package com.gazua.meeting_room_api.Dto.Project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProjectResDto {
    int projId;                   // 프로젝트id
    String projNm;                 // 프로젝트명
    String projComment;              // 프로젝트 설명
    int userId;                   // 사용자ID(프로젝트생성자)
}
