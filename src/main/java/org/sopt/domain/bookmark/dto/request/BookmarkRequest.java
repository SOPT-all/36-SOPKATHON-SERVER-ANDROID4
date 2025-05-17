package org.sopt.domain.bookmark.dto.request;

public record BookmarkRequest(
        Long userId,
        Long courseId
) {}