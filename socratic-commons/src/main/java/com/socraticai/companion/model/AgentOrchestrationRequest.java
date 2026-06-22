package com.socraticai.companion.model;

import java.util.List;
import java.util.Map;

public record AgentOrchestrationRequest(
        String sessionId,
        String userId,
        String objective,
        List<ConversationTurn> history,
        Map<String, Object> attributes
) {
}
