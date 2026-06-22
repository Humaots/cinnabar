package com.socraticai.companion.model;

import java.util.Map;

public record ColdStartAssessmentCompletedEvent(
        String eventId,
        String userId,
        Map<String, Double> initialMastery,
        long occurredAtEpochMs
) {
}
