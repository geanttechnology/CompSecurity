// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.e;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tremorvideo.sdk.android.richmedia.ae;
import com.tremorvideo.sdk.android.videoad.ad;
import com.tremorvideo.sdk.android.videoad.br;
import com.tremorvideo.sdk.android.videoad.g;
import com.tremorvideo.sdk.android.videoad.r;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

// Referenced classes of package com.tremorvideo.sdk.android.e:
//            c, k, i, e, 
//            m, l

public class p extends WebView
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        private static final a c[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/tremorvideo/sdk/android/e/p$a, s);
        }

        public static a[] values()
        {
            return (a[])c.clone();
        }

        static 
        {
            a = new a("ENABLED", 0);
            b = new a("DISABLED", 1);
            c = (new a[] {
                a, b
            });
        }

        private a(String s, int i1)
        {
            super(s, i1);
        }
    }

    static class b
    {

        private h a;
        private g b;
        private j c;
        private f d;
        private i e;

        static f a(b b1, f f1)
        {
            b1.d = f1;
            return f1;
        }

        static g a(b b1, g g1)
        {
            b1.b = g1;
            return g1;
        }

        static h a(b b1)
        {
            return b1.a;
        }

        static j a(b b1, j j1)
        {
            b1.c = j1;
            return j1;
        }

        static g b(b b1)
        {
            return b1.b;
        }

        static j c(b b1)
        {
            return b1.c;
        }

        static f d(b b1)
        {
            return b1.d;
        }

        static i e(b b1)
        {
            return b1.e;
        }

        b()
        {
        }
    }

    private class c extends WebChromeClient
        implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener
    {

        final p a;
        private p b;
        private VideoView c;
        private android.webkit.WebChromeClient.CustomViewCallback d;
        private int e;

        public void a()
        {
            if (c != null)
            {
                c.stopPlayback();
                if (d != null)
                {
                    d.onCustomViewHidden();
                }
                c = null;
                d = null;
            }
        }

        public boolean b()
        {
            if (c != null)
            {
                c.stopPlayback();
                d.onCustomViewHidden();
                onHideCustomView();
                b.a();
                b.d();
                c = null;
                d = null;
                b.m();
                return true;
            } else
            {
                return false;
            }
        }

        public void c()
        {
            if (c != null)
            {
                e = c.getCurrentPosition();
                c.pause();
            }
        }

        public void d()
        {
            if (c != null)
            {
                c.forceLayout();
                c.requestLayout();
                if (!c.isPlaying())
                {
                    c.start();
                    if (c.isPlaying() && e > 0)
                    {
                        c.seekTo(e);
                    }
                }
                e = 0;
            }
        }

        public void onCompletion(MediaPlayer mediaplayer)
        {
            c.stopPlayback();
            d.onCustomViewHidden();
            onHideCustomView();
            b.a();
            b.d();
            c = null;
            d = null;
            b.m();
        }

        public boolean onError(MediaPlayer mediaplayer, int i1, int j1)
        {
            c.stopPlayback();
            d.onCustomViewHidden();
            onHideCustomView();
            b.a();
            b.d();
            c = null;
            d = null;
            return true;
        }

        public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
        {
            return false;
        }

        public void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
        {
            Object obj;
            super.onShowCustomView(view, customviewcallback);
            if (!(view instanceof FrameLayout))
            {
                break MISSING_BLOCK_LABEL_139;
            }
            obj = (FrameLayout)view;
            if (!(((FrameLayout) (obj)).getFocusedChild() instanceof VideoView))
            {
                break MISSING_BLOCK_LABEL_139;
            }
            view = (VideoView)((FrameLayout) (obj)).getFocusedChild();
            c = view;
            d = customviewcallback;
            ((FrameLayout) (obj)).removeView(view);
            customviewcallback = (Activity)a.getContext();
            obj = new RelativeLayout(a.getContext());
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            layoutparams.addRule(14);
            layoutparams.addRule(15);
            view.setLayoutParams(layoutparams);
            ((RelativeLayout) (obj)).addView(view);
            customviewcallback.setContentView(((View) (obj)));
            view.setOnCompletionListener(this);
            view.setOnErrorListener(this);
            view.start();
            b.c();
            return;
            view;
            ad.a(view);
            return;
        }

        public c(p p2)
        {
            a = p.this;
            super();
            e = 0;
            b = p2;
        }
    }

    private class d extends WebViewClient
    {

        final p a;

        public void onPageFinished(WebView webview, String s)
        {
            if (!p.a(a))
            {
                p.a(a, true);
                p.b(a).c();
                a.a(com.tremorvideo.sdk.android.e.l.a(p.c(a)));
                a.p();
                if (a.j() != null)
                {
                    a.j().a(a);
                }
                p.b(a, true);
            }
        }

        public void onReceivedError(WebView webview, int i1, String s, String s1)
        {
            super.onReceivedError(webview, i1, s, s1);
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            if (Uri.parse(s).getScheme().equals("mraid"))
            {
                p.a(a, URI.create(s));
                return true;
            }
            webview = new Intent();
            webview.setAction("android.intent.action.VIEW");
            webview.setData(Uri.parse(s));
            webview.addFlags(0x10000000);
            try
            {
                a.getContext().startActivity(webview);
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                ad.a(webview);
                return false;
            }
            return true;
        }

        private d()
        {
            a = p.this;
            super();
        }

    }

    public static final class e extends Enum
    {

        public static final e a;
        public static final e b;
        public static final e c;
        private static final e d[];

        public static e valueOf(String s)
        {
            return (e)Enum.valueOf(com/tremorvideo/sdk/android/e/p$e, s);
        }

        public static e[] values()
        {
            return (e[])d.clone();
        }

        static 
        {
            a = new e("ALWAYS_VISIBLE", 0);
            b = new e("ALWAYS_HIDDEN", 1);
            c = new e("AD_CONTROLLED", 2);
            d = (new e[] {
                a, b, c
            });
        }

        private e(String s, int i1)
        {
            super(s, i1);
        }
    }

    public static interface f
    {

        public abstract void a(p p1, boolean flag);
    }

    public static interface g
    {

        public abstract void a(p p1, l l1);
    }

    public static interface h
    {

        public abstract void a(p p1);
    }

    public static interface i
    {

        public abstract void a(p p1);
    }

    public static interface j
    {

        public abstract void a(p p1);
    }

    public static final class k extends Enum
    {

        public static final k a;
        public static final k b;
        private static final k c[];

        public static k valueOf(String s)
        {
            return (k)Enum.valueOf(com/tremorvideo/sdk/android/e/p$k, s);
        }

        public static k[] values()
        {
            return (k[])c.clone();
        }

        static 
        {
            a = new k("INLINE", 0);
            b = new k("INTERSTITIAL", 1);
            c = (new k[] {
                a, b
            });
        }

        private k(String s, int i1)
        {
            super(s, i1);
        }
    }

    public static final class l extends Enum
    {

        public static final l a;
        public static final l b;
        public static final l c;
        public static final l d;
        private static final l e[];

        public static l valueOf(String s)
        {
            return (l)Enum.valueOf(com/tremorvideo/sdk/android/e/p$l, s);
        }

        public static l[] values()
        {
            return (l[])e.clone();
        }

        static 
        {
            a = new l("LOADING", 0);
            b = new l("DEFAULT", 1);
            c = new l("EXPANDED", 2);
            d = new l("HIDDEN", 3);
            e = (new l[] {
                a, b, c, d
            });
        }

        private l(String s, int i1)
        {
            super(s, i1);
        }
    }


    r a;
    private com.tremorvideo.sdk.android.e.c b;
    private com.tremorvideo.sdk.android.e.k c;
    private d d;
    private c e;
    private boolean f;
    private final k g;
    private com.tremorvideo.sdk.android.videoad.g h;
    private String i;
    private boolean j;
    private b k;

    public p(Context context, a a1, e e1, k k1, String s, r r1)
    {
        super(context);
        j = false;
        a = r1;
        j = false;
        g = k1;
        i = s;
        a(a1, e1);
    }

    private void a(a a1, e e1)
    {
        setScrollContainer(false);
        setBackgroundColor(0);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        WebSettings websettings = getSettings();
        websettings.setSupportZoom(false);
        setOnTouchListener(new android.view.View.OnTouchListener() {

            final p a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                motionevent.getAction();
                JVM INSTR tableswitch 0 1: default 28
            //                           0 30
            //                           1 30;
                   goto _L1 _L2 _L2
_L1:
                return false;
_L2:
                if (!view.hasFocus())
                {
                    view.requestFocus();
                }
                if (true) goto _L1; else goto _L3
_L3:
            }

            
            {
                a = p.this;
                super();
            }
        });
        websettings.setJavaScriptEnabled(true);
        websettings.setAllowFileAccess(true);
        websettings.setCacheMode(2);
        if (ad.q() >= 16)
        {
            websettings.setAllowFileAccessFromFileURLs(true);
        }
        if (ad.q() >= 17)
        {
            websettings.setMediaPlaybackRequiresUserGesture(false);
        }
        b = new com.tremorvideo.sdk.android.e.c(this);
        c = new com.tremorvideo.sdk.android.e.k(this, a1, e1);
        d = new d();
        setWebViewClient(d);
        e = new c(this);
        setWebChromeClient(e);
        k = new b();
    }

    static boolean a(p p1)
    {
        return p1.f;
    }

    static boolean a(p p1, URI uri)
    {
        return p1.a(uri);
    }

    static boolean a(p p1, boolean flag)
    {
        p1.j = flag;
        return flag;
    }

    private boolean a(URI uri)
    {
        String s = uri.getHost();
        Object obj = URLEncodedUtils.parse(uri, "UTF-8");
        uri = new HashMap();
        NameValuePair namevaluepair;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); uri.put(namevaluepair.getName(), namevaluepair.getValue()))
        {
            namevaluepair = (NameValuePair)((Iterator) (obj)).next();
        }

        uri = com.tremorvideo.sdk.android.e.i.a(s, uri, this);
        if (uri == null)
        {
            b(s);
            return false;
        } else
        {
            uri.a();
            b(s);
            return true;
        }
    }

    static com.tremorvideo.sdk.android.e.k b(p p1)
    {
        return p1.c;
    }

    static boolean b(p p1, boolean flag)
    {
        p1.f = flag;
        return flag;
    }

    static k c(p p1)
    {
        return p1.g;
    }

    public void a()
    {
        if (h != null)
        {
            h.e();
        }
    }

    protected void a(m m1)
    {
        m1 = (new StringBuilder()).append("{").append(m1.toString()).append("}").toString();
        a((new StringBuilder()).append("window.mraidbridge.fireChangeEvent(").append(m1).append(");").toString());
    }

    public void a(f f1)
    {
        b.a(k, f1);
    }

    public void a(g g1)
    {
        b.a(k, g1);
    }

    public void a(j j1)
    {
        b.a(k, j1);
    }

    public void a(com.tremorvideo.sdk.android.videoad.g g1)
    {
        h = g1;
    }

    public void a(File file)
    {
        String s1 = ae.b(file);
        boolean flag = false;
        String s = s1;
        if (s1.indexOf("<html>") == -1)
        {
            s = (new StringBuilder()).append("<html><head><meta name='viewport' content='user-scalable=no; initial-scale=1.0'/></head><body style='margin:0;padding:0;overflow:hidden;background:transparent;'>").append(s1).append("</body></html>").toString();
            flag = true;
        }
        String s2 = (new StringBuilder()).append("file://").append(i).append("mraid.js").toString();
        s1 = s;
        if (s.indexOf((new StringBuilder()).append("<head><script src='").append(s2).append("'></script>").toString()) == -1)
        {
            s1 = s.replace("<head>", (new StringBuilder()).append("<head><script src='").append(s2).append("'></script>").toString());
            flag = true;
        }
        boolean flag1 = flag;
        s = s1;
        if (a != null)
        {
            flag1 = flag;
            s = s1;
            if (a.f().a("disable-video-tag-autoplay"))
            {
                flag1 = flag;
                s = s1;
                if (s1.indexOf("<video") != -1)
                {
                    s = s1.replace("autoplay", "").replace("<video", "<video preload='none'");
                    flag1 = true;
                }
            }
        }
        if (flag1)
        {
            try
            {
                FileWriter filewriter = new FileWriter(file);
                filewriter.write(s);
                filewriter.close();
            }
            catch (IOException ioexception)
            {
                Log.e("Exception", (new StringBuilder()).append("File write failed: ").append(ioexception.toString()).toString());
            }
        }
        loadUrl((new StringBuilder()).append("file://").append(file.getAbsolutePath()).toString());
    }

    protected void a(String s)
    {
        if (s != null && j)
        {
            super.loadUrl((new StringBuilder()).append("javascript:").append(s).toString());
        }
    }

    protected void a(String s, String s1)
    {
        a((new StringBuilder()).append("window.mraidbridge.fireErrorEvent('").append(s).append("', '").append(s1).append("');").toString());
    }

    protected void a(ArrayList arraylist)
    {
        arraylist = arraylist.toString();
        if (arraylist.length() < 2)
        {
            return;
        } else
        {
            arraylist = (new StringBuilder()).append("{").append(arraylist.substring(1, arraylist.length() - 1)).append("}").toString();
            a((new StringBuilder()).append("window.mraidbridge.fireChangeEvent(").append(arraylist).append(");").toString());
            return;
        }
    }

    protected void b(String s)
    {
        a((new StringBuilder()).append("window.mraidbridge.nativeCallComplete('").append(s).append("');").toString());
    }

    public boolean b()
    {
        m();
        return e.b();
    }

    public void c()
    {
        h.f();
    }

    public void d()
    {
        h.h();
    }

    public void destroy()
    {
        if (c != null)
        {
            c.b();
        }
        super.destroy();
    }

    public void e()
    {
        e.a();
        c.b();
        c = null;
        loadDataWithBaseURL(null, "", "text/html", "UTF-8", null);
        clearView();
        e = null;
        d = null;
    }

    protected com.tremorvideo.sdk.android.e.c f()
    {
        return b;
    }

    protected com.tremorvideo.sdk.android.e.k g()
    {
        return c;
    }

    public h h()
    {
        return b.a(k);
    }

    public g i()
    {
        return b.b(k);
    }

    public j j()
    {
        return b.c(k);
    }

    public f k()
    {
        return b.d(k);
    }

    public i l()
    {
        return b.e(k);
    }

    public void m()
    {
        a("window.mraidbridge.fireTremorVideoEndEvent();");
    }

    public void n()
    {
        a("window.mraidbridge.fireTremorPauseAppEvent();");
    }

    public void o()
    {
        a("window.mraidbridge.fireTremorResumeAppEvent();");
    }

    public void onPause()
    {
        super.onPause();
        n();
        if (e != null)
        {
            e.c();
        }
    }

    public void onResume()
    {
        super.onResume();
        o();
        if (e != null)
        {
            e.d();
        }
    }

    protected void p()
    {
        a("window.mraidbridge.fireReadyEvent();");
    }

    public void q()
    {
        try
        {
            a(new URI("mraid://close"));
            return;
        }
        catch (Exception exception)
        {
            ad.a(exception);
        }
    }
}
