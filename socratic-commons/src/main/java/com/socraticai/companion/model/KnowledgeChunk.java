package com.socraticai.companion.model;

import java.util.Map;

public record KnowledgeChunk(
        String chunkId,
        String title,
        String content,
        double score,
        Map<String, Object> metadata
) {
}
