package com.gazua.meeting_room_api.Service.impl;

import com.gazua.meeting_room_api.Controller.ProjectController;
import com.gazua.meeting_room_api.Dto.Common.ResDto;
import com.gazua.meeting_room_api.Dto.Common.ResListDto;
import com.gazua.meeting_room_api.Dto.ProjectDto;
import com.gazua.meeting_room_api.Exception.ServiceException;
import com.gazua.meeting_room_api.Mapper.ProjectMapper;
import com.gazua.meeting_room_api.Service.Common.MessageService;
import com.gazua.meeting_room_api.Service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private static final Logger logger = LogManager.getLogger(ProjectController.class); // 로깅 객체
    private final MessageService messageService;    // 공통 메시지 처리를 위한 서비스
    private final ProjectMapper projectMapper;

    /* T_PROJ_INFO_MAST와 T_USER_PROJ_MAPP 을 생성해주는 함수 */
    @Override
    @Transactional
    public ResDto<ProjectDto.CUDResponse> createProject(ProjectDto.CRequest req) {

        ResDto<ProjectDto.CUDResponse> result = new ResDto<>();    // 최종 결과값
        ProjectDto.CUDResponse data = new ProjectDto.CUDResponse();   // 최종 결과값 내 data 부분

        /* T_PROJ_INFO_MAST 데이터 생성 */
        Map<String, Object> reqMap = new HashMap<>();   // 쿼리 수행을 위한 맵 생성
        reqMap.put("projNm", req.getProjNm());
        reqMap.put("projComment", req.getProjComment());
        int dbResult = 0;
        try {
            dbResult = projectMapper.createProject(reqMap); // 프로젝트 생성(성공 1, 실패0)
        } catch (Exception e) {
            throw new ServiceException(false, "unKnownError", "projectMapper.createProject 수행 시 예외 발생", e);
        }
        if (dbResult == 1) {    // 성공 시
            data.setProjId((int)reqMap.get("projId"));
        } else {                // 실패 시
            throw new ServiceException(false, "unKnownError", "projectMapper.createProject 수행 결과 미존재");
        }


        /* T_USER_PROJ_MAPP 데이터 생성 */
        reqMap.clear();     // 맵 초기화
        reqMap.put("userId", req.getUserId());
        reqMap.put("projNickname", req.getProjNickname());
        reqMap.put("projId", data.getProjId());
        dbResult = 0;
        try {
            dbResult = projectMapper.createUserProjectMapping(reqMap);
        } catch (Exception e) {
            throw new ServiceException(false, "unKnownError", "projectMapper.createUserProjectMapping 수행 시 예외 발생", e);
        }
        if (dbResult != 1) {    // 실패 시
            throw new ServiceException(false, "unKnownError", "projectMapper.createUserProjectMapping 수행 결과 미존재");
        }

        result.setData(data); // 응답메시지 data 부분 셋팅
        messageService.setSuccessMessage(result);   // 응답메시지 공통부분 셋팅(isSuccess, code, msg)

        return result;
    }

    /* projId로 T_PROJ_INFO_MAST 값을 변경하는 함수 */
    @Override
    @Transactional
    public ResDto<ProjectDto.CUDResponse> updateProject(int projId, ProjectDto.URequest req) {
        ResDto<ProjectDto.CUDResponse> result = new ResDto<>();
        ProjectDto.CUDResponse data = new ProjectDto.CUDResponse();

        Map<String, Object> reqMap = new HashMap<>();
        reqMap.put("projId", projId);
        reqMap.put("projComment", req.getProjComment());
        reqMap.put("removeDt", req.getRemoveDt());
        if (req.getProjNm()!=null && !req.getProjNm().isEmpty()) {
            reqMap.put("projNm", req.getProjNm().trim());   // 프로젝트명은 공백이 들어가면 안되므로 trim 처리
        }

        int dbResult = 0;
        try {
            dbResult = projectMapper.updateProject(reqMap);
        } catch (Exception e) {
            throw new ServiceException(false, "", "projectMapper.updateProject 수행 시 예외 발생", e);
        }
        if (dbResult == 1) {
            data.setProjId(projId);
        } else {
            throw new ServiceException(false, "", "projectMapper.updateProject 수행 결과 미존재");
        }

        result.setData(data);                   // 응답메시지 data 부분 셋팅
        messageService.setSuccessMessage(result);// 응답메시지 공통부분 셋팅(isSuccess, code, msg)
        return result;
    }

    /* projId로 T_PROJ_INFO_MAST & T_USER_PROJ_MAPP 정보를 조회하는 함수 */
    @Override
    @Transactional(readOnly = true)
    public ResDto<ProjectDto.RResponse> selectProjectByPk(int projId) {
        ResDto<ProjectDto.RResponse> result = new ResDto<>();   // 최종 결과값
        ProjectDto.RResponse data = new ProjectDto.RResponse();     // 최종 결과값 내 data 부분
        Map<String, Object> resMap;
        try {
            resMap = projectMapper.selectProjectByPk(projId);

        } catch (Exception e) {
            throw new ServiceException(false, "unKnownError", "projectMapper.selectProjectByPk 수행 시 예외 발생", e);
        }
        if (resMap != null  && !resMap.isEmpty()) {
            data.setProjId((int)resMap.get("projId"));
            data.setProjNm((String)resMap.get("projNm"));
            data.setProjPasswd((String)resMap.get("projPassWd"));
            data.setProjComment((String)resMap.get("projComment"));
            data.setRemoveDt((Date)resMap.get("removeDt"));
            data.setProjNickname((String)resMap.get("projNickname"));
            data.setRegId((String)resMap.get("regId"));
            data.setRegDt((Date)resMap.get("regDt"));
            data.setUpdId((String)resMap.get("updId"));
            data.setUpdDt((Date)resMap.get("updDt"));
        } else {
            logger.info("1");
            throw new ServiceException(false, "dataNotFoundError1", "projectMapper.selectProjectByPk 수행 결과 없음");
        }

        result.setData(data);       // 응답메시지 data 부분 셋팅
        messageService.setSuccessMessage(result);   // 응답메시지 공통부분 셋팅(isSuccess, code, msg)
        return result;
    }

    /* userId로 T_PROJ_INFO_MAST & T_USER_PROJ_MAPP 정보를 조회하는 함수 */
    @Override
    public ResListDto<ProjectDto.RResponse> selectProjectByUserId(int userId) {
        ResListDto<ProjectDto.RResponse> result = new ResListDto<>();
        List<ProjectDto.RResponse> data = new ArrayList<>();

        try {
            data = projectMapper.selectProjectByUserId(userId);
        } catch (Exception e) {
            throw new ServiceException(false, "unKnownError", "projectMapper.selectProjectByUserId 수행 시 예외 발생", e);
        }

        result.setDataCnt(data.size()); // list 데이터 건수
        result.setData(data);
        messageService.setSuccessMessage(result);
        return result;
    }

    @Override
    public ResDto<ProjectDto.CUDResponse> createProjectUserMapp(int projId, int userId, ProjectDto.UserCRequest req) {
        return null;
    }
}
