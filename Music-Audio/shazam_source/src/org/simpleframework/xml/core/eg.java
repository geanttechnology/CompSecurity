// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.a.b;
import org.simpleframework.xml.b.d;
import org.simpleframework.xml.b.f;
import org.simpleframework.xml.b.g;
import org.simpleframework.xml.c.ag;
import org.simpleframework.xml.c.as;
import org.simpleframework.xml.c.i;
import org.simpleframework.xml.c.o;
import org.simpleframework.xml.s;

// Referenced classes of package org.simpleframework.xml.core:
//            ai, em, el, ej, 
//            dz, dd, dv, dp, 
//            l, bq, i, an, 
//            dx

final class eg
    implements ai
{

    private el a;
    private d b;
    private ej c;
    private dz d;
    private b e;

    public eg(d d1, ej ej1, dz dz1)
    {
        e = new em(this, ej1);
        a = new el(e);
        b = d1;
        c = ej1;
        d = dz1;
    }

    private dv h(Class class1)
    {
        return c.a(class1);
    }

    public final Class a(f f1, Object obj)
    {
        if (obj != null)
        {
            return obj.getClass();
        } else
        {
            return f1.C_();
        }
    }

    public final Object a(Object obj)
    {
        return d.get(obj);
    }

    public final String a(String s)
    {
        return a.a(s);
    }

    public final g a(f f1, o o1)
    {
        org.simpleframework.xml.c.y y = o1.f();
        if (y == null)
        {
            throw new dd("No attributes for %s", new Object[] {
                o1
            });
        } else
        {
            return b.a(f1, y);
        }
    }

    public final boolean a()
    {
        return d.b;
    }

    public final boolean a(Class class1)
    {
        return c.b(class1);
    }

    public final boolean a(f f1)
    {
        for (f1 = f1.C_(); f1 == java/lang/Double || f1 == java/lang/Float || f1 == Float.TYPE || f1 == Double.TYPE;)
        {
            return true;
        }

        return false;
    }

    public final boolean a(f f1, Object obj, ag ag1)
    {
        org.simpleframework.xml.c.y y = ag1.b();
        if (y == null)
        {
            throw new dd("No attributes for %s", new Object[] {
                ag1
            });
        } else
        {
            return b.a(f1, obj, y);
        }
    }

    public final as b()
    {
        return c.d.c;
    }

    public final bq b(Class class1)
    {
        return new br.a(c.a, class1);
    }

    public final boolean b(f f1)
    {
        return a(f1.C_());
    }

    public final String c(Class class1)
    {
        String s = c.a(class1).l();
        if (s != null)
        {
            class1 = s;
        } else
        {
            Class class2 = class1;
            if (class1.isArray())
            {
                class2 = class1.getComponentType();
            }
            String s1 = class2.getSimpleName();
            class1 = s1;
            if (!class2.isPrimitive())
            {
                return dp.a(s1);
            }
        }
        return class1;
    }

    public final dz c()
    {
        return d;
    }

    public final ej d()
    {
        return c;
    }

    public final org.simpleframework.xml.core.i d(Class class1)
    {
        return h(class1).a(this);
    }

    public final s e(Class class1)
    {
        return h(class1).h();
    }

    public final an f(Class class1)
    {
        return h(class1).f();
    }

    public final dx g(Class class1)
    {
        dv dv1 = h(class1);
        if (dv1 == null)
        {
            throw new dd("Invalid schema class %s", new Object[] {
                class1
            });
        } else
        {
            return new l(dv1, this);
        }
    }
}
