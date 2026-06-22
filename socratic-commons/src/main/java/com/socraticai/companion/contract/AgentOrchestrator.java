package com.socraticai.companion.contract;

import com.socraticai.companion.model.AgentOrchestrationRequest;
import com.socraticai.companion.model.AgentOrchestrationResult;

/**
 * 调度层契约。
 *
 * 这个接口只描述“谁来编排哪些 Agent”，不关心底层是本地方法调用、
 * HTTP 还是 MQ。这样后续从 3 服务扩展到 6+ 时，调用方式可以演进，
 * 但领域边界不需要重写。
 */
public interface AgentOrchestrator {
    AgentOrchestrationResult orchestrate(AgentOrchestrationRequest request);
}
