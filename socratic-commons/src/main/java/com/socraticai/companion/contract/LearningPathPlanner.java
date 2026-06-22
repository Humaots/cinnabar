package com.socraticai.companion.contract;

import com.socraticai.companion.model.LearningPathRequest;
import com.socraticai.companion.model.LearningPathPlan;

public interface LearningPathPlanner {
    LearningPathPlan plan(LearningPathRequest request);
}
