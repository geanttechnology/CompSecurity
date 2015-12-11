// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            ImmutableCollection, RegularImmutableList, ObjectArrays, SingletonImmutableList, 
//            Collections2, Lists, UnmodifiableIterator, UnmodifiableListIterator, 
//            AbstractIndexedListIterator

public abstract class ImmutableList extends ImmutableCollection
    implements List, RandomAccess
{
    public static final class Builder extends ImmutableCollection.ArrayBasedBuilder
    {

        public volatile ImmutableCollection.ArrayBasedBuilder add(Object obj)
        {
            return add(obj);
        }

        public volatile ImmutableCollection.Builder add(Object obj)
        {
            return add(obj);
        }

        public Builder add(Object obj)
        {
            super.add(obj);
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
            super.addAll(iterable);
            return this;
        }

        public Builder addAll(Iterator iterator1)
        {
            super.addAll(iterator1);
            return this;
        }

        public ImmutableList build()
        {
            return ImmutableList.asImmutableList(contents, size);
        }

        public Builder()
        {
            this(4);
        }

        Builder(int i)
        {
            super(i);
        }
    }

    class SubList extends ImmutableList
    {

        final transient int length;
        final transient int offset;
        final ImmutableList this$0;

        public Object get(int i)
        {
            Preconditions.checkElementIndex(i, length);
            return ImmutableList.this.get(offset + i);
        }

        boolean isPartialView()
        {
            return true;
        }

        public volatile Iterator iterator()
        {
            return iterator();
        }

        public volatile ListIterator listIterator()
        {
            return listIterator();
        }

        public volatile ListIterator listIterator(int i)
        {
            return listIterator(i);
        }

        public int size()
        {
            return length;
        }

        public volatile List subList(int i, int j)
        {
            return subList(i, j);
        }

        public ImmutableList subList(int i, int j)
        {
            Preconditions.checkPositionIndexes(i, j, length);
            return ImmutableList.this.subList(offset + i, offset + j);
        }

        SubList(int i, int j)
        {
            this$0 = ImmutableList.this;
            super();
            offset = i;
            length = j;
        }
    }


    private static final ImmutableList EMPTY;

    ImmutableList()
    {
    }

    static ImmutableList asImmutableList(Object aobj[])
    {
        return asImmutableList(aobj, aobj.length);
    }

    static ImmutableList asImmutableList(Object aobj[], int i)
    {
        switch (i)
        {
        default:
            Object aobj1[] = aobj;
            if (i < aobj.length)
            {
                aobj1 = ObjectArrays.arraysCopyOf(aobj, i);
            }
            return new RegularImmutableList(aobj1);

        case 0: // '\0'
            return of();

        case 1: // '\001'
            return new SingletonImmutableList(aobj[0]);
        }
    }

    public static Builder builder()
    {
        return new Builder();
    }

    private static transient ImmutableList construct(Object aobj[])
    {
        return asImmutableList(ObjectArrays.checkElementsNotNull(aobj));
    }

    public static ImmutableList copyOf(Iterable iterable)
    {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof Collection)
        {
            return copyOf(Collections2.cast(iterable));
        } else
        {
            return copyOf(iterable.iterator());
        }
    }

    public static ImmutableList copyOf(Collection collection)
    {
        if (collection instanceof ImmutableCollection)
        {
            ImmutableList immutablelist = ((ImmutableCollection)collection).asList();
            collection = immutablelist;
            if (immutablelist.isPartialView())
            {
                collection = asImmutableList(immutablelist.toArray());
            }
            return collection;
        } else
        {
            return construct(collection.toArray());
        }
    }

    public static ImmutableList copyOf(Iterator iterator1)
    {
        if (!iterator1.hasNext())
        {
            return of();
        }
        Object obj = iterator1.next();
        if (!iterator1.hasNext())
        {
            return of(obj);
        } else
        {
            return (new Builder()).add(obj).addAll(iterator1).build();
        }
    }

    public static ImmutableList copyOf(Object aobj[])
    {
        switch (aobj.length)
        {
        default:
            return new RegularImmutableList(ObjectArrays.checkElementsNotNull((Object[])((Object []) (aobj)).clone()));

        case 0: // '\0'
            return of();

        case 1: // '\001'
            return new SingletonImmutableList(aobj[0]);
        }
    }

    public static ImmutableList of()
    {
        return EMPTY;
    }

    public static ImmutableList of(Object obj)
    {
        return new SingletonImmutableList(obj);
    }

    public static ImmutableList of(Object obj, Object obj1)
    {
        return construct(new Object[] {
            obj, obj1
        });
    }

    public static ImmutableList of(Object obj, Object obj1, Object obj2)
    {
        return construct(new Object[] {
            obj, obj1, obj2
        });
    }

    public final void add(int i, Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(int i, Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public final ImmutableList asList()
    {
        return this;
    }

    public boolean contains(Object obj)
    {
        return indexOf(obj) >= 0;
    }

    int copyIntoArray(Object aobj[], int i)
    {
        int k = size();
        for (int j = 0; j < k; j++)
        {
            aobj[i + j] = get(j);
        }

        return i + k;
    }

    public boolean equals(Object obj)
    {
        return Lists.equalsImpl(this, obj);
    }

    public int hashCode()
    {
        int j = 1;
        int k = size();
        for (int i = 0; i < k; i++)
        {
            j = ~~(j * 31 + get(i).hashCode());
        }

        return j;
    }

    public int indexOf(Object obj)
    {
        if (obj == null)
        {
            return -1;
        } else
        {
            return Lists.indexOfImpl(this, obj);
        }
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public UnmodifiableIterator iterator()
    {
        return listIterator();
    }

    public int lastIndexOf(Object obj)
    {
        if (obj == null)
        {
            return -1;
        } else
        {
            return Lists.lastIndexOfImpl(this, obj);
        }
    }

    public volatile ListIterator listIterator()
    {
        return listIterator();
    }

    public volatile ListIterator listIterator(int i)
    {
        return listIterator(i);
    }

    public UnmodifiableListIterator listIterator()
    {
        return listIterator(0);
    }

    public UnmodifiableListIterator listIterator(int i)
    {
        return new AbstractIndexedListIterator(size(), i) {

            final ImmutableList this$0;

            protected Object get(int j)
            {
                return ImmutableList.this.get(j);
            }

            
            {
                this$0 = ImmutableList.this;
                super(i, j);
            }
        };
    }

    public final Object remove(int i)
    {
        throw new UnsupportedOperationException();
    }

    public final Object set(int i, Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public volatile List subList(int i, int j)
    {
        return subList(i, j);
    }

    public ImmutableList subList(int i, int j)
    {
        Preconditions.checkPositionIndexes(i, j, size());
        switch (j - i)
        {
        default:
            return subListUnchecked(i, j);

        case 0: // '\0'
            return of();

        case 1: // '\001'
            return of(get(i));
        }
    }

    ImmutableList subListUnchecked(int i, int j)
    {
        return new SubList(i, j - i);
    }

    static 
    {
        EMPTY = new RegularImmutableList(ObjectArrays.EMPTY_ARRAY);
    }
}
