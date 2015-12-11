// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.tagmanager:
//            RuleEvaluationStepInfoBuilder, DebugResolvedRuleBuilder, ResolvedRuleBuilder

class DebugRuleEvaluationStepInfoBuilder
    implements RuleEvaluationStepInfoBuilder
{

    private com.google.analytics.containertag.proto.MutableDebug.RuleEvaluationStepInfo ruleEvaluationStepInfo;

    public DebugRuleEvaluationStepInfoBuilder(com.google.analytics.containertag.proto.MutableDebug.RuleEvaluationStepInfo ruleevaluationstepinfo)
    {
        ruleEvaluationStepInfo = ruleevaluationstepinfo;
    }

    public ResolvedRuleBuilder createResolvedRuleBuilder()
    {
        return new DebugResolvedRuleBuilder(ruleEvaluationStepInfo.addRules());
    }

    public void setEnabledFunctions(Set set)
    {
        ResourceUtil.ExpandedFunctionCall expandedfunctioncall;
        for (set = set.iterator(); set.hasNext(); ruleEvaluationStepInfo.addEnabledFunctions(DebugResolvedRuleBuilder.translateExpandedFunctionCall(expandedfunctioncall)))
        {
            expandedfunctioncall = (ResourceUtil.ExpandedFunctionCall)set.next();
        }

    }
}
