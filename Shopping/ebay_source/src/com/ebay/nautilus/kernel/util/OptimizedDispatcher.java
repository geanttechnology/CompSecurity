// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import java.util.ArrayList;
import java.util.Iterator;

public class OptimizedDispatcher
{
    public static interface Callback
    {

        public abstract void onTargetedNotify(Object obj, Object obj1);
    }


    private volatile Object _item;
    private final ArrayList _items = new ArrayList();

    public OptimizedDispatcher()
    {
    }

    private void optimize()
    {
        if (_items.size() == 1)
        {
            _item = _items.get(0);
            return;
        } else
        {
            _item = null;
            return;
        }
    }

    public void doNotify(Object obj, Callback callback)
    {
        Object obj1 = _item;
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        callback.onTargetedNotify(obj1, obj);
_L4:
        return;
_L2:
        synchronized (_items)
        {
            if (_items.size() != 0)
            {
                break MISSING_BLOCK_LABEL_43;
            }
        }
        return;
        obj;
        arraylist;
        JVM INSTR monitorexit ;
        throw obj;
        ArrayList arraylist1 = new ArrayList(_items);
        arraylist;
        JVM INSTR monitorexit ;
        Iterator iterator = arraylist1.iterator();
        while (iterator.hasNext()) 
        {
            callback.onTargetedNotify(iterator.next(), obj);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void register(Object obj)
    {
        synchronized (_items)
        {
            unRegister(obj);
            _items.add(obj);
            optimize();
        }
        return;
        obj;
        arraylist;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public void unRegister(Object obj)
    {
        synchronized (_items)
        {
            Iterator iterator = _items.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                if (iterator.next() != obj)
                {
                    continue;
                }
                iterator.remove();
                break;
            } while (true);
            optimize();
        }
        return;
        obj;
        arraylist;
        JVM INSTR monitorexit ;
        throw obj;
    }
}
