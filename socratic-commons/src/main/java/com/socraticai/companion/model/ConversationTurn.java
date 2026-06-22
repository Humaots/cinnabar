package com.socraticai.companion.model;

public record ConversationTurn(
        String role,
        String content,
        long occurredAtEpochMs
) {
}
