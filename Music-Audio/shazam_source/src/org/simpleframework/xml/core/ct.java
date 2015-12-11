// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.m;
import org.simpleframework.xml.s;

// Referenced classes of package org.simpleframework.xml.core:
//            dv, k, ei, cm, 
//            aq, bu, cl, bx, 
//            cb, ep, eh, ej, 
//            ag, af, ae, i, 
//            cp, ec, ai, cz, 
//            bt, an, dy, bm

final class ct
    implements dv
{

    private ei a;
    private k b;
    private eh c;
    private ej d;
    private aq e;

    public ct(aq aq1, ej ej1)
    {
        boolean flag = false;
        super();
        b = new k(aq1, ej1);
        a = new ei(this, aq1, ej1);
        d = ej1;
        e = aq1;
        ej1 = a;
        Object obj = ((ei) (ej1)).f.i();
        if (obj != null)
        {
            ((ei) (ej1)).c.a(((ei) (ej1)).i, ((m) (obj)));
        }
        a(aq1);
        b(aq1);
        aq1 = aq1.f();
        ej1 = a;
        if (((ei) (ej1)).d == null)
        {
            ej1.d = ((ei) (ej1)).a.a();
        }
        ej1 = a;
        obj = ((ei) (ej1)).f.i();
        ej1.a();
        ej1.a(aq1, ((m) (obj)));
        ej1.b(aq1, ((m) (obj)));
        if (!((ei) (ej1)).i.a())
        {
            ((ei) (ej1)).i.a(aq1);
        }
        obj = ((ei) (ej1)).i.f();
        if (obj != null)
        {
            if (!((bx) (obj)).isTextList())
            {
                if (!((ei) (ej1)).e.isEmpty())
                {
                    throw new ep("Elements used with %s in %s", new Object[] {
                        obj, aq1
                    });
                }
                if (((ei) (ej1)).i.b())
                {
                    throw new ep("Paths used with %s in %s", new Object[] {
                        obj, aq1
                    });
                }
            }
        } else
        if (((ei) (ej1)).f.t())
        {
            if (((ei) (ej1)).h == null)
            {
                flag = ((ei) (ej1)).i.a();
            }
            ej1.j = flag;
        }
        ej1.a(aq1);
        if (c == null)
        {
            aq1 = a;
            c = new eh(((ei) (aq1)).d, ((ei) (aq1)).i, ((ei) (aq1)).g, ((ei) (aq1)).h, ((ei) (aq1)).j);
        }
        a = null;
    }

    private void a(aq aq1)
    {
        Class class1 = aq1.f();
        aq1 = aq1.k();
        aq1 = d.b(class1, aq1).iterator();
        do
        {
            if (!aq1.hasNext())
            {
                break;
            }
            af af1 = (af)aq1.next();
            java.lang.annotation.Annotation annotation = af1.e();
            if (annotation != null)
            {
                a.a(af1, annotation);
            }
        } while (true);
    }

    private void b(aq aq1)
    {
        Class class1 = aq1.f();
        aq1 = aq1.k();
        aq1 = d.c(class1, aq1).iterator();
        do
        {
            if (!aq1.hasNext())
            {
                break;
            }
            af af1 = (af)aq1.next();
            java.lang.annotation.Annotation annotation = af1.e();
            if (annotation != null)
            {
                a.a(af1, annotation);
            }
        } while (true);
    }

    public final ec a()
    {
        return b.b.c;
    }

    public final i a(ai ai)
    {
        return new i(this, ai);
    }

    public final List b()
    {
        return new ArrayList(b.b.a);
    }

    public final cz c()
    {
        return b.b.b;
    }

    public final bt d()
    {
        return c.a;
    }

    public final Class e()
    {
        return e.f();
    }

    public final an f()
    {
        return b.a;
    }

    public final dy g()
    {
        return new cp(c.d);
    }

    public final s h()
    {
        eh eh1 = c;
        if (eh1.b != null)
        {
            return (s)eh1.b.getContact().a(org/simpleframework/xml/s);
        } else
        {
            return null;
        }
    }

    public final m i()
    {
        return b.j;
    }

    public final bx j()
    {
        return c.b;
    }

    public final bx k()
    {
        return c.c;
    }

    public final String l()
    {
        return e.g();
    }

    public final bm m()
    {
        return b.c;
    }

    public final bm n()
    {
        return b.d;
    }

    public final bm o()
    {
        return b.e;
    }

    public final bm p()
    {
        return b.f;
    }

    public final bm q()
    {
        return b.g;
    }

    public final bm r()
    {
        return b.h;
    }

    public final boolean s()
    {
        return c.e;
    }

    public final boolean t()
    {
        return b.i == null;
    }

    public final boolean u()
    {
        return e.a();
    }
}
