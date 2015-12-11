// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.b.f;
import org.simpleframework.xml.c.ag;
import org.simpleframework.xml.c.as;
import org.simpleframework.xml.c.o;

// Referenced classes of package org.simpleframework.xml.core:
//            ai, m, du, s, 
//            an

final class es
{

    private final ai a;
    private final as b;

    public es(ai ai1)
    {
        b = ai1.b();
        a = ai1;
    }

    private static f c(Class class1)
    {
        return new m(class1);
    }

    final Object a(Class class1, Object obj)
    {
        if (b(class1) == null)
        {
            throw new du("Root annotation required for %s", new Object[] {
                class1
            });
        } else
        {
            return obj;
        }
    }

    public final Object a(o o, Class class1)
    {
        o = ((o) (a(class1).a(o)));
        if (o != null)
        {
            return a(o.getClass(), o);
        } else
        {
            return null;
        }
    }

    final s a(Class class1)
    {
        f f = c(class1);
        if (class1 == null)
        {
            throw new du("Can not instantiate null class", new Object[0]);
        } else
        {
            return new s(a, f);
        }
    }

    public final void a(ag ag1, Object obj, Class class1, String s1)
    {
        ag1 = ag1.c(s1);
        class1 = c(class1);
        if (obj != null)
        {
            s1 = obj.getClass();
            an an1 = a.f(s1);
            if (an1 != null)
            {
                an1.a(ag1);
            }
            if (!a.a(class1, obj, ag1))
            {
                a(((Class) (s1))).a(ag1, obj);
            }
        }
        ag1.j();
    }

    final String b(Class class1)
    {
        class1 = a.c(class1);
        return b.b(class1);
    }
}
