// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.AsyncTask;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tremorvideo.sdk.android.richmedia.ae;
import com.tremorvideo.sdk.android.videoad.ad;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia.b:
//            b

public class com.tremorvideo.sdk.android.richmedia.b.d extends WebView
{
    private class a extends WebViewClient
    {

        final com.tremorvideo.sdk.android.richmedia.b.d a;

        public void onPageFinished(WebView webview, String s)
        {
            if (s.equals(com.tremorvideo.sdk.android.richmedia.b.d.b(a)) && !com.tremorvideo.sdk.android.richmedia.b.d.c(a))
            {
                a.b();
                com.tremorvideo.sdk.android.richmedia.b.d.a(a, true);
                a.a();
            }
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            super.onReceivedError(webview, i, s, s1);
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            if (Uri.parse(s).getScheme().equals("tremorvideo"))
            {
                com.tremorvideo.sdk.android.richmedia.b.d.a(a, URI.create(s));
                return true;
            } else
            {
                return false;
            }
        }

        private a()
        {
            a = com.tremorvideo.sdk.android.richmedia.b.d.this;
            super();
        }

    }

    class b extends AsyncTask
    {

        String a;
        final com.tremorvideo.sdk.android.richmedia.b.d b;
        private boolean c;
        private boolean d;
        private boolean e;

        protected transient String a(String as[])
        {
            DefaultHttpClient defaulthttpclient;
            a = null;
            BasicHttpParams basichttpparams = new BasicHttpParams();
            basichttpparams.setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
            HttpConnectionParams.setTcpNoDelay(basichttpparams, true);
            defaulthttpclient = new DefaultHttpClient(basichttpparams);
            com.tremorvideo.sdk.android.richmedia.b.d.a(b, defaulthttpclient);
            if (!as[1].equals("POST")) goto _L2; else goto _L1
_L1:
            Object obj = as[0];
            Object obj1;
            Object obj2;
            Object obj3;
            obj1 = new HttpPost(new URI(((String) (obj))));
            ae.a(((HttpPost) (obj1)), ((String) (obj)));
            obj2 = new JSONObject(as[2]);
            obj3 = ((JSONObject) (obj2)).keys();
_L12:
            if (!((Iterator) (obj3)).hasNext()) goto _L4; else goto _L3
_L3:
            String s = (String)((Iterator) (obj3)).next();
            obj = ((JSONObject) (obj2)).getString(s);
_L5:
            if (obj != null)
            {
                try
                {
                    ((HttpPost) (obj1)).addHeader(s, ((String) (obj)));
                }
                // Misplaced declaration of an exception variable
                catch (String as[])
                {
                    ad.a(as);
                    d = true;
                    e = true;
                    b.a("url-request");
                    b.c("");
                    return null;
                }
            }
            continue; /* Loop/switch isn't completed */
            Exception exception;
            exception;
            ad.a(exception);
            exception = null;
            if (true) goto _L5; else goto _L4
_L4:
            ((HttpPost) (obj1)).setEntity(new StringEntity(as[3], "UTF-8"));
            as = defaulthttpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj1)));
            a = EntityUtils.toString(as.getEntity());
            if (!d)
            {
                b.a("url-request");
                d = true;
            }
            return Integer.toString(as.getStatusLine().getStatusCode());
_L2:
            exception = new HttpGet(new URI(as[0]));
            obj1 = new JSONObject(as[2]);
            obj2 = ((JSONObject) (obj1)).keys();
_L9:
            if (!((Iterator) (obj2)).hasNext()) goto _L7; else goto _L6
_L6:
            obj3 = (String)((Iterator) (obj2)).next();
            as = ((JSONObject) (obj1)).getString(((String) (obj3)));
_L10:
            if (as == null) goto _L9; else goto _L8
_L8:
            exception.addHeader(((String) (obj3)), as);
              goto _L9
            as;
            ad.a(as);
            as = null;
              goto _L10
_L7:
            as = defaulthttpclient.execute(exception);
            a = EntityUtils.toString(as.getEntity());
            if (!d)
            {
                b.a("url-request");
                d = true;
            }
            as = Integer.toString(as.getStatusLine().getStatusCode());
            return as;
            if (true) goto _L12; else goto _L11
_L11:
        }

        public void a()
        {
            d = true;
            b.a("url-request");
            c = true;
            b.a(this);
        }

        protected void a(String s)
        {
            if (!d)
            {
                b.a("url-request");
                d = true;
            }
            if (!isCancelled() && !c) goto _L2; else goto _L1
_L1:
            b.a(this);
            return;
_L2:
            if (s != null && Integer.parseInt(s) == 200)
            {
                b.b(a);
            } else
            if (!e)
            {
                b.c(a);
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        protected void b(String s)
        {
            if (!d)
            {
                b.a("url-request");
                d = true;
            }
            b.a(this);
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((String[])aobj);
        }

        protected void onCancelled(Object obj)
        {
            b((String)obj);
        }

        protected void onPostExecute(Object obj)
        {
            a((String)obj);
        }

        b()
        {
            b = com.tremorvideo.sdk.android.richmedia.b.d.this;
            super();
            c = false;
            d = false;
            e = false;
        }
    }

    private class c extends WebChromeClient
    {

        final com.tremorvideo.sdk.android.richmedia.b.d a;

        public void onConsoleMessage(String s, int i, String s1)
        {
        }

        public boolean onConsoleMessage(ConsoleMessage consolemessage)
        {
            return false;
        }

        private c()
        {
            a = com.tremorvideo.sdk.android.richmedia.b.d.this;
            super();
        }

    }

    public class d
        implements Runnable
    {

        String a;
        final com.tremorvideo.sdk.android.richmedia.b.d b;

        public void run()
        {
            b.loadUrl((new StringBuilder()).append("javascript:").append(a).toString());
        }

        public d(String s)
        {
            b = com.tremorvideo.sdk.android.richmedia.b.d.this;
            super();
            a = s;
        }
    }

    public class e
        implements Runnable
    {

        Map a;
        final com.tremorvideo.sdk.android.richmedia.b.d b;

        public void run()
        {
            b b1 = b. new b();
            com.tremorvideo.sdk.android.richmedia.b.d.a(b).add(b1);
            if (a.containsKey("data"))
            {
                b1.execute(new String[] {
                    (String)a.get("url"), (String)a.get("type"), (String)a.get("header"), (String)a.get("data")
                });
                return;
            } else
            {
                b1.execute(new String[] {
                    (String)a.get("url"), (String)a.get("type"), (String)a.get("header")
                });
                return;
            }
        }

        public e(Map map)
        {
            b = com.tremorvideo.sdk.android.richmedia.b.d.this;
            super();
            a = map;
        }
    }


    a a;
    com.tremorvideo.sdk.android.richmedia.b.b b;
    public float c;
    public boolean d;
    private boolean e;
    private JSONObject f;
    private ArrayList g;
    private String h;

    public com.tremorvideo.sdk.android.richmedia.b.d(Context context)
    {
        super(context);
        c = 255F;
        d = false;
        clearCache(true);
        c();
    }

    static ArrayList a(com.tremorvideo.sdk.android.richmedia.b.d d1)
    {
        return d1.g;
    }

    static void a(com.tremorvideo.sdk.android.richmedia.b.d d1, URI uri)
    {
        d1.a(uri);
    }

    static void a(com.tremorvideo.sdk.android.richmedia.b.d d1, HttpClient httpclient)
    {
        d1.a(httpclient);
    }

    private void a(URI uri)
    {
        Object obj;
        obj = uri.getHost();
        Object obj1 = URLEncodedUtils.parse(uri, "UTF-8");
        uri = new HashMap();
        NameValuePair namevaluepair;
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); uri.put(namevaluepair.getName(), namevaluepair.getValue()))
        {
            namevaluepair = (NameValuePair)((Iterator) (obj1)).next();
        }

        if (!((String) (obj)).equals("url-request")) goto _L2; else goto _L1
_L1:
        ((Activity)getContext()).runOnUiThread(new e(uri));
_L4:
        return;
_L2:
        if (((String) (obj)).equals("trigger-event"))
        {
            obj = com.tremorvideo.sdk.android.videoad.aw.b.a((String)uri.get("event_type"));
            if (obj == com.tremorvideo.sdk.android.videoad.aw.b.ao)
            {
                String s = (String)uri.get("url");
                b.a(((com.tremorvideo.sdk.android.videoad.aw.b) (obj)), s);
            }
            if (obj == com.tremorvideo.sdk.android.videoad.aw.b.an)
            {
                String s1 = (String)uri.get("url");
                b.a(((com.tremorvideo.sdk.android.videoad.aw.b) (obj)), s1);
            }
            if (obj == com.tremorvideo.sdk.android.videoad.aw.b.ap && uri.containsKey("id"))
            {
                uri = (String)uri.get("id");
                b.a(uri);
            }
            a("trigger-event");
            return;
        }
        if (((String) (obj)).equals("cancel-request") && g != null)
        {
            uri = g.iterator();
            while (uri.hasNext()) 
            {
                b b1 = (b)uri.next();
                b1.cancel(true);
                b1.a();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(HttpClient httpclient)
    {
        if (ad.q() < 14)
        {
            LayeredSocketFactory layeredsocketfactory = new LayeredSocketFactory() {

                SSLSocketFactory a;
                final com.tremorvideo.sdk.android.richmedia.b.d b;

                private void a(Socket socket, String s)
                {
                    try
                    {
                        Field field = java/net/InetAddress.getDeclaredField("hostName");
                        field.setAccessible(true);
                        field.set(socket.getInetAddress(), s);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Socket socket)
                    {
                        return;
                    }
                }

                public Socket connectSocket(Socket socket, String s, int i, InetAddress inetaddress, int j, HttpParams httpparams)
                    throws IOException
                {
                    return a.connectSocket(socket, s, i, inetaddress, j, httpparams);
                }

                public Socket createSocket()
                    throws IOException
                {
                    return a.createSocket();
                }

                public Socket createSocket(Socket socket, String s, int i, boolean flag)
                    throws IOException
                {
                    a(socket, s);
                    return a.createSocket(socket, s, i, flag);
                }

                public boolean isSecure(Socket socket)
                    throws IllegalArgumentException
                {
                    return a.isSecure(socket);
                }

            
            {
                b = com.tremorvideo.sdk.android.richmedia.b.d.this;
                super();
                a = SSLSocketFactory.getSocketFactory();
            }
            };
            httpclient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", layeredsocketfactory, 443));
        }
    }

    static boolean a(com.tremorvideo.sdk.android.richmedia.b.d d1, boolean flag)
    {
        d1.e = flag;
        return flag;
    }

    static String b(com.tremorvideo.sdk.android.richmedia.b.d d1)
    {
        return d1.h;
    }

    private void c()
    {
        setScrollContainer(false);
        setBackgroundColor(0);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        WebSettings websettings = getSettings();
        websettings.setSupportZoom(false);
        websettings.setJavaScriptEnabled(true);
        websettings.setUseWideViewPort(true);
        websettings.setCacheMode(2);
        if (ad.q() >= 8)
        {
            websettings.setPluginState(android.webkit.WebSettings.PluginState.ON);
        }
        websettings.setAllowFileAccess(true);
        if (ad.q() >= 16)
        {
            websettings.setAllowFileAccessFromFileURLs(true);
        }
        a = new a();
        setWebViewClient(a);
        setWebChromeClient(new c());
        getSettings().setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.NORMAL);
        g = new ArrayList();
        e = false;
    }

    static boolean c(com.tremorvideo.sdk.android.richmedia.b.d d1)
    {
        return d1.e;
    }

    public void a()
    {
        setBackgroundColor(0);
        if (ad.q() > 10)
        {
            setLayerType(1, null);
        }
        onSizeChanged(getWidth(), getHeight(), 0, 0);
    }

    public void a(float f1)
    {
        if (ad.q() > 10 && f1 != c)
        {
            setAlpha(f1 / 255F);
        }
        c = f1;
    }

    public void a(com.tremorvideo.sdk.android.richmedia.b.b b1)
    {
        b = b1;
    }

    public void a(b b1)
    {
        if (g != null && g.contains(b1))
        {
            g.remove(b1);
        }
    }

    protected void a(String s)
    {
        e((new StringBuilder()).append("tremorcore.nativeCallComplete('").append(s).append("');").toString());
    }

    public void a(String s, JSONObject jsonobject)
    {
        for (Iterator iterator = g.iterator(); iterator.hasNext(); ((b)iterator.next()).cancel(true)) { }
        g.clear();
        e = false;
        h = s;
        f = jsonobject;
        loadUrl(s);
    }

    protected void b()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
            if (layoutparams instanceof android.widget.RelativeLayout.LayoutParams)
            {
                jsonobject.put("x", ((android.widget.RelativeLayout.LayoutParams)layoutparams).leftMargin);
                jsonobject.put("y", ((android.widget.RelativeLayout.LayoutParams)layoutparams).topMargin);
                jsonobject.put("width", layoutparams.width);
                jsonobject.put("height", layoutparams.height);
                if (ad.q() < 14)
                {
                    jsonobject.put("Android2Fix", 1);
                }
            }
        }
        catch (Exception exception)
        {
            ad.a(exception);
        }
        d(jsonobject.toString());
        e((new StringBuilder()).append("tremorcore.fireEvent('init',").append(f).append(");").toString());
    }

    protected void b(String s)
    {
        e((new StringBuilder()).append("tremorcore.urlRequestDidFinishLoading(").append(s).append(");").toString());
    }

    protected void c(String s)
    {
        e((new StringBuilder()).append("tremorcore.urlRequestDidFailWithError(").append(s).append(");").toString());
    }

    protected void d(String s)
    {
        e((new StringBuilder()).append("tremorcore.fireEvent('frameChange',").append(s).append(");").toString());
    }

    public void destroy()
    {
        d = true;
        for (Iterator iterator = g.iterator(); iterator.hasNext(); ((b)iterator.next()).cancel(true)) { }
        g.clear();
        g = null;
        f = null;
        e = false;
        super.destroyDrawingCache();
        super.destroy();
    }

    public void draw(Canvas canvas)
    {
        if (ad.q() < 11)
        {
            canvas.saveLayerAlpha(null, Math.round(c), 31);
            super.draw(canvas);
            canvas.restore();
            return;
        } else
        {
            super.draw(canvas);
            return;
        }
    }

    protected void e(String s)
    {
        if (s != null)
        {
            ((Activity)getContext()).runOnUiThread(new d(s));
        }
    }

    public void loadUrl(String s)
    {
        if (!d)
        {
            super.loadUrl(s);
        }
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        if (e)
        {
            JSONObject jsonobject = new JSONObject();
            try
            {
                android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
                if (layoutparams instanceof android.widget.RelativeLayout.LayoutParams)
                {
                    jsonobject.put("x", ((android.widget.RelativeLayout.LayoutParams)layoutparams).leftMargin);
                    jsonobject.put("y", ((android.widget.RelativeLayout.LayoutParams)layoutparams).topMargin);
                }
                jsonobject.put("width", i);
                jsonobject.put("height", j);
                if (ad.q() < 14)
                {
                    jsonobject.put("Android2Fix", 1);
                }
            }
            catch (Exception exception)
            {
                ad.a(exception);
            }
            d(jsonobject.toString());
        }
        super.onSizeChanged(i, j, k, l);
    }
}
