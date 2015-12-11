// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.omniata.android.sdk;

import java.util.concurrent.BlockingQueue;

// Referenced classes of package com.omniata.android.sdk:
//            OmniataLog, PersistentBlockingQueue

class OmniataEventLogger
    implements Runnable
{

    private static final String TAG = "OmniataEventLogger";
    private BlockingQueue eventBuffer;
    private PersistentBlockingQueue eventLog;
    private boolean isRunning;
    private boolean isStarted;
    private Thread worker;

    public OmniataEventLogger(BlockingQueue blockingqueue, PersistentBlockingQueue persistentblockingqueue)
    {
        eventBuffer = blockingqueue;
        eventLog = persistentblockingqueue;
        worker = new Thread(this);
    }

    public void run()
    {
        OmniataLog.i("OmniataEventLogger", "Thread begin");
        isRunning = true;
        try
        {
            while (isRunning) 
            {
                OmniataLog.v("OmniataEventLogger", (new StringBuilder("Thread running: ")).append(Thread.currentThread().getId()).toString());
                eventLog.add(eventBuffer.take());
            }
        }
        catch (InterruptedException interruptedexception)
        {
            OmniataLog.e("OmniataEventLogger", "Thread interrupted");
            Thread.currentThread().interrupt();
        }
        OmniataLog.i("OmniataEventLogger", "Thread done");
    }

    public void start()
    {
        if (!isStarted)
        {
            worker.start();
            isStarted = true;
        }
    }
}
