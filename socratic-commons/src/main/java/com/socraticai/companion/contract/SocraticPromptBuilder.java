package com.socraticai.companion.contract;

import com.socraticai.companion.model.SocraticPromptContext;

/**
 * 苏格拉底式提示词构造器。
 *
 * 用于把会话态、知识召回结果和约束条件拼装成可交给模型执行的 prompt。
 */
public interface SocraticPromptBuilder {
    String build(SocraticPromptContext context);
}
