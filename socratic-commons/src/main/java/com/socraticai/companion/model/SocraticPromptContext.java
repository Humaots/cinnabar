package com.socraticai.companion.model;

import java.util.List;
import java.util.Map;

public record SocraticPromptContext(
        String sessionId,
        String userId,
        String question,
        List<ConversationTurn> history,
        List<KnowledgeChunk> retrievedContext,
        Map<String, Object> profile,
        Map<String, Object> constraints
) {
}
