package com.gazua.meeting_room_api.Mapper;

import com.gazua.meeting_room_api.Model.Project.CreateProjectReqDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProjectMapper {
    public String createProject(CreateProjectReqDto req);
}
