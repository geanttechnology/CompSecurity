// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.Iterator;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            ImmutableSet, ImmutableMap, ImmutableList, UnmodifiableIterator, 
//            ImmutableAsList, ImmutableCollection

final class ImmutableMapKeySet extends ImmutableSet
{

    private final ImmutableMap map;

    ImmutableMapKeySet(ImmutableMap immutablemap)
    {
        map = immutablemap;
    }

    public boolean contains(Object obj)
    {
        return map.containsKey(obj);
    }

    ImmutableList createAsList()
    {
        return new ImmutableAsList() {

            final ImmutableMapKeySet this$0;
            final ImmutableList val$entryList;

            ImmutableCollection delegateCollection()
            {
                return ImmutableMapKeySet.this;
            }

            public Object get(int i)
            {
                return ((java.util.Map.Entry)entryList.get(i)).getKey();
            }

            
            {
                this$0 = ImmutableMapKeySet.this;
                entryList = immutablelist;
                super();
            }
        };
    }

    boolean isPartialView()
    {
        return true;
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public UnmodifiableIterator iterator()
    {
        return asList().iterator();
    }

    public int size()
    {
        return map.size();
    }
}
