// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.trigger;


// Referenced classes of package com.amazon.client.metrics.trigger:
//            TriggerExpression

class SimpleTriggerExpression
    implements TriggerExpression
{
    static final class TriggerOperator extends Enum
    {

        private static final TriggerOperator $VALUES[];
        public static final TriggerOperator EQUAL_TO;
        public static final TriggerOperator GREATER_THAN;
        public static final TriggerOperator LESS_THAN;

        static TriggerOperator fromString(String s)
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

        public static TriggerOperator valueOf(String s)
        {
            return (TriggerOperator)Enum.valueOf(com/amazon/client/metrics/trigger/SimpleTriggerExpression$TriggerOperator, s);
        }

        public static TriggerOperator[] values()
        {
            return (TriggerOperator[])$VALUES.clone();
        }

        static 
        {
            GREATER_THAN = new TriggerOperator("GREATER_THAN", 0);
            LESS_THAN = new TriggerOperator("LESS_THAN", 1);
            EQUAL_TO = new TriggerOperator("EQUAL_TO", 2);
            $VALUES = (new TriggerOperator[] {
                GREATER_THAN, LESS_THAN, EQUAL_TO
            });
        }

        private TriggerOperator(String s, int i)
        {
            super(s, i);
        }
    }


    private final TriggerOperator mTriggerOperator;
    private final double mTriggerThreshold;

    SimpleTriggerExpression(TriggerOperator triggeroperator, double d)
    {
        mTriggerOperator = triggeroperator;
        mTriggerThreshold = d;
    }

    public boolean evaluate(double d)
    {
        boolean flag = true;
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$client$metrics$trigger$SimpleTriggerExpression$TriggerOperator[];

            static 
            {
                $SwitchMap$com$amazon$client$metrics$trigger$SimpleTriggerExpression$TriggerOperator = new int[TriggerOperator.values().length];
                try
                {
                    $SwitchMap$com$amazon$client$metrics$trigger$SimpleTriggerExpression$TriggerOperator[TriggerOperator.GREATER_THAN.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$client$metrics$trigger$SimpleTriggerExpression$TriggerOperator[TriggerOperator.LESS_THAN.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$client$metrics$trigger$SimpleTriggerExpression$TriggerOperator[TriggerOperator.EQUAL_TO.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.client.metrics.trigger.SimpleTriggerExpression.TriggerOperator[mTriggerOperator.ordinal()];
        JVM INSTR tableswitch 1 3: default 40
    //                   1 44
    //                   2 55
    //                   3 66;
           goto _L1 _L2 _L3 _L4
_L1:
        flag = false;
_L6:
        return flag;
_L2:
        if (d <= mTriggerThreshold)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (d >= mTriggerThreshold)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (d != mTriggerThreshold)
        {
            return false;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    TriggerOperator getOperator()
    {
        return mTriggerOperator;
    }

    double getThreshold()
    {
        return mTriggerThreshold;
    }
}
