// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable;


public final class WearableDeviceType extends Enum
{

    private static final WearableDeviceType $VALUES[];
    public static final WearableDeviceType AndroidWear;

    private WearableDeviceType(String s, int i)
    {
        super(s, i);
    }

    public static WearableDeviceType valueOf(String s)
    {
        return (WearableDeviceType)Enum.valueOf(com/amazon/mShop/wearable/WearableDeviceType, s);
    }

    public static WearableDeviceType[] values()
    {
        return (WearableDeviceType[])$VALUES.clone();
    }

    static 
    {
        AndroidWear = new WearableDeviceType("AndroidWear", 0);
        $VALUES = (new WearableDeviceType[] {
            AndroidWear
        });
    }
}
