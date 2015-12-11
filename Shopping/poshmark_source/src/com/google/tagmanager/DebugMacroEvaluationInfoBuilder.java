// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            MacroEvaluationInfoBuilder, DebugResolvedFunctionCallBuilder, DebugRuleEvaluationStepInfoBuilder, ResolvedFunctionCallBuilder, 
//            RuleEvaluationStepInfoBuilder

class DebugMacroEvaluationInfoBuilder
    implements MacroEvaluationInfoBuilder
{

    private com.google.analytics.containertag.proto.MutableDebug.MacroEvaluationInfo macroEvaluationInfo;

    public DebugMacroEvaluationInfoBuilder(com.google.analytics.containertag.proto.MutableDebug.MacroEvaluationInfo macroevaluationinfo)
    {
        macroEvaluationInfo = macroevaluationinfo;
    }

    public ResolvedFunctionCallBuilder createResult()
    {
        return new DebugResolvedFunctionCallBuilder(macroEvaluationInfo.getMutableResult());
    }

    public RuleEvaluationStepInfoBuilder createRulesEvaluation()
    {
        return new DebugRuleEvaluationStepInfoBuilder(macroEvaluationInfo.getMutableRulesEvaluation());
    }
}
