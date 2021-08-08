package com.gazua.meeting_room_api.Mapper;

import com.gazua.meeting_room_api.Dto.Project.CreateProjectReqDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface ProjectMapper {
    int createProject(Map<String, Object> req);             // 프로젝트 생성
    int createUserProjectMapping(Map<String, Object> req);  // 유저 프로젝트 매핑 생성
    Map<String, Object> selectProjectByPk(int projId);      // PK로 프로젝트 조회

}
