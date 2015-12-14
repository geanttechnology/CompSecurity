// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.metrics.clickstream;


public final class HitType extends Enum
{

    private static final HitType $VALUES[];
    public static final HitType APP_ACTION;
    public static final HitType PAGE_HIT;
    public static final HitType PAGE_TOUCH;
    private final String name;

    private HitType(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }

    public static HitType valueOf(String s)
    {
        return (HitType)Enum.valueOf(com/amazon/gallery/framework/metrics/clickstream/HitType, s);
    }

    public static HitType[] values()
    {
        return (HitType[])$VALUES.clone();
    }

    public String toString()
    {
        return name;
    }

    static 
    {
        PAGE_HIT = new HitType("PAGE_HIT", 0, "pageHit");
        PAGE_TOUCH = new HitType("PAGE_TOUCH", 1, "pageTouch");
        APP_ACTION = new HitType("APP_ACTION", 2, "deviceAction");
        $VALUES = (new HitType[] {
            PAGE_HIT, PAGE_TOUCH, APP_ACTION
        });
    }
}
