// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.amazon.client.metrics.AndroidMetricsFactoryImpl;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.MetricsFactory;
import com.amazon.client.metrics.NullMetricsFactory;
import com.amazon.retailsearch.android.api.init.DebugMode;
import com.amazon.retailsearch.android.api.init.RetailSearchInitSettings;
import com.amazon.retailsearch.android.api.init.RetailSearchInitializer;
import com.amazon.retailsearch.debug.RetailSearchDebug;
import com.amazon.retailsearch.deviceinfo.DeviceProfile;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.searchapp.retailsearch.client.SearchParameterName;
import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import com.amazon.searchapp.retailsearch.client.web.ServiceCall;
import com.amazon.searchapp.retailsearch.client.web.UrlMaker;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.net.ssl.SSLException;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;

// Referenced classes of package com.amazon.retailsearch.metrics:
//            StringName, MetricName, SourceName, RetailSearchLoggingConfig

public abstract class BaseAbstractDCMLogger
{

    private static final String INVALID_ANDROID_ID = "9774d56d682e549c";
    private static final int MAX_STACK_TRACE_SIZE = 16384;
    private static final List NETWORK_EXCEPTIONS = Arrays.asList(new Class[] {
        java/io/EOFException, java/net/SocketException, java/io/InterruptedIOException, java/net/UnknownHostException, javax/net/ssl/SSLException, org/apache/http/client/ClientProtocolException, org/apache/http/MalformedChunkCodingException, org/apache/http/NoHttpResponseException
    });
    protected static final String TAG = com/amazon/retailsearch/metrics/BaseAbstractDCMLogger.getSimpleName();
    private static final String UTF8_ENCODING = "UTF-8";
    protected static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/metrics/BaseAbstractDCMLogger);
    protected final String appVersion;
    protected RetailSearchLoggingConfig config;
    protected Context context;
    protected MetricsFactory metricsFactory;

    public BaseAbstractDCMLogger(Context context1, RetailSearchLoggingConfig retailsearchloggingconfig)
    {
        context = context1;
        config = retailsearchloggingconfig;
        retailsearchloggingconfig = RetailSearchInitializer.getInstance().getSettings();
        if (retailsearchloggingconfig != null && retailsearchloggingconfig.getAppVersion() != null)
        {
            appVersion = (new StringBuilder()).append(Locale.getDefault().toString()).append('-').append(retailsearchloggingconfig.getAppVersion()).toString();
        } else
        {
            appVersion = "Unknown";
        }
        init(context1);
    }

    private void addDeviceInfo(MetricEvent metricevent)
    {
        if (!TextUtils.isEmpty(Build.MODEL))
        {
            metricevent.addString(StringName.DeviceModel.name(), Build.MODEL);
        }
        if (!TextUtils.isEmpty(android.os.Build.VERSION.RELEASE))
        {
            metricevent.addString(StringName.OsVersion.name(), android.os.Build.VERSION.RELEASE);
        }
        if (!TextUtils.isEmpty(Build.MANUFACTURER))
        {
            metricevent.addString(StringName.Manufacturer.name(), Build.MANUFACTURER);
        }
        if (!TextUtils.isEmpty(Build.PRODUCT))
        {
            metricevent.addString(StringName.BuildProduct.name(), Build.PRODUCT);
        }
        if (!TextUtils.isEmpty(Build.FINGERPRINT))
        {
            metricevent.addString(StringName.BuildFingerprint.name(), Build.FINGERPRINT);
        }
        String s = DeviceProfile.getSerial();
        if (!TextUtils.isEmpty(s))
        {
            metricevent.addString(StringName.SerialNumber.name(), s);
        }
        s = DeviceProfile.getAndroidId(context.getContentResolver());
        if (!TextUtils.isEmpty(s) && !"9774d56d682e549c".equals(s))
        {
            metricevent.addString(StringName.AndroidId.name(), s);
        }
        String s1 = DeviceProfile.getNetworkOperatorName(context);
        if (!TextUtils.isEmpty(s1))
        {
            metricevent.addString(StringName.NetworkName.name(), s1);
        }
_L2:
        return;
        metricevent;
        if (!DebugMode.enabled()) goto _L2; else goto _L1
_L1:
        Log.e(TAG, "Telephony info error", metricevent);
        return;
        metricevent;
        if (DebugMode.enabled())
        {
            Log.e(TAG, "Error", metricevent);
            return;
        }
          goto _L2
    }

    private void addExceptionInfo(MetricEvent metricevent, Throwable throwable)
    {
        if (throwable != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        s = throwable.getClass().getCanonicalName();
        if (!TextUtils.isEmpty(s))
        {
            metricevent.addString(StringName.ExceptionName.name(), s);
        }
        s = throwable.getMessage();
        if (!TextUtils.isEmpty(s))
        {
            metricevent.addString(StringName.ExceptionMessage.name(), s);
        }
        s = getStackTraceAsString(throwable);
        if (!TextUtils.isEmpty(s))
        {
            throwable = s;
            try
            {
                if (s.length() > 16384)
                {
                    throwable = s.substring(0, 16384);
                }
                metricevent.addString(StringName.StackTrace.name(), throwable);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (MetricEvent metricevent) { }
            if (DebugMode.enabled())
            {
                Log.e(TAG, "Error", metricevent);
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private String getStackTraceAsString(Throwable throwable)
    {
        if (throwable == null)
        {
            return "";
        } else
        {
            StringWriter stringwriter = new StringWriter();
            throwable.printStackTrace(new PrintWriter(stringwriter));
            return stringwriter.toString();
        }
    }

    private void init(Context context1)
    {
        metricsFactory = (MetricsFactory)context1.getSystemService("com.amazon.client.metrics.api");
        if (metricsFactory == null)
        {
            metricsFactory = AndroidMetricsFactoryImpl.getInstance(context1);
        }
_L1:
        return;
        context1;
        metricsFactory = new NullMetricsFactory();
        if (DebugMode.enabled())
        {
            Log.e(TAG, "Could not instantiate DCM metrics logger", context1);
            return;
        }
          goto _L1
    }

    private String toLines(CollectionMap collectionmap)
    {
        if (collectionmap == null)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        collectionmap = collectionmap.entrySet().iterator();
        do
        {
            if (!collectionmap.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)collectionmap.next();
            if (entry.getKey() != null && entry.getValue() != null)
            {
                Iterator iterator = ((List)entry.getValue()).iterator();
                while (iterator.hasNext()) 
                {
                    String s = (String)iterator.next();
                    stringbuilder.append((String)entry.getKey()).append(": ").append(s).append('\n');
                }
            }
        } while (true);
        return stringbuilder.toString();
    }

    private String toQueryString(CollectionMap collectionmap)
        throws UnsupportedEncodingException
    {
        if (collectionmap == null)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        for (collectionmap = collectionmap.entrySet().iterator(); collectionmap.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)collectionmap.next();
            if (entry.getKey() != null && entry.getValue() != null)
            {
                Iterator iterator = ((List)entry.getValue()).iterator();
                while (iterator.hasNext()) 
                {
                    String s = (String)iterator.next();
                    if (stringbuilder.length() > 0)
                    {
                        stringbuilder.append('&');
                    }
                    stringbuilder.append(URLEncoder.encode((String)entry.getKey(), "UTF-8"));
                    if (s != null)
                    {
                        stringbuilder.append('=').append(URLEncoder.encode(s, "UTF-8"));
                    }
                }
            }
        }

        return stringbuilder.toString();
    }

    protected void addAppVersionInfo(MetricEvent metricevent)
    {
        if (metricevent != null)
        {
            metricevent.addString(MetricName.MarketAppVersion.name(), appVersion);
        }
    }

    protected void addEventInfo(MetricEvent metricevent, String s, Throwable throwable)
    {
        if (!TextUtils.isEmpty(s))
        {
            metricevent.addString(StringName.Message.name(), s);
        }
        addDeviceInfo(metricevent);
        addExceptionInfo(metricevent, throwable);
_L1:
        return;
        metricevent;
        if (DebugMode.enabled())
        {
            Log.e(TAG, "Error", metricevent);
            return;
        }
          goto _L1
    }

    protected void addServiceCallInfo(MetricEvent metricevent, ServiceCall servicecall)
    {
        if (servicecall != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        obj = servicecall.getMethod();
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            metricevent.addString(StringName.RequestMethod.name(), ((String) (obj)));
        }
        obj = servicecall.getRequestUrl();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        obj = ((UrlMaker) (obj)).build();
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            metricevent.addString(StringName.RequestUrl.name(), ((String) (obj)));
        }
        obj = servicecall.getParameters();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        String s = toQueryString(((CollectionMap) (obj)));
        if (!TextUtils.isEmpty(s))
        {
            metricevent.addString(StringName.RequestParameters.name(), s);
        }
        obj = (String)((CollectionMap) (obj)).get(SearchParameterName.CLIENT_REQUEST_ID.getName());
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            metricevent.addString(StringName.ClientRequestId.name(), ((String) (obj)));
        }
        servicecall = servicecall.getHeaders();
        if (servicecall != null)
        {
            try
            {
                servicecall = toLines(servicecall);
                if (!TextUtils.isEmpty(servicecall))
                {
                    metricevent.addString(StringName.RequestHeaders.name(), servicecall);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (MetricEvent metricevent)
            {
                if (DebugMode.enabled())
                {
                    Log.e(TAG, "Error", metricevent);
                    return;
                }
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected MetricEvent getConcurrentMetricEvent(String s, SourceName sourcename)
    {
        if (TextUtils.isEmpty(s) || sourcename == null)
        {
            return null;
        } else
        {
            s = metricsFactory.createConcurrentMetricEvent(s, sourcename.name());
            addAppVersionInfo(s);
            return s;
        }
    }

    protected String getErrorMetric(Throwable throwable)
    {
        if (throwable == null)
        {
            return MetricName.Error.name();
        }
        if (throwable instanceof JsonProcessingException)
        {
            return MetricName.JsonError.name();
        }
        for (Iterator iterator = NETWORK_EXCEPTIONS.iterator(); iterator.hasNext();)
        {
            if (((Class)iterator.next()).isInstance(throwable))
            {
                return MetricName.NetworkError.name();
            }
        }

        return MetricName.Error.name();
    }

    protected MetricEvent getMetricEvent(String s, SourceName sourcename)
    {
        if (TextUtils.isEmpty(s) || sourcename == null)
        {
            return null;
        } else
        {
            s = metricsFactory.createMetricEvent(s, sourcename.name());
            addAppVersionInfo(s);
            return s;
        }
    }

    protected void recordCounter(MetricEvent metricevent, String s, int i)
    {
        if (metricevent == null || TextUtils.isEmpty(s))
        {
            return;
        } else
        {
            metricevent.addCounter(s, i);
            RetailSearchDebug.logMetricEvent(metricevent);
            metricsFactory.record(metricevent);
            return;
        }
    }

}
