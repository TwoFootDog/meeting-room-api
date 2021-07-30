package com.gazua.meeting_room_api.Model.Project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProjectResDto {
    String projectId;                   // 프로젝트id
    String projectName;                 // 프로젝트명
    String projectContents;             // 프로젝트 설명
    String userNo;                      // 사용자번호(프로젝트생성자)
    List<Map<String, Object>> detail;   // 프로젝트 상세
}
