// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.Context;
import android.content.res.Resources;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;

// Referenced classes of package com.livemixtapes:
//            AsyncHttp, App

private class Callback extends est
{

    final AsyncHttp this$0;

    private String getParamUrl(String s, Map map)
    {
        Object obj;
        String s1;
        if (map == null || map.size() == 0)
        {
            return s;
        }
        s1 = "";
        obj = s1;
        Iterator iterator = map.entrySet().iterator();
        map = s1;
_L3:
        obj = map;
        boolean flag = iterator.hasNext();
        if (flag) goto _L2; else goto _L1
_L1:
        obj = map;
_L4:
        map = s;
        java.util.yncGet yncget;
        if (((String) (obj)).length() > 0)
        {
            if (!s.contains("?"))
            {
                map = (new StringBuilder(String.valueOf(s))).append("?").append(((String) (obj)).substring(1)).toString();
            } else
            {
                map = (new StringBuilder(String.valueOf(s))).append(((String) (obj))).toString();
            }
        }
        return map;
_L2:
        obj = map;
        yncget = (java.util.ing)iterator.next();
        obj = map;
        map = (new StringBuilder(String.valueOf(map))).append("&").append(URLEncoder.encode((String)yncget.d(), "UTF-8")).append("=").append(URLEncoder.encode((String)yncget.d(), "UTF-8")).toString();
          goto _L3
        map;
          goto _L4
    }

    protected transient nseData doInBackground(Void avoid[])
    {
        Object obj1;
        avoid = null;
        obj1 = App.context.getResources().openRawResource(0x7f070001);
        Object obj;
        obj = KeyStore.getInstance("BKS");
        ((KeyStore) (obj)).load(((java.io.InputStream) (obj1)), "api42829".toCharArray());
        obj1 = new BasicHttpParams();
        SchemeRegistry schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("https", new SSLSocketFactory(((KeyStore) (obj))), 443));
        obj = new DefaultHttpClient(new ThreadSafeClientConnManager(((org.apache.http.params.HttpParams) (obj1)), schemeregistry), ((org.apache.http.params.HttpParams) (obj1)));
        avoid = ((Void []) (obj));
_L1:
        HttpGet httpget = new HttpGet(getParamUrl(url, params));
        httpget.setHeader("X-Api-Key", "bJGpttXhgbjsLEpbI9VPFj1pvizPrfLh");
        httpget.setHeader("User-Agent", "LiveMixtapes Android/1.0.84 BETA");
        Exception exception;
        try
        {
            avoid = avoid.execute(httpget);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            return getExceptionResponse(avoid);
        }
        return getDataResponse(avoid);
        exception;
        exception.printStackTrace();
          goto _L1
    }

    public Callback(String s, Map map, Callback callback, Boolean boolean1)
    {
        this$0 = AsyncHttp.this;
        super(s, map, callback, boolean1);
    }
}
