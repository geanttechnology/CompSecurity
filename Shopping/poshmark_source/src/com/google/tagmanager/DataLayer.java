// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class DataLayer
{
    static interface Listener
    {

        public abstract void changed(Map map);
    }


    static final int MAX_QUEUE_DEPTH = 500;
    public static final Object OBJECT_NOT_PRESENT = new Object();
    private final ConcurrentHashMap mListeners = new ConcurrentHashMap();
    private final Map mModel = new HashMap();
    private final ReentrantLock mPushLock = new ReentrantLock();
    private final LinkedList mUpdateQueue = new LinkedList();

    DataLayer()
    {
    }

    public static transient List listOf(Object aobj[])
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < aobj.length; i++)
        {
            arraylist.add(aobj[i]);
        }

        return arraylist;
    }

    public static transient Map mapOf(Object aobj[])
    {
        if (aobj.length % 2 != 0)
        {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        HashMap hashmap = new HashMap();
        for (int i = 0; i < aobj.length; i += 2)
        {
            hashmap.put(aobj[i], aobj[i + 1]);
        }

        return hashmap;
    }

    private void notifyListeners(Map map)
    {
        for (Iterator iterator = mListeners.keySet().iterator(); iterator.hasNext(); ((Listener)iterator.next()).changed(map)) { }
    }

    private void processQueuedUpdates()
    {
        int i = 0;
        do
        {
            Map map = (Map)mUpdateQueue.poll();
            if (map != null)
            {
                processUpdate(map);
                int j = i + 1;
                i = j;
                if (j > 500)
                {
                    mUpdateQueue.clear();
                    throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                }
            } else
            {
                return;
            }
        } while (true);
    }

    private void processUpdate(Map map)
    {
        Map map1 = mModel;
        map1;
        JVM INSTR monitorenter ;
        Object obj;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); mergeMap(expandKeyValue(obj, map.get(obj)), mModel))
        {
            obj = iterator.next();
        }

        break MISSING_BLOCK_LABEL_66;
        map;
        map1;
        JVM INSTR monitorexit ;
        throw map;
        map1;
        JVM INSTR monitorexit ;
        notifyListeners(map);
        return;
    }

    Map expandKeyValue(Object obj, Object obj1)
    {
        HashMap hashmap = new HashMap();
        Object obj2 = hashmap;
        String as[] = obj.toString().split("\\.");
        for (int i = 0; i < as.length - 1; i++)
        {
            obj = new HashMap();
            ((Map) (obj2)).put(as[i], obj);
            obj2 = obj;
        }

        ((Map) (obj2)).put(as[as.length - 1], obj1);
        return hashmap;
    }

    public Object get(String s)
    {
        Map map = mModel;
        map;
        JVM INSTR monitorenter ;
        Object obj;
        String as[];
        int j;
        obj = mModel;
        as = s.split("\\.");
        j = as.length;
        int i;
        i = 0;
        s = ((String) (obj));
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        obj = as[i];
        if (s instanceof Map)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        map;
        JVM INSTR monitorexit ;
        return null;
        s = ((String) (((Map)s).get(obj)));
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        map;
        JVM INSTR monitorexit ;
        return null;
        map;
        JVM INSTR monitorexit ;
        return s;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    void mergeList(List list, List list1)
    {
        for (; list1.size() < list.size(); list1.add(null)) { }
        int i = 0;
        while (i < list.size()) 
        {
            Object obj = list.get(i);
            if (obj instanceof List)
            {
                if (!(list1.get(i) instanceof List))
                {
                    list1.set(i, new ArrayList());
                }
                mergeList((List)obj, (List)list1.get(i));
            } else
            if (obj instanceof Map)
            {
                if (!(list1.get(i) instanceof Map))
                {
                    list1.set(i, new HashMap());
                }
                mergeMap((Map)obj, (Map)list1.get(i));
            } else
            if (obj != OBJECT_NOT_PRESENT)
            {
                list1.set(i, obj);
            }
            i++;
        }
    }

    void mergeMap(Map map, Map map1)
    {
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
        {
            Object obj = iterator.next();
            Object obj1 = map.get(obj);
            if (obj1 instanceof List)
            {
                if (!(map1.get(obj) instanceof List))
                {
                    map1.put(obj, new ArrayList());
                }
                mergeList((List)obj1, (List)map1.get(obj));
            } else
            if (obj1 instanceof Map)
            {
                if (!(map1.get(obj) instanceof Map))
                {
                    map1.put(obj, new HashMap());
                }
                mergeMap((Map)obj1, (Map)map1.get(obj));
            } else
            {
                map1.put(obj, obj1);
            }
        }

    }

    public void push(Object obj, Object obj1)
    {
        push(expandKeyValue(obj, obj1));
    }

    public void push(Map map)
    {
        mPushLock.lock();
        mUpdateQueue.offer(map);
        if (mPushLock.getHoldCount() == 1)
        {
            processQueuedUpdates();
        }
        mPushLock.unlock();
        return;
        map;
        mPushLock.unlock();
        throw map;
    }

    void registerListener(Listener listener)
    {
        mListeners.put(listener, Integer.valueOf(0));
    }

    void unregisterListener(Listener listener)
    {
        mListeners.remove(listener);
    }

}
