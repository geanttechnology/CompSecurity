// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.trigger;


// Referenced classes of package com.amazon.client.metrics.trigger:
//            SimpleTriggerExpression

static final class  extends Enum
{

    private static final EQUAL_TO $VALUES[];
    public static final EQUAL_TO EQUAL_TO;
    public static final EQUAL_TO GREATER_THAN;
    public static final EQUAL_TO LESS_THAN;

    static  fromString(String s)
    {
        if (s.equals("<"))
        {
            return LESS_THAN;
        }
        if (s.equals(">"))
        {
            return GREATER_THAN;
        }
        if (s.equals("=="))
        {
            return EQUAL_TO;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown operator ").append(s).toString());
        }
    }

    public static EQUAL_TO valueOf(String s)
    {
        return (EQUAL_TO)Enum.valueOf(com/amazon/client/metrics/trigger/SimpleTriggerExpression$TriggerOperator, s);
    }

    public static EQUAL_TO[] values()
    {
        return (EQUAL_TO[])$VALUES.clone();
    }

    static 
    {
        GREATER_THAN = new <init>("GREATER_THAN", 0);
        LESS_THAN = new <init>("LESS_THAN", 1);
        EQUAL_TO = new <init>("EQUAL_TO", 2);
        $VALUES = (new .VALUES[] {
            GREATER_THAN, LESS_THAN, EQUAL_TO
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
