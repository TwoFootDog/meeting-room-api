package com.gazua.meeting_room_api.Service.impl;

import com.gazua.meeting_room_api.Controller.ProjectController;
import com.gazua.meeting_room_api.Dto.Common.ResDto;
import com.gazua.meeting_room_api.Dto.Project.CreateProjectReqDto;
import com.gazua.meeting_room_api.Dto.Project.CreateProjectResDto;
import com.gazua.meeting_room_api.Exception.ServiceException;
import com.gazua.meeting_room_api.Mapper.ProjectMapper;
import com.gazua.meeting_room_api.Service.Common.MessageService;
import com.gazua.meeting_room_api.Service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private static final Logger logger = LogManager.getLogger(ProjectController.class); // 로깅 객체
    private final MessageService messageService;    // 공통 메시지 처리를 위한 서비스
    private final ProjectMapper projectMapper;

    @Override
    public ResDto<CreateProjectResDto> createProject(CreateProjectReqDto req) {

        ResDto<CreateProjectResDto> result = new ResDto<>();
        CreateProjectResDto resDto = new CreateProjectResDto();

        /* T_PROJ_INFO_MAST 데이터 생성 */
        Map<String, Object> reqMap = new HashMap<>();   // 쿼리 수행을 위한 맵 생성
        reqMap.put("projNm", req.getProjNm());
        reqMap.put("projComment", req.getProjComment());
        try {
            int dbResult = projectMapper.createProject(reqMap); // 프로젝트 생성(성공 1, 실패0)
            if (dbResult == 1) {    // 성공 시
                Map<String, Object> projMap = projectMapper.selectProjectByPk((int)reqMap.get("projId"));   // 생성한 프로젝트 정보 조회
                if (projMap!=null && !projMap.isEmpty()) {
                    resDto.setProjId((int) projMap.get("projId"));
                    resDto.setProjNm((String) projMap.get("projNm"));
                    resDto.setProjPasswd((String) projMap.get("projPasswd"));
                    resDto.setProjComment((String) projMap.get("projComment"));
                    resDto.setUserId(req.getUserId());
                } else {
                    throw new ServiceException(false, "unKnownError", "projectMapper.selectProjectByPk 수행 결과 미존재");
                }
            } else {
                throw new ServiceException(false, "unKnownError", "projectMapper.createProject 수행 결과 미존재");
            }
        } catch (Exception e) {
            throw new ServiceException(false, "unKnownError", "projectMapper.createProject 수행 시 예외 발생", e);
        }

        /* T_USER_PROJ_MAPP 데이터 생성 */
        reqMap.clear();     // 맵 초기화
        reqMap.put("userId", req.getUserId());
        reqMap.put("projNickname", req.getProjNickname());
        reqMap.put("projId", resDto.getProjId());
        try {
            int dbResult2 = projectMapper.createUserProjectMapping(reqMap);
            if (dbResult2 !=1) {
                throw new ServiceException(false, "unKnownError", "projectMapper.createUserProjectMapping 수행 결과 미존재");
            }
        } catch (Exception e) {
            throw new ServiceException(false, "unKnownError", "projectMapper.createUserProjectMapping 수행 시 예외 발생", e);
        }

        result.setData(resDto); // 응답메시지 data 부분 셋팅
        messageService.setSuccessMessage(result);   // 응답메시지 공통부분 셋팅(isSuccess, code, msg)

        return result;
    }
}
