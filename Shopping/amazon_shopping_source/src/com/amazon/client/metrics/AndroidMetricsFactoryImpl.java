// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import android.content.Context;
import com.amazon.client.metrics.configuration.MetricsConfiguration;
import com.amazon.client.metrics.transport.OAuthHelper;

// Referenced classes of package com.amazon.client.metrics:
//            AbstractMetricsFactoryImpl, GenericMetricsServiceAdapter, MetricsFactory, IMetricsService

public class AndroidMetricsFactoryImpl extends AbstractMetricsFactoryImpl
{

    private final Context mContext;

    private AndroidMetricsFactoryImpl(Context context)
    {
        mContext = context;
    }

    public static MetricsFactory getInstance(Context context)
    {
        com/amazon/client/metrics/AndroidMetricsFactoryImpl;
        JVM INSTR monitorenter ;
        if (sMetricsFactory == null)
        {
            sMetricsFactory = new AndroidMetricsFactoryImpl(context);
        }
        context = sMetricsFactory;
        com/amazon/client/metrics/AndroidMetricsFactoryImpl;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static void setCountryOfResidence(Context context, String s)
    {
        com/amazon/client/metrics/AndroidMetricsFactoryImpl;
        JVM INSTR monitorenter ;
        GenericMetricsServiceAdapter.getInstance(context).setCountryOfResidence(s);
        com/amazon/client/metrics/AndroidMetricsFactoryImpl;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public static void setDeviceId(Context context, String s)
    {
        com/amazon/client/metrics/AndroidMetricsFactoryImpl;
        JVM INSTR monitorenter ;
        GenericMetricsServiceAdapter.getInstance(context).setDeviceSerialNumber(s);
        com/amazon/client/metrics/AndroidMetricsFactoryImpl;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public static void setDeviceType(Context context, String s)
    {
        com/amazon/client/metrics/AndroidMetricsFactoryImpl;
        JVM INSTR monitorenter ;
        GenericMetricsServiceAdapter.getInstance(context).setDeviceType(s);
        com/amazon/client/metrics/AndroidMetricsFactoryImpl;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public static void setMetricsConfiguration(MetricsConfiguration metricsconfiguration)
    {
        com/amazon/client/metrics/AndroidMetricsFactoryImpl;
        JVM INSTR monitorenter ;
        GenericMetricsServiceAdapter.setMetricsConfiguration(metricsconfiguration);
        com/amazon/client/metrics/AndroidMetricsFactoryImpl;
        JVM INSTR monitorexit ;
        return;
        metricsconfiguration;
        throw metricsconfiguration;
    }

    public static void setOAuthHelper(Context context, OAuthHelper oauthhelper)
    {
        com/amazon/client/metrics/AndroidMetricsFactoryImpl;
        JVM INSTR monitorenter ;
        GenericMetricsServiceAdapter.getInstance(context).setOAuthHelper(oauthhelper);
        com/amazon/client/metrics/AndroidMetricsFactoryImpl;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public static void setPreferredMarketplace(Context context, String s)
    {
        com/amazon/client/metrics/AndroidMetricsFactoryImpl;
        JVM INSTR monitorenter ;
        GenericMetricsServiceAdapter.getInstance(context).setPreferredMarketplace(s);
        com/amazon/client/metrics/AndroidMetricsFactoryImpl;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public static void shutdown()
    {
        com/amazon/client/metrics/AndroidMetricsFactoryImpl;
        JVM INSTR monitorenter ;
        GenericMetricsServiceAdapter.shutdownInstance();
        sMetricsService = null;
        sMetricsFactory = null;
        com/amazon/client/metrics/AndroidMetricsFactoryImpl;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static void shutdown(Context context)
    {
        com/amazon/client/metrics/AndroidMetricsFactoryImpl;
        JVM INSTR monitorenter ;
        shutdown();
        com/amazon/client/metrics/AndroidMetricsFactoryImpl;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    protected IMetricsService getService()
    {
        if (sMetricsService == null)
        {
            sMetricsService = GenericMetricsServiceAdapter.getInstance(mContext).getMetricsService();
        }
        return sMetricsService;
    }

    public String getSessionID()
    {
        return "";
    }

    protected boolean shouldRecordMetrics()
    {
        return true;
    }
}
