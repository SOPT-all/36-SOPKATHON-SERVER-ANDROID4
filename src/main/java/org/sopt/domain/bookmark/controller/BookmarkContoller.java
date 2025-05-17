package org.sopt.domain.bookmark.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.domain.bookmark.dto.request.CreateBookmarkRequest;
import org.sopt.domain.bookmark.service.BookmarkService;
import org.sopt.global.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkContoller {

    private final BookmarkService bookmarkService;

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> create(
            @RequestHeader("userId") Long userId,
            @RequestBody CreateBookmarkRequest request
    ) {
        bookmarkService.create(userId, request.courseId());
        return ResponseEntity.ok(
                ApiResponse.ok(null)
        );
    }

    @DeleteMapping("courses/{courseId}")
    public ResponseEntity<ApiResponse<Void>> delete(
            @RequestHeader("userId") Long userId,
            @PathVariable("courseId") Long courseId
    ) {
        bookmarkService.delete(userId, courseId);
        return ResponseEntity.ok(ApiResponse.ok(null));
    }

}