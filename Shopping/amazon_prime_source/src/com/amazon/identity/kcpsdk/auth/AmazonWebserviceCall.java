// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import android.content.Context;
import com.amazon.identity.auth.device.framework.RetryableURLConnection;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.metrics.WebserviceCallMetrics;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.StreamUtils;
import com.amazon.identity.kcpsdk.common.HttpVerb;
import com.amazon.identity.kcpsdk.common.WebRequest;
import com.amazon.identity.kcpsdk.common.WebResponseHeaders;
import com.amazon.identity.platform.metric.MetricUtils;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            IAmazonWebserviceCall, ParseErrorException, AmazonWebserviceCallRetryLogic, AmazonWebserviceCallResponseParser, 
//            RequestSigner, IAmazonWebServiceCallback

public class AmazonWebserviceCall
    implements IAmazonWebserviceCall
{

    static final AtomicInteger CALL_COUNTER = new AtomicInteger(0);
    private static final String TAG = com/amazon/identity/kcpsdk/auth/AmazonWebserviceCall.getName();
    private final Context mContext;
    RequestSigner mRequestSigner;
    private final Tracer mTracer;
    WebRequest mWebRequest;
    IAmazonWebServiceCallback mWebServiceCallback;

    public AmazonWebserviceCall(Context context, WebRequest webrequest, IAmazonWebServiceCallback iamazonwebservicecallback, RequestSigner requestsigner, Tracer tracer)
    {
        mWebServiceCallback = null;
        mWebRequest = null;
        mRequestSigner = null;
        mWebRequest = webrequest;
        mRequestSigner = requestsigner;
        mWebServiceCallback = iamazonwebservicecallback;
        mContext = context;
        mTracer = tracer;
    }

    public static WebResponseHeaders connectionRequest(WebRequest webrequest, HttpURLConnection httpurlconnection)
        throws IOException
    {
        HttpVerb httpverb;
        httpverb = webrequest.getVerb();
        int i;
        if (httpverb == HttpVerb.HttpVerbGet)
        {
            httpurlconnection.setRequestMethod("GET");
        } else
        if (httpverb == HttpVerb.HttpVerbPost)
        {
            httpurlconnection.setRequestMethod("POST");
            httpurlconnection.setDoOutput(true);
        } else
        if (httpverb == HttpVerb.HttpVerbPut)
        {
            httpurlconnection.setRequestMethod("PUT");
            httpurlconnection.setDoOutput(true);
        } else
        {
            throw new UnsupportedOperationException((new StringBuilder("unrecognized HttpVerb: ")).append(httpverb).toString());
        }
        for (i = 0; i < webrequest.getNumHeaders(); i++)
        {
            httpurlconnection.setRequestProperty(webrequest.getHeaderName(i), webrequest.getHeaderValue(i));
        }

        if (httpverb != HttpVerb.HttpVerbPost && httpverb != HttpVerb.HttpVerbPut) goto _L2; else goto _L1
_L1:
        byte abyte0[] = webrequest.getBodyBytes();
        if (abyte0 != null && abyte0.length != 0) goto _L4; else goto _L3
_L3:
        MAPLog.i(TAG, "Finished write body.");
_L2:
        int j;
        MAPLog.i(TAG, "Starting get response code");
        j = httpurlconnection.getResponseCode();
        MAPLog.i(TAG, (new StringBuilder("Received response: ")).append(j).toString());
        if (j == -1)
        {
            throw new IOException("Invalid response code");
        }
        break; /* Loop/switch isn't completed */
_L4:
        httpurlconnection.setFixedLengthStreamingMode(abyte0.length);
        webrequest = httpurlconnection.getOutputStream();
        webrequest.write(abyte0);
        try
        {
            webrequest.flush();
        }
        catch (IOException ioexception)
        {
            MAPLog.e(TAG, "Couldn't flush write body stream", ioexception);
        }
        try
        {
            webrequest.close();
        }
        // Misplaced declaration of an exception variable
        catch (WebRequest webrequest)
        {
            MAPLog.e(TAG, "Couldn't close write body stream", webrequest);
        }
        if (true) goto _L3; else goto _L5
        httpurlconnection;
        try
        {
            webrequest.flush();
        }
        catch (IOException ioexception1)
        {
            MAPLog.e(TAG, "Couldn't flush write body stream", ioexception1);
        }
        try
        {
            webrequest.close();
        }
        // Misplaced declaration of an exception variable
        catch (WebRequest webrequest)
        {
            MAPLog.e(TAG, "Couldn't close write body stream", webrequest);
        }
        throw httpurlconnection;
_L5:
        webrequest = new WebResponseHeaders();
        webrequest.setStatusCode(j);
        j = 1;
        String s1;
        do
        {
            String s = httpurlconnection.getHeaderFieldKey(j);
            s1 = httpurlconnection.getHeaderField(j);
            int k = j;
            if (s1 != null)
            {
                webrequest.addHeader(s, s1);
                k = j + 1;
            }
            j = k;
        } while (s1 != null);
        return webrequest;
    }

    public static Object doRun(Context context, WebRequest webrequest, AmazonWebserviceCallResponseParser amazonwebservicecallresponseparser, Tracer tracer)
        throws IOException, ParseErrorException
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Tracer tracer1;
        Tracer tracer2;
        byte abyte0[];
        Object obj6;
        Object obj7;
        Object obj8;
        PlatformMetricsTimer platformmetricstimer;
        obj = null;
        obj3 = null;
        obj4 = null;
        obj2 = null;
        platformmetricstimer = WebserviceCallMetrics.getTimer(webrequest.getUrl());
        obj6 = null;
        obj7 = null;
        obj8 = null;
        abyte0 = null;
        platformmetricstimer.start();
        obj5 = abyte0;
        obj1 = obj6;
        tracer1 = obj7;
        tracer2 = obj8;
        tracer = RetryableURLConnection.openConnection(new URL(webrequest.getUrl()), new AmazonWebserviceCallRetryLogic(context, amazonwebservicecallresponseparser), tracer, context);
        obj2 = tracer;
        obj5 = abyte0;
        obj = tracer;
        obj1 = obj6;
        obj3 = tracer;
        tracer1 = obj7;
        obj4 = tracer;
        tracer2 = obj8;
        HttpURLConnection httpurlconnection = (HttpURLConnection)setAmazonWebRequestSettings(tracer);
        obj2 = httpurlconnection;
        obj5 = abyte0;
        obj = httpurlconnection;
        obj1 = obj6;
        obj3 = httpurlconnection;
        tracer1 = obj7;
        obj4 = httpurlconnection;
        tracer2 = obj8;
        (new StringBuilder("X-Amzn-RequestId:")).append(httpurlconnection.getRequestProperty("X-Amzn-RequestId"));
        obj2 = httpurlconnection;
        obj5 = abyte0;
        obj = httpurlconnection;
        obj1 = obj6;
        obj3 = httpurlconnection;
        tracer1 = obj7;
        obj4 = httpurlconnection;
        tracer2 = obj8;
        MAPLog.i(TAG, "Opened WebRequest Connection.");
        obj2 = httpurlconnection;
        obj5 = abyte0;
        obj = httpurlconnection;
        obj1 = obj6;
        obj3 = httpurlconnection;
        tracer1 = obj7;
        obj4 = httpurlconnection;
        tracer2 = obj8;
        WebResponseHeaders webresponseheaders = connectionRequest(webrequest, httpurlconnection);
        obj = httpurlconnection;
        obj1 = obj6;
        obj3 = httpurlconnection;
        tracer1 = obj7;
        obj4 = httpurlconnection;
        tracer2 = obj8;
        tracer = httpurlconnection.getInputStream();
_L2:
        abyte0 = null;
        if (tracer == null)
        {
            break MISSING_BLOCK_LABEL_320;
        }
        obj2 = httpurlconnection;
        obj5 = tracer;
        obj = httpurlconnection;
        obj1 = tracer;
        obj3 = httpurlconnection;
        tracer1 = tracer;
        obj4 = httpurlconnection;
        tracer2 = tracer;
        abyte0 = StreamUtils.readInputStream(tracer);
        obj2 = httpurlconnection;
        obj5 = tracer;
        obj = httpurlconnection;
        obj1 = tracer;
        obj3 = httpurlconnection;
        tracer1 = tracer;
        obj4 = httpurlconnection;
        tracer2 = tracer;
        amazonwebservicecallresponseparser = ((AmazonWebserviceCallResponseParser) (amazonwebservicecallresponseparser.parse(webresponseheaders, abyte0)));
        if (tracer != null)
        {
            try
            {
                tracer.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                MAPLog.e(TAG, (new StringBuilder("Error closing stream to ")).append(getLogSafeUrl(webrequest)).toString(), context);
            }
        }
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
        platformmetricstimer.stop();
        return amazonwebservicecallresponseparser;
        tracer;
        obj2 = httpurlconnection;
        obj5 = abyte0;
        obj = httpurlconnection;
        obj1 = obj6;
        obj3 = httpurlconnection;
        tracer1 = obj7;
        obj4 = httpurlconnection;
        tracer2 = obj8;
        tracer = httpurlconnection.getErrorStream();
        if (true) goto _L2; else goto _L1
_L1:
        amazonwebservicecallresponseparser;
        obj = obj2;
        obj1 = obj5;
        MAPLog.e(TAG, (new StringBuilder("IOException making request to ")).append(getLogSafeUrl(webrequest)).toString(), amazonwebservicecallresponseparser);
        obj = obj2;
        obj1 = obj5;
        if (!MetricUtils.checkConnectivity(context, platformmetricstimer))
        {
            break MISSING_BLOCK_LABEL_525;
        }
        obj = obj2;
        obj1 = obj5;
        WebserviceCallMetrics.reportNetworkNotAvailableFailure(webrequest.getUrl());
        obj = obj2;
        obj1 = obj5;
        WebserviceCallMetrics.reportNetworkFailure(webrequest.getUrl());
        obj = obj2;
        obj1 = obj5;
        throw amazonwebservicecallresponseparser;
        context;
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (AmazonWebserviceCallResponseParser amazonwebservicecallresponseparser)
            {
                MAPLog.e(TAG, (new StringBuilder("Error closing stream to ")).append(getLogSafeUrl(webrequest)).toString(), amazonwebservicecallresponseparser);
            }
        }
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        platformmetricstimer.stop();
        throw context;
        context;
        obj = obj3;
        obj1 = tracer1;
        MAPLog.e(TAG, (new StringBuilder("UnsupportedOperationException making request to ")).append(getLogSafeUrl(webrequest)).toString(), context);
        obj = obj3;
        obj1 = tracer1;
        WebserviceCallMetrics.reportNetworkFailure(webrequest.getUrl());
        obj = obj3;
        obj1 = tracer1;
        throw context;
        context;
        obj = obj4;
        obj1 = tracer2;
        throw context;
    }

    private static String getLogSafeUrl(WebRequest webrequest)
    {
        return webrequest.getUrl().replace(webrequest.getQueryString(), "");
    }

    private static int getTimeInMS$134621()
    {
        return (int)TimeUnit.MILLISECONDS.convert(30L, TimeUnit.SECONDS);
    }

    private static void handleAuthentication(WebRequest webrequest, RequestSigner requestsigner)
    {
label0:
        {
            if (webrequest.getAuthenticationRequired())
            {
                if (requestsigner == null)
                {
                    break label0;
                }
                requestsigner.signRequest(webrequest);
            }
            return;
        }
        MAPLog.e(TAG, "The request requires authentication, but no authentication credentials were supplied.");
    }

    public static Object run(Context context, WebRequest webrequest, AmazonWebserviceCallResponseParser amazonwebservicecallresponseparser, RequestSigner requestsigner, Tracer tracer)
        throws IOException, ParseErrorException
    {
        handleAuthentication(webrequest, requestsigner);
        MAPLog.i(TAG, "Starting web request");
        webrequest.getUrl();
        return doRun(context, webrequest, amazonwebservicecallresponseparser, tracer);
    }

    public static URLConnection setAmazonWebRequestSettings(URLConnection urlconnection)
    {
        urlconnection.setRequestProperty("X-Amzn-RequestId", UUID.randomUUID().toString());
        urlconnection.setConnectTimeout(getTimeInMS$134621());
        urlconnection.setReadTimeout(getTimeInMS$134621());
        return urlconnection;
    }

    public void call()
    {
        handleAuthentication(mWebRequest, mRequestSigner);
        MAPLog.i(TAG, "Starting web request");
        mWebRequest.getUrl();
        try
        {
            doRun(mContext, mWebRequest, new AmazonWebserviceCallResponseParser() {

                final AmazonWebserviceCall this$0;

                public String getErrorCode(HttpURLConnection httpurlconnection)
                {
                    return null;
                }

                public Object parse(WebResponseHeaders webresponseheaders, byte abyte0[])
                    throws ParseErrorException, IOException
                {
                    mWebServiceCallback.onHeadersReceived(webresponseheaders);
                    if (abyte0 != null)
                    {
                        mWebServiceCallback.onBodyChunkReceived(abyte0, abyte0.length);
                    }
                    MAPLog.i(AmazonWebserviceCall.TAG, "Request complete");
                    mWebServiceCallback.onRequestComplete();
                    return null;
                }

            
            {
                this$0 = AmazonWebserviceCall.this;
                super();
            }
            }, mTracer);
            return;
        }
        catch (IOException ioexception)
        {
            mWebServiceCallback.onNetworkError();
            return;
        }
        catch (ParseErrorException parseerrorexception)
        {
            return;
        }
        catch (UnsupportedOperationException unsupportedoperationexception)
        {
            mWebServiceCallback.onNetworkError();
        }
    }


}
