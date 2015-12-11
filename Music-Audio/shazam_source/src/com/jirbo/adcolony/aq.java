// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.jirbo.adcolony:
//            s, ac, as, q, 
//            ae, ai, aj

final class aq
{
    static final class a
    {

        String a;
        int b;
        String c;
        double d;

        a(String s1, double d1, String s2, int i)
        {
            c = s1;
            d = d1;
            a = s2;
            b = i;
        }
    }


    ac a;
    ArrayList b;
    HashMap c;
    HashMap d;
    boolean e;
    boolean f;

    aq(ac ac1)
    {
        b = new ArrayList();
        c = new HashMap();
        d = new HashMap();
        e = false;
        f = false;
        a = ac1;
    }

    final int a(int i, double d1)
    {
        this;
        JVM INSTR monitorenter ;
        double d2 = s.b();
        int j = 0;
        int k = b.size() - 1;
_L3:
        if (k < 0) goto _L2; else goto _L1
_L1:
        int l;
        if (((a)b.get(k)).d < d2 - d1)
        {
            break; /* Loop/switch isn't completed */
        }
        l = ((a)b.get(k)).b;
        if (i == l)
        {
            j++;
        }
        k--;
          goto _L3
_L2:
        this;
        JVM INSTR monitorexit ;
        return j;
        Exception exception;
        exception;
        throw exception;
    }

    final int a(String s1)
    {
        int i = 0;
        this;
        JVM INSTR monitorenter ;
        String s2;
        int j;
        s2 = a.e.j;
        j = b.size() - 1;
        boolean flag = false;
_L6:
        if (j < 0) goto _L2; else goto _L1
_L1:
        if (b.get(j) == null || ((a)b.get(j)).c == null) goto _L2; else goto _L3
_L3:
        if (!((a)b.get(j)).c.equals(s2)) goto _L5; else goto _L4
_L4:
        flag = true;
        boolean flag1 = ((a)b.get(j)).a.equals(s1);
        if (flag1)
        {
            i++;
            flag = true;
        }
_L7:
        j--;
          goto _L6
_L5:
        if (flag) goto _L2; else goto _L7
_L2:
        this;
        JVM INSTR monitorexit ;
        return i;
        s1;
        throw s1;
    }

    final int a(String s1, double d1)
    {
        this;
        JVM INSTR monitorenter ;
        double d2 = s.b();
        int i = 0;
        int j = b.size() - 1;
_L3:
        if (j < 0) goto _L2; else goto _L1
_L1:
        boolean flag;
        if (((a)b.get(j)).d < d2 - d1)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = s1.equals(((a)b.get(j)).a);
        if (flag)
        {
            i++;
        }
        j--;
          goto _L3
_L2:
        this;
        JVM INSTR monitorexit ;
        return i;
        s1;
        throw s1;
    }

    final void a()
    {
        boolean flag = false;
        q.i = true;
        a.g g;
        if (!f || ((a)b.get(b.size() - 1)).c != a.e.j)
        {
            if ((g = ai.a(new ae("play_history_info.txt"))) != null)
            {
                b.clear();
                d = new HashMap();
                Object obj = g.a("reward_credit");
                for (int i = 0; i < ((a.g) (obj)).b.size(); i++)
                {
                    String s1 = ((a.g) (obj)).a(i);
                    int i1 = ((a.g) (obj)).e(s1);
                    d.put(s1, Integer.valueOf(i1));
                }

                obj = g.b("play_events");
                for (int j = 0; j < ((a.c) (obj)).a.size(); j++)
                {
                    a.g g1 = ((a.c) (obj)).a(j);
                    double d1 = g1.d("timestamp");
                    String s2 = g1.a("zone_id", "");
                    int j1 = g1.e("ad_id");
                    if (d1 != 0.0D && s2 != null && j1 != 0)
                    {
                        b.add(new a(null, d1, s2, j1));
                    }
                }

                c = new HashMap();
                g = g.a("play_counts");
                for (int k = ((flag) ? 1 : 0); k < g.b.size(); k++)
                {
                    int l = Integer.parseInt(g.a(k));
                    int k1 = g.e(String.valueOf(l));
                    c.put(Integer.valueOf(l), Integer.valueOf(k1));
                }

                f = true;
                return;
            }
        }
    }

    final void a(String s1, int i)
    {
        aj.a.b("Adding play event to play history");
        e = true;
        b.add(new a(a.e.j, s.b(), s1, i));
        s1 = (Integer)c.get(Integer.valueOf(i));
        aj.a.a("Got play count of ").a(s1).b(" for this ad");
        if (s1 == null)
        {
            c.put(Integer.valueOf(i), Integer.valueOf(1));
            return;
        } else
        {
            c.put(Integer.valueOf(i), Integer.valueOf(s1.intValue() + 1));
            return;
        }
    }

    final int b(String s1)
    {
        s1 = (Integer)d.get(s1);
        if (s1 == null)
        {
            return 0;
        } else
        {
            return s1.intValue();
        }
    }

    final void b()
    {
        a.c c1 = new a.c();
        a.g g = new a.g();
        a.g g1 = new a.g();
        double d1 = s.b();
        int i = b.size() - 1;
        do
        {
            if (i < 0)
            {
                break;
            }
            a a1 = (a)b.get(i);
            if (a1.d < d1 - 2678400D)
            {
                break;
            }
            a.g g2 = new a.g();
            g2.b("zone_id", a1.a);
            g2.a("ad_id", a1.b);
            g2.a("timestamp", a1.d);
            c1.a(g2);
            i--;
        } while (true);
        g.a("play_events", c1);
        int j;
        for (Iterator iterator = c.keySet().iterator(); iterator.hasNext(); g1.a(String.valueOf(j), ((Integer)c.get(Integer.valueOf(j))).intValue()))
        {
            j = ((Integer)iterator.next()).intValue();
        }

        g.a("play_counts", g1);
        g1 = new a.g();
        if (d.size() > 0)
        {
            String s1;
            for (Iterator iterator1 = d.keySet().iterator(); iterator1.hasNext(); g1.a(s1, ((Integer)d.get(s1)).intValue()))
            {
                s1 = (String)iterator1.next();
            }

        }
        g.a("reward_credit", g1);
        aj.a.a("Saving play history");
        ai.a(new ae("play_history_info.txt"), g);
    }
}
