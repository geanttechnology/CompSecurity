// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            DataLayerEventEvaluationInfoBuilder, NoopResolvedFunctionCallBuilder, NoopRuleEvaluationStepInfoBuilder, ResolvedFunctionCallBuilder, 
//            RuleEvaluationStepInfoBuilder

class NoopDataLayerEventEvaluationInfoBuilder
    implements DataLayerEventEvaluationInfoBuilder
{

    NoopDataLayerEventEvaluationInfoBuilder()
    {
    }

    public ResolvedFunctionCallBuilder createAndAddResult()
    {
        return new NoopResolvedFunctionCallBuilder();
    }

    public RuleEvaluationStepInfoBuilder createRulesEvaluation()
    {
        return new NoopRuleEvaluationStepInfoBuilder();
    }
}
