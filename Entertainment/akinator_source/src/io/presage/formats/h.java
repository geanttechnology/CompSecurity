// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats;

import android.net.Uri;
import android.os.Handler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import io.presage.Presage;
import io.presage.ads.d;
import io.presage.do.e;
import java.util.ArrayList;
import shared_presage.com.google.gson.Gson;

// Referenced classes of package io.presage.formats:
//            g, j, k, l, 
//            i, m, n

public final class h extends g
{
    final class a extends WebViewClient
    {

        final h a;

        public final boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            webview = Uri.parse(s).getScheme();
            return webview != null && !webview.equals("http") && !webview.equals("https");
        }

        public a()
        {
            a = h.this;
            super();
        }
    }

    final class b extends WebChromeClient
    {

        final h a;
        private h b;
        private String c;
        private e d;

        public final void onConsoleMessage(String s, int i1, String s1)
        {
            io.presage.utils.e.a(new String[] {
                "Webviews", "[", c, "]", s, "-- From line", Integer.toString(i1), "of", s1
            });
        }

        public b(String s, h h2, e e1)
        {
            a = h.this;
            super();
            c = s;
            b = h2;
            d = e1;
        }
    }

    final class c
    {

        final h a;
        private h b;
        private String c;
        private WebView d;
        private e e;

        static h a(c c1)
        {
            return c1.b;
        }

        static String b(c c1)
        {
            return c1.c;
        }

        static WebView c(c c1)
        {
            return c1.d;
        }

        public final void close(int i1)
        {
            (new Handler()).postDelayed(new m(this), i1);
        }

        public final void loadComplete()
        {
            io.presage.utils.e.b(new String[] {
                "Webviews", "[", c, "] loadComplete"
            });
            b.i();
        }

        public final String param(String s)
        {
            return (new Gson()).toJson(e.a(s)).toString();
        }

        public final void sendAction(String s)
        {
            io.presage.utils.e.b(new String[] {
                "Webviews", "[", c, "] sendAction:", s
            });
            if (s.equals("close"))
            {
                b.e = false;
                b.j();
                return;
            }
            if (s.equals("cancel"))
            {
                b.e = true;
                b.j();
                return;
            } else
            {
                b.a().b(s);
                return;
            }
        }

        public final void setTimeout(String s, int i1)
        {
            io.presage.utils.e.b(new String[] {
                "Webviews", "[", c, "] setTimeout:", s, "-", Integer.toString(i1)
            });
            (new Handler()).postDelayed(new n(this, s), i1);
        }

        public final String stringParam(String s)
        {
            return e.a(s).toString();
        }

        public c(String s, WebView webview, h h2, e e1)
        {
            a = h.this;
            super();
            c = s;
            d = webview;
            b = h2;
            e = e1;
        }
    }


    public boolean e;

    public h(String s, String s1, d d1, e e1)
    {
        super(s, s1, d1, e1);
        e = false;
        a(d1);
    }

    public final void b()
    {
        Presage.getInstance().runOnUiThread(new j(this));
        super.b();
    }

    public final void c()
    {
        b = new ArrayList();
        Presage.getInstance().runOnUiThread(new k(this, this));
    }

    public final void d()
    {
        Presage.getInstance().runOnUiThread(new l(this));
    }

    public final void j()
    {
        Presage.getInstance().runOnUiThread(new i(this));
    }
}
