// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            DataLayerEventEvaluationInfoBuilder, DebugResolvedFunctionCallBuilder, DebugRuleEvaluationStepInfoBuilder, ResolvedFunctionCallBuilder, 
//            RuleEvaluationStepInfoBuilder

class DebugDataLayerEventEvaluationInfoBuilder
    implements DataLayerEventEvaluationInfoBuilder
{

    private com.google.analytics.containertag.proto.MutableDebug.DataLayerEventEvaluationInfo dataLayerEvent;

    public DebugDataLayerEventEvaluationInfoBuilder(com.google.analytics.containertag.proto.MutableDebug.DataLayerEventEvaluationInfo datalayereventevaluationinfo)
    {
        dataLayerEvent = datalayereventevaluationinfo;
    }

    public ResolvedFunctionCallBuilder createAndAddResult()
    {
        return new DebugResolvedFunctionCallBuilder(dataLayerEvent.addResults());
    }

    public RuleEvaluationStepInfoBuilder createRulesEvaluation()
    {
        return new DebugRuleEvaluationStepInfoBuilder(dataLayerEvent.getMutableRulesEvaluation());
    }
}
