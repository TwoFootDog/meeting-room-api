package com.gazua.meeting_room_api.Model.Project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProjectReqDto {
    String userNo;          // 사용자번호(프로젝트생성자)
    String projNm;     // 프로젝트 명
    String projComment;  // 프로젝트 설명
}
