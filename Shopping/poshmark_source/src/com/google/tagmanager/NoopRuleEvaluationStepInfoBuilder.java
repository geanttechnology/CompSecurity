// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import java.util.Set;

// Referenced classes of package com.google.tagmanager:
//            RuleEvaluationStepInfoBuilder, NoopResolvedRuleBuilder, ResolvedRuleBuilder

class NoopRuleEvaluationStepInfoBuilder
    implements RuleEvaluationStepInfoBuilder
{

    NoopRuleEvaluationStepInfoBuilder()
    {
    }

    public ResolvedRuleBuilder createResolvedRuleBuilder()
    {
        return new NoopResolvedRuleBuilder();
    }

    public void setEnabledFunctions(Set set)
    {
    }
}
