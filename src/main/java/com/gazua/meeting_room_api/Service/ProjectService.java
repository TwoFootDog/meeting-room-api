package com.gazua.meeting_room_api.Service;

import com.gazua.meeting_room_api.Dto.Common.ResDto;
import com.gazua.meeting_room_api.Dto.Project.CreateProjectReqDto;
import com.gazua.meeting_room_api.Dto.Project.CreateProjectResDto;

public interface ProjectService {
    public ResDto<CreateProjectResDto> createProject(CreateProjectReqDto req);
}
