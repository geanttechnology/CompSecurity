// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;


// Referenced classes of package com.amazon.mShop.net:
//            CountMetricObserver

public static final class _cls9 extends Enum
{

    private static final FLOW_SCAN $VALUES[];
    public static final FLOW_SCAN FLOW_SCAN;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/amazon/mShop/net/CountMetricObserver$MetricType, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        FLOW_SCAN = new <init>("FLOW_SCAN", 0);
        $VALUES = (new .VALUES[] {
            FLOW_SCAN
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
