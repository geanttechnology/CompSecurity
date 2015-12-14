// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;

import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.thor.metrics.MetricsHelper;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.thisday:
//            ThisDayViewCollection

public class ThisDayMetricsHelper extends MetricsHelper
{
    private static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent AppDownload;
        public static final MetricsEvent ThisDayBannerDisplay;
        public static final MetricsEvent ThisDayBannerOpen;
        public static final MetricsEvent ThisDayNotificationsToggle;
        public static final MetricsEvent ThisDayOpenNotification;
        public static final MetricsEvent ThisDayPostNotification;
        public static final MetricsEvent ThisDayShuffleViewSingle;
        public static final MetricsEvent ThisDayViewAll;
        public static final MetricsEvent ThisDayYearViewAll;
        public static final MetricsEvent ThisDayYearViewSingle;
        public static final MetricsEvent ThisWeekYearViewAll;
        public static final MetricsEvent ThisWeekYearViewSingle;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/thor/thisday/ThisDayMetricsHelper$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            ThisDayViewAll = new MetricsEvent("ThisDayViewAll", 0);
            ThisDayYearViewAll = new MetricsEvent("ThisDayYearViewAll", 1);
            ThisWeekYearViewAll = new MetricsEvent("ThisWeekYearViewAll", 2);
            ThisDayYearViewSingle = new MetricsEvent("ThisDayYearViewSingle", 3);
            ThisWeekYearViewSingle = new MetricsEvent("ThisWeekYearViewSingle", 4);
            ThisDayShuffleViewSingle = new MetricsEvent("ThisDayShuffleViewSingle", 5);
            ThisDayPostNotification = new MetricsEvent("ThisDayPostNotification", 6);
            ThisDayOpenNotification = new MetricsEvent("ThisDayOpenNotification", 7);
            AppDownload = new MetricsEvent("AppDownload", 8);
            ThisDayNotificationsToggle = new MetricsEvent("ThisDayNotificationsToggle", 9);
            ThisDayBannerDisplay = new MetricsEvent("ThisDayBannerDisplay", 10);
            ThisDayBannerOpen = new MetricsEvent("ThisDayBannerOpen", 11);
            $VALUES = (new MetricsEvent[] {
                ThisDayViewAll, ThisDayYearViewAll, ThisWeekYearViewAll, ThisDayYearViewSingle, ThisWeekYearViewSingle, ThisDayShuffleViewSingle, ThisDayPostNotification, ThisDayOpenNotification, AppDownload, ThisDayNotificationsToggle, 
                ThisDayBannerDisplay, ThisDayBannerOpen
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private final ComponentProfiler profiler;

    public ThisDayMetricsHelper(Profiler profiler1)
    {
        profiler = new ComponentProfiler(profiler1, "ThisDayMetrics");
    }

    public void onClickThisDayBanner()
    {
        profiler.trackEvent(MetricsEvent.ThisDayBannerOpen);
    }

    public void onGetDesktopApp()
    {
        profiler.trackEvent(MetricsEvent.AppDownload, createMetricsExtra(MetricsEvent.AppDownload.name(), "Desktop", null));
    }

    public void onNotificationsToggleFromSettings(boolean flag)
    {
        ComponentProfiler componentprofiler = profiler;
        MetricsEvent metricsevent = MetricsEvent.ThisDayNotificationsToggle;
        String s1 = MetricsEvent.ThisDayNotificationsToggle.name();
        String s;
        if (flag)
        {
            s = "On";
        } else
        {
            s = "Off";
        }
        componentprofiler.trackEvent(metricsevent, createMetricsExtra(s1, s, "Settings"));
    }

    public void onOpenFromNotification(int i)
    {
        profiler.trackEvent(MetricsEvent.ThisDayOpenNotification, createMetricsExtra(MetricsEvent.ThisDayOpenNotification.name(), String.valueOf(i), null));
    }

    public void onOpenShuffleSingleView()
    {
        profiler.trackEvent(MetricsEvent.ThisDayShuffleViewSingle, createMetricsExtra(MetricsEvent.ThisDayShuffleViewSingle.name(), null, "listShuffleSingle"));
    }

    public void onOpenShuffleView(ThisDayViewCollection thisdayviewcollection)
    {
        profiler.trackEvent(MetricsEvent.ThisDayViewAll, createMetricsExtra(MetricsEvent.ThisDayViewAll.name(), String.format("%s:0", new Object[] {
            String.valueOf(thisdayviewcollection.yearInfoList.size())
        }), "ThisDayShuffle"));
    }

    public void onOpenThisDayGalleryView()
    {
        profiler.trackEvent(MetricsEvent.ThisDayYearViewAll, createMetricsExtra(MetricsEvent.ThisDayYearViewAll.name(), null, "listThisDayGrid"));
    }

    public void onOpenThisDaySingleView()
    {
        profiler.trackEvent(MetricsEvent.ThisDayYearViewSingle, createMetricsExtra(MetricsEvent.ThisDayYearViewSingle.name(), null, "listThisDaySingle"));
    }

    public void onOpenThisDayView(ThisDayViewCollection thisdayviewcollection)
    {
        profiler.trackEvent(MetricsEvent.ThisDayViewAll, createMetricsExtra(MetricsEvent.ThisDayViewAll.name(), String.format("%s:%s", new Object[] {
            String.valueOf(thisdayviewcollection.yearInfoList.size()), String.valueOf(thisdayviewcollection.getTotalMediaItemsInCollection())
        }), "ThisDayList"));
    }

    public void onOpenThisWeekGalleryView()
    {
        profiler.trackEvent(MetricsEvent.ThisWeekYearViewAll, createMetricsExtra(MetricsEvent.ThisWeekYearViewAll.name(), null, "listThisWeekGrid"));
    }

    public void onOpenThisWeekSingleView()
    {
        profiler.trackEvent(MetricsEvent.ThisWeekYearViewSingle, createMetricsExtra(MetricsEvent.ThisWeekYearViewSingle.name(), null, "listThisWeekSingle"));
    }

    public void onOpenThisWeekView(ThisDayViewCollection thisdayviewcollection)
    {
        profiler.trackEvent(MetricsEvent.ThisDayViewAll, createMetricsExtra(MetricsEvent.ThisDayViewAll.name(), String.format("%s:%s", new Object[] {
            String.valueOf(thisdayviewcollection.yearInfoList.size()), String.valueOf(thisdayviewcollection.getTotalMediaItemsInCollection())
        }), "ThisWeekList"));
    }

    public void onPostNotification()
    {
        profiler.trackEvent(MetricsEvent.ThisDayPostNotification);
    }

    public void onShowThisDayBanner()
    {
        profiler.trackEvent(MetricsEvent.ThisDayBannerDisplay);
    }
}
