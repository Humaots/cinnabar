package com.socraticai.companion.contract;

import com.socraticai.companion.model.SessionState;

import java.time.Duration;
import java.util.Optional;

/**
 * 会话态存储端口。
 *
 * 短期对话上下文应集中在这里管理，避免 Executor 自己维护“权威状态”。
 */
public interface SessionStateStore {
    Optional<SessionState> find(String sessionId);

    void save(SessionState state, Duration ttl);

    void delete(String sessionId);
}
