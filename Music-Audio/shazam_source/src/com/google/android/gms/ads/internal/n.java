// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.c;
import com.google.android.gms.ads.internal.formats.d;
import com.google.android.gms.ads.internal.formats.e;
import com.google.android.gms.ads.internal.formats.f;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.be;
import com.google.android.gms.d.bi;
import com.google.android.gms.d.bs;
import com.google.android.gms.d.bt;
import com.google.android.gms.d.bu;
import com.google.android.gms.d.bv;
import com.google.android.gms.d.dg;
import com.google.android.gms.d.dh;
import com.google.android.gms.d.dj;
import com.google.android.gms.d.dk;
import com.google.android.gms.d.em;
import com.google.android.gms.d.fb;
import com.google.android.gms.d.gb;
import com.google.android.gms.d.gm;
import com.google.android.gms.d.id;
import java.util.List;

// Referenced classes of package com.google.android.gms.ads.internal:
//            b, q, p, o

public final class n extends com.google.android.gms.ads.internal.b
{

    public n(Context context, AdSizeParcel adsizeparcel, String s, dg dg, VersionInfoParcel versioninfoparcel)
    {
        super(context, adsizeparcel, s, dg, versioninfoparcel, null);
    }

    private void a(c c1)
    {
        gm.a.post(new Runnable(c1) {

            final c a;
            final n b;

            public final void run()
            {
                try
                {
                    b.c.s.a(a);
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    com.google.android.gms.ads.internal.util.client.b.a(5);
                }
            }

            
            {
                b = n.this;
                a = c1;
                super();
            }
        });
    }

    private void a(d d1)
    {
        gm.a.post(new Runnable(d1) {

            final d a;
            final n b;

            public final void run()
            {
                try
                {
                    b.c.t.a(a);
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    com.google.android.gms.ads.internal.util.client.b.a(5);
                }
            }

            
            {
                b = n.this;
                a = d1;
                super();
            }
        });
    }

    public final bu a(String s)
    {
        w.b("getOnCustomClickListener must be called on the main UI thread.");
        return (bu)c.u.get(s);
    }

    public final void a(NativeAdOptionsParcel nativeadoptionsparcel)
    {
        w.b("setNativeAdOptions must be called on the main UI thread.");
        c.w = nativeadoptionsparcel;
    }

    public final void a(bi bi)
    {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    public final void a(bs bs)
    {
        w.b("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        c.s = bs;
    }

    public final void a(bt bt)
    {
        w.b("setOnContentAdLoadedListener must be called on the main UI thread.");
        c.t = bt;
    }

    public final void a(em em)
    {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    public final void a(com.google.android.gms.d.gb.a a1, be be)
    {
        if (a1.d != null)
        {
            c.i = a1.d;
        }
        if (a1.e != -2)
        {
            gm.a.post(new Runnable(a1) {

                final com.google.android.gms.d.gb.a a;
                final n b;

                public final void run()
                {
                    b.b(new gb(a));
                }

            
            {
                b = n.this;
                a = a1;
                super();
            }
            });
            return;
        } else
        {
            c.C = 0;
            q q1 = c;
            com.google.android.gms.ads.internal.p.d();
            q1.h = fb.a(c.c, this, a1, c.d, null, g, this, be);
            (new StringBuilder("AdRenderer: ")).append(c.h.getClass().getName());
            com.google.android.gms.ads.internal.util.client.b.a(3);
            return;
        }
    }

    public final void a(id id1)
    {
        w.b("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        c.v = id1;
    }

    public final void a(List list)
    {
        w.b("setNativeTemplates must be called on the main UI thread.");
        c.y = list;
    }

    protected final boolean a(AdRequestParcel adrequestparcel, gb gb1, boolean flag)
    {
        return b.d;
    }

    protected final boolean a(gb gb1, gb gb2)
    {
        a(((List) (null)));
        if (!c.c())
        {
            throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
        }
        if (!gb2.k) goto _L2; else goto _L1
_L1:
        Object obj2;
        Object obj3;
        obj2 = gb2.m.h();
        obj3 = gb2.m.i();
        if (obj2 == null) goto _L4; else goto _L3
_L3:
        List list;
        String s;
        obj3 = ((dj) (obj2)).a();
        list = ((dj) (obj2)).b();
        s = ((dj) (obj2)).c();
        if (((dj) (obj2)).d() == null) goto _L6; else goto _L5
_L5:
        Object obj = ((dj) (obj2)).d();
_L7:
        obj = new c(((String) (obj3)), list, s, ((com.google.android.gms.d.bk) (obj)), ((dj) (obj2)).e(), ((dj) (obj2)).f(), ((dj) (obj2)).g(), ((dj) (obj2)).h(), null, ((dj) (obj2)).l());
        ((c) (obj)).a(new f(c.c, this, c.d, ((dj) (obj2))));
        a(((c) (obj)));
_L8:
        return super.a(gb1, gb2);
_L6:
        obj = null;
          goto _L7
_L4:
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_337;
        }
        obj2 = ((dk) (obj3)).a();
        list = ((dk) (obj3)).b();
        s = ((dk) (obj3)).c();
        if (((dk) (obj3)).d() == null)
        {
            break MISSING_BLOCK_LABEL_332;
        }
        obj = ((dk) (obj3)).d();
_L9:
        obj = new d(((String) (obj2)), list, s, ((com.google.android.gms.d.bk) (obj)), ((dk) (obj3)).e(), ((dk) (obj3)).f(), null, ((dk) (obj3)).j());
        ((d) (obj)).a(new f(c.c, this, c.d, ((dk) (obj3))));
        a(((d) (obj)));
          goto _L8
        obj;
        com.google.android.gms.ads.internal.util.client.b.a(5);
          goto _L8
        obj = null;
          goto _L9
        com.google.android.gms.ads.internal.util.client.b.a(5);
        a(0);
        return false;
_L2:
        Object obj1 = gb2.w;
        if ((obj1 instanceof d) && c.t != null)
        {
            a((d)gb2.w);
        } else
        if ((obj1 instanceof c) && c.s != null)
        {
            a((c)gb2.w);
        } else
        {
label0:
            {
                if (!(obj1 instanceof e) || c.v == null || c.v.get(((e)obj1).k()) == null)
                {
                    break label0;
                }
                obj1 = ((e)obj1).k();
                gm.a.post(new Runnable(((String) (obj1)), gb2) {

                    final String a;
                    final gb b;
                    final n c;

                    public final void run()
                    {
                        try
                        {
                            ((bv)c.c.v.get(a)).a((e)b.w);
                            return;
                        }
                        catch (RemoteException remoteexception)
                        {
                            com.google.android.gms.ads.internal.util.client.b.a(5);
                        }
                    }

            
            {
                c = n.this;
                a = s;
                b = gb1;
                super();
            }
                });
            }
        }
          goto _L8
        com.google.android.gms.ads.internal.util.client.b.a(5);
        a(0);
        return false;
          goto _L7
    }

    public final void b(id id1)
    {
        w.b("setOnCustomClickListener must be called on the main UI thread.");
        c.u = id1;
    }

    public final void d()
    {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    public final void e()
    {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    public final void f()
    {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    public final void q()
    {
        a(c.j, false);
    }

    public final id x()
    {
        w.b("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return c.v;
    }
}
