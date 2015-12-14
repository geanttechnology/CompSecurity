// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.metrics;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.metrics.Timer;
import com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper;
import com.amazon.gallery.framework.gallery.view.NoOpViewStateListener;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.metrics.customer.CustomerMetricsHelper;
import java.util.concurrent.TimeUnit;

public class SessionMetrics extends NoOpViewStateListener
{
    public static final class MetricEvent extends Enum
    {

        private static final MetricEvent $VALUES[];
        public static final MetricEvent ActiveTime;
        public static final MetricEvent SessionStart;
        public static final MetricEvent SessionStop;
        public static final MetricEvent ViewedCollections;
        public static final MetricEvent ViewedItems;

        public static MetricEvent valueOf(String s)
        {
            return (MetricEvent)Enum.valueOf(com/amazon/gallery/framework/gallery/metrics/SessionMetrics$MetricEvent, s);
        }

        public static MetricEvent[] values()
        {
            return (MetricEvent[])$VALUES.clone();
        }

        static 
        {
            ActiveTime = new MetricEvent("ActiveTime", 0);
            ViewedCollections = new MetricEvent("ViewedCollections", 1);
            ViewedItems = new MetricEvent("ViewedItems", 2);
            SessionStart = new MetricEvent("SessionStart", 3);
            SessionStop = new MetricEvent("SessionStop", 4);
            $VALUES = (new MetricEvent[] {
                ActiveTime, ViewedCollections, ViewedItems, SessionStart, SessionStop
            });
        }

        private MetricEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private static final Object ALL_ITEMS_OBJECT = new Object();
    private static final long SESSION_EXPIRE;
    private static final String TAG = com/amazon/gallery/framework/gallery/metrics/SessionMetrics.getName();
    private final AmazonInsightsHelper amazonInsightsHelper;
    private Object collectionId;
    private final Context context;
    private int focusedIndex;
    private final Profiler rootProfiler;
    private final ComponentProfiler sessionProfiler;
    private Timer sessionTimer;

    public SessionMetrics(Context context1, Profiler profiler, AmazonInsightsHelper amazoninsightshelper)
    {
        context = context1;
        rootProfiler = profiler;
        sessionProfiler = new ComponentProfiler(profiler, com/amazon/gallery/framework/gallery/metrics/SessionMetrics);
        amazonInsightsHelper = amazoninsightshelper;
    }

    private Object getCollectionId(ViewDescriptor viewdescriptor)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType = new int[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.CUSTOM_DATA_SET.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.MEDIA_PROPERTY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.TAG.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.DYNAMIC_ALBUM.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.MEDIA_TYPE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.EVERYTHING.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType[viewdescriptor.getCollectionType().ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown collection type").append(viewdescriptor.getCollectionType()).toString());

        case 1: // '\001'
            return viewdescriptor.getCustomDataSet();

        case 2: // '\002'
            return viewdescriptor.getMediaProperty();

        case 3: // '\003'
        case 4: // '\004'
            return viewdescriptor.getTag();

        case 5: // '\005'
            return viewdescriptor.getMediaType();

        case 6: // '\006'
            return ALL_ITEMS_OBJECT;
        }
    }

    public void endSession()
    {
        if (sessionTimer != null)
        {
            sessionTimer.stop();
            sessionTimer = null;
        }
        saveSessionStopData(System.currentTimeMillis());
        rootProfiler.endSession();
        amazonInsightsHelper.pauseSession();
        amazonInsightsHelper.submitEvents();
    }

    protected long getSessionStopData()
    {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("lastSessionStopTime", -1L);
    }

    public boolean isSessionStarted()
    {
        return sessionTimer != null;
    }

    public void onFocusedGained(ViewDescriptor viewdescriptor)
    {
        Object obj = getCollectionId(viewdescriptor);
        if (collectionId == obj && focusedIndex != viewdescriptor.getFocusedIndex())
        {
            focusedIndex = viewdescriptor.getFocusedIndex();
            sessionProfiler.trackEvent(MetricEvent.ViewedItems);
        }
    }

    public void onViewStateChange(ViewDescriptor viewdescriptor, boolean flag)
    {
        if (flag)
        {
            Object obj = getCollectionId(viewdescriptor);
            if (collectionId != obj)
            {
                collectionId = obj;
                focusedIndex = -1;
                sessionProfiler.trackEvent(MetricEvent.ViewedCollections, CustomerMetricsHelper.getExtraEventTag(viewdescriptor.getCollectionSize()));
            }
        }
    }

    protected void saveSessionStopData(long l)
    {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("lastSessionStopTime", l).apply();
    }

    public void startSession()
    {
        long l;
        long l1;
        rootProfiler.startSession();
        sessionTimer = sessionProfiler.newTimer(MetricEvent.ActiveTime);
        sessionTimer.start();
        l = getSessionStopData();
        l1 = System.currentTimeMillis();
        if (l != -1L) goto _L2; else goto _L1
_L1:
        sessionProfiler.trackEvent(MetricEvent.SessionStart, CustomerMetricsHelper.getExtraDateTime(l1));
_L4:
        amazonInsightsHelper.resumeSession();
        return;
_L2:
        if (l1 - l > SESSION_EXPIRE)
        {
            sessionProfiler.trackEvent(MetricEvent.SessionStop, CustomerMetricsHelper.getExtraDateTime(l));
            sessionProfiler.trackEvent(MetricEvent.SessionStart, CustomerMetricsHelper.getExtraDateTime(l1));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        SESSION_EXPIRE = TimeUnit.MINUTES.toMillis(2L);
    }
}
