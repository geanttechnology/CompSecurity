// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.attributes;

import android.content.Context;
import android.net.Uri;
import com.amazon.identity.auth.device.api.AuthenticationMethodFactory;
import com.amazon.identity.auth.device.api.AuthenticationType;
import com.amazon.identity.auth.device.env.EnvironmentUtils;
import com.amazon.identity.auth.device.features.Feature;
import com.amazon.identity.auth.device.framework.AmazonUrlConnectionHelpers;
import com.amazon.identity.auth.device.framework.AuthenticatedUrlConnectionFactory;
import com.amazon.identity.auth.device.framework.SSODeviceInfo;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.JSONHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.Platform;
import com.amazon.identity.auth.device.utils.StreamUtils;
import com.amazon.identity.platform.metric.MetricUtils;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.auth.attributes:
//            CORPFMResponse

public class CorPfmFetcher
{

    private static final String TAG = com/amazon/identity/auth/attributes/CorPfmFetcher.getName();
    private final AuthenticationMethodFactory mAuthMethodFactory;
    private final Context mContext;
    private final SSODeviceInfo mDeviceInfo;
    private final Tracer mTracer;
    private final AuthenticatedUrlConnectionFactory mUrlConnectionFactory;

    public CorPfmFetcher(Context context, String s, Tracer tracer)
    {
        mContext = context;
        mAuthMethodFactory = new AuthenticationMethodFactory(context, s);
        mUrlConnectionFactory = (AuthenticatedUrlConnectionFactory)context.getSystemService("dcp_authenticated_url_connection_factory");
        mDeviceInfo = (SSODeviceInfo)mContext.getSystemService("dcp_device_info");
        mTracer = tracer;
    }

    private URL buildRequestUrl()
    {
        Object obj;
        try
        {
            obj = (new android.net.Uri.Builder()).scheme("https").authority(EnvironmentUtils.getInstance().getDCAHost()).appendPath("getCustomerAttribute").appendQueryParameter("version", "1_0").appendQueryParameter("preferences", "cor,pfm").appendQueryParameter("devicetype", mDeviceInfo.getDeviceType());
            if (Platform.hasFeature(mContext, Feature.DSNWhenNotRegistered))
            {
                ((android.net.Uri.Builder) (obj)).appendQueryParameter("dsn", mDeviceInfo.getDeviceSerialNumber());
            }
            obj = new URL(((android.net.Uri.Builder) (obj)).build().toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            MAPLog.e(TAG, "Could not contruct DCA endpoint");
            return null;
        }
        return ((URL) (obj));
    }

    private CORPFMResponse parseResponse(HttpURLConnection httpurlconnection)
        throws IOException
    {
        Object obj;
        java.io.InputStream inputstream;
        Object obj1;
        obj = null;
        obj1 = null;
        inputstream = null;
        java.io.InputStream inputstream1 = httpurlconnection.getInputStream();
        inputstream = inputstream1;
        obj = inputstream1;
        obj1 = inputstream1;
        Object obj2 = new String(StreamUtils.readInputStream(inputstream1));
        inputstream = inputstream1;
        obj = inputstream1;
        obj1 = inputstream1;
        String s = TAG;
        inputstream = inputstream1;
        obj = inputstream1;
        obj1 = inputstream1;
        (new StringBuilder("Response: ")).append(((String) (obj2))).toString();
        inputstream = inputstream1;
        obj = inputstream1;
        obj1 = inputstream1;
        obj2 = new JSONObject(((String) (obj2)));
        inputstream = inputstream1;
        obj = inputstream1;
        obj1 = inputstream1;
        Object obj3 = JSONHelpers.getJSONObject(((JSONObject) (obj2)), "customerAttribute");
        if (obj3 != null)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        inputstream = inputstream1;
        obj = inputstream1;
        obj1 = inputstream1;
        obj2 = JSONHelpers.getStringOrDefault(((JSONObject) (obj2)), "Message", "Internal Error.");
        inputstream = inputstream1;
        obj = inputstream1;
        obj1 = inputstream1;
        MAPLog.w(TAG, (new StringBuilder("The server returned an error with message: ")).append(((String) (obj2))).toString());
        StreamUtils.closeStream(inputstream1);
        return null;
        inputstream = inputstream1;
        obj = inputstream1;
        obj1 = inputstream1;
        if (((JSONObject) (obj3)).has("cor"))
        {
            break MISSING_BLOCK_LABEL_287;
        }
        inputstream = inputstream1;
        obj = inputstream1;
        obj1 = inputstream1;
        if (((JSONObject) (obj3)).has("pfm"))
        {
            break MISSING_BLOCK_LABEL_287;
        }
        inputstream = inputstream1;
        obj = inputstream1;
        obj1 = inputstream1;
        obj2 = JSONHelpers.getStringOrDefault(((JSONObject) (obj3)), "Description", "Generic Error. No COR or PFM found.");
        inputstream = inputstream1;
        obj = inputstream1;
        obj1 = inputstream1;
        MAPLog.w(TAG, (new StringBuilder("The server did not return a cor pfm for the customer. Message: ")).append(((String) (obj2))).toString());
        StreamUtils.closeStream(inputstream1);
        return null;
        inputstream = inputstream1;
        obj = inputstream1;
        obj1 = inputstream1;
        obj2 = JSONHelpers.getStringOrDefault(((JSONObject) (obj3)), "cor", null);
        inputstream = inputstream1;
        obj = inputstream1;
        obj1 = inputstream1;
        s = JSONHelpers.getStringOrDefault(((JSONObject) (obj3)), "pfm", null);
        inputstream = inputstream1;
        obj = inputstream1;
        obj1 = inputstream1;
        String s1 = JSONHelpers.getStringOrDefault(((JSONObject) (obj3)), "sourceOfComputationCOR", null);
        inputstream = inputstream1;
        obj = inputstream1;
        obj1 = inputstream1;
        String s2 = JSONHelpers.getStringOrDefault(((JSONObject) (obj3)), "sourceOfComputationPFM", null);
        inputstream = inputstream1;
        obj = inputstream1;
        obj1 = inputstream1;
        obj3 = JSONHelpers.getStringOrDefault(((JSONObject) (obj3)), "computationConfidenceValue", null);
        inputstream = inputstream1;
        obj = inputstream1;
        obj1 = inputstream1;
        MAPLog.i(TAG, String.format("Received response with: \nCoR: %s \nPFM:%s \nSource Of Computation CoR: %s \n Source Of Computation PFM: %s \n Computation Confidence Value: %s", new Object[] {
            obj2, s, s1, s2, obj3
        }));
        inputstream = inputstream1;
        obj = inputstream1;
        obj1 = inputstream1;
        obj3 = CORPFMResponse.ComputationConfidenceValue.parseFromValue(((String) (obj3)), CORPFMResponse.ComputationConfidenceValue.CUSTOMER_PROVIDED);
        inputstream = inputstream1;
        obj = inputstream1;
        obj1 = inputstream1;
        MetricsHelper.incrementCounter("fetchCORPFMSuccess", new String[0]);
        inputstream = inputstream1;
        obj = inputstream1;
        obj1 = inputstream1;
        obj2 = new CORPFMResponse(((String) (obj2)), s, ((CORPFMResponse.ComputationConfidenceValue) (obj3)));
        StreamUtils.closeStream(inputstream1);
        return ((CORPFMResponse) (obj2));
        obj1;
        obj = inputstream;
        MetricsHelper.incrementCounter("fetchCORPFMFailure", new String[] {
            "IOException"
        });
        obj = inputstream;
        AmazonUrlConnectionHelpers.writeErrorStream(httpurlconnection, "DCA service");
        obj = inputstream;
        throw obj1;
        httpurlconnection;
        StreamUtils.closeStream(((java.io.Closeable) (obj)));
        throw httpurlconnection;
        httpurlconnection;
        obj = obj1;
        MetricsHelper.incrementCounter("fetchCORPFMFailure", new String[] {
            "JSONException"
        });
        obj = obj1;
        MAPLog.e(TAG, (new StringBuilder("Error parsing DCAS JSON Response: ")).append(httpurlconnection.getMessage()).toString());
        StreamUtils.closeStream(((java.io.Closeable) (obj1)));
        return null;
    }

    public CORPFMResponse fetch()
    {
        Object obj2;
        URL url;
        obj2 = null;
        MAPLog.i(TAG, "Fetching the COR and PFM values");
        url = buildRequestUrl();
        if (url != null) goto _L2; else goto _L1
_L1:
        Object obj1 = obj2;
_L3:
        return ((CORPFMResponse) (obj1));
_L2:
        Object obj;
        HttpURLConnection httpurlconnection;
        Object obj3;
        obj3 = null;
        httpurlconnection = null;
        obj = httpurlconnection;
        obj1 = obj3;
        com.amazon.identity.auth.device.api.AuthenticationMethod authenticationmethod = mAuthMethodFactory.newAuthenticationMethod(AuthenticationType.ADPAuthenticator);
        obj = httpurlconnection;
        obj1 = obj3;
        PlatformMetricsTimer platformmetricstimer = mTracer.startTimer(MetricUtils.getUrlPathAndDomain(url));
        obj = httpurlconnection;
        obj1 = obj3;
        httpurlconnection = mUrlConnectionFactory.openConnection(url, authenticationmethod);
        obj = httpurlconnection;
        obj1 = httpurlconnection;
        httpurlconnection.setRequestMethod("GET");
        obj = httpurlconnection;
        obj1 = httpurlconnection;
        httpurlconnection.setRequestProperty("Accept", "application/json");
        obj = httpurlconnection;
        obj1 = httpurlconnection;
        int i = httpurlconnection.getResponseCode();
        obj = httpurlconnection;
        obj1 = httpurlconnection;
        platformmetricstimer.stopClock();
        obj = httpurlconnection;
        obj1 = httpurlconnection;
        platformmetricstimer.setTimerName(MetricUtils.getUrlPathAndDomain(url, i));
        obj = httpurlconnection;
        obj1 = httpurlconnection;
        platformmetricstimer.stop();
        obj = httpurlconnection;
        obj1 = httpurlconnection;
        MAPLog.i(TAG, String.format("Received Response Code %d from DCAS", new Object[] {
            Integer.valueOf(i)
        }));
        obj = httpurlconnection;
        obj1 = httpurlconnection;
        mTracer.incrementCounter(MetricUtils.getAvailabilityMetricName(url), 1.0D);
        obj = httpurlconnection;
        obj1 = httpurlconnection;
        obj3 = parseResponse(httpurlconnection);
        obj = obj3;
        obj1 = obj;
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
            return ((CORPFMResponse) (obj));
        }
          goto _L3
        IOException ioexception;
        ioexception;
        obj1 = obj;
        MAPLog.e(TAG, (new StringBuilder("IOException: Could not call DCAS Service. ")).append(ioexception.getClass().getName()).toString());
        obj1 = obj;
        obj3 = TAG;
        obj1 = obj;
        (new StringBuilder("IOException: ")).append(ioexception.getMessage()).toString();
        obj1 = obj;
        if (!MetricUtils.isDeviceConnected(mContext))
        {
            break MISSING_BLOCK_LABEL_315;
        }
        obj1 = obj;
        mTracer.incrementCounter(MetricUtils.getAvailabilityMetricName(url), 0.0D);
        obj1 = obj;
        mTracer.incrementCounter(MetricUtils.getIOExceptionMetricName(url));
        obj1 = obj;
        mTracer.incrementCounter(MetricUtils.getIOExceptionWithSubClassMetricName(url, ioexception, mContext));
        obj1 = obj2;
        if (obj == null) goto _L3; else goto _L4
_L4:
        ((HttpURLConnection) (obj)).disconnect();
        return null;
        Exception exception;
        exception;
        if (obj1 != null)
        {
            ((HttpURLConnection) (obj1)).disconnect();
        }
        throw exception;
    }

}
