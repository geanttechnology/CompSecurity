// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.a.a;

import com.google.api.a.d.h;
import com.google.api.a.d.l;
import com.google.api.a.d.r;
import com.google.api.a.d.v;
import com.google.api.a.f.a.a.a.a.c;
import com.google.api.a.g.b.d;
import com.google.api.a.g.g;
import com.google.api.a.g.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

// Referenced classes of package com.google.api.a.a.a:
//            m, l, b, d, 
//            i, p, k, s, 
//            j

public class com.google.api.a.a.a.a
{
    public static class a
    {

        i.a a;
        v b;
        com.google.api.a.e.c c;
        h d;
        l e;
        String f;
        String g;
        k h;
        d i;
        r j;
        Collection k;
        g l;
        b m;
        Collection n;

        public a a(b b1)
        {
            m = b1;
            return this;
        }

        public a a(i.a a1)
        {
            a = (i.a)com.google.api.a.f.a.a.a.a.c.a(a1);
            return this;
        }

        public a a(j j1)
        {
            n.add(com.google.api.a.f.a.a.a.a.c.a(j1));
            return this;
        }

        public a a(h h1)
        {
            d = (h)com.google.api.a.f.a.a.a.a.c.a(h1);
            return this;
        }

        public a a(l l1)
        {
            e = l1;
            return this;
        }

        public a a(v v1)
        {
            b = (v)com.google.api.a.f.a.a.a.a.c.a(v1);
            return this;
        }

        public a a(com.google.api.a.e.c c1)
        {
            c = (com.google.api.a.e.c)com.google.api.a.f.a.a.a.a.c.a(c1);
            return this;
        }

        public a a(d d1)
        {
            boolean flag;
            if (h == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            w.a(flag);
            i = d1;
            return this;
        }

        public a a(String s)
        {
            f = (String)com.google.api.a.f.a.a.a.a.c.a(s);
            return this;
        }

        public a a(Collection collection)
        {
            k = (Collection)com.google.api.a.f.a.a.a.a.c.a(collection);
            return this;
        }

        public com.google.api.a.a.a.a a()
        {
            return new com.google.api.a.a.a.a(this);
        }

        public a b(String s)
        {
            g = (String)com.google.api.a.f.a.a.a.a.c.a(s);
            return this;
        }

        public a(i.a a1, v v1, com.google.api.a.e.c c1, h h1, l l1, String s, String s1)
        {
            k = new ArrayList();
            l = g.a;
            n = new ArrayList();
            a(a1);
            a(v1);
            a(c1);
            a(h1);
            a(l1);
            a(s);
            b(s1);
        }
    }

    public static interface b
    {

        public abstract void onCredentialCreated(i i1, s s);
    }


    public final v a;
    public final com.google.api.a.e.c b;
    public final String c;
    public final l d;
    public final String e;
    public final String f;
    public final r g;
    public final Collection h;
    private final i.a i;
    private final k j;
    private final d k;
    private final g l;
    private final b m;
    private final Collection n;

    public com.google.api.a.a.a.a(a a1)
    {
        i = (i.a)com.google.api.a.f.a.a.a.a.c.a(a1.a);
        a = (v)com.google.api.a.f.a.a.a.a.c.a(a1.b);
        b = (com.google.api.a.e.c)com.google.api.a.f.a.a.a.a.c.a(a1.c);
        c = ((h)com.google.api.a.f.a.a.a.a.c.a(a1.d)).d();
        d = a1.e;
        e = (String)com.google.api.a.f.a.a.a.a.c.a(a1.f);
        f = (String)com.google.api.a.f.a.a.a.a.c.a(a1.g);
        g = a1.j;
        j = a1.h;
        k = a1.i;
        h = Collections.unmodifiableCollection(a1.k);
        l = (g)com.google.api.a.f.a.a.a.a.c.a(a1.l);
        m = a1.m;
        n = Collections.unmodifiableCollection(a1.n);
    }

    private i c(String s)
    {
        i.b b1;
        b1 = new i.b(i);
        b1.b = a;
        b1.c = b;
        Object obj = c;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = new h(((String) (obj)));
        }
        b1.d = ((h) (obj));
        b1.f = d;
        b1.g = g;
        b1.e = (g)com.google.api.a.f.a.a.a.a.c.a(l);
        if (k == null) goto _L2; else goto _L1
_L1:
        b1.a(new m(s, k));
_L4:
        b1.h.addAll(n);
        return b1.a();
_L2:
        if (j != null)
        {
            b1.a(new com.google.api.a.a.a.l(s, j));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public com.google.api.a.a.a.b a()
    {
        return (new com.google.api.a.a.a.b(f, e)).b(h);
    }

    public com.google.api.a.a.a.d a(String s)
    {
        return (new com.google.api.a.a.a.d(a, b, new h(c), s)).a(d).a(g).a(h);
    }

    public final i a(s s, String s1)
    {
        i i1 = c(s1).a(s);
        if (k != null)
        {
            k.a(s1, new p(i1));
        }
        if (m != null)
        {
            m.onCredentialCreated(i1, s);
        }
        return i1;
    }

    public final i b(String s)
    {
        if (k == null && j == null)
        {
            return null;
        }
        i i1 = c(s);
        if (k != null)
        {
            s = (p)k.a(s);
            if (s == null)
            {
                return null;
            }
            i1.a(s.a());
            i1.b(s.c());
            i1.a(s.b());
        } else
        if (!j.a())
        {
            return null;
        }
        return i1;
    }
}
