// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.livemixtapes:
//            console, App

public class AsyncHttp
{
    private class AsyncGet extends AsyncRequest
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
            java.util.Map.Entry entry;
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
            entry = (java.util.Map.Entry)iterator.next();
            obj = map;
            map = (new StringBuilder(String.valueOf(map))).append("&").append(URLEncoder.encode((String)entry.getKey(), "UTF-8")).append("=").append(URLEncoder.encode((String)entry.getValue(), "UTF-8")).toString();
              goto _L3
            map;
              goto _L4
        }

        protected transient HttpResponseData doInBackground(Void avoid[])
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

        public AsyncGet(String s, Map map, AsyncHttpCallback asynchttpcallback, Boolean boolean1)
        {
            this$0 = AsyncHttp.this;
            super(s, map, asynchttpcallback, boolean1);
        }
    }

    public static abstract class AsyncHttpCallback
    {

        protected abstract void always();

        protected abstract void exception(Exception exception1);

        protected abstract void success(String s, String s1, int i);

        public AsyncHttpCallback()
        {
        }
    }

    private class AsyncPost extends AsyncRequest
    {

        final AsyncHttp this$0;

        protected transient HttpResponseData doInBackground(Void avoid[])
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
            HttpPost httppost = getParamRequest(url, params);
            httppost.setHeader("X-Api-Key", "bJGpttXhgbjsLEpbI9VPFj1pvizPrfLh");
            httppost.setHeader("User-Agent", "LiveMixtapes Android/1.0.84 BETA");
            Exception exception;
            try
            {
                avoid = avoid.execute(httppost);
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

        protected HttpPost getParamRequest(String s, Map map)
        {
            s = new HttpPost(s);
            if (map == null || map.size() <= 0) goto _L2; else goto _L1
_L1:
            ArrayList arraylist;
            arraylist = new ArrayList();
            map = map.entrySet().iterator();
_L6:
            if (map.hasNext()) goto _L4; else goto _L3
_L3:
            try
            {
                s.setEntity(new UrlEncodedFormEntity(arraylist, "UTF-8"));
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                return s;
            }
_L2:
            return s;
_L4:
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            arraylist.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue()));
            if (true) goto _L6; else goto _L5
_L5:
        }

        public AsyncPost(String s, Map map, AsyncHttpCallback asynchttpcallback, Boolean boolean1)
        {
            this$0 = AsyncHttp.this;
            super(s, map, asynchttpcallback, boolean1);
        }
    }

    private static abstract class AsyncRequest extends AsyncTask
    {

        protected final AsyncHttpCallback callback;
        protected final Boolean json;
        protected final Map params;
        protected final String url;

        protected transient abstract HttpResponseData doInBackground(Void avoid[]);

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected HttpResponseData getDataResponse(HttpResponse httpresponse)
        {
            HttpResponseData httpresponsedata = new HttpResponseData(null);
            StatusLine statusline = httpresponse.getStatusLine();
            httpresponsedata.data = readEntity(httpresponse.getEntity());
            httpresponsedata.reasonPhrase = statusline.getReasonPhrase();
            httpresponsedata.statusCode = statusline.getStatusCode();
            return httpresponsedata;
        }

        protected HttpResponseData getExceptionResponse(Exception exception)
        {
            HttpResponseData httpresponsedata = new HttpResponseData(null);
            httpresponsedata.exception = exception;
            return httpresponsedata;
        }

        protected void onPostExecute(HttpResponseData httpresponsedata)
        {
            if (callback == null)
            {
                return;
            }
            if (httpresponsedata.exception != null)
            {
                callback.exception(httpresponsedata.exception);
            } else
            {
                callback.success(httpresponsedata.data, httpresponsedata.reasonPhrase, httpresponsedata.statusCode);
            }
            callback.always();
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((HttpResponseData)obj);
        }

        protected String readEntity(HttpEntity httpentity)
        {
            try
            {
                httpentity = EntityUtils.toString(httpentity);
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntity httpentity)
            {
                return "";
            }
            return httpentity;
        }

        public AsyncRequest(String s, Map map, AsyncHttpCallback asynchttpcallback, Boolean boolean1)
        {
            url = s;
            params = map;
            callback = asynchttpcallback;
            json = boolean1;
        }
    }

    private static final class HttpResponseData
    {

        public String data;
        public Exception exception;
        public String reasonPhrase;
        public int statusCode;

        private HttpResponseData()
        {
            data = "";
            reasonPhrase = "";
            statusCode = 0;
            exception = null;
        }

        HttpResponseData(HttpResponseData httpresponsedata)
        {
            this();
        }
    }


    public AsyncHttp()
    {
    }

    public final void get(String s)
    {
        get(s, null, null, Boolean.valueOf(false));
    }

    public final void get(String s, AsyncHttpCallback asynchttpcallback)
    {
        get(s, null, asynchttpcallback, Boolean.valueOf(false));
    }

    public final void get(String s, AsyncHttpCallback asynchttpcallback, Boolean boolean1)
    {
        get(s, null, asynchttpcallback, boolean1);
    }

    public final void get(String s, Boolean boolean1)
    {
        get(s, null, null, boolean1);
    }

    public final void get(String s, Map map, AsyncHttpCallback asynchttpcallback)
    {
        get(s, map, asynchttpcallback, Boolean.valueOf(false));
    }

    public final void get(String s, Map map, AsyncHttpCallback asynchttpcallback, Boolean boolean1)
    {
        (new AsyncGet(s, map, asynchttpcallback, boolean1)).execute(new Void[0]);
    }

    public final void post(String s)
    {
        post(s, null, null, Boolean.valueOf(false));
    }

    public final void post(String s, AsyncHttpCallback asynchttpcallback)
    {
        post(s, null, asynchttpcallback, Boolean.valueOf(false));
    }

    public final void post(String s, AsyncHttpCallback asynchttpcallback, Boolean boolean1)
    {
        post(s, null, asynchttpcallback, boolean1);
    }

    public final void post(String s, Boolean boolean1)
    {
        post(s, null, null, boolean1);
    }

    public final void post(String s, Map map, AsyncHttpCallback asynchttpcallback)
    {
        post(s, map, asynchttpcallback, Boolean.valueOf(false));
    }

    public final void post(String s, Map map, AsyncHttpCallback asynchttpcallback, Boolean boolean1)
    {
        (new AsyncPost(s, map, asynchttpcallback, boolean1)).execute(new Void[0]);
        console.log(new Object[] {
            (new StringBuilder("POSTING URL: ")).append(s).toString()
        });
    }
}
