// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            ImmutableSet, Iterables, Iterators, UnmodifiableIterator

final class ImmutableEnumSet extends ImmutableSet
{

    private final transient EnumSet _flddelegate;
    private transient int hashCode;

    private ImmutableEnumSet(EnumSet enumset)
    {
        _flddelegate = enumset;
    }

    static ImmutableSet asImmutable(EnumSet enumset)
    {
        switch (enumset.size())
        {
        default:
            return new ImmutableEnumSet(enumset);

        case 0: // '\0'
            return ImmutableSet.of();

        case 1: // '\001'
            return ImmutableSet.of(Iterables.getOnlyElement(enumset));
        }
    }

    public boolean contains(Object obj)
    {
        return _flddelegate.contains(obj);
    }

    public boolean containsAll(Collection collection)
    {
        return _flddelegate.containsAll(collection);
    }

    public boolean equals(Object obj)
    {
        return obj == this || _flddelegate.equals(obj);
    }

    public int hashCode()
    {
        int j = hashCode;
        int i = j;
        if (j == 0)
        {
            i = _flddelegate.hashCode();
            hashCode = i;
        }
        return i;
    }

    public boolean isEmpty()
    {
        return _flddelegate.isEmpty();
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
        return Iterators.unmodifiableIterator(_flddelegate.iterator());
    }

    public int size()
    {
        return _flddelegate.size();
    }

    public String toString()
    {
        return _flddelegate.toString();
    }
}
