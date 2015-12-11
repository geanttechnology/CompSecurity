// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import com.edisonwang.android.slog.SLog;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingToken
{

    private static final int LOCK[] = new int[0];
    private static final HashMap sTokens = new HashMap();

    public BlockingToken()
    {
    }

    public static void acquire(String s)
    {
        SLog.d("bbq {} acquire.", s);
        for (LinkedBlockingQueue linkedblockingqueue = getQueue(s); linkedblockingqueue.poll() == null;)
        {
            try
            {
                Thread.sleep(15L);
            }
            catch (InterruptedException interruptedexception)
            {
                SLog.e("bbq {} failed to acquire.", s);
            }
        }

    }

    private static LinkedBlockingQueue getQueue(String s)
    {
        int ai[] = LOCK;
        ai;
        JVM INSTR monitorenter ;
        LinkedBlockingQueue linkedblockingqueue1 = (LinkedBlockingQueue)sTokens.get(s);
        LinkedBlockingQueue linkedblockingqueue = linkedblockingqueue1;
        if (linkedblockingqueue1 != null) goto _L2; else goto _L1
_L1:
        linkedblockingqueue = new LinkedBlockingQueue();
        linkedblockingqueue.put(s);
_L3:
        sTokens.put(s, linkedblockingqueue);
_L2:
        ai;
        JVM INSTR monitorexit ;
        return linkedblockingqueue;
        InterruptedException interruptedexception;
        interruptedexception;
        SLog.e("bbq {} failed to queue.", s);
          goto _L3
        s;
        ai;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void release(String s)
    {
        SLog.d("bbq {} release.", s);
        LinkedBlockingQueue linkedblockingqueue = getQueue(s);
        try
        {
            linkedblockingqueue.put(s);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            SLog.e("bbq {} failed to release.", s);
        }
    }

}
