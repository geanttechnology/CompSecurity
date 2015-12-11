// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.m;
import com.google.android.gms.ads.internal.client.w;
import com.google.android.gms.ads.internal.overlay.g;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.purchase.c;
import com.google.android.gms.ads.internal.purchase.d;
import com.google.android.gms.ads.internal.purchase.f;
import com.google.android.gms.ads.internal.purchase.i;
import com.google.android.gms.ads.internal.purchase.j;
import com.google.android.gms.ads.internal.purchase.k;
import com.google.android.gms.ads.internal.request.CapabilityParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.d.ay;
import com.google.android.gms.d.be;
import com.google.android.gms.d.cg;
import com.google.android.gms.d.cx;
import com.google.android.gms.d.cz;
import com.google.android.gms.d.da;
import com.google.android.gms.d.db;
import com.google.android.gms.d.de;
import com.google.android.gms.d.dg;
import com.google.android.gms.d.dh;
import com.google.android.gms.d.ej;
import com.google.android.gms.d.em;
import com.google.android.gms.d.eq;
import com.google.android.gms.d.gb;
import com.google.android.gms.d.gc;
import com.google.android.gms.d.gd;
import com.google.android.gms.d.ge;
import com.google.android.gms.d.gg;
import com.google.android.gms.d.gi;
import com.google.android.gms.d.gl;
import com.google.android.gms.d.gm;
import com.google.android.gms.d.gn;
import com.google.android.gms.d.he;
import com.google.android.gms.d.id;
import com.google.android.gms.d.x;
import com.google.android.gms.d.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.WeakHashMap;

// Referenced classes of package com.google.android.gms.ads.internal:
//            a, q, p, m, 
//            o, d

public abstract class b extends com.google.android.gms.ads.internal.a
    implements g, j, cg, da
{

    protected final dg g;
    protected transient boolean h;
    private final Messenger i;

    public b(Context context, AdSizeParcel adsizeparcel, String s1, dg dg, VersionInfoParcel versioninfoparcel, com.google.android.gms.ads.internal.d d1)
    {
        this(new q(context, adsizeparcel, s1, versioninfoparcel), dg, d1);
    }

    private b(q q1, dg dg, com.google.android.gms.ads.internal.d d1)
    {
        super(q1, d1);
        g = dg;
        i = new Messenger(new ej(c.c));
        h = false;
    }

    private com.google.android.gms.ads.internal.request.AdRequestInfoParcel.a a(AdRequestParcel adrequestparcel, Bundle bundle)
    {
        Object obj;
        Object obj1;
        String s1;
        ApplicationInfo applicationinfo;
        DisplayMetrics displaymetrics;
        Object obj2;
        Object obj3;
        Object obj4;
        long l2;
        applicationinfo = c.c.getApplicationInfo();
        int i1;
        try
        {
            obj = c.c.getPackageManager().getPackageInfo(applicationinfo.packageName, 0);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
        }
        displaymetrics = c.c.getResources().getDisplayMetrics();
        s1 = null;
        obj1 = s1;
        if (c.f != null)
        {
            obj1 = s1;
            if (c.f.getParent() != null)
            {
                obj1 = new int[2];
                c.f.getLocationOnScreen(((int []) (obj1)));
                int k1 = obj1[0];
                int l1 = obj1[1];
                int i2 = c.f.getWidth();
                int j2 = c.f.getHeight();
                boolean flag = false;
                int l = ((flag) ? 1 : 0);
                if (c.f.isShown())
                {
                    l = ((flag) ? 1 : 0);
                    if (k1 + i2 > 0)
                    {
                        l = ((flag) ? 1 : 0);
                        if (l1 + j2 > 0)
                        {
                            l = ((flag) ? 1 : 0);
                            if (k1 <= displaymetrics.widthPixels)
                            {
                                l = ((flag) ? 1 : 0);
                                if (l1 <= displaymetrics.heightPixels)
                                {
                                    l = 1;
                                }
                            }
                        }
                    }
                }
                obj1 = new Bundle(5);
                ((Bundle) (obj1)).putInt("x", k1);
                ((Bundle) (obj1)).putInt("y", l1);
                ((Bundle) (obj1)).putInt("width", i2);
                ((Bundle) (obj1)).putInt("height", j2);
                ((Bundle) (obj1)).putInt("visible", l);
            }
        }
        s1 = p.h().a();
        c.l = new gc(s1, c.b);
        obj4 = c.l;
        obj2 = ((gc) (obj4)).c;
        obj2;
        JVM INSTR monitorenter ;
        obj4.i = SystemClock.elapsedRealtime();
        obj3 = ((gc) (obj4)).a.b();
        l2 = ((gc) (obj4)).i;
        obj4 = ((ge) (obj3)).d;
        obj4;
        JVM INSTR monitorenter ;
        if (((ge) (obj3)).b != -1L) goto _L2; else goto _L1
_L1:
        obj3.b = l2;
        obj3.a = ((ge) (obj3)).b;
_L6:
        if (adrequestparcel.c == null || adrequestparcel.c.getInt("gw", 2) != 1) goto _L4; else goto _L3
_L3:
        obj2;
        JVM INSTR monitorexit ;
          goto _L5
_L2:
        obj3.a = l2;
          goto _L6
        adrequestparcel;
        obj4;
        JVM INSTR monitorexit ;
        throw adrequestparcel;
        adrequestparcel;
        obj2;
        JVM INSTR monitorexit ;
        throw adrequestparcel;
_L4:
        obj3.c = ((ge) (obj3)).c + 1;
        obj4;
        JVM INSTR monitorexit ;
          goto _L3
_L5:
        p.e();
        obj2 = gm.a(c.c, c.f, c.i);
        int j1 = com.google.android.gms.ads.internal.m.a(c.c).c();
        boolean flag3 = com.google.android.gms.ads.internal.m.a(c.c).a();
        long l3 = 0L;
        l2 = l3;
        ArrayList arraylist;
        if (c.p != null)
        {
            try
            {
                l2 = c.p.a();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj3)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                l2 = l3;
            }
        }
        obj3 = UUID.randomUUID().toString();
        obj4 = p.h().a(c.c, this, s1);
        arraylist = new ArrayList();
        for (i1 = 0; i1 < c.v.size(); i1++)
        {
            arraylist.add(c.v.b(i1));
        }

        boolean flag1;
        boolean flag2;
        if (c.q != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (c.r != null && p.h().i())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        return new com.google.android.gms.ads.internal.request.AdRequestInfoParcel.a(((Bundle) (obj1)), adrequestparcel, c.i, c.b, applicationinfo, ((PackageInfo) (obj)), s1, p.h().b, c.e, ((Bundle) (obj4)), c.y, arraylist, bundle, p.h().e(), i, displaymetrics.widthPixels, displaymetrics.heightPixels, displaymetrics.density, ((String) (obj2)), flag3, j1, l2, ((String) (obj3)), ay.a(), c.a, c.w, new CapabilityParcel(flag1, flag2));
          goto _L6
    }

    public void a(em em1)
    {
        com.google.android.gms.common.internal.w.b("setInAppPurchaseListener must be called on the main UI thread.");
        c.q = em1;
    }

    public final void a(eq eq1, String s1)
    {
        com.google.android.gms.common.internal.w.b("setPlayStorePurchaseParams must be called on the main UI thread.");
        c.z = new k(s1);
        c.r = eq1;
        if (!p.h().d() && eq1 != null)
        {
            gl.a(((gi) (new c(c.c, c.r, c.z))).i);
        }
    }

    protected final void a(gb gb1, boolean flag)
    {
        if (gb1 == null)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        } else
        {
            super.c(gb1);
            if (gb1.o != null && gb1.o.d != null)
            {
                p.q();
                Context context = c.c;
                String s1 = c.e.b;
                String s3 = c.b;
                p.e();
                de.a(context, s1, gb1, s3, flag, gm.a(c.c, gb1.o.d, gb1.x));
            }
            if (gb1.l != null && gb1.l.g != null)
            {
                p.q();
                Context context1 = c.c;
                String s2 = c.e.b;
                String s4 = c.b;
                p.e();
                de.a(context1, s2, gb1, s4, flag, gm.a(c.c, gb1.l.g, gb1.x));
                return;
            }
        }
    }

    public final void a(String s1, ArrayList arraylist)
    {
        arraylist = new d(s1, arraylist, c.c, c.e.b);
        if (c.q == null)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            m.a();
            if (!com.google.android.gms.ads.internal.util.client.a.b(c.c))
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                return;
            }
            if (c.r == null)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                return;
            }
            if (c.z == null)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                return;
            }
            if (c.D)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                return;
            }
            c.D = true;
            try
            {
                if (!c.r.a(s1))
                {
                    c.D = false;
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                c.D = false;
                return;
            }
            p.o();
            s1 = c.c;
            boolean flag = c.e.e;
            arraylist = new GInAppPurchaseManagerInfoParcel(c.c, c.z, arraylist, this);
            Intent intent = new Intent();
            intent.setClassName(s1, "com.google.android.gms.ads.purchase.InAppPurchaseActivity");
            intent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", flag);
            GInAppPurchaseManagerInfoParcel.a(intent, arraylist);
            s1.startActivity(intent);
            return;
        }
        try
        {
            c.q.a(arraylist);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final void a(String s1, boolean flag, int l, Intent intent, f f1)
    {
        try
        {
            if (c.r != null)
            {
                c.r.a(new com.google.android.gms.ads.internal.purchase.g(c.c, s1, flag, l, intent, f1));
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
        gm.a.postDelayed(new Runnable(intent) {

            final Intent a;
            final b b;

            public final void run()
            {
                p.o();
                int i1 = com.google.android.gms.ads.internal.purchase.i.a(a);
                p.o();
                if (i1 == 0 && b.c.j != null && b.c.j.b != null && b.c.j.b.f() != null)
                {
                    b.c.j.b.f().a();
                }
                b.c.D = false;
            }

            
            {
                b = b.this;
                a = intent;
                super();
            }
        }, 500L);
    }

    public boolean a(AdRequestParcel adrequestparcel, be be1)
    {
        if (!r())
        {
            return false;
        }
        Object obj = a(p.h().a(c.c));
        b.a();
        c.C = 0;
        adrequestparcel = a(adrequestparcel, ((Bundle) (obj)));
        be1.a("seq_num", ((com.google.android.gms.ads.internal.request.AdRequestInfoParcel.a) (adrequestparcel)).g);
        if (((com.google.android.gms.ads.internal.request.AdRequestInfoParcel.a) (adrequestparcel)).x != null)
        {
            be1.a("request_id", ((com.google.android.gms.ads.internal.request.AdRequestInfoParcel.a) (adrequestparcel)).x);
        }
        if (((com.google.android.gms.ads.internal.request.AdRequestInfoParcel.a) (adrequestparcel)).f != null)
        {
            be1.a("app_version", String.valueOf(((com.google.android.gms.ads.internal.request.AdRequestInfoParcel.a) (adrequestparcel)).f.versionCode));
        }
        be1 = c;
        com.google.android.gms.ads.internal.p.a();
        obj = c.c;
        com.google.android.gms.d.o o1 = c.d;
        if (((com.google.android.gms.ads.internal.request.AdRequestInfoParcel.a) (adrequestparcel)).b.c.getBundle("sdk_less_server_data") != null)
        {
            adrequestparcel = new com.google.android.gms.ads.internal.request.m(((Context) (obj)), adrequestparcel, this);
        } else
        {
            adrequestparcel = new com.google.android.gms.ads.internal.request.b(((Context) (obj)), adrequestparcel, o1, this);
        }
        adrequestparcel.e();
        be1.g = adrequestparcel;
        return true;
    }

    protected boolean a(AdRequestParcel adrequestparcel, gb gb1, boolean flag)
    {
        if (flag || !c.c()) goto _L2; else goto _L1
_L1:
        if (gb1.h <= 0L) goto _L4; else goto _L3
_L3:
        b.a(adrequestparcel, gb1.h);
_L2:
        return b.d;
_L4:
        if (gb1.o != null && gb1.o.g > 0L)
        {
            b.a(adrequestparcel, gb1.o.g);
        } else
        if (!gb1.k && gb1.d == 2)
        {
            b.a(adrequestparcel);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    final boolean a(gb gb1)
    {
        boolean flag = false;
        if (d == null) goto _L2; else goto _L1
_L1:
        AdRequestParcel adrequestparcel;
        adrequestparcel = d;
        d = null;
_L4:
        return a(adrequestparcel, gb1, flag);
_L2:
        AdRequestParcel adrequestparcel1 = gb1.a;
        adrequestparcel = adrequestparcel1;
        if (adrequestparcel1.c != null)
        {
            flag = adrequestparcel1.c.getBoolean("_noRefresh", false);
            adrequestparcel = adrequestparcel1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected boolean a(gb gb1, gb gb2)
    {
        int l = 0;
        if (gb1 != null && gb1.p != null)
        {
            gb1.p.a(null);
        }
        if (gb2.p != null)
        {
            gb2.p.a(this);
        }
        gg gg1;
        gd gd1;
        String s1;
        int i1;
        if (gb2.o != null)
        {
            i1 = gb2.o.j;
            l = gb2.o.k;
        } else
        {
            i1 = 0;
        }
        gg1 = c.A;
        gb1 = ((gb) (gg1.a));
        gb1;
        JVM INSTR monitorenter ;
        gg1.b = i1;
        gg1.c = l;
        gd1 = gg1.d;
        s1 = gg1.e;
        synchronized (gd1.a)
        {
            gd1.e.put(s1, gg1);
        }
        gb1;
        JVM INSTR monitorexit ;
        return true;
        exception;
        gb2;
        JVM INSTR monitorexit ;
        throw exception;
        gb2;
        gb1;
        JVM INSTR monitorexit ;
        throw gb2;
    }

    public void a_()
    {
        e.a(c.j);
        h = false;
        m();
        gc gc1 = c.l;
        synchronized (gc1.c)
        {
            if (gc1.j != -1L && !gc1.b.isEmpty())
            {
                com.google.android.gms.d.gc.a a1 = (com.google.android.gms.d.gc.a)gc1.b.getLast();
                if (a1.b == -1L)
                {
                    a1.b = SystemClock.elapsedRealtime();
                    gc1.a.a(gc1);
                }
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void b(gb gb1)
    {
        super.b(gb1);
        if (gb1.d == 3 && gb1.o != null && gb1.o.e != null)
        {
            com.google.android.gms.ads.internal.util.client.b.a(3);
            p.q();
            de.a(c.c, c.e.b, gb1, c.b, false, gb1.o.e);
        }
    }

    protected final boolean b(AdRequestParcel adrequestparcel)
    {
        return super.b(adrequestparcel) && !h;
    }

    public void b_()
    {
        h = true;
        o();
    }

    public void d()
    {
        Object obj;
        com.google.android.gms.common.internal.w.b("pause must be called on the main UI thread.");
        if (c.j != null && c.j.b != null && c.c())
        {
            com.google.android.gms.ads.internal.p.g().a(c.j.b.getWebView());
        }
        Object obj1;
        gb gb1;
        if (c.j != null && c.j.m != null)
        {
            try
            {
                c.j.m.d();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
            }
        }
        obj1 = e;
        gb1 = c.j;
        obj = ((x) (obj1)).a;
        obj;
        JVM INSTR monitorenter ;
        obj1 = (y)((x) (obj1)).b.get(gb1);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        ((y) (obj1)).f();
        obj;
        JVM INSTR monitorexit ;
        obj = b;
        obj.e = true;
        if (((o) (obj)).d)
        {
            ((o) (obj)).a.a(((o) (obj)).b);
        }
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void e()
    {
        Object obj;
        com.google.android.gms.common.internal.w.b("resume must be called on the main UI thread.");
        if (c.j != null && c.j.b != null && c.c())
        {
            com.google.android.gms.ads.internal.p.g().b(c.j.b.getWebView());
        }
        Object obj1;
        gb gb1;
        if (c.j != null && c.j.m != null)
        {
            try
            {
                c.j.m.e();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
            }
        }
        obj = b;
        obj.e = false;
        if (((o) (obj)).d)
        {
            obj.d = false;
            ((o) (obj)).a(((o) (obj)).c, ((o) (obj)).f);
        }
        obj1 = e;
        gb1 = c.j;
        obj = ((x) (obj1)).a;
        obj;
        JVM INSTR monitorenter ;
        obj1 = (y)((x) (obj1)).b.get(gb1);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        ((y) (obj1)).g();
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void f()
    {
        throw new IllegalStateException("showInterstitial is not supported for current ad type");
    }

    public final String j()
    {
        if (c.j == null)
        {
            return null;
        } else
        {
            return c.j.n;
        }
    }

    public void onAdClicked()
    {
        if (c.j == null)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return;
        }
        if (c.j.o != null && c.j.o.c != null)
        {
            p.q();
            Context context = c.c;
            String s1 = c.e.b;
            gb gb1 = c.j;
            String s3 = c.b;
            p.e();
            de.a(context, s1, gb1, s3, false, gm.a(c.c, c.j.o.c, c.j.x));
        }
        if (c.j.l != null && c.j.l.f != null)
        {
            p.q();
            Context context1 = c.c;
            String s2 = c.e.b;
            gb gb2 = c.j;
            String s4 = c.b;
            p.e();
            de.a(context1, s2, gb2, s4, false, gm.a(c.c, c.j.l.f, c.j.x));
        }
        super.onAdClicked();
    }

    protected boolean r()
    {
        boolean flag;
label0:
        {
            flag = true;
            p.e();
            if (gm.a(c.c.getPackageManager(), c.c.getPackageName(), "android.permission.INTERNET"))
            {
                p.e();
                if (gm.a(c.c))
                {
                    break label0;
                }
            }
            flag = false;
        }
        return flag;
    }

    public final void s()
    {
        onAdClicked();
    }

    public final void t()
    {
        a_();
    }

    public final void u()
    {
        super.n();
    }

    public final void v()
    {
        b_();
    }

    public final void w()
    {
        if (c.j != null)
        {
            (new StringBuilder("Mediation adapter ")).append(c.j.n).append(" refreshed, but mediation adapters should never refresh.");
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
        a(c.j, true);
        p();
    }
}
