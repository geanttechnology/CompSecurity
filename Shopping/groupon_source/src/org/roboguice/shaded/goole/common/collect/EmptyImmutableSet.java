// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            ImmutableSet, ImmutableList, Iterators, UnmodifiableIterator

final class EmptyImmutableSet extends ImmutableSet
{

    static final EmptyImmutableSet INSTANCE = new EmptyImmutableSet();

    private EmptyImmutableSet()
    {
    }

    public ImmutableList asList()
    {
        return ImmutableList.of();
    }

    public boolean contains(Object obj)
    {
        return false;
    }

    public boolean containsAll(Collection collection)
    {
        return collection.isEmpty();
    }

    int copyIntoArray(Object aobj[], int i)
    {
        return i;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Set)
        {
            return ((Set)obj).isEmpty();
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return 0;
    }

    public boolean isEmpty()
    {
        return true;
    }

    boolean isHashCodeFast()
    {
        return true;
    }

    boolean isPartialView()
    {
        return false;
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public UnmodifiableIterator iterator()
    {
        return Iterators.emptyIterator();
    }

    public int size()
    {
        return 0;
    }

    public String toString()
    {
        return "[]";
    }

}
