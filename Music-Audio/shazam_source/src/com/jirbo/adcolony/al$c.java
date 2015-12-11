// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            al, q, ac, aq, 
//            aj, aa, x

public static final class 
{

    String a;
    int b;
    int c;
    int d;
    public boolean e;
    public boolean f;
    ArrayList g;
    toString h;
    toString i;
    toString j;
    x k;

    private static int a(int l, int i1)
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
                j1 = i1;
                if (l < i1)
                {
                    return l;
                }
            }
        }
        return j1;
    }

    private int a( )
    {
        int l = -1;
        this;
        JVM INSTR monitorenter ;
        int i1;
        int j1;
        j1 = q.c.h.a(a, 86400D);
        i1 = .o.g;
        if (i1 == 0) goto _L2; else goto _L1
_L1:
        if (q.S == 0L || (System.currentTimeMillis() - q.S) / 1000L < (long)i1) goto _L2; else goto _L3
_L3:
        c();
        q.T = 7;
        l = aj.c.c("The volatile expiration for this ad has been hit.");
_L5:
        this;
        JVM INSTR monitorexit ;
        return l;
_L2:
        i1 = .o.h;
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        l = a(-1, i1 - q.c.h.a(.d, (System.currentTimeMillis() - q.S) / 1000L));
        if (l != 0 || i1 == 0)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        c();
        q.T = 7;
        l = aj.c.c("Ad is not ready to be played due to the volatile play cap.");
        continue; /* Loop/switch isn't completed */
        int k1 = c;
        i1 = l;
        if (k1 <= 0)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        i1 = a(l, k1 - j1);
        if (i1 != 0)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        q.T = 5;
        l = aj.c.c((new StringBuilder("Ad is not ready to be played due to the daily play cap for zone ")).append(a).toString());
        continue; /* Loop/switch isn't completed */
        k1 = d;
        l = i1;
        if (k1 <= 0)
        {
            break MISSING_BLOCK_LABEL_246;
        }
        l = a(i1, k1 - q.c.h.a(a));
        if (l != 0)
        {
            break MISSING_BLOCK_LABEL_283;
        }
        q.T = 3;
        l = aj.c.c((new StringBuilder("Ad is not ready to be played due to the session play cap for zone ")).append(a).toString());
        continue; /* Loop/switch isn't completed */
        i1 = l;
        if (!j.a)
        {
            break MISSING_BLOCK_LABEL_421;
        }
        k1 = j.b.a;
        i1 = l;
        if (k1 <= 0)
        {
            break MISSING_BLOCK_LABEL_324;
        }
        i1 = a(l, k1 - j1);
        if (i1 != 0)
        {
            break MISSING_BLOCK_LABEL_344;
        }
        q.T = 4;
        l = aj.c.c("Ad is not ready to be played due to the V4VC daily play cap.");
        continue; /* Loop/switch isn't completed */
        j1 = j.b.c;
        k1 = j.b.b;
        l = i1;
        if (k1 <= 0)
        {
            break MISSING_BLOCK_LABEL_399;
        }
        l = a(i1, k1 - q.c.h.a(a, j1));
        i1 = l;
        if (l != 0)
        {
            break MISSING_BLOCK_LABEL_421;
        }
        q.T = 4;
        l = aj.c.c("Ad is not ready to be played due to the V4VC custom play cap.");
        continue; /* Loop/switch isn't completed */
        j1 = .d;
        k1 = .o.a;
        l = i1;
        if (k1 <= 0)
        {
            break MISSING_BLOCK_LABEL_465;
        }
        l = a(i1, k1 - q.c.h.a(j1, 86400D));
        if (l != 0)
        {
            break MISSING_BLOCK_LABEL_489;
        }
        q.T = 7;
        c();
        l = aj.c.c("Ad is not ready to be played due to the daily play cap.");
        continue; /* Loop/switch isn't completed */
        k1 = .o.f;
        i1 = l;
        if (k1 <= 0)
        {
            break MISSING_BLOCK_LABEL_527;
        }
        i1 = a(l, k1 - q.c.h.a(j1, 604800D));
        if (i1 != 0)
        {
            break MISSING_BLOCK_LABEL_551;
        }
        q.T = 7;
        c();
        l = aj.c.c("Ad is not ready to be played due to the weekly play cap.");
        continue; /* Loop/switch isn't completed */
        k1 = .o.e;
        l = i1;
        if (k1 <= 0)
        {
            break MISSING_BLOCK_LABEL_589;
        }
        l = a(i1, k1 - q.c.h.a(j1, 2628000D));
        if (l != 0)
        {
            break MISSING_BLOCK_LABEL_613;
        }
        q.T = 7;
        c();
        l = aj.c.c("Ad is not ready to be played due to the monthly play cap.");
        continue; /* Loop/switch isn't completed */
        k1 = .o.d;
        i1 = l;
        if (k1 <= 0)
        {
            break MISSING_BLOCK_LABEL_651;
        }
        i1 = a(l, k1 - q.c.h.a(j1, 15768000D));
        if (i1 != 0)
        {
            break MISSING_BLOCK_LABEL_675;
        }
        q.T = 7;
        c();
        l = aj.c.c("Ad is not ready to be played due to the half-year play cap.");
        continue; /* Loop/switch isn't completed */
        int l1;
        k1 = .o.c;
        l1 = .o.b;
        l = i1;
        if (l1 <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        l = a(i1, l1 - q.c.h.a(j1, k1));
        if (true) goto _L5; else goto _L4
_L4:
        ;
        throw ;
    }

    private static void c()
    {
        q.c.b.a();
    }

    final a a()
    {
        if (g.size() > 0)
        {
            a a1 = i;
            String s = (String)g.get(k.c % g.size());
            for (int l = 0; l < a1.a.size(); l++)
            {
                a a2 = ()a1.a.get(l);
                if (a2.a.equals(s))
                {
                    return a2;
                }
            }

            return null;
        } else
        {
            return null;
        }
    }

    final boolean a(boolean flag)
    {
        if (!flag)
        {
            while (!e || !f || i.a.size() == 0 || i.a().r.a) 
            {
                return false;
            }
            return true;
        }
        if (!e || !f)
        {
            q.T = 1;
            return aj.c.b((new StringBuilder("Ad is not ready, as zone ")).append(a).append(" is disabled or inactive.").toString());
        }
        if (i.a.size() == 0)
        {
            q.T = 5;
            return aj.c.b((new StringBuilder("Ad is not ready, as there are currently no ads to play in zone ")).append(a).append(".").toString());
        }
        if (i.a().r.a)
        {
            q.T = 14;
            return aj.c.b((new StringBuilder("Ad is not ready, as zone ")).append(a).append(" is V4VC enabled and must be played using an AdColonyV4VCAd object.").toString());
        } else
        {
            return true;
        }
    }

    final boolean a(boolean flag, boolean flag1)
    {
_L2:
        int l;
        int i1;
        do
        {
            return false;
        } while (!e || !f || i.a.size() == 0 || g.size() == 0);
        i1 = g.size();
        l = 0;
_L4:
        tostring = obj;
        if (l >= i1)
        {
            continue; /* Loop/switch isn't completed */
        }
        tostring = a();
        if (tostring == null) goto _L2; else goto _L1
_L1:
        if (!tostring.a())
        {
            break MISSING_BLOCK_LABEL_105;
        }
        if (tostring == null || a(tostring) == 0) goto _L2; else goto _L3
_L3:
        return true;
        b();
        l++;
          goto _L4
        Object obj = null;
        toString tostring;
        if (!flag1)
        {
            if (!flag)
            {
                q.f();
            }
            break MISSING_BLOCK_LABEL_14;
        }
        if (!e || !f)
        {
            q.T = 1;
            return aj.c.b((new StringBuilder("Ad is not ready to be played, as zone ")).append(a).append(" is disabled or inactive.").toString());
        }
        if (i.a.size() == 0 || g.size() == 0)
        {
            q.T = 5;
            return aj.c.b((new StringBuilder("Ad is not ready to be played, as AdColony currently has no videos available to be played in zone ")).append(a).append(".").toString());
        }
        i1 = g.size();
        l = 0;
_L7:
        toString tostring1;
        if (l >= i1)
        {
            break MISSING_BLOCK_LABEL_310;
        }
        tostring1 = a();
        if (tostring1 == null)
        {
            return aj.c.b("Ad is not ready to be played due to an unknown error.");
        }
        if (!tostring1.a()) goto _L6; else goto _L5
_L5:
        if (tostring1 == null)
        {
            q.T = 6;
            return aj.c.b("Ad is not ready to be played as required assets are still downloading or otherwise missing.");
        }
        continue; /* Loop/switch isn't completed */
_L6:
        b();
        l++;
          goto _L7
        if (a(tostring1) == 0) goto _L2; else goto _L8
_L8:
        return true;
        tostring1 = null;
          goto _L5
    }

    final void b()
    {
        if (g.size() > 0)
        {
            k.c = (k.c + 1) % g.size();
        }
    }

    final boolean b(boolean flag)
    {
        boolean flag1 = true;
        if (flag) goto _L2; else goto _L1
_L1:
        if (e && f) goto _L4; else goto _L3
_L3:
        flag = false;
_L6:
        return flag;
_L4:
        if (i.a.size() == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (i.a().r.a) goto _L6; else goto _L5
_L5:
        return false;
_L2:
        if (!e || !f)
        {
            q.T = 1;
            return aj.c.b((new StringBuilder("Ad is not ready, as zone ")).append(a).append(" is disabled or inactive.").toString());
        }
        if (i.a.size() == 0)
        {
            q.T = 5;
            return aj.c.b((new StringBuilder("Ad is not ready, as there are currently no ads to play in zone ")).append(a).append(".").toString());
        }
        flag = flag1;
        if (!i.a().r.a)
        {
            q.T = 15;
            return aj.c.b((new StringBuilder("Ad is not ready, as zone ")).append(a).append(" is not V4VC enabled and must be played using an AdColonyVideoAd object.").toString());
        }
        if (true) goto _L6; else goto _L7
_L7:
    }

    ()
    {
    }
}
