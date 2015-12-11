// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.stats;


// Referenced classes of package com.newrelic.agent.android.stats:
//            TicToc

private static final class  extends Enum
{

    private static final STARTED $VALUES[];
    public static final STARTED STARTED;
    public static final STARTED STOPPED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/newrelic/agent/android/stats/TicToc$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        STOPPED = new <init>("STOPPED", 0);
        STARTED = new <init>("STARTED", 1);
        $VALUES = (new .VALUES[] {
            STOPPED, STARTED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
