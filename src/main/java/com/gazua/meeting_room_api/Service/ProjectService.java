package com.gazua.meeting_room_api.Service;

import com.gazua.meeting_room_api.Model.Common.ResDto;
import com.gazua.meeting_room_api.Model.Project.CreateProjectReqDto;
import com.gazua.meeting_room_api.Model.Project.CreateProjectResDto;

public interface ProjectService {
    public CreateProjectResDto createProject(CreateProjectReqDto req);
}
