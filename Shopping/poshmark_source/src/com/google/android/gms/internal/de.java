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
//            dd, bo, ar, da, 
//            ab, bq, ao, aq, 
//            cz, m, l, bn, 
//            ap, u, br, bu

public class de extends WebViewClient
{
    public static interface a
    {

        public abstract void a(dd dd1);
    }


    private ap lV;
    private final Object mg = new Object();
    protected final dd ng;
    private final HashMap qf = new HashMap();
    private u qg;
    private br qh;
    private a qi;
    private boolean qj;
    private boolean qk;
    private bu ql;

    public de(dd dd1, boolean flag)
    {
        qj = false;
        ng = dd1;
        qk = flag;
    }

    private void a(bq bq1)
    {
        bo.a(ng.getContext(), bq1);
    }

    private static boolean b(Uri uri)
    {
        uri = uri.getScheme();
        return "http".equalsIgnoreCase(uri) || "https".equalsIgnoreCase(uri);
    }

    private void c(Uri uri)
    {
        String s = uri.getPath();
        ar ar1 = (ar)qf.get(s);
        if (ar1 != null)
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

            if (da.n(2))
            {
                da.v((new StringBuilder()).append("Received GMSG: ").append(s).toString());
                String s1;
                for (uri = hashmap.keySet().iterator(); uri.hasNext(); da.v((new StringBuilder()).append("  ").append(s1).append(": ").append((String)hashmap.get(s1)).toString()))
                {
                    s1 = (String)uri.next();
                }

            }
            ar1.a(ng, hashmap);
            return;
        } else
        {
            da.w((new StringBuilder()).append("No GMSG handler found for GMSG: ").append(uri).toString());
            return;
        }
    }

    public final void a(bn bn1)
    {
        br br = null;
        boolean flag = ng.be();
        u u;
        if (flag && !ng.Q().lo)
        {
            u = null;
        } else
        {
            u = qg;
        }
        if (!flag)
        {
            br = qh;
        }
        a(new bq(bn1, u, br, ql, ng.bd()));
    }

    public final void a(a a1)
    {
        qi = a1;
    }

    public void a(u u, br br, ap ap, bu bu, boolean flag)
    {
        a("/appEvent", ((ar) (new ao(ap))));
        a("/canOpenURLs", aq.lW);
        a("/click", aq.lX);
        a("/close", aq.lY);
        a("/customClose", aq.lZ);
        a("/httpTrack", aq.ma);
        a("/log", aq.mb);
        a("/open", aq.mc);
        a("/touch", aq.md);
        a("/video", aq.me);
        qg = u;
        qh = br;
        lV = ap;
        ql = bu;
        o(flag);
    }

    public final void a(String s, ar ar1)
    {
        qf.put(s, ar1);
    }

    public final void a(boolean flag, int i)
    {
        u u;
        if (ng.be() && !ng.Q().lo)
        {
            u = null;
        } else
        {
            u = qg;
        }
        a(new bq(u, qh, ql, ng, flag, i, ng.bd()));
    }

    public final void a(boolean flag, int i, String s)
    {
        br br = null;
        boolean flag1 = ng.be();
        u u;
        if (flag1 && !ng.Q().lo)
        {
            u = null;
        } else
        {
            u = qg;
        }
        if (!flag1)
        {
            br = qh;
        }
        a(new bq(u, br, lV, ql, ng, flag, i, s, ng.bd()));
    }

    public final void a(boolean flag, int i, String s, String s1)
    {
        br br = null;
        boolean flag1 = ng.be();
        u u;
        if (flag1 && !ng.Q().lo)
        {
            u = null;
        } else
        {
            u = qg;
        }
        if (!flag1)
        {
            br = qh;
        }
        a(new bq(u, br, lV, ql, ng, flag, i, s, s1, ng.bd()));
    }

    public final void ar()
    {
        Object obj = mg;
        obj;
        JVM INSTR monitorenter ;
        bo bo1;
        qj = false;
        qk = true;
        bo1 = ng.ba();
        if (bo1 == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        if (cz.aX())
        {
            break MISSING_BLOCK_LABEL_54;
        }
        cz.pT.post(new Runnable(bo1) {

            final bo qm;
            final de qn;

            public void run()
            {
                qm.ar();
            }

            
            {
                qn = de.this;
                qm = bo1;
                super();
            }
        });
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        bo1.ar();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean bi()
    {
        boolean flag;
        synchronized (mg)
        {
            flag = qk;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void o(boolean flag)
    {
        qj = flag;
    }

    public final void onPageFinished(WebView webview, String s)
    {
        if (qi != null)
        {
            qi.a(ng);
            qi = null;
        }
    }

    public final void reset()
    {
        synchronized (mg)
        {
            qf.clear();
            qg = null;
            qh = null;
            qi = null;
            lV = null;
            qj = false;
            qk = false;
            ql = null;
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
        da.v((new StringBuilder()).append("AdWebView shouldOverrideUrlLoading: ").append(s).toString());
        uri = Uri.parse(s);
        if (!"gmsg".equalsIgnoreCase(uri.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(uri.getHost())) goto _L2; else goto _L1
_L1:
        c(uri);
_L4:
        return true;
_L2:
        if (qj && webview == ng && b(uri))
        {
            return super.shouldOverrideUrlLoading(webview, s);
        }
        if (ng.willNotDraw())
        {
            break MISSING_BLOCK_LABEL_196;
        }
        l l1 = ng.bc();
        webview = uri;
        if (l1 != null)
        {
            webview = uri;
            try
            {
                if (l1.a(uri))
                {
                    webview = l1.a(uri, ng.getContext());
                }
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                da.w((new StringBuilder()).append("Unable to append parameter to URL: ").append(s).toString());
                webview = uri;
            }
        }
        a(new bn("android.intent.action.VIEW", webview.toString(), null, null, null, null, null));
        continue; /* Loop/switch isn't completed */
        da.w((new StringBuilder()).append("AdWebView unable to handle URL: ").append(s).toString());
        if (true) goto _L4; else goto _L3
_L3:
    }
}
