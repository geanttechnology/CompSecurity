// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            Maps, Multiset, Iterators

public final class Sets
{
    static abstract class ImprovedAbstractSet extends AbstractSet
    {

        public boolean removeAll(Collection collection)
        {
            return Sets.removeAllImpl(this, collection);
        }

        public boolean retainAll(Collection collection)
        {
            return super.retainAll((Collection)Preconditions.checkNotNull(collection));
        }

        ImprovedAbstractSet()
        {
        }
    }


    private Sets()
    {
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
        set = set.iterator();
        int i = 0;
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
            i = ~~(i + j);
        }
        return i;
    }

    public static HashSet newHashSet()
    {
        return new HashSet();
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

    static boolean removeAllImpl(Set set, Collection collection)
    {
        Preconditions.checkNotNull(collection);
        Object obj = collection;
        if (collection instanceof Multiset)
        {
            obj = ((Multiset)collection).elementSet();
        }
        if ((obj instanceof Set) && ((Collection) (obj)).size() > set.size())
        {
            return Iterators.removeAll(set.iterator(), ((Collection) (obj)));
        } else
        {
            return removeAllImpl(set, ((Collection) (obj)).iterator());
        }
    }

    static boolean removeAllImpl(Set set, Iterator iterator)
    {
        boolean flag;
        for (flag = false; iterator.hasNext(); flag |= set.remove(iterator.next())) { }
        return flag;
    }
}
