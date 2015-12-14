// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.platform.metric;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.RegistrationType;
import com.amazon.identity.auth.device.framework.SystemPropertiesWrapper;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.UnitTestUtils;

// Referenced classes of package com.amazon.identity.platform.metric:
//            PlatformLoggingMetricsCollector, PlatformDCPMetricsCollector, PlatformMetricsCollector, PlatformMetricsTimer

public final class MetricsHelper
{

    private static final String TAG = com/amazon/identity/auth/device/framework/Tracer.getName();
    private static final boolean VERBOSE_METRICS_ENABLED = "yes".equals((new SystemPropertiesWrapper()).get("com.amazon.map.verbose.metrics"));
    private static Context sContext;
    private static PlatformMetricsCollector sMetricsCollector = null;
    private static volatile Boolean sSupportsDcpMetrics = null;

    public static PlatformMetricsCollector getMetricsCollectorInstance(Context context)
    {
        com/amazon/identity/platform/metric/MetricsHelper;
        JVM INSTR monitorenter ;
        if (sMetricsCollector == null) goto _L2; else goto _L1
_L1:
        context = sMetricsCollector;
_L4:
        com/amazon/identity/platform/metric/MetricsHelper;
        JVM INSTR monitorexit ;
        return context;
_L2:
        if (!UnitTestUtils.isRunningInUnitTest())
        {
            break; /* Loop/switch isn't completed */
        }
        MAPLog.i(TAG, "Running in unit test, creating logging metrics collector");
        sMetricsCollector = new PlatformLoggingMetricsCollector("UnitTest");
_L5:
        context = sMetricsCollector;
        if (true) goto _L4; else goto _L3
_L3:
        if (!supportClientMetrics() || context == null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        String s = TAG;
        sMetricsCollector = new PlatformDCPMetricsCollector(context);
          goto _L5
        context;
        throw context;
        context = TAG;
        sMetricsCollector = new PlatformLoggingMetricsCollector(null);
          goto _L5
    }

    public static PlatformMetricsCollector getNewCollector(String s)
    {
        com/amazon/identity/platform/metric/MetricsHelper;
        JVM INSTR monitorenter ;
        if (sContext == null || !supportClientMetrics()) goto _L2; else goto _L1
_L1:
        String s1 = TAG;
        s = new PlatformDCPMetricsCollector(sContext, s);
_L4:
        com/amazon/identity/platform/metric/MetricsHelper;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = TAG;
        s = new PlatformLoggingMetricsCollector(null);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public static String getRegType(RegistrationType registrationtype)
    {
        if (registrationtype == null)
        {
            return "NullRegType";
        } else
        {
            return registrationtype.name();
        }
    }

    public static transient void incrementCounter(String s, String as[])
    {
        PlatformMetricsCollector platformmetricscollector = getMetricsCollectorInstance(sContext);
        if (platformmetricscollector == null)
        {
            return;
        } else
        {
            platformmetricscollector.incrementCounter(s, as);
            return;
        }
    }

    public static void init(Context context)
    {
        sContext = context.getApplicationContext();
    }

    public static PlatformMetricsTimer startTimer(String s, String s1)
    {
        s = (new StringBuilder()).append(s).append("_").append(s1).toString();
        s1 = getMetricsCollectorInstance(sContext);
        if (s1 != null)
        {
            s = s1.createTimer(s);
        } else
        {
            s = new PlatformMetricsTimer.FakeMetricsTimer(s);
        }
        s.start();
        return s;
    }

    public static PlatformMetricsTimer startVerboseTimer(String s, String s1)
    {
        if (VERBOSE_METRICS_ENABLED)
        {
            return startTimer(s, s1);
        } else
        {
            return new PlatformMetricsTimer.FakeMetricsTimer(s1);
        }
    }

    public static boolean supportClientMetrics()
    {
        Object obj;
        Object obj1;
        Boolean boolean1;
        obj = sSupportsDcpMetrics;
        if (obj != null)
        {
            return ((Boolean) (obj)).booleanValue();
        }
        boolean1 = Boolean.valueOf(false);
        obj = boolean1;
        obj1 = boolean1;
        Class.forName("com.amazon.client.metrics.AndroidMetricsFactoryImpl");
        obj = boolean1;
        obj1 = boolean1;
        Class.forName("com.amazon.client.metrics.MetricsFactory").getMethod("createConcurrentMetricEvent", new Class[] {
            java/lang/String, java/lang/String
        });
        obj = boolean1;
        obj1 = boolean1;
        boolean1 = Boolean.valueOf(true);
        obj = boolean1;
        obj1 = boolean1;
        String s = TAG;
        obj = boolean1;
_L2:
        sSupportsDcpMetrics = ((Boolean) (obj));
        return ((Boolean) (obj)).booleanValue();
        obj1;
        obj1 = TAG;
        continue; /* Loop/switch isn't completed */
        NoSuchMethodException nosuchmethodexception;
        nosuchmethodexception;
        nosuchmethodexception = TAG;
        nosuchmethodexception = ((NoSuchMethodException) (obj1));
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Callback wrapCallback(Tracer tracer, PlatformMetricsTimer platformmetricstimer, Callback callback)
    {
        return wrapCallback(tracer, platformmetricstimer, callback, false);
    }

    public static Callback wrapCallback(Tracer tracer, PlatformMetricsTimer platformmetricstimer, Callback callback, boolean flag)
    {
        return new Callback(platformmetricstimer, tracer, flag, callback) {

            final boolean val$addSuccessCounter;
            final Callback val$callback;
            final PlatformMetricsTimer val$timer;
            final Tracer val$tracer;

            public void onError(Bundle bundle)
            {
                if (timer != null)
                {
                    timer.stop();
                }
                if (tracer != null)
                {
                    tracer.finishTrace();
                }
                if (callback != null)
                {
                    callback.onError(bundle);
                }
            }

            public void onSuccess(Bundle bundle)
            {
                if (timer != null)
                {
                    timer.stop();
                }
                if (tracer != null)
                {
                    if (addSuccessCounter)
                    {
                        tracer.incrementCounter("Success");
                    }
                    tracer.finishTrace();
                }
                if (callback != null)
                {
                    callback.onSuccess(bundle);
                }
            }

            
            {
                timer = platformmetricstimer;
                tracer = tracer1;
                addSuccessCounter = flag;
                callback = callback1;
                super();
            }
        };
    }

    public static Callback wrapCallback(PlatformMetricsTimer platformmetricstimer, Callback callback)
    {
        return new Callback(platformmetricstimer, callback) {

            final Callback val$callback;
            final PlatformMetricsTimer val$timer;

            public void onError(Bundle bundle)
            {
                timer.stop();
                if (callback != null)
                {
                    callback.onError(bundle);
                }
            }

            public void onSuccess(Bundle bundle)
            {
                timer.stop();
                if (callback != null)
                {
                    callback.onSuccess(bundle);
                }
            }

            
            {
                timer = platformmetricstimer;
                callback = callback1;
                super();
            }
        };
    }

}
