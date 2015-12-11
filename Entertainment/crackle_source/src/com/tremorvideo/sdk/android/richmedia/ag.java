// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tremorvideo.sdk.android.videoad.ad;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            WebViewEmbedJSCallHandler, af

public class ag extends WebView
{
    private class a extends WebChromeClient
    {

        final ag a;

        private a()
        {
            a = ag.this;
            super();
        }

    }

    private class b extends WebViewClient
    {

        final ag a;

        public void a()
        {
            a.d.loadUrl("javascript: tremorvideo.EmbedVideoPlayer.stopVideo();");
        }

        protected void a(String s)
        {
            a.d.loadUrl((new StringBuilder()).append("javascript: tremorcore.nativeCallComplete('").append(s).append("');").toString());
        }

        public void b()
        {
            a.d.loadUrl("javascript: tremorvideo.EmbedVideoPlayer.pauseVideo();");
        }

        public void c()
        {
            a.d.loadUrl("javascript: tremorvideo.EmbedVideoPlayer.resumeVideo();");
        }

        public void onPageFinished(WebView webview, String s)
        {
            if (!a.d.i)
            {
                a.d.j = false;
                a.d.loadUrl("javascript: tremorvideo.EmbedVideoPlayer.setIsAndroid()");
                a.d.loadUrl((new StringBuilder()).append("javascript: tremorvideo.EmbedVideoPlayer.initVideo('").append(a.d.e).append("');").toString());
                a.d.i = true;
            }
        }

        public void onReceivedError(WebView webview, int i1, String s, String s1)
        {
            a.h.m();
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            if (Uri.parse(s).getScheme().equals("tremorvideo"))
            {
                a.a(URI.create(s));
                return true;
            }
            if (ag.a(a) != null && s.startsWith(ag.a(a)))
            {
                a.h.a(s);
                return true;
            } else
            {
                return false;
            }
        }

        private b()
        {
            a = ag.this;
            super();
        }

    }


    public static int a = -1;
    public static int b = 0;
    public static int c = 1;
    ag d;
    String e;
    String f;
    b g;
    af h;
    boolean i;
    boolean j;
    boolean k;
    public int l;
    public int m;
    WebViewEmbedJSCallHandler n;
    private String o;

    public ag(Context context, af af1)
    {
        super(context);
        l = a;
        m = 0;
        d = this;
        h = af1;
        setBackgroundColor(0);
        l = a;
        context = getSettings();
        context.setSupportZoom(false);
        context.setJavaScriptEnabled(true);
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            context.setPluginState(android.webkit.WebSettings.PluginState.ON);
        }
        context.setAllowFileAccess(true);
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            context.setAllowFileAccessFromFileURLs(true);
        }
        n = new WebViewEmbedJSCallHandler(this);
        addJavascriptInterface(n, "Device");
        g = new b();
        setWebViewClient(g);
        setWebChromeClient(new a());
    }

    static String a(ag ag1)
    {
        return ag1.o;
    }

    public void a()
    {
        if (i && j && k)
        {
            g.a();
        }
    }

    public void a(int i1)
    {
        m = i1;
    }

    public void a(com.tremorvideo.sdk.android.videoad.aw.b b1)
    {
        h.a(b1);
    }

    public void a(String s, String s1)
    {
        h.m();
        i = false;
        j = false;
        k = false;
        e = s1;
        f = s;
        super.loadUrl((new StringBuilder()).append("file://").append(s).append("index.html").toString());
    }

    public void a(URI uri)
    {
        String s = uri.getHost();
        Object obj = URLEncodedUtils.parse(uri, "UTF-8");
        uri = new HashMap();
        NameValuePair namevaluepair;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); uri.put(namevaluepair.getName(), namevaluepair.getValue()))
        {
            namevaluepair = (NameValuePair)((Iterator) (obj)).next();
        }

        ad.d((new StringBuilder()).append("Trying Command: ").append(s).append(" / ").append((String)uri.get("event_type")).toString());
        if (s.equals("trigger-event"))
        {
            uri = (String)uri.get("event_type");
            if (uri.equals("video-ready"))
            {
                j = true;
            } else
            if (uri.equals("video-start"))
            {
                k = true;
                d.a(com.tremorvideo.sdk.android.videoad.aw.b.ag);
            } else
            if (uri.equals("video-playing"))
            {
                l = b;
            } else
            if (uri.equals("video-paused") && l == b)
            {
                c();
            }
            uri = com.tremorvideo.sdk.android.videoad.aw.b.a(uri);
            d.a(((com.tremorvideo.sdk.android.videoad.aw.b) (uri)));
        } else
        if (s.equals("handle-url"))
        {
            o = (String)uri.get("url");
        } else
        if (s.equals("trigger-error"))
        {
            d.b((String)uri.get("error_code"), (String)uri.get("description"));
        } else
        {
            ad.d((new StringBuilder()).append("Unknown native call in Embed JS player: ").append(s).toString());
        }
        g.a(s);
    }

    public void b()
    {
        if (i && j && k)
        {
            l = c;
            g.b();
        }
    }

    public void b(String s, String s1)
    {
        ad.d((new StringBuilder()).append("EmbedPlayer Error - ").append(s).append(": ").append(s1).toString());
        h.m();
        g.a("trigger-error");
    }

    public void c()
    {
        if (i && j && k)
        {
            l = b;
            g.c();
        }
    }

    public void d()
    {
        if (i && j)
        {
            ((Activity)getContext()).runOnUiThread(new Runnable() {

                final ag a;

                public void run()
                {
                    a.loadUrl("javascript: tremorvideo.EmbedVideoPlayer.getCurrentTime();");
                }

            
            {
                a = ag.this;
                super();
            }
            });
        }
    }

    public void e()
    {
        k = true;
        d.a(com.tremorvideo.sdk.android.videoad.aw.b.ah);
        d.a(com.tremorvideo.sdk.android.videoad.aw.b.ag);
    }

    public int getProgress()
    {
        if (m > 0)
        {
            return m;
        } else
        {
            return 0;
        }
    }

}
