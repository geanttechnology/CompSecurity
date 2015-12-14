// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.metrics.customer;


// Referenced classes of package com.amazon.gallery.framework.kindle.metrics.customer:
//            TimelineMetrics

public static final class  extends Enum
{

    private static final TimelineMonthTapCollection $VALUES[];
    public static final TimelineMonthTapCollection TimelineAutoClose;
    public static final TimelineMonthTapCollection TimelineAutoOpen;
    public static final TimelineMonthTapCollection TimelineMonthTapAllView;
    public static final TimelineMonthTapCollection TimelineMonthTapCameraRoll;
    public static final TimelineMonthTapCollection TimelineMonthTapCollection;
    public static final TimelineMonthTapCollection TimelineMonthTapVideoView;
    public static final TimelineMonthTapCollection TimelineSwipeClose;
    public static final TimelineMonthTapCollection TimelineSwipeOpen;
    public static final TimelineMonthTapCollection TimelineTapClose;
    public static final TimelineMonthTapCollection TimelineTapOpen;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/metrics/customer/TimelineMetrics$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TimelineSwipeOpen = new <init>("TimelineSwipeOpen", 0);
        TimelineTapOpen = new <init>("TimelineTapOpen", 1);
        TimelineSwipeClose = new <init>("TimelineSwipeClose", 2);
        TimelineTapClose = new <init>("TimelineTapClose", 3);
        TimelineAutoOpen = new <init>("TimelineAutoOpen", 4);
        TimelineAutoClose = new <init>("TimelineAutoClose", 5);
        TimelineMonthTapAllView = new <init>("TimelineMonthTapAllView", 6);
        TimelineMonthTapVideoView = new <init>("TimelineMonthTapVideoView", 7);
        TimelineMonthTapCameraRoll = new <init>("TimelineMonthTapCameraRoll", 8);
        TimelineMonthTapCollection = new <init>("TimelineMonthTapCollection", 9);
        $VALUES = (new .VALUES[] {
            TimelineSwipeOpen, TimelineTapOpen, TimelineSwipeClose, TimelineTapClose, TimelineAutoOpen, TimelineAutoClose, TimelineMonthTapAllView, TimelineMonthTapVideoView, TimelineMonthTapCameraRoll, TimelineMonthTapCollection
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
