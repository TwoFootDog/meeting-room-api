package com.gazua.meeting_room_api.Dto.Common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResListDto<E> {
    int dataCnt;        // 응답 건수
    List<E> data;       // 응답 데이터
    boolean isSuccess;  // 성공여부
    String code;     // 응답 코드
    String msg;      // 응답 메시지

}