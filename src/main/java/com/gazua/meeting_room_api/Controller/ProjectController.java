package com.gazua.meeting_room_api.Controller;

import com.gazua.meeting_room_api.Model.Common.ResDto;
import com.gazua.meeting_room_api.Model.Project.CreateProjectReqDto;
import com.gazua.meeting_room_api.Model.Project.CreateProjectResDto;
import com.gazua.meeting_room_api.Service.Common.MessageService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@AllArgsConstructor
@RestController
@RequestMapping("/project")
public class ProjectController {

    private final MessageService messageService;    // 공통 메시지 처리를 위한 서비스
    private static final Logger logger = LogManager.getLogger(ProjectController.class); // 로깅 객체

    @ApiOperation(  // swagger 작성
            value = "프로젝트생성",
            httpMethod = "POST",
            notes = "프로젝트를 신규 생성하는 API"
    )
    public ResponseEntity<ResDto<CreateProjectResDto>> createProject(@RequestBody CreateProjectReqDto req,
                                                                     HttpServletRequest httpReq) {
        logger.info("info : Hello world");
        ResDto<CreateProjectResDto> result = new ResDto<>();
        messageService.setSuccessMessage(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/{projectId}")
    public ResponseEntity<ResDto<ProjectResDto>>

/*    @GetMapping
    public ListResDto<CreateProjectResDto> getProjectList(@RequestBody CreateProjectReqDto req, HttpServletRequest httpReq, HttpServletResponse httpRes) {
        ListResDto<GetProjectListDto> res = new ListResDto<>();
    }*/
}
