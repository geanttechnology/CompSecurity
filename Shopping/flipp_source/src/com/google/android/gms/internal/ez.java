// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            af, et, ew, cd, 
//            x, bm, t, w, 
//            er, fa, fb, jp, 
//            jg, bj, kq, ci, 
//            u, cn

public class ez extends WebViewClient
{

    protected final ew a;
    final HashMap b = new HashMap();
    final Object c = new Object();
    kq d;
    ci e;
    fb f;
    u g;
    boolean h;
    boolean i;
    cn j;

    public ez(ew ew1, boolean flag)
    {
        h = false;
        a = ew1;
        i = flag;
    }

    private void a(Uri uri)
    {
        String s = uri.getPath();
        af af1 = (af)b.get(s);
        if (af1 != null)
        {
            HashMap hashmap = new HashMap();
            Object obj = new UrlQuerySanitizer();
            ((UrlQuerySanitizer) (obj)).setAllowUnregisteredParamaters(true);
            ((UrlQuerySanitizer) (obj)).setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
            ((UrlQuerySanitizer) (obj)).parseUrl(uri.toString());
            for (uri = ((UrlQuerySanitizer) (obj)).getParameterList().iterator(); uri.hasNext(); hashmap.put(((android.net.UrlQuerySanitizer.ParameterValuePair) (obj)).mParameter, ((android.net.UrlQuerySanitizer.ParameterValuePair) (obj)).mValue))
            {
                obj = (android.net.UrlQuerySanitizer.ParameterValuePair)uri.next();
            }

            if (et.a(2))
            {
                et.c((new StringBuilder("Received GMSG: ")).append(s).toString());
                String s1;
                for (uri = hashmap.keySet().iterator(); uri.hasNext(); et.c((new StringBuilder("  ")).append(s1).append(": ").append((String)hashmap.get(s1)).toString()))
                {
                    s1 = (String)uri.next();
                }

            }
            af1.a(a, hashmap);
            return;
        } else
        {
            et.d((new StringBuilder("No GMSG handler found for GMSG: ")).append(uri).toString());
            return;
        }
    }

    private void a(bm bm1)
    {
        cd.a(a.getContext(), bm1);
    }

    public final void a(bj bj1)
    {
        ci ci = null;
        boolean flag = a.d();
        kq kq;
        if (flag && !a.c().e)
        {
            kq = null;
        } else
        {
            kq = d;
        }
        if (!flag)
        {
            ci = e;
        }
        a(new bm(bj1, kq, ci, j, a.d));
    }

    public final void a(kq kq, ci ci, u u, cn cn, boolean flag)
    {
        a("/appEvent", ((af) (new t(u))));
        a("/canOpenURLs", w.a);
        a("/click", w.b);
        a("/close", w.c);
        a("/customClose", w.d);
        a("/httpTrack", w.e);
        a("/log", w.f);
        a("/open", w.g);
        a("/touch", w.h);
        a("/video", w.i);
        d = kq;
        e = ci;
        g = u;
        j = cn;
        h = flag;
    }

    public final void a(String s, af af1)
    {
        b.put(s, af1);
    }

    public final void a(boolean flag, int k)
    {
        kq kq;
        if (a.d() && !a.c().e)
        {
            kq = null;
        } else
        {
            kq = d;
        }
        a(new bm(kq, e, j, a, flag, k, a.d));
    }

    public final void a(boolean flag, int k, String s)
    {
        ci ci = null;
        boolean flag1 = a.d();
        kq kq;
        if (flag1 && !a.c().e)
        {
            kq = null;
        } else
        {
            kq = d;
        }
        if (!flag1)
        {
            ci = e;
        }
        a(new bm(kq, ci, g, j, a, flag, k, s, a.d));
    }

    public final void a(boolean flag, int k, String s, String s1)
    {
        ci ci = null;
        boolean flag1 = a.d();
        kq kq;
        if (flag1 && !a.c().e)
        {
            kq = null;
        } else
        {
            kq = d;
        }
        if (!flag1)
        {
            ci = e;
        }
        a(new bm(kq, ci, g, j, a, flag, k, s, s1, a.d));
    }

    public final boolean a()
    {
        boolean flag;
        synchronized (c)
        {
            flag = i;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void b()
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        cd cd1;
        h = false;
        i = true;
        cd1 = a.b();
        if (cd1 == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        if (er.b())
        {
            break MISSING_BLOCK_LABEL_54;
        }
        er.a.post(new fa(this, cd1));
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        cd1.h();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void onPageFinished(WebView webview, String s)
    {
        if (f != null)
        {
            f.a(a);
            f = null;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        Uri uri;
        et.c((new StringBuilder("AdWebView shouldOverrideUrlLoading: ")).append(s).toString());
        uri = Uri.parse(s);
        if (!"gmsg".equalsIgnoreCase(uri.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(uri.getHost())) goto _L2; else goto _L1
_L1:
        a(uri);
_L4:
        return true;
_L2:
        if (h && webview == a)
        {
            String s1 = uri.getScheme();
            boolean flag;
            if ("http".equalsIgnoreCase(s1) || "https".equalsIgnoreCase(s1))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return super.shouldOverrideUrlLoading(webview, s);
            }
        }
        if (a.willNotDraw())
        {
            break MISSING_BLOCK_LABEL_225;
        }
        jg jg1 = a.c;
        webview = uri;
        if (jg1 != null)
        {
            webview = uri;
            try
            {
                if (jg1.a(uri))
                {
                    webview = jg1.a(uri, a.getContext());
                }
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                et.d((new StringBuilder("Unable to append parameter to URL: ")).append(s).toString());
                webview = uri;
            }
        }
        a(new bj("android.intent.action.VIEW", webview.toString(), null, null, null, null, null));
        continue; /* Loop/switch isn't completed */
        et.d((new StringBuilder("AdWebView unable to handle URL: ")).append(s).toString());
        if (true) goto _L4; else goto _L3
_L3:
    }
}
