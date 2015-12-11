// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.a;

import c.f;
import c.m;
import c.t;
import com.g.b.a.d.a;
import com.g.b.a.d.d;
import com.g.b.a.d.o;
import com.g.b.a.d.p;
import com.g.b.a.k;
import com.g.b.i;
import com.g.b.s;
import com.g.b.u;
import com.g.b.v;
import com.g.b.x;
import com.g.b.y;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.g.b.a.a:
//            t, k, n, g, 
//            m, j, s

public final class r
    implements com.g.b.a.a.t
{

    private static final List a = k.a(new f[] {
        f.a("connection"), f.a("host"), f.a("keep-alive"), f.a("proxy-connection"), f.a("transfer-encoding")
    });
    private static final List b = k.a(new f[] {
        f.a("connection"), f.a("host"), f.a("keep-alive"), f.a("proxy-connection"), f.a("te"), f.a("transfer-encoding"), f.a("encoding"), f.a("upgrade")
    });
    private final g c;
    private final o d;
    private p e;

    public r(g g1, o o1)
    {
        c = g1;
        d = o1;
    }

    private static boolean a(u u1, f f1)
    {
        if (u1 == u.c)
        {
            return a.contains(f1);
        }
        if (u1 == u.d)
        {
            return b.contains(f1);
        } else
        {
            throw new AssertionError(u1);
        }
    }

    public final c.r a(v v1, long l)
    {
        return e.d();
    }

    public final y a(x x1)
    {
        return new com.g.b.a.a.k(x1.f, m.a(e.f));
    }

    public final void a()
    {
        e.d().close();
    }

    public final void a(g g1)
    {
        if (e != null)
        {
            e.a(a.l);
        }
    }

    public final void a(n n1)
    {
        n1.a(e.d());
    }

    public final void a(v v1)
    {
        o o1;
        ArrayList arraylist;
        Object obj;
        String s1;
        boolean flag;
        if (e != null)
        {
            return;
        }
        c.b();
        flag = c.c();
        obj = com.g.b.a.a.m.a(c.b.g);
        o1 = d;
        u u1 = d.a;
        com.g.b.o o2 = v1.c;
        arraylist = new ArrayList(o2.a.length / 2 + 10);
        arraylist.add(new d(d.b, v1.b));
        arraylist.add(new d(d.c, com.g.b.a.a.m.a(v1.a())));
        s1 = com.g.b.a.a.g.a(v1.a());
        int l;
        int j1;
        if (u.c == u1)
        {
            arraylist.add(new d(d.g, ((String) (obj))));
            arraylist.add(new d(d.f, s1));
        } else
        if (u.d == u1)
        {
            arraylist.add(new d(d.e, s1));
        } else
        {
            throw new AssertionError();
        }
        arraylist.add(new d(d.d, v1.a().getProtocol()));
        v1 = new LinkedHashSet();
        j1 = o2.a.length / 2;
        l = 0;
        if (l >= j1)
        {
            break MISSING_BLOCK_LABEL_519;
        }
        obj = f.a(o2.a(l).toLowerCase(Locale.US));
        s1 = o2.b(l);
        if (!a(u1, ((f) (obj))) && !((f) (obj)).equals(d.b) && !((f) (obj)).equals(d.c) && !((f) (obj)).equals(d.d) && !((f) (obj)).equals(d.e) && !((f) (obj)).equals(d.f) && !((f) (obj)).equals(d.g))
        {
            if (!v1.add(obj))
            {
                break; /* Loop/switch isn't completed */
            }
            arraylist.add(new d(((f) (obj)), s1));
        }
_L6:
        l++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_227;
_L1:
        int i1 = 0;
_L4:
        if (i1 < arraylist.size())
        {
label0:
            {
                if (!((d)arraylist.get(i1)).h.equals(obj))
                {
                    break label0;
                }
                arraylist.set(i1, new d(((f) (obj)), (new StringBuilder(((d)arraylist.get(i1)).i.a())).append('\0').append(s1).toString()));
            }
        }
        continue; /* Loop/switch isn't completed */
        i1++;
        if (true) goto _L4; else goto _L3
_L3:
        e = o1.a(arraylist, flag);
        e.h.a(c.a.u, TimeUnit.MILLISECONDS);
        return;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final com.g.b.x.a b()
    {
        List list = e.c();
        u u1 = d.a;
        Object obj = null;
        Object obj1 = "HTTP/1.1";
        com.g.b.o.a a1 = new com.g.b.o.a();
        a1.b(com.g.b.a.a.j.d, u1.toString());
        int l1 = list.size();
        int l = 0;
        do
        {
            if (l >= l1)
            {
                break;
            }
            f f1 = ((d)list.get(l)).h;
            String s2 = ((d)list.get(l)).i.a();
            int i1 = 0;
            while (i1 < s2.length()) 
            {
                int k1 = s2.indexOf('\0', i1);
                int j1 = k1;
                if (k1 == -1)
                {
                    j1 = s2.length();
                }
                String s1 = s2.substring(i1, j1);
                if (f1.equals(d.a))
                {
                    obj = s1;
                } else
                if (f1.equals(d.g))
                {
                    obj1 = s1;
                } else
                if (!a(u1, f1))
                {
                    a1.a(f1.a(), s1);
                }
                i1 = j1 + 1;
            }
            l++;
        } while (true);
        if (obj == null)
        {
            throw new ProtocolException("Expected ':status' header not present");
        } else
        {
            obj = com.g.b.a.a.s.a((new StringBuilder()).append(((String) (obj1))).append(" ").append(((String) (obj))).toString());
            obj1 = new com.g.b.x.a();
            obj1.b = u1;
            obj1.c = ((com.g.b.a.a.s) (obj)).b;
            obj1.d = ((com.g.b.a.a.s) (obj)).c;
            return ((com.g.b.x.a) (obj1)).a(a1.a());
        }
    }

    public final void c()
    {
    }

    public final boolean d()
    {
        return true;
    }

}
