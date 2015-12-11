// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics;


public final class TrackingType extends Enum
{

    private static final TrackingType $VALUES[];
    public static final TrackingType EVENT;
    public static final TrackingType PAGE_IMPRESSION;
    public static final TrackingType ROI;

    private TrackingType(String s, int i)
    {
        super(s, i);
    }

    public static TrackingType valueOf(String s)
    {
        return (TrackingType)Enum.valueOf(com/ebay/mobile/analytics/TrackingType, s);
    }

    public static TrackingType[] values()
    {
        return (TrackingType[])$VALUES.clone();
    }

    static 
    {
        PAGE_IMPRESSION = new TrackingType("PAGE_IMPRESSION", 0);
        EVENT = new TrackingType("EVENT", 1);
        ROI = new TrackingType("ROI", 2);
        $VALUES = (new TrackingType[] {
            PAGE_IMPRESSION, EVENT, ROI
        });
    }
}
