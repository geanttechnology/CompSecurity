// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

// Referenced classes of package com.google.common.collect:
//            Collections2, Maps, Iterators

public final class Sets
{
    public static abstract class SetView extends AbstractSet
    {

        private SetView()
        {
        }

    }


    public static SetView difference(Set set, Set set1)
    {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set1, "set2");
        return new SetView(set, Predicates.not(Predicates.in(set1)), set1) {

            final Predicate val$notInSet2;
            final Set val$set1;
            final Set val$set2;

            public boolean contains(Object obj)
            {
                return set1.contains(obj) && !set2.contains(obj);
            }

            public boolean isEmpty()
            {
                return set2.containsAll(set1);
            }

            public Iterator iterator()
            {
                return Iterators.filter(set1.iterator(), notInSet2);
            }

            public int size()
            {
                return Iterators.size(iterator());
            }

            
            {
                set1 = set;
                notInSet2 = predicate;
                set2 = set3;
                super();
            }
        };
    }

    static boolean equalsImpl(Set set, Object obj)
    {
        boolean flag;
        boolean flag1;
        flag1 = true;
        flag = false;
        if (set != obj) goto _L2; else goto _L1
_L1:
        flag = true;
_L4:
        return flag;
_L2:
        if (!(obj instanceof Set)) goto _L4; else goto _L3
_L3:
        obj = (Set)obj;
        if (set.size() != ((Set) (obj)).size()) goto _L6; else goto _L5
_L5:
        flag = set.containsAll(((Collection) (obj)));
        if (!flag) goto _L6; else goto _L7
_L7:
        flag = flag1;
_L9:
        return flag;
_L6:
        flag = false;
        if (true) goto _L9; else goto _L8
_L8:
        set;
        return false;
        set;
        return false;
    }

    static int hashCodeImpl(Set set)
    {
        int i = 0;
        set = set.iterator();
        while (set.hasNext()) 
        {
            Object obj = set.next();
            int j;
            if (obj != null)
            {
                j = obj.hashCode();
            } else
            {
                j = 0;
            }
            i += j;
        }
        return i;
    }

    public static SetView intersection(Set set, Set set1)
    {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set1, "set2");
        return new SetView(set, Predicates.in(set1), set1) {

            final Predicate val$inSet2;
            final Set val$set1;
            final Set val$set2;

            public boolean contains(Object obj)
            {
                return set1.contains(obj) && set2.contains(obj);
            }

            public boolean containsAll(Collection collection)
            {
                return set1.containsAll(collection) && set2.containsAll(collection);
            }

            public boolean isEmpty()
            {
                return !iterator().hasNext();
            }

            public Iterator iterator()
            {
                return Iterators.filter(set1.iterator(), inSet2);
            }

            public int size()
            {
                return Iterators.size(iterator());
            }

            
            {
                set1 = set;
                inSet2 = predicate;
                set2 = set3;
                super();
            }
        };
    }

    public static HashSet newHashSet()
    {
        return new HashSet();
    }

    public static HashSet newHashSet(Iterable iterable)
    {
        if (iterable instanceof Collection)
        {
            return new HashSet(Collections2.cast(iterable));
        } else
        {
            return newHashSet(iterable.iterator());
        }
    }

    public static HashSet newHashSet(Iterator iterator)
    {
        HashSet hashset = newHashSet();
        for (; iterator.hasNext(); hashset.add(iterator.next())) { }
        return hashset;
    }

    public static transient HashSet newHashSet(Object aobj[])
    {
        HashSet hashset = newHashSetWithExpectedSize(aobj.length);
        Collections.addAll(hashset, aobj);
        return hashset;
    }

    public static HashSet newHashSetWithExpectedSize(int i)
    {
        return new HashSet(Maps.capacity(i));
    }

    public static LinkedHashSet newLinkedHashSet()
    {
        return new LinkedHashSet();
    }

    public static TreeSet newTreeSet(Comparator comparator)
    {
        return new TreeSet((Comparator)Preconditions.checkNotNull(comparator));
    }

    public static SetView union(Set set, Set set1)
    {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set1, "set2");
        return new SetView(set, difference(set1, set), set1) {

            final Set val$set1;
            final Set val$set2;
            final Set val$set2minus1;

            public boolean contains(Object obj)
            {
                return set1.contains(obj) || set2.contains(obj);
            }

            public boolean isEmpty()
            {
                return set1.isEmpty() && set2.isEmpty();
            }

            public Iterator iterator()
            {
                return Iterators.unmodifiableIterator(Iterators.concat(set1.iterator(), set2minus1.iterator()));
            }

            public int size()
            {
                return set1.size() + set2minus1.size();
            }

            
            {
                set1 = set;
                set2minus1 = set3;
                set2 = set4;
                super();
            }
        };
    }
}
