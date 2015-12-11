// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.m;
import com.google.android.gms.ads.internal.client.o;
import com.google.android.gms.ads.internal.client.p;
import com.google.android.gms.ads.internal.client.v;
import com.google.android.gms.ads.internal.overlay.n;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.c;
import com.google.android.gms.b.d;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.ah;
import com.google.android.gms.d.ai;
import com.google.android.gms.d.ak;
import com.google.android.gms.d.ax;
import com.google.android.gms.d.ay;
import com.google.android.gms.d.bb;
import com.google.android.gms.d.bd;
import com.google.android.gms.d.be;
import com.google.android.gms.d.bi;
import com.google.android.gms.d.cb;
import com.google.android.gms.d.em;
import com.google.android.gms.d.eq;
import com.google.android.gms.d.gb;
import com.google.android.gms.d.gc;
import com.google.android.gms.d.gd;
import com.google.android.gms.d.ge;
import com.google.android.gms.d.gf;
import com.google.android.gms.d.gg;
import com.google.android.gms.d.gm;
import com.google.android.gms.d.gn;
import com.google.android.gms.d.gw;
import com.google.android.gms.d.he;
import com.google.android.gms.d.hf;
import com.google.android.gms.d.x;
import com.google.android.gms.d.y;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.WeakHashMap;

// Referenced classes of package com.google.android.gms.ads.internal:
//            o, p, q, d

public abstract class a extends com.google.android.gms.ads.internal.client.t.a
    implements com.google.android.gms.ads.internal.client.a, n, com.google.android.gms.ads.internal.request.a, cb, com.google.android.gms.d.fb.a, gf
{

    boolean a;
    protected final com.google.android.gms.ads.internal.o b = new com.google.android.gms.ads.internal.o(this);
    protected final q c;
    protected transient AdRequestParcel d;
    protected final x e;
    protected final com.google.android.gms.ads.internal.d f;
    private be g;
    private bd h;
    private bd i;

    a(q q1, com.google.android.gms.ads.internal.d d1)
    {
        a = false;
        c = q1;
        f = d1;
        q1 = com.google.android.gms.ads.internal.p.e();
        d1 = c.c;
        if (!((gm) (q1)).c)
        {
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.intent.action.USER_PRESENT");
            intentfilter.addAction("android.intent.action.SCREEN_OFF");
            d1.getApplicationContext().registerReceiver(new com.google.android.gms.d.gm.a(q1, (byte)0), intentfilter);
            q1.c = true;
        }
        com.google.android.gms.ads.internal.p.h().a(c.c, c.e);
        e = com.google.android.gms.ads.internal.p.h().c;
    }

    private static long a(String s)
    {
        int j;
        int j1;
        j1 = s.indexOf("ufe");
        int i1 = s.indexOf(',', j1);
        j = i1;
        if (i1 == -1)
        {
            j = s.length();
        }
        long l1 = Long.parseLong(s.substring(j1 + 4, j));
        return l1;
        s;
        com.google.android.gms.ads.internal.util.client.b.a(5);
_L2:
        return -1L;
        s;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        if (true) goto _L2; else goto _L1
_L1:
    }

    static Bundle a(ak ak1)
    {
        if (ak1 != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if (ak1.a)
        {
            synchronized (ak1.b)
            {
                ak1.a = false;
                ak1.b.notifyAll();
                com.google.android.gms.ads.internal.util.client.b.a(3);
            }
        }
        obj = ak1.c.a();
        if (obj != null)
        {
            ak1 = ((ah) (obj)).f;
            (new StringBuilder("In AdManger: loadAd, ")).append(((ah) (obj)).toString());
            com.google.android.gms.ads.internal.util.client.b.a(3);
        } else
        {
            ak1 = null;
        }
        if (ak1 == null) goto _L1; else goto _L3
_L3:
        obj = new Bundle(1);
        ((Bundle) (obj)).putString("fingerprint", ak1);
        ((Bundle) (obj)).putInt("v", 1);
        return ((Bundle) (obj));
        ak1;
        obj;
        JVM INSTR monitorexit ;
        throw ak1;
    }

    public final c a()
    {
        w.b("getAdFrame must be called on the main UI thread.");
        return com.google.android.gms.b.d.a(c.f);
    }

    protected final void a(View view)
    {
        c.f.addView(view, com.google.android.gms.ads.internal.p.g().d());
    }

    public final void a(AdSizeParcel adsizeparcel)
    {
        w.b("setAdSize must be called on the main UI thread.");
        c.i = adsizeparcel;
        if (c.j != null && c.j.b != null && c.C == 0)
        {
            c.j.b.a(adsizeparcel);
        }
        if (c.f == null)
        {
            return;
        }
        if (c.f.getChildCount() > 1)
        {
            c.f.removeView(c.f.getNextView());
        }
        c.f.setMinimumWidth(adsizeparcel.g);
        c.f.setMinimumHeight(adsizeparcel.d);
        c.f.requestLayout();
    }

    public final void a(o o1)
    {
        w.b("setAdListener must be called on the main UI thread.");
        c.m = o1;
    }

    public final void a(p p1)
    {
        w.b("setAdListener must be called on the main UI thread.");
        c.n = p1;
    }

    public final void a(v v1)
    {
        w.b("setAppEventListener must be called on the main UI thread.");
        c.o = v1;
    }

    public final void a(com.google.android.gms.ads.internal.client.w w1)
    {
        w.b("setCorrelationIdProvider must be called on the main UI thread");
        c.p = w1;
    }

    public void a(bi bi)
    {
        throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
    }

    public void a(em em)
    {
        throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
    }

    public void a(eq eq, String s)
    {
        throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
    }

    public final void a(com.google.android.gms.d.gb.a a1)
    {
        if (a1.b.n != -1L && !TextUtils.isEmpty(a1.b.z))
        {
            long l1 = a(a1.b.z);
            if (l1 != -1L)
            {
                bd bd1 = g.a(l1 + a1.b.n);
                g.a(bd1, new String[] {
                    "stc"
                });
            }
        }
        be be1 = g;
        String s = a1.b.z;
        if (be1.a)
        {
            synchronized (be1.b)
            {
                be1.c = s;
            }
        }
        g.a(h, new String[] {
            "arf"
        });
        i = g.a();
        c.g = null;
        c.k = a1;
        a(a1, g);
        return;
        a1;
        obj;
        JVM INSTR monitorexit ;
        throw a1;
    }

    protected abstract void a(com.google.android.gms.d.gb.a a1, be be1);

    public final void a(String s, String s1)
    {
        if (c.o == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        c.o.a(s, s1);
        return;
        s;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        return;
    }

    public final void a(HashSet hashset)
    {
        c.F = hashset;
    }

    public void a(boolean flag)
    {
        throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    protected final boolean a(int j)
    {
        com.google.android.gms.ads.internal.util.client.b.a(5);
        a = false;
        if (c.n == null)
        {
            return false;
        }
        try
        {
            c.n.a(j);
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return false;
        }
        return true;
    }

    public boolean a(AdRequestParcel adrequestparcel)
    {
        w.b("loadAd must be called on the main UI thread.");
        if (c.g != null || c.h != null)
        {
            if (d != null)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
            }
            d = adrequestparcel;
            return false;
        }
        com.google.android.gms.ads.internal.util.client.b.a(4);
        a = true;
        com.google.android.gms.d.au au = ay.G;
        g = new be(((Boolean)com.google.android.gms.ads.internal.p.n().a(au)).booleanValue(), "load_ad", c.i.b);
        h = new bd(-1L, null, null);
        i = new bd(-1L, null, null);
        h = g.a();
        if (!adrequestparcel.f)
        {
            StringBuilder stringbuilder = new StringBuilder("Use AdRequest.Builder.addTestDevice(\"");
            com.google.android.gms.ads.internal.client.m.a();
            stringbuilder.append(com.google.android.gms.ads.internal.util.client.a.a(c.c)).append("\") to get test ads on this device.");
            com.google.android.gms.ads.internal.util.client.b.a(4);
        }
        return a(adrequestparcel, g);
    }

    protected abstract boolean a(AdRequestParcel adrequestparcel, be be1);

    boolean a(gb gb1)
    {
        return false;
    }

    protected abstract boolean a(gb gb1, gb gb2);

    public final void b()
    {
        Object obj1;
        gb gb1;
        w.b("destroy must be called on the main UI thread.");
        b.a();
        obj1 = e;
        gb1 = c.j;
        Object obj = ((x) (obj1)).a;
        obj;
        JVM INSTR monitorenter ;
        obj1 = (y)((x) (obj1)).b.get(gb1);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        ((y) (obj1)).e();
        obj;
        JVM INSTR monitorexit ;
        obj = c;
        if (((q) (obj)).f != null)
        {
            q.a a1 = ((q) (obj)).f;
            com.google.android.gms.ads.internal.util.client.b.a(2);
            if (a1.b != null)
            {
                a1.b.b();
            }
        }
        obj.n = null;
        obj.o = null;
        obj.r = null;
        obj.q = null;
        obj.x = null;
        obj.p = null;
        ((q) (obj)).a(false);
        if (((q) (obj)).f != null)
        {
            ((q) (obj)).f.removeAllViews();
        }
        ((q) (obj)).a();
        ((q) (obj)).b();
        obj.j = null;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void b(gb gb1)
    {
        g.a(i, new String[] {
            "awr"
        });
        c.h = null;
        if (gb1.d != -2 && gb1.d != 3)
        {
            gd gd1 = com.google.android.gms.ads.internal.p.h();
            HashSet hashset = c.F;
            synchronized (gd1.a)
            {
                gd1.d.addAll(hashset);
            }
        }
        if (gb1.d != -1) goto _L2; else goto _L1
_L1:
        a = false;
_L4:
        return;
        gb1;
        obj;
        JVM INSTR monitorexit ;
        throw gb1;
_L2:
        if (a(gb1))
        {
            com.google.android.gms.ads.internal.util.client.b.a(3);
        }
        if (gb1.d != -2)
        {
            a(gb1.d);
            return;
        }
        if (c.A == null)
        {
            c.A = new gg(c.b);
        }
        e.a(c.j);
        if (!a(c.j, gb1)) goto _L4; else goto _L3
_L3:
        gc gc1;
        boolean flag;
        c.j = gb1;
        gb1 = c;
        gc1 = ((q) (gb1)).l;
        long l1 = ((q) (gb1)).j.t;
        synchronized (gc1.c)
        {
            gc1.j = l1;
            if (gc1.j != -1L)
            {
                gc1.a.a(gc1);
            }
        }
        gc1 = ((q) (gb1)).l;
        l1 = ((q) (gb1)).j.u;
        synchronized (gc1.c)
        {
            if (gc1.j != -1L)
            {
                gc1.d = l1;
                gc1.a.a(gc1);
            }
        }
        gc1 = ((q) (gb1)).l;
        flag = ((q) (gb1)).i.e;
        obj1 = gc1.c;
        obj1;
        JVM INSTR monitorenter ;
        if (gc1.j == -1L)
        {
            break MISSING_BLOCK_LABEL_359;
        }
        gc1.g = SystemClock.elapsedRealtime();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_359;
        }
        gc1.e = gc1.g;
        gc1.a.a(gc1);
        obj1;
        JVM INSTR monitorexit ;
        obj1 = ((q) (gb1)).l;
        boolean flag1 = ((q) (gb1)).j.k;
        synchronized (((gc) (obj1)).c)
        {
            if (((gc) (obj1)).j != -1L)
            {
                obj1.f = flag1;
                ((gc) (obj1)).a.a(((gc) (obj1)));
            }
        }
        obj1 = g;
        if (c.j.a())
        {
            gb1 = "1";
        } else
        {
            gb1 = "0";
        }
        ((be) (obj1)).a("is_mraid", gb1);
        obj1 = g;
        if (c.j.k)
        {
            gb1 = "1";
        } else
        {
            gb1 = "0";
        }
        ((be) (obj1)).a("is_mediation", gb1);
        if (c.j.b != null && c.j.b.i() != null)
        {
            obj1 = g;
            if (c.j.b.i().b())
            {
                gb1 = "1";
            } else
            {
                gb1 = "0";
            }
            ((be) (obj1)).a("is_video", gb1);
        }
        g.a(h, new String[] {
            "ttc"
        });
        if (com.google.android.gms.ads.internal.p.h().c() != null)
        {
            com.google.android.gms.ads.internal.p.h().c().a(g);
        }
        if (!c.c()) goto _L4; else goto _L5
_L5:
        p();
        return;
        gb1;
        obj1;
        JVM INSTR monitorexit ;
        throw gb1;
        gb1;
        obj1;
        JVM INSTR monitorexit ;
        throw gb1;
        gb1;
        obj1;
        JVM INSTR monitorexit ;
        throw gb1;
        exception;
        gb1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected boolean b(AdRequestParcel adrequestparcel)
    {
        adrequestparcel = c.f.getParent();
        return (adrequestparcel instanceof View) && ((View)adrequestparcel).isShown() && com.google.android.gms.ads.internal.p.e().b;
    }

    public final void c(AdRequestParcel adrequestparcel)
    {
        if (b(adrequestparcel))
        {
            a(adrequestparcel);
            return;
        } else
        {
            com.google.android.gms.ads.internal.util.client.b.a(4);
            b.a(adrequestparcel);
            return;
        }
    }

    protected final void c(gb gb1)
    {
        if (gb1 != null) goto _L2; else goto _L1
_L1:
        com.google.android.gms.ads.internal.util.client.b.a(5);
_L4:
        return;
_L2:
        gc gc1;
        com.google.android.gms.ads.internal.util.client.b.a(3);
        gc1 = c.l;
        Object obj = gc1.c;
        obj;
        JVM INSTR monitorenter ;
        ge ge1;
        if (gc1.j != -1L && gc1.e == -1L)
        {
            gc1.e = SystemClock.elapsedRealtime();
            gc1.a.a(gc1);
        }
        ge1 = gc1.a.b();
        synchronized (ge1.d)
        {
            ge1.g = ge1.g + 1;
        }
        obj;
        JVM INSTR monitorexit ;
        if (gb1.e == null) goto _L4; else goto _L3
_L3:
        com.google.android.gms.ads.internal.p.e();
        obj = c.c;
        obj1 = c.e.b;
        com.google.android.gms.ads.internal.p.e();
        gm.a(((Context) (obj)), ((String) (obj1)), gm.a(c.c, gb1.e, gb1.x));
        return;
        gb1;
        obj1;
        JVM INSTR monitorexit ;
        throw gb1;
        gb1;
        obj;
        JVM INSTR monitorexit ;
        throw gb1;
    }

    public final boolean c()
    {
        w.b("isLoaded must be called on the main UI thread.");
        return c.g == null && c.h == null && c.j != null;
    }

    public void d()
    {
        w.b("pause must be called on the main UI thread.");
    }

    public void e()
    {
        w.b("resume must be called on the main UI thread.");
    }

    public final void g()
    {
        w.b("stopLoading must be called on the main UI thread.");
        a = false;
        c.a(true);
    }

    public final void h()
    {
        w.b("recordManualImpression must be called on the main UI thread.");
        if (c.j == null)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        } else
        {
            com.google.android.gms.ads.internal.util.client.b.a(3);
            if (c.j.f != null)
            {
                com.google.android.gms.ads.internal.p.e();
                Context context = c.c;
                String s = c.e.b;
                com.google.android.gms.ads.internal.p.e();
                gm.a(context, s, gm.a(c.c, c.j.f, c.j.x));
                return;
            }
        }
    }

    public final AdSizeParcel i()
    {
        w.b("getAdSize must be called on the main UI thread.");
        return c.i;
    }

    public final boolean k()
    {
        return a;
    }

    public final void l()
    {
        n();
    }

    protected final boolean m()
    {
        com.google.android.gms.ads.internal.util.client.b.a(2);
        if (c.n == null)
        {
            return false;
        }
        try
        {
            c.n.a();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return false;
        }
        return true;
    }

    final boolean n()
    {
        com.google.android.gms.ads.internal.util.client.b.a(4);
        if (c.n == null)
        {
            return false;
        }
        try
        {
            c.n.b();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return false;
        }
        return true;
    }

    protected final boolean o()
    {
        com.google.android.gms.ads.internal.util.client.b.a(4);
        if (c.n == null)
        {
            return false;
        }
        try
        {
            c.n.d();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return false;
        }
        return true;
    }

    public void onAdClicked()
    {
        if (c.j != null) goto _L2; else goto _L1
_L1:
        com.google.android.gms.ads.internal.util.client.b.a(5);
_L4:
        return;
_L2:
        gc gc1;
        com.google.android.gms.ads.internal.util.client.b.a(3);
        gc1 = c.l;
        Object obj = gc1.c;
        obj;
        JVM INSTR monitorenter ;
        ge ge1;
        if (gc1.j == -1L)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        com.google.android.gms.d.gc.a a1 = new com.google.android.gms.d.gc.a();
        a1.a = SystemClock.elapsedRealtime();
        gc1.b.add(a1);
        gc1.h = gc1.h + 1L;
        ge1 = gc1.a.b();
        synchronized (ge1.d)
        {
            ge1.f = ge1.f + 1;
        }
        gc1.a.a(gc1);
        obj;
        JVM INSTR monitorexit ;
        if (c.j.c != null)
        {
            com.google.android.gms.ads.internal.p.e();
            obj = c.c;
            String s = c.e.b;
            com.google.android.gms.ads.internal.p.e();
            gm.a(((Context) (obj)), s, gm.a(c.c, c.j.c, c.j.x));
        }
        if (c.m == null) goto _L4; else goto _L3
_L3:
        try
        {
            c.m.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
        return;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
        Exception exception1;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    protected boolean p()
    {
        com.google.android.gms.ads.internal.util.client.b.a(4);
        a = false;
        if (c.n == null)
        {
            return false;
        }
        try
        {
            c.n.c();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return false;
        }
        return true;
    }

    protected void q()
    {
        c(c.j);
    }
}
