// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import com.amazon.identity.auth.device.utils.JSONHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.platform.metric.MetricUtils;
import com.amazon.identity.platform.metric.MetricsHelper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            RetryLogic, AuthEndpointErrorParser, Tracer

public class AuthErrorRetryLogic extends RetryLogic
{

    private static final String TAG = com/amazon/identity/auth/device/framework/AuthErrorRetryLogic.getName();
    private final AuthEndpointErrorParser mAuthEndpointErrorParser = new AuthEndpointErrorParser();

    public AuthErrorRetryLogic()
    {
    }

    public boolean shouldRetry(HttpURLConnection httpurlconnection, int i, Tracer tracer)
        throws IOException
    {
        i = httpurlconnection.getResponseCode();
        tracer = JSONHelpers.toJson(httpurlconnection);
        if (tracer != null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        MAPLog.e(TAG, "Malformatted json response detected. Should retry if still within retry limit.");
        return true;
        if (!mAuthEndpointErrorParser.isFailure(i))
        {
            return false;
        }
        tracer = mAuthEndpointErrorParser.parse(tracer);
        if (tracer == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        boolean flag = tracer.shouldRetry();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        return false;
        tracer;
        httpurlconnection = httpurlconnection.getURL();
        MetricsHelper.increasePeriodicCounter((new StringBuilder()).append(MetricUtils.getMAPUrlType(httpurlconnection.toString())).append(":").append(httpurlconnection.getHost()).append(":JSONException").toString(), new String[0]);
        MAPLog.e(TAG, "Got JSONException while parsing response. Should retry if still within retry limit.", tracer);
        return true;
    }

}
