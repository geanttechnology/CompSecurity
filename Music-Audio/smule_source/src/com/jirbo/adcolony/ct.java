// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.jirbo.adcolony:
//            l, ar, k, cu, 
//            bl, ak, ap, be, 
//            n, bc, bx, bg, 
//            bk, h, d, cx

class ct
    implements l
{

    be a;
    ArrayList b;
    HashMap c;
    int d;
    ar e;
    int f;
    ArrayList g;
    boolean h;
    boolean i;
    double j;

    ct(be be1)
    {
        b = new ArrayList();
        c = new HashMap();
        d = 1;
        e = new ar(2D);
        g = new ArrayList();
        a = be1;
    }

    String a(String s, int i1)
    {
        int j1 = s.lastIndexOf('.');
        if (j1 == -1)
        {
            return (new StringBuilder()).append(i1).append("").toString();
        }
        String s1 = s.substring(j1);
        s = s1;
        if (s1.contains("/"))
        {
            s = ".0";
        }
        return (new StringBuilder()).append(i1).append(s).toString();
    }

    void a()
    {
        b();
        h = true;
    }

    public void a(k k1)
    {
        cu cu1 = (cu)k1.e;
        f = f - 1;
        i = true;
        e.a(2D);
        cu1.e = k1.i;
        cu1.d = false;
        if (k1.i)
        {
            cu1.g = k1.l;
            j = j + (double)cu1.g;
            bl.a.a("Downloaded ").b(cu1.a);
        }
        ak.f();
        f();
    }

    void a(String s, String s1)
    {
        if (s != null && !s.equals("")) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s2;
        cu cu1;
        s2 = s1;
        if (s1 == null)
        {
            s2 = "";
        }
        cu1 = (cu)c.get(s);
        if (cu1 == null) goto _L4; else goto _L3
_L3:
        cu1.h = ap.b();
        s1 = cu1;
        if (!cu1.c.equals(s2))
        {
            break MISSING_BLOCK_LABEL_83;
        }
        if (cu1.e || cu1.d) goto _L1; else goto _L5
_L5:
        s1 = cu1;
_L7:
        if (((cu) (s1)).f == 0)
        {
            int i1 = h();
            String s3 = a(s, i1);
            s3 = (new StringBuilder()).append(a.f.c).append(s3).toString();
            s1.f = i1;
            s1.b = s3;
        }
        s1.c = s2;
        s1.d = true;
        s1.e = false;
        bl.a.a("Adding ").a(s).b(" to pending downloads.");
        g.add(s);
        i = true;
        e.a(2D);
        ak.i = true;
        return;
_L4:
        s1 = new cu();
        s1.a = s;
        b.add(s1);
        s1.h = ap.b();
        c.put(s, s1);
        if (true) goto _L7; else goto _L6
_L6:
    }

    boolean a(String s)
    {
        if (s == null || s.equals(""))
        {
            return false;
        }
        s = (cu)c.get(s);
        if (s == null)
        {
            a.b.j.a();
            return false;
        }
        if (((cu) (s)).e)
        {
            if (((cu) (s)).d)
            {
                return false;
            } else
            {
                s.h = ap.b();
                return true;
            }
        }
        if (!((cu) (s)).d)
        {
            a.b.j.a();
        }
        return false;
    }

    String b(String s)
    {
        s = (cu)c.get(s);
        if (s == null || ((cu) (s)).b == null)
        {
            return "(file not found)";
        } else
        {
            s.h = ap.b();
            i = true;
            e.a(2D);
            return ((cu) (s)).b;
        }
    }

    void b()
    {
        bl.a.b("Loading media info");
        Object obj = bk.b(new bg("media_info.txt"));
        if (obj == null)
        {
            obj = new h();
            bl.a.b("No saved media info exists.");
        } else
        {
            bl.a.b("Loaded media info");
        }
        d = ((h) (obj)).f("next_file_number");
        if (d <= 0)
        {
            d = 1;
        }
        obj = ((h) (obj)).b("assets");
        if (obj != null)
        {
            b.clear();
            for (int i1 = 0; i1 < ((d) (obj)).a_(); i1++)
            {
                h h1 = ((d) (obj)).a(i1);
                cu cu1 = new cu();
                cu1.a = h1.d("url");
                cu1.b = h1.d("filepath");
                cu1.c = h1.d("last_modified");
                cu1.f = h1.f("file_number");
                cu1.g = h1.f("size");
                cu1.e = h1.g("ready");
                cu1.h = h1.e("last_accessed");
                if (cu1.f > d)
                {
                    d = cu1.f + 1;
                }
                b.add(cu1);
            }

        }
        c();
    }

    void c()
    {
        HashMap hashmap = new HashMap();
        String s = a.f.c;
        String as[] = (new File(s)).list();
        if (as == null)
        {
            as = new String[0];
        }
        int i2 = as.length;
        for (int i1 = 0; i1 < i2; i1++)
        {
            String s2 = as[i1];
            s2 = (new StringBuilder()).append(s).append(s2).toString();
            hashmap.put(s2, s2);
        }

        HashMap hashmap1 = new HashMap();
        j = 0.0D;
        ArrayList arraylist = new ArrayList();
        for (int j1 = 0; j1 < b.size(); j1++)
        {
            cu cu2 = (cu)b.get(j1);
            if (cu2.d || !cu2.e)
            {
                continue;
            }
            String s3 = cu2.b;
            if (hashmap.containsKey(s3) && (new File(s3)).length() == (long)cu2.g)
            {
                j = j + (double)cu2.g;
                arraylist.add(cu2);
                hashmap1.put(s3, s3);
            }
        }

        b = arraylist;
        i2 = as.length;
        for (int k1 = 0; k1 < i2; k1++)
        {
            String s1 = as[k1];
            s1 = (new StringBuilder()).append(s).append(s1).toString();
            if (!hashmap1.containsKey(s1))
            {
                bl.b.a("Deleting unused media ").b(s1);
                (new File(s1)).delete();
            }
        }

        c.clear();
        for (int l1 = 0; l1 < b.size(); l1++)
        {
            cu cu1 = (cu)b.get(l1);
            c.put(cu1.a, cu1);
        }

        double d1 = a.b.j.g;
        if (d1 > 0.0D)
        {
            bl.b.a("Media pool at ").a(j / 1048576D).a("/").a(d1 / 1048576D).b(" MB");
        }
    }

    void d()
    {
        bl.a.b("Saving media info");
        d d1 = new d();
        for (int i1 = 0; i1 < b.size(); i1++)
        {
            cu cu1 = (cu)b.get(i1);
            if (cu1.e && !cu1.d)
            {
                h h2 = new h();
                h2.b("url", cu1.a);
                h2.b("filepath", cu1.b);
                h2.b("last_modified", cu1.c);
                h2.b("file_number", cu1.f);
                h2.b("size", cu1.g);
                h2.b("ready", cu1.e);
                h2.b("last_accessed", cu1.h);
                d1.a(h2);
            }
        }

        h h1 = new h();
        h1.b("next_file_number", d);
        h1.a("assets", d1);
        bk.a(new bg("media_info.txt"), h1);
        i = false;
    }

    void e()
    {
        f();
        if (i && e.a())
        {
            g();
            d();
        }
    }

    void f()
    {
        if (a.b.j.j.equals("wifi") && !cx.a())
        {
            bl.a.b("Skipping asset download due to CACHE_FILTER_WIFI");
        } else
        {
            if (a.b.j.j.equals("cell") && !cx.b())
            {
                bl.a.b("Skipping asset download due to CACHE_FILTER_CELL.");
                return;
            }
            while (f < 3 && g.size() > 0) 
            {
                String s = (String)g.remove(0);
                cu cu1 = (cu)c.get(s);
                if (cu1 != null && (s == null || s.equals("")))
                {
                    bl.d.b("[ADC ERROR] - NULL URL");
                    (new RuntimeException()).printStackTrace();
                }
                if (cu1 != null && s != null && !s.equals(""))
                {
                    ak.i = true;
                    f = f + 1;
                    (new k(a, s, this, cu1.b)).a(cu1).a();
                }
            }
        }
    }

    void g()
    {
        double d1 = a.b.j.g;
        if (d1 != 0.0D) goto _L2; else goto _L1
_L1:
        return;
_L7:
        cu cu1;
        bl.b.a("Deleting ").b(cu1.b);
        cu1.e = false;
        (new File(cu1.b)).delete();
        cu1.b = null;
        j = j - (double)cu1.g;
        bl.b.a("Media pool now at ").a(j / 1048576D).a("/").a(d1 / 1048576D).b(" MB");
        i = true;
        e.a(2D);
_L2:
        if (j <= a.b.j.g) goto _L1; else goto _L3
_L3:
        int i1;
        i1 = 0;
        cu1 = null;
_L5:
        cu cu2;
        if (i1 >= b.size())
        {
            continue; /* Loop/switch isn't completed */
        }
        cu cu3 = (cu)b.get(i1);
        if (!cu3.e)
        {
            break MISSING_BLOCK_LABEL_241;
        }
        cu2 = cu3;
        if (cu1 != null)
        {
            if (cu3.h >= cu1.h)
            {
                break MISSING_BLOCK_LABEL_241;
            }
            cu2 = cu3;
        }
_L8:
        i1++;
        cu1 = cu2;
        if (true) goto _L5; else goto _L4
_L4:
        if (cu1 != null && cu1.b != null) goto _L7; else goto _L6
_L6:
        return;
        cu2 = cu1;
          goto _L8
    }

    int h()
    {
        i = true;
        e.a(2D);
        int i1 = d;
        d = i1 + 1;
        return i1;
    }
}
