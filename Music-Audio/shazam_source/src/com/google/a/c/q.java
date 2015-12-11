// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

// Referenced classes of package com.google.a.c:
//            am, ap, ad, aw, 
//            bk

final class q extends am
{

    q(Comparator comparator)
    {
        super(comparator);
    }

    final int a(Object aobj[], int i)
    {
        return i;
    }

    final am a(Object obj, boolean flag)
    {
        return this;
    }

    final am a(Object obj, boolean flag, Object obj1, boolean flag1)
    {
        return this;
    }

    public final bk a()
    {
        return ap.a();
    }

    public final ad b()
    {
        return ad.d();
    }

    final am b(Object obj, boolean flag)
    {
        return this;
    }

    public final bk c()
    {
        return ap.a();
    }

    public final boolean contains(Object obj)
    {
        return false;
    }

    public final boolean containsAll(Collection collection)
    {
        return collection.isEmpty();
    }

    final am d()
    {
        return new q(aw.a(a).a());
    }

    public final Iterator descendingIterator()
    {
        return ap.a();
    }

    final boolean e()
    {
        return false;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof Set)
        {
            return ((Set)obj).isEmpty();
        } else
        {
            return false;
        }
    }

    public final Object first()
    {
        throw new NoSuchElementException();
    }

    public final int hashCode()
    {
        return 0;
    }

    public final boolean isEmpty()
    {
        return true;
    }

    public final Iterator iterator()
    {
        return ap.a();
    }

    public final Object last()
    {
        throw new NoSuchElementException();
    }

    public final int size()
    {
        return 0;
    }

    public final String toString()
    {
        return "[]";
    }
}
