// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.ResponseHeader;
import com.mopub.network.Networking;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.params.HttpConnectionParams;

// Referenced classes of package com.mopub.common:
//            Preconditions

public class HttpClient
{

    private static final int CONNECTION_TIMEOUT = 10000;
    private static final int SOCKET_TIMEOUT = 10000;

    public HttpClient()
    {
    }

    static URI encodeUrl(String s)
        throws Exception
    {
        Object obj;
        try
        {
            obj = new URL(s);
            obj = new URI(((URL) (obj)).getProtocol(), ((URL) (obj)).getUserInfo(), ((URL) (obj)).getHost(), ((URL) (obj)).getPort(), ((URL) (obj)).getPath(), ((URL) (obj)).getQuery(), ((URL) (obj)).getRef());
        }
        catch (Exception exception)
        {
            MoPubLog.w((new StringBuilder()).append("Failed to encode url: ").append(s).toString());
            throw exception;
        }
        return ((URI) (obj));
    }

    public static AndroidHttpClient getHttpClient()
    {
        AndroidHttpClient androidhttpclient = AndroidHttpClient.newInstance(Networking.getCachedUserAgent());
        org.apache.http.params.HttpParams httpparams = androidhttpclient.getParams();
        HttpConnectionParams.setConnectionTimeout(httpparams, 10000);
        HttpConnectionParams.setSoTimeout(httpparams, 10000);
        HttpClientParams.setRedirecting(httpparams, true);
        return androidhttpclient;
    }

    public static HttpGet initializeHttpGet(String s)
    {
        return initializeHttpGet(s, null);
    }

    public static HttpGet initializeHttpGet(String s, Context context)
    {
        Preconditions.checkNotNull(s);
        String s1 = urlEncode(s);
        s = s1;
_L1:
        HttpGet httpget = new HttpGet(s);
        Exception exception;
        if (context != null)
        {
            s = Networking.getUserAgent(context);
        } else
        {
            s = Networking.getCachedUserAgent();
        }
        if (s != null)
        {
            httpget.addHeader(ResponseHeader.USER_AGENT.getKey(), s);
        }
        return httpget;
        exception;
          goto _L1
    }

    static boolean isUrlImproperlyEncoded(String s)
    {
        try
        {
            URLDecoder.decode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            MoPubLog.w((new StringBuilder()).append("Url is improperly encoded: ").append(s).toString());
            return true;
        }
        return false;
    }

    static boolean isUrlUnencoded(String s)
    {
        try
        {
            new URI(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return true;
        }
        return false;
    }

    public static String urlEncode(String s)
        throws Exception
    {
        Preconditions.checkNotNull(s);
        if (isUrlImproperlyEncoded(s))
        {
            throw new UnsupportedEncodingException((new StringBuilder()).append("URL is improperly encoded: ").append(s).toString());
        }
        if (isUrlUnencoded(s))
        {
            s = encodeUrl(s);
        } else
        {
            s = new URI(s);
        }
        return s.toURL().toString();
    }
}
