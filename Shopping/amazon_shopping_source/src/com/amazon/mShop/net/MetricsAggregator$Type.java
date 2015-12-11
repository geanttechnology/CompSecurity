// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;


// Referenced classes of package com.amazon.mShop.net:
//            MetricsAggregator

public static final class  extends Enum
{

    private static final NetworkInfoMetric $VALUES[];
    public static final NetworkInfoMetric CallMetric;
    public static final NetworkInfoMetric ClickedSlotsMetric;
    public static final NetworkInfoMetric CountMetric;
    public static final NetworkInfoMetric ErrorExceptionMetric;
    public static final NetworkInfoMetric ExposedSlotsMetric;
    public static final NetworkInfoMetric NetworkInfoMetric;
    public static final NetworkInfoMetric OrientationMetric;
    public static final NetworkInfoMetric PageMetric;
    public static final NetworkInfoMetric RefMarkerMetric;
    public static final NetworkInfoMetric StartupMetric;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/mShop/net/MetricsAggregator$Type, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CallMetric = new <init>("CallMetric", 0);
        PageMetric = new <init>("PageMetric", 1);
        ExposedSlotsMetric = new <init>("ExposedSlotsMetric", 2);
        ClickedSlotsMetric = new <init>("ClickedSlotsMetric", 3);
        ErrorExceptionMetric = new <init>("ErrorExceptionMetric", 4);
        OrientationMetric = new <init>("OrientationMetric", 5);
        RefMarkerMetric = new <init>("RefMarkerMetric", 6);
        StartupMetric = new <init>("StartupMetric", 7);
        CountMetric = new <init>("CountMetric", 8);
        NetworkInfoMetric = new <init>("NetworkInfoMetric", 9);
        $VALUES = (new .VALUES[] {
            CallMetric, PageMetric, ExposedSlotsMetric, ClickedSlotsMetric, ErrorExceptionMetric, OrientationMetric, RefMarkerMetric, StartupMetric, CountMetric, NetworkInfoMetric
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
