// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.do;
import com.google.android.gms.internal.dr;
import com.google.android.gms.internal.gu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ace extends WebViewClient
{

    protected final gu a;
    private final HashMap b;
    private final Object c;
    private ahh d;
    private xh e;
    private acf f;
    private vb g;
    private boolean h;
    private ve i;
    private vg j;
    private boolean k;
    private xj l;
    private final wz m;
    private ahl n;

    public ace(gu gu1, boolean flag)
    {
        this(gu1, flag, new wz(gu1, gu1.getContext(), new ue(gu1.getContext())));
    }

    ace(gu gu1, boolean flag, wz wz1)
    {
        b = new HashMap();
        c = new Object();
        h = false;
        a = gu1;
        k = flag;
        m = wz1;
    }

    private static boolean a(Uri uri)
    {
        uri = uri.getScheme();
        return "http".equalsIgnoreCase(uri) || "https".equalsIgnoreCase(uri);
    }

    private void b(Uri uri)
    {
        String s = uri.getPath();
        vd vd1 = (vd)b.get(s);
        if (vd1 != null)
        {
            uri = abq.a(uri);
            if (acb.a(2))
            {
                acb.d((new StringBuilder()).append("Received GMSG: ").append(s).toString());
                String s1;
                for (Iterator iterator = uri.keySet().iterator(); iterator.hasNext(); acb.d((new StringBuilder()).append("  ").append(s1).append(": ").append((String)uri.get(s1)).toString()))
                {
                    s1 = (String)iterator.next();
                }

            }
            vd1.a(a, uri);
            return;
        } else
        {
            acb.d((new StringBuilder()).append("No GMSG handler found for GMSG: ").append(uri).toString());
            return;
        }
    }

    public ahl a()
    {
        return n;
    }

    public final void a(acf acf1)
    {
        f = acf1;
    }

    public void a(ahh ahh, xh xh, vb vb, xj xj, boolean flag, ve ve, ahl ahl1)
    {
        ahl ahl2 = ahl1;
        if (ahl1 == null)
        {
            ahl2 = new ahl(false);
        }
        a("/appEvent", ((vd) (new va(vb))));
        a("/canOpenURLs", vc.b);
        a("/canOpenIntents", vc.c);
        a("/click", vc.d);
        a("/close", vc.e);
        a("/customClose", vc.f);
        a("/httpTrack", vc.g);
        a("/log", vc.h);
        a("/open", ((vd) (new vi(ve, ahl2))));
        a("/touch", vc.i);
        a("/video", vc.j);
        a("/mraid", ((vd) (new vh())));
        d = ahh;
        e = xh;
        g = vb;
        i = ve;
        l = xj;
        n = ahl2;
        a(flag);
    }

    public void a(ahh ahh, xh xh, vb vb, xj xj, boolean flag, ve ve, vg vg, 
            ahl ahl1)
    {
        a(ahh, xh, vb, xj, flag, ve, ahl1);
        a("/setInterstitialProperties", ((vd) (new vf(vg))));
        j = vg;
    }

    public final void a(do do1)
    {
        xh xh = null;
        boolean flag = a.j();
        ahh ahh;
        if (flag && !a.e().e)
        {
            ahh = null;
        } else
        {
            ahh = d;
        }
        if (!flag)
        {
            xh = e;
        }
        a(new dr(do1, ahh, xh, l, a.i()));
    }

    protected void a(dr dr1)
    {
        xc.a(a.getContext(), dr1);
    }

    public final void a(String s, vd vd1)
    {
        b.put(s, vd1);
    }

    public final void a(boolean flag)
    {
        h = flag;
    }

    public final void a(boolean flag, int i1)
    {
        ahh ahh;
        if (a.j() && !a.e().e)
        {
            ahh = null;
        } else
        {
            ahh = d;
        }
        a(new dr(ahh, e, l, a, flag, i1, a.i()));
    }

    public final void a(boolean flag, int i1, String s)
    {
        xh xh = null;
        boolean flag1 = a.j();
        ahh ahh;
        if (flag1 && !a.e().e)
        {
            ahh = null;
        } else
        {
            ahh = d;
        }
        if (!flag1)
        {
            xh = e;
        }
        a(new dr(ahh, xh, g, l, a, flag, i1, s, a.i(), i));
    }

    public final void a(boolean flag, int i1, String s, String s1)
    {
        boolean flag1 = a.j();
        ahh ahh;
        xh xh;
        if (flag1 && !a.e().e)
        {
            ahh = null;
        } else
        {
            ahh = d;
        }
        if (flag1)
        {
            xh = null;
        } else
        {
            xh = e;
        }
        a(new dr(ahh, xh, g, l, a, flag, i1, s, s1, a.i(), i));
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
        if (b())
        {
            m.b();
        }
    }

    public final void d()
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
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void e()
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        xc xc1;
        h = false;
        k = true;
        xc1 = a.d();
        if (xc1 == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        if (aca.b())
        {
            break MISSING_BLOCK_LABEL_54;
        }
        aca.a.post(new Runnable(xc1) {

            final xc a;
            final ace b;

            public void run()
            {
                a.k();
            }

            
            {
                b = ace.this;
                a = xc1;
                super();
            }
        });
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        xc1.k();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void onLoadResource(WebView webview, String s)
    {
        acb.d((new StringBuilder()).append("Loading resource: ").append(s).toString());
        webview = Uri.parse(s);
        if ("gmsg".equalsIgnoreCase(webview.getScheme()) && "mobileads.google.com".equalsIgnoreCase(webview.getHost()))
        {
            b(webview);
        }
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
        acb.d((new StringBuilder()).append("AdWebView shouldOverrideUrlLoading: ").append(s).toString());
        uri = Uri.parse(s);
        if (!"gmsg".equalsIgnoreCase(uri.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(uri.getHost())) goto _L2; else goto _L1
_L1:
        b(uri);
_L4:
        return true;
_L2:
        if (h && webview == a && a(uri))
        {
            return super.shouldOverrideUrlLoading(webview, s);
        }
        if (a.willNotDraw())
        {
            break MISSING_BLOCK_LABEL_224;
        }
        aea aea1 = a.h();
        webview = uri;
        if (aea1 != null)
        {
            webview = uri;
            try
            {
                if (aea1.b(uri))
                {
                    webview = aea1.a(uri, a.getContext());
                }
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                acb.e((new StringBuilder()).append("Unable to append parameter to URL: ").append(s).toString());
                webview = uri;
            }
        }
        if (n == null || n.b())
        {
            a(new do("android.intent.action.VIEW", webview.toString(), null, null, null, null, null));
        } else
        {
            n.a(s);
        }
        continue; /* Loop/switch isn't completed */
        acb.e((new StringBuilder()).append("AdWebView unable to handle URL: ").append(s).toString());
        if (true) goto _L4; else goto _L3
_L3:
    }
}
