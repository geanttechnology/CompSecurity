// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch.tools.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MultiSkipListMap
{
    public static interface ListFactory
    {

        public abstract List newList();
    }


    private final ListFactory listFactory;
    private ConcurrentSkipListMap map;

    public MultiSkipListMap()
    {
        this(new ListFactory() {

            public List newList()
            {
                return new ArrayList(1);
            }

        });
    }

    public MultiSkipListMap(ListFactory listfactory)
    {
        listFactory = listfactory;
    }

    public NavigableMap getMap()
    {
        return map;
    }

    public void put(Object obj, Object obj1)
    {
        List list;
        List list1 = (List)map.get(obj);
        list = list1;
        if (list1 == null)
        {
            list = (List)map.putIfAbsent(obj, listFactory.newList());
        }
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        list;
        JVM INSTR monitorenter ;
        if (!list.contains(obj1))
        {
            list.add(obj1);
        }
        list;
        JVM INSTR monitorexit ;
        return;
        obj;
        list;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public void remove(Object obj)
    {
        map.remove(obj);
    }

    public void remove(Object obj, Object obj1)
    {
        ConcurrentSkipListMap concurrentskiplistmap = map;
        concurrentskiplistmap;
        JVM INSTR monitorenter ;
        List list = (List)map.get(obj);
        if (list == null) goto _L2; else goto _L1
_L1:
        list;
        JVM INSTR monitorenter ;
        list.remove(obj1);
        if (list.isEmpty())
        {
            map.remove(obj);
        }
        list;
        JVM INSTR monitorexit ;
_L2:
        concurrentskiplistmap;
        JVM INSTR monitorexit ;
        return;
        obj;
        list;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        concurrentskiplistmap;
        JVM INSTR monitorexit ;
        throw obj;
    }
}
