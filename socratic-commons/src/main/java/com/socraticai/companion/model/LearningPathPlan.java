package com.socraticai.companion.model;

import java.util.List;

public record LearningPathPlan(
        String userId,
        String currentWeakness,
        List<LearningPathStep> steps
) {
}
