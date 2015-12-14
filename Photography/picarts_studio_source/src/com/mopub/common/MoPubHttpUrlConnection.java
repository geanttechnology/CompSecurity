// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import com.mopub.common.logging.MoPubLog;
import com.mopub.network.Networking;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

// Referenced classes of package com.mopub.common:
//            Preconditions

public abstract class MoPubHttpUrlConnection extends HttpURLConnection
{

    private static final int CONNECT_TIMEOUT = 10000;
    private static final int READ_TIMEOUT = 10000;

    private MoPubHttpUrlConnection(URL url)
    {
        super(url);
    }

    static URI encodeUrl(String s)
    {
        Object obj;
        try
        {
            obj = new URL(s);
            obj = new URI(((URL) (obj)).getProtocol(), ((URL) (obj)).getUserInfo(), ((URL) (obj)).getHost(), ((URL) (obj)).getPort(), ((URL) (obj)).getPath(), ((URL) (obj)).getQuery(), ((URL) (obj)).getRef());
        }
        catch (Exception exception)
        {
            MoPubLog.w((new StringBuilder("Failed to encode url: ")).append(s).toString());
            throw exception;
        }
        return ((URI) (obj));
    }

    public static HttpURLConnection getHttpUrlConnection(String s)
    {
        Preconditions.checkNotNull(s);
        if (isUrlImproperlyEncoded(s))
        {
            throw new IllegalArgumentException((new StringBuilder("URL is improperly encoded: ")).append(s).toString());
        }
        String s1 = urlEncode(s);
        s = s1;
_L2:
        s = (HttpURLConnection)(new URL(s)).openConnection();
        s.setRequestProperty("User-Agent", Networking.getCachedUserAgent());
        s.setConnectTimeout(10000);
        s.setReadTimeout(10000);
        return s;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static boolean isUrlImproperlyEncoded(String s)
    {
        try
        {
            URLDecoder.decode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            MoPubLog.w((new StringBuilder("Url is improperly encoded: ")).append(s).toString());
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
    {
        Preconditions.checkNotNull(s);
        if (isUrlImproperlyEncoded(s))
        {
            throw new UnsupportedEncodingException((new StringBuilder("URL is improperly encoded: ")).append(s).toString());
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
