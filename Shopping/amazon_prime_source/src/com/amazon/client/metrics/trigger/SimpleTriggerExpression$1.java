// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.trigger;


// Referenced classes of package com.amazon.client.metrics.trigger:
//            SimpleTriggerExpression

static class iggerOperator
{

    static final int $SwitchMap$com$amazon$client$metrics$trigger$SimpleTriggerExpression$TriggerOperator[];

    static 
    {
        $SwitchMap$com$amazon$client$metrics$trigger$SimpleTriggerExpression$TriggerOperator = new int[iggerOperator.values().length];
        try
        {
            $SwitchMap$com$amazon$client$metrics$trigger$SimpleTriggerExpression$TriggerOperator[iggerOperator.GREATER_THAN.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$client$metrics$trigger$SimpleTriggerExpression$TriggerOperator[iggerOperator.LESS_THAN.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$client$metrics$trigger$SimpleTriggerExpression$TriggerOperator[iggerOperator.EQUAL_TO.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
