package com.gazua.meeting_room_api.Model.Common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResDto {
    int dataCnt;        // 응답 건수
    boolean isSuccess;  // 성공여부
    String Code;     // 응답 코드
    String Msg;      // 응답 메시지
}
