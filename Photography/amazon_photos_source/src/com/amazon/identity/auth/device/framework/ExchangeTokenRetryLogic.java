// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import android.text.TextUtils;
import com.amazon.identity.auth.device.utils.JSONHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.platform.metric.MetricUtils;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import java.io.IOException;
import java.net.HttpURLConnection;
import org.json.JSONException;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            RetryLogic, AuthEndpointErrorParser, Tracer

public class ExchangeTokenRetryLogic extends RetryLogic
{

    private static final String TAG = com/amazon/identity/auth/device/framework/ExchangeTokenRetryLogic.getName();
    private final AuthEndpointErrorParser mAuthEndpointErrorParser = new AuthEndpointErrorParser();
    private Context mContext;
    private int mNumberOfAttempts;

    public ExchangeTokenRetryLogic(Context context)
    {
        mNumberOfAttempts = 0;
        mContext = context;
    }

    public boolean shouldRetry(HttpURLConnection httpurlconnection, int i, Tracer tracer)
        throws IOException
    {
        java.net.URL url;
        int j;
        int k;
        mNumberOfAttempts = mNumberOfAttempts + 1;
        url = httpurlconnection.getURL();
        k = -1;
        j = k;
        PlatformMetricsTimer platformmetricstimer = tracer.startTimer(MetricUtils.getUrlPathAndDomain(url));
        j = k;
        k = httpurlconnection.getResponseCode();
        j = k;
        platformmetricstimer.stopClock();
        j = k;
        httpurlconnection = JSONHelpers.toJson(httpurlconnection);
        if (httpurlconnection != null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        j = k;
        MAPLog.e(TAG, "Malformatted exchange token json response detected. Should retry if still within retry limit.");
        return true;
        j = k;
        httpurlconnection = mAuthEndpointErrorParser.getServerErrorCode(httpurlconnection);
        j = k;
        if (!TextUtils.isEmpty(httpurlconnection)) goto _L2; else goto _L1
_L1:
        j = k;
        platformmetricstimer.setTimerName(MetricUtils.getUrlPathAndDomain(url, k));
_L4:
        j = k;
        platformmetricstimer.stop();
        j = k;
        if (isHTTP500ErrorCodeSeries(k))
        {
            break; /* Loop/switch isn't completed */
        }
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        j = k;
        tracer.incrementCounter(MetricUtils.getSuccessAfterRetryMetricName(url));
        j = k;
        RetryLogic.recordAvailability(mNumberOfAttempts, url, tracer);
        return false;
_L2:
        j = k;
        platformmetricstimer.setTimerName(MetricUtils.getUrlPathAndDomain(url, k, httpurlconnection));
        if (true) goto _L4; else goto _L3
        httpurlconnection;
        MAPLog.e(TAG, "IOException while calling exchange token endpoint. Will retry. Exception : ", httpurlconnection);
        if (!MetricUtils.isDeviceConnected(mContext))
        {
            mNumberOfAttempts = mNumberOfAttempts - 1;
        }
        tracer.incrementCounter(MetricUtils.getIOExceptionMetricName(url));
        tracer.incrementCounter(MetricUtils.getIOExceptionWithSubClassMetricName(url, httpurlconnection, mContext));
        return true;
        httpurlconnection;
        tracer.incrementCounter((new StringBuilder()).append(MetricUtils.getUrlPathAndDomain(url, j)).append(":JSONException").toString());
        MAPLog.e(TAG, "Got JSONException while parsing response. Should retry if still within retry limit.", httpurlconnection);
_L3:
        return true;
    }

}
