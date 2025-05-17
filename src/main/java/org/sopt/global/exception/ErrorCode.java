package org.sopt.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    //common
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"서버 에러가 발생했습니다"),
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "입력값이 올바르지 않습니다."),
    NOT_FOUND_RESOURCE_EXCEPTION(HttpStatus.NOT_FOUND, "존재하지 않는 데이터입니다."),
    DUPLICATED_RESOURCE_EXCEPTION(HttpStatus.CONFLICT, "이미 존재하는 데이터입니다."),
    PARSE_JSON_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "JSON 파싱 에러가 발생했습니다."),
    NOT_FOUND_HANDLER_EXCEPTION(HttpStatus.NOT_FOUND, "지원하지 않는 Api 요청 입니다."),
    NOT_FOUND_USER_EXCEPTION(HttpStatus.NOT_FOUND, "존재하지 않는 사용자입니다."),
    INVALID_ACCESS_EXCEPTION(HttpStatus.FORBIDDEN, "잘못된 접근입니다."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "지원하지 않는 HTTP 메소드입니다."),
    INVALID_ID(HttpStatus.BAD_REQUEST,"아이디가 올바르지 않습니다."),

    //bookmark
    ALREADY_BOOKMARKED(HttpStatus.CONFLICT, "이미 북마크된 코스입니다."),
    BOOKMARK_NOT_FOUND(HttpStatus.NOT_FOUND, "북마크되어 있지 않던 코스입니다." ),

    //course
    COURSE_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 코스는 존재하지 않습니다." );



    private final HttpStatus httpStatus;
    private final String message;

}
