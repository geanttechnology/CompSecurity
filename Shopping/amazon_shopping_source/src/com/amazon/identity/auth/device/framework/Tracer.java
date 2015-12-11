// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.metric.PlatformMetricsCollector;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import java.util.concurrent.atomic.AtomicInteger;

public class Tracer
{

    public static final String KEY_API_NAME = "apiName";
    public static final String KEY_TRACE_ID = "traceId";
    private static final String TAG = com/amazon/identity/auth/device/framework/Tracer.getName();
    private static final AtomicInteger TRACE_ID_COUNTER = new AtomicInteger(0);
    private final String mApiName;
    private PlatformMetricsCollector mCollector;
    private long mStartTime;
    private final int mTraceId;

    private Tracer(int i, String s)
    {
        mStartTime = System.nanoTime();
        mTraceId = i;
        mApiName = s;
        mCollector = MetricsHelper.getNewCollector(mApiName);
        s = TAG;
        i = mTraceId;
        s = mApiName;
    }

    private Tracer(String s)
    {
        this(getNewTraceId(), s);
    }

    public static Tracer createFromBundle(Bundle bundle, String s)
    {
        if (bundle == null)
        {
            return new Tracer(s);
        }
        int i = bundle.getInt("traceId", getNewTraceId());
        bundle = bundle.getString("apiName");
        if (TextUtils.isEmpty(bundle))
        {
            return new Tracer(i, s);
        } else
        {
            return new Tracer(i, bundle);
        }
    }

    public static Tracer createFromIntent(Intent intent, String s)
    {
        if (intent == null)
        {
            return new Tracer(s);
        }
        int i = intent.getIntExtra("traceId", getNewTraceId());
        intent = intent.getStringExtra("apiName");
        if (TextUtils.isEmpty(intent))
        {
            intent = TAG;
            (new StringBuilder("There is no tracer info in intent, creating tracer using new traceId and defaultApiName, traceId:")).append(i).append(" apiName:").append(s).toString();
            return new Tracer(i, s);
        } else
        {
            s = TAG;
            (new StringBuilder("Creating Tracer from intent, traceId:")).append(i).append(" apiName:").append(intent).toString();
            return new Tracer(i, intent);
        }
    }

    private static int getNewTraceId()
    {
        return TRACE_ID_COUNTER.incrementAndGet() % 1000 + Process.myPid() * 1000;
    }

    public static Tracer getNewTracer(String s)
    {
        return new Tracer(s);
    }

    public void addToBundle(Bundle bundle)
    {
        bundle.putInt("traceId", mTraceId);
        bundle.putString("apiName", mApiName);
    }

    public void addToIntent(Intent intent)
    {
        intent.putExtra("traceId", mTraceId);
        intent.putExtra("apiName", mApiName);
    }

    public void addTracePoint(String s)
    {
        long l = (System.nanoTime() - mStartTime) / 0xf4240L;
        s = TAG;
        int i = mTraceId;
    }

    public void finishTrace()
    {
        mCollector.recordEvent();
    }

    public String getAPIName()
    {
        return mApiName;
    }

    public PlatformMetricsTimer getTimer(String s)
    {
        return mCollector.createTimer(s);
    }

    public int getTraceId()
    {
        return mTraceId;
    }

    public void incrementCounter(String s)
    {
        String s1 = TAG;
        (new StringBuilder("increase MAP incrementCounter:")).append(s).toString();
        mCollector.incrementCounter(s);
    }

    public void incrementCounter(String s, double d)
    {
        mCollector.incrementCounter(s, d);
    }

    void setCollector(PlatformMetricsCollector platformmetricscollector)
    {
        mCollector = platformmetricscollector;
    }

    public PlatformMetricsTimer startTimer(String s)
    {
        s = mCollector.createTimer(s);
        s.start();
        return s;
    }

}
