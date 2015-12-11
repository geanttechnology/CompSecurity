// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.VideoView;
import java.io.File;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            aq, ad

public class as extends aq
{
    private class a extends WebChromeClient
    {

        final as a;

        public void onGeolocationPermissionsShowPrompt(String s, android.webkit.GeolocationPermissions.Callback callback)
        {
            callback.invoke(s, true, false);
        }

        public void onHideCustomView()
        {
            as.e(a);
        }

        public void onProgressChanged(WebView webview, int l)
        {
            super.onProgressChanged(webview, l);
            if (l == 100 && a.b != null)
            {
                a.b.a();
            }
        }

        public void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
        {
            if (as.a(a) != null)
            {
                customviewcallback.onCustomViewHidden();
                return;
            }
            VideoView videoview = as.a(a, view);
            if (videoview != null)
            {
                as.a(a, videoview);
            }
            as.b(a).setVisibility(8);
            as.c(a).addView(view, new android.widget.FrameLayout.LayoutParams(-1, -1));
            as.b(a, view);
            as.a(a, customviewcallback);
            as.c(a).setVisibility(0);
            as.d(a);
        }

        private a()
        {
            a = as.this;
            super();
        }

    }


    private int c;
    private View d;
    private FrameLayout e;
    private android.webkit.WebChromeClient.CustomViewCallback f;
    private WebView g;
    private VideoView h;

    as(Context context)
    {
        super(context);
        c = 43981;
        g = new WebView(context);
        g.setVerticalScrollBarEnabled(false);
        g.setHorizontalScrollBarEnabled(false);
        g.setWebViewClient(h());
        g.getSettings().setJavaScriptEnabled(true);
        g.getSettings().setSaveFormData(false);
        g.getSettings().setSavePassword(false);
        g.getSettings().setGeolocationDatabasePath(context.getFilesDir().getPath());
        g.getSettings().setGeolocationEnabled(true);
        g.getSettings().setAppCacheEnabled(true);
        g.getSettings().setDatabaseEnabled(true);
        ad.d(g.getSettings().getUserAgentString());
        g.getSettings().setDatabaseEnabled(true);
        g.setWebChromeClient(new a());
        g.getSettings().setDomStorageEnabled(true);
        g.getSettings().setBuiltInZoomControls(true);
        e = new FrameLayout(context);
        e.setVisibility(8);
        f();
        System.gc();
        addView(g, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        addView(e, new android.widget.RelativeLayout.LayoutParams(-1, -1));
    }

    static View a(as as1)
    {
        return as1.d;
    }

    static android.webkit.WebChromeClient.CustomViewCallback a(as as1, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        as1.f = customviewcallback;
        return customviewcallback;
    }

    private VideoView a(View view)
    {
        if (view instanceof VideoView)
        {
            return (VideoView)view;
        }
        if (view instanceof ViewGroup)
        {
            view = (ViewGroup)view;
            int i1 = view.getChildCount();
            for (int l = 0; l < i1; l++)
            {
                View view1 = view.getChildAt(l);
                if (view1 instanceof VideoView)
                {
                    return (VideoView)view1;
                }
            }

        }
        return null;
    }

    static VideoView a(as as1, View view)
    {
        return as1.a(view);
    }

    private void a(VideoView videoview)
    {
        h = videoview;
        videoview.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener() {

            final as a;

            public void onPrepared(MediaPlayer mediaplayer)
            {
                ad.d("WebView - Video Available");
                as.f(a);
                mediaplayer.start();
            }

            
            {
                a = as.this;
                super();
            }
        });
        videoview.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

            final as a;

            public void onCompletion(MediaPlayer mediaplayer)
            {
                ad.d("WebView - Video Complete");
                if (mediaplayer != null)
                {
                    mediaplayer.stop();
                }
                as.e(a);
                if (mediaplayer != null)
                {
                    mediaplayer.release();
                }
            }

            
            {
                a = as.this;
                super();
            }
        });
    }

    static void a(as as1, VideoView videoview)
    {
        as1.a(videoview);
    }

    static View b(as as1, View view)
    {
        as1.d = view;
        return view;
    }

    static WebView b(as as1)
    {
        return as1.g;
    }

    static FrameLayout c(as as1)
    {
        return as1.e;
    }

    static void d(as as1)
    {
        as1.i();
    }

    static void e(as as1)
    {
        as1.j();
    }

    static void f(as as1)
    {
        as1.k();
    }

    private void i()
    {
        if (h != null && !h.isPlaying() && e.findViewById(c) == null)
        {
            ProgressBar progressbar = new ProgressBar(h.getContext());
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
        h = null;
        e.removeView(d);
        d = null;
        e.setVisibility(8);
        f.onCustomViewHidden();
        g.setVisibility(0);
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

    public void a(aq.d d1)
    {
        a = d1;
    }

    public void a(String s)
    {
        f();
        if (g != null)
        {
            g.loadUrl(s);
        }
    }

    public boolean a()
    {
        return h != null;
    }

    public void b()
    {
        if (h != null)
        {
            if (g != null && a != null)
            {
                g.loadUrl("javascript:onVideoExit();");
            }
            ad.d("WebView - skipping video");
            j();
        }
    }

    public void c()
    {
        if (h != null)
        {
            h.stopPlayback();
        }
        j();
    }

    public void d()
    {
        if (h == null)
        {
            if (g != null && a != null)
            {
                g.loadUrl("javascript:onResume();");
            }
        } else
        {
            h.start();
        }
        i();
    }

    public void e()
    {
        if (h == null)
        {
            if (g != null && a != null)
            {
                g.loadUrl("javascript:onPause();");
            }
            return;
        } else
        {
            h.pause();
            return;
        }
    }

    public void f()
    {
        if (g != null)
        {
            g.clearCache(false);
            g.destroyDrawingCache();
        }
    }

    public void g()
    {
        if (g != null)
        {
            removeView(g);
            f();
            g.destroy();
            g = null;
        }
    }

    public void setBackgroundColor(int l)
    {
        super.setBackgroundColor(l);
        g.setBackgroundColor(l);
    }
}
