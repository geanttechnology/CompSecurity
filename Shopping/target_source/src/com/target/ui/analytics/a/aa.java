// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;


// Referenced classes of package com.target.ui.analytics.a:
//            d, y

public class aa extends d
{

    public static final int CARTWHEEL = 1;
    public static final int MOBILE_COUPONS = 2;

    protected aa(y y1, Integer integer, Integer integer1)
    {
        super(y1, integer, integer1);
    }

    public static aa a(int i)
    {
        y y1;
        Integer integer;
        integer = null;
        y1 = y.Unknown;
        i;
        JVM INSTR tableswitch 1 2: default 28
    //                   1 42
    //                   2 54;
           goto _L1 _L2 _L3
_L1:
        return new aa(y1, Integer.valueOf(1), integer);
_L2:
        y1 = y.DealsCartwheel;
        integer = Integer.valueOf(0);
        continue; /* Loop/switch isn't completed */
_L3:
        y1 = y.DealsMobileCoupons;
        integer = Integer.valueOf(1);
        if (true) goto _L1; else goto _L4
_L4:
    }
}
