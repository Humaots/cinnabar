package com.socraticai.companion.model;

import java.util.List;
import java.util.Map;

public record SessionState(
        String sessionId,
        String userId,
        String currentMode,
        List<ConversationTurn> recentTurns,
        Map<String, Object> attributes,
        long updatedAtEpochMs
) {
}
