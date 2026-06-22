package com.socraticai.companion.contract;

import com.socraticai.companion.model.LearningPathPlan;
import com.socraticai.companion.model.LearningPathRequest;

/**
 * 学习路径规划端口。
 *
 * 由知识图谱和掌握度快照驱动，用来输出下一步学什么。
 */
public interface LearningPathPlanner {
    LearningPathPlan plan(LearningPathRequest request);
}
