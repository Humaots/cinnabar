package com.socraticai.companion.model;

import java.util.Map;

public record KnowledgeQuery(
        String userId,
        String sessionId,
        String question,
        Map<String, Object> filters
) {
}
