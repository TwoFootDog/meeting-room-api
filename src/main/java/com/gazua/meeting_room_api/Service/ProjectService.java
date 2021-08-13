package com.gazua.meeting_room_api.Service;

import com.gazua.meeting_room_api.Dto.Common.ResDto;
import com.gazua.meeting_room_api.Dto.Common.ResListDto;
import com.gazua.meeting_room_api.Dto.ProjectDto;

public interface ProjectService {
    public ResDto<ProjectDto.CUDResponse> createProject(ProjectDto.CRequest req);
    public ResDto<ProjectDto.CUDResponse> updateProject(int projId, ProjectDto.URequest req);
    public ResDto<ProjectDto.RResponse> selectProjectByPk(int projId);
    public ResListDto<ProjectDto.RResponse> selectProjectByUserId(int userId);
    public ResDto<ProjectDto.CUDResponse> createProjectUserMapp(int projId, int userId, ProjectDto.UserCRequest req);
}
