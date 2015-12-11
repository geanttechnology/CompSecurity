// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;

// Referenced classes of package com.google.common.collect:
//            ImmutableSet, ImmutableMap, RegularImmutableAsList, ImmutableList, 
//            UnmodifiableIterator

abstract class ImmutableMapEntrySet extends ImmutableSet
{
    private static class EntrySetSerializedForm
        implements Serializable
    {

        private static final long serialVersionUID = 0L;
        final ImmutableMap map;

        Object readResolve()
        {
            return map.entrySet();
        }

        EntrySetSerializedForm(ImmutableMap immutablemap)
        {
            map = immutablemap;
        }
    }

    static final class RegularEntrySet extends ImmutableMapEntrySet
    {

        private final transient java.util.Map.Entry entries[];
        private final transient ImmutableMap map;

        ImmutableList createAsList()
        {
            return new RegularImmutableAsList(this, entries);
        }

        public UnmodifiableIterator iterator()
        {
            return asList().iterator();
        }

        public volatile Iterator iterator()
        {
            return iterator();
        }

        ImmutableMap map()
        {
            return map;
        }

        RegularEntrySet(ImmutableMap immutablemap, java.util.Map.Entry aentry[])
        {
            map = immutablemap;
            entries = aentry;
        }
    }


    ImmutableMapEntrySet()
    {
    }

    public boolean contains(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof java.util.Map.Entry)
        {
            obj = (java.util.Map.Entry)obj;
            Object obj1 = map().get(((java.util.Map.Entry) (obj)).getKey());
            flag = flag1;
            if (obj1 != null)
            {
                flag = flag1;
                if (obj1.equals(((java.util.Map.Entry) (obj)).getValue()))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return map().hashCode();
    }

    boolean isHashCodeFast()
    {
        return map().isHashCodeFast();
    }

    boolean isPartialView()
    {
        return map().isPartialView();
    }

    abstract ImmutableMap map();

    public int size()
    {
        return map().size();
    }

    Object writeReplace()
    {
        return new EntrySetSerializedForm(map());
    }
}
