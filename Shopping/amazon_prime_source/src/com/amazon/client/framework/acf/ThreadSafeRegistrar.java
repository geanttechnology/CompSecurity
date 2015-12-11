// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package com.amazon.client.framework.acf:
//            Registrar

public class ThreadSafeRegistrar
    implements Registrar
{

    private final Object mAddOnceLock = new Object();
    private final Queue mRegistry = new ConcurrentLinkedQueue();

    public ThreadSafeRegistrar()
    {
    }

    public void add(Object obj)
    {
        synchronized (mAddOnceLock)
        {
            if (!mRegistry.contains(obj))
            {
                mRegistry.add(obj);
            }
        }
        return;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public void clear()
    {
        mRegistry.clear();
    }

    public Iterator iterator()
    {
        return mRegistry.iterator();
    }

    public boolean remove(Object obj)
    {
        return mRegistry.remove(obj);
    }

    public int size()
    {
        return mRegistry.size();
    }
}
