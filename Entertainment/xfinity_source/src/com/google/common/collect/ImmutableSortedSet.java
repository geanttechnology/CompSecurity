// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

// Referenced classes of package com.google.common.collect:
//            ImmutableSortedSetFauxverideShim, SortedIterable, Ordering, EmptyImmutableSortedSet, 
//            SortedIterables, ImmutableList, RegularImmutableSortedSet, UnmodifiableIterator

public abstract class ImmutableSortedSet extends ImmutableSortedSetFauxverideShim
    implements SortedIterable, SortedSet
{
    public static final class Builder extends ImmutableSet.Builder
    {

        private final Comparator comparator;

        public volatile ImmutableCollection.Builder add(Object obj)
        {
            return add(obj);
        }

        public volatile ImmutableCollection.Builder add(Object aobj[])
        {
            return add(aobj);
        }

        public volatile ImmutableSet.Builder add(Object obj)
        {
            return add(obj);
        }

        public volatile ImmutableSet.Builder add(Object aobj[])
        {
            return add(aobj);
        }

        public Builder add(Object obj)
        {
            super.add(obj);
            return this;
        }

        public transient Builder add(Object aobj[])
        {
            super.add(aobj);
            return this;
        }

        public ImmutableSortedSet build()
        {
            return ImmutableSortedSet.copyOfInternal(comparator, contents.iterator());
        }

        public Builder(Comparator comparator1)
        {
            comparator = (Comparator)Preconditions.checkNotNull(comparator1);
        }
    }

    private static class SerializedForm
        implements Serializable
    {

        final Comparator comparator;
        final Object elements[];

        Object readResolve()
        {
            return (new Builder(comparator)).add((Object[])elements).build();
        }

        public SerializedForm(Comparator comparator1, Object aobj[])
        {
            comparator = comparator1;
            elements = aobj;
        }
    }


    private static final ImmutableSortedSet NATURAL_EMPTY_SET;
    private static final Comparator NATURAL_ORDER;
    final transient Comparator comparator;

    ImmutableSortedSet(Comparator comparator1)
    {
        comparator = comparator1;
    }

    private static ImmutableSortedSet copyOfInternal(Comparator comparator1, Iterator iterator1)
    {
        iterator1 = ImmutableList.copyOf(SortedIterables.sortedUnique(comparator1, iterator1));
        if (iterator1.isEmpty())
        {
            return emptySet(comparator1);
        } else
        {
            return new RegularImmutableSortedSet(iterator1, comparator1);
        }
    }

    private static ImmutableSortedSet emptySet()
    {
        return NATURAL_EMPTY_SET;
    }

    static ImmutableSortedSet emptySet(Comparator comparator1)
    {
        if (NATURAL_ORDER.equals(comparator1))
        {
            return emptySet();
        } else
        {
            return new EmptyImmutableSortedSet(comparator1);
        }
    }

    private void readObject(ObjectInputStream objectinputstream)
        throws InvalidObjectException
    {
        throw new InvalidObjectException("Use SerializedForm");
    }

    static int unsafeCompare(Comparator comparator1, Object obj, Object obj1)
    {
        return comparator1.compare(obj, obj1);
    }

    public Comparator comparator()
    {
        return comparator;
    }

    public ImmutableSortedSet headSet(Object obj)
    {
        return headSet(obj, false);
    }

    ImmutableSortedSet headSet(Object obj, boolean flag)
    {
        return headSetImpl(Preconditions.checkNotNull(obj), flag);
    }

    public volatile SortedSet headSet(Object obj)
    {
        return headSet(obj);
    }

    abstract ImmutableSortedSet headSetImpl(Object obj, boolean flag);

    abstract int indexOf(Object obj);

    public abstract UnmodifiableIterator iterator();

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public ImmutableSortedSet subSet(Object obj, Object obj1)
    {
        return subSet(obj, true, obj1, false);
    }

    ImmutableSortedSet subSet(Object obj, boolean flag, Object obj1, boolean flag1)
    {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj1);
        boolean flag2;
        if (comparator.compare(obj, obj1) <= 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        Preconditions.checkArgument(flag2);
        return subSetImpl(obj, flag, obj1, flag1);
    }

    public volatile SortedSet subSet(Object obj, Object obj1)
    {
        return subSet(obj, obj1);
    }

    abstract ImmutableSortedSet subSetImpl(Object obj, boolean flag, Object obj1, boolean flag1);

    public ImmutableSortedSet tailSet(Object obj)
    {
        return tailSet(obj, true);
    }

    ImmutableSortedSet tailSet(Object obj, boolean flag)
    {
        return tailSetImpl(Preconditions.checkNotNull(obj), flag);
    }

    public volatile SortedSet tailSet(Object obj)
    {
        return tailSet(obj);
    }

    abstract ImmutableSortedSet tailSetImpl(Object obj, boolean flag);

    int unsafeCompare(Object obj, Object obj1)
    {
        return unsafeCompare(comparator, obj, obj1);
    }

    Object writeReplace()
    {
        return new SerializedForm(comparator, toArray());
    }

    static 
    {
        NATURAL_ORDER = Ordering.natural();
        NATURAL_EMPTY_SET = new EmptyImmutableSortedSet(NATURAL_ORDER);
    }

}
