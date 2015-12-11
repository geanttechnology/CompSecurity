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
//            cw, bk, an, ct, 
//            cs, x, bm, ak, 
//            am, i, h, bj, 
//            al, q, bn, bq

public class cx extends WebViewClient
{
    public static interface a
    {

        public abstract void a(cw cw1);
    }


    private al fm;
    private final Object fx = new Object();
    protected final cw gv;
    private final HashMap iU = new HashMap();
    private q iV;
    private bn iW;
    private a iX;
    private boolean iY;
    private boolean iZ;
    private bq ja;

    public cx(cw cw1, boolean flag)
    {
        iY = false;
        gv = cw1;
        iZ = flag;
    }

    private void a(bm bm1)
    {
        bk.a(gv.getContext(), bm1);
    }

    private static boolean b(Uri uri)
    {
        uri = uri.getScheme();
        return "http".equalsIgnoreCase(uri) || "https".equalsIgnoreCase(uri);
    }

    private void c(Uri uri)
    {
        String s = uri.getPath();
        an an1 = (an)iU.get(s);
        if (an1 != null)
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

            if (ct.n(2))
            {
                ct.u((new StringBuilder()).append("Received GMSG: ").append(s).toString());
                String s1;
                for (uri = hashmap.keySet().iterator(); uri.hasNext(); ct.u((new StringBuilder()).append("  ").append(s1).append(": ").append((String)hashmap.get(s1)).toString()))
                {
                    s1 = (String)uri.next();
                }

            }
            an1.a(gv, hashmap);
            return;
        } else
        {
            ct.v((new StringBuilder()).append("No GMSG handler found for GMSG: ").append(uri).toString());
            return;
        }
    }

    public final void Y()
    {
        Object obj = fx;
        obj;
        JVM INSTR monitorenter ;
        bk bk1;
        iY = false;
        iZ = true;
        bk1 = gv.aB();
        if (bk1 == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        if (cs.ay())
        {
            break MISSING_BLOCK_LABEL_54;
        }
        cs.iI.post(new Runnable(bk1) {

            final bk jb;
            final cx jc;

            public void run()
            {
                jb.Y();
            }

            
            {
                jc = cx.this;
                jb = bk1;
                super();
            }
        });
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        bk1.Y();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(bj bj1)
    {
        bn bn = null;
        boolean flag = gv.aF();
        q q;
        if (flag && !gv.y().eG)
        {
            q = null;
        } else
        {
            q = iV;
        }
        if (!flag)
        {
            bn = iW;
        }
        a(new bm(bj1, q, bn, ja, gv.aE()));
    }

    public final void a(a a1)
    {
        iX = a1;
    }

    public void a(q q, bn bn, al al, bq bq, boolean flag)
    {
        a("/appEvent", ((an) (new ak(al))));
        a("/canOpenURLs", am.fn);
        a("/click", am.fo);
        a("/close", am.fp);
        a("/customClose", am.fq);
        a("/httpTrack", am.fr);
        a("/log", am.fs);
        a("/open", am.ft);
        a("/touch", am.fu);
        a("/video", am.fv);
        iV = q;
        iW = bn;
        fm = al;
        ja = bq;
        m(flag);
    }

    public final void a(String s, an an1)
    {
        iU.put(s, an1);
    }

    public final void a(boolean flag, int j)
    {
        q q;
        if (gv.aF() && !gv.y().eG)
        {
            q = null;
        } else
        {
            q = iV;
        }
        a(new bm(q, iW, ja, gv, flag, j, gv.aE()));
    }

    public final void a(boolean flag, int j, String s)
    {
        bn bn = null;
        boolean flag1 = gv.aF();
        q q;
        if (flag1 && !gv.y().eG)
        {
            q = null;
        } else
        {
            q = iV;
        }
        if (!flag1)
        {
            bn = iW;
        }
        a(new bm(q, bn, fm, ja, gv, flag, j, s, gv.aE()));
    }

    public final void a(boolean flag, int j, String s, String s1)
    {
        bn bn = null;
        boolean flag1 = gv.aF();
        q q;
        if (flag1 && !gv.y().eG)
        {
            q = null;
        } else
        {
            q = iV;
        }
        if (!flag1)
        {
            bn = iW;
        }
        a(new bm(q, bn, fm, ja, gv, flag, j, s, s1, gv.aE()));
    }

    public boolean aJ()
    {
        boolean flag;
        synchronized (fx)
        {
            flag = iZ;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void m(boolean flag)
    {
        iY = flag;
    }

    public final void onPageFinished(WebView webview, String s)
    {
        if (iX != null)
        {
            iX.a(gv);
            iX = null;
        }
    }

    public final void reset()
    {
        synchronized (fx)
        {
            iU.clear();
            iV = null;
            iW = null;
            iX = null;
            fm = null;
            iY = false;
            iZ = false;
            ja = null;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        Uri uri;
        ct.u((new StringBuilder()).append("AdWebView shouldOverrideUrlLoading: ").append(s).toString());
        uri = Uri.parse(s);
        if (!"gmsg".equalsIgnoreCase(uri.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(uri.getHost())) goto _L2; else goto _L1
_L1:
        c(uri);
_L4:
        return true;
_L2:
        if (iY && webview == gv && b(uri))
        {
            return super.shouldOverrideUrlLoading(webview, s);
        }
        if (gv.willNotDraw())
        {
            break MISSING_BLOCK_LABEL_196;
        }
        h h1 = gv.aD();
        webview = uri;
        if (h1 != null)
        {
            webview = uri;
            try
            {
                if (h1.a(uri))
                {
                    webview = h1.a(uri, gv.getContext());
                }
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                ct.v((new StringBuilder()).append("Unable to append parameter to URL: ").append(s).toString());
                webview = uri;
            }
        }
        a(new bj("android.intent.action.VIEW", webview.toString(), null, null, null, null, null));
        continue; /* Loop/switch isn't completed */
        ct.v((new StringBuilder()).append("AdWebView unable to handle URL: ").append(s).toString());
        if (true) goto _L4; else goto _L3
_L3:
    }
}
