// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.jirbo.adcolony:
//            aj, ae, ai, ac, 
//            d, aa, b, q, 
//            s, ao, r

final class am
    implements b.a
{
    static final class a
    {

        String a;
        String b;
        String c;
        boolean d;
        boolean e;
        int f;
        int g;
        double h;

        a()
        {
        }
    }


    ac a;
    ArrayList b;
    HashMap c;
    int d;
    s.b e;
    int f;
    ArrayList g;
    boolean h;
    boolean i;
    double j;

    am(ac ac1)
    {
        b = new ArrayList();
        c = new HashMap();
        d = 1;
        e = new s.b(2D);
        g = new ArrayList();
        a = ac1;
    }

    final void a()
    {
        aj.a.b("Loading media info");
        Object obj = ai.a(new ae("media_info.txt"));
        if (obj == null)
        {
            obj = new a.g();
            aj.a.b("No saved media info exists.");
        } else
        {
            aj.a.b("Loaded media info");
        }
        d = ((a.g) (obj)).e("next_file_number");
        if (d <= 0)
        {
            d = 1;
        }
        obj = ((a.g) (obj)).b("assets");
        if (obj != null)
        {
            b.clear();
            for (int k = 0; k < ((a.c) (obj)).a.size(); k++)
            {
                a.g g1 = ((a.c) (obj)).a(k);
                a a2 = new a();
                a2.a = g1.a("url", "");
                a2.b = g1.a("filepath", "");
                a2.c = g1.a("last_modified", "");
                a2.f = g1.e("file_number");
                a2.g = g1.e("size");
                a2.e = g1.a("ready", false);
                a2.h = g1.d("last_accessed");
                if (a2.f > d)
                {
                    d = a2.f + 1;
                }
                b.add(a2);
            }

        }
        HashMap hashmap = new HashMap();
        String s1 = a.f.c;
        String as[] = (new File(s1)).list();
        if (as == null)
        {
            as = new String[0];
        }
        int l1 = as.length;
        for (int l = 0; l < l1; l++)
        {
            String s3 = as[l];
            s3 = (new StringBuilder()).append(s1).append(s3).toString();
            hashmap.put(s3, s3);
        }

        HashMap hashmap1 = new HashMap();
        j = 0.0D;
        ArrayList arraylist = new ArrayList();
        for (int i1 = 0; i1 < b.size(); i1++)
        {
            a a3 = (a)b.get(i1);
            if (a3.d || !a3.e)
            {
                continue;
            }
            String s4 = a3.b;
            if (hashmap.containsKey(s4) && (new File(s4)).length() == (long)a3.g)
            {
                j = j + (double)a3.g;
                arraylist.add(a3);
                hashmap1.put(s4, s4);
            }
        }

        b = arraylist;
        l1 = as.length;
        for (int j1 = 0; j1 < l1; j1++)
        {
            String s2 = as[j1];
            s2 = (new StringBuilder()).append(s1).append(s2).toString();
            if (!hashmap1.containsKey(s2))
            {
                aj.b.a("Deleting unused media ").b(s2);
                (new File(s2)).delete();
            }
        }

        c.clear();
        for (int k1 = 0; k1 < b.size(); k1++)
        {
            a a1 = (a)b.get(k1);
            c.put(a1.a, a1);
        }

        double d1 = a.b.j.g;
        if (d1 > 0.0D)
        {
            aj.b.a("Media pool at ").a(j / 1048576D).a("/").a(d1 / 1048576D).b(" MB");
        }
    }

    public final void a(b b1)
    {
        a a1 = (a)b1.e;
        f = f - 1;
        i = true;
        e.a(2D);
        a1.e = b1.i;
        a1.d = false;
        if (b1.i)
        {
            a1.g = b1.l;
            j = j + (double)a1.g;
            aj.a.a("Downloaded ").b(a1.a);
        }
        q.f();
        c();
    }

    final void a(String s1, String s2)
    {
        if (s1 != null && !s1.equals("")) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s3;
        a a1;
        s3 = s2;
        if (s2 == null)
        {
            s3 = "";
        }
        a1 = (a)c.get(s1);
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_246;
        }
        a1.h = s.b();
        s2 = a1;
        if (!a1.c.equals(s3))
        {
            break MISSING_BLOCK_LABEL_83;
        }
        if (a1.e || a1.d) goto _L1; else goto _L3
_L3:
        s2 = a1;
_L4:
        if (((a) (s2)).f == 0)
        {
            i = true;
            e.a(2D);
            int k = d;
            d = k + 1;
            int l = s1.lastIndexOf('.');
            String s4;
            if (l == -1)
            {
                s4 = String.valueOf(k);
            } else
            {
                String s5 = s1.substring(l);
                s4 = s5;
                if (s5.contains("/"))
                {
                    s4 = ".0";
                }
                s4 = (new StringBuilder()).append(k).append(s4).toString();
            }
            s4 = (new StringBuilder()).append(a.f.c).append(s4).toString();
            s2.f = k;
            s2.b = s4;
        }
        s2.c = s3;
        s2.d = true;
        s2.e = false;
        aj.a.a("Adding ").a(s1).b(" to pending downloads.");
        g.add(s1);
        i = true;
        e.a(2D);
        q.i = true;
        return;
        s2 = new a();
        s2.a = s1;
        b.add(s2);
        s2.h = s.b();
        c.put(s1, s2);
          goto _L4
    }

    final boolean a(String s1)
    {
        if (s1 == null || s1.equals(""))
        {
            return false;
        }
        s1 = (a)c.get(s1);
        if (s1 == null)
        {
            a.b.j.a();
            return false;
        }
        if (((a) (s1)).e)
        {
            if (((a) (s1)).d)
            {
                return false;
            } else
            {
                s1.h = s.b();
                return true;
            }
        }
        if (!((a) (s1)).d)
        {
            a.b.j.a();
        }
        return false;
    }

    final String b(String s1)
    {
        s1 = (a)c.get(s1);
        if (s1 == null || ((a) (s1)).b == null)
        {
            return "(file not found)";
        } else
        {
            s1.h = s.b();
            i = true;
            e.a(2D);
            return ((a) (s1)).b;
        }
    }

    final void b()
    {
        aj.a.b("Saving media info");
        a.c c1 = new a.c();
        for (int k = 0; k < b.size(); k++)
        {
            a a1 = (a)b.get(k);
            if (a1.e && !a1.d)
            {
                a.g g2 = new a.g();
                g2.b("url", a1.a);
                g2.b("filepath", a1.b);
                g2.b("last_modified", a1.c);
                g2.a("file_number", a1.f);
                g2.a("size", a1.g);
                g2.b("ready", a1.e);
                g2.a("last_accessed", a1.h);
                c1.a(g2);
            }
        }

        a.g g1 = new a.g();
        g1.a("next_file_number", d);
        g1.a("assets", c1);
        ai.a(new ae("media_info.txt"), g1);
        i = false;
    }

    final void c()
    {
        if (a.b.j.j.equals("wifi") && !ao.a())
        {
            aj.a.b("Skipping asset download due to CACHE_FILTER_WIFI");
        } else
        {
            if (a.b.j.j.equals("cell") && !ao.b())
            {
                aj.a.b("Skipping asset download due to CACHE_FILTER_CELL.");
                return;
            }
            while (f < 3 && g.size() > 0) 
            {
                Object obj = (String)g.remove(0);
                a a1 = (a)c.get(obj);
                if (a1 != null && (obj == null || ((String) (obj)).equals("")))
                {
                    aj.d.b("[ADC ERROR] - NULL URL");
                    (new RuntimeException()).printStackTrace();
                }
                if (a1 != null && obj != null && !((String) (obj)).equals(""))
                {
                    q.i = true;
                    f = f + 1;
                    obj = new b(a, ((String) (obj)), this, a1.b);
                    obj.e = a1;
                    r.a(((Runnable) (obj)));
                }
            }
        }
    }

    final void d()
    {
        double d1 = a.b.j.g;
        if (d1 != 0.0D) goto _L2; else goto _L1
_L1:
        return;
_L7:
        a a1;
        aj.b.a("Deleting ").b(a1.b);
        a1.e = false;
        (new File(a1.b)).delete();
        a1.b = null;
        j = j - (double)a1.g;
        aj.b.a("Media pool now at ").a(j / 1048576D).a("/").a(d1 / 1048576D).b(" MB");
        i = true;
        e.a(2D);
_L2:
        if (j <= a.b.j.g) goto _L1; else goto _L3
_L3:
        int k;
        k = 0;
        a1 = null;
_L5:
        a a2;
        if (k >= b.size())
        {
            continue; /* Loop/switch isn't completed */
        }
        a a3 = (a)b.get(k);
        if (!a3.e)
        {
            break MISSING_BLOCK_LABEL_240;
        }
        a2 = a3;
        if (a1 != null)
        {
            if (a3.h >= a1.h)
            {
                break MISSING_BLOCK_LABEL_240;
            }
            a2 = a3;
        }
_L8:
        k++;
        a1 = a2;
        if (true) goto _L5; else goto _L4
_L4:
        if (a1 != null && a1.b != null) goto _L7; else goto _L6
_L6:
        return;
        a2 = a1;
          goto _L8
    }
}
