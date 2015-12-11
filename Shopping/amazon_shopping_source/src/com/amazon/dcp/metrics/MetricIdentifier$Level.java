// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.metrics;


// Referenced classes of package com.amazon.dcp.metrics:
//            MetricIdentifier

public static final class  extends Enum
{

    private static final CRITICAL $VALUES[];
    public static final CRITICAL CRITICAL;
    public static final CRITICAL ERROR;
    public static final CRITICAL INFO;
    public static final CRITICAL WARN;

    public static  fromCode(int i)
    {
         a[] = values();
        int k = a.length;
        for (int j = 0; j < k; j++)
        {
              = a[j];
            if (.ordinal() == i)
            {
                return ;
            }
        }

        throw new IllegalArgumentException();
    }

    public static ordinal valueOf(String s)
    {
        return (ordinal)Enum.valueOf(com/amazon/dcp/metrics/MetricIdentifier$Level, s);
    }

    public static ordinal[] values()
    {
        return (ordinal[])$VALUES.clone();
    }

    static 
    {
        INFO = new <init>("INFO", 0);
        WARN = new <init>("WARN", 1);
        ERROR = new <init>("ERROR", 2);
        CRITICAL = new <init>("CRITICAL", 3);
        $VALUES = (new .VALUES[] {
            INFO, WARN, ERROR, CRITICAL
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
