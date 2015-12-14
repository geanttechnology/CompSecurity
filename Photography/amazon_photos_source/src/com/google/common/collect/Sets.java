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
//            Maps, Multiset

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
        boolean flag1;
        if ((obj instanceof Set) && ((Collection) (obj)).size() > set.size())
        {
            set = set.iterator();
            boolean flag = false;
            do
            {
                flag1 = flag;
                if (!set.hasNext())
                {
                    break;
                }
                if (((Collection) (obj)).contains(set.next()))
                {
                    flag = true;
                    set.remove();
                }
            } while (true);
        } else
        {
            flag1 = removeAllImpl(set, ((Collection) (obj)).iterator());
        }
        return flag1;
    }

    static boolean removeAllImpl(Set set, Iterator iterator)
    {
        boolean flag;
        for (flag = false; iterator.hasNext(); flag |= set.remove(iterator.next())) { }
        return flag;
    }
}
