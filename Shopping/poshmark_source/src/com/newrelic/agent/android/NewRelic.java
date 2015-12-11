// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android;

import android.content.Context;
import android.text.TextUtils;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.logging.AndroidAgentLog;
import com.newrelic.agent.android.logging.NullAgentLog;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.newrelic.agent.android.metric.MetricUnit;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.tracing.TracingInactiveException;
import com.newrelic.agent.android.util.NetworkFailure;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

// Referenced classes of package com.newrelic.agent.android:
//            AgentConfiguration, TaskQueue, Measurements, FeatureFlag, 
//            Agent, AgentImpl, NullAgentImpl, AndroidAgentImpl

public class NewRelic
{

    private static final String DEFAULT_COLLECTOR_ADDR = "mobile-collector.newrelic.com";
    private static final String UNKNOWN_HTTP_REQUEST_TYPE = "unknown";
    private static final AgentConfiguration agentConfiguration = new AgentConfiguration();
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private static boolean started = false;
    private int logLevel;
    private boolean loggingEnabled;

    private NewRelic(String s)
    {
        loggingEnabled = true;
        logLevel = 3;
        agentConfiguration.setApplicationToken(s);
    }

    private static void _noticeHttpTransaction(String s, String s1, int i, long l, long l1, long l2, long l3, String s2, Map map, String s3)
    {
        checkEmpty(s, "noticeHttpTransaction: url must not be empty.");
        checkEmpty(s1, "noticeHttpTransaction: httpMethod must not be empty.");
        double d;
        try
        {
            new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("noticeHttpTransaction: URL is malformed: ").append(s).toString());
        }
        d = l1 - l;
        if (!checkNegative((int)d, "noticeHttpTransaction: the startTimeMs is later than the endTimeMs, resulting in a negative total time."))
        {
            TaskQueue.queue(new HttpTransactionMeasurement(s, s1, i, 0, l, d / 1000D, l2, l3, s3));
            if ((long)i >= 400L)
            {
                Measurements.addHttpError(s, s1, i, s2, map);
            }
        }
    }

    private static void checkEmpty(String s, String s1)
    {
        checkNull(s, s1);
        if (s.length() == 0)
        {
            throw new IllegalArgumentException(s1);
        } else
        {
            return;
        }
    }

    private static boolean checkNegative(int i, String s)
    {
        if (i < 0)
        {
            log.error(s);
            return true;
        } else
        {
            return false;
        }
    }

    private static void checkNull(Object obj, String s)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException(s);
        } else
        {
            return;
        }
    }

    public static void crashNow()
    {
        crashNow("This is a demonstration crash courtesy of New Relic");
    }

    public static void crashNow(String s)
    {
        throw new RuntimeException(s);
    }

    public static String currentSessionId()
    {
        return agentConfiguration.getSessionID();
    }

    public static void disableFeature(FeatureFlag featureflag)
    {
        FeatureFlag.disableFeature(featureflag);
    }

    public static void enableFeature(FeatureFlag featureflag)
    {
        FeatureFlag.enableFeature(featureflag);
    }

    public static void endInteraction(String s)
    {
        log.debug((new StringBuilder()).append("NewRelic.endInteraction invoked. id: ").append(s).toString());
        TraceMachine.endTrace(s);
    }

    public static boolean incrementAttribute(String s)
    {
        return AnalyticsControllerImpl.getInstance().incrementAttribute(s, 1.0F);
    }

    public static boolean incrementAttribute(String s, float f)
    {
        return AnalyticsControllerImpl.getInstance().incrementAttribute(s, f);
    }

    private boolean isInstrumented()
    {
        return true;
    }

    public static boolean isStarted()
    {
        return started;
    }

    public static void noticeHttpTransaction(String s, int i, long l, long l1, long l2, 
            long l3)
    {
        _noticeHttpTransaction(s, "unknown", i, l, l1, l2, l3, null, null, null);
    }

    public static void noticeHttpTransaction(String s, int i, long l, long l1, long l2, 
            long l3, String s1)
    {
        _noticeHttpTransaction(s, "unknown", i, l, l1, l2, l3, s1, null, null);
    }

    public static void noticeHttpTransaction(String s, int i, long l, long l1, long l2, 
            long l3, String s1, Map map)
    {
        _noticeHttpTransaction(s, "unknown", i, l, l1, l2, l3, s1, map, null);
    }

    public static void noticeHttpTransaction(String s, int i, long l, long l1, long l2, 
            long l3, String s1, Map map, String s2)
    {
        _noticeHttpTransaction(s, "unknown", i, l, l1, l2, l3, s1, map, s2);
    }

    public static void noticeHttpTransaction(String s, int i, long l, long l1, long l2, 
            long l3, String s1, Map map, URLConnection urlconnection)
    {
        noticeHttpTransaction(s, "unknown", i, l, l1, l2, l3, s1, map, urlconnection);
    }

    public static void noticeHttpTransaction(String s, int i, long l, long l1, long l2, 
            long l3, String s1, Map map, HttpResponse httpresponse)
    {
        noticeHttpTransaction(s, "unknown", i, l, l1, l2, l3, s1, map, httpresponse);
    }

    public static void noticeHttpTransaction(String s, String s1, int i, long l, long l1, long l2, long l3)
    {
        _noticeHttpTransaction(s, s1, i, l, l1, l2, l3, null, null, null);
    }

    public static void noticeHttpTransaction(String s, String s1, int i, long l, long l1, long l2, long l3, String s2)
    {
        _noticeHttpTransaction(s, s1, i, l, l1, l2, l3, s2, null, null);
    }

    public static void noticeHttpTransaction(String s, String s1, int i, long l, long l1, long l2, long l3, String s2, Map map)
    {
        _noticeHttpTransaction(s, s1, i, l, l1, l2, l3, s2, map, null);
    }

    public static void noticeHttpTransaction(String s, String s1, int i, long l, long l1, long l2, long l3, String s2, Map map, String s3)
    {
        _noticeHttpTransaction(s, s1, i, l, l1, l2, l3, s2, map, s3);
    }

    public static void noticeHttpTransaction(String s, String s1, int i, long l, long l1, long l2, long l3, String s2, Map map, URLConnection urlconnection)
    {
        if (urlconnection != null)
        {
            urlconnection = urlconnection.getHeaderField("X-NewRelic-ID");
            if (urlconnection != null && urlconnection.length() > 0)
            {
                _noticeHttpTransaction(s, s1, i, l, l1, l2, l3, s2, map, urlconnection);
                return;
            }
        }
        _noticeHttpTransaction(s, s1, i, l, l1, l2, l3, s2, map, null);
    }

    public static void noticeHttpTransaction(String s, String s1, int i, long l, long l1, long l2, long l3, String s2, Map map, HttpResponse httpresponse)
    {
        if (httpresponse != null)
        {
            httpresponse = httpresponse.getFirstHeader("X-NewRelic-ID");
            if (httpresponse != null && httpresponse.getValue() != null && httpresponse.getValue().length() > 0)
            {
                _noticeHttpTransaction(s, s1, i, l, l1, l2, l3, s2, map, httpresponse.getValue());
                return;
            }
        }
        _noticeHttpTransaction(s, s1, i, l, l1, l2, l3, s2, map, null);
    }

    public static void noticeNetworkFailure(String s, long l, long l1, NetworkFailure networkfailure)
    {
        noticeNetworkFailure(s, "unknown", l, l1, networkfailure);
    }

    public static void noticeNetworkFailure(String s, long l, long l1, Exception exception)
    {
        noticeNetworkFailure(s, "unknown", l, l1, exception);
    }

    public static void noticeNetworkFailure(String s, String s1, long l, long l1, NetworkFailure networkfailure)
    {
        noticeNetworkFailure(s, s1, l, l1, networkfailure, "");
    }

    public static void noticeNetworkFailure(String s, String s1, long l, long l1, NetworkFailure networkfailure, String s2)
    {
        float f = (float)(l1 - l) / 1000F;
        TransactionState transactionstate = new TransactionState();
        TransactionStateUtil.inspectAndInstrument(transactionstate, s, s1);
        transactionstate.setErrorCode(networkfailure.getErrorCode());
        s = transactionstate.end();
        s1 = new TreeMap();
        s1.put("content_length", "0");
        s1.put("content_type", "text/html");
        TaskQueue.queue(new HttpTransactionMeasurement(s.getUrl(), s.getHttpMethod(), s.getStatusCode(), s.getErrorCode(), l, f, s.getBytesSent(), s.getBytesReceived(), s.getAppData()));
        Measurements.addHttpError(s.getUrl(), s.getHttpMethod(), s.getStatusCode(), s2, s1);
    }

    public static void noticeNetworkFailure(String s, String s1, long l, long l1, Exception exception)
    {
        checkEmpty(s, "noticeHttpException: url must not be empty.");
        noticeNetworkFailure(s, s1, l, l1, NetworkFailure.exceptionToNetworkFailure(exception), exception.getMessage());
    }

    public static boolean recordEvent(String s, Map map)
    {
        return AnalyticsControllerImpl.getInstance().recordEvent(s, map);
    }

    public static void recordMetric(String s, String s1)
    {
        recordMetric(s, s1, 1.0D);
    }

    public static void recordMetric(String s, String s1, double d)
    {
        recordMetric(s, s1, 1, d, d, null, null);
    }

    public static void recordMetric(String s, String s1, int i, double d, double d1)
    {
        recordMetric(s, s1, i, d, d1, null, null);
    }

    public static void recordMetric(String s, String s1, int i, double d, double d1, MetricUnit metricunit, 
            MetricUnit metricunit1)
    {
        log.debug((new StringBuilder()).append("NewRelic.recordMeric invoked for name ").append(s).append(", category: ").append(s1).append(", count: ").append(i).append(", totalValue ").append(d).append(", exclusiveValue: ").append(d1).append(", countUnit: ").append(metricunit).append(", valueUnit: ").append(metricunit1).toString());
        checkNull(s1, "recordMetric: category must not be null. If no MetricCategory is applicable, use MetricCategory.NONE.");
        checkEmpty(s, "recordMetric: name must not be empty.");
        if (!checkNegative(i, "recordMetric: count must not be negative."))
        {
            Measurements.addCustomMetric(s, s1, i, d, d1, metricunit, metricunit1);
        }
    }

    public static boolean removeAllAttributes()
    {
        return AnalyticsControllerImpl.getInstance().removeAllAttributes();
    }

    public static boolean removeAttribute(String s)
    {
        return AnalyticsControllerImpl.getInstance().removeAttribute(s);
    }

    public static boolean setAttribute(String s, float f)
    {
        return AnalyticsControllerImpl.getInstance().setAttribute(s, f);
    }

    public static boolean setAttribute(String s, String s1)
    {
        return AnalyticsControllerImpl.getInstance().setAttribute(s, s1);
    }

    public static boolean setAttribute(String s, boolean flag)
    {
        return AnalyticsControllerImpl.getInstance().setAttribute(s, flag);
    }

    public static void setInteractionName(String s)
    {
        TraceMachine.setRootDisplayName(s);
    }

    public static void setMaxEventBufferTime(int i)
    {
        AnalyticsControllerImpl.getInstance().setMaxEventBufferTime(i);
    }

    public static void setMaxEventPoolSize(int i)
    {
        AnalyticsControllerImpl.getInstance().setMaxEventPoolSize(i);
    }

    public static void shutdown()
    {
        StatsEngine.get().inc("Supportability/AgentHealth/Deprecated/Shutdown");
        if (!started)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        Agent.getImpl().stop();
        Agent.setImpl(NullAgentImpl.instance);
        started = false;
        return;
        Exception exception;
        exception;
        Agent.setImpl(NullAgentImpl.instance);
        started = false;
        throw exception;
    }

    public static String startInteraction(Context context, String s)
    {
        checkNull(context, "startInteraction: context must be an Activity instance.");
        checkNull(s, "startInteraction: actionName must be an action/method name.");
        TraceMachine.startTracing((new StringBuilder()).append(context.getClass().getSimpleName()).append("#").append(s.replace("/", ".")).toString());
        try
        {
            context = TraceMachine.getActivityTrace().getId();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    public static String startInteraction(Context context, String s, boolean flag)
    {
        if (TraceMachine.isTracingActive() && !flag)
        {
            log.warning("startInteraction: An interaction is already being traced, and invalidateActiveTrace is false. This interaction will not be traced.");
            return null;
        } else
        {
            return startInteraction(context, s);
        }
    }

    public static String startInteraction(String s)
    {
        checkNull(s, "startInteraction: actionName must be an action/method name.");
        log.debug((new StringBuilder()).append("NewRelic.startInteraction invoked. actionName: ").append(s).toString());
        TraceMachine.startTracing(s.replace("/", "."), true);
        try
        {
            s = TraceMachine.getActivityTrace().getId();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static NewRelic withApplicationToken(String s)
    {
        return new NewRelic(s);
    }

    public void start(Context context)
    {
        if (started)
        {
            log.debug("NewRelic is already running.");
            return;
        }
        Object obj;
        if (!loggingEnabled)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        obj = new AndroidAgentLog();
_L1:
        AgentLogManager.setAgentLog(((AgentLog) (obj)));
        log.setLevel(logLevel);
        if (isInstrumented())
        {
            AndroidAgentImpl.init(context, agentConfiguration);
            started = true;
            return;
        }
        break MISSING_BLOCK_LABEL_93;
        try
        {
            obj = new NullAgentLog();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            log.error("Error occurred while starting the New Relic agent!", context);
            return;
        }
          goto _L1
        log.error("Failed to detect New Relic instrumentation.  Something likely went wrong during your build process and you should visit http://support.newrelic.com.");
        return;
    }

    public NewRelic usingCollectorAddress(String s)
    {
        agentConfiguration.setCollectorHost(s);
        return this;
    }

    public NewRelic usingCrashCollectorAddress(String s)
    {
        agentConfiguration.setCrashCollectorHost(s);
        return this;
    }

    public NewRelic usingSsl(boolean flag)
    {
        agentConfiguration.setUseSsl(flag);
        return this;
    }

    public NewRelic withAnalyticsEvents(boolean flag)
    {
        if (flag)
        {
            enableFeature(FeatureFlag.AnalyticsEvents);
            return this;
        } else
        {
            disableFeature(FeatureFlag.AnalyticsEvents);
            return this;
        }
    }

    public NewRelic withApplicationBuild(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            agentConfiguration.setCustomBuildIdentifier(s);
        }
        return this;
    }

    public NewRelic withApplicationVersion(String s)
    {
        if (s != null)
        {
            agentConfiguration.setCustomApplicationVersion(s);
        }
        return this;
    }

    public NewRelic withBuildIdentifier(String s)
    {
        StatsEngine.get().inc("Supportability/AgentHealth/Deprecated/WithBuildIdentifier");
        return withApplicationBuild(s);
    }

    public NewRelic withCrashReportingEnabled(boolean flag)
    {
        agentConfiguration.setReportCrashes(flag);
        if (flag)
        {
            enableFeature(FeatureFlag.CrashReporting);
            return this;
        } else
        {
            disableFeature(FeatureFlag.CrashReporting);
            return this;
        }
    }

    public NewRelic withHttpResponseBodyCaptureEnabled(boolean flag)
    {
        if (flag)
        {
            enableFeature(FeatureFlag.HttpResponseBodyCapture);
            return this;
        } else
        {
            disableFeature(FeatureFlag.HttpResponseBodyCapture);
            return this;
        }
    }

    public NewRelic withLocationServiceEnabled(boolean flag)
    {
        agentConfiguration.setUseLocationService(flag);
        return this;
    }

    public NewRelic withLogLevel(int i)
    {
        logLevel = i;
        return this;
    }

    public NewRelic withLoggingEnabled(boolean flag)
    {
        loggingEnabled = flag;
        return this;
    }

}
