// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package android.support.v7:
//            qt, ul, nf, nn, 
//            nj, tp, qo, ox, 
//            ot, ow, pd, pe, 
//            pa, tq, md, mc, 
//            ou, oz, pb, qv

public class um extends WebViewClient
{
    public static interface a
    {

        public abstract void zza(ul ul1, boolean flag);
    }

    public static interface b
    {

        public abstract void zzbf();
    }

    private static class c
        implements zzg
    {

        private ul a;
        private zzg b;

        public void zzaV()
        {
            b.zzaV();
            a.a();
        }

        public void zzaW()
        {
            b.zzaW();
            a.b();
        }

        public c(ul ul1, zzg zzg1)
        {
            a = ul1;
            b = zzg1;
        }
    }

    private class d
        implements ox
    {

        final um a;

        public void zza(ul ul1, Map map)
        {
            if (map.keySet().contains("start"))
            {
                um.a(a);
            } else
            {
                if (map.keySet().contains("stop"))
                {
                    um.b(a);
                    return;
                }
                if (map.keySet().contains("cancel"))
                {
                    um.c(a);
                    return;
                }
            }
        }

        private d()
        {
            a = um.this;
            super();
        }

    }


    private static final String b[] = {
        "UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", 
        "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"
    };
    private static final String c[] = {
        "NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"
    };
    protected final ul a;
    private final HashMap d;
    private final Object e;
    private zza f;
    private zzg g;
    private a h;
    private ou i;
    private b j;
    private boolean k;
    private oz l;
    private pb m;
    private boolean n;
    private boolean o;
    private zzn p;
    private final qt q;
    private zze r;
    private qo s;
    private qv t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;

    public um(ul ul1, boolean flag)
    {
        this(ul1, flag, new qt(ul1, ul1.d(), new nf(ul1.getContext())), null);
    }

    um(ul ul1, boolean flag, qt qt1, qo qo1)
    {
        d = new HashMap();
        e = new Object();
        k = false;
        a = ul1;
        n = flag;
        q = qt1;
        s = qo1;
    }

    static b a(um um1, b b1)
    {
        um1.j = b1;
        return b1;
    }

    private String a(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            return "";
        }
        s1 = Uri.parse(s1);
        if (s1.getHost() != null)
        {
            return s1.getHost();
        } else
        {
            return "";
        }
    }

    private void a(Context context, String s1, String s2, String s3)
    {
        if (!((Boolean)nn.af.c()).booleanValue())
        {
            return;
        } else
        {
            Bundle bundle = new Bundle();
            bundle.putString("err", s1);
            bundle.putString("code", s2);
            bundle.putString("host", a(s3));
            zzp.zzbx().a(context, a.l().zzIz, "gmob-apps", bundle, true);
            return;
        }
    }

    static void a(um um1)
    {
        um1.h();
    }

    static void b(um um1)
    {
        um1.i();
    }

    private static boolean b(Uri uri)
    {
        uri = uri.getScheme();
        return "http".equalsIgnoreCase(uri) || "https".equalsIgnoreCase(uri);
    }

    static void c(um um1)
    {
        um1.j();
    }

    static b d(um um1)
    {
        return um1.j;
    }

    private void h()
    {
        synchronized (e)
        {
            o = true;
        }
        y = y + 1;
        e();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void i()
    {
        y = y - 1;
        e();
    }

    private void j()
    {
        x = true;
        e();
    }

    public zze a()
    {
        return r;
    }

    public void a(int i1, int j1)
    {
        if (s != null)
        {
            s.c(i1, j1);
        }
    }

    public void a(int i1, int j1, boolean flag)
    {
        q.a(i1, j1);
        if (s != null)
        {
            s.a(i1, j1, flag);
        }
    }

    public void a(Uri uri)
    {
        String s1 = uri.getPath();
        Object obj = (List)d.get(s1);
        if (obj != null)
        {
            uri = zzp.zzbx().a(uri);
            if (zzb.zzM(2))
            {
                zzb.v((new StringBuilder()).append("Received GMSG: ").append(s1).toString());
                String s2;
                for (Iterator iterator = uri.keySet().iterator(); iterator.hasNext(); zzb.v((new StringBuilder()).append("  ").append(s2).append(": ").append((String)uri.get(s2)).toString()))
                {
                    s2 = (String)iterator.next();
                }

            }
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((ox)((Iterator) (obj)).next()).zza(a, uri)) { }
        } else
        {
            zzb.v((new StringBuilder()).append("No GMSG handler found for GMSG: ").append(uri).toString());
        }
    }

    public void a(a a1)
    {
        h = a1;
    }

    public void a(b b1)
    {
        j = b1;
    }

    public void a(zza zza1, zzg zzg, ou ou, zzn zzn, boolean flag, oz oz, pb pb, 
            zze zze1, qv qv)
    {
        zze zze2 = zze1;
        if (zze1 == null)
        {
            zze2 = new zze(false);
        }
        s = new qo(a, qv);
        a("/appEvent", ((ox) (new ot(ou))));
        a("/backButton", ow.j);
        a("/canOpenURLs", ow.b);
        a("/canOpenIntents", ow.c);
        a("/click", ow.d);
        a("/close", ow.e);
        a("/customClose", ow.f);
        a("/delayPageLoaded", ((ox) (new d())));
        a("/httpTrack", ow.g);
        a("/log", ow.h);
        a("/mraid", ((ox) (new pd(zze2, s))));
        a("/mraidLoaded", ((ox) (q)));
        a("/open", ((ox) (new pe(oz, zze2, s))));
        a("/precache", ow.l);
        a("/touch", ow.i);
        a("/video", ow.k);
        if (pb != null)
        {
            a("/setInterstitialProperties", ((ox) (new pa(pb))));
        }
        f = zza1;
        g = zzg;
        i = ou;
        l = oz;
        p = zzn;
        r = zze2;
        t = qv;
        m = pb;
        a(flag);
        u = false;
    }

    public final void a(AdLauncherIntentInfoParcel adlauncherintentinfoparcel)
    {
        zzg zzg = null;
        boolean flag = a.m();
        zza zza1;
        if (flag && !a.h().zzsH)
        {
            zza1 = null;
        } else
        {
            zza1 = f;
        }
        if (!flag)
        {
            zzg = g;
        }
        a(new AdOverlayInfoParcel(adlauncherintentinfoparcel, zza1, zzg, p, a.l()));
    }

    public void a(AdOverlayInfoParcel adoverlayinfoparcel)
    {
        boolean flag1 = false;
        com.google.android.gms.ads.internal.overlay.zze zze1;
        Context context;
        boolean flag;
        if (s != null)
        {
            flag = s.b();
        } else
        {
            flag = false;
        }
        zze1 = zzp.zzbv();
        context = a.getContext();
        if (!flag)
        {
            flag1 = true;
        }
        zze1.zza(context, adoverlayinfoparcel, flag1);
    }

    public final void a(String s1, ox ox1)
    {
        Object obj1 = e;
        obj1;
        JVM INSTR monitorenter ;
        List list = (List)d.get(s1);
        Object obj;
        obj = list;
        if (list != null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        obj = new CopyOnWriteArrayList();
        d.put(s1, obj);
        ((List) (obj)).add(ox1);
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
        k = flag;
    }

    public final void a(boolean flag, int i1)
    {
        zza zza1;
        if (a.m() && !a.h().zzsH)
        {
            zza1 = null;
        } else
        {
            zza1 = f;
        }
        a(new AdOverlayInfoParcel(zza1, g, p, a, flag, i1, a.l()));
    }

    public final void a(boolean flag, int i1, String s1)
    {
        Object obj = null;
        boolean flag1 = a.m();
        zza zza1;
        if (flag1 && !a.h().zzsH)
        {
            zza1 = null;
        } else
        {
            zza1 = f;
        }
        if (!flag1)
        {
            obj = new c(a, g);
        }
        a(new AdOverlayInfoParcel(zza1, ((zzg) (obj)), i, p, a, flag, i1, s1, a.l(), l));
    }

    public final void a(boolean flag, int i1, String s1, String s2)
    {
        boolean flag1 = a.m();
        zza zza1;
        Object obj;
        if (flag1 && !a.h().zzsH)
        {
            zza1 = null;
        } else
        {
            zza1 = f;
        }
        if (flag1)
        {
            obj = null;
        } else
        {
            obj = new c(a, g);
        }
        a(new AdOverlayInfoParcel(zza1, ((zzg) (obj)), i, p, a, flag, i1, s1, s2, a.l(), l));
    }

    public final void b(String s1, ox ox1)
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        s1 = (List)d.get(s1);
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        s1.remove(ox1);
        obj;
        JVM INSTR monitorexit ;
        return;
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public boolean b()
    {
        boolean flag;
        synchronized (e)
        {
            flag = n;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean c()
    {
        boolean flag;
        synchronized (e)
        {
            flag = o;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void d()
    {
        synchronized (e)
        {
            zzb.v("Loading blank page in WebView, 2...");
            v = true;
            a.a("about:blank");
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void e()
    {
        if (h != null && (w && y <= 0 || x))
        {
            a a1 = h;
            ul ul1 = a;
            boolean flag;
            if (!x)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a1.zza(ul1, flag);
            h = null;
        }
    }

    public final void f()
    {
        synchronized (e)
        {
            d.clear();
            f = null;
            g = null;
            h = null;
            i = null;
            k = false;
            n = false;
            o = false;
            l = null;
            p = null;
            j = null;
            if (s != null)
            {
                s.a(true);
                s = null;
            }
            u = false;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void g()
    {
        synchronized (e)
        {
            k = false;
            n = true;
            tp.a(new Runnable() {

                final um a;

                public void run()
                {
                    a.a.q();
                    zzd zzd1 = a.a.f();
                    if (zzd1 != null)
                    {
                        zzd1.zzeA();
                    }
                    if (um.d(a) != null)
                    {
                        um.d(a).zzbf();
                        um.a(a, null);
                    }
                }

            
            {
                a = um.this;
                super();
            }
            });
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void onLoadResource(WebView webview, String s1)
    {
        zzb.v((new StringBuilder()).append("Loading resource: ").append(s1).toString());
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
            synchronized (e)
            {
                if (!v || !"about:blank".equals(s1))
                {
                    break label0;
                }
                zzb.v("Blank page loaded, 1...");
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
        if (i1 < 0 && -i1 - 1 < b.length)
        {
            s3 = b[-i1 - 1];
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
            if (i1 >= 0 && i1 < c.length)
            {
                s1 = c[i1];
            } else
            {
                s1 = String.valueOf(i1);
            }
            a(a.getContext(), "ssl_err", s1, zzp.zzbz().a(sslerror));
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
        Uri uri;
        zzb.v((new StringBuilder()).append("AdWebView shouldOverrideUrlLoading: ").append(s1).toString());
        uri = Uri.parse(s1);
        if (!"gmsg".equalsIgnoreCase(uri.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(uri.getHost())) goto _L2; else goto _L1
_L1:
        a(uri);
_L4:
        return true;
_L2:
        if (k && webview == a && b(uri))
        {
            if (!u)
            {
                u = true;
                if (f != null && ((Boolean)nn.T.c()).booleanValue())
                {
                    f.onAdClicked();
                }
            }
            return super.shouldOverrideUrlLoading(webview, s1);
        }
        if (a.willNotDraw())
        {
            break MISSING_BLOCK_LABEL_273;
        }
        mc mc1 = a.k();
        webview = uri;
        if (mc1 != null)
        {
            webview = uri;
            try
            {
                if (mc1.b(uri))
                {
                    webview = mc1.a(uri, a.getContext());
                }
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                zzb.zzaE((new StringBuilder()).append("Unable to append parameter to URL: ").append(s1).toString());
                webview = uri;
            }
        }
        if (r == null || r.zzbe())
        {
            a(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", webview.toString(), null, null, null, null, null));
        } else
        {
            r.zzp(s1);
        }
        continue; /* Loop/switch isn't completed */
        zzb.zzaE((new StringBuilder()).append("AdWebView unable to handle URL: ").append(s1).toString());
        if (true) goto _L4; else goto _L3
_L3:
    }

}
