package com.socraticai.companion.contract;

import com.socraticai.companion.model.KnowledgeChunk;
import com.socraticai.companion.model.KnowledgeQuery;

import java.util.List;

/**
 * 知识检索端口。
 *
 * 所有 RAG、语义召回和知识点过滤都通过这个契约暴露，避免业务层直接依赖
 * 具体向量库实现。
 */
public interface KnowledgeRetriever {
    List<KnowledgeChunk> retrieve(KnowledgeQuery query);
}
