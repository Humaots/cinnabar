package com.socraticai.companion.model;

import java.util.Map;

public record LearningPathRequest(
        String userId,
        Map<String, Double> masterySnapshot,
        String goal
) {
}
