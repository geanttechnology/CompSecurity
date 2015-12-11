// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

// Referenced classes of package com.google.common.collect:
//            ImmutableSortedSetFauxverideShim, SortedIterable, Ordering, RegularImmutableSortedSet, 
//            ImmutableList, ObjectArrays, SortedIterables, Iterables, 
//            DescendingImmutableSortedSet, UnmodifiableIterator, Iterators, ImmutableCollection, 
//            ImmutableSet

public abstract class ImmutableSortedSet extends ImmutableSortedSetFauxverideShim
    implements NavigableSet, SortedIterable
{
    public static final class Builder extends ImmutableSet.Builder
    {

        private final Comparator comparator;

        public volatile ImmutableCollection.ArrayBasedBuilder add(Object obj)
        {
            return add(obj);
        }

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

        public volatile ImmutableCollection.Builder addAll(Iterable iterable)
        {
            return addAll(iterable);
        }

        public volatile ImmutableCollection.Builder addAll(Iterator iterator1)
        {
            return addAll(iterator1);
        }

        public volatile ImmutableSet.Builder addAll(Iterable iterable)
        {
            return addAll(iterable);
        }

        public volatile ImmutableSet.Builder addAll(Iterator iterator1)
        {
            return addAll(iterator1);
        }

        public Builder addAll(Iterable iterable)
        {
            super.addAll(iterable);
            return this;
        }

        public Builder addAll(Iterator iterator1)
        {
            super.addAll(iterator1);
            return this;
        }

        public volatile ImmutableCollection build()
        {
            return build();
        }

        public volatile ImmutableSet build()
        {
            return build();
        }

        public ImmutableSortedSet build()
        {
            Object aobj[] = (Object[])contents;
            ImmutableSortedSet immutablesortedset = ImmutableSortedSet.construct(comparator, size, aobj);
            size = immutablesortedset.size();
            return immutablesortedset;
        }

        public Builder(Comparator comparator1)
        {
            comparator = (Comparator)Preconditions.checkNotNull(comparator1);
        }
    }

    private static class SerializedForm
        implements Serializable
    {

        private static final long serialVersionUID = 0L;
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


    private static final RegularImmutableSortedSet NATURAL_EMPTY_SET;
    private static final Comparator NATURAL_ORDER;
    final transient Comparator comparator;
    transient ImmutableSortedSet descendingSet;

    ImmutableSortedSet(Comparator comparator1)
    {
        comparator = comparator1;
    }

    static transient ImmutableSortedSet construct(Comparator comparator1, int i, Object aobj[])
    {
        if (i == 0)
        {
            return emptySet(comparator1);
        }
        ObjectArrays.checkElementsNotNull(aobj, i);
        Arrays.sort(aobj, 0, i, comparator1);
        int k = 1;
        int j = 1;
        for (; k < i; k++)
        {
            Object obj = aobj[k];
            if (comparator1.compare(obj, aobj[j - 1]) != 0)
            {
                int l = j + 1;
                aobj[j] = obj;
                j = l;
            }
        }

        Arrays.fill(aobj, j, i, null);
        return new RegularImmutableSortedSet(ImmutableList.asImmutableList(aobj, j), comparator1);
    }

    public static ImmutableSortedSet copyOf(Iterable iterable)
    {
        return copyOf(((Comparator) (Ordering.natural())), iterable);
    }

    public static ImmutableSortedSet copyOf(Collection collection)
    {
        return copyOf(((Comparator) (Ordering.natural())), collection);
    }

    public static ImmutableSortedSet copyOf(Comparator comparator1, Iterable iterable)
    {
        Preconditions.checkNotNull(comparator1);
        if (SortedIterables.hasSameComparator(comparator1, iterable) && (iterable instanceof ImmutableSortedSet))
        {
            ImmutableSortedSet immutablesortedset = (ImmutableSortedSet)iterable;
            if (!immutablesortedset.isPartialView())
            {
                return immutablesortedset;
            }
        }
        iterable = ((Iterable) ((Object[])Iterables.toArray(iterable)));
        return construct(comparator1, iterable.length, iterable);
    }

    public static ImmutableSortedSet copyOf(Comparator comparator1, Collection collection)
    {
        return copyOf(comparator1, ((Iterable) (collection)));
    }

    public static ImmutableSortedSet copyOf(Comparator comparator1, Iterator iterator1)
    {
        return (new Builder(comparator1)).addAll(iterator1).build();
    }

    public static ImmutableSortedSet copyOf(Iterator iterator1)
    {
        return copyOf(((Comparator) (Ordering.natural())), iterator1);
    }

    public static ImmutableSortedSet copyOf(Comparable acomparable[])
    {
        return construct(Ordering.natural(), acomparable.length, (Object[])acomparable.clone());
    }

    public static ImmutableSortedSet copyOfSorted(SortedSet sortedset)
    {
        Comparator comparator1 = SortedIterables.comparator(sortedset);
        sortedset = ImmutableList.copyOf(sortedset);
        if (sortedset.isEmpty())
        {
            return emptySet(comparator1);
        } else
        {
            return new RegularImmutableSortedSet(sortedset, comparator1);
        }
    }

    static RegularImmutableSortedSet emptySet(Comparator comparator1)
    {
        if (NATURAL_ORDER.equals(comparator1))
        {
            return NATURAL_EMPTY_SET;
        } else
        {
            return new RegularImmutableSortedSet(ImmutableList.of(), comparator1);
        }
    }

    public static Builder naturalOrder()
    {
        return new Builder(Ordering.natural());
    }

    public static ImmutableSortedSet of()
    {
        return NATURAL_EMPTY_SET;
    }

    public static ImmutableSortedSet of(Comparable comparable)
    {
        return new RegularImmutableSortedSet(ImmutableList.of(comparable), Ordering.natural());
    }

    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable1)
    {
        return construct(Ordering.natural(), 2, new Comparable[] {
            comparable, comparable1
        });
    }

    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable1, Comparable comparable2)
    {
        return construct(Ordering.natural(), 3, new Comparable[] {
            comparable, comparable1, comparable2
        });
    }

    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable1, Comparable comparable2, Comparable comparable3)
    {
        return construct(Ordering.natural(), 4, new Comparable[] {
            comparable, comparable1, comparable2, comparable3
        });
    }

    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable1, Comparable comparable2, Comparable comparable3, Comparable comparable4)
    {
        return construct(Ordering.natural(), 5, new Comparable[] {
            comparable, comparable1, comparable2, comparable3, comparable4
        });
    }

    public static transient ImmutableSortedSet of(Comparable comparable, Comparable comparable1, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable acomparable[])
    {
        Comparable acomparable1[] = new Comparable[acomparable.length + 6];
        acomparable1[0] = comparable;
        acomparable1[1] = comparable1;
        acomparable1[2] = comparable2;
        acomparable1[3] = comparable3;
        acomparable1[4] = comparable4;
        acomparable1[5] = comparable5;
        System.arraycopy(acomparable, 0, acomparable1, 6, acomparable.length);
        return construct(Ordering.natural(), acomparable1.length, (Comparable[])acomparable1);
    }

    public static Builder orderedBy(Comparator comparator1)
    {
        return new Builder(comparator1);
    }

    private void readObject(ObjectInputStream objectinputstream)
        throws InvalidObjectException
    {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static Builder reverseOrder()
    {
        return new Builder(Ordering.natural().reverse());
    }

    static int unsafeCompare(Comparator comparator1, Object obj, Object obj1)
    {
        return comparator1.compare(obj, obj1);
    }

    public Object ceiling(Object obj)
    {
        return Iterables.getFirst(tailSet(obj, true), null);
    }

    public Comparator comparator()
    {
        return comparator;
    }

    ImmutableSortedSet createDescendingSet()
    {
        return new DescendingImmutableSortedSet(this);
    }

    public abstract UnmodifiableIterator descendingIterator();

    public volatile Iterator descendingIterator()
    {
        return descendingIterator();
    }

    public ImmutableSortedSet descendingSet()
    {
        ImmutableSortedSet immutablesortedset1 = descendingSet;
        ImmutableSortedSet immutablesortedset = immutablesortedset1;
        if (immutablesortedset1 == null)
        {
            immutablesortedset = createDescendingSet();
            descendingSet = immutablesortedset;
            immutablesortedset.descendingSet = this;
        }
        return immutablesortedset;
    }

    public volatile NavigableSet descendingSet()
    {
        return descendingSet();
    }

    public Object first()
    {
        return iterator().next();
    }

    public Object floor(Object obj)
    {
        return Iterators.getNext(headSet(obj, true).descendingIterator(), null);
    }

    public ImmutableSortedSet headSet(Object obj)
    {
        return headSet(obj, false);
    }

    public ImmutableSortedSet headSet(Object obj, boolean flag)
    {
        return headSetImpl(Preconditions.checkNotNull(obj), flag);
    }

    public volatile NavigableSet headSet(Object obj, boolean flag)
    {
        return headSet(obj, flag);
    }

    public volatile SortedSet headSet(Object obj)
    {
        return headSet(obj);
    }

    abstract ImmutableSortedSet headSetImpl(Object obj, boolean flag);

    public Object higher(Object obj)
    {
        return Iterables.getFirst(tailSet(obj, false), null);
    }

    abstract int indexOf(Object obj);

    public abstract UnmodifiableIterator iterator();

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public Object last()
    {
        return descendingIterator().next();
    }

    public Object lower(Object obj)
    {
        return Iterators.getNext(headSet(obj, false).descendingIterator(), null);
    }

    public final Object pollFirst()
    {
        throw new UnsupportedOperationException();
    }

    public final Object pollLast()
    {
        throw new UnsupportedOperationException();
    }

    public ImmutableSortedSet subSet(Object obj, Object obj1)
    {
        return subSet(obj, true, obj1, false);
    }

    public ImmutableSortedSet subSet(Object obj, boolean flag, Object obj1, boolean flag1)
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

    public volatile NavigableSet subSet(Object obj, boolean flag, Object obj1, boolean flag1)
    {
        return subSet(obj, flag, obj1, flag1);
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

    public ImmutableSortedSet tailSet(Object obj, boolean flag)
    {
        return tailSetImpl(Preconditions.checkNotNull(obj), flag);
    }

    public volatile NavigableSet tailSet(Object obj, boolean flag)
    {
        return tailSet(obj, flag);
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
        NATURAL_EMPTY_SET = new RegularImmutableSortedSet(ImmutableList.of(), NATURAL_ORDER);
    }
}
