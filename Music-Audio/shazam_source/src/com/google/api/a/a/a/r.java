// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.a.a;

import com.google.api.a.d.ac;
import com.google.api.a.d.h;
import com.google.api.a.d.p;
import com.google.api.a.d.q;
import com.google.api.a.d.s;
import com.google.api.a.d.v;
import com.google.api.a.e.e;
import com.google.api.a.f.a.a.a.a.c;
import com.google.api.a.g.l;
import com.google.api.a.g.n;
import com.google.api.a.g.w;
import java.util.Collection;

// Referenced classes of package com.google.api.a.a.a:
//            t, s

public class r extends l
{

    com.google.api.a.d.r a;
    com.google.api.a.d.l b;
    private final v c;
    private final com.google.api.a.e.c d;
    private h e;
    private String grantType;
    private String scopes;

    public r(v v1, com.google.api.a.e.c c1, h h1, String s1)
    {
        c = (v)com.google.api.a.f.a.a.a.a.c.a(v1);
        d = (com.google.api.a.e.c)com.google.api.a.f.a.a.a.a.c.a(c1);
        b(h1);
        d(s1);
    }

    public final s a()
    {
        Object obj = c.a(new com.google.api.a.d.r() {

            final r a;

            public final void a(p p1)
            {
                if (a.a != null)
                {
                    a.a.a(p1);
                }
                p1.a = new com.google.api.a.d.l(this, p1.a) {

                    final com.google.api.a.d.l a;
                    final _cls1 b;

                    public final void b(p p1)
                    {
                        if (a != null)
                        {
                            a.b(p1);
                        }
                        if (b.a.b != null)
                        {
                            b.a.b.b(p1);
                        }
                    }

            
            {
                b = _pcls1;
                a = l1;
                super();
            }
                };
            }

            
            {
                a = r.this;
                super();
            }
        }).a(e, new ac(this));
        obj.m = new e(d);
        obj.o = false;
        obj = ((p) (obj)).a();
        if (((s) (obj)).a())
        {
            return ((s) (obj));
        } else
        {
            throw t.a(d, ((s) (obj)));
        }
    }

    public r b(h h1)
    {
        e = h1;
        boolean flag;
        if (h1.b == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag);
        return this;
    }

    public r b(com.google.api.a.d.l l1)
    {
        b = l1;
        return this;
    }

    public r b(com.google.api.a.d.r r1)
    {
        a = r1;
        return this;
    }

    public r b(String s1, Object obj)
    {
        return (r)super.set(s1, obj);
    }

    public r b(Collection collection)
    {
        if (collection == null)
        {
            collection = null;
        } else
        {
            collection = n.a().a(collection);
        }
        scopes = collection;
        return this;
    }

    public com.google.api.a.a.a.s b()
    {
        return (com.google.api.a.a.a.s)a().a(com/google/api/a/a/a/s);
    }

    public r d(String s1)
    {
        grantType = (String)com.google.api.a.f.a.a.a.a.c.a(s1);
        return this;
    }

    public l set(String s1, Object obj)
    {
        return b(s1, obj);
    }
}
