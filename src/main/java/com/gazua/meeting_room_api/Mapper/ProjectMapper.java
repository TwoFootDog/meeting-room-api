package com.gazua.meeting_room_api.Mapper;

import com.gazua.meeting_room_api.Dto.ProjectDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ProjectMapper {
    int createProject(Map<String, Object> req);             // 프로젝트 생성
    int createUserProjectMapping(Map<String, Object> req);  // 유저 프로젝트 매핑 생성
    int updateProject(Map<String, Object> req);             // 프로젝트 수정
    Map<String, Object> selectProjectByPk(int projId);      // PK로 프로젝트 조회
    List<ProjectDto.RResponse> selectProjectByUserId(int userId); // userId로 프로젝트 조회
}
