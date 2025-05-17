package org.sopt.domain.spot.dto;

import org.sopt.domain.spot.domain.Spot;

import java.util.ArrayList;
import java.util.List;

public record SpotDto(
        String spotName,
        String address,
        String description,
        List<String> imageUrls
) {
    public static SpotDto from(Spot spot) {
        return new SpotDto(
                spot.getSpotName(),
                spot.getAddress(),
                spot.getDescription(),
                new ArrayList<>(spot.getImageUrls()) // ← 여기서 미리 초기화해야 LAZY 문제 없음
        );
    }
}
