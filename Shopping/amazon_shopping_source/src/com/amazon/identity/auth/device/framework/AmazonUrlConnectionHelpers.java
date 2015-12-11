// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import com.amazon.identity.auth.device.api.AuthenticatedURLConnection;
import com.amazon.identity.auth.device.api.AuthenticationMethod;
import com.amazon.identity.auth.device.framework.security.EnhancedURLConnectionFactory;
import com.amazon.identity.auth.device.utils.StreamUtils;
import com.amazon.identity.kcpsdk.auth.AmazonWebserviceCall;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            RetryableURLConnection, RetryLogic, Tracer

public final class AmazonUrlConnectionHelpers
{

    private static final String TAG = com/amazon/identity/auth/device/framework/AmazonUrlConnectionHelpers.getName();

    private AmazonUrlConnectionHelpers()
    {
    }

    public static HttpURLConnection openConnection(HttpURLConnection httpurlconnection, AuthenticationMethod authenticationmethod)
        throws IOException
    {
        return (HttpURLConnection)AmazonWebserviceCall.setAmazonWebRequestSettings(AuthenticatedURLConnection.openConnection(httpurlconnection, authenticationmethod));
    }

    public static HttpURLConnection openConnection(URL url, AuthenticationMethod authenticationmethod)
        throws IOException
    {
        return (HttpURLConnection)AmazonWebserviceCall.setAmazonWebRequestSettings(AuthenticatedURLConnection.openConnection(url, authenticationmethod));
    }

    public static HttpURLConnection openConnection(URL url, RetryLogic retrylogic, Tracer tracer, Context context)
        throws IOException
    {
        return (HttpURLConnection)AmazonWebserviceCall.setAmazonWebRequestSettings(RetryableURLConnection.openConnection(url, retrylogic, tracer, context));
    }

    public static URLConnection openConnection(URL url)
        throws IOException
    {
        return AmazonWebserviceCall.setAmazonWebRequestSettings(EnhancedURLConnectionFactory.createURLConnection(url));
    }

    public static void writeErrorStream(HttpURLConnection httpurlconnection, String s)
        throws IOException
    {
        s = null;
        java.io.InputStream inputstream = httpurlconnection.getErrorStream();
        if (inputstream != null) goto _L2; else goto _L1
_L1:
        httpurlconnection = "No Error Stream Found";
_L4:
        s = inputstream;
        httpurlconnection = TAG;
        StreamUtils.closeStream(inputstream);
        return;
_L2:
        s = inputstream;
        httpurlconnection = new String(StreamUtils.readInputStream(inputstream));
        if (true) goto _L4; else goto _L3
_L3:
        httpurlconnection;
        StreamUtils.closeStream(s);
        throw httpurlconnection;
    }

}
