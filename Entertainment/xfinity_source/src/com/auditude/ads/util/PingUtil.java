// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.auditude.ads.util;

import com.auditude.ads.core.AdSettings;
import com.auditude.ads.core.AuditudeEnv;
import com.auditude.ads.util.log.ILogger;
import com.auditude.ads.util.log.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.StrictHostnameVerifier;

// Referenced classes of package com.auditude.ads.util:
//            StringUtil

public final class PingUtil
{

    private static final Integer NETWORK_TIMEOUT = Integer.valueOf(10000);
    private static int POOL_NUM = 5;
    private static int REDIRECT_LIMIT = 5;
    private static ExecutorService _executor;
    private static volatile Boolean _executor_pred = Boolean.valueOf(true);

    private static HttpURLConnection _requestConnect(String s)
    {
        Object obj;
        obj = new URL(s);
        if (!((URL) (obj)).getProtocol().equals("https"))
        {
            break MISSING_BLOCK_LABEL_42;
        }
        obj = (HttpsURLConnection)((URL) (obj)).openConnection();
        ((HttpsURLConnection) (obj)).setHostnameVerifier(new StrictHostnameVerifier());
        return ((HttpURLConnection) (obj));
        obj = (HttpURLConnection)((URL) (obj)).openConnection();
        return ((HttpURLConnection) (obj));
        MalformedURLException malformedurlexception;
        malformedurlexception;
        Log.getLogger("Ping").info((new StringBuilder("Pinging Url: MalformedURL ")).append(s).toString());
_L2:
        return null;
        s;
        Log.getLogger("Ping").info((new StringBuilder("Pinging Url: Exception opening url (")).append(s.getLocalizedMessage()).append(")").toString());
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static final String getAbsoluteUrl(String s, String s1)
    {
        if (s1.length() <= 0) goto _L2; else goto _L1
_L1:
        if (s1.toLowerCase().startsWith("http"))
        {
            return s1;
        }
        if (!s1.toLowerCase().startsWith("/")) goto _L4; else goto _L3
_L3:
        s = new URL(s);
        s = (new URL(s.getProtocol(), s.getHost(), s.getPort(), s1)).toString();
        return s;
        s;
        Log.getLogger("Ping").info("Pinging Url: Exception when building redirect url.");
_L2:
        return "";
_L4:
        URL url;
        int i;
        url = new URL(s);
        s = url.getPath();
        i = s.lastIndexOf("/");
        if (i >= 0) goto _L6; else goto _L5
_L5:
        s = "/";
_L8:
        return (new URL(url.getProtocol(), url.getHost(), url.getPort(), (new StringBuilder(String.valueOf(s))).append(s1).toString())).toString();
_L6:
        s = s.substring(0, i + 1);
        if (true) goto _L8; else goto _L7
_L7:
        s;
        Log.getLogger("Ping").info("Pinging Url: Exception when building redirect url.");
        if (true) goto _L2; else goto _L9
_L9:
    }

    private static ExecutorService getExecutor()
    {
        com/auditude/ads/util/PingUtil;
        JVM INSTR monitorenter ;
        ExecutorService executorservice;
        if (_executor_pred.booleanValue())
        {
            _executor = Executors.newFixedThreadPool(POOL_NUM);
            _executor_pred = Boolean.valueOf(false);
        }
        executorservice = _executor;
        com/auditude/ads/util/PingUtil;
        JVM INSTR monitorexit ;
        return executorservice;
        Exception exception;
        exception;
        throw exception;
    }

    public static final void pingUrl(String s)
    {
        pingUrl(s, 0);
    }

    public static final void pingUrl(String s, int i)
    {
        String s2 = AuditudeEnv.getInstance().getAdSettings().getUserAgent();
        String s1 = s2;
        if (!StringUtil.isNotNullOrEmpty(s2))
        {
            s1 = System.getProperty("http.agent");
        }
        pingUrlHttpURLConnection(s, s1, i);
    }

    private static final void pingUrlHttpURLConnection(final String url, final String userAgent, final int redirect)
    {
        if (redirect < REDIRECT_LIMIT)
        {
            getExecutor().execute(new Runnable() {

                private final int val$redirect;
                private final String val$url;
                private final String val$userAgent;

                public void run()
                {
                    String s1;
                    String s2;
                    HttpURLConnection httpurlconnection;
                    String s3;
                    String s4;
                    String s5;
                    HttpURLConnection httpurlconnection2;
                    HttpURLConnection httpurlconnection3;
                    HttpURLConnection httpurlconnection4;
                    boolean flag;
                    boolean flag1;
                    boolean flag2;
                    boolean flag3;
                    boolean flag4;
                    boolean flag5;
                    boolean flag6;
                    boolean flag7;
                    boolean flag8;
                    boolean flag9;
                    httpurlconnection3 = null;
                    httpurlconnection4 = null;
                    httpurlconnection = null;
                    httpurlconnection2 = null;
                    flag = false;
                    flag6 = false;
                    flag7 = false;
                    flag8 = false;
                    flag9 = false;
                    flag5 = false;
                    s1 = "";
                    s3 = s1;
                    flag2 = flag6;
                    s4 = s1;
                    flag3 = flag7;
                    s5 = s1;
                    flag4 = flag8;
                    s2 = s1;
                    flag1 = flag9;
                    HttpURLConnection httpurlconnection1 = PingUtil._requestConnect(url);
                    httpurlconnection2 = httpurlconnection1;
                    s3 = s1;
                    flag2 = flag6;
                    httpurlconnection3 = httpurlconnection1;
                    s4 = s1;
                    flag3 = flag7;
                    httpurlconnection4 = httpurlconnection1;
                    s5 = s1;
                    flag4 = flag8;
                    httpurlconnection = httpurlconnection1;
                    s2 = s1;
                    flag1 = flag9;
                    httpurlconnection1.setInstanceFollowRedirects(false);
                    String s;
                    s = s1;
                    if (httpurlconnection1 == null)
                    {
                        break MISSING_BLOCK_LABEL_824;
                    }
                    httpurlconnection2 = httpurlconnection1;
                    s3 = s1;
                    flag2 = flag6;
                    httpurlconnection3 = httpurlconnection1;
                    s4 = s1;
                    flag3 = flag7;
                    httpurlconnection4 = httpurlconnection1;
                    s5 = s1;
                    flag4 = flag8;
                    httpurlconnection = httpurlconnection1;
                    s2 = s1;
                    flag1 = flag9;
                    httpurlconnection1.setRequestMethod("GET");
                    httpurlconnection2 = httpurlconnection1;
                    s3 = s1;
                    flag2 = flag6;
                    httpurlconnection3 = httpurlconnection1;
                    s4 = s1;
                    flag3 = flag7;
                    httpurlconnection4 = httpurlconnection1;
                    s5 = s1;
                    flag4 = flag8;
                    httpurlconnection = httpurlconnection1;
                    s2 = s1;
                    flag1 = flag9;
                    httpurlconnection1.setConnectTimeout(PingUtil.NETWORK_TIMEOUT.intValue());
                    httpurlconnection2 = httpurlconnection1;
                    s3 = s1;
                    flag2 = flag6;
                    httpurlconnection3 = httpurlconnection1;
                    s4 = s1;
                    flag3 = flag7;
                    httpurlconnection4 = httpurlconnection1;
                    s5 = s1;
                    flag4 = flag8;
                    httpurlconnection = httpurlconnection1;
                    s2 = s1;
                    flag1 = flag9;
                    httpurlconnection1.setReadTimeout(PingUtil.NETWORK_TIMEOUT.intValue());
                    httpurlconnection2 = httpurlconnection1;
                    s3 = s1;
                    flag2 = flag6;
                    httpurlconnection3 = httpurlconnection1;
                    s4 = s1;
                    flag3 = flag7;
                    httpurlconnection4 = httpurlconnection1;
                    s5 = s1;
                    flag4 = flag8;
                    httpurlconnection = httpurlconnection1;
                    s2 = s1;
                    flag1 = flag9;
                    httpurlconnection1.setRequestProperty("User-Agent", userAgent);
                    httpurlconnection2 = httpurlconnection1;
                    s3 = s1;
                    flag2 = flag6;
                    httpurlconnection3 = httpurlconnection1;
                    s4 = s1;
                    flag3 = flag7;
                    httpurlconnection4 = httpurlconnection1;
                    s5 = s1;
                    flag4 = flag8;
                    httpurlconnection = httpurlconnection1;
                    s2 = s1;
                    flag1 = flag9;
                    httpurlconnection1.setRequestProperty("Connection", "close");
                    httpurlconnection2 = httpurlconnection1;
                    s3 = s1;
                    flag2 = flag6;
                    httpurlconnection3 = httpurlconnection1;
                    s4 = s1;
                    flag3 = flag7;
                    httpurlconnection4 = httpurlconnection1;
                    s5 = s1;
                    flag4 = flag8;
                    httpurlconnection = httpurlconnection1;
                    s2 = s1;
                    flag1 = flag9;
                    httpurlconnection1.connect();
                    httpurlconnection2 = httpurlconnection1;
                    s3 = s1;
                    flag2 = flag6;
                    httpurlconnection3 = httpurlconnection1;
                    s4 = s1;
                    flag3 = flag7;
                    httpurlconnection4 = httpurlconnection1;
                    s5 = s1;
                    flag4 = flag8;
                    httpurlconnection = httpurlconnection1;
                    s2 = s1;
                    flag1 = flag9;
                    Log.getLogger("Ping").info((new StringBuilder("Pinging Url [")).append(redirect).append("]: ").append(url).toString());
                    httpurlconnection2 = httpurlconnection1;
                    s3 = s1;
                    flag2 = flag6;
                    httpurlconnection3 = httpurlconnection1;
                    s4 = s1;
                    flag3 = flag7;
                    httpurlconnection4 = httpurlconnection1;
                    s5 = s1;
                    flag4 = flag8;
                    httpurlconnection = httpurlconnection1;
                    s2 = s1;
                    flag1 = flag9;
                    int i = httpurlconnection1.getResponseCode();
                    if (i != 302)
                    {
                        s = s1;
                        flag = flag5;
                        if (i != 301)
                        {
                            break MISSING_BLOCK_LABEL_773;
                        }
                    }
                    httpurlconnection2 = httpurlconnection1;
                    s3 = s1;
                    flag2 = flag6;
                    httpurlconnection3 = httpurlconnection1;
                    s4 = s1;
                    flag3 = flag7;
                    httpurlconnection4 = httpurlconnection1;
                    s5 = s1;
                    flag4 = flag8;
                    httpurlconnection = httpurlconnection1;
                    s2 = s1;
                    flag1 = flag9;
                    s1 = PingUtil.getAbsoluteUrl(url, httpurlconnection1.getHeaderField("Location"));
                    s = s1;
                    flag = flag5;
                    httpurlconnection2 = httpurlconnection1;
                    s3 = s1;
                    flag2 = flag6;
                    httpurlconnection3 = httpurlconnection1;
                    s4 = s1;
                    flag3 = flag7;
                    httpurlconnection4 = httpurlconnection1;
                    s5 = s1;
                    flag4 = flag8;
                    httpurlconnection = httpurlconnection1;
                    s2 = s1;
                    flag1 = flag9;
                    if (s1.length() <= 0)
                    {
                        break MISSING_BLOCK_LABEL_773;
                    }
                    s = s1;
                    flag = flag5;
                    httpurlconnection2 = httpurlconnection1;
                    s3 = s1;
                    flag2 = flag6;
                    httpurlconnection3 = httpurlconnection1;
                    s4 = s1;
                    flag3 = flag7;
                    httpurlconnection4 = httpurlconnection1;
                    s5 = s1;
                    flag4 = flag8;
                    httpurlconnection = httpurlconnection1;
                    s2 = s1;
                    flag1 = flag9;
                    if (s1.toLowerCase().startsWith("http"))
                    {
                        flag = true;
                        s = s1;
                    }
                    httpurlconnection2 = httpurlconnection1;
                    s3 = s;
                    flag2 = flag;
                    httpurlconnection3 = httpurlconnection1;
                    s4 = s;
                    flag3 = flag;
                    httpurlconnection4 = httpurlconnection1;
                    s5 = s;
                    flag4 = flag;
                    httpurlconnection = httpurlconnection1;
                    s2 = s;
                    flag1 = flag;
                    httpurlconnection1.getInputStream().close();
                    if (httpurlconnection1 != null)
                    {
                        httpurlconnection1.disconnect();
                    }
                    if (flag)
                    {
                        Log.getLogger("Ping").info((new StringBuilder("Redirect to Url [")).append(redirect).append("]: ").append(s).toString());
                        PingUtil.pingUrl(s, redirect + 1);
                    }
_L2:
                    return;
                    Object obj;
                    obj;
                    httpurlconnection = httpurlconnection2;
                    s2 = s3;
                    flag1 = flag2;
                    Log.getLogger("Ping").info((new StringBuilder("Pinging Url: Timed out sending request to ")).append(url).toString());
                    if (httpurlconnection2 != null)
                    {
                        httpurlconnection2.disconnect();
                    }
                    if (!flag2) goto _L2; else goto _L1
_L1:
                    Log.getLogger("Ping").info((new StringBuilder("Redirect to Url [")).append(redirect).append("]: ").append(s3).toString());
                    PingUtil.pingUrl(s3, redirect + 1);
                    return;
                    obj;
                    httpurlconnection = httpurlconnection3;
                    s2 = s4;
                    flag1 = flag3;
                    Log.getLogger("Ping").info((new StringBuilder("Pinging Url: IOException while sending request, may retry(")).append(((IOException) (obj)).getLocalizedMessage()).append(")").toString());
                    if (httpurlconnection3 != null)
                    {
                        httpurlconnection3.disconnect();
                    }
                    if (!flag3) goto _L2; else goto _L3
_L3:
                    Log.getLogger("Ping").info((new StringBuilder("Redirect to Url [")).append(redirect).append("]: ").append(s4).toString());
                    PingUtil.pingUrl(s4, redirect + 1);
                    return;
                    obj;
                    httpurlconnection = httpurlconnection4;
                    s2 = s5;
                    flag1 = flag4;
                    Log.getLogger("Ping").info((new StringBuilder("Pinging Url: Unable to create HTTP connection to ")).append(url).toString());
                    if (httpurlconnection4 != null)
                    {
                        httpurlconnection4.disconnect();
                    }
                    if (!flag4) goto _L2; else goto _L4
_L4:
                    Log.getLogger("Ping").info((new StringBuilder("Redirect to Url [")).append(redirect).append("]: ").append(s5).toString());
                    PingUtil.pingUrl(s5, redirect + 1);
                    return;
                    obj;
                    if (httpurlconnection != null)
                    {
                        httpurlconnection.disconnect();
                    }
                    if (flag1)
                    {
                        Log.getLogger("Ping").info((new StringBuilder("Redirect to Url [")).append(redirect).append("]: ").append(s2).toString());
                        PingUtil.pingUrl(s2, redirect + 1);
                    }
                    throw obj;
                }

            
            {
                redirect = i;
                url = s;
                userAgent = s1;
                super();
            }
            });
            return;
        } else
        {
            Log.getLogger("Ping").info((new StringBuilder("Too many redirects. Abandon Url: ")).append(url).toString());
            return;
        }
    }




}
