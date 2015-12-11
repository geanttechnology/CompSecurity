// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.analytics;


// Referenced classes of package com.pointinside.analytics:
//            MapMarkerAnalyticData

public static final class  extends Enum
{

    private static final OTHER $VALUES[];
    public static final OTHER OTHER;
    public static final OTHER PRODUCT;
    public static final OTHER SERVICE;
    public static final OTHER TERM;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pointinside/analytics/MapMarkerAnalyticData$ItemType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PRODUCT = new <init>("PRODUCT", 0);
        SERVICE = new <init>("SERVICE", 1);
        TERM = new <init>("TERM", 2);
        OTHER = new <init>("OTHER", 3);
        $VALUES = (new .VALUES[] {
            PRODUCT, SERVICE, TERM, OTHER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
