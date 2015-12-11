// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

// Referenced classes of package com.gotv.crackle.util:
//            Log

public class HttpManager
{

    private static final int REQUEST_TIME_OUT = 12000;
    private static final String TAG = "HttpManager";
    private static final DefaultHttpClient mClient;
    public static final Map mHeaders = new HashMap();

    private HttpManager()
    {
    }

    public static void addHeader(String s, String s1)
    {
        mHeaders.put(s, s1);
    }

    public static void addHeaders(HashMap hashmap)
    {
        mHeaders.putAll(hashmap);
    }

    public static void clearCookies()
    {
        mClient.getCookieStore().clear();
    }

    public static void displayCookies()
    {
        if (mClient != null)
        {
            Object obj = mClient.getCookieStore();
            if (obj != null)
            {
                obj = ((CookieStore) (obj)).getCookies();
                if (obj != null)
                {
                    Log.d("HttpManager", (new StringBuilder()).append("List<Cookie> has ").append(((List) (obj)).size()).append(" cookies").toString());
                    Iterator iterator = ((List) (obj)).iterator();
                    while (iterator.hasNext()) 
                    {
                        Object obj1 = (Cookie)iterator.next();
                        if (obj1 != null)
                        {
                            obj1 = obj1.toString();
                        } else
                        {
                            obj1 = "<null>";
                        }
                        Log.d("HttpManager", ((String) (obj1)));
                    }
                } else
                {
                    Log.d("HttpManager", "List<Cookie> is null");
                }
            }
            return;
        } else
        {
            Log.d("HttpManager", "DefaultHttpClient is null!");
            return;
        }
    }

    public static HttpResponse execute(HttpHost httphost, HttpGet httpget)
        throws IOException
    {
        return mClient.execute(httphost, httpget);
    }

    public static HttpResponse execute(HttpHead httphead)
        throws IOException
    {
        return mClient.execute(httphead);
    }

    public static HttpResponse execute(HttpUriRequest httpurirequest)
        throws IOException, IllegalStateException
    {
        return execute(httpurirequest, ((Map) (null)));
    }

    public static HttpResponse execute(HttpUriRequest httpurirequest, Map map)
        throws IOException, IllegalStateException
    {
        Log.d("HttpManager", "execute");
        String s;
        for (Iterator iterator = mHeaders.keySet().iterator(); iterator.hasNext(); httpurirequest.setHeader(s, (String)mHeaders.get(s)))
        {
            s = (String)iterator.next();
        }

        if (map != null)
        {
            String s1;
            for (Iterator iterator1 = map.keySet().iterator(); iterator1.hasNext(); httpurirequest.setHeader(s1, (String)map.get(s1)))
            {
                s1 = (String)iterator1.next();
            }

        }
        Log.d("HttpManager", (new StringBuilder()).append("mHeaders.size(): ").append(httpurirequest.getAllHeaders().length).toString());
        map = httpurirequest.getAllHeaders();
        int j = map.length;
        for (int i = 0; i < j; i++)
        {
            Header header = map[i];
            Log.d("HttpManager", (new StringBuilder()).append("mHeaders - ").append(header.getName()).append(": ").append(header.getValue()).toString());
        }

        return mClient.execute(httpurirequest);
    }

    public static CookieStore getCookieStore()
    {
        return mClient.getCookieStore();
    }

    public static void remove(String s)
    {
        mHeaders.remove(s);
    }

    public static void setHttpHeaderToken(String s)
    {
        mHeaders.put("token", s);
    }

    static 
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basichttpparams, "UTF-8");
        HttpConnectionParams.setStaleCheckingEnabled(basichttpparams, false);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 12000);
        HttpConnectionParams.setSoTimeout(basichttpparams, 12000);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        HttpClientParams.setRedirecting(basichttpparams, true);
        SchemeRegistry schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeregistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        mClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, schemeregistry), basichttpparams);
    }
}
