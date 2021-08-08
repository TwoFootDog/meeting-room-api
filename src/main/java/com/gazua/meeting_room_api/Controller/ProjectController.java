package com.gazua.meeting_room_api.Controller;

import com.gazua.meeting_room_api.Dto.Common.ResDto;
import com.gazua.meeting_room_api.Dto.Project.CreateProjectReqDto;
import com.gazua.meeting_room_api.Dto.Project.CreateProjectResDto;
import com.gazua.meeting_room_api.Dto.Project.GetProjectResDto;
import com.gazua.meeting_room_api.Service.ProjectService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;    // 프로젝트 서비스
    private static final Logger logger = LogManager.getLogger(ProjectController.class); // 로깅 객체

    @ApiOperation(  // swagger 작성
            value = "프로젝트생성",
            httpMethod = "POST",
            notes = "프로젝트를 신규 생성하는 API"
    )
    @PostMapping
    public ResponseEntity<ResDto<CreateProjectResDto>> createProject(@RequestBody @Valid CreateProjectReqDto req,
                                                                     HttpServletRequest httpReq) {
        logger.info("info : Hello world");
//        ResDto<CreateProjectResDto> result = new ResDto<>();
        ResDto<CreateProjectResDto> result = projectService.createProject(req);
        logger.info("info : result" + result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/{projectId}")
    public ResponseEntity<ResDto<GetProjectResDto>> getPRoject(@PathVariable String projectNo) {
        return new ResponseEntity<>(new ResDto<GetProjectResDto>(), HttpStatus.OK);
    }
}
