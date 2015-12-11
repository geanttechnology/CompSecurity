// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics;

import android.app.ActivityManager;
import android.content.Context;
import com.amazon.analytics.session.PackageSessionBuilder;
import com.amazon.analytics.session.PriorityQueue;
import com.amazon.analytics.session.SessionObserver;
import com.amazon.device.analytics.AnalyticsClient;
import com.amazon.device.analytics.events.EventRecorder;
import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import com.amazon.mas.client.featureconfig.FeatureConfigLocator;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

// Referenced classes of package com.amazon.analytics:
//            TailwindActivityManagerImpl, AnalyticsConfigurationImpl, AnalyticsConfigurationInitializer, TailwindActivityManager, 
//            AnalyticsConfiguration

public class TailwindModule
{

    private static final String API_VERSION = "ver";
    private static final String API_VERSION_VALUE = "v2.0";
    private static final String MAS_APPLICATION_KEY = "MasApplicationKey";
    private static final Logger logger = Logging.getLogger(com/amazon/analytics/TailwindModule);
    private Class tailwindAcitivtyClazz;

    public TailwindModule()
    {
        tailwindAcitivtyClazz = com/amazon/analytics/TailwindActivityManagerImpl;
    }

    AnalyticsConfiguration getAnalyticsConfiguration(AnalyticsConfigurationImpl analyticsconfigurationimpl)
    {
        return analyticsconfigurationimpl;
    }

    AnalyticsConfigurationImpl getAnalyticsConfigurationImpl(FeatureConfigLocator featureconfiglocator)
    {
        return new AnalyticsConfigurationImpl(featureconfiglocator);
    }

    AnalyticsConfigurationInitializer getAnalyticsConfigurationInitializer(Context context, TailwindActivityManager tailwindactivitymanager, AnalyticsConfiguration analyticsconfiguration, PriorityQueue priorityqueue, PackageSessionBuilder packagesessionbuilder, ScheduledExecutorService scheduledexecutorservice)
    {
        return new AnalyticsConfigurationInitializer(context, tailwindactivitymanager, analyticsconfiguration, priorityqueue, packagesessionbuilder, scheduledexecutorservice);
    }

    EventRecorder getEventRecorder(Context context, AnalyticsConfigurationImpl analyticsconfigurationimpl)
    {
        context = AnalyticsClient.newInstance(context, analyticsconfigurationimpl.getUnderlyingConfig()).newEventRecorder("MasApplicationKey");
        context.addGlobalAttribute("ver", "v2.0");
        return context;
    }

    PackageSessionBuilder getPackageSessionBuilder()
    {
        return new PackageSessionBuilder();
    }

    PriorityQueue getPriorityQueue(SessionObserver sessionobserver, AnalyticsConfiguration analyticsconfiguration)
    {
        return new PriorityQueue(sessionobserver, analyticsconfiguration);
    }

    ScheduledExecutorService getScheduledExecutorService()
    {
        return Executors.newSingleThreadScheduledExecutor();
    }

    SessionObserver getSessionObserver(EventRecorder eventrecorder, PackageSessionBuilder packagesessionbuilder)
    {
        return new SessionObserver(eventrecorder, packagesessionbuilder);
    }

    TailwindActivityManager getTailwindActivityManager(ActivityManager activitymanager)
    {
        TailwindActivityManager tailwindactivitymanager;
        try
        {
            tailwindactivitymanager = (TailwindActivityManager)tailwindAcitivtyClazz.getConstructor(new Class[] {
                android/app/ActivityManager
            }).newInstance(new Object[] {
                activitymanager
            });
        }
        catch (Exception exception)
        {
            logger.w("Tailwind activity manager impl class does not have right constructor signature, using default", exception);
            return new TailwindActivityManagerImpl(activitymanager);
        }
        return tailwindactivitymanager;
    }

    public void setTailwindActivityManagerClass(Class class1)
    {
        tailwindAcitivtyClazz = class1;
    }

}
