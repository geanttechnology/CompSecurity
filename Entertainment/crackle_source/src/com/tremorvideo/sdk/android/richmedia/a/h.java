// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tremorvideo.sdk.android.adapter.TremorAdapterCalls;
import com.tremorvideo.sdk.android.richmedia.ae;
import com.tremorvideo.sdk.android.videoad.Playvideo;
import com.tremorvideo.sdk.android.videoad.ad;
import com.tremorvideo.sdk.android.videoad.at;
import com.tremorvideo.sdk.android.videoad.bo;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
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
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia.a:
//            e

public class h extends WebView
    implements com.tremorvideo.sdk.android.videoad.ax.e
{
    private class a extends WebViewClient
    {

        final h a;

        public void onPageFinished(WebView webview, String s)
        {
            if (s.equals(h.d(a)) && !h.e(a))
            {
                webview = new JSONObject();
                try
                {
                    s = a.getLayoutParams();
                    if (s instanceof android.widget.RelativeLayout.LayoutParams)
                    {
                        webview.put("x", ((android.widget.RelativeLayout.LayoutParams)s).leftMargin);
                        webview.put("y", ((android.widget.RelativeLayout.LayoutParams)s).topMargin);
                        webview.put("width", ((android.view.ViewGroup.LayoutParams) (s)).width);
                        webview.put("height", ((android.view.ViewGroup.LayoutParams) (s)).height);
                        webview.put("AndroidVersion", ad.q());
                    }
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    ad.a(s);
                }
                a.d(webview.toString());
                h.a(a, true);
                a.b();
                (new Thread(this) {

                    final a a;

                    public void run()
                    {
                        a.a.c();
                    }

            
            {
                a = a1;
                super();
            }
                }).start();
            }
        }

        public void onReceivedError(WebView webview, int i1, String s, String s1)
        {
            super.onReceivedError(webview, i1, s, s1);
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            if (s.indexOf("tel:") > -1)
            {
                a.g.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(s)));
                return true;
            }
            if (Uri.parse(s).getScheme().equals("tmwi"))
            {
                h.a(a, URI.create(s));
                return true;
            } else
            {
                return false;
            }
        }

        private a()
        {
            a = h.this;
            super();
        }

    }

    class b extends AsyncTask
    {

        String a;
        final h b;
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
            h.a(b, defaulthttpclient);
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
_L10:
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
                d = true;
            }
            return Integer.toString(as.getStatusLine().getStatusCode());
_L2:
            obj1 = as[0];
            exception = new HttpGet(new URI(((String) (obj1))));
            ae.a(exception, ((String) (obj1)));
            obj1 = new JSONObject(as[2]);
            obj2 = ((JSONObject) (obj1)).keys();
_L7:
            if (!((Iterator) (obj2)).hasNext())
            {
                break MISSING_BLOCK_LABEL_343;
            }
            obj3 = (String)((Iterator) (obj2)).next();
            as = ((JSONObject) (obj1)).getString(((String) (obj3)));
_L8:
            if (as == null) goto _L7; else goto _L6
_L6:
            exception.addHeader(((String) (obj3)), as);
              goto _L7
            as;
            ad.a(as);
            as = null;
              goto _L8
            as = defaulthttpclient.execute(exception);
            a = EntityUtils.toString(as.getEntity());
            if (!d)
            {
                d = true;
            }
            as = Integer.toString(as.getStatusLine().getStatusCode());
            return as;
            if (true) goto _L10; else goto _L9
_L9:
        }

        public void a()
        {
            d = true;
            c = true;
            b.a(this);
        }

        protected void a(String s)
        {
            if (!d)
            {
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
            b = h.this;
            super();
            c = false;
            d = false;
            e = false;
        }
    }

    private class c extends android.view.GestureDetector.SimpleOnGestureListener
    {

        final h a;

        public boolean onDoubleTap(MotionEvent motionevent)
        {
            h.a(a).set(true);
            h.b(a).set(System.currentTimeMillis());
            return true;
        }

        public boolean onDoubleTapEvent(MotionEvent motionevent)
        {
            h.a(a).set(true);
            h.b(a).set(System.currentTimeMillis());
            return true;
        }

        private c()
        {
            a = h.this;
            super();
        }

    }

    private class d extends WebChromeClient
    {

        final h a;

        public void onConsoleMessage(String s, int i1, String s1)
        {
            ad.d((new StringBuilder()).append("GenericWebview Console: ").append(s).toString());
        }

        public boolean onConsoleMessage(ConsoleMessage consolemessage)
        {
            ad.d((new StringBuilder()).append("GenericWebview Console: ").append(consolemessage.message()).toString());
            return false;
        }

        private d()
        {
            a = h.this;
            super();
        }

    }

    public class e
        implements Runnable
    {

        Map a;
        final h b;

        public void run()
        {
            b b1 = b. new b();
            h.c(b).add(b1);
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
            b = h.this;
            super();
            a = map;
        }
    }

    public class f
        implements Runnable
    {

        String a;
        final h b;

        public void run()
        {
            if (ad.q() < 19)
            {
                b.loadUrl((new StringBuilder()).append("javascript:").append(a).toString());
                return;
            } else
            {
                b.evaluateJavascript(a, null);
                return;
            }
        }

        public f(String s)
        {
            b = h.this;
            super();
            a = s;
        }
    }

    class g extends TimerTask
    {

        String a;
        final h b;

        public void run()
        {
            b.h.purge();
            b.h.cancel();
            b.h = null;
            b.g.runOnUiThread(new Runnable(this) {

                final g a;

                public void run()
                {
                    if (!a.b.d)
                    {
                        a.b.loadUrl(a.a);
                    }
                }

            
            {
                a = g1;
                super();
            }
            });
        }

        public g(String s)
        {
            b = h.this;
            super();
            a = s;
        }
    }


    a a;
    com.tremorvideo.sdk.android.richmedia.a.e b;
    public float c;
    public boolean d;
    int e;
    Context f;
    Activity g;
    Timer h;
    JSONObject i;
    private boolean j;
    private JSONObject k;
    private ArrayList l;
    private String m;
    private GestureDetector n;
    private AtomicBoolean o;
    private AtomicLong p;

    public h(Context context, int i1, String s, JSONObject jsonobject, JSONObject jsonobject1)
    {
        super(context);
        c = 255F;
        d = false;
        e = -1;
        o = new AtomicBoolean(false);
        p = new AtomicLong(0L);
        f = context;
        g = (Activity)context;
        clearCache(true);
        e = i1;
        m = s;
        k = jsonobject;
        i = jsonobject1;
        d();
    }

    static AtomicBoolean a(h h1)
    {
        return h1.o;
    }

    static void a(h h1, URI uri)
    {
        h1.a(uri);
    }

    static void a(h h1, HttpClient httpclient)
    {
        h1.a(httpclient);
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
        a("url-request");
_L5:
        return;
_L2:
        if (((String) (obj)).equals("fire-tracking"))
        {
            obj = (String)uri.get("event_tag");
            if (obj != null)
            {
                ArrayList arraylist = new ArrayList();
                uri = uri.entrySet().iterator();
                do
                {
                    if (!uri.hasNext())
                    {
                        break;
                    }
                    java.util.Map.Entry entry = (java.util.Map.Entry)uri.next();
                    if (!((String)entry.getKey()).equals("event_tag"))
                    {
                        arraylist.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue()));
                    }
                } while (true);
                b.a(((String) (obj)), arraylist);
            }
            a("fire-tracking");
            return;
        }
        if (!((String) (obj)).equals("open-map-view"))
        {
            break; /* Loop/switch isn't completed */
        }
        if (uri.get("locations") == null)
        {
            break MISSING_BLOCK_LABEL_587;
        }
        uri = URLDecoder.decode((String)uri.get("locations"), "UTF-8");
_L3:
        ad.d((new StringBuilder()).append("locations:").append(uri).toString());
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_592;
        }
        if (uri.length() > 0)
        {
            uri = (new JSONArray(uri)).getJSONObject(0);
            if (uri.has("long") && uri.has("lat"))
            {
                double d1 = uri.getDouble("long");
                double d2 = uri.getDouble("lat");
                obj = new StringBuilder("geo:");
                ((StringBuilder) (obj)).append(d2);
                ((StringBuilder) (obj)).append(",");
                ((StringBuilder) (obj)).append(d1);
                ((StringBuilder) (obj)).append("?q=");
                ((StringBuilder) (obj)).append(d2);
                ((StringBuilder) (obj)).append(",");
                ((StringBuilder) (obj)).append(d1);
                ((StringBuilder) (obj)).append("(");
                if (uri.has("name"))
                {
                    ((StringBuilder) (obj)).append(URLEncoder.encode(uri.getString("name"), "UTF-8"));
                }
                ((StringBuilder) (obj)).append("+");
                if (uri.has("address"))
                {
                    ((StringBuilder) (obj)).append(URLEncoder.encode(uri.getString("address"), "UTF-8"));
                }
                ((StringBuilder) (obj)).append(")");
                ((StringBuilder) (obj)).append("&z=16");
                a("open-map-view");
                uri = new Intent("android.intent.action.VIEW", Uri.parse(((StringBuilder) (obj)).toString()));
                g.startActivityForResult(uri, 12);
                TremorAdapterCalls.onLeaveApp();
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_592;
        uri = null;
          goto _L3
        try
        {
            a("open-map-view");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (URI uri)
        {
            a("open-map-view");
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
        if (!((String) (obj)).equals("open-web-view"))
        {
            break MISSING_BLOCK_LABEL_708;
        }
        a("open-web-view");
        try
        {
            uri = (String)uri.get("url");
        }
        // Misplaced declaration of an exception variable
        catch (URI uri)
        {
            return;
        }
        if (uri == null) goto _L5; else goto _L6
_L6:
        if (uri.length() <= 0) goto _L5; else goto _L7
_L7:
        obj = new Intent(g, com/tremorvideo/sdk/android/videoad/Playvideo);
        ((Intent) (obj)).putExtra("tremorVideoType", "webview");
        ((Intent) (obj)).putExtra("tremorVideoURL", URLDecoder.decode(uri, "UTF-8"));
        ((Intent) (obj)).putExtra("curEventID", -1);
        g.startActivityForResult(((Intent) (obj)), 12);
        return;
        if (!((String) (obj)).equals("open-url"))
        {
            break MISSING_BLOCK_LABEL_833;
        }
        a("open-url");
        try
        {
            uri = (String)uri.get("url");
        }
        // Misplaced declaration of an exception variable
        catch (URI uri)
        {
            return;
        }
        if (uri == null) goto _L5; else goto _L8
_L8:
        if (uri.length() <= 0) goto _L5; else goto _L9
_L9:
        obj = URLDecoder.decode(uri, "UTF-8");
        uri = ((URI) (obj));
        if (!((String) (obj)).startsWith("http"))
        {
            uri = (new StringBuilder()).append("http://").append(((String) (obj))).toString();
        }
        obj = new Intent("android.intent.action.VIEW");
        ((Intent) (obj)).setData(Uri.parse(uri));
        g.startActivityForResult(((Intent) (obj)), 12);
        TremorAdapterCalls.onLeaveApp();
        return;
        if (((String) (obj)).equals("show-zip-picker"))
        {
            a("show-zip-picker");
            b.a(this);
            return;
        }
        if (((String) (obj)).equals("trigger-pause-ad"))
        {
            a("trigger-pause-ad");
            return;
        }
        if (((String) (obj)).equals("trigger-resume-ad"))
        {
            a("trigger-resume-ad");
            return;
        }
        if (((String) (obj)).equals("cancel-request"))
        {
            if (l != null)
            {
                for (uri = l.iterator(); uri.hasNext(); ((b) (obj)).a())
                {
                    obj = (b)uri.next();
                    ((b) (obj)).cancel(true);
                }

            }
            a("cancel-request");
            return;
        } else
        {
            a(((String) (obj)));
            return;
        }
    }

    private void a(HttpClient httpclient)
    {
        if (ad.q() < 14)
        {
            LayeredSocketFactory layeredsocketfactory = new LayeredSocketFactory() {

                SSLSocketFactory a;
                final h b;

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

                public Socket connectSocket(Socket socket, String s, int i1, InetAddress inetaddress, int j1, HttpParams httpparams)
                    throws IOException
                {
                    return a.connectSocket(socket, s, i1, inetaddress, j1, httpparams);
                }

                public Socket createSocket()
                    throws IOException
                {
                    return a.createSocket();
                }

                public Socket createSocket(Socket socket, String s, int i1, boolean flag)
                    throws IOException
                {
                    a(socket, s);
                    return a.createSocket(socket, s, i1, flag);
                }

                public boolean isSecure(Socket socket)
                    throws IllegalArgumentException
                {
                    return a.isSecure(socket);
                }

            
            {
                b = h.this;
                super();
                a = SSLSocketFactory.getSocketFactory();
            }
            };
            httpclient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", layeredsocketfactory, 443));
        }
    }

    static boolean a(h h1, boolean flag)
    {
        h1.j = flag;
        return flag;
    }

    static AtomicLong b(h h1)
    {
        return h1.p;
    }

    static ArrayList c(h h1)
    {
        return h1.l;
    }

    static String d(h h1)
    {
        return h1.m;
    }

    private void d()
    {
        setScrollContainer(false);
        setBackgroundColor(0);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        requestFocus(130);
        setBackgroundColor(0);
        if (ad.q() > 10)
        {
            setLayerType(1, null);
        }
        WebSettings websettings = getSettings();
        websettings.setSupportZoom(false);
        websettings.setJavaScriptEnabled(true);
        websettings.setUseWideViewPort(true);
        websettings.setLoadWithOverviewMode(true);
        websettings.setCacheMode(2);
        getSettings().setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.NORMAL);
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
        setWebChromeClient(new d());
        l = new ArrayList();
        j = false;
        n = new GestureDetector(f, new c());
        addJavascriptInterface(this, "AndroidDevice");
        for (Iterator iterator = l.iterator(); iterator.hasNext(); ((b)iterator.next()).cancel(true)) { }
        l.clear();
        j = false;
        h = new Timer();
        h.schedule(new g(m), 100L);
    }

    static boolean e(h h1)
    {
        return h1.j;
    }

    public int a()
    {
        return e;
    }

    public void a(float f1)
    {
        if (ad.q() > 10 && f1 != c)
        {
            setAlpha(f1 / 255F);
        }
        c = f1;
    }

    public void a(int i1, int j1)
    {
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            offsetLeftAndRight(i1);
            offsetTopAndBottom(j1);
            return;
        } else
        {
            setX(i1);
            setY(j1);
            return;
        }
    }

    public void a(com.tremorvideo.sdk.android.richmedia.a.e e1)
    {
        b = e1;
    }

    public void a(b b1)
    {
        if (l != null && l.contains(b1))
        {
            l.remove(b1);
        }
    }

    protected void a(String s)
    {
        e((new StringBuilder()).append("TMWI.nativeCallComplete('").append(s).append("');").toString());
    }

    public void b()
    {
        setBackgroundColor(0);
        if (ad.q() > 10)
        {
            setLayerType(1, null);
        }
        onSizeChanged(getWidth(), getHeight(), 0, 0);
    }

    protected void b(String s)
    {
        e((new StringBuilder()).append("TMWI.urlRequestDidFinishLoading(").append(s).append(");").toString());
    }

    protected void c()
    {
        Object obj;
        k.put("AppID", ad.c);
        obj = ad.v();
        at at1 = at.a();
        k.put("OS", at1.d);
        k.put("OS_version", at1.e);
        k.put("carrier", at1.l);
        k.put("connection", at1.i);
        k.put("make", at1.b);
        k.put("sdk_version", at1.a);
        k.put("udid", at1.f);
        k.put("opt-out", at1.g);
        k.put("androidID", at1.h);
        k.put("AndroidVersion", ad.q());
        if (i != null)
        {
            String s;
            for (Iterator iterator = i.keys(); iterator.hasNext(); k.put(s, i.get(s)))
            {
                s = (String)iterator.next();
            }

        }
          goto _L1
_L3:
        e((new StringBuilder()).append("TMWI.fireEvent('init',").append(k).append(");").toString());
        return;
_L1:
        try
        {
            bo.a(((Context) (obj)), true);
            k.put("Lat", bo.a);
            k.put("Long", bo.b);
        }
        catch (Exception exception)
        {
            try
            {
                ad.a(exception);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ad.d("Failed to add additional parameters");
            }
        }
        if (true) goto _L3; else goto _L2
_L2:
    }

    protected void c(String s)
    {
        e((new StringBuilder()).append("TMWI.urlRequestDidFailWithError(").append(s).append(");").toString());
    }

    protected void d(String s)
    {
        e((new StringBuilder()).append("TMWI.fireEvent('frameChange',").append(s).append(");").toString());
    }

    public void destroy()
    {
        d = true;
        for (Iterator iterator = l.iterator(); iterator.hasNext(); ((b)iterator.next()).cancel(true)) { }
        l.clear();
        l = null;
        k = null;
        j = false;
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
            ((Activity)getContext()).runOnUiThread(new f(s));
        }
    }

    public void executeSDKCall(String s)
    {
        a(URI.create(s));
    }

    public void f(String s)
    {
        ad.d((new StringBuilder()).append("GenericWebView:onZipChanged zip=").append(s).toString());
        e((new StringBuilder()).append("TMWI.fireEvent('onZipPicked','").append(s).append("');").toString());
    }

    public void loadUrl(String s)
    {
        if (!d)
        {
            super.loadUrl(s);
        }
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        if (j)
        {
            JSONObject jsonobject = new JSONObject();
            try
            {
                android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
                if (layoutparams instanceof android.widget.RelativeLayout.LayoutParams)
                {
                    jsonobject.put("x", ((android.widget.RelativeLayout.LayoutParams)layoutparams).leftMargin);
                    jsonobject.put("y", ((android.widget.RelativeLayout.LayoutParams)layoutparams).topMargin);
                    jsonobject.put("width", ((android.widget.RelativeLayout.LayoutParams)layoutparams).width);
                    jsonobject.put("height", ((android.widget.RelativeLayout.LayoutParams)layoutparams).height);
                }
                jsonobject.put("AndroidVersion", ad.q());
            }
            catch (Exception exception)
            {
                ad.a(exception);
            }
            d(jsonobject.toString());
        }
        super.onSizeChanged(i1, j1, k1, l1);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
label0:
        {
            boolean flag1 = true;
            requestFocus(130);
            flag = flag1;
            if (motionevent.getPointerId((motionevent.getAction() & 0xff00) >> 8) != 0)
            {
                break label0;
            }
            n.onTouchEvent(motionevent);
            if (o.get())
            {
                flag = flag1;
                if (System.currentTimeMillis() - p.get() <= (long)ViewConfiguration.getDoubleTapTimeout())
                {
                    break label0;
                }
                o.set(false);
            }
            flag = super.onTouchEvent(motionevent);
        }
        return flag;
    }
}
