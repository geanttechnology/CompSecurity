// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.type.base;


public final class TrackingEventType extends Enum
{

    private static final TrackingEventType $VALUES[];
    public static final TrackingEventType PERFORMED_ACTION;
    public static final TrackingEventType REFERRED;
    public static final TrackingEventType SERVED;
    public static final TrackingEventType UNKNOWN;
    public static final TrackingEventType VIEWED;

    private TrackingEventType(String s, int i)
    {
        super(s, i);
    }

    public static TrackingEventType valueOf(String s)
    {
        return (TrackingEventType)Enum.valueOf(com/ebay/nautilus/domain/data/experience/type/base/TrackingEventType, s);
    }

    public static TrackingEventType[] values()
    {
        return (TrackingEventType[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new TrackingEventType("UNKNOWN", 0);
        REFERRED = new TrackingEventType("REFERRED", 1);
        SERVED = new TrackingEventType("SERVED", 2);
        VIEWED = new TrackingEventType("VIEWED", 3);
        PERFORMED_ACTION = new TrackingEventType("PERFORMED_ACTION", 4);
        $VALUES = (new TrackingEventType[] {
            UNKNOWN, REFERRED, SERVED, VIEWED, PERFORMED_ACTION
        });
    }
}
