package com.socraticai.companion.contract;

import com.socraticai.companion.model.KnowledgeQuery;
import com.socraticai.companion.model.KnowledgeChunk;

import java.util.List;

public interface KnowledgeRetriever {
    List<KnowledgeChunk> retrieve(KnowledgeQuery query);
}
