package com.gazua.meeting_room_api.Exception;

import com.gazua.meeting_room_api.Controller.ProjectController;
import com.gazua.meeting_room_api.Model.Common.ExceptionResDto;
import com.gazua.meeting_room_api.Service.Common.MessageService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/* Exception을 공통적으로 처리해주는 Handler. 특정 Exception을 발생시키면 수행 */
@RequiredArgsConstructor
@RestControllerAdvice
public class  GlobalExceptionHandler {

    private final MessageService messageService;    // 공통 메시지 처리를 위한 서비스
    private static final Logger logger = LogManager.getLogger(ProjectController.class); // 로깅 객체

    @ExceptionHandler(value = ServiceException.class)   // ServiceException 발생 시 수행
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private ExceptionResDto handleServiceException(ServiceException e) {
        ExceptionResDto exceptionRes = new ExceptionResDto();
        messageService.setExceptionMessage(exceptionRes, e.getCode());
        logger.error("@@@Error Code : " + exceptionRes.getCode() + ", Error Message : " + exceptionRes.getMsg());

        return exceptionRes;
    }

}
