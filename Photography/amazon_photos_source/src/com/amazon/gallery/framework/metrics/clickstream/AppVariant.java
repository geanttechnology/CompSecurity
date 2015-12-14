// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.metrics.clickstream;


public final class AppVariant extends Enum
{

    private static final AppVariant $VALUES[];
    public static final AppVariant FREETIME;
    public static final AppVariant STANDARD;
    public static final AppVariant TEENTIME;
    private final String appVariant;

    private AppVariant(String s, int i, String s1)
    {
        super(s, i);
        appVariant = s1;
    }

    public static AppVariant valueOf(String s)
    {
        return (AppVariant)Enum.valueOf(com/amazon/gallery/framework/metrics/clickstream/AppVariant, s);
    }

    public static AppVariant[] values()
    {
        return (AppVariant[])$VALUES.clone();
    }

    public String toString()
    {
        return appVariant;
    }

    static 
    {
        STANDARD = new AppVariant("STANDARD", 0, "Standard");
        FREETIME = new AppVariant("FREETIME", 1, "FreeTime");
        TEENTIME = new AppVariant("TEENTIME", 2, "TeenTime");
        $VALUES = (new AppVariant[] {
            STANDARD, FREETIME, TEENTIME
        });
    }
}
