// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.VideoView;
import java.io.File;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            aq, ad

public class ar extends aq
{
    class a
    {

        final ar a;

        public a(WebSettings websettings)
        {
            a = ar.this;
            super();
            websettings.setDatabaseEnabled(true);
        }
    }

    private class b extends WebChromeClient
    {

        final ar a;

        public void onGeolocationPermissionsShowPrompt(String s, android.webkit.GeolocationPermissions.Callback callback)
        {
            callback.invoke(s, true, false);
        }

        public void onProgressChanged(WebView webview, int l)
        {
            super.onProgressChanged(webview, l);
            if (l == 100 && a.b != null)
            {
                a.b.a();
            }
        }

        private b()
        {
            a = ar.this;
            super();
        }

    }


    private int c;
    private View d;
    private FrameLayout e;
    private WebView f;
    private VideoView g;

    ar(Context context)
    {
        super(context);
        c = 43981;
        f = new WebView(context);
        f.setVerticalScrollBarEnabled(false);
        f.setHorizontalScrollBarEnabled(false);
        f.setWebViewClient(new aq.a(this));
        f.setWebChromeClient(new b());
        f.getSettings().setJavaScriptEnabled(true);
        f.getSettings().setSaveFormData(false);
        f.getSettings().setSavePassword(false);
        f.getSettings().setGeolocationDatabasePath(context.getFilesDir().getPath());
        f.getSettings().setGeolocationEnabled(true);
        f.getSettings().setAppCacheEnabled(true);
        f.getSettings().setDatabaseEnabled(true);
        if (Integer.parseInt(android.os.Build.VERSION.SDK) >= 5)
        {
            new a(f.getSettings());
        }
        e = new FrameLayout(context);
        e.setVisibility(8);
        f();
        System.gc();
        addView(f, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        addView(e, new android.widget.RelativeLayout.LayoutParams(-1, -1));
    }

    private void i()
    {
        if (g != null && e.findViewById(c) == null)
        {
            ProgressBar progressbar = new ProgressBar(g.getContext());
            progressbar.setIndeterminate(true);
            progressbar.setId(c);
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-2, -2);
            layoutparams.gravity = 17;
            e.addView(progressbar, layoutparams);
        }
    }

    private void j()
    {
        this;
        JVM INSTR monitorenter ;
        View view = d;
        if (view != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        k();
        d.setVisibility(8);
        g = null;
        e.removeView(d);
        d = null;
        e.setVisibility(8);
        f.setVisibility(0);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void k()
    {
        do
        {
            View view = e.findViewById(c);
            if (view != null)
            {
                e.removeView(view);
            } else
            {
                return;
            }
        } while (true);
    }

    public void a(String s)
    {
        f();
        f.loadUrl(s);
    }

    public boolean a()
    {
        return g != null;
    }

    public void b()
    {
        if (g != null)
        {
            ad.d("WebView - skipping video");
            j();
        }
    }

    public void c()
    {
    }

    public void d()
    {
        i();
    }

    public void e()
    {
    }

    public void f()
    {
        if (f != null)
        {
            f.clearCache(false);
            f.destroyDrawingCache();
        }
    }

    public void g()
    {
        f();
        f = null;
    }

    public void setBackgroundColor(int l)
    {
        super.setBackgroundColor(l);
        f.setBackgroundColor(l);
    }
}
