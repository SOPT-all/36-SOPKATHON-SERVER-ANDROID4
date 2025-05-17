package org.sopt.domain.bookmark.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.domain.bookmark.dto.request.BookmarkRequest;
import org.sopt.domain.bookmark.service.BookmarkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkContoller {

    private final BookmarkService bookmarkService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody BookmarkRequest request) {
        bookmarkService.create(request.userId(), request.courseId());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody BookmarkRequest request) {
        bookmarkService.delete(request.userId(), request.courseId());
        return ResponseEntity.noContent().build();
    }

}