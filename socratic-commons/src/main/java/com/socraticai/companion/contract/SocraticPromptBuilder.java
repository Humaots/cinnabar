package com.socraticai.companion.contract;

import com.socraticai.companion.model.SocraticPromptContext;

public interface SocraticPromptBuilder {
    String build(SocraticPromptContext context);
}
