// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.amazon.client.metrics.AndroidMetricsFactoryImpl;
import com.amazon.client.metrics.ClickStreamMetricsEvent;
import com.amazon.client.metrics.DataPoint;
import com.amazon.client.metrics.DataPointType;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.MetricsException;
import com.amazon.client.metrics.MetricsFactory;
import com.amazon.client.metrics.clickstream.UsageInfo;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.Util;

public class WearableMetricHelper
{

    private static final boolean DEBUG = DebugSettings.isDebugEnabled();
    private static final String TAG = com/amazon/mShop/wearable/WearableMetricHelper.getSimpleName();
    private static WearableMetricHelper sInstance = null;
    final MetricsFactory mMetricsFactory;

    private WearableMetricHelper(Context context)
    {
        mMetricsFactory = AndroidMetricsFactoryImpl.getInstance(context);
    }

    public static WearableMetricHelper getInstance(Context context)
    {
        com/amazon/mShop/wearable/WearableMetricHelper;
        JVM INSTR monitorenter ;
        if (sInstance == null)
        {
            sInstance = new WearableMetricHelper(context);
        }
        context = sInstance;
        com/amazon/mShop/wearable/WearableMetricHelper;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public void addLatencyMetric(String s, String s1, double d)
    {
        if (DEBUG)
        {
            Log.d(TAG, (new StringBuilder()).append("addLatencyMetric :: sourceName").append(s).append(", timerName:").append(s1).append(", timerValue:").append(d).toString());
        }
        s = mMetricsFactory.createMetricEvent("MShopAndroidPhoneApp", s);
        s.addTimer(s1, d);
        mMetricsFactory.record(s);
    }

    public void emitClickStream(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, int i)
    {
        if (DEBUG)
        {
            Log.d(TAG, (new StringBuilder()).append("emitClickStream :: sourceName:").append(s).append(", pageType:").append(s1).append(", pageTypeID").append(s2).append(", subPageType:").append(s3).append(", hitType").append(s4).append(", pageAction:").append(s5).append(", counterName").append(s6).append(", refTag:").append(s7).append(", count:").append(i).toString());
        }
        s = mMetricsFactory.createClickStreamMetricEvent("MShopAndroidPhoneApp", s);
        s4 = new UsageInfo(s1, s4, "mobile-sensory", "wear");
        if (User.getUser() != null)
        {
            s4.setIsPrimeCustomer(User.getUser().isPrime());
        }
        s4.setPageAction(s5);
        s4.setPageTypeID(s2);
        s4.setSubPageType(s3);
        s.setUsageInfo(s4);
        try
        {
            if (!TextUtils.isEmpty(s7))
            {
                s.addDataPoint(new DataPoint("ref-override", s7, 1, DataPointType.CK));
            }
            if (s1.toLowerCase().contains("detail") || s1.toLowerCase().contains("addedasintowl"))
            {
                s.addDataPoint(new DataPoint("is-glance-view", "Y", 1, DataPointType.CK));
                s.addDataPoint(new DataPoint("page-type-id-source", "ASIN", 1, DataPointType.CK));
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.e(TAG, "Metric exception thrown while trying to add datapoint to clickStream", s1);
        }
        s.addCounter(s6, i);
        mMetricsFactory.record(s);
    }

    public void incrementPMETCounter(String s, String s1, int i)
    {
        if (DEBUG)
        {
            Log.d(TAG, (new StringBuilder()).append("incrementPMETCounter:: sourceName:").append(s).append(", counterName:").append(s1).append(", count:").append(i).toString());
        }
        s = mMetricsFactory.createMetricEvent("MShopAndroidPhoneApp", s);
        s.incrementCounter(s1, i);
        mMetricsFactory.record(s);
    }

    public void logRefMarker(String s)
    {
        if (DEBUG)
        {
            Log.d(TAG, (new StringBuilder()).append("logRefmarker:: ").append(s).toString());
        }
        if (!Util.isEmpty(s))
        {
            RefMarkerObserver.logRefMarker(s);
        }
    }

}
