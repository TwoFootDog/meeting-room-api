package com.gazua.meeting_room_api.Service.impl;

import com.gazua.meeting_room_api.Mapper.ProjectMapper;
import com.gazua.meeting_room_api.Model.Common.ResDto;
import com.gazua.meeting_room_api.Model.Project.CreateProjectReqDto;
import com.gazua.meeting_room_api.Model.Project.CreateProjectResDto;
import com.gazua.meeting_room_api.Service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectMapper projectMapper;

    @Override
    public CreateProjectResDto createProject(CreateProjectReqDto req) {

//        String result = projectMapper.createProject(req);
        CreateProjectResDto res = new CreateProjectResDto();
        return res;
    }

}
