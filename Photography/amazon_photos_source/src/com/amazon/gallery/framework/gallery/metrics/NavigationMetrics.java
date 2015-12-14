// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.metrics;

import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.metrics.Timer;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.view.NoOpViewStateListener;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.metrics.clickstream.ClickstreamEventHelper;
import com.amazon.gallery.framework.metrics.clickstream.HitType;
import com.amazon.gallery.framework.model.media.MediaType;

public class NavigationMetrics extends NoOpViewStateListener
{
    public static final class MetricEvent extends Enum
    {

        private static final MetricEvent $VALUES[];
        public static final MetricEvent CameraLaunchedFromApp;
        public static final MetricEvent PhotoViewed;
        public static final MetricEvent ScreenRotation;
        public static final MetricEvent TimeInAll;
        public static final MetricEvent TimeInCameraRoll;
        public static final MetricEvent TimeInCloudCollection;
        public static final MetricEvent TimeInCloudDrive;
        public static final MetricEvent TimeInDevice;
        public static final MetricEvent TimeInDeviceCollection;
        public static final MetricEvent TimeInVideos;
        public static final MetricEvent TimeToLoadHighResolutionInSingle;
        public static final MetricEvent TimeToLoadScene;
        public static final MetricEvent VideoViewed;
        public static final MetricEvent ViewAdjacentPhoto;
        public static final MetricEvent ViewCollection;
        public static final MetricEvent ViewPhoto;

        public static MetricEvent valueOf(String s)
        {
            return (MetricEvent)Enum.valueOf(com/amazon/gallery/framework/gallery/metrics/NavigationMetrics$MetricEvent, s);
        }

        public static MetricEvent[] values()
        {
            return (MetricEvent[])$VALUES.clone();
        }

        static 
        {
            ViewCollection = new MetricEvent("ViewCollection", 0);
            ViewPhoto = new MetricEvent("ViewPhoto", 1);
            ViewAdjacentPhoto = new MetricEvent("ViewAdjacentPhoto", 2);
            ScreenRotation = new MetricEvent("ScreenRotation", 3);
            TimeInAll = new MetricEvent("TimeInAll", 4);
            TimeInVideos = new MetricEvent("TimeInVideos", 5);
            TimeInCameraRoll = new MetricEvent("TimeInCameraRoll", 6);
            TimeInDeviceCollection = new MetricEvent("TimeInDeviceCollection", 7);
            TimeInCloudCollection = new MetricEvent("TimeInCloudCollection", 8);
            TimeInCloudDrive = new MetricEvent("TimeInCloudDrive", 9);
            TimeInDevice = new MetricEvent("TimeInDevice", 10);
            PhotoViewed = new MetricEvent("PhotoViewed", 11);
            VideoViewed = new MetricEvent("VideoViewed", 12);
            CameraLaunchedFromApp = new MetricEvent("CameraLaunchedFromApp", 13);
            TimeToLoadHighResolutionInSingle = new MetricEvent("TimeToLoadHighResolutionInSingle", 14);
            TimeToLoadScene = new MetricEvent("TimeToLoadScene", 15);
            $VALUES = (new MetricEvent[] {
                ViewCollection, ViewPhoto, ViewAdjacentPhoto, ScreenRotation, TimeInAll, TimeInVideos, TimeInCameraRoll, TimeInDeviceCollection, TimeInCloudCollection, TimeInCloudDrive, 
                TimeInDevice, PhotoViewed, VideoViewed, CameraLaunchedFromApp, TimeToLoadHighResolutionInSingle, TimeToLoadScene
            });
        }

        private MetricEvent(String s, int i)
        {
            super(s, i);
        }
    }

    private static final class TimerType extends Enum
    {

        private static final TimerType $VALUES[];
        public static final TimerType COLLECTION_TIMER;
        public static final TimerType SINGLE_VIEW_TIMER;

        public static TimerType valueOf(String s)
        {
            return (TimerType)Enum.valueOf(com/amazon/gallery/framework/gallery/metrics/NavigationMetrics$TimerType, s);
        }

        public static TimerType[] values()
        {
            return (TimerType[])$VALUES.clone();
        }

        static 
        {
            SINGLE_VIEW_TIMER = new TimerType("SINGLE_VIEW_TIMER", 0);
            COLLECTION_TIMER = new TimerType("COLLECTION_TIMER", 1);
            $VALUES = (new TimerType[] {
                SINGLE_VIEW_TIMER, COLLECTION_TIMER
            });
        }

        private TimerType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/framework/gallery/metrics/NavigationMetrics.getName();
    private Timer collectionTimer;
    private com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType currentCollection;
    private ViewDescriptor lastViewDescriptor;
    private final ComponentProfiler profiler;
    private Timer sceneLoadTimer;
    private Timer singleViewTimer;
    private Timer timer;

    public NavigationMetrics(Profiler profiler1)
    {
        profiler = new ComponentProfiler(profiler1, com/amazon/gallery/framework/gallery/metrics/NavigationMetrics);
    }

    public void onFocusedGained(ViewDescriptor viewdescriptor)
    {
        lastViewDescriptor = viewdescriptor;
        if (viewdescriptor.getMediaItem() == null || viewdescriptor.getMediaItemType() == null) goto _L2; else goto _L1
_L1:
        currentCollection = null;
        stopAllTimers();
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$gallery$metrics$NavigationMetrics$TimerType[];
            static final int $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[];
            static final int $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$gallery$metrics$NavigationMetrics$TimerType = new int[TimerType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$metrics$NavigationMetrics$TimerType[TimerType.SINGLE_VIEW_TIMER.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$metrics$NavigationMetrics$TimerType[TimerType.COLLECTION_TIMER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                $SwitchMap$com$amazon$gallery$framework$model$media$MediaType = new int[MediaType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[MediaType.PHOTO.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[MediaType.VIDEO.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType = new int[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.EVERYTHING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.MEDIA_PROPERTY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.MEDIA_TYPE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.TAG.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.DYNAMIC_ALBUM.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.CUSTOM_DATA_SET.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.gallery.framework.model.media.MediaType[viewdescriptor.getMediaItemType().ordinal()];
        JVM INSTR tableswitch 1 2: default 60
    //                   1 61
    //                   2 72;
           goto _L2 _L3 _L4
_L2:
        return;
_L3:
        startTimerByType(TimerType.SINGLE_VIEW_TIMER, MetricEvent.PhotoViewed);
        return;
_L4:
        startTimerByType(TimerType.SINGLE_VIEW_TIMER, MetricEvent.VideoViewed);
        return;
    }

    public void onNavigateToCollection()
    {
        this;
        JVM INSTR monitorenter ;
        timer = profiler.newTimer(MetricEvent.ViewCollection);
        timer.start();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void onNavigateToTagType(MetricEvent metricevent)
    {
        this;
        JVM INSTR monitorenter ;
        stopAllTimers();
        currentCollection = null;
        collectionTimer = profiler.newTimer(metricevent);
        collectionTimer.start();
        this;
        JVM INSTR monitorexit ;
        return;
        metricevent;
        throw metricevent;
    }

    public void onViewStateChange(ViewDescriptor viewdescriptor, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        lastViewDescriptor = viewdescriptor;
        if (viewdescriptor.getMediaItem() == null) goto _L2; else goto _L1
_L1:
        timer = profiler.newTimer(MetricEvent.ViewPhoto);
        timer.start();
_L4:
        startSceneLoadTimer();
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        stopTimerByType(TimerType.SINGLE_VIEW_TIMER);
        if (viewdescriptor.getCollectionType() == currentCollection) goto _L4; else goto _L3
_L3:
        stopTimerByType(TimerType.COLLECTION_TIMER);
        currentCollection = viewdescriptor.getCollectionType();
        _cls1..SwitchMap.com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType[currentCollection.ordinal()];
        JVM INSTR tableswitch 1 5: default 201
    //                   1 124
    //                   2 142
    //                   3 155
    //                   4 168
    //                   5 168;
           goto _L4 _L5 _L6 _L7 _L8 _L8
_L5:
        startTimerByType(TimerType.COLLECTION_TIMER, MetricEvent.TimeInAll);
          goto _L4
        viewdescriptor;
        throw viewdescriptor;
_L6:
        startTimerByType(TimerType.COLLECTION_TIMER, MetricEvent.TimeInCameraRoll);
          goto _L4
_L7:
        startTimerByType(TimerType.COLLECTION_TIMER, MetricEvent.TimeInVideos);
          goto _L4
_L8:
        if (!viewdescriptor.inLocalCollection()) goto _L10; else goto _L9
_L9:
        startTimerByType(TimerType.COLLECTION_TIMER, MetricEvent.TimeInDeviceCollection);
          goto _L4
_L10:
        startTimerByType(TimerType.COLLECTION_TIMER, MetricEvent.TimeInCloudCollection);
          goto _L4
    }

    public void startSceneLoadTimer()
    {
        this;
        JVM INSTR monitorenter ;
        sceneLoadTimer = profiler.newTimer(MetricEvent.TimeToLoadScene);
        sceneLoadTimer.start();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void startTimerByType(TimerType timertype, MetricEvent metricevent)
    {
        this;
        JVM INSTR monitorenter ;
        int i = _cls1..SwitchMap.com.amazon.gallery.framework.gallery.metrics.NavigationMetrics.TimerType[timertype.ordinal()];
        i;
        JVM INSTR tableswitch 1 2: default 36
    //                   1 39
    //                   2 76;
           goto _L1 _L2 _L3
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        singleViewTimer = profiler.newTimer(metricevent, ClickstreamEventHelper.createClickstreamExtra("NavigationEvent", HitType.APP_ACTION));
        singleViewTimer.start();
          goto _L1
        timertype;
        throw timertype;
_L3:
        collectionTimer = profiler.newTimer(metricevent);
        collectionTimer.start();
          goto _L1
    }

    public void stopAllTimers()
    {
        stopTimerByType(TimerType.SINGLE_VIEW_TIMER);
        stopTimerByType(TimerType.COLLECTION_TIMER);
    }

    public void stopTimerByType(TimerType timertype)
    {
        this;
        JVM INSTR monitorenter ;
        int i = _cls1..SwitchMap.com.amazon.gallery.framework.gallery.metrics.NavigationMetrics.TimerType[timertype.ordinal()];
        i;
        JVM INSTR tableswitch 1 2: default 36
    //                   1 39
    //                   2 80;
           goto _L1 _L2 _L3
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (singleViewTimer == null) goto _L1; else goto _L4
_L4:
        GLogger.d(TAG, "Stopping single view timer!", new Object[0]);
        singleViewTimer.stop();
        singleViewTimer = null;
          goto _L1
        timertype;
        throw timertype;
_L3:
        if (collectionTimer == null) goto _L1; else goto _L5
_L5:
        GLogger.d(TAG, "Stopping collection timer!", new Object[0]);
        collectionTimer.stop();
        collectionTimer = null;
          goto _L1
    }

}
