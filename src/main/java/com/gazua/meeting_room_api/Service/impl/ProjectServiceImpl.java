package com.gazua.meeting_room_api.Service.impl;

import com.gazua.meeting_room_api.Mapper.ProjectMapper;
import com.gazua.meeting_room_api.Model.Common.ResDto;
import com.gazua.meeting_room_api.Model.Project.CreateProjectReqDto;
import com.gazua.meeting_room_api.Model.Project.CreateProjectResDto;
import com.gazua.meeting_room_api.Service.Common.MessageService;
import com.gazua.meeting_room_api.Service.ProjectService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final MessageService messageService;    // 공통 메시지 처리를 위한 서비스
    private final ProjectMapper projectMapper;

    @Override
    public ResDto<CreateProjectResDto> createProject(CreateProjectReqDto req) {

        CreateProjectResDto resDto = new CreateProjectResDto();
        List<CreateProjectResDto> resDtoList = new ArrayList<>();
        ResDto<CreateProjectResDto> result = new ResDto<>();

        messageService.setSuccessMessage(result);
        result.setDataCnt(1);
        result.setData(resDtoList);

        return result;
    }

}
