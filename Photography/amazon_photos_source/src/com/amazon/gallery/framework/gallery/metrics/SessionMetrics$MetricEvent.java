// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.metrics;


// Referenced classes of package com.amazon.gallery.framework.gallery.metrics:
//            SessionMetrics

public static final class  extends Enum
{

    private static final SessionStop $VALUES[];
    public static final SessionStop ActiveTime;
    public static final SessionStop SessionStart;
    public static final SessionStop SessionStop;
    public static final SessionStop ViewedCollections;
    public static final SessionStop ViewedItems;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/gallery/metrics/SessionMetrics$MetricEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ActiveTime = new <init>("ActiveTime", 0);
        ViewedCollections = new <init>("ViewedCollections", 1);
        ViewedItems = new <init>("ViewedItems", 2);
        SessionStart = new <init>("SessionStart", 3);
        SessionStop = new <init>("SessionStop", 4);
        $VALUES = (new .VALUES[] {
            ActiveTime, ViewedCollections, ViewedItems, SessionStart, SessionStop
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
