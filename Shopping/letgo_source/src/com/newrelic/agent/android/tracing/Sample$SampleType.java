// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.tracing;


// Referenced classes of package com.newrelic.agent.android.tracing:
//            Sample

public static final class  extends Enum
{

    private static final CPU $VALUES[];
    public static final CPU CPU;
    public static final CPU MEMORY;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/newrelic/agent/android/tracing/Sample$SampleType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MEMORY = new <init>("MEMORY", 0);
        CPU = new <init>("CPU", 1);
        $VALUES = (new .VALUES[] {
            MEMORY, CPU
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
