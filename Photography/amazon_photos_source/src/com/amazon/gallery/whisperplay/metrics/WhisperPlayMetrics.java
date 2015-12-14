// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.whisperplay.metrics;

import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Timer;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WhisperPlayMetrics extends ComponentProfiler
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent WPConnectionStatusFail;
        public static final MetricsEvent WPConnectionStatusNoDevice;
        public static final MetricsEvent WPConnectionStatusNoPermission;
        public static final MetricsEvent WPConnectionStatusSuccess;
        public static final MetricsEvent WPConnectionStatusTimeOut;
        public static final MetricsEvent WPDeleteAction;
        public static final MetricsEvent WPDeviceConnectionMessageDismissed;
        public static final MetricsEvent WPDeviceConnectionMessageDisplayed;
        public static final MetricsEvent WPDeviceOptionTapped;
        public static final MetricsEvent WPDownloadAction;
        public static final MetricsEvent WPEditAction;
        public static final MetricsEvent WPEndConnection;
        public static final MetricsEvent WPFirstTimeIconShown;
        public static final MetricsEvent WPInfoAction;
        public static final MetricsEvent WPInitiateConnection;
        public static final MetricsEvent WPLeftPanelOpened;
        public static final MetricsEvent WPLoopTapped;
        public static final MetricsEvent WPPhotoFlungBySlideshow;
        public static final MetricsEvent WPPhotoFlungManually;
        public static final MetricsEvent WPPrintAction;
        public static final MetricsEvent WPShareAction;
        public static final MetricsEvent WPShuffleTapped;
        public static final MetricsEvent WPSlideshowPaused;
        public static final MetricsEvent WPSlideshowStarted;
        public static final MetricsEvent WPStartedInVideosContainer;
        public static final MetricsEvent WPUploadAction;
        public static final MetricsEvent WPVideoFlungBySlideshow;
        public static final MetricsEvent WPVideoFlungManually;
        public static final MetricsEvent WPVideoPauseAfterManualFling;
        public static final MetricsEvent WPVideoPlayAfterManualFling;
        public static final MetricsEvent WPVideoSeekAfterManualFling;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/whisperplay/metrics/WhisperPlayMetrics$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            WPFirstTimeIconShown = new MetricsEvent("WPFirstTimeIconShown", 0);
            WPInitiateConnection = new MetricsEvent("WPInitiateConnection", 1);
            WPEndConnection = new MetricsEvent("WPEndConnection", 2);
            WPDeviceConnectionMessageDisplayed = new MetricsEvent("WPDeviceConnectionMessageDisplayed", 3);
            WPDeviceOptionTapped = new MetricsEvent("WPDeviceOptionTapped", 4);
            WPDeviceConnectionMessageDismissed = new MetricsEvent("WPDeviceConnectionMessageDismissed", 5);
            WPConnectionStatusNoDevice = new MetricsEvent("WPConnectionStatusNoDevice", 6);
            WPConnectionStatusSuccess = new MetricsEvent("WPConnectionStatusSuccess", 7);
            WPConnectionStatusFail = new MetricsEvent("WPConnectionStatusFail", 8);
            WPConnectionStatusTimeOut = new MetricsEvent("WPConnectionStatusTimeOut", 9);
            WPConnectionStatusNoPermission = new MetricsEvent("WPConnectionStatusNoPermission", 10);
            WPPhotoFlungManually = new MetricsEvent("WPPhotoFlungManually", 11);
            WPVideoFlungManually = new MetricsEvent("WPVideoFlungManually", 12);
            WPPhotoFlungBySlideshow = new MetricsEvent("WPPhotoFlungBySlideshow", 13);
            WPVideoFlungBySlideshow = new MetricsEvent("WPVideoFlungBySlideshow", 14);
            WPVideoPlayAfterManualFling = new MetricsEvent("WPVideoPlayAfterManualFling", 15);
            WPVideoPauseAfterManualFling = new MetricsEvent("WPVideoPauseAfterManualFling", 16);
            WPVideoSeekAfterManualFling = new MetricsEvent("WPVideoSeekAfterManualFling", 17);
            WPSlideshowStarted = new MetricsEvent("WPSlideshowStarted", 18);
            WPSlideshowPaused = new MetricsEvent("WPSlideshowPaused", 19);
            WPLeftPanelOpened = new MetricsEvent("WPLeftPanelOpened", 20);
            WPStartedInVideosContainer = new MetricsEvent("WPStartedInVideosContainer", 21);
            WPShuffleTapped = new MetricsEvent("WPShuffleTapped", 22);
            WPLoopTapped = new MetricsEvent("WPLoopTapped", 23);
            WPShareAction = new MetricsEvent("WPShareAction", 24);
            WPDeleteAction = new MetricsEvent("WPDeleteAction", 25);
            WPEditAction = new MetricsEvent("WPEditAction", 26);
            WPDownloadAction = new MetricsEvent("WPDownloadAction", 27);
            WPUploadAction = new MetricsEvent("WPUploadAction", 28);
            WPPrintAction = new MetricsEvent("WPPrintAction", 29);
            WPInfoAction = new MetricsEvent("WPInfoAction", 30);
            $VALUES = (new MetricsEvent[] {
                WPFirstTimeIconShown, WPInitiateConnection, WPEndConnection, WPDeviceConnectionMessageDisplayed, WPDeviceOptionTapped, WPDeviceConnectionMessageDismissed, WPConnectionStatusNoDevice, WPConnectionStatusSuccess, WPConnectionStatusFail, WPConnectionStatusTimeOut, 
                WPConnectionStatusNoPermission, WPPhotoFlungManually, WPVideoFlungManually, WPPhotoFlungBySlideshow, WPVideoFlungBySlideshow, WPVideoPlayAfterManualFling, WPVideoPauseAfterManualFling, WPVideoSeekAfterManualFling, WPSlideshowStarted, WPSlideshowPaused, 
                WPLeftPanelOpened, WPStartedInVideosContainer, WPShuffleTapped, WPLoopTapped, WPShareAction, WPDeleteAction, WPEditAction, WPDownloadAction, WPUploadAction, WPPrintAction, 
                WPInfoAction
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private Timer timer;

    public Timer newTimer(Enum enum, Map map)
    {
        stopTimer();
        timer = super.newTimer(enum, map);
        String s;
        for (enum = map.keySet().iterator(); enum.hasNext(); timer.addExtra(s, (String)map.get(s)))
        {
            s = (String)enum.next();
        }

        return timer;
    }

    public void stopTimer()
    {
        if (timer != null)
        {
            timer.stop();
            timer = null;
        }
    }
}
