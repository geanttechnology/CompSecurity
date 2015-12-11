// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


public final class ShippingTrackingEvent extends Enum
{

    private static final ShippingTrackingEvent $VALUES[];
    public static final ShippingTrackingEvent NOT_SET;
    public static final ShippingTrackingEvent ValetPickedUpOrder;
    public static final ShippingTrackingEvent ValetReadyForPickup;

    private ShippingTrackingEvent(String s, int i)
    {
        super(s, i);
    }

    public static ShippingTrackingEvent valueOf(String s)
    {
        return (ShippingTrackingEvent)Enum.valueOf(com/ebay/nautilus/domain/data/ShippingTrackingEvent, s);
    }

    public static ShippingTrackingEvent[] values()
    {
        return (ShippingTrackingEvent[])$VALUES.clone();
    }

    static 
    {
        NOT_SET = new ShippingTrackingEvent("NOT_SET", 0);
        ValetReadyForPickup = new ShippingTrackingEvent("ValetReadyForPickup", 1);
        ValetPickedUpOrder = new ShippingTrackingEvent("ValetPickedUpOrder", 2);
        $VALUES = (new ShippingTrackingEvent[] {
            NOT_SET, ValetReadyForPickup, ValetPickedUpOrder
        });
    }
}
