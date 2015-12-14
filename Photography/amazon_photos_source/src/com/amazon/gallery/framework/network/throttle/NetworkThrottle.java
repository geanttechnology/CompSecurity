// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.throttle;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.account.AccountChangeListener;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.cloudfront.CloudFrontConfig;
import com.amazon.gallery.framework.network.exceptions.NoNetworkException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class NetworkThrottle
    implements AccountChangeListener
{

    private static final String TAG = com/amazon/gallery/framework/network/throttle/NetworkThrottle.getName();
    private static final long THROTTLE_INTERVAL;
    private static final AtomicLong networkDelay = new AtomicLong(10L);
    private final CloudFrontConfig cloudFrontConfig;
    private final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
    private long lastRunMs;
    private final RestClient restClient;
    private final SharedPreferences sharedPreferences;
    private ScheduledFuture throttleFuture;
    private final Runnable throttleRunnable = new Runnable() {

        final NetworkThrottle this$0;

        public void run()
        {
            long l;
            l = ((Long)NetworkExecutor.getInstance().execute(restClient.getNetworkThrottleOperation(cloudFrontConfig))).longValue();
            l = validateDelay(l);
            lastRunMs = SystemClock.uptimeMillis();
            GLogger.v(NetworkThrottle.TAG, "Network delay last fetched %d", new Object[] {
                Long.valueOf(lastRunMs)
            });
_L1:
            sharedPreferences.edit().putLong("persisted_delay_key", l).apply();
            GLogger.d(NetworkThrottle.TAG, "Network delay updated, new delay is now %dms", new Object[] {
                Long.valueOf(l)
            });
            NetworkThrottle.networkDelay.set(l);
            return;
            Object obj;
            obj;
            GLogger.i(NetworkThrottle.TAG, "Unable to retrieve network throttle due to no network connection. Using default value.", new Object[0]);
            l = sharedPreferences.getLong("persisted_delay_key", 10L);
            lastRunMs = SystemClock.uptimeMillis();
            GLogger.v(NetworkThrottle.TAG, "Network delay last fetched %d", new Object[] {
                Long.valueOf(lastRunMs)
            });
              goto _L1
            obj;
            GLogger.wx(NetworkThrottle.TAG, "An unexpected error occurred retrieving updated network throttle, using default value", ((Throwable) (obj)));
            l = sharedPreferences.getLong("persisted_delay_key", 10L);
            lastRunMs = SystemClock.uptimeMillis();
            GLogger.v(NetworkThrottle.TAG, "Network delay last fetched %d", new Object[] {
                Long.valueOf(lastRunMs)
            });
              goto _L1
            obj;
            lastRunMs = SystemClock.uptimeMillis();
            GLogger.v(NetworkThrottle.TAG, "Network delay last fetched %d", new Object[] {
                Long.valueOf(lastRunMs)
            });
            throw obj;
        }

            
            {
                this$0 = NetworkThrottle.this;
                super();
            }
    };

    public NetworkThrottle(RestClient restclient, SharedPreferences sharedpreferences, CloudFrontConfig cloudfrontconfig)
    {
        lastRunMs = 0L;
        restClient = restclient;
        sharedPreferences = sharedpreferences;
        cloudFrontConfig = cloudfrontconfig;
    }

    public static long getNetworkDelay()
    {
        return networkDelay.get();
    }

    private long validateDelay(long l)
    {
        long l1;
        if (l < 0L)
        {
            l1 = sharedPreferences.getLong("persisted_delay_key", 10L);
        } else
        {
            l1 = l;
            if (l > 5000L)
            {
                return 5000L;
            }
        }
        return l1;
    }

    public void onAccountDeregistered()
    {
        stopThrottleThread();
    }

    public void onAccountRegistered()
    {
        startThrottleThread();
    }

    public void startThrottleThread()
    {
        long l = SystemClock.uptimeMillis() - lastRunMs;
        if (l > THROTTLE_INTERVAL && throttleFuture == null)
        {
            GLogger.v(TAG, "Throttle thread started with no delay", new Object[0]);
            throttleFuture = executor.scheduleAtFixedRate(throttleRunnable, 0L, THROTTLE_INTERVAL, TimeUnit.MILLISECONDS);
            return;
        } else
        {
            l = THROTTLE_INTERVAL - l;
            GLogger.v(TAG, "Throttle thread started with an initial delay of %dms", new Object[] {
                Long.valueOf(l)
            });
            throttleFuture = executor.scheduleAtFixedRate(throttleRunnable, l, THROTTLE_INTERVAL, TimeUnit.MILLISECONDS);
            return;
        }
    }

    public void stopThrottleThread()
    {
        GLogger.v(TAG, "Shutting down throttle thread immediately", new Object[0]);
        if (throttleFuture != null)
        {
            throttleFuture.cancel(true);
        }
        throttleFuture = null;
    }

    static 
    {
        THROTTLE_INTERVAL = TimeUnit.MINUTES.toMillis(15L);
    }








/*
    static long access$502(NetworkThrottle networkthrottle, long l)
    {
        networkthrottle.lastRunMs = l;
        return l;
    }

*/

}
