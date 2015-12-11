// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.upstream;

import java.io.IOException;
import java.util.PriorityQueue;

public final class NetworkLock
{
    public static class PriorityTooLowException extends IOException
    {

        public PriorityTooLowException(int i, int j)
        {
            super((new StringBuilder("Priority too low [priority=")).append(i).append(", highest=").append(j).append("]").toString());
        }
    }


    public static final int DOWNLOAD_PRIORITY = 10;
    public static final int STREAMING_PRIORITY = 0;
    public static final NetworkLock instance = new NetworkLock();
    private int highestPriority;
    private final Object lock = new Object();
    private final PriorityQueue queue = new PriorityQueue();

    private NetworkLock()
    {
        highestPriority = 0x7fffffff;
    }

    public final void add(int i)
    {
        synchronized (lock)
        {
            queue.add(Integer.valueOf(i));
            highestPriority = Math.min(highestPriority, i);
        }
    }

    public final void proceed(int i)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        while (highestPriority < i) 
        {
            lock.wait();
        }
        break MISSING_BLOCK_LABEL_30;
        Exception exception;
        exception;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }

    public final boolean proceedNonBlocking(int i)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        if (highestPriority >= i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public final void proceedOrThrow(int i)
    {
        synchronized (lock)
        {
            if (highestPriority < i)
            {
                throw new PriorityTooLowException(i, highestPriority);
            }
            break MISSING_BLOCK_LABEL_33;
        }
        obj;
        JVM INSTR monitorexit ;
    }

    public final void remove(int i)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        queue.remove(Integer.valueOf(i));
        if (!queue.isEmpty()) goto _L2; else goto _L1
_L1:
        i = 0x7fffffff;
_L4:
        highestPriority = i;
        lock.notifyAll();
        obj;
        JVM INSTR monitorexit ;
        return;
_L2:
        i = ((Integer)queue.peek()).intValue();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

}
