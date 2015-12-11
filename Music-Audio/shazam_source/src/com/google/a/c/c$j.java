// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.Comparator;
import java.util.SortedSet;

// Referenced classes of package com.google.a.c:
//            c

private final class n extends n
    implements SortedSet
{

    final c a;

    public final Comparator comparator()
    {
        return ((SortedSet)super.c).comparator();
    }

    public final Object first()
    {
        a();
        return ((SortedSet)super.c).first();
    }

    public final SortedSet headSet(Object obj)
    {
        a();
        c c1 = a;
        Object obj1 = super.b;
        SortedSet sortedset = ((SortedSet)super.c).headSet(obj);
        if (super.d == null)
        {
            obj = this;
        } else
        {
            obj = super.d;
        }
        return new <init>(c1, obj1, sortedset, (() (obj)));
    }

    public final Object last()
    {
        a();
        return ((SortedSet)super.c).last();
    }

    public final SortedSet subSet(Object obj, Object obj1)
    {
        a();
        c c1 = a;
        Object obj2 = super.b;
        obj1 = ((SortedSet)super.c).subSet(obj, obj1);
        if (super.d == null)
        {
            obj = this;
        } else
        {
            obj = super.d;
        }
        return new <init>(c1, obj2, ((SortedSet) (obj1)), (() (obj)));
    }

    public final SortedSet tailSet(Object obj)
    {
        a();
        c c1 = a;
        Object obj1 = super.b;
        SortedSet sortedset = ((SortedSet)super.c).tailSet(obj);
        if (super.d == null)
        {
            obj = this;
        } else
        {
            obj = super.d;
        }
        return new <init>(c1, obj1, sortedset, (() (obj)));
    }

    n(c c1, Object obj, SortedSet sortedset,  )
    {
        a = c1;
        super(c1, obj, sortedset, );
    }
}
