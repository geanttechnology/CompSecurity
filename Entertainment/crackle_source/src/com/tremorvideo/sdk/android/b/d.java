// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.b;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tremorvideo.sdk.android.richmedia.ae;
import com.tremorvideo.sdk.android.videoad.ad;
import com.tremorvideo.sdk.android.videoad.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.tremorvideo.sdk.android.b:
//            b, c, a

public class d extends WebView
{
    private class a extends WebChromeClient
    {

        final d a;

        public void onConsoleMessage(String s, int i, String s1)
        {
            Log.d("KK", (new StringBuilder()).append("MSG: ").append(s).append("; Line: ").append(i).append("; Source: ").append(s1).toString());
        }

        public boolean onConsoleMessage(ConsoleMessage consolemessage)
        {
            Log.d("KK", (new StringBuilder()).append("MSG: ").append(consolemessage.message()).append("; Line: ").append(consolemessage.lineNumber()).append("; Source: ").append(consolemessage.sourceId()).toString());
            return true;
        }

        private a()
        {
            a = d.this;
            super();
        }

    }

    private class b extends WebViewClient
    {

        final d a;

        public void onPageFinished(WebView webview, String s)
        {
            if (!d.a(a))
            {
                a.c();
                a.a();
                a.b();
                a.d();
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
                d.a(a, URI.create(s));
                return true;
            } else
            {
                return false;
            }
        }

        private b()
        {
            a = d.this;
            super();
        }

    }

    class c extends AsyncTask
    {

        final d a;

        private String a(InputStream inputstream)
        {
            StringBuilder stringbuilder;
            BufferedReader bufferedreader;
            bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
            stringbuilder = new StringBuilder();
_L1:
            String s = bufferedreader.readLine();
            if (s == null)
            {
                break MISSING_BLOCK_LABEL_77;
            }
            stringbuilder.append((new StringBuilder()).append(s).append("\n").toString());
              goto _L1
            IOException ioexception;
            ioexception;
            ioexception.printStackTrace();
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                inputstream.printStackTrace();
            }
            return stringbuilder.toString();
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                inputstream.printStackTrace();
            }
            if (true)
            {
                break MISSING_BLOCK_LABEL_72;
            }
            Exception exception;
            exception;
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                inputstream.printStackTrace();
            }
            throw exception;
        }

        protected transient String a(String as[])
        {
            Object obj = new DefaultHttpClient();
            try
            {
                HttpGet httpget = new HttpGet(new URI(as[0]));
                ae.a(httpget, as[0]);
                as = ((HttpClient) (obj)).execute(httpget).getEntity();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                ad.a(as);
                return null;
            }
            if (as == null)
            {
                break MISSING_BLOCK_LABEL_76;
            }
            as = as.getContent();
            obj = a(((InputStream) (as)));
            as.close();
            return ((String) (obj));
            return null;
        }

        protected void a(String s)
        {
            a.b(s);
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((String[])aobj);
        }

        protected void onPostExecute(Object obj)
        {
            a((String)obj);
        }

        c()
        {
            a = d.this;
            super();
        }
    }


    private com.tremorvideo.sdk.android.b.b a;
    private b b;
    private a c;
    private com.tremorvideo.sdk.android.b.a d;
    private com.tremorvideo.sdk.android.b.c e;
    private boolean f;

    public d(Context context, com.tremorvideo.sdk.android.b.b b1)
    {
        super(context);
        a = b1;
        e = b1.g().z();
        e();
    }

    static void a(d d1, URI uri)
    {
        d1.a(uri);
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

        if (!((String) (obj)).equals("trigger-event")) goto _L2; else goto _L1
_L1:
        obj = com.tremorvideo.sdk.android.videoad.aw.b.a((String)uri.get("event_type"));
        if (obj == com.tremorvideo.sdk.android.videoad.aw.b.ac)
        {
            uri = (String)uri.get("new_zip");
            if (uri != null && uri.length() > 0 && uri != e.a)
            {
                e.a = uri;
                d();
            }
            d.a(((com.tremorvideo.sdk.android.videoad.aw.b) (obj)));
        } else
        if (obj == com.tremorvideo.sdk.android.videoad.aw.b.aa)
        {
            d.e();
        } else
        if (obj == com.tremorvideo.sdk.android.videoad.aw.b.ae)
        {
            String s = (String)uri.get("longitude");
            String s1 = (String)uri.get("latitude");
            uri = (String)uri.get("theatre");
            d.a(((com.tremorvideo.sdk.android.videoad.aw.b) (obj)), s, s1, uri);
        } else
        if (obj == com.tremorvideo.sdk.android.videoad.aw.b.ad)
        {
            uri = (String)uri.get("click_url");
            d.a(((com.tremorvideo.sdk.android.videoad.aw.b) (obj)), uri);
        } else
        if (obj == com.tremorvideo.sdk.android.videoad.aw.b.af)
        {
            uri = (String)uri.get("click_url");
            d.a(((com.tremorvideo.sdk.android.videoad.aw.b) (obj)), uri);
        } else
        if (obj == com.tremorvideo.sdk.android.videoad.aw.b.Z)
        {
            d.f();
        } else
        {
            d.a(((com.tremorvideo.sdk.android.videoad.aw.b) (obj)));
        }
_L6:
        a("trigger-event");
_L4:
        return;
_L2:
        if (((String) (obj)).equals("trigger-error"))
        {
            a((String)uri.get("error_code"), (String)uri.get("description"));
            return;
        }
        if (!((String) (obj)).equals("cancel-auto-skip")) goto _L4; else goto _L3
_L3:
        d.h();
        a("cancel-auto-skip");
        return;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static boolean a(d d1)
    {
        return d1.f;
    }

    private void e()
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
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            websettings.setPluginState(android.webkit.WebSettings.PluginState.ON);
        }
        websettings.setAllowFileAccess(true);
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            websettings.setAllowFileAccessFromFileURLs(true);
        }
        d = a.k();
        b = new b();
        setWebViewClient(b);
        c = new a();
        setWebChromeClient(c);
        f = false;
    }

    protected void a()
    {
        c("tremorcore.fireEvent('viewableChange','true');");
    }

    protected void a(String s)
    {
        c((new StringBuilder()).append("tremorcore.nativeCallComplete('").append(s).append("');").toString());
    }

    public void a(String s, String s1)
    {
        ad.d((new StringBuilder()).append("EmbedPlayer Error - ").append(s).append(": ").append(s1).toString());
        a("trigger-error");
    }

    protected void b()
    {
        c((new StringBuilder()).append("tremorcore.fireEvent('zipChange','").append(e.a).append("');").toString());
    }

    protected void b(String s)
    {
        d.g();
        c((new StringBuilder()).append("tremorcore.fireEvent('tmsDataChange',").append(s).append(");").toString());
    }

    public void c()
    {
        setBackgroundColor(0);
        if (ad.q() > 10)
        {
            setLayerType(1, null);
        }
        f = true;
    }

    protected void c(String s)
    {
        if (s != null)
        {
            super.loadUrl((new StringBuilder()).append("javascript:").append(s).toString());
        }
    }

    public void d()
    {
        this;
        JVM INSTR monitorenter ;
        String s = e.b().replace("__ZIP__", e.a).replace("__DATE__", e.b);
        (new c()).execute(new String[] {
            s
        });
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void destroy()
    {
        clearCache(false);
        destroyDrawingCache();
    }
}
