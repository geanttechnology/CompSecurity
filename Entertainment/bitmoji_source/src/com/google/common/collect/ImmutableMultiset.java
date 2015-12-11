// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            ImmutableCollection, Multiset, LinkedHashMultiset, RegularImmutableMultiset, 
//            Multisets, Iterators, ImmutableSet, Sets, 
//            UnmodifiableIterator

public abstract class ImmutableMultiset extends ImmutableCollection
    implements Multiset
{
    public static class Builder extends ImmutableCollection.Builder
    {

        final Multiset contents;

        public volatile ImmutableCollection.Builder add(Object obj)
        {
            return add(obj);
        }

        public volatile ImmutableCollection.Builder add(Object aobj[])
        {
            return add(aobj);
        }

        public Builder add(Object obj)
        {
            contents.add(Preconditions.checkNotNull(obj));
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

        public Builder addAll(Iterable iterable)
        {
            if (iterable instanceof Multiset)
            {
                Multiset.Entry entry;
                for (iterable = Multisets.cast(iterable).entrySet().iterator(); iterable.hasNext(); addCopies(entry.getElement(), entry.getCount()))
                {
                    entry = (Multiset.Entry)iterable.next();
                }

            } else
            {
                super.addAll(iterable);
            }
            return this;
        }

        public Builder addAll(Iterator iterator1)
        {
            super.addAll(iterator1);
            return this;
        }

        public Builder addCopies(Object obj, int i)
        {
            contents.add(Preconditions.checkNotNull(obj), i);
            return this;
        }

        public volatile ImmutableCollection build()
        {
            return build();
        }

        public ImmutableMultiset build()
        {
            return ImmutableMultiset.copyOf(contents);
        }

        public Builder setCount(Object obj, int i)
        {
            contents.setCount(Preconditions.checkNotNull(obj), i);
            return this;
        }

        public Builder()
        {
            this(((Multiset) (LinkedHashMultiset.create())));
        }

        Builder(Multiset multiset)
        {
            contents = multiset;
        }
    }

    private final class EntrySet extends ImmutableSet.Indexed
    {

        private static final long serialVersionUID = 0L;
        final ImmutableMultiset this$0;

        public boolean contains(Object obj)
        {
            if (obj instanceof Multiset.Entry)
            {
                obj = (Multiset.Entry)obj;
                break MISSING_BLOCK_LABEL_12;
            }
            do
            {
                return false;
            } while (((Multiset.Entry) (obj)).getCount() <= 0 || count(((Multiset.Entry) (obj)).getElement()) != ((Multiset.Entry) (obj)).getCount());
            return true;
        }

        Multiset.Entry get(int i)
        {
            return getEntry(i);
        }

        volatile Object get(int i)
        {
            return get(i);
        }

        public int hashCode()
        {
            return ImmutableMultiset.this.hashCode();
        }

        boolean isPartialView()
        {
            return ImmutableMultiset.this.isPartialView();
        }

        public int size()
        {
            return elementSet().size();
        }

        Object writeReplace()
        {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }

        private EntrySet()
        {
            this$0 = ImmutableMultiset.this;
            super();
        }

    }

    static class EntrySetSerializedForm
        implements Serializable
    {

        final ImmutableMultiset multiset;

        Object readResolve()
        {
            return multiset.entrySet();
        }

        EntrySetSerializedForm(ImmutableMultiset immutablemultiset)
        {
            multiset = immutablemultiset;
        }
    }

    private static class SerializedForm
        implements Serializable
    {

        private static final long serialVersionUID = 0L;
        final int counts[];
        final Object elements[];

        Object readResolve()
        {
            LinkedHashMultiset linkedhashmultiset = LinkedHashMultiset.create(elements.length);
            for (int i = 0; i < elements.length; i++)
            {
                linkedhashmultiset.add(elements[i], counts[i]);
            }

            return ImmutableMultiset.copyOf(linkedhashmultiset);
        }

        SerializedForm(Multiset multiset)
        {
            int i = multiset.entrySet().size();
            elements = new Object[i];
            counts = new int[i];
            i = 0;
            for (multiset = multiset.entrySet().iterator(); multiset.hasNext();)
            {
                Multiset.Entry entry = (Multiset.Entry)multiset.next();
                elements[i] = entry.getElement();
                counts[i] = entry.getCount();
                i++;
            }

        }
    }


    private transient ImmutableSet entrySet;

    ImmutableMultiset()
    {
    }

    public static Builder builder()
    {
        return new Builder();
    }

    private static transient ImmutableMultiset copyFromElements(Object aobj[])
    {
        LinkedHashMultiset linkedhashmultiset = LinkedHashMultiset.create();
        Collections.addAll(linkedhashmultiset, aobj);
        return copyFromEntries(linkedhashmultiset.entrySet());
    }

    static ImmutableMultiset copyFromEntries(Collection collection)
    {
        if (collection.isEmpty())
        {
            return of();
        } else
        {
            return new RegularImmutableMultiset(collection);
        }
    }

    public static ImmutableMultiset copyOf(Iterable iterable)
    {
        if (iterable instanceof ImmutableMultiset)
        {
            ImmutableMultiset immutablemultiset = (ImmutableMultiset)iterable;
            if (!immutablemultiset.isPartialView())
            {
                return immutablemultiset;
            }
        }
        if (iterable instanceof Multiset)
        {
            iterable = Multisets.cast(iterable);
        } else
        {
            iterable = LinkedHashMultiset.create(iterable);
        }
        return copyFromEntries(iterable.entrySet());
    }

    public static ImmutableMultiset copyOf(Iterator iterator1)
    {
        LinkedHashMultiset linkedhashmultiset = LinkedHashMultiset.create();
        Iterators.addAll(linkedhashmultiset, iterator1);
        return copyFromEntries(linkedhashmultiset.entrySet());
    }

    public static ImmutableMultiset copyOf(Object aobj[])
    {
        return copyFromElements(aobj);
    }

    private final ImmutableSet createEntrySet()
    {
        if (isEmpty())
        {
            return ImmutableSet.of();
        } else
        {
            return new EntrySet();
        }
    }

    public static ImmutableMultiset of()
    {
        return RegularImmutableMultiset.EMPTY;
    }

    public static ImmutableMultiset of(Object obj)
    {
        return copyFromElements(new Object[] {
            obj
        });
    }

    public static ImmutableMultiset of(Object obj, Object obj1)
    {
        return copyFromElements(new Object[] {
            obj, obj1
        });
    }

    public static ImmutableMultiset of(Object obj, Object obj1, Object obj2)
    {
        return copyFromElements(new Object[] {
            obj, obj1, obj2
        });
    }

    public static ImmutableMultiset of(Object obj, Object obj1, Object obj2, Object obj3)
    {
        return copyFromElements(new Object[] {
            obj, obj1, obj2, obj3
        });
    }

    public static ImmutableMultiset of(Object obj, Object obj1, Object obj2, Object obj3, Object obj4)
    {
        return copyFromElements(new Object[] {
            obj, obj1, obj2, obj3, obj4
        });
    }

    public static transient ImmutableMultiset of(Object obj, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object aobj[])
    {
        return (new Builder()).add(obj).add(obj1).add(obj2).add(obj3).add(obj4).add(obj5).add(aobj).build();
    }

    public final int add(Object obj, int i)
    {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object obj)
    {
        return count(obj) > 0;
    }

    int copyIntoArray(Object aobj[], int i)
    {
        for (UnmodifiableIterator unmodifiableiterator = entrySet().iterator(); unmodifiableiterator.hasNext();)
        {
            Multiset.Entry entry = (Multiset.Entry)unmodifiableiterator.next();
            Arrays.fill(aobj, i, entry.getCount() + i, entry.getElement());
            i += entry.getCount();
        }

        return i;
    }

    public ImmutableSet entrySet()
    {
        ImmutableSet immutableset1 = entrySet;
        ImmutableSet immutableset = immutableset1;
        if (immutableset1 == null)
        {
            immutableset = createEntrySet();
            entrySet = immutableset;
        }
        return immutableset;
    }

    public volatile Set entrySet()
    {
        return entrySet();
    }

    public boolean equals(Object obj)
    {
        return Multisets.equalsImpl(this, obj);
    }

    abstract Multiset.Entry getEntry(int i);

    public int hashCode()
    {
        return Sets.hashCodeImpl(entrySet());
    }

    public UnmodifiableIterator iterator()
    {
        return new UnmodifiableIterator() {

            Object element;
            int remaining;
            final ImmutableMultiset this$0;
            final Iterator val$entryIterator;

            public boolean hasNext()
            {
                return remaining > 0 || entryIterator.hasNext();
            }

            public Object next()
            {
                if (remaining <= 0)
                {
                    Multiset.Entry entry = (Multiset.Entry)entryIterator.next();
                    element = entry.getElement();
                    remaining = entry.getCount();
                }
                remaining = remaining - 1;
                return element;
            }

            
            {
                this$0 = ImmutableMultiset.this;
                entryIterator = iterator1;
                super();
            }
        };
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public final int remove(Object obj, int i)
    {
        throw new UnsupportedOperationException();
    }

    public final int setCount(Object obj, int i)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean setCount(Object obj, int i, int j)
    {
        throw new UnsupportedOperationException();
    }

    public String toString()
    {
        return entrySet().toString();
    }

    Object writeReplace()
    {
        return new SerializedForm(this);
    }
}
