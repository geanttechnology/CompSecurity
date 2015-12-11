// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.net.Uri;
import android.os.Handler;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.a;
import com.google.android.gms.ads.internal.c;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.h;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.d;
import com.google.android.gms.ads.internal.overlay.f;
import com.google.android.gms.ads.internal.overlay.k;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.google.android.gms.b:
//            bd, cj, s, az, 
//            bz, ai, af, ah, 
//            am, an, ak, g, 
//            y, u, f, ag, 
//            aj, al, bf

public class ck extends WebViewClient
{

    protected final cj a;
    private final HashMap b;
    private final Object c;
    private com.google.android.gms.ads.internal.client.a d;
    private f e;
    private a f;
    private ag g;
    private boolean h;
    private aj i;
    private al j;
    private boolean k;
    private k l;
    private final bd m;
    private a n;
    private az o;
    private bf p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private int u;

    public ck(cj cj1, boolean flag)
    {
        this(cj1, flag, new bd(cj1, cj1.d(), new s(cj1.getContext())), null);
    }

    ck(cj cj1, boolean flag, bd bd1, az az1)
    {
        b = new HashMap();
        c = new Object();
        h = false;
        a = cj1;
        k = flag;
        m = bd1;
        o = az1;
    }

    static void a(ck ck1)
    {
        ck1.h();
    }

    static void b(ck ck1)
    {
        ck1.i();
    }

    private static boolean b(Uri uri)
    {
        uri = uri.getScheme();
        return "http".equalsIgnoreCase(uri) || "https".equalsIgnoreCase(uri);
    }

    static void c(ck ck1)
    {
        ck1.j();
    }

    private void h()
    {
        u = u + 1;
        d();
    }

    private void i()
    {
        u = u - 1;
        d();
    }

    private void j()
    {
        t = true;
        d();
    }

    public a a()
    {
        return n;
    }

    public void a(int i1, int j1)
    {
        if (o != null)
        {
            o.c(i1, j1);
        }
    }

    public void a(Uri uri)
    {
        String s1 = uri.getPath();
        Object obj = (List)b.get(s1);
        if (obj != null)
        {
            uri = com.google.android.gms.ads.internal.c.c().a(uri);
            if (com.google.android.gms.ads.internal.util.client.b.a(2))
            {
                com.google.android.gms.ads.internal.util.client.b.d((new StringBuilder()).append("Received GMSG: ").append(s1).toString());
                String s2;
                for (Iterator iterator = uri.keySet().iterator(); iterator.hasNext(); com.google.android.gms.ads.internal.util.client.b.d((new StringBuilder()).append("  ").append(s2).append(": ").append((String)uri.get(s2)).toString()))
                {
                    s2 = (String)iterator.next();
                }

            }
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((ai)((Iterator) (obj)).next()).a(a, uri)) { }
        } else
        {
            com.google.android.gms.ads.internal.util.client.b.d((new StringBuilder()).append("No GMSG handler found for GMSG: ").append(uri).toString());
        }
    }

    public void a(com.google.android.gms.ads.internal.client.a a1, f f1, ag ag, k k1, boolean flag, aj aj, al al, 
            a a2, bf bf)
    {
        a a3 = a2;
        if (a2 == null)
        {
            a3 = new a(false);
        }
        o = new az(a, bf);
        a("/appEvent", ((ai) (new af(ag))));
        a("/canOpenURLs", com.google.android.gms.b.ah.b);
        a("/canOpenIntents", com.google.android.gms.b.ah.c);
        a("/click", com.google.android.gms.b.ah.d);
        a("/close", ah.e);
        a("/customClose", com.google.android.gms.b.ah.f);
    /* block-local class not found */
    class c {}

        a("/delayPageLoaded", ((ai) (new c(null))));
        a("/httpTrack", ah.g);
        a("/log", com.google.android.gms.b.ah.h);
        a("/mraid", ((ai) (new am(a3, o))));
        a("/open", ((ai) (new an(aj, a3, o))));
        a("/precache", com.google.android.gms.b.ah.k);
        a("/touch", ah.i);
        a("/video", ah.j);
        if (al != null)
        {
            a("/setInterstitialProperties", ((ai) (new ak(al))));
        }
        d = a1;
        e = f1;
        g = ag;
        i = aj;
        l = k1;
        n = a3;
        p = bf;
        j = al;
        a(flag);
        q = false;
    }

    public final void a(AdLauncherIntentInfoParcel adlauncherintentinfoparcel)
    {
        f f1 = null;
        boolean flag = a.l();
        com.google.android.gms.ads.internal.client.a a1;
        if (flag && !a.g().e)
        {
            a1 = null;
        } else
        {
            a1 = d;
        }
        if (!flag)
        {
            f1 = e;
        }
        a(new AdOverlayInfoParcel(adlauncherintentinfoparcel, a1, f1, l, a.k()));
    }

    public void a(AdOverlayInfoParcel adoverlayinfoparcel)
    {
        boolean flag1 = false;
        d d1;
        android.content.Context context;
        boolean flag;
        if (o != null)
        {
            flag = o.b();
        } else
        {
            flag = false;
        }
        d1 = com.google.android.gms.ads.internal.c.b();
        context = a.getContext();
        if (!flag)
        {
            flag1 = true;
        }
        d1.a(context, adoverlayinfoparcel, flag1);
    }

    public void a(a a1)
    {
        f = a1;
    }

    public final void a(String s1, ai ai1)
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
        ((List) (obj)).add(ai1);
        obj1;
        JVM INSTR monitorexit ;
        return;
        s1;
        obj1;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public void a(boolean flag)
    {
        h = flag;
    }

    public final void a(boolean flag, int i1)
    {
        com.google.android.gms.ads.internal.client.a a1;
        if (a.l() && !a.g().e)
        {
            a1 = null;
        } else
        {
            a1 = d;
        }
        a(new AdOverlayInfoParcel(a1, e, l, a, flag, i1, a.k()));
    }

    public final void a(boolean flag, int i1, String s1)
    {
        Object obj = null;
        boolean flag1 = a.l();
        com.google.android.gms.ads.internal.client.a a1;
        if (flag1 && !a.g().e)
        {
            a1 = null;
        } else
        {
            a1 = d;
        }
    /* block-local class not found */
    class b {}

        if (!flag1)
        {
            obj = new b(a, e);
        }
        a(new AdOverlayInfoParcel(a1, ((f) (obj)), g, l, a, flag, i1, s1, a.k(), i));
    }

    public final void a(boolean flag, int i1, String s1, String s2)
    {
        boolean flag1 = a.l();
        com.google.android.gms.ads.internal.client.a a1;
        Object obj;
        if (flag1 && !a.g().e)
        {
            a1 = null;
        } else
        {
            a1 = d;
        }
        if (flag1)
        {
            obj = null;
        } else
        {
            obj = new b(a, e);
        }
        a(new AdOverlayInfoParcel(a1, ((f) (obj)), g, l, a, flag, i1, s1, s2, a.k(), i));
    }

    public boolean b()
    {
        boolean flag;
        synchronized (c)
        {
            flag = k;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void c()
    {
        synchronized (c)
        {
            com.google.android.gms.ads.internal.util.client.b.d("Loading blank page in WebView, 2...");
            r = true;
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
        if (f != null && (s && u <= 0 || t))
        {
            a a1 = f;
            cj cj1 = a;
    /* block-local class not found */
    class a {}

            boolean flag;
            if (!t)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a1.a(cj1, flag);
            f = null;
        }
    }

    public void e()
    {
        if (b())
        {
            m.c();
        }
    }

    public final void f()
    {
        synchronized (c)
        {
            b.clear();
            d = null;
            e = null;
            f = null;
            g = null;
            h = false;
            k = false;
            i = null;
            l = null;
            if (o != null)
            {
                o.a(true);
                o = null;
            }
            q = false;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void g()
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        com.google.android.gms.ads.internal.overlay.c c1;
        h = false;
        k = true;
        a.o();
        c1 = a.e();
        if (c1 == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        if (com.google.android.gms.ads.internal.client.h.a().a())
        {
            break MISSING_BLOCK_LABEL_68;
        }
        com.google.android.gms.b.bz.a.post(new _cls1(c1));
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        c1.m();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void onLoadResource(WebView webview, String s1)
    {
        com.google.android.gms.ads.internal.util.client.b.d((new StringBuilder()).append("Loading resource: ").append(s1).toString());
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
                if (!r || !"about:blank".equals(s1))
                {
                    break label0;
                }
                com.google.android.gms.ads.internal.util.client.b.d("Blank page loaded, 1...");
                a.n();
            }
            return;
        }
        webview;
        JVM INSTR monitorexit ;
        s = true;
        d();
        return;
        s1;
        webview;
        JVM INSTR monitorexit ;
        throw s1;
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
        Uri uri;
        com.google.android.gms.ads.internal.util.client.b.d((new StringBuilder()).append("AdWebView shouldOverrideUrlLoading: ").append(s1).toString());
        uri = Uri.parse(s1);
        if (!"gmsg".equalsIgnoreCase(uri.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(uri.getHost())) goto _L2; else goto _L1
_L1:
        a(uri);
_L4:
        return true;
_L2:
        if (h && webview == a && b(uri))
        {
            if (!q)
            {
                q = true;
                if (d != null && ((Boolean)y.J.c()).booleanValue())
                {
                    d.a();
                }
            }
            return super.shouldOverrideUrlLoading(webview, s1);
        }
        if (a.willNotDraw())
        {
            break MISSING_BLOCK_LABEL_273;
        }
        com.google.android.gms.b.f f1 = a.j();
        webview = uri;
        if (f1 != null)
        {
            webview = uri;
            try
            {
                if (f1.b(uri))
                {
                    webview = f1.a(uri, a.getContext());
                }
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                com.google.android.gms.ads.internal.util.client.b.e((new StringBuilder()).append("Unable to append parameter to URL: ").append(s1).toString());
                webview = uri;
            }
        }
        if (n == null || n.a())
        {
            a(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", webview.toString(), null, null, null, null, null));
        } else
        {
            n.a(s1);
        }
        continue; /* Loop/switch isn't completed */
        com.google.android.gms.ads.internal.util.client.b.e((new StringBuilder()).append("AdWebView unable to handle URL: ").append(s1).toString());
        if (true) goto _L4; else goto _L3
_L3:
    }

    /* member class not found */
    class _cls1 {}

}
