// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.b.e;
import com.google.b.b.h;
import com.google.b.b.j;
import com.google.b.d.a;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.i;
import com.google.b.l;
import com.google.b.n;
import com.google.b.o;
import com.google.b.r;
import com.google.b.u;
import com.google.b.x;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.b.b.a:
//            g, l

private final class d extends x
{

    final g a;
    private final x b;
    private final x c;
    private final h d;

    public final Object a(a a1)
    {
        b b1 = a1.f();
        if (b1 == b.i)
        {
            a1.k();
            return null;
        }
        Map map = (Map)d.a();
        if (b1 == b.a)
        {
            a1.a();
            for (; a1.e(); a1.b())
            {
                a1.a();
                Object obj = b.a(a1);
                if (map.put(obj, c.a(a1)) != null)
                {
                    throw new u((new StringBuilder("duplicate key: ")).append(obj).toString());
                }
            }

            a1.b();
            return map;
        }
        a1.c();
        while (a1.e()) 
        {
            e.a.a(a1);
            Object obj1 = b.a(a1);
            if (map.put(obj1, c.a(a1)) != null)
            {
                throw new u((new StringBuilder("duplicate key: ")).append(obj1).toString());
            }
        }
        a1.d();
        return map;
    }

    public final void a(c c1, Object obj)
    {
        boolean flag3 = false;
        boolean flag2 = false;
        obj = (Map)obj;
        if (obj == null)
        {
            c1.f();
            return;
        }
        if (!com.google.b.b.a.g.a(a))
        {
            c1.d();
            java.util.Entry entry;
            for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); c.a(c1, entry.getValue()))
            {
                entry = (java.util.Entry)((Iterator) (obj)).next();
                c1.a(String.valueOf(entry.getKey()));
            }

            c1.e();
            return;
        }
        ArrayList arraylist = new ArrayList(((Map) (obj)).size());
        ArrayList arraylist1 = new ArrayList(((Map) (obj)).size());
        obj = ((Map) (obj)).entrySet().iterator();
        boolean flag = false;
        while (((Iterator) (obj)).hasNext()) 
        {
            java.util.Entry entry1 = (java.util.Entry)((Iterator) (obj)).next();
            l l1 = b.a(entry1.getKey());
            arraylist.add(l1);
            arraylist1.add(entry1.getValue());
            boolean flag1;
            if ((l1 instanceof i) || (l1 instanceof o))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag = flag1 | flag;
        }
        if (flag)
        {
            c1.b();
            for (int k = ((flag2) ? 1 : 0); k < arraylist.size(); k++)
            {
                c1.b();
                j.a((l)arraylist.get(k), c1);
                c.a(c1, arraylist1.get(k));
                c1.c();
            }

            c1.c();
            return;
        }
        c1.d();
        int i1 = ((flag3) ? 1 : 0);
        while (i1 < arraylist.size()) 
        {
            obj = (l)arraylist.get(i1);
            if (obj instanceof r)
            {
                obj = ((l) (obj)).h();
                if (((r) (obj)).a instanceof Number)
                {
                    obj = String.valueOf(((r) (obj)).a());
                } else
                if (((r) (obj)).a instanceof Boolean)
                {
                    obj = Boolean.toString(((r) (obj)).f());
                } else
                if (((r) (obj)).a instanceof String)
                {
                    obj = ((r) (obj)).b();
                } else
                {
                    throw new AssertionError();
                }
            } else
            if (obj instanceof n)
            {
                obj = "null";
            } else
            {
                throw new AssertionError();
            }
            c1.a(((String) (obj)));
            c.a(c1, arraylist1.get(i1));
            i1++;
        }
        c1.e();
    }

    public e(g g1, f f, Type type, x x1, Type type1, x x2, h h1)
    {
        a = g1;
        super();
        b = new com.google.b.b.a.l(f, x1, type);
        c = new com.google.b.b.a.l(f, x2, type1);
        d = h1;
    }
}
