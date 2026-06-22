package com.socraticai.companion.contract;

import com.socraticai.companion.model.AnswerEvaluatedEvent;
import com.socraticai.companion.model.ColdStartAssessmentCompletedEvent;

public interface LearningAnalyticsPort {
    void recordAnswerEvaluated(AnswerEvaluatedEvent event);

    void recordColdStartAssessment(ColdStartAssessmentCompletedEvent event);
}
