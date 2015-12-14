// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.storage;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class MStorageEvent
{

    private int bP;
    private final Hashtable bQ = new Hashtable();
    private final CopyOnWriteArraySet bR = new CopyOnWriteArraySet();

    public MStorageEvent()
    {
        bP = 0;
    }

    private void e()
    {
        HashSet hashset = new HashSet(bQ.keySet());
        if (hashset.size() <= 0)
        {
            return;
        }
        HashMap hashmap = new HashMap();
        for (Iterator iterator = hashset.iterator(); iterator.hasNext();)
        {
            Object obj = iterator.next();
            Object obj1 = bQ.get(obj);
            Iterator iterator1 = bR.iterator();
            while (iterator1.hasNext()) 
            {
                Object obj2 = iterator1.next();
                if (obj2 != null)
                {
                    if (obj1 == null)
                    {
                        Log.f("MicroMsg.SDK.MStorageEvent", "handle listener fatal unknown bug");
                    } else
                    if (obj1 instanceof Looper)
                    {
                        Looper looper = (Looper)obj1;
                        Handler handler1 = (Handler)hashmap.get(looper);
                        Handler handler = handler1;
                        if (handler1 == null)
                        {
                            handler = new Handler(looper);
                            hashmap.put(looper, handler);
                        }
                        handler.post(new _cls1(obj, obj2));
                    } else
                    {
                        processEvent(obj, obj2);
                    }
                }
            }
        }

        bR.clear();
    }

    public void add(Object obj, Looper looper)
    {
label0:
        {
            if (!bQ.containsKey(obj))
            {
                if (looper == null)
                {
                    break label0;
                }
                bQ.put(obj, looper);
            }
            return;
        }
        bQ.put(obj, new Object());
    }

    public void doNotify()
    {
        if (!isLocked())
        {
            e();
        }
    }

    public boolean event(Object obj)
    {
        return bR.add(obj);
    }

    public boolean isLocked()
    {
        return bP > 0;
    }

    public void lock()
    {
        bP = bP + 1;
    }

    protected abstract void processEvent(Object obj, Object obj1);

    public void remove(Object obj)
    {
        bQ.remove(obj);
    }

    public void removeAll()
    {
        bQ.clear();
    }

    public void unlock()
    {
        bP = bP - 1;
        if (bP <= 0)
        {
            bP = 0;
            e();
        }
    }

    private class _cls1
        implements Runnable
    {

        final Object bS;
        final Object bT;
        final MStorageEvent bU;

        public void run()
        {
            bU.processEvent(bS, bT);
        }

        _cls1(Object obj, Object obj1)
        {
            bU = MStorageEvent.this;
            bS = obj;
            bT = obj1;
            super();
        }
    }

}
