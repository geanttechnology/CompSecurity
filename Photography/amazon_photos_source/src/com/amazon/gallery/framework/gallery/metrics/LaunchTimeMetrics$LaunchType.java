// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.metrics;


// Referenced classes of package com.amazon.gallery.framework.gallery.metrics:
//            LaunchTimeMetrics

public static final class event extends Enum
{

    private static final COLD $VALUES[];
    public static final COLD COLD;
    public static final COLD COOL;
    public static final COLD FIRE;
    public static final COLD WARM;
    private final t event;

    public static event valueOf(String s)
    {
        return (event)Enum.valueOf(com/amazon/gallery/framework/gallery/metrics/LaunchTimeMetrics$LaunchType, s);
    }

    public static event[] values()
    {
        return (event[])$VALUES.clone();
    }

    static 
    {
        FIRE = new <init>("FIRE", 0, t.FireStart);
        WARM = new <init>("WARM", 1, t.WarmStart);
        COOL = new <init>("COOL", 2, t.CoolStart);
        COLD = new <init>("COLD", 3, t.ColdStart);
        $VALUES = (new .VALUES[] {
            FIRE, WARM, COOL, COLD
        });
    }


    private t(String s, int i, t t)
    {
        super(s, i);
        event = t;
    }
}
