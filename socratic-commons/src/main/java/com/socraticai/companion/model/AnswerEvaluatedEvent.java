package com.socraticai.companion.model;

public record AnswerEvaluatedEvent(
        String eventId,
        String sessionId,
        String userId,
        String questionId,
        boolean correct,
        double confidence,
        long occurredAtEpochMs
) {
}
