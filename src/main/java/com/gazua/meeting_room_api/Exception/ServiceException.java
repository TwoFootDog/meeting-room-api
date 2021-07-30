package com.gazua.meeting_room_api.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceException extends RuntimeException {
    private boolean isSuccess;    // 응답 성공여부(true/false)
    private String code;           // 응답 코드 번호 (>= 0 : 정상, < 0 비정상)
//    private String msg;         // 응답 메시지
    private Exception e;

    public ServiceException(boolean isSuccess, String code) {
        this.isSuccess = isSuccess;
        this.code = code;
    }
}
