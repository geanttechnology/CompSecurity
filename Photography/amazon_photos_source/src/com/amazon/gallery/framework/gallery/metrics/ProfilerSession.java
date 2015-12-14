// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.metrics;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.amazon.gallery.foundation.utils.log.GLogger;

// Referenced classes of package com.amazon.gallery.framework.gallery.metrics:
//            SessionMetrics, NavigationMetrics

public class ProfilerSession
    implements android.app.Application.ActivityLifecycleCallbacks
{

    public static final String TAG = com/amazon/gallery/framework/gallery/metrics/ProfilerSession.getName();
    private final Runnable endSession = new Runnable() {

        final ProfilerSession this$0;

        public void run()
        {
            if (startedActivities == 0)
            {
                if (navigationMetrics != null)
                {
                    navigationMetrics.stopAllTimers();
                }
                sessionMetrics.endSession();
            }
        }

            
            {
                this$0 = ProfilerSession.this;
                super();
            }
    };
    private int existingActivities;
    private final Handler handler = new Handler();
    private NavigationMetrics navigationMetrics;
    private SessionMetrics sessionMetrics;
    private int startedActivities;

    public ProfilerSession()
    {
        existingActivities = 0;
        startedActivities = 0;
    }

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
        existingActivities = existingActivities + 1;
        GLogger.v(TAG, "#onActivityCreated(%s), active:%d, existing:%d", new Object[] {
            activity.getClass().getSimpleName(), Integer.valueOf(startedActivities), Integer.valueOf(existingActivities)
        });
    }

    public void onActivityDestroyed(Activity activity)
    {
        existingActivities = existingActivities - 1;
        GLogger.v(TAG, "#onActivityDestroyed(%s), active:%d, existing:%d", new Object[] {
            activity.getClass().getSimpleName(), Integer.valueOf(startedActivities), Integer.valueOf(existingActivities)
        });
    }

    public void onActivityPaused(Activity activity)
    {
        GLogger.v(TAG, "#onActivityPaused(%s), active:%d, existing:%d", new Object[] {
            activity.getClass().getSimpleName(), Integer.valueOf(startedActivities), Integer.valueOf(existingActivities)
        });
    }

    public void onActivityResumed(Activity activity)
    {
        GLogger.v(TAG, "#onActivityResumed(%s), active:%d, existing:%d", new Object[] {
            activity.getClass().getSimpleName(), Integer.valueOf(startedActivities), Integer.valueOf(existingActivities)
        });
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
    }

    public void onActivityStarted(Activity activity)
    {
        startedActivities = startedActivities + 1;
        GLogger.v(TAG, "#onActivityStarted(%s), active:%d, existing:%d", new Object[] {
            activity.getClass().getSimpleName(), Integer.valueOf(startedActivities), Integer.valueOf(existingActivities)
        });
        if (startedActivities == 1 && !sessionMetrics.isSessionStarted())
        {
            sessionMetrics.startSession();
        }
    }

    public void onActivityStopped(Activity activity)
    {
        startedActivities = startedActivities - 1;
        GLogger.v(TAG, "#onActivityStopped(%s), active:%d, existing:%d", new Object[] {
            activity.getClass().getSimpleName(), Integer.valueOf(startedActivities), Integer.valueOf(existingActivities)
        });
        handler.removeCallbacks(endSession);
        handler.postDelayed(endSession, 3000L);
    }

    public void setNavigationMetrics(NavigationMetrics navigationmetrics)
    {
        navigationMetrics = navigationmetrics;
    }

    public void setSessionMetrics(SessionMetrics sessionmetrics)
    {
        sessionMetrics = sessionmetrics;
    }




}
