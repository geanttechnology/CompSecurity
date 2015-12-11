// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.analytics;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;

// Referenced classes of package com.comcast.cim.cmasl.analytics:
//            AnalyticsTaskQueue, AnalyticsTask, AnalyticsServiceConfiguration

public abstract class AnalyticsService extends Service
    implements AnalyticsTask.Callback
{

    private int consecutiveFailures;
    private long postAfterTime;
    private boolean running;

    public AnalyticsService()
    {
        postAfterTime = 0L;
        consecutiveFailures = 0;
    }

    private boolean deviceIsCharging()
    {
        Intent intent = registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int i;
        if (intent != null)
        {
            i = intent.getIntExtra("status", 1);
        } else
        {
            i = 1;
        }
        return i == 2 || i == 5;
    }

    private boolean hasFastInternetAccess()
    {
        return getInternetConnection().isConnectedOnWiFi() || getInternetConnection().isConnectedOnHighspeedMobile();
    }

    private boolean notInFailureBackoffTimePeriod()
    {
        return System.currentTimeMillis() > postAfterTime;
    }

    private void sendAnalytics()
    {
        if (running)
        {
            return;
        }
        AnalyticsTask analyticstask = (AnalyticsTask)getAnalyticsTaskQueue().peek();
        if (shouldRunNow() && analyticstask != null)
        {
            running = true;
            analyticstask.execute(this);
            return;
        } else
        {
            stopSelf();
            return;
        }
    }

    private boolean shouldRunNow()
    {
        return notInFailureBackoffTimePeriod() && (hasFastInternetAccess() || deviceIsCharging());
    }

    protected abstract AnalyticsTaskQueue getAnalyticsTaskQueue();

    protected abstract InternetConnection getInternetConnection();

    protected abstract AnalyticsServiceConfiguration getServiceConfiguration();

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onFailure()
    {
        if (((AnalyticsTask)getAnalyticsTaskQueue().peek()).getFailureCount() > getServiceConfiguration().getMaxTaskFailures())
        {
            getAnalyticsTaskQueue().remove();
        }
        running = false;
        consecutiveFailures = consecutiveFailures + 1;
        postAfterTime = System.currentTimeMillis() + getServiceConfiguration().getDelayAfterError() * (long)consecutiveFailures;
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        sendAnalytics();
        return 1;
    }

    public void onSuccess()
    {
        consecutiveFailures = 0;
        running = false;
        getAnalyticsTaskQueue().remove();
        sendAnalytics();
    }
}
