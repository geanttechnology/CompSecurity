// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation;


// Referenced classes of package com.newrelic.agent.android.instrumentation:
//            TransactionState

private static final class  extends Enum
{

    private static final COMPLETE $VALUES[];
    public static final COMPLETE COMPLETE;
    public static final COMPLETE READY;
    public static final COMPLETE SENT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/newrelic/agent/android/instrumentation/TransactionState$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        READY = new <init>("READY", 0);
        SENT = new <init>("SENT", 1);
        COMPLETE = new <init>("COMPLETE", 2);
        $VALUES = (new .VALUES[] {
            READY, SENT, COMPLETE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
