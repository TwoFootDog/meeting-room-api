package com.gazua.meeting_room_api.Dto.Project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProjectResDto {
    int projId;          // 프로젝트ID
    String projNm;          // 프로젝트 명
    String projComment;     // 프로젝트 설명
    String projPasswd;      //프로젝트비밀번호
    int userId;          // 사용자ID(프로젝트생성자)
}
