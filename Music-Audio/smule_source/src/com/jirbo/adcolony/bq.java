// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            ak, be, cz, bo, 
//            cg, bl, bs, cs, 
//            h, br, bw, az, 
//            ay, bv, bc

class bq
{

    String a;
    int b;
    int c;
    int d;
    boolean e;
    boolean f;
    ArrayList g;
    br h;
    bw i;
    bs j;
    ay k;

    bq()
    {
    }

    int a(int l, int i1)
    {
        int j1;
        if (i1 <= 0)
        {
            j1 = 0;
        } else
        {
            j1 = i1;
            if (l != -1)
            {
                if (l >= i1)
                {
                    l = i1;
                }
                return l;
            }
        }
        return j1;
    }

    int a(bo bo1)
    {
        this;
        JVM INSTR monitorenter ;
        int j1 = ak.c.h.b(a);
        int l = -1;
        int i1 = bo1.o.g;
        if (i1 == 0) goto _L2; else goto _L1
_L1:
        if (ak.S == 0L || (System.currentTimeMillis() - ak.S) / 1000L < (long)i1) goto _L2; else goto _L3
_L3:
        c();
        ak.T = 7;
        l = bl.c.c("The volatile expiration for this ad has been hit.");
_L5:
        this;
        JVM INSTR monitorexit ;
        return l;
_L2:
        i1 = bo1.o.h;
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        l = a(-1, i1 - ak.c.h.a(bo1.d, (System.currentTimeMillis() - ak.S) / 1000L));
        if (l != 0 || i1 == 0)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        c();
        ak.T = 7;
        l = bl.c.c("Ad is not ready to be played due to the volatile play cap.");
        continue; /* Loop/switch isn't completed */
        int k1 = c;
        i1 = l;
        if (k1 <= 0)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        i1 = a(l, k1 - j1);
        if (i1 != 0)
        {
            break MISSING_BLOCK_LABEL_216;
        }
        ak.T = 5;
        l = bl.c.c((new StringBuilder()).append("Ad is not ready to be played due to the daily play cap for zone ").append(a).toString());
        continue; /* Loop/switch isn't completed */
        k1 = d;
        l = i1;
        if (k1 <= 0)
        {
            break MISSING_BLOCK_LABEL_251;
        }
        l = a(i1, k1 - ak.c.h.a(a));
        if (l != 0)
        {
            break MISSING_BLOCK_LABEL_291;
        }
        ak.T = 3;
        l = bl.c.c((new StringBuilder()).append("Ad is not ready to be played due to the session play cap for zone ").append(a).toString());
        continue; /* Loop/switch isn't completed */
        i1 = l;
        if (!j.a)
        {
            break MISSING_BLOCK_LABEL_431;
        }
        k1 = j.b.a;
        i1 = l;
        if (k1 <= 0)
        {
            break MISSING_BLOCK_LABEL_333;
        }
        i1 = a(l, k1 - j1);
        if (i1 != 0)
        {
            break MISSING_BLOCK_LABEL_353;
        }
        ak.T = 4;
        l = bl.c.c("Ad is not ready to be played due to the V4VC daily play cap.");
        continue; /* Loop/switch isn't completed */
        j1 = j.b.c;
        k1 = j.b.b;
        l = i1;
        if (k1 <= 0)
        {
            break MISSING_BLOCK_LABEL_409;
        }
        l = a(i1, k1 - ak.c.h.a(a, j1));
        i1 = l;
        if (l != 0)
        {
            break MISSING_BLOCK_LABEL_431;
        }
        ak.T = 4;
        l = bl.c.c("Ad is not ready to be played due to the V4VC custom play cap.");
        continue; /* Loop/switch isn't completed */
        j1 = bo1.d;
        k1 = bo1.o.a;
        l = i1;
        if (k1 <= 0)
        {
            break MISSING_BLOCK_LABEL_473;
        }
        l = a(i1, k1 - ak.c.h.a(j1));
        if (l != 0)
        {
            break MISSING_BLOCK_LABEL_498;
        }
        ak.T = 7;
        c();
        l = bl.c.c("Ad is not ready to be played due to the daily play cap.");
        continue; /* Loop/switch isn't completed */
        k1 = bo1.o.f;
        i1 = l;
        if (k1 <= 0)
        {
            break MISSING_BLOCK_LABEL_534;
        }
        i1 = a(l, k1 - ak.c.h.b(j1));
        if (i1 != 0)
        {
            break MISSING_BLOCK_LABEL_559;
        }
        ak.T = 7;
        c();
        l = bl.c.c("Ad is not ready to be played due to the weekly play cap.");
        continue; /* Loop/switch isn't completed */
        k1 = bo1.o.e;
        l = i1;
        if (k1 <= 0)
        {
            break MISSING_BLOCK_LABEL_595;
        }
        l = a(i1, k1 - ak.c.h.c(j1));
        if (l != 0)
        {
            break MISSING_BLOCK_LABEL_620;
        }
        ak.T = 7;
        c();
        l = bl.c.c("Ad is not ready to be played due to the monthly play cap.");
        continue; /* Loop/switch isn't completed */
        k1 = bo1.o.d;
        i1 = l;
        if (k1 <= 0)
        {
            break MISSING_BLOCK_LABEL_656;
        }
        i1 = a(l, k1 - ak.c.h.d(j1));
        if (i1 != 0)
        {
            break MISSING_BLOCK_LABEL_681;
        }
        ak.T = 7;
        c();
        l = bl.c.c("Ad is not ready to be played due to the half-year play cap.");
        continue; /* Loop/switch isn't completed */
        int l1;
        k1 = bo1.o.c;
        l1 = bo1.o.b;
        l = i1;
        if (l1 <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        l = a(i1, l1 - ak.c.h.a(j1, k1));
        if (true) goto _L5; else goto _L4
_L4:
        bo1;
        throw bo1;
    }

    boolean a()
    {
        return a(false, true);
    }

    boolean a(h h1)
    {
        if (h1 != null)
        {
            a = h1.d("uuid");
            e = h1.g("enabled");
            f = h1.g("active");
            if (!e || !f)
            {
                return true;
            }
            b = h1.f("play_interval");
            c = h1.f("daily_play_cap");
            d = h1.f("session_play_cap");
            g = new ArrayList();
            ArrayList arraylist = h1.c("play_order");
            g = arraylist;
            if (arraylist != null)
            {
                h = new br();
                if (h.a(h1.a("tracking")))
                {
                    i = new bw();
                    if (i.a(h1.b("ads")))
                    {
                        j = new bs();
                        if (j.a(h1.a("v4vc")))
                        {
                            k = ak.c.g.a(a);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    boolean a(boolean flag)
    {
        if (!flag)
        {
            ak.f();
        }
        break MISSING_BLOCK_LABEL_7;
_L2:
        int l;
        int i1;
        do
        {
            return false;
        } while (!e || !f || i.a() == 0 || g.size() == 0);
        i1 = g.size();
        l = 0;
_L5:
        bo bo1;
        if (l >= i1)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        bo1 = h();
        if (bo1 == null) goto _L2; else goto _L1
_L1:
        if (!bo1.a()) goto _L4; else goto _L3
_L3:
        if (bo1 != null && a(bo1) != 0)
        {
            return true;
        }
          goto _L2
_L4:
        j();
        l++;
          goto _L5
        bo1 = null;
          goto _L3
    }

    boolean a(boolean flag, boolean flag1)
    {
        boolean flag2 = true;
        if (flag1) goto _L2; else goto _L1
_L1:
        flag = a(flag);
_L7:
        return flag;
_L2:
        int l;
        int i1;
        if (!e || !f)
        {
            ak.T = 1;
            return bl.c.b((new StringBuilder()).append("Ad is not ready to be played, as zone ").append(a).append(" is disabled or inactive.").toString());
        }
        if (i.a() == 0 || g.size() == 0)
        {
            ak.T = 5;
            return bl.c.b((new StringBuilder()).append("Ad is not ready to be played, as AdColony currently has no videos available to be played in zone ").append(a).append(".").toString());
        }
        i1 = g.size();
        l = 0;
_L5:
        bo bo1;
        if (l >= i1)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        bo1 = h();
        if (bo1 == null)
        {
            return bl.c.b("Ad is not ready to be played due to an unknown error.");
        }
        if (!bo1.a()) goto _L4; else goto _L3
_L4:
        j();
        l++;
          goto _L5
_L3:
        if (bo1 == null)
        {
            ak.T = 6;
            return bl.c.b("Ad is not ready to be played as required assets are still downloading or otherwise missing.");
        }
        flag = flag2;
        if (a(bo1) == 0)
        {
            return false;
        }
        if (true) goto _L7; else goto _L6
_L6:
        bo1 = null;
          goto _L3
        if (true) goto _L7; else goto _L8
_L8:
    }

    boolean b()
    {
        if (b > 1)
        {
            ak.c.g.b = true;
            ay ay1 = k;
            int l = ay1.b;
            ay1.b = l + 1;
            if (l != 0)
            {
                if (k.b >= b)
                {
                    k.b = 0;
                }
                return true;
            }
        }
        return false;
    }

    boolean b(boolean flag)
    {
        boolean flag1 = true;
        if (!flag)
        {
            flag = e();
        } else
        {
            if (!e || !f)
            {
                ak.T = 1;
                return bl.c.b((new StringBuilder()).append("Ad is not ready, as zone ").append(a).append(" is disabled or inactive.").toString());
            }
            if (i.a() == 0)
            {
                ak.T = 5;
                return bl.c.b((new StringBuilder()).append("Ad is not ready, as there are currently no ads to play in zone ").append(a).append(".").toString());
            }
            flag = flag1;
            if (i.b().r.a)
            {
                ak.T = 14;
                return bl.c.b((new StringBuilder()).append("Ad is not ready, as zone ").append(a).append(" is V4VC enabled and must be played using an AdColonyV4VCAd object.").toString());
            }
        }
        return flag;
    }

    void c()
    {
        ak.c.b.e();
    }

    boolean c(boolean flag)
    {
        boolean flag1 = true;
        if (!flag)
        {
            flag = g();
        } else
        {
            if (!e || !f)
            {
                ak.T = 1;
                return bl.c.b((new StringBuilder()).append("Ad is not ready, as zone ").append(a).append(" is disabled or inactive.").toString());
            }
            if (i.a() == 0)
            {
                ak.T = 5;
                return bl.c.b((new StringBuilder()).append("Ad is not ready, as there are currently no ads to play in zone ").append(a).append(".").toString());
            }
            flag = flag1;
            if (!i.b().r.a)
            {
                ak.T = 15;
                return bl.c.b((new StringBuilder()).append("Ad is not ready, as zone ").append(a).append(" is not V4VC enabled and must be played using an AdColonyVideoAd object.").toString());
            }
        }
        return flag;
    }

    boolean d()
    {
        return b(true);
    }

    boolean e()
    {
        while (!e || !f || i.a() == 0 || i.b().r.a) 
        {
            return false;
        }
        return true;
    }

    boolean f()
    {
        return c(true);
    }

    boolean g()
    {
        while (!e || !f || i.a() == 0 || !i.b().r.a) 
        {
            return false;
        }
        return true;
    }

    bo h()
    {
        if (g.size() > 0)
        {
            return i.a((String)g.get(k.c % g.size()));
        } else
        {
            return null;
        }
    }

    bo i()
    {
        if (g.size() > 0)
        {
            return i.b(k.c % g.size());
        } else
        {
            return null;
        }
    }

    void j()
    {
        if (g.size() > 0)
        {
            k.c = (k.c + 1) % g.size();
        }
    }

    void k()
    {
        if (e && f)
        {
            int l = 0;
            while (l < i.a()) 
            {
                i.a(l).b();
                l++;
            }
        }
    }
}
