// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.metric.PlatformMetricsCollector;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Tracer
{

    private static final String TAG = com/amazon/identity/auth/device/framework/Tracer.getName();
    private static final AtomicInteger TRACE_ID_COUNTER = new AtomicInteger(0);
    private final String mApiName;
    private final int mCallingUid;
    private PlatformMetricsCollector mCollector;
    private long mStartTime;
    private final int mTraceId;

    private Tracer(int i, String s, int j)
    {
        mStartTime = System.nanoTime();
        mTraceId = i;
        mApiName = s;
        mCallingUid = j;
        mCollector = MetricsHelper.getNewCollector(mApiName);
        s = TAG;
        i = mTraceId;
        s = mApiName;
    }

    private Tracer(String s)
    {
        this(getNewTraceId(), s, Binder.getCallingUid());
    }

    public static Tracer createFromIntent(Intent intent, String s)
    {
        if (intent == null)
        {
            return new Tracer(s);
        }
        int i = intent.getIntExtra("traceId", getNewTraceId());
        String s1 = intent.getStringExtra("apiName");
        int j = intent.getIntExtra("callingUid", -1);
        if (TextUtils.isEmpty(s1))
        {
            intent = TAG;
            (new StringBuilder("There is no tracer info in intent, creating tracer using new traceId and defaultApiName, traceId:")).append(i).append(" apiName:").append(s).toString();
            return new Tracer(i, s, j);
        } else
        {
            intent = TAG;
            (new StringBuilder("Creating Tracer from intent, traceId:")).append(i).append(" apiName:").append(s1).toString();
            return new Tracer(i, s1, j);
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
        if (bundle == null)
        {
            return;
        } else
        {
            bundle.putInt("traceId", mTraceId);
            bundle.putString("apiName", mApiName);
            return;
        }
    }

    public void addToIntent(Intent intent)
    {
        if (intent == null)
        {
            return;
        } else
        {
            intent.putExtra("traceId", mTraceId);
            intent.putExtra("apiName", mApiName);
            return;
        }
    }

    public void finishTrace()
    {
        mCollector.recordEvent();
    }

    public String getPackageToBlame(Context context)
    {
        String s;
        String s1;
        s1 = "unknown";
        s = s1;
        if (mCallingUid == -1)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        context = context.getPackageManager().getPackagesForUid(mCallingUid);
        s = s1;
        if (context != null)
        {
            try
            {
                s = Arrays.toString(context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                MAPLog.w(TAG, (new StringBuilder("Couldn't get packages for uid ")).append(mCallingUid).toString(), context);
                return "unknown";
            }
        }
        return s;
    }

    public void incrementCounter(String s)
    {
        String s1 = TAG;
        (new StringBuilder("Incrementing counter. Name:")).append(s).toString();
        mCollector.incrementCounter(s);
    }

    public void incrementCounter(String s, double d)
    {
        String s1 = TAG;
        (new StringBuilder("Incrementing counter. Name:")).append(s).append(" Count:").append(d).toString();
        mCollector.incrementCounter(s, d);
    }

    public PlatformMetricsTimer startTimer(String s)
    {
        s = mCollector.createTimer(s);
        s.start();
        return s;
    }

}
