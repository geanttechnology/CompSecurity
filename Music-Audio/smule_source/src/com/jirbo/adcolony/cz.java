// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.jirbo.adcolony:
//            ap, da, be, dd, 
//            bl, ak, bg, bk, 
//            h, d

class cz
{

    be a;
    ArrayList b;
    HashMap c;
    HashMap d;
    boolean e;
    boolean f;

    cz(be be1)
    {
        b = new ArrayList();
        c = new HashMap();
        d = new HashMap();
        e = false;
        f = false;
        a = be1;
    }

    int a(int i)
    {
        return a(i, 86400D);
    }

    int a(int i, double d1)
    {
        this;
        JVM INSTR monitorenter ;
        double d2 = ap.b();
        int j = 0;
        int k = b.size() - 1;
_L2:
        if (k < 0)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        double d3 = ((da)b.get(k)).d;
        if (d3 >= d2 - d1)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        this;
        JVM INSTR monitorexit ;
        return j;
        int l = ((da)b.get(k)).b;
        if (i == l)
        {
            j++;
        }
        k--;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    int a(String s)
    {
        int i = 0;
        this;
        JVM INSTR monitorenter ;
        String s1;
        int j;
        s1 = a.e.j;
        j = b.size() - 1;
        boolean flag = false;
_L9:
        if (j < 0) goto _L2; else goto _L1
_L1:
        if (b.get(j) == null) goto _L2; else goto _L3
_L3:
        String s2 = ((da)b.get(j)).c;
        if (s2 != null) goto _L4; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return i;
_L4:
        if (!((da)b.get(j)).c.equals(s1)) goto _L6; else goto _L5
_L5:
        flag = true;
        boolean flag1 = ((da)b.get(j)).a.equals(s);
        if (flag1)
        {
            i++;
            flag = true;
        }
_L7:
        j--;
        continue; /* Loop/switch isn't completed */
_L6:
        if (flag) goto _L2; else goto _L7
        s;
        throw s;
        if (true) goto _L9; else goto _L8
_L8:
    }

    int a(String s, double d1)
    {
        this;
        JVM INSTR monitorenter ;
        double d2 = ap.b();
        int i = 0;
        int j = b.size() - 1;
_L2:
        if (j < 0)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        double d3 = ((da)b.get(j)).d;
        if (d3 >= d2 - d1)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        this;
        JVM INSTR monitorexit ;
        return i;
        boolean flag = s.equals(((da)b.get(j)).a);
        if (flag)
        {
            i++;
        }
        j--;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        throw s;
    }

    void a()
    {
        b();
        e = false;
    }

    void a(String s, int i)
    {
        bl.a.b("Adding play event to play history");
        e = true;
        b.add(new da(a.e.j, ap.b(), s, i));
        s = (Integer)c.get(Integer.valueOf(i));
        bl.a.a("Got play count of ").a(s).b(" for this ad");
        if (s == null)
        {
            c.put(Integer.valueOf(i), Integer.valueOf(1));
            return;
        } else
        {
            c.put(Integer.valueOf(i), Integer.valueOf(s.intValue() + 1));
            return;
        }
    }

    int b(int i)
    {
        return a(i, 604800D);
    }

    int b(String s)
    {
        return a(s, 86400D);
    }

    void b()
    {
        boolean flag = false;
        ak.i = true;
        h h1;
        if (!f || ((da)b.get(b.size() - 1)).c != a.e.j)
        {
            if ((h1 = bk.b(new bg("play_history_info.txt"))) != null)
            {
                b.clear();
                d = new HashMap();
                Object obj = h1.a("reward_credit");
                for (int i = 0; i < ((h) (obj)).n(); i++)
                {
                    String s = ((h) (obj)).a(i);
                    int i1 = ((h) (obj)).f(s);
                    d.put(s, Integer.valueOf(i1));
                }

                obj = h1.b("play_events");
                for (int j = 0; j < ((d) (obj)).a_(); j++)
                {
                    h h2 = ((d) (obj)).a(j);
                    double d1 = h2.e("timestamp");
                    String s1 = h2.d("zone_id");
                    int j1 = h2.f("ad_id");
                    if (d1 != 0.0D && s1 != null && j1 != 0)
                    {
                        b.add(new da(null, d1, s1, j1));
                    }
                }

                c = new HashMap();
                h1 = h1.a("play_counts");
                for (int k = ((flag) ? 1 : 0); k < h1.n(); k++)
                {
                    int l = Integer.parseInt(h1.a(k));
                    int k1 = h1.f((new StringBuilder()).append("").append(l).toString());
                    c.put(Integer.valueOf(l), Integer.valueOf(k1));
                }

                f = true;
                return;
            }
        }
    }

    void b(String s, int i)
    {
        d.put(s, Integer.valueOf(i));
        e = true;
    }

    int c(int i)
    {
        return a(i, 2628000D);
    }

    int c(String s)
    {
        s = (Integer)d.get(s);
        if (s == null)
        {
            return 0;
        } else
        {
            return s.intValue();
        }
    }

    void c()
    {
        Object obj = new d();
        h h1 = new h();
        h h2 = new h();
        double d1 = ap.b();
        int i = b.size() - 1;
label0:
        do
        {
            da da1;
label1:
            {
                if (i >= 0)
                {
                    da1 = (da)b.get(i);
                    if (da1.d >= d1 - 2678400D)
                    {
                        break label1;
                    }
                }
                h1.a("play_events", ((j) (obj)));
                int j;
                for (obj = c.keySet().iterator(); ((Iterator) (obj)).hasNext(); h2.b((new StringBuilder()).append("").append(i).toString(), j))
                {
                    i = ((Integer)((Iterator) (obj)).next()).intValue();
                    j = ((Integer)c.get(Integer.valueOf(i))).intValue();
                }

                break label0;
            }
            h h3 = new h();
            h3.b("zone_id", da1.a);
            h3.b("ad_id", da1.b);
            h3.b("timestamp", da1.d);
            ((d) (obj)).a(h3);
            i--;
        } while (true);
        h1.a("play_counts", h2);
        h2 = new h();
        if (d.size() > 0)
        {
            String s;
            for (Iterator iterator = d.keySet().iterator(); iterator.hasNext(); h2.b(s, ((Integer)d.get(s)).intValue()))
            {
                s = (String)iterator.next();
            }

        }
        h1.a("reward_credit", h2);
        bl.a.a("Saving play history");
        bk.a(new bg("play_history_info.txt"), h1);
    }

    int d(int i)
    {
        return a(i, 15768000D);
    }

    void d()
    {
        if (e)
        {
            e = false;
            c();
        }
    }
}
