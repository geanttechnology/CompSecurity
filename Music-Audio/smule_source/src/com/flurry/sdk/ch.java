// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;
import com.flurry.android.impl.ads.protocol.v13.AdFrame;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

// Referenced classes of package com.flurry.sdk:
//            ci, cy, gk, gy, 
//            fn, av, aw, r, 
//            co, gd, hk, fz, 
//            i, aa, ah, fp, 
//            ap, x, cq, hn, 
//            af, f, b, cr, 
//            a, au, hp, fj, 
//            fy, hj, fx, hq, 
//            da, ad, cj

public class ch
{

    private static final String a = com/flurry/sdk/ch.getSimpleName();
    private final String b;
    private final ci c;
    private final TreeSet d;
    private final TreeSet e;
    private a f;
    private r g;
    private ci h;
    private x i;
    private ap j;
    private ap k;
    private int l;
    private long m;
    private long n;
    private long o;
    private long p;
    private long q;
    private final fy r = new fy() {

        final ch a;

        public void a(hj hj1)
        {
            if (a.b.equals(ch.a(a)))
            {
                fp.a().b(new hq(this) {

                    final _cls1 a;

                    public void safeRun()
                    {
                        ch.b(a.a);
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            } else
            {
                if (a.d.equals(ch.a(a)))
                {
                    fp.a().b(new hq(this) {

                        final _cls1 a;

                        public void safeRun()
                        {
                            ch.c(a.a);
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                    return;
                }
                if (a.e.equals(ch.a(a)))
                {
                    fp.a().b(new hq(this) {

                        final _cls1 a;

                        public void safeRun()
                        {
                            ch.d(a.a);
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                    return;
                }
                if (a.g.equals(ch.a(a)))
                {
                    fp.a().b(new hq(this) {

                        final _cls1 a;

                        public void safeRun()
                        {
                            ch.e(a.a);
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                    return;
                }
            }
        }

        public void notify(fx fx)
        {
            a((hj)fx);
        }

            
            {
                a = ch.this;
                super();
            }
    };
    private final fy s = new fy() {

        final ch a;

        public void a(ad ad1)
        {
            fp.a().b(new hq(this, ad1) {

                final ad a;
                final _cls4 b;

                public void safeRun()
                {
                    ch.a(b.a, a.a, a.b);
                }

            
            {
                b = _pcls4;
                a = ad1;
                super();
            }
            });
        }

        public void notify(fx fx)
        {
            a((ad)fx);
        }

            
            {
                a = ch.this;
                super();
            }
    };
    private final fy t = new fy() {

        final ch a;

        public void a(cj cj1)
        {
            if (ch.f(a) == cj1.a)
            {
                fp.a().b(new hq(this) {

                    final _cls5 a;

                    public void safeRun()
                    {
                        ch.g(a.a);
                    }

            
            {
                a = _pcls5;
                super();
            }
                });
            } else
            if (ch.h(a) == cj1.a)
            {
                fp.a().b(new hq(this, cj1) {

                    final cj a;
                    final _cls5 b;

                    public void safeRun()
                    {
                        ch.a(b.a, a.c);
                    }

            
            {
                b = _pcls5;
                a = cj1;
                super();
            }
                });
                return;
            }
        }

        public void notify(fx fx)
        {
            a((cj)fx);
        }

            
            {
                a = ch.this;
                super();
            }
    };

    public ch(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException("adSpace cannot be null");
        } else
        {
            b = s1;
            c = new ci(s1);
            d = new TreeSet();
            e = new TreeSet();
            f = a.a;
            e();
            return;
        }
    }

    static a a(ch ch1)
    {
        return ch1.f;
    }

    private void a(ap ap1, int i1, cy cy1)
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = cy1.e();
        gk gk1 = new gk();
        gk1.a(s1);
        gk1.a(20000);
        gk1.b(new gy());
        gk1.a(new gk.a(s1, cy1, i1, ap1) {

            final String a;
            final cy b;
            final int c;
            final ap d;
            final ch e;

            public volatile void a(gk gk2, Object obj)
            {
                a(gk2, (String)obj);
            }

            public void a(gk gk2, String s2)
            {
                int j1 = gk2.e();
                gd.a(3, ch.d(), (new StringBuilder()).append("VAST resolver: HTTP status code is:").append(j1).append(" for url: ").append(a).toString());
                cy cy2 = null;
                if (gk2.c())
                {
                    gd.a(3, ch.d(), (new StringBuilder()).append("VAST resolver response:").append(s2).append(" for url: ").append(a).toString());
                    cy2 = cy.a(b, da.a(s2));
                }
                if (cy2 == null)
                {
                    gd.a(3, ch.d(), (new StringBuilder()).append("VAST resolver failed for frame: ").append(c).toString());
                    d.a(c, (new cy.a()).a().b());
                } else
                {
                    gd.a(3, ch.d(), (new StringBuilder()).append("VAST resolver successful for frame: ").append(c).toString());
                    d.a(c, cy2);
                }
                fp.a().b(new hq(this) {

                    final _cls11 a;

                    public void safeRun()
                    {
                        ch.i(a.e);
                    }

            
            {
                a = _pcls11;
                super();
            }
                });
            }

            
            {
                e = ch.this;
                a = s1;
                b = cy1;
                c = i1;
                d = ap1;
                super();
            }
        });
        fn.a().a(this, gk1);
        this;
        JVM INSTR monitorexit ;
        return;
        ap1;
        throw ap1;
    }

    private void a(ap ap1, av av1)
    {
        this;
        JVM INSTR monitorenter ;
        HashMap hashmap;
        hashmap = new HashMap();
        hashmap.put("preRender", "true");
        av av2;
        av2 = av1;
        if (av1 != null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        av2 = av.a;
        hashmap.put("errorCode", Integer.toString(av2.a()));
        co.a(aw.g, hashmap, g.e(), g, ap1, 0);
        this;
        JVM INSTR monitorexit ;
        return;
        ap1;
        throw ap1;
    }

    private void a(ap ap1, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        gd.a(3, a, (new StringBuilder()).append("Pre-render: HTTP get for url: ").append(s1).toString());
        gk gk1 = new gk();
        gk1.a(s1);
        gk1.a(20000);
        gk1.b(new gy());
        gk1.a(new gk.a(s1, ap1) {

            final String a;
            final ap b;
            final ch c;

            public volatile void a(gk gk2, Object obj)
            {
                a(gk2, (String)obj);
            }

            public void a(gk gk2, String s2)
            {
                int i1 = gk2.e();
                gd.a(3, ch.d(), (new StringBuilder()).append("Prerender: HTTP status code is:").append(i1).append(" for url: ").append(a).toString());
                if (gk2.c())
                {
                    b.b(s2);
                    cq.a(ch.l(c));
                    ch.m(c);
                    return;
                } else
                {
                    ch.a(c, b, av.k);
                    ch.m(c);
                    return;
                }
            }

            
            {
                c = ch.this;
                a = s1;
                b = ap1;
                super();
            }
        });
        fn.a().a(this, gk1);
        this;
        JVM INSTR monitorexit ;
        return;
        ap1;
        throw ap1;
    }

    private void a(a a1)
    {
        this;
        JVM INSTR monitorenter ;
        a a2;
        a2 = a1;
        if (a1 != null)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        a2 = a.a;
        gd.a(3, a, (new StringBuilder()).append("Setting state from ").append(f).append(" to ").append(a2).append(" for adspace: ").append(b).toString());
        if (!a.a.equals(f) || a.a.equals(a2)) goto _L2; else goto _L1
_L1:
        gd.a(3, a, (new StringBuilder()).append("Adding fetch listeners for adspace: ").append(b).toString());
        hk.a().a(r);
        fz.a().a("com.flurry.android.sdk.AssetStatusEvent", s);
        fz.a().a("com.flurry.android.sdk.AdResponseEvent", t);
_L4:
        f = a2;
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!a.a.equals(a2) || a.a.equals(f)) goto _L4; else goto _L3
_L3:
        gd.a(3, a, (new StringBuilder()).append("Removing fetch listeners for adspace: ").append(b).toString());
        hk.a().b(r);
        fz.a().a(s);
        fz.a().a(t);
          goto _L4
        a1;
        throw a1;
    }

    static void a(ch ch1, ap ap1, av av1)
    {
        ch1.a(ap1, av1);
    }

    static void a(ch ch1, String s1, ah ah1)
    {
        ch1.a(s1, ah1);
    }

    static void a(ch ch1, List list)
    {
        ch1.a(list);
    }

    private void a(String s1, ah ah1)
    {
        this;
        JVM INSTR monitorenter ;
        if (a.e.equals(f) && com.flurry.sdk.i.a().l().a(j, s1))
        {
            gd.a(3, a, (new StringBuilder()).append("Detected asset status change for asset:").append(s1).append(" status:").append(ah1).toString());
            if (ah.d.equals(ah1) || ah.g.equals(ah1))
            {
                fp.a().b(new hq() {

                    final ch a;

                    public void safeRun()
                    {
                        ch.i(a);
                    }

            
            {
                a = ch.this;
                super();
            }
                });
            }
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    private void a(List list)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a.d.equals(f);
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        if (!list.isEmpty() && list.size() <= 1)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        n();
          goto _L1
        list;
        throw list;
        ap ap1;
label0:
        {
            ap1 = (ap)list.get(0);
            if (ap1.a().renderTime)
            {
                break label0;
            }
            n();
        }
          goto _L1
        list = ap1.a().adFrames;
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        if (!list.isEmpty() && ((AdFrame)list.get(0)).binding != 6)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        n();
          goto _L1
        Object obj;
        obj = null;
        list = obj;
        Map map;
        if (ap1.a() == null)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        map = ap1.a().clientSideRtbPayload;
        list = obj;
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        list = obj;
        if (map.containsKey("GROUP_ID"))
        {
            list = (String)map.get("GROUP_ID");
        }
        if (list != null)
        {
            break MISSING_BLOCK_LABEL_320;
        }
        list = ap1.a().adFrames;
        List list1 = k.a().adFrames;
        list1.clear();
        list1.addAll(list);
        ap1.a().adFrames = list1;
        ap1.a().groupId = k.a().groupId;
        if (ap1.a().clientSideRtbPayload != null && ap1.a().clientSideRtbPayload.isEmpty())
        {
            ap1.a().clientSideRtbPayload = k.a().clientSideRtbPayload;
        }
        j = ap1;
_L3:
        a(a.e);
        fp.a().b(new hq() {

            final ch a;

            public void safeRun()
            {
                ch.i(a);
            }

            
            {
                a = ch.this;
                super();
            }
        });
          goto _L1
        j = ap1;
          goto _L3
    }

    static void b(ch ch1)
    {
        ch1.g();
    }

    static void c(ch ch1)
    {
        ch1.h();
    }

    static String d()
    {
        return a;
    }

    static void d(ch ch1)
    {
        ch1.i();
    }

    private void e()
    {
        this;
        JVM INSTR monitorenter ;
        gd.a(3, a, (new StringBuilder()).append("Fetch finished for adObject:").append(g).append(" adSpace:").append(b).toString());
        c.b();
        fn.a().a(this);
        a(a.a);
        if (i != null)
        {
            i.a(e);
        }
        e.clear();
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = 0;
        m = 0L;
        n = 0L;
        o = 0L;
        p = 0L;
        q = 0L;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static void e(ch ch1)
    {
        ch1.j();
    }

    static ci f(ch ch1)
    {
        return ch1.h;
    }

    private void f()
    {
        this;
        JVM INSTR monitorenter ;
        if (a.b.equals(f))
        {
            d.addAll(i.c());
            if (!d.isEmpty())
            {
                j = (ap)d.pollFirst();
            }
            a(a.e);
            fp.a().b(new hq() {

                final ch a;

                public void safeRun()
                {
                    ch.i(a);
                }

            
            {
                a = ch.this;
                super();
            }
            });
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void g()
    {
        this;
        JVM INSTR monitorenter ;
        if (m > 0L && System.currentTimeMillis() > m)
        {
            cq.a(g, av.v);
            e();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static void g(ch ch1)
    {
        ch1.f();
    }

    static ci h(ch ch1)
    {
        return ch1.c;
    }

    private void h()
    {
        this;
        JVM INSTR monitorenter ;
        if (n > 0L && System.currentTimeMillis() > n)
        {
            n();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void i()
    {
        this;
        JVM INSTR monitorenter ;
        if (p <= 0L || System.currentTimeMillis() <= p) goto _L2; else goto _L1
_L1:
        a(j, av.m);
        e();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (o > 0L && System.currentTimeMillis() > o)
        {
            m();
            l();
        }
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static void i(ch ch1)
    {
        ch1.l();
    }

    private void j()
    {
        this;
        JVM INSTR monitorenter ;
        if (q > 0L && System.currentTimeMillis() > q)
        {
            fn.a().a(this);
            a(j, av.o);
            e();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static void j(ch ch1)
    {
        ch1.o();
    }

    private void k()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a.c.equals(f);
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (j != null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        gd.a(6, a, "An auction is required, but there is no ad unit!");
        cq.a(g, av.d);
        e();
          goto _L1
        Exception exception;
        exception;
        throw exception;
        long l1;
        a(a.d);
        l1 = j.a().preRenderTimeoutMillis;
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        gd.a(3, a, (new StringBuilder()).append("Setting CSRTB auction timeout for ").append(l1).append(" ms").toString());
        n = l1 + System.currentTimeMillis();
        k = j;
        c.a(g, null, j);
          goto _L1
    }

    static void k(ch ch1)
    {
        ch1.p();
    }

    static r l(ch ch1)
    {
        return ch1.g;
    }

    private void l()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a.e.equals(f);
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (g.e() != null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        cq.a(g, av.e);
        e();
          goto _L1
        Exception exception;
        exception;
        throw exception;
label0:
        {
            if (!hn.a())
            {
                break label0;
            }
            cq.a(g, av.x);
            e();
        }
          goto _L1
        aa aa1 = com.flurry.sdk.i.a().l();
_L19:
        if (j == null) goto _L4; else goto _L3
_L3:
        Object obj = j.a().adFrames;
        if (obj == null) goto _L6; else goto _L5
_L5:
        if (!((List) (obj)).isEmpty()) goto _L7; else goto _L6
_L6:
        a(j, av.f);
        e();
          goto _L1
_L21:
        int i1;
        if (i1 >= ((List) (obj)).size()) goto _L9; else goto _L8
_L8:
        if (((AdFrame)((List) (obj)).get(i1)).binding != 6)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        j.a().renderTime = true;
        a(a.c);
        k();
          goto _L1
        cy cy1 = j.d(i1);
        if (cy1 == null)
        {
            break MISSING_BLOCK_LABEL_779;
        }
        if (cy1.c())
        {
            break MISSING_BLOCK_LABEL_779;
        }
        if (!cy1.d()) goto _L10; else goto _L9
_L9:
        p = 0L;
        if (!j.o()) goto _L12; else goto _L11
_L11:
        long l1;
        obj = aa1.a(j);
        l1 = j.a().preCacheAdSkippableTimeLimitMillis;
        gd.a(3, a, (new StringBuilder()).append("Pre-caching required for ad, AdUnitCachedStatus: ").append(obj).append(", skip time limit: ").append(l1).toString());
        if (af.d.equals(obj) || l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_366;
        }
        if (o == 0L)
        {
            gd.a(3, a, (new StringBuilder()).append("Setting skip timer for ").append(l1).append(" ms").toString());
            o = System.currentTimeMillis() + l1;
        }
        if (!af.d.equals(obj)) goto _L14; else goto _L13
_L13:
        gd.a(3, a, "Pre-caching completed, ad may proceed");
_L4:
        if (j != null) goto _L16; else goto _L15
_L15:
        com.flurry.sdk.i.a().a(null, aw.e, true, Collections.emptyMap());
        cq.a(g, av.v);
        e();
          goto _L1
_L10:
        l1 = j.a().preRenderTimeoutMillis;
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_496;
        }
        if (p == 0L)
        {
            gd.a(3, a, (new StringBuilder()).append("Setting VAST resolve timeout for ").append(l1).append(" ms").toString());
            p = l1 + System.currentTimeMillis();
        }
        a(j, i1, cy1);
          goto _L1
_L14:
        if (!af.b.equals(obj))
        {
            break MISSING_BLOCK_LABEL_592;
        }
        if (l1 != 0L) goto _L18; else goto _L17
_L17:
        gd.a(3, a, "No skip timer");
        m();
          goto _L19
_L18:
        if (l1 <= 0L) goto _L19; else goto _L20
_L20:
label1:
        {
            if (System.currentTimeMillis() <= o)
            {
                break label1;
            }
            gd.a(3, a, "Skip timer expired");
            m();
        }
          goto _L19
        gd.a(3, a, "Waiting for skip timer");
          goto _L1
        if (l1 != 0L)
        {
            break MISSING_BLOCK_LABEL_616;
        }
        gd.a(3, a, "No skip timer");
        m();
          goto _L19
        i1 = l + 1;
        l = i1;
        if (i1 <= 1)
        {
            break MISSING_BLOCK_LABEL_664;
        }
        gd.a(3, a, "Too many precaching attempts, precaching failed");
        a(j, av.h);
        e();
          goto _L1
        i1 = aa1.b(j);
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_723;
        }
        gd.a(3, a, (new StringBuilder()).append("Requesting ").append(i1).append(" asset(s), attempt #").append(l).toString());
          goto _L1
        gd.a(3, a, "No assets to cache");
          goto _L4
_L12:
        gd.a(3, a, "Pre-caching not required for ad");
          goto _L4
_L16:
        a(a.f);
        fp.a().a(new hq() {

            final ch a;

            public void safeRun()
            {
                ch.j(a);
            }

            
            {
                a = ch.this;
                super();
            }
        });
          goto _L1
_L7:
        i1 = 0;
          goto _L21
        i1++;
          goto _L21
    }

    private void m()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a.e.equals(f);
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        String s1 = j.a().groupId;
        gd.a(3, a, (new StringBuilder()).append("Precaching required for incomplete ad unit, skipping ad group -- adspace: ").append(b).append(" groupId: ").append(s1).toString());
        e.add(j);
        j = null;
        e.addAll(d);
        d.clear();
        d.addAll(i.c());
        if (!d.isEmpty())
        {
            j = (ap)d.pollFirst();
        }
        com.flurry.sdk.f.a().a("precachingAdGroupSkipped", 1);
        l = 0;
        o = 0L;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static void m(ch ch1)
    {
        ch1.e();
    }

    private void n()
    {
        this;
        JVM INSTR monitorenter ;
        if (a.c.equals(f)) goto _L2; else goto _L1
_L1:
        boolean flag1 = a.d.equals(f);
        if (flag1) goto _L2; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Iterator iterator = cr.a((AdFrame)j.a().adFrames.get(0), new b(aw.e, null, null, null, null)).iterator();
        com.flurry.sdk.a a1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_166;
            }
            a1 = (com.flurry.sdk.a)iterator.next();
        } while (!au.f.equals(a1.a()));
        boolean flag = false;
_L4:
        co.a(aw.e, Collections.emptyMap(), g.e(), g, j, 0);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        a(j, av.n);
        e();
          goto _L3
        Exception exception;
        exception;
        throw exception;
        flag = true;
          goto _L4
    }

    private void o()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        hp.a();
        flag = a.f.equals(f);
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        gd.a(3, a, "Preparing ad");
        if (g.e() != null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        a(j, av.e);
        e();
          goto _L1
        Exception exception;
        exception;
        throw exception;
        co.a(aw.d, Collections.emptyMap(), g.e(), g, j, 1);
        g.a(j);
        a(a.g);
        fp.a().b(new hq() {

            final ch a;

            public void safeRun()
            {
                ch.k(a);
            }

            
            {
                a = ch.this;
                super();
            }
        });
          goto _L1
    }

    private void p()
    {
        int i1 = 0;
        this;
        JVM INSTR monitorenter ;
        boolean flag = a.g.equals(f);
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj;
        gd.a(3, a, "Pre-rendering ad");
        obj = j.a().adFrames;
_L3:
        cy cy1;
        if (i1 >= ((List) (obj)).size())
        {
            break MISSING_BLOCK_LABEL_112;
        }
        cy1 = j.d(i1);
        if (cy1 == null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        if (cy1.c() && !cy1.d())
        {
            break MISSING_BLOCK_LABEL_105;
        }
        a(j, av.g);
        e();
          goto _L1
        obj;
        throw obj;
        i1++;
          goto _L3
label0:
        {
            Object obj1 = com.flurry.sdk.i.a().l();
            if (!j.o())
            {
                break MISSING_BLOCK_LABEL_264;
            }
            gd.a(3, a, "Precaching required for ad, copying assets");
            obj1 = ((aa) (obj1)).a(j);
            if (!af.d.equals(obj1))
            {
                break label0;
            }
            com.flurry.sdk.f.a().a("precachingAdAssetsAvailable", 1);
            if (com.flurry.sdk.i.a().l().a(g, j))
            {
                break MISSING_BLOCK_LABEL_302;
            }
            gd.a(3, a, "Could not copy required ad assets");
            com.flurry.sdk.f.a().a("precachingAdAssetCopyFailed", 1);
            a(j, av.i);
            e();
        }
          goto _L1
        gd.a(3, a, "Ad assets incomplete");
        com.flurry.sdk.f.a().a("precachingAdAssetsIncomplete", 1);
        a(j, av.j);
        e();
          goto _L1
        if (j.n())
        {
            gd.a(3, a, "Precaching optional for ad, copying assets");
            com.flurry.sdk.i.a().l().a(g, j);
        }
        long l1;
        co.a(aw.K, Collections.emptyMap(), g.e(), g, j, 0);
        obj = (AdFrame)((List) (obj)).get(0);
        if (((AdFrame) (obj)).binding != 1)
        {
            break MISSING_BLOCK_LABEL_436;
        }
        gd.a(3, a, "Binding is HTML_URL, pre-render required");
        l1 = j.a().preRenderTimeoutMillis;
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_421;
        }
        gd.a(3, a, (new StringBuilder()).append("Setting pre-render timeout for ").append(l1).append(" ms").toString());
        q = l1 + System.currentTimeMillis();
        a(j, ((AdFrame) (obj)).display);
          goto _L1
        cq.a(g);
        e();
          goto _L1
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        e();
        c.a();
        d.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(r r1, ci ci1, x x1)
    {
        this;
        JVM INSTR monitorenter ;
        if (r1 != null && ci1 != null && x1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        gd.a(3, a, (new StringBuilder()).append("fetchAd: adObject=").append(r1).toString());
        if (a.a.equals(f))
        {
            g = r1;
            i = x1;
            h = ci1;
            if (fj.a().c())
            {
                break MISSING_BLOCK_LABEL_113;
            }
            gd.a(5, a, "There is no network connectivity (ad will not fetch)");
            cq.a(g, av.c);
            e();
        }
          goto _L1
        r1;
        throw r1;
        com.flurry.sdk.i.a().l().g();
        if (d.isEmpty())
        {
            d.addAll(i.c());
        }
        if (!d.isEmpty())
        {
            break MISSING_BLOCK_LABEL_237;
        }
        a(a.b);
        if (15000L <= 0L)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        gd.a(3, a, (new StringBuilder()).append("Setting ad request timeout for ").append(15000L).append(" ms").toString());
        m = 15000L + System.currentTimeMillis();
        h.a(g, i, null);
          goto _L1
        j = (ap)d.pollFirst();
        a(a.e);
        fp.a().b(new hq() {

            final ch a;

            public void safeRun()
            {
                ch.i(a);
            }

            
            {
                a = ch.this;
                super();
            }
        });
          goto _L1
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        d.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        if (h != null)
        {
            h.b();
        }
        e();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }


    private class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        private static final a h[];

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/flurry/sdk/ch$a, s1);
        }

        public static a[] values()
        {
            return (a[])h.clone();
        }

        static 
        {
            a = new a("NONE", 0);
            b = new a("REQUEST", 1);
            c = new a("CSRTB_AUCTION_REQUIRED", 2);
            d = new a("CSRTB_AWAIT_AUCTION", 3);
            e = new a("SELECT", 4);
            f = new a("PREPARE", 5);
            g = new a("PRERENDER", 6);
            h = (new a[] {
                a, b, c, d, e, f, g
            });
        }

        private a(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
