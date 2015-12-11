// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics.eventbuilder;

import android.os.Build;
import com.amazon.analytics.AnalyticsConfiguration;
import com.amazon.analytics.AnalyticsConfigurationInitializer;
import com.amazon.analytics.session.PriorityQueue;
import com.amazon.analytics.util.Preconditions;
import com.amazon.android.dagger.DaggerAndroid;
import com.amazon.device.analytics.events.Event;
import com.amazon.device.analytics.events.EventRecorder;
import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import com.amazon.device.analytics.util.StringUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public abstract class AnalyticsEventBuilder
    implements AnalyticsBuilderInterfaces.AppAsinView, AnalyticsBuilderInterfaces.AppVersionView, AnalyticsBuilderInterfaces.BaseAnalyticsBuilder, AnalyticsBuilderInterfaces.ContentIdView, AnalyticsBuilderInterfaces.FinallyRecord, AnalyticsBuilderInterfaces.MASVersionView, AnalyticsBuilderInterfaces.MarketplaceIdView, AnalyticsBuilderInterfaces.PackageNameView, AnalyticsBuilderInterfaces.TimestampView
{
    public static class InjectPoint
    {

        private static final InjectPoint injectPoint = new InjectPoint();
        AnalyticsConfiguration config;
        ScheduledExecutorService execService;
        AnalyticsConfigurationInitializer initializer;
        PriorityQueue queue;
        EventRecorder recorder;

        public static void inject(AnalyticsEventBuilder analyticseventbuilder)
        {
            DaggerAndroid.inject(injectPoint);
            analyticseventbuilder.initializer = injectPoint.initializer;
            analyticseventbuilder.recorder = injectPoint.recorder;
            analyticseventbuilder.config = injectPoint.config;
            analyticseventbuilder.queue = injectPoint.queue;
            analyticseventbuilder.execService = injectPoint.execService;
        }


        public InjectPoint()
        {
        }
    }


    private static final Map eventTypeMapping;
    private static final Logger logger = Logging.getLogger(com/amazon/analytics/eventbuilder/AnalyticsEventBuilder);
    String appAsin;
    String appVersion;
    AnalyticsConfiguration config;
    String contentId;
    ExecutorService execService;
    AnalyticsConfigurationInitializer initializer;
    String marketplaceId;
    String masVersion;
    String packageName;
    PriorityQueue queue;
    EventRecorder recorder;
    long timestamp;

    public AnalyticsEventBuilder()
    {
    }

    abstract String getType();

    void processEvent(Event event)
    {
        recorder.recordEvent(event);
        logger.d((new StringBuilder()).append("EventRecorder recording event with type ").append(getType()).toString());
    }

    public final void record()
    {
        InjectPoint.inject(this);
        if (!config.getBoolean(com.amazon.analytics.AnalyticsConfiguration.Setting.Enabled) && !"TRUE".equalsIgnoreCase(StringUtil.getSysProp("tailwind.enable")))
        {
            logger.w("Global switch is off, don't use any event collection");
            return;
        }
        if (config.getCommaDelimitedStringList(com.amazon.analytics.AnalyticsConfiguration.Setting.NeverCollectForPackageNames).contains(packageName))
        {
            logger.w((new StringBuilder()).append("Not collecting event for blacklisted package ").append(packageName).toString());
            return;
        } else
        {
            initializer.init();
            final Event event = recorder.createEvent((String)eventTypeMapping.get(getClass()));
            setupEventAttributesAndMetrics(event);
            execService.execute(new Runnable() {

                final AnalyticsEventBuilder this$0;
                final Event val$event;

                public void run()
                {
                    processEvent(event);
                }

            
            {
                this$0 = AnalyticsEventBuilder.this;
                event = event1;
                super();
            }
            });
            return;
        }
    }

    void setupEventAttributesAndMetrics(Event event)
    {
        event.addAttribute("os", android.os.Build.VERSION.CODENAME);
        event.addAttribute("ov", android.os.Build.VERSION.RELEASE);
        event.addAttribute("mo", Build.MODEL);
        event.addAttribute("bo", Build.BOARD);
        event.addAttribute("br", Build.BRAND);
        event.addAttribute("ma", Build.MANUFACTURER);
        event.addAttribute("cp", Build.CPU_ABI);
        event.addAttribute("pr", Build.PRODUCT);
        event.addAttribute("pn", packageName);
        event.addAttribute("masver", masVersion);
        event.addAttribute("aa", appAsin);
        event.addAttribute("av", appVersion);
        event.addAttribute("ci", contentId);
        event.addAttribute("mp", marketplaceId);
        event.addMetric("TimeStamp", Long.valueOf(timestamp));
    }

    public AnalyticsBuilderInterfaces.AppVersionView withAppAsin(String s)
    {
        appAsin = (String)Preconditions.checkNotNull(s);
        return this;
    }

    public AnalyticsBuilderInterfaces.ContentIdView withAppVersion(String s)
    {
        appVersion = (String)Preconditions.checkNotNull(s);
        return this;
    }

    public AnalyticsBuilderInterfaces.MarketplaceIdView withContentId(String s)
    {
        contentId = (String)Preconditions.checkNotNull(s);
        return this;
    }

    public AnalyticsBuilderInterfaces.AppAsinView withMASVersion(String s)
    {
        masVersion = (String)Preconditions.checkNotNull(s);
        return this;
    }

    public AnalyticsBuilderInterfaces.TimestampView withMarketplaceId(String s)
    {
        marketplaceId = (String)Preconditions.checkNotNull(s);
        return this;
    }

    public AnalyticsBuilderInterfaces.MASVersionView withPackageName(String s)
    {
        packageName = (String)Preconditions.checkNotNull(s);
        return this;
    }

    public AnalyticsBuilderInterfaces.FinallyRecord withTimestamp(long l)
    {
        timestamp = l;
        return this;
    }

    static 
    {
        HashMap hashmap = new HashMap();
        hashmap.put(com/amazon/analytics/eventbuilder/InstallEventTypeBuilder$InstallBuilder, "com.amazon.developer.app.install");
        hashmap.put(com/amazon/analytics/eventbuilder/InstallEventTypeBuilder$UninstallBuilder, "com.amazon.developer.app.uninstall");
        hashmap.put(com/amazon/analytics/eventbuilder/InstallEventTypeBuilder$UpgradeBuilder, "com.amazon.developer.app.upgrade");
        hashmap.put(com/amazon/analytics/eventbuilder/IAPEventTypeBuilder$IAPBuilder, "com.amazon.developer.app.iap");
        hashmap.put(com/amazon/analytics/eventbuilder/SessionEventTypeBuilder$OnResumeBuilder, "com.amazon.analytics.session.start");
        hashmap.put(com/amazon/analytics/eventbuilder/SessionEventTypeBuilder$OnPauseBuilder, "com.amazon.analytics.session.stop");
        eventTypeMapping = Collections.unmodifiableMap(hashmap);
    }
}
