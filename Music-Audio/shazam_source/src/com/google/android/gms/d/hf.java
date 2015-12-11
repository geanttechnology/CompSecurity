// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.e;
import com.google.android.gms.ads.internal.overlay.g;
import com.google.android.gms.ads.internal.overlay.n;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.google.android.gms.d:
//            ea, he, aq, ay, 
//            ax, gm, ce, dv, 
//            ca, cd, ck, cl, 
//            ch, gn, p, o, 
//            cb, cg, ci, ec

public class hf extends WebViewClient
{
    public static interface a
    {

        public abstract void a(he he1, boolean flag);
    }

    public static interface b
    {

        public abstract void a();
    }

    private static final class c
        implements g
    {

        private he a;
        private g b;

        public final void a_()
        {
            b.a_();
            a.a();
        }

        public final void b_()
        {
            b.b_();
            a.b();
        }

        public c(he he1, g g1)
        {
            a = he1;
            b = g1;
        }
    }

    private final class d
        implements ce
    {

        final hf a;

        public final void a(he he1, Map map)
        {
            if (map.keySet().contains("start"))
            {
                com.google.android.gms.d.hf.a(a);
            } else
            {
                if (map.keySet().contains("stop"))
                {
                    com.google.android.gms.d.hf.b(a);
                    return;
                }
                if (map.keySet().contains("cancel"))
                {
                    hf.c(a);
                    return;
                }
            }
        }

        private d()
        {
            a = hf.this;
            super();
        }

        d(byte byte0)
        {
            this();
        }
    }


    private static final String k[] = {
        "UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", 
        "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"
    };
    private static final String l[] = {
        "NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"
    };
    protected final he a;
    final HashMap b;
    final Object c;
    public a d;
    public b e;
    public boolean f;
    boolean g;
    public final ea h;
    public com.google.android.gms.ads.internal.e i;
    public dv j;
    private com.google.android.gms.ads.internal.client.a m;
    private g n;
    private cb o;
    private cg p;
    private ci q;
    private boolean r;
    private n s;
    private ec t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;

    public hf(he he1, boolean flag)
    {
        this(he1, flag, new ea(he1, he1.d(), new aq(he1.getContext())));
    }

    private hf(he he1, boolean flag, ea ea1)
    {
        b = new HashMap();
        c = new Object();
        f = false;
        a = he1;
        g = flag;
        h = ea1;
        j = null;
    }

    private void a(Context context, String s1, String s2, String s3)
    {
        Object obj;
        obj = ay.af;
        if (!((Boolean)com.google.android.gms.ads.internal.p.n().a(((au) (obj)))).booleanValue())
        {
            return;
        }
        obj = new Bundle();
        ((Bundle) (obj)).putString("err", s1);
        ((Bundle) (obj)).putString("code", s2);
        if (TextUtils.isEmpty(s3)) goto _L2; else goto _L1
_L1:
        s1 = Uri.parse(s3);
        if (s1.getHost() == null) goto _L2; else goto _L3
_L3:
        s1 = s1.getHost();
_L5:
        ((Bundle) (obj)).putString("host", s1);
        com.google.android.gms.ads.internal.p.e();
        com.google.android.gms.d.gm.a(context, a.l().b, "gmob-apps", ((Bundle) (obj)), true);
        return;
_L2:
        s1 = "";
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void a(Uri uri)
    {
        Object obj = uri.getPath();
        obj = (List)b.get(obj);
        if (obj != null)
        {
            com.google.android.gms.ads.internal.p.e();
            uri = com.google.android.gms.d.gm.a(uri);
            if (com.google.android.gms.ads.internal.util.client.b.a(2))
            {
                com.google.android.gms.ads.internal.util.client.b.a(2);
                for (Iterator iterator = uri.keySet().iterator(); iterator.hasNext(); com.google.android.gms.ads.internal.util.client.b.a(2))
                {
                    String s1 = (String)iterator.next();
                    (new StringBuilder("  ")).append(s1).append(": ").append((String)uri.get(s1));
                }

            }
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((ce)((Iterator) (obj)).next()).a(a, uri)) { }
        } else
        {
            (new StringBuilder("No GMSG handler found for GMSG: ")).append(uri);
            com.google.android.gms.ads.internal.util.client.b.a(2);
        }
    }

    private void a(AdOverlayInfoParcel adoverlayinfoparcel)
    {
        boolean flag1 = false;
        Context context;
        boolean flag;
        if (j != null)
        {
            flag = j.b();
        } else
        {
            flag = false;
        }
        com.google.android.gms.ads.internal.p.c();
        context = a.getContext();
        if (!flag)
        {
            flag1 = true;
        }
        com.google.android.gms.ads.internal.overlay.e.a(context, adoverlayinfoparcel, flag1);
    }

    static void a(hf hf1)
    {
        synchronized (hf1.c)
        {
            hf1.r = true;
        }
        hf1.y = hf1.y + 1;
        hf1.e();
        return;
        hf1;
        obj;
        JVM INSTR monitorexit ;
        throw hf1;
    }

    static void b(hf hf1)
    {
        hf1.y = hf1.y - 1;
        hf1.e();
    }

    static void c(hf hf1)
    {
        hf1.x = true;
        hf1.e();
    }

    static b d(hf hf1)
    {
        return hf1.e;
    }

    static b e(hf hf1)
    {
        hf1.e = null;
        return null;
    }

    private void e()
    {
        if (d != null && (w && y <= 0 || x))
        {
            a a1 = d;
            he he1 = a;
            boolean flag;
            if (!x)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a1.a(he1, flag);
            d = null;
        }
    }

    public final void a(com.google.android.gms.ads.internal.client.a a1, g g1, cb cb, n n1, boolean flag, cg cg, ci ci, 
            com.google.android.gms.ads.internal.e e1, ec ec)
    {
        com.google.android.gms.ads.internal.e e2 = e1;
        if (e1 == null)
        {
            e2 = new com.google.android.gms.ads.internal.e((byte)0);
        }
        j = new dv(a, ec);
        a("/appEvent", ((ce) (new ca(cb))));
        a("/backButton", cd.j);
        a("/canOpenURLs", com.google.android.gms.d.cd.b);
        a("/canOpenIntents", cd.c);
        a("/click", cd.d);
        a("/close", com.google.android.gms.d.cd.e);
        a("/customClose", cd.f);
        a("/delayPageLoaded", ((ce) (new d((byte)0))));
        a("/httpTrack", com.google.android.gms.d.cd.g);
        a("/log", cd.h);
        a("/mraid", ((ce) (new ck(e2, j))));
        a("/mraidLoaded", ((ce) (h)));
        a("/open", ((ce) (new cl(cg, e2, j))));
        a("/precache", cd.l);
        a("/touch", cd.i);
        a("/video", cd.k);
        if (ci != null)
        {
            a("/setInterstitialProperties", ((ce) (new ch(ci))));
        }
        m = a1;
        n = g1;
        o = cb;
        p = cg;
        s = n1;
        i = e2;
        t = ec;
        q = ci;
        f = flag;
        u = false;
    }

    public final void a(AdLauncherIntentInfoParcel adlauncherintentinfoparcel)
    {
        g g1 = null;
        boolean flag = a.m();
        com.google.android.gms.ads.internal.client.a a1;
        if (flag && !a.h().e)
        {
            a1 = null;
        } else
        {
            a1 = m;
        }
        if (!flag)
        {
            g1 = n;
        }
        a(new AdOverlayInfoParcel(adlauncherintentinfoparcel, a1, g1, s, a.l()));
    }

    public final void a(String s1, ce ce1)
    {
        Object obj1 = c;
        obj1;
        JVM INSTR monitorenter ;
        List list = (List)b.get(s1);
        Object obj;
        obj = list;
        if (list != null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        obj = new CopyOnWriteArrayList();
        b.put(s1, obj);
        ((List) (obj)).add(ce1);
        obj1;
        JVM INSTR monitorexit ;
        return;
        s1;
        obj1;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public final void a(boolean flag, int i1)
    {
        com.google.android.gms.ads.internal.client.a a1;
        if (a.m() && !a.h().e)
        {
            a1 = null;
        } else
        {
            a1 = m;
        }
        a(new AdOverlayInfoParcel(a1, n, s, a, flag, i1, a.l()));
    }

    public final void a(boolean flag, int i1, String s1)
    {
        Object obj = null;
        boolean flag1 = a.m();
        com.google.android.gms.ads.internal.client.a a1;
        if (flag1 && !a.h().e)
        {
            a1 = null;
        } else
        {
            a1 = m;
        }
        if (!flag1)
        {
            obj = new c(a, n);
        }
        a(new AdOverlayInfoParcel(a1, ((g) (obj)), o, s, a, flag, i1, s1, a.l(), p));
    }

    public final void a(boolean flag, int i1, String s1, String s2)
    {
        boolean flag1 = a.m();
        com.google.android.gms.ads.internal.client.a a1;
        Object obj;
        if (flag1 && !a.h().e)
        {
            a1 = null;
        } else
        {
            a1 = m;
        }
        if (flag1)
        {
            obj = null;
        } else
        {
            obj = new c(a, n);
        }
        a(new AdOverlayInfoParcel(a1, ((g) (obj)), o, s, a, flag, i1, s1, s2, a.l(), p));
    }

    public final boolean a()
    {
        boolean flag;
        synchronized (c)
        {
            flag = g;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean b()
    {
        boolean flag;
        synchronized (c)
        {
            flag = r;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void c()
    {
        synchronized (c)
        {
            com.google.android.gms.ads.internal.util.client.b.a(2);
            v = true;
            a.a("about:blank");
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void d()
    {
        synchronized (c)
        {
            b.clear();
            m = null;
            n = null;
            d = null;
            o = null;
            f = false;
            g = false;
            r = false;
            p = null;
            s = null;
            e = null;
            if (j != null)
            {
                j.a(true);
                j = null;
            }
            u = false;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void onLoadResource(WebView webview, String s1)
    {
        com.google.android.gms.ads.internal.util.client.b.a(2);
        webview = Uri.parse(s1);
        if ("gmsg".equalsIgnoreCase(webview.getScheme()) && "mobileads.google.com".equalsIgnoreCase(webview.getHost()))
        {
            a(webview);
        }
    }

    public final void onPageFinished(WebView webview, String s1)
    {
label0:
        {
            synchronized (c)
            {
                if (!v || !"about:blank".equals(s1))
                {
                    break label0;
                }
                com.google.android.gms.ads.internal.util.client.b.a(2);
                a.o();
            }
            return;
        }
        webview;
        JVM INSTR monitorexit ;
        w = true;
        e();
        return;
        s1;
        webview;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public final void onReceivedError(WebView webview, int i1, String s1, String s2)
    {
        String s3;
        if (i1 < 0 && -i1 - 1 < k.length)
        {
            s3 = k[-i1 - 1];
        } else
        {
            s3 = String.valueOf(i1);
        }
        a(a.getContext(), "http_err", s3, s2);
        super.onReceivedError(webview, i1, s1, s2);
    }

    public final void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        if (sslerror != null)
        {
            int i1 = sslerror.getPrimaryError();
            String s1;
            if (i1 >= 0 && i1 < l.length)
            {
                s1 = l[i1];
            } else
            {
                s1 = String.valueOf(i1);
            }
            a(a.getContext(), "ssl_err", s1, com.google.android.gms.ads.internal.p.g().a(sslerror));
        }
        super.onReceivedSslError(webview, sslerrorhandler, sslerror);
    }

    public boolean shouldOverrideKeyEvent(WebView webview, KeyEvent keyevent)
    {
        switch (keyevent.getKeyCode())
        {
        default:
            return false;

        case 79: // 'O'
        case 85: // 'U'
        case 86: // 'V'
        case 87: // 'W'
        case 88: // 'X'
        case 89: // 'Y'
        case 90: // 'Z'
        case 91: // '['
        case 126: // '~'
        case 127: // '\177'
        case 128: 
        case 129: 
        case 130: 
        case 222: 
            return true;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s1)
    {
        Object obj;
        com.google.android.gms.ads.internal.util.client.b.a(2);
        obj = Uri.parse(s1);
        if (!"gmsg".equalsIgnoreCase(((Uri) (obj)).getScheme()) || !"mobileads.google.com".equalsIgnoreCase(((Uri) (obj)).getHost())) goto _L2; else goto _L1
_L1:
        a(((Uri) (obj)));
_L4:
        return true;
_L2:
        if (f && webview == a)
        {
            String s2 = ((Uri) (obj)).getScheme();
            boolean flag;
            if ("http".equalsIgnoreCase(s2) || "https".equalsIgnoreCase(s2))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                if (!u)
                {
                    u = true;
                    if (m != null)
                    {
                        obj = ay.T;
                        if (((Boolean)com.google.android.gms.ads.internal.p.n().a(((au) (obj)))).booleanValue())
                        {
                            m.onAdClicked();
                        }
                    }
                }
                return super.shouldOverrideUrlLoading(webview, s1);
            }
        }
        if (a.willNotDraw())
        {
            break MISSING_BLOCK_LABEL_277;
        }
        o o1 = a.k();
        webview = ((WebView) (obj));
        if (o1 != null)
        {
            webview = ((WebView) (obj));
            try
            {
                if (o1.a(((Uri) (obj))))
                {
                    webview = o1.a(((Uri) (obj)), a.getContext());
                }
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                webview = ((WebView) (obj));
            }
        }
        if (i == null || i.a())
        {
            a(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", webview.toString(), null, null, null, null, null));
        } else
        {
            i.a(s1);
        }
        continue; /* Loop/switch isn't completed */
        com.google.android.gms.ads.internal.util.client.b.a(5);
        if (true) goto _L4; else goto _L3
_L3:
    }


    // Unreferenced inner class com/google/android/gms/d/hf$1

/* anonymous class */
    final class _cls1
        implements Runnable
    {

        final hf a;

        public final void run()
        {
            a.a.q();
            com.google.android.gms.ads.internal.overlay.d d1 = a.a.f();
            if (d1 != null)
            {
                d1.o.removeView(d1.i);
                d1.a(true);
            }
            if (hf.d(a) != null)
            {
                hf.d(a).a();
                com.google.android.gms.d.hf.e(a);
            }
        }

            
            {
                a = hf.this;
                super();
            }
    }

}
