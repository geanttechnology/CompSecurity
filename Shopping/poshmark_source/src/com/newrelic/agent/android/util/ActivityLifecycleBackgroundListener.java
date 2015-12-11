// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.util;

import android.app.Activity;
import android.os.Bundle;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.newrelic.agent.android.util:
//            UiBackgroundListener

public class ActivityLifecycleBackgroundListener extends UiBackgroundListener
    implements android.app.Application.ActivityLifecycleCallbacks
{

    private static final AgentLog log = AgentLogManager.getAgentLog();
    private AtomicBoolean isInBackground;

    public ActivityLifecycleBackgroundListener()
    {
        isInBackground = new AtomicBoolean(false);
    }

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
        log.info("ActivityLifecycleBackgroundListener.onActivityCreated");
        isInBackground.set(false);
    }

    public void onActivityDestroyed(Activity activity)
    {
        log.info("ActivityLifecycleBackgroundListener.onActivityDestroyed");
        isInBackground.set(false);
    }

    public void onActivityPaused(Activity activity)
    {
        if (isInBackground.compareAndSet(false, true))
        {
            activity = new Runnable() {

                final ActivityLifecycleBackgroundListener this$0;

                public void run()
                {
                    ActivityLifecycleBackgroundListener.log.debug("ActivityLifecycleBackgroundListener.onActivityPaused - notifying ApplicationStateMonitor");
                    ApplicationStateMonitor.getInstance().uiHidden();
                }

            
            {
                this$0 = ActivityLifecycleBackgroundListener.this;
                super();
            }
            };
            executor.submit(activity);
        }
    }

    public void onActivityResumed(Activity activity)
    {
        log.info("ActivityLifecycleBackgroundListener.onActivityResumed");
        if (isInBackground.getAndSet(false))
        {
            activity = new Runnable() {

                final ActivityLifecycleBackgroundListener this$0;

                public void run()
                {
                    ApplicationStateMonitor.getInstance().activityStarted();
                }

            
            {
                this$0 = ActivityLifecycleBackgroundListener.this;
                super();
            }
            };
            executor.submit(activity);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
    }

    public void onActivityStarted(Activity activity)
    {
        if (isInBackground.compareAndSet(true, false))
        {
            activity = new Runnable() {

                final ActivityLifecycleBackgroundListener this$0;

                public void run()
                {
                    ActivityLifecycleBackgroundListener.log.debug("ActivityLifecycleBackgroundListener.onActivityStarted - notifying ApplicationStateMonitor");
                    ApplicationStateMonitor.getInstance().activityStarted();
                }

            
            {
                this$0 = ActivityLifecycleBackgroundListener.this;
                super();
            }
            };
            executor.submit(activity);
        }
    }

    public void onActivityStopped(Activity activity)
    {
    }

    public void onTrimMemory(int i)
    {
        log.info((new StringBuilder()).append("ActivityLifecycleBackgroundListener.onTrimMemory level: ").append(i).toString());
        if (20 == i)
        {
            isInBackground.set(true);
        }
        super.onTrimMemory(i);
    }


}
