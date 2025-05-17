package org.sopt.domain.spot.dto;

import java.util.ArrayList;
import java.util.List;
import org.sopt.domain.spot.domain.Spot;

public record SpotDto(
        String spotName,
        String address,
        List<String> imageUrls
) {
    public static SpotDto from(Spot spot) {
        return new SpotDto(
                spot.getSpotName(),
                spot.getAddress(),
                new ArrayList<>(spot.getImageUrls()) // ← 여기서 미리 초기화해야 LAZY 문제 없음
        );
    }
}