// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.amazon.analytics.session.PackageSessionBuilder;
import com.amazon.analytics.session.PriorityQueue;
import com.amazon.analytics.session.poller.PackageCheckRunnable;
import com.amazon.analytics.session.poller.ScreenStateBroadcastReceiver;
import com.amazon.analytics.session.poller.ScreenStateMonitor;
import com.amazon.device.analytics.configuration.ConfigurationChangedListener;
import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.analytics:
//            AnalyticsConfiguration, TailwindActivityManager

public class AnalyticsConfigurationInitializer
{

    private static final Logger logger = Logging.getLogger(com/amazon/analytics/AnalyticsConfigurationInitializer);
    private final TailwindActivityManager activityManager;
    private final AnalyticsConfiguration config;
    private final Context context;
    private AtomicBoolean initialized;
    private final PriorityQueue queue;
    private final ScheduledExecutorService service;
    private final PackageSessionBuilder sessionBuilder;

    public AnalyticsConfigurationInitializer(Context context1, TailwindActivityManager tailwindactivitymanager, AnalyticsConfiguration analyticsconfiguration, PriorityQueue priorityqueue, PackageSessionBuilder packagesessionbuilder, ScheduledExecutorService scheduledexecutorservice)
    {
        initialized = new AtomicBoolean(false);
        context = context1;
        activityManager = tailwindactivitymanager;
        config = analyticsconfiguration;
        queue = priorityqueue;
        sessionBuilder = packagesessionbuilder;
        service = scheduledexecutorservice;
    }

    public void init()
    {
        if (initialized.compareAndSet(false, true))
        {
            logger.d("Initializing config");
            config.registerChangedListener(AnalyticsConfiguration.Setting.RunningProcessPollInterval.getKey(), new ConfigurationChangedListener() {

                BroadcastReceiver currentReceiver;
                final AnalyticsConfigurationInitializer this$0;

                public void onPropertyChanged(String s, Object obj)
                {
                    if (obj == null) goto _L2; else goto _L1
_L1:
                    int i;
                    try
                    {
                        i = Integer.parseInt(obj.toString());
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        AnalyticsConfigurationInitializer.logger.e("RunningProcessPollInterval is not a number", s);
                        return;
                    }
                    this;
                    JVM INSTR monitorenter ;
                    context.unregisterReceiver(currentReceiver);
                    currentReceiver = setUpPackageCheckMonitor(i);
                    this;
                    JVM INSTR monitorexit ;
_L2:
                    return;
                    s;
                    this;
                    JVM INSTR monitorexit ;
                    throw s;
                }

            
            {
                this$0 = AnalyticsConfigurationInitializer.this;
                super();
                currentReceiver = setUpPackageCheckMonitor(config.getInt(AnalyticsConfiguration.Setting.RunningProcessPollInterval));
            }
            });
        }
    }

    BroadcastReceiver setUpPackageCheckMonitor(int i)
    {
        Object obj = new PackageCheckRunnable(context, activityManager, queue, sessionBuilder);
        obj = new ScreenStateBroadcastReceiver(new ScreenStateMonitor(service, ((Runnable) (obj)), i));
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.SCREEN_ON");
        intentfilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(((BroadcastReceiver) (obj)), intentfilter);
        return ((BroadcastReceiver) (obj));
    }




}
