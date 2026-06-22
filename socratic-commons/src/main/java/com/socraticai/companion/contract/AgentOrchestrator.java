package com.socraticai.companion.contract;

import com.socraticai.companion.model.AgentOrchestrationRequest;
import com.socraticai.companion.model.AgentOrchestrationResult;

public interface AgentOrchestrator {
    AgentOrchestrationResult orchestrate(AgentOrchestrationRequest request);
}
