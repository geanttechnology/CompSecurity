// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.app.Activity;
import android.content.Context;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tremorvideo.sdk.android.videoad.ad;
import com.tremorvideo.sdk.android.videoad.bt;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            a, m, o, w, 
//            c, x, ab, q, 
//            ae

public class ScriptInterpreter
{
    private class a extends WebChromeClient
    {

        final ScriptInterpreter a;

        public void onConsoleMessage(String s, int i, String s1)
        {
        }

        public boolean onConsoleMessage(ConsoleMessage consolemessage)
        {
            return false;
        }

        private a()
        {
            a = ScriptInterpreter.this;
            super();
        }

    }

    private class b extends WebViewClient
    {

        final ScriptInterpreter a;

        public void onPageFinished(WebView webview, String s)
        {
            a.scriptLoaded = true;
            a.b.m();
        }

        private b()
        {
            a = ScriptInterpreter.this;
            super();
        }

    }

    public class c
        implements Runnable
    {

        String a;
        final ScriptInterpreter b;

        public void run()
        {
            b.a.evaluateJavascript(a, null);
        }

        public c(String s)
        {
            b = ScriptInterpreter.this;
            super();
            a = s;
        }
    }


    WebView a;
    m b;
    com.tremorvideo.sdk.android.richmedia.a c;
    private Activity d;
    public boolean scriptLoaded;

    public ScriptInterpreter(Context context)
    {
        d = (Activity)context;
        a = new WebView(context);
        a.getSettings().setJavaScriptEnabled(true);
        a.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        a.addJavascriptInterface(this, "Device");
        a.setWebViewClient(new b());
        a.setWebChromeClient(new a());
    }

    public void callFunction(String s)
    {
        if (s != "" && s != null)
        {
            ad.d((new StringBuilder()).append("Calling Function: ").append(s).toString());
            a.loadUrl((new StringBuilder()).append("javascript:").append(s).append("();").toString());
        }
    }

    public void destroy()
    {
        d.runOnUiThread(new Runnable() {

            final ScriptInterpreter a;

            public void run()
            {
                a.a.destroy();
                a.a = null;
            }

            
            {
                a = ScriptInterpreter.this;
                super();
            }
        });
    }

    public void getValue(String s, String s1)
    {
        if (s.equals("geo.dma"))
        {
            s = c.a.e;
            s = (new StringBuilder()).append("javascript:callCallback(").append(s1).append(",'").append(s).append("');").toString();
        } else
        if (s.equals("geo.state"))
        {
            s = c.a.c;
            s = (new StringBuilder()).append("javascript:callCallback(").append(s1).append(",'").append(s).append("');").toString();
        } else
        if (s.equals("geo.city"))
        {
            s = c.a.a;
            s = (new StringBuilder()).append("javascript:callCallback(").append(s1).append(",'").append(s).append("');").toString();
        } else
        if (s.equals("geo.country"))
        {
            s = c.a.b;
            s = (new StringBuilder()).append("javascript:callCallback(").append(s1).append(",'").append(s).append("');").toString();
        } else
        if (s.equals("geo.zip"))
        {
            s = c.a.d;
            s = (new StringBuilder()).append("javascript:callCallback(").append(s1).append(",'").append(s).append("');").toString();
        } else
        {
            String s2 = ad.g().a(s);
            s = s2;
            if (s2 == null)
            {
                s = "null";
            }
            s = (new StringBuilder()).append("javascript:callCallback(").append(s1).append(",'").append(s).append("');").toString();
        }
        if (ad.q() < 19)
        {
            a.loadUrl(s);
            return;
        } else
        {
            d.runOnUiThread(new c(s));
            return;
        }
    }

    public WebView getView()
    {
        return a;
    }

    public void load(m m1, com.tremorvideo.sdk.android.richmedia.a a1)
    {
        scriptLoaded = false;
        String s = (new StringBuilder()).append("<html><head><script type=\"text/javascript\">\n").append(a1.h()).toString();
        s = (new StringBuilder()).append(s).append("</script></head></html>").toString();
        a.loadDataWithBaseURL(null, s, "text/html", "utf-8", null);
        c = a1;
        b = m1;
    }

    public void onError(String s)
    {
        ad.d(s);
    }

    public void playVideo(int i, int j)
    {
        b.a(i, j);
    }

    public void setImage(int i, int j)
    {
        Object obj = b.b();
        Object obj1 = ((o) (obj)).a(i);
        if (obj1 instanceof w)
        {
            obj1 = (w)obj1;
            if (obj1 != null)
            {
                obj = ((o) (obj)).f().r().a(j);
                if (obj != null)
                {
                    ((w) (obj1)).a(((android.graphics.Bitmap) (obj)));
                }
            }
        }
    }

    public void setOverrideScene(int i, int j)
    {
        o o1 = b.b();
        Object obj = o1.a(i);
        if (obj instanceof x)
        {
            obj = (x)obj;
            if (obj != null)
            {
                ((x) (obj)).a(o1.f().b(j));
            }
        }
    }

    public void setScene(int i)
    {
        o o1 = c.b(i);
        if (o1 != null)
        {
            b.a(o1);
        }
    }

    public void setText(int i, String s)
    {
        Object obj = b.b().a(i);
        if (obj instanceof ab)
        {
            obj = (ab)obj;
            if (obj != null)
            {
                ((ab) (obj)).a(s);
            }
        }
    }

    public void setValue(String s, String s1)
    {
        ad.g().a(s, s1);
    }

    public void setVisibility(int i, int j)
    {
        q q1 = b.b().a(i);
        if (q1 != null)
        {
            q1.a(j);
        }
    }

    public void startEvent(String s)
    {
        b.b(String.valueOf(ae.a(s)));
    }
}
