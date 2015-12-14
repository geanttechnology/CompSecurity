// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.metrics.customer;

import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;

public class TimelineMetrics extends ComponentProfiler
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent TimelineAutoClose;
        public static final MetricsEvent TimelineAutoOpen;
        public static final MetricsEvent TimelineMonthTapAllView;
        public static final MetricsEvent TimelineMonthTapCameraRoll;
        public static final MetricsEvent TimelineMonthTapCollection;
        public static final MetricsEvent TimelineMonthTapVideoView;
        public static final MetricsEvent TimelineSwipeClose;
        public static final MetricsEvent TimelineSwipeOpen;
        public static final MetricsEvent TimelineTapClose;
        public static final MetricsEvent TimelineTapOpen;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/kindle/metrics/customer/TimelineMetrics$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            TimelineSwipeOpen = new MetricsEvent("TimelineSwipeOpen", 0);
            TimelineTapOpen = new MetricsEvent("TimelineTapOpen", 1);
            TimelineSwipeClose = new MetricsEvent("TimelineSwipeClose", 2);
            TimelineTapClose = new MetricsEvent("TimelineTapClose", 3);
            TimelineAutoOpen = new MetricsEvent("TimelineAutoOpen", 4);
            TimelineAutoClose = new MetricsEvent("TimelineAutoClose", 5);
            TimelineMonthTapAllView = new MetricsEvent("TimelineMonthTapAllView", 6);
            TimelineMonthTapVideoView = new MetricsEvent("TimelineMonthTapVideoView", 7);
            TimelineMonthTapCameraRoll = new MetricsEvent("TimelineMonthTapCameraRoll", 8);
            TimelineMonthTapCollection = new MetricsEvent("TimelineMonthTapCollection", 9);
            $VALUES = (new MetricsEvent[] {
                TimelineSwipeOpen, TimelineTapOpen, TimelineSwipeClose, TimelineTapClose, TimelineAutoOpen, TimelineAutoClose, TimelineMonthTapAllView, TimelineMonthTapVideoView, TimelineMonthTapCameraRoll, TimelineMonthTapCollection
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    public TimelineMetrics(Profiler profiler)
    {
        super(profiler, com/amazon/gallery/framework/kindle/metrics/customer/TimelineMetrics);
    }
}
