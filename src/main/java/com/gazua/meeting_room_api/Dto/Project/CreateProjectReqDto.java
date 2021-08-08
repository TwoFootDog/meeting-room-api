package com.gazua.meeting_room_api.Dto.Project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProjectReqDto {
    int userId;          // 사용자번호(프로젝트생성자)
    @NotBlank(message = "projectName")
    String projNm;          // 프로젝트 명
    String projComment;     // 프로젝트 설명
    @NotBlank(message = "projectNickName")
    String projNickname;    // 프로젝트 생성자(닉네임)
}
