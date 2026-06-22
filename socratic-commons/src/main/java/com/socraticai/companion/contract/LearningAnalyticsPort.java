package com.socraticai.companion.contract;

import com.socraticai.companion.model.AnswerEvaluatedEvent;
import com.socraticai.companion.model.ColdStartAssessmentCompletedEvent;

/**
 * 学习分析端口。
 *
 * 负责承接答题结果和冷启动测评，不让分析逻辑散落在编排层和执行层。
 */
public interface LearningAnalyticsPort {
    void recordAnswerEvaluated(AnswerEvaluatedEvent event);

    void recordColdStartAssessment(ColdStartAssessmentCompletedEvent event);
}
