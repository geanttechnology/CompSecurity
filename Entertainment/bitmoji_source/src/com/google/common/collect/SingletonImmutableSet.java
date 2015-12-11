// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;

// Referenced classes of package com.google.common.collect:
//            ImmutableSet, Iterators, UnmodifiableIterator

final class SingletonImmutableSet extends ImmutableSet
{

    private transient int cachedHashCode;
    final transient Object element;

    SingletonImmutableSet(Object obj)
    {
        element = Preconditions.checkNotNull(obj);
    }

    SingletonImmutableSet(Object obj, int i)
    {
        element = obj;
        cachedHashCode = i;
    }

    public boolean contains(Object obj)
    {
        return element.equals(obj);
    }

    int copyIntoArray(Object aobj[], int i)
    {
        aobj[i] = element;
        return i + 1;
    }

    public final int hashCode()
    {
        int j = cachedHashCode;
        int i = j;
        if (j == 0)
        {
            i = element.hashCode();
            cachedHashCode = i;
        }
        return i;
    }

    boolean isHashCodeFast()
    {
        return cachedHashCode != 0;
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

    public String toString()
    {
        String s = element.toString();
        return (new StringBuilder(s.length() + 2)).append('[').append(s).append(']').toString();
    }
}
