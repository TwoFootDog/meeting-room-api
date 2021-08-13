package com.gazua.meeting_room_api.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;


public class ProjectDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CRequest {  // 프로젝트 생성 요청 전문
        int userId;          // 사용자번호(프로젝트생성자)
        @NotBlank(message = "requiredValueNotEntered1") // 미 입력 시 resultCode.yml의 requiredValueNotEntered1 결과 셋팅
        String projNm;          // 프로젝트 명
        String projComment;     // 프로젝트 설명
        @NotBlank(message = "requiredValueNotEntered2")
        String projNickname;    // 프로젝트 생성자(닉네임)
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class URequest {  // 프로젝트 수정 요청 전문
        String projNm;          // 프로젝트 명
        String projComment;     // 프로젝트 설명
        String removeDt;        // 프로젝트 탈퇴일자
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserCRequest {  // 프로젝트-사용자 매핑정보 생성 요청 전문
        String projNm;          // 프로젝트 명
        String projComment;     // 프로젝트 설명
        String removeDt;        // 프로젝트 탈퇴일자
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CUDResponse {   // 프로젝트 생성, 수정, 삭제 응답 전문
        int projId;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RResponse {     // 프로젝트 조회 응답 전문
        int projId;          // 프로젝트ID
        String projNm;          // 프로젝트 명
        String projComment;     // 프로젝트 설명
        String projPasswd;      //프로젝트비밀번호
        String projNickname;    // 프로젝트 생성자(닉네임)
        Date removeDt;          // 프로젝트 삭제일자

        String regId;           // 등록자
        Date regDt;             // 등록일시
        String updId;           // 수정자
        Date updDt;             // 수정일시
    }

}
