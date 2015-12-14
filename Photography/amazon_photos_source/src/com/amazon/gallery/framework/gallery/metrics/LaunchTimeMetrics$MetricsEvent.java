// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.metrics;


// Referenced classes of package com.amazon.gallery.framework.gallery.metrics:
//            LaunchTimeMetrics

public static final class Q extends Enum
{

    private static final AboveTheFoldLoaded $VALUES[];
    public static final AboveTheFoldLoaded AboveTheFoldLoaded;
    public static final AboveTheFoldLoaded ColdStart;
    public static final AboveTheFoldLoaded CoolStart;
    public static final AboveTheFoldLoaded FireStart;
    public static final AboveTheFoldLoaded WarmStart;

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/amazon/gallery/framework/gallery/metrics/LaunchTimeMetrics$MetricsEvent, s);
    }

    public static Q[] values()
    {
        return (Q[])$VALUES.clone();
    }

    static 
    {
        FireStart = new <init>("FireStart", 0);
        WarmStart = new <init>("WarmStart", 1);
        CoolStart = new <init>("CoolStart", 2);
        ColdStart = new <init>("ColdStart", 3);
        AboveTheFoldLoaded = new <init>("AboveTheFoldLoaded", 4);
        $VALUES = (new .VALUES[] {
            FireStart, WarmStart, CoolStart, ColdStart, AboveTheFoldLoaded
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
