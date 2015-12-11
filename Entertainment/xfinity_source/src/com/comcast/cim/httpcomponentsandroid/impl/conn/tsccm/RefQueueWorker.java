// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.conn.tsccm;

import java.lang.ref.ReferenceQueue;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.conn.tsccm:
//            RefQueueHandler

public class RefQueueWorker
    implements Runnable
{

    protected final RefQueueHandler refHandler;
    protected final ReferenceQueue refQueue;
    protected volatile Thread workerThread;

    public void run()
    {
        if (workerThread == null)
        {
            workerThread = Thread.currentThread();
        }
        while (workerThread == Thread.currentThread()) 
        {
            try
            {
                java.lang.ref.Reference reference = refQueue.remove();
                refHandler.handleReference(reference);
            }
            catch (InterruptedException interruptedexception) { }
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("RefQueueWorker::").append(workerThread).toString();
    }
}
