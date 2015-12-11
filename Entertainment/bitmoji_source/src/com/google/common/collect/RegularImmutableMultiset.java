// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            ImmutableMultiset, ImmutableList, ImmutableSet, Hashing

class RegularImmutableMultiset extends ImmutableMultiset
{
    private final class ElementSet extends ImmutableSet.Indexed
    {

        final RegularImmutableMultiset this$0;

        public boolean contains(Object obj)
        {
            return RegularImmutableMultiset.this.contains(obj);
        }

        Object get(int i)
        {
            return entries[i].getElement();
        }

        boolean isPartialView()
        {
            return true;
        }

        public int size()
        {
            return entries.length;
        }

        private ElementSet()
        {
            this$0 = RegularImmutableMultiset.this;
            super();
        }

    }

    private static final class NonTerminalEntry extends Multisets.ImmutableEntry
    {

        private final Multisets.ImmutableEntry nextInBucket;

        public Multisets.ImmutableEntry nextInBucket()
        {
            return nextInBucket;
        }

        NonTerminalEntry(Object obj, int i, Multisets.ImmutableEntry immutableentry)
        {
            super(obj, i);
            nextInBucket = immutableentry;
        }
    }


    static final RegularImmutableMultiset EMPTY = new RegularImmutableMultiset(ImmutableList.of());
    private transient ImmutableSet elementSet;
    private final transient Multisets.ImmutableEntry entries[];
    private final transient int hashCode;
    private final transient Multisets.ImmutableEntry hashTable[];
    private final transient int size;

    RegularImmutableMultiset(Collection collection)
    {
        int i = collection.size();
        Multisets.ImmutableEntry aimmutableentry[] = new Multisets.ImmutableEntry[i];
        if (i == 0)
        {
            entries = aimmutableentry;
            hashTable = null;
            size = 0;
            hashCode = 0;
            elementSet = ImmutableSet.of();
            return;
        }
        int k = Hashing.closedTableSize(i, 1.0D);
        Multisets.ImmutableEntry aimmutableentry1[] = new Multisets.ImmutableEntry[k];
        i = 0;
        int j = 0;
        long l1 = 0L;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) 
        {
            collection = (Multiset.Entry)iterator.next();
            Object obj = Preconditions.checkNotNull(collection.getElement());
            int l = collection.getCount();
            int j1 = obj.hashCode();
            int i1 = Hashing.smear(j1) & k - 1;
            Multisets.ImmutableEntry immutableentry = aimmutableentry1[i1];
            if (immutableentry == null)
            {
                boolean flag;
                if ((collection instanceof Multisets.ImmutableEntry) && !(collection instanceof NonTerminalEntry))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    collection = (Multisets.ImmutableEntry)collection;
                } else
                {
                    collection = new Multisets.ImmutableEntry(obj, l);
                }
            } else
            {
                collection = new NonTerminalEntry(obj, l, immutableentry);
            }
            j += j1 ^ l;
            aimmutableentry[i] = collection;
            aimmutableentry1[i1] = collection;
            l1 += l;
            i++;
        }
        entries = aimmutableentry;
        hashTable = aimmutableentry1;
        size = Ints.saturatedCast(l1);
        hashCode = j;
    }

    public int count(Object obj)
    {
        Multisets.ImmutableEntry aimmutableentry[] = hashTable;
        if (obj != null && aimmutableentry != null)
        {
            Multisets.ImmutableEntry immutableentry = aimmutableentry[Hashing.smearedHash(obj) & aimmutableentry.length - 1];
            while (immutableentry != null) 
            {
                if (Objects.equal(obj, immutableentry.getElement()))
                {
                    return immutableentry.getCount();
                }
                immutableentry = immutableentry.nextInBucket();
            }
        }
        return 0;
    }

    public ImmutableSet elementSet()
    {
        ImmutableSet immutableset = elementSet;
        Object obj = immutableset;
        if (immutableset == null)
        {
            obj = new ElementSet();
            elementSet = ((ImmutableSet) (obj));
        }
        return ((ImmutableSet) (obj));
    }

    public volatile Set elementSet()
    {
        return elementSet();
    }

    Multiset.Entry getEntry(int i)
    {
        return entries[i];
    }

    public int hashCode()
    {
        return hashCode;
    }

    boolean isPartialView()
    {
        return false;
    }

    public int size()
    {
        return size;
    }


}
