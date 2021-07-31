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
    String projNo;                   // 프로젝트id
    String projNm;                 // 프로젝트명
    String projComment;              // 프로젝트 설명
    String userNo;                   // 사용자번호(프로젝트생성자)
}
