// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.metrics;

import android.os.SystemClock;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.SceneLoadedEvent;
import com.amazon.gallery.framework.gallery.widget.GridStatus;
import com.amazon.gallery.framework.network.http.senna.sync.manager.SyncManager;

public class LaunchTimeMetrics
{
    public static final class LaunchType extends Enum
    {

        private static final LaunchType $VALUES[];
        public static final LaunchType COLD;
        public static final LaunchType COOL;
        public static final LaunchType FIRE;
        public static final LaunchType WARM;
        private final MetricsEvent event;

        public static LaunchType valueOf(String s)
        {
            return (LaunchType)Enum.valueOf(com/amazon/gallery/framework/gallery/metrics/LaunchTimeMetrics$LaunchType, s);
        }

        public static LaunchType[] values()
        {
            return (LaunchType[])$VALUES.clone();
        }

        static 
        {
            FIRE = new LaunchType("FIRE", 0, MetricsEvent.FireStart);
            WARM = new LaunchType("WARM", 1, MetricsEvent.WarmStart);
            COOL = new LaunchType("COOL", 2, MetricsEvent.CoolStart);
            COLD = new LaunchType("COLD", 3, MetricsEvent.ColdStart);
            $VALUES = (new LaunchType[] {
                FIRE, WARM, COOL, COLD
            });
        }


        private LaunchType(String s, int i, MetricsEvent metricsevent)
        {
            super(s, i);
            event = metricsevent;
        }
    }

    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent AboveTheFoldLoaded;
        public static final MetricsEvent ColdStart;
        public static final MetricsEvent CoolStart;
        public static final MetricsEvent FireStart;
        public static final MetricsEvent WarmStart;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/gallery/metrics/LaunchTimeMetrics$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            FireStart = new MetricsEvent("FireStart", 0);
            WarmStart = new MetricsEvent("WarmStart", 1);
            CoolStart = new MetricsEvent("CoolStart", 2);
            ColdStart = new MetricsEvent("ColdStart", 3);
            AboveTheFoldLoaded = new MetricsEvent("AboveTheFoldLoaded", 4);
            $VALUES = (new MetricsEvent[] {
                FireStart, WarmStart, CoolStart, ColdStart, AboveTheFoldLoaded
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/framework/gallery/metrics/LaunchTimeMetrics.getName();
    private static long sessionStartTime;
    private boolean firstStart;
    private GridStatus gridStatus;
    private long lastThumbnailLoadedTime;
    private boolean launchCompleted;
    private LaunchType launchType;
    private int loadedThumbnails;
    private ComponentProfiler profiler;
    private SyncManager syncManager;

    public LaunchTimeMetrics()
    {
        launchCompleted = false;
        firstStart = true;
        startTimerIfNotStarted();
    }

    private void beginSession()
    {
        startTimerIfNotStarted();
        setLaunchTypeIfNotSet();
        launchCompleted = false;
        loadedThumbnails = 0;
    }

    public static long currentTime()
    {
        return SystemClock.uptimeMillis();
    }

    private void startTimerIfNotStarted()
    {
        long l = currentTime();
        if (sessionStartTime == 0L)
        {
            sessionStartTime = l;
        } else
        if (l - sessionStartTime > 5000L)
        {
            sessionStartTime = l;
            firstStart = false;
            return;
        }
    }

    private void track(MetricsEvent metricsevent, long l)
    {
        GLogger.i(TAG, "Event: %s, Duration: %d", new Object[] {
            metricsevent, Long.valueOf(l)
        });
        profiler.trackTimer(metricsevent, l);
    }

    public void invalidateSceneLoading()
    {
        launchCompleted = true;
    }

    public void onSceneLoaded()
    {
        if (launchCompleted)
        {
            return;
        }
        launchCompleted = true;
        firstStart = false;
        long l = currentTime() - sessionStartTime;
        track(MetricsEvent.AboveTheFoldLoaded, l);
        if (launchType != null)
        {
            track(launchType.event, l);
        }
        GlobalMessagingBus.post(new SceneLoadedEvent());
    }

    public void setGridStatus(GridStatus gridstatus)
    {
        gridStatus = gridstatus;
    }

    public void setLaunchTypeIfNotSet()
    {
label0:
        {
            if (launchType == null)
            {
                if (!firstStart)
                {
                    break label0;
                }
                LaunchType launchtype;
                if (syncManager != null && syncManager.isColdBootCompleted())
                {
                    launchtype = LaunchType.COOL;
                } else
                {
                    launchtype = LaunchType.COLD;
                }
                launchType = launchtype;
            }
            return;
        }
        launchType = LaunchType.WARM;
    }

    public void setProfiler(Profiler profiler1)
    {
        profiler = new ComponentProfiler(profiler1, getClass());
    }

    public void setSyncManager(SyncManager syncmanager)
    {
        syncManager = syncmanager;
    }

    public void thumbnailLoaded()
    {
        if (!launchCompleted)
        {
            long l = currentTime();
            if (loadedThumbnails > 0 && l - lastThumbnailLoadedTime > 5000L)
            {
                invalidateSceneLoading();
                return;
            }
            lastThumbnailLoadedTime = l;
            loadedThumbnails = loadedThumbnails + 1;
            if (gridStatus != null && !gridStatus.isLoading())
            {
                onSceneLoaded();
                return;
            }
        }
    }

    public void trackOnCreate()
    {
        beginSession();
    }

    public void trackOnPause()
    {
        launchType = null;
        sessionStartTime = 0L;
    }

    public void trackOnResume()
    {
        boolean flag;
        if (!launchCompleted)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        beginSession();
        if (!flag && launchType == LaunchType.WARM)
        {
            launchType = LaunchType.FIRE;
        }
    }

}
