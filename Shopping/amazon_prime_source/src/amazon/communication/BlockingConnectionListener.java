// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication;

import amazon.communication.connection.Connection;
import amazon.communication.connection.ConnectionClosedDetails;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.communication.time.GlobalTimeSource;
import com.amazon.communication.time.TimeSource;
import com.amazon.dp.logger.DPLogger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package amazon.communication:
//            TimeoutException, ConnectionAcquisitionFailedException

public class BlockingConnectionListener
    implements amazon.communication.connection.Connection.ConnectionListener
{

    private static final DPLogger log = new DPLogger("TComm.BlockingConnectionListener");
    private ConnectionClosedDetails mConnectionClosedDetails;
    private final amazon.communication.connection.Connection.ConnectionListener mInnerListener;
    private final Lock mLock = new ReentrantLock();
    private final Condition mOpened;
    private final int mTimeout;

    public BlockingConnectionListener(amazon.communication.connection.Connection.ConnectionListener connectionlistener, int i)
    {
        mOpened = mLock.newCondition();
        mTimeout = i;
        mInnerListener = connectionlistener;
    }

    public void onClosed(Connection connection, ConnectionClosedDetails connectioncloseddetails)
    {
        mLock.lock();
        mConnectionClosedDetails = connectioncloseddetails;
        mOpened.signal();
        mLock.unlock();
        if (mInnerListener != null)
        {
            mInnerListener.onClosed(connection, connectioncloseddetails);
        }
        return;
        connection;
        mLock.unlock();
        throw connection;
    }

    public void onOpened(Connection connection)
    {
        mLock.lock();
        mOpened.signal();
        mLock.unlock();
        if (mInnerListener != null)
        {
            mInnerListener.onOpened(connection);
        }
        return;
        connection;
        mLock.unlock();
        throw connection;
    }

    public void waitForConnectionOpen(Connection connection, MetricEvent metricevent)
        throws TimeoutException, InterruptedException, ConnectionAcquisitionFailedException
    {
        if (metricevent == null)
        {
            throw new IllegalArgumentException("MetricEvent must not be null");
        }
        mLock.lock();
        int i;
        long l;
        i = connection.getConnectionState();
        l = GlobalTimeSource.INSTANCE.currentTimeMillis();
          goto _L1
_L2:
        throw new IllegalStateException((new StringBuilder()).append(i).append(" is not a valid connection state").toString());
        connection;
        mLock.unlock();
        throw connection;
_L5:
        if (mConnectionClosedDetails != null)
        {
            throw new ConnectionAcquisitionFailedException(mConnectionClosedDetails.getMessage());
        } else
        {
            throw new ConnectionAcquisitionFailedException("Cannot aquire connection.  Connnection is already closed.");
        }
_L3:
        metricevent.addCounter("CountEstablishNewConnectionTotal", 1.0D);
        long l1 = GlobalTimeSource.INSTANCE.currentTimeMillis();
        long l2 = mTimeout;
        if (!mOpened.await(l2 - (l1 - l), TimeUnit.MILLISECONDS))
        {
            log.verbose("waitForConnectionOpen", "setup connection timed out", new Object[] {
                "Thread.currentThread().getId()", Long.valueOf(Thread.currentThread().getId()), "mTimeout", Integer.valueOf(mTimeout)
            });
            metricevent.addCounter("CountEstablishNewConnectionTimeout", 1.0D);
            throw new TimeoutException("Setup connection timed out");
        }
        l1 = GlobalTimeSource.INSTANCE.currentTimeMillis();
        metricevent.addCounter("CountEstablishNewConnectionSuccess", 1.0D);
        metricevent.addTimer("TimeEstablishNewConnection", l1 - l);
        i = connection.getConnectionState();
          goto _L1
_L4:
        mLock.unlock();
        return;
_L1:
        i;
        JVM INSTR tableswitch 0 4: default 316
    //                   0 114
    //                   1 114
    //                   2 271
    //                   3 82
    //                   4 82;
           goto _L2 _L3 _L3 _L4 _L5 _L5
    }

}
