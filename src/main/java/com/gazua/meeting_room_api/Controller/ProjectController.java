package com.gazua.meeting_room_api.Controller;

import com.gazua.meeting_room_api.Dto.Common.ResDto;
import com.gazua.meeting_room_api.Dto.Common.ResListDto;
import com.gazua.meeting_room_api.Dto.ProjectDto;
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
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;    // 프로젝트 서비스
    private static final Logger logger = LogManager.getLogger(ProjectController.class); // 로깅 객체

    /* 프로젝트를 생성하는 API */
    @ApiOperation(  // swagger 작성
            value = "프로젝트생성",
            httpMethod = "POST",
            notes = "프로젝트를 신규 생성하는 API"
    )
    @PostMapping
    public ResponseEntity<ResDto<ProjectDto.CUDResponse>> createProject(@RequestBody @Valid ProjectDto.CRequest req,
                                                                        HttpServletRequest httpReq) {
        ResDto<ProjectDto.CUDResponse> result = projectService.createProject(req);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /* 프로젝트의 정보를 수정하는 API */
    @PutMapping(value = "/{projId}")
    public ResponseEntity<ResDto<ProjectDto.CUDResponse>> updateProject(@PathVariable int projId,
                                                   @RequestBody @Valid ProjectDto.URequest req,
                                                   HttpServletRequest httpReq) {
        ResDto<ProjectDto.CUDResponse> result = projectService.updateProject(projId, req);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /* 프로젝트ID로 프로젝트를 조회하는 API */
    @GetMapping(value = "/{projId}")
    public ResponseEntity<ResDto<ProjectDto.RResponse>> selectProjectByPk(@PathVariable int projId) {
        ResDto<ProjectDto.RResponse> result = projectService.selectProjectByPk(projId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /* 회원이 소속되어 있는 프로젝트의 정보를 조회하는 API */
    @GetMapping(value = "/users/{userId}")
    public ResponseEntity<ResListDto<ProjectDto.RResponse>> selectProjectByUserId(@PathVariable int userId) {
        ResListDto<ProjectDto.RResponse> result = projectService.selectProjectByUserId(userId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /* 사용자가 프로젝트에 참여하는 API */
    @PostMapping("/{projId}/users/{userId}")
    public ResponseEntity<ResDto<ProjectDto.CUDResponse>> createProjectUserMapp(@PathVariable int projId,
                                                                                @PathVariable int userId,
                                                                                @RequestBody ProjectDto.UserCRequest req) {
        ResDto<ProjectDto.CUDResponse> result = projectService.createProjectUserMapp(projId, userId, req);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }



}
