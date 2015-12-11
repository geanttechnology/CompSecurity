// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPCFHttp, TPEventLog, TwinPrimeSDKPvt, TPHttpsURLConnection, 
//            TPHttpURLConnection, TPLog

public class TPURLConnection
{

    final String LOG_TAG = "TPURLConnection";
    private Boolean acceleration;
    private String http_client;
    private URL url;
    private String urlStr;

    public TPURLConnection()
    {
        http_client = null;
    }

    private URLConnection getConnection()
        throws IOException
    {
        Object obj;
        URL url1;
        url1 = url;
        obj = new TPCFHttp(url1, 0, acceleration);
        if (((TPCFHttp) (obj)).shouldAccelerate || !TwinPrimeSDKPvt.bypassSDK(((TPCFHttp) (obj)).tpEventLog.bypass_reason)) goto _L2; else goto _L1
_L1:
        obj = url1.openConnection();
_L4:
        return ((URLConnection) (obj));
_L2:
        if (url1.getProtocol().equalsIgnoreCase("https"))
        {
            obj = new TPHttpsURLConnection(((TPCFHttp) (obj)));
            if (http_client != null)
            {
                obj.http_client = http_client;
            }
            break; /* Loop/switch isn't completed */
        }
        try
        {
            obj = new TPHttpURLConnection(((TPCFHttp) (obj)));
            if (http_client != null)
            {
                obj.http_client = http_client;
            }
            break; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (TPLog.LOG10.isLoggable("TPURLConnection"))
            {
                ((ConnectException) (obj)).printStackTrace();
            }
            obj = url1.openConnection();
        }
        if (true) goto _L4; else goto _L3
_L3:
        return ((URLConnection) (obj));
    }

    private static URLConnection initTPUrlConnection(String s, Boolean boolean1, String s1)
        throws IOException
    {
        TPURLConnection tpurlconnection = new TPURLConnection();
        tpurlconnection.urlStr = s;
        tpurlconnection.url = new URL(s);
        tpurlconnection.acceleration = boolean1;
        tpurlconnection.http_client = s1;
        return tpurlconnection.getConnection();
    }

    public static URLConnection openConnection(String s)
        throws IOException
    {
        return initTPUrlConnection(s, null, null);
    }

    public static URLConnection openConnection(String s, boolean flag)
        throws IOException
    {
        return initTPUrlConnection(s, Boolean.valueOf(flag), null);
    }
}
