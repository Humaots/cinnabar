package com.socraticai.companion.model;

import java.util.List;

public record AgentOrchestrationResult(
        String sessionId,
        String selectedAgent,
        List<String> planSteps,
        String nextAction
) {
}
