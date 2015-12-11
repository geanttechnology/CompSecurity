// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import android.content.Context;
import android.text.TextUtils;
import com.amazon.identity.auth.device.framework.RetryLogic;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.platform.metric.MetricUtils;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import java.io.IOException;
import java.net.HttpURLConnection;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            AmazonWebserviceCallResponseParser

public class AmazonWebserviceCallRetryLogic extends RetryLogic
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/AmazonWebserviceCallRetryLogic.getName();
    private Context mContext;
    private int mNumberOfAttempts;
    private AmazonWebserviceCallResponseParser mParser;

    public AmazonWebserviceCallRetryLogic(Context context, AmazonWebserviceCallResponseParser amazonwebservicecallresponseparser)
    {
        mNumberOfAttempts = 0;
        mParser = amazonwebservicecallresponseparser;
        mContext = context;
    }

    public boolean shouldRetry(HttpURLConnection httpurlconnection, int i, Tracer tracer)
        throws IOException
    {
        java.net.URL url;
        mNumberOfAttempts = mNumberOfAttempts + 1;
        url = httpurlconnection.getURL();
        PlatformMetricsTimer platformmetricstimer;
        int j;
        platformmetricstimer = tracer.startTimer(MetricUtils.getUrlPathAndDomain(url));
        j = httpurlconnection.getResponseCode();
        platformmetricstimer.stopClock();
        httpurlconnection = mParser.getErrorCode(httpurlconnection);
        if (!TextUtils.isEmpty(httpurlconnection))
        {
            break MISSING_BLOCK_LABEL_103;
        }
        platformmetricstimer.setTimerName(MetricUtils.getUrlPathAndDomain(url, j));
_L1:
        platformmetricstimer.stop();
        if (!isHTTP500ErrorCodeSeries(j))
        {
            break MISSING_BLOCK_LABEL_174;
        }
        MAPLog.formattedError(TAG, "Got response code %d. Retrying", new Object[] {
            Integer.valueOf(j)
        });
        return true;
        try
        {
            platformmetricstimer.setTimerName(MetricUtils.getUrlPathAndDomain(url, j, httpurlconnection));
        }
        // Misplaced declaration of an exception variable
        catch (HttpURLConnection httpurlconnection)
        {
            if (!MetricUtils.isDeviceConnected(mContext))
            {
                mNumberOfAttempts = mNumberOfAttempts - 1;
            }
            MAPLog.e(TAG, "IOException : ", httpurlconnection);
            tracer.incrementCounter(MetricUtils.getIOExceptionMetricName(url));
            tracer.incrementCounter(MetricUtils.getIOExceptionWithSubClassMetricName(url, httpurlconnection, mContext));
            return true;
        }
          goto _L1
        RetryLogic.recordAvailability(mNumberOfAttempts, url, tracer);
        if (i > 0)
        {
            tracer.incrementCounter(MetricUtils.getSuccessAfterRetryMetricName(url));
        }
        return false;
    }

}
