package com.socraticai.companion.model;

public record LearningPathStep(
        String knowledgePointId,
        String title,
        String reason,
        int priority
) {
}
