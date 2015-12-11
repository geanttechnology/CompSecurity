// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.creditcardreaderlibrary.metrics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import com.a9.creditcardreaderlibrary.helpers.ScreenSizeHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONObject;

public class MManager
{
    public static interface MetricUploadListener
    {

        public abstract void onError(String s);

        public abstract void onSuccess();
    }

    private static class MetricUploadTask extends AsyncTask
    {

        private MetricUploadListener m_metricUploadListener;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground(aobj);
        }

        protected transient HttpResponse doInBackground(Object aobj[])
        {
            try
            {
                Object obj = (JSONObject)aobj[0];
                m_metricUploadListener = (MetricUploadListener)aobj[1];
                Object obj1 = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(((org.apache.http.params.HttpParams) (obj1)), 3000);
                aobj = new ArrayList(1);
                ((List) (aobj)).add(new BasicNameValuePair("DATA", ((JSONObject) (obj)).toString()));
                obj = new DefaultHttpClient(((org.apache.http.params.HttpParams) (obj1)));
                obj1 = new HttpPost("https://eventlog-visualsearch.amazon.com/vsmetrics");
                ((HttpPost) (obj1)).setEntity(new UrlEncodedFormEntity(((List) (aobj))));
                aobj = ((HttpClient) (obj)).execute(((org.apache.http.client.methods.HttpUriRequest) (obj1)));
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                ((Exception) (aobj)).printStackTrace();
                return null;
            }
            return ((HttpResponse) (aobj));
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((HttpResponse)obj);
        }

        protected void onPostExecute(HttpResponse httpresponse)
        {
            MManager.onHttpResponseReceived(httpresponse, m_metricUploadListener);
            super.onPostExecute(httpresponse);
        }

        private MetricUploadTask()
        {
            m_metricUploadListener = null;
        }

    }


    private static String s_appVersion;
    private static Context s_context;
    private static HashMap s_countersMap = new HashMap();
    private static String s_deviceId;
    private static boolean s_isDryRun = false;
    private static String s_marketPlace = "1";
    private static String s_serviceName;
    private static long s_sessionEnd;
    private static long s_sessionStart;
    private static HashMap s_timingsMap = new HashMap();

    public MManager()
    {
    }

    private static void clearMaps()
    {
        s_timingsMap.clear();
        s_countersMap.clear();
    }

    private static JSONObject getBaseJSONObject()
        throws Exception
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("DEVICE_ID", s_deviceId);
        jsonobject.put("MODEL", Build.MODEL);
        jsonobject.put("PLATFORM_VERSION", (new StringBuilder()).append("").append(android.os.Build.VERSION.SDK_INT).toString());
        jsonobject.put("PLATFORM", "Android");
        jsonobject.put("Marketplace", s_marketPlace);
        jsonobject.put("APP_VERSION", s_appVersion);
        jsonobject.put("Program", s_serviceName);
        jsonobject.put("TIMESTAMP", System.currentTimeMillis());
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(s_serviceName).append(s_appVersion).append("MetricsProd").append("Android");
        stringbuilder.append("/");
        if (ScreenSizeHelper.isTabletDevice(s_context))
        {
            stringbuilder.append("Tablet");
        } else
        {
            stringbuilder.append("Phone");
        }
        jsonobject.put("Operation", stringbuilder.toString());
        jsonobject.put("Locale", getLocale());
        return jsonobject;
    }

    private static String getLocale()
    {
        String s;
        try
        {
            s = Locale.getDefault().toString();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return "";
        }
        return s;
    }

    private static double getSessionLength()
    {
        com/a9/creditcardreaderlibrary/metrics/MManager;
        JVM INSTR monitorenter ;
        long l = (s_sessionEnd - s_sessionStart) / 1000L;
        double d = l;
        com/a9/creditcardreaderlibrary/metrics/MManager;
        JVM INSTR monitorexit ;
        return d;
        Exception exception;
        exception;
        throw exception;
    }

    public static void init(Context context, String s, String s1, String s2)
    {
        s_deviceId = s;
        s_serviceName = s1;
        s_context = context;
        try
        {
            s_appVersion = s_context.getPackageManager().getPackageInfo(s_context.getPackageName(), 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        if (s2 != null)
        {
            s_marketPlace = s2;
        }
    }

    private static void onHttpResponseReceived(HttpResponse httpresponse, MetricUploadListener metricuploadlistener)
    {
        if (httpresponse != null)
        {
            httpresponse = httpresponse.getStatusLine();
            if (httpresponse.getStatusCode() == 200)
            {
                clearMaps();
                if (metricuploadlistener != null)
                {
                    metricuploadlistener.onSuccess();
                }
                return;
            } else
            {
                reportError(metricuploadlistener, httpresponse.getStatusCode(), httpresponse.getReasonPhrase());
                return;
            }
        } else
        {
            reportError(metricuploadlistener, -1, "No Network Connectivity");
            return;
        }
    }

    private static void reportError(MetricUploadListener metricuploadlistener, int i, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Error Code: ");
        stringbuilder.append(i);
        stringbuilder.append("\n");
        stringbuilder.append(s);
        if (metricuploadlistener != null)
        {
            metricuploadlistener.onError(s.toString());
        }
    }

    public static final void sendMetrics(String s, MetricUploadListener metricuploadlistener)
    {
        com/a9/creditcardreaderlibrary/metrics/MManager;
        JVM INSTR monitorenter ;
        boolean flag = s_isDryRun;
        if (!flag) goto _L2; else goto _L1
_L1:
        com/a9/creditcardreaderlibrary/metrics/MManager;
        JVM INSTR monitorexit ;
        return;
_L2:
        double d = getSessionLength();
        if (d <= 0.0D)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        setTimingMetric("CreditCard.camera.session.length", d);
        JSONObject jsonobject = getBaseJSONObject();
        jsonobject.put("SESSION_ID", s);
        jsonobject.put("counters", new JSONObject(s_countersMap));
        jsonobject.put("timing", new JSONObject(s_timingsMap));
        (new MetricUploadTask()).execute(new Object[] {
            jsonobject, metricuploadlistener
        });
        continue; /* Loop/switch isn't completed */
        s;
        s.printStackTrace();
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
    }

    public static final void setCounterMetric(String s, int i)
    {
        com/a9/creditcardreaderlibrary/metrics/MManager;
        JVM INSTR monitorenter ;
        s_countersMap.put(s, Integer.valueOf(i));
        com/a9/creditcardreaderlibrary/metrics/MManager;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public static final void setTimingMetric(String s, double d)
    {
        com/a9/creditcardreaderlibrary/metrics/MManager;
        JVM INSTR monitorenter ;
        s_timingsMap.put(s, Double.valueOf(d));
        com/a9/creditcardreaderlibrary/metrics/MManager;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public static final void startSession()
    {
        com/a9/creditcardreaderlibrary/metrics/MManager;
        JVM INSTR monitorenter ;
        s_sessionStart = System.currentTimeMillis();
        com/a9/creditcardreaderlibrary/metrics/MManager;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static final void stopSession()
    {
        com/a9/creditcardreaderlibrary/metrics/MManager;
        JVM INSTR monitorenter ;
        s_sessionEnd = System.currentTimeMillis();
        com/a9/creditcardreaderlibrary/metrics/MManager;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }


}
