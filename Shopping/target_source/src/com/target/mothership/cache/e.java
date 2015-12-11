// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache;

import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.support.ConnectionSource;
import com.target.a.a.b;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.target.mothership.cache:
//            h

public class e extends Thread
{

    private static final int CLOSE_TIMEOUT_MSEC = 2000;
    private static final int QUEUE_SIZE = 100;
    private static final String TAG = com/target/mothership/cache/e.getSimpleName();
    private static e sDataBasePool;
    private static Object sMutex = new Object();
    private ConnectionSource mConnectionSource;
    private ArrayBlockingQueue mDBRequests;
    private CountDownLatch mSignal;

    private e()
    {
        mConnectionSource = h.getInstance().getConnectionSource();
        mDBRequests = new ArrayBlockingQueue(100);
    }

    public static e getInstance()
    {
        synchronized (sMutex)
        {
            if (sDataBasePool == null)
            {
                sDataBasePool = new e();
                sDataBasePool.start();
            }
        }
        return sDataBasePool;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void shutDown()
    {
        b.e(TAG, "shutdown");
        mConnectionSource.closeQuietly();
        sDataBasePool = null;
        mSignal.countDown();
    }

    public void add(Callable callable)
    {
        mDBRequests.add(callable);
    }

    public void close()
    {
        Exception exception;
        b.e(TAG, "shutdown");
        mSignal = new CountDownLatch(1);
        interrupt();
        try
        {
            mSignal.await(2000L, TimeUnit.MILLISECONDS);
            if (mSignal.getCount() > 0L)
            {
                b.b(TAG, "timeout waiting for database tasks to finish.");
            }
        }
        catch (InterruptedException interruptedexception)
        {
            shutDown();
            return;
        }
        finally
        {
            shutDown();
        }
        shutDown();
        return;
        throw exception;
    }

    public void run()
    {
_L2:
label0:
        {
            synchronized (sMutex)
            {
                if (!interrupted())
                {
                    break label0;
                }
                shutDown();
            }
            return;
        }
        obj;
        JVM INSTR monitorexit ;
        try
        {
            obj = (Callable)mDBRequests.take();
            TransactionManager.callInTransaction(mConnectionSource, ((Callable) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        catch (SQLException sqlexception)
        {
            b.a(TAG, sqlexception.getMessage());
        }
        if (true) goto _L2; else goto _L1
_L1:
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
