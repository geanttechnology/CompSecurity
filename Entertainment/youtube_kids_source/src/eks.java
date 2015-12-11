// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;
import java.util.Set;

final class eks extends eiz
{

    final transient ekv a;
    private final transient eic b;

    eks(ekv ekv1, eic eic1)
    {
        a = ekv1;
        b = eic1;
    }

    static eic a(eks eks1)
    {
        return eks1.b;
    }

    private eiz a(int i, int j)
    {
        if (i == 0 && j == size())
        {
            return this;
        }
        if (i == j)
        {
            return a(comparator());
        }
        eje eje1 = a.a(i, j);
        eic eic1 = b.a(i, j);
        if (eje1.isEmpty())
        {
            return eiz.a(eje1.comparator());
        } else
        {
            return new eks((ekv)eje1, eic1);
        }
    }

    public final eiz a(Object obj, boolean flag)
    {
        return a(0, a.c(f.b(obj), flag));
    }

    public final eiz b(Object obj, boolean flag)
    {
        return a(a.d(f.b(obj), flag), size());
    }

    final eiu c()
    {
        return new ekt(this);
    }

    public final eiu d()
    {
        return a;
    }

    public final ehr f()
    {
        return b;
    }

    public final Object get(Object obj)
    {
        int i = a.a(obj);
        if (i == -1)
        {
            return null;
        } else
        {
            return b.get(i);
        }
    }

    public final Set keySet()
    {
        return a;
    }

    public final eje n_()
    {
        return a;
    }

    public final Collection values()
    {
        return b;
    }
}
