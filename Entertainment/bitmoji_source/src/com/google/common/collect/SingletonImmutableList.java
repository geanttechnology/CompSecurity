// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.common.collect:
//            ImmutableList, Iterators, UnmodifiableIterator

final class SingletonImmutableList extends ImmutableList
{

    final transient Object element;

    SingletonImmutableList(Object obj)
    {
        element = Preconditions.checkNotNull(obj);
    }

    public Object get(int i)
    {
        Preconditions.checkElementIndex(i, 1);
        return element;
    }

    boolean isPartialView()
    {
        return false;
    }

    public UnmodifiableIterator iterator()
    {
        return Iterators.singletonIterator(element);
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public int size()
    {
        return 1;
    }

    public ImmutableList subList(int i, int j)
    {
        Preconditions.checkPositionIndexes(i, j, 1);
        Object obj = this;
        if (i == j)
        {
            obj = ImmutableList.of();
        }
        return ((ImmutableList) (obj));
    }

    public volatile List subList(int i, int j)
    {
        return subList(i, j);
    }

    public String toString()
    {
        String s = element.toString();
        return (new StringBuilder(s.length() + 2)).append('[').append(s).append(']').toString();
    }
}
