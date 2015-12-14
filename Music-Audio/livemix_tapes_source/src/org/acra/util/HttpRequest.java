// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.acra.ACRA;
import org.acra.ACRAConfiguration;
import org.acra.log.ACRALog;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

// Referenced classes of package org.acra.util:
//            FakeSocketFactory

public final class HttpRequest
{
    private static class SocketTimeOutRetryHandler
        implements HttpRequestRetryHandler
    {

        private final HttpParams httpParams;
        private final int maxNrRetries;

        public boolean retryRequest(IOException ioexception, int i, HttpContext httpcontext)
        {
            if (ioexception instanceof SocketTimeoutException)
            {
                if (i <= maxNrRetries)
                {
                    if (httpParams != null)
                    {
                        i = HttpConnectionParams.getSoTimeout(httpParams) * 2;
                        HttpConnectionParams.setSoTimeout(httpParams, i);
                        ACRA.log.d(ACRA.LOG_TAG, (new StringBuilder()).append("SocketTimeOut - increasing time out to ").append(i).append(" millis and trying again").toString());
                    } else
                    {
                        ACRA.log.d(ACRA.LOG_TAG, "SocketTimeOut - no HttpParams, cannot increase time out. Trying again with current settings");
                    }
                    return true;
                }
                ACRA.log.d(ACRA.LOG_TAG, (new StringBuilder()).append("SocketTimeOut but exceeded max number of retries : ").append(maxNrRetries).toString());
            }
            return false;
        }

        private SocketTimeOutRetryHandler(HttpParams httpparams, int i)
        {
            httpParams = httpparams;
            maxNrRetries = i;
        }

    }


    private int connectionTimeOut;
    private Map headers;
    private String login;
    private int maxNrRetries;
    private String password;
    private int socketTimeOut;

    public HttpRequest()
    {
        connectionTimeOut = 3000;
        socketTimeOut = 3000;
        maxNrRetries = 3;
    }

    private UsernamePasswordCredentials getCredentials()
    {
        if (login != null || password != null)
        {
            return new UsernamePasswordCredentials(login, password);
        } else
        {
            return null;
        }
    }

    private HttpClient getHttpClient()
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        basichttpparams.setParameter("http.protocol.cookie-policy", "rfc2109");
        HttpConnectionParams.setConnectionTimeout(basichttpparams, connectionTimeOut);
        HttpConnectionParams.setSoTimeout(basichttpparams, socketTimeOut);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        Object obj = new SchemeRegistry();
        ((SchemeRegistry) (obj)).register(new Scheme("http", new PlainSocketFactory(), 80));
        if (ACRA.getConfig().disableSSLCertValidation())
        {
            ((SchemeRegistry) (obj)).register(new Scheme("https", new FakeSocketFactory(), 443));
        } else
        {
            ((SchemeRegistry) (obj)).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        }
        obj = new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, ((SchemeRegistry) (obj))), basichttpparams);
        ((DefaultHttpClient) (obj)).setHttpRequestRetryHandler(new SocketTimeOutRetryHandler(basichttpparams, maxNrRetries));
        return ((HttpClient) (obj));
    }

    private HttpEntityEnclosingRequestBase getHttpRequest(URL url, org.acra.sender.HttpSender.Method method, String s, org.acra.sender.HttpSender.Type type)
        throws UnsupportedEncodingException, UnsupportedOperationException
    {
        static class _cls1
        {

            static final int $SwitchMap$org$acra$sender$HttpSender$Method[];

            static 
            {
                $SwitchMap$org$acra$sender$HttpSender$Method = new int[org.acra.sender.HttpSender.Method.values().length];
                try
                {
                    $SwitchMap$org$acra$sender$HttpSender$Method[org.acra.sender.HttpSender.Method.POST.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$acra$sender$HttpSender$Method[org.acra.sender.HttpSender.Method.PUT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.org.acra.sender.HttpSender.Method[method.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 62
    //                   2 186;
           goto _L1 _L2 _L3
_L1:
        throw new UnsupportedOperationException((new StringBuilder()).append("Unknown method: ").append(method.name()).toString());
_L2:
        url = new HttpPost(url.toString());
_L5:
        method = getCredentials();
        if (method != null)
        {
            url.addHeader(BasicScheme.authenticate(method, "UTF-8", false));
        }
        url.setHeader("User-Agent", "Android");
        url.setHeader("Accept", "text/html,application/xml,application/json,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
        url.setHeader("Content-Type", type.getContentType());
        if (headers != null)
        {
            for (method = headers.keySet().iterator(); method.hasNext(); url.setHeader(type, (String)headers.get(type)))
            {
                type = (String)method.next();
            }

        }
        break; /* Loop/switch isn't completed */
_L3:
        url = new HttpPut(url.toString());
        if (true) goto _L5; else goto _L4
_L4:
        url.setEntity(new StringEntity(s, "UTF-8"));
        return url;
    }

    public static String getParamsAsFormString(Map map)
        throws UnsupportedEncodingException
    {
        StringBuilder stringbuilder = new StringBuilder();
        Object obj;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); stringbuilder.append(URLEncoder.encode(obj.toString(), "UTF-8")))
        {
            Object obj1 = iterator.next();
            if (stringbuilder.length() != 0)
            {
                stringbuilder.append('&');
            }
            obj = map.get(obj1);
            if (obj == null)
            {
                obj = "";
            }
            stringbuilder.append(URLEncoder.encode(obj1.toString(), "UTF-8"));
            stringbuilder.append('=');
        }

        return stringbuilder.toString();
    }

    public void send(URL url, org.acra.sender.HttpSender.Method method, String s, org.acra.sender.HttpSender.Type type)
        throws IOException
    {
        HttpClient httpclient;
        httpclient = getHttpClient();
        method = getHttpRequest(url, method, s, type);
        ACRA.log.d(ACRA.LOG_TAG, (new StringBuilder()).append("Sending request to ").append(url).toString());
        url = null;
        method = httpclient.execute(method, new BasicHttpContext());
        if (method == null)
        {
            break MISSING_BLOCK_LABEL_206;
        }
        url = method;
        if (method.getStatusLine() == null)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        url = method;
        s = Integer.toString(method.getStatusLine().getStatusCode());
        url = method;
        if (s.equals("409"))
        {
            break MISSING_BLOCK_LABEL_194;
        }
        url = method;
        if (s.equals("403"))
        {
            break MISSING_BLOCK_LABEL_194;
        }
        url = method;
        if (s.startsWith("4"))
        {
            break MISSING_BLOCK_LABEL_146;
        }
        url = method;
        if (!s.startsWith("5"))
        {
            break MISSING_BLOCK_LABEL_194;
        }
        url = method;
        throw new IOException((new StringBuilder()).append("Host returned error code ").append(s).toString());
        method;
        if (url != null)
        {
            url.getEntity().consumeContent();
        }
        throw method;
        url = method;
        EntityUtils.toString(method.getEntity());
        if (method != null)
        {
            method.getEntity().consumeContent();
        }
        return;
    }

    public void setConnectionTimeOut(int i)
    {
        connectionTimeOut = i;
    }

    public void setHeaders(Map map)
    {
        headers = map;
    }

    public void setLogin(String s)
    {
        login = s;
    }

    public void setMaxNrRetries(int i)
    {
        maxNrRetries = i;
    }

    public void setPassword(String s)
    {
        password = s;
    }

    public void setSocketTimeOut(int i)
    {
        socketTimeOut = i;
    }
}
