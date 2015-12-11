// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Comparator;
import java.util.SortedSet;

final class egw extends egr
    implements SortedSet
{

    private egi e;

    egw(egi egi, Object obj, SortedSet sortedset, egr egr1)
    {
        e = egi;
        super(egi, obj, sortedset, egr1);
    }

    private SortedSet d()
    {
        return (SortedSet)super.b;
    }

    public final Comparator comparator()
    {
        return d().comparator();
    }

    public final Object first()
    {
        a();
        return d().first();
    }

    public final SortedSet headSet(Object obj)
    {
        a();
        egi egi = e;
        Object obj1 = super.a;
        SortedSet sortedset = d().headSet(obj);
        if (super.c == null)
        {
            obj = this;
        } else
        {
            obj = super.c;
        }
        return new egw(egi, obj1, sortedset, ((egr) (obj)));
    }

    public final Object last()
    {
        a();
        return d().last();
    }

    public final SortedSet subSet(Object obj, Object obj1)
    {
        a();
        egi egi = e;
        Object obj2 = super.a;
        obj1 = d().subSet(obj, obj1);
        if (super.c == null)
        {
            obj = this;
        } else
        {
            obj = super.c;
        }
        return new egw(egi, obj2, ((SortedSet) (obj1)), ((egr) (obj)));
    }

    public final SortedSet tailSet(Object obj)
    {
        a();
        egi egi = e;
        Object obj1 = super.a;
        SortedSet sortedset = d().tailSet(obj);
        if (super.c == null)
        {
            obj = this;
        } else
        {
            obj = super.c;
        }
        return new egw(egi, obj1, sortedset, ((egr) (obj)));
    }
}
