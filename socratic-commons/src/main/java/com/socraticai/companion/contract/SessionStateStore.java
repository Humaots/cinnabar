package com.socraticai.companion.contract;

import com.socraticai.companion.model.SessionState;

import java.time.Duration;
import java.util.Optional;

public interface SessionStateStore {
    Optional<SessionState> find(String sessionId);

    void save(SessionState state, Duration ttl);

    void delete(String sessionId);
}
