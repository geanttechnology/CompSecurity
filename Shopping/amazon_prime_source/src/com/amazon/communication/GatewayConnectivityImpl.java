// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.GatewayConnectivity;
import amazon.communication.TCommServiceDownException;
import amazon.communication.connection.ConnectionClosedDetails;
import android.os.RemoteException;
import com.amazon.communication.connection.ClosedConnectionReasonFactory;
import com.amazon.dp.logger.DPLogger;
import com.dp.utils.FailFast;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.communication:
//            IGatewayConnectivity

public class GatewayConnectivityImpl extends IConnectionListener.Stub
    implements GatewayConnectivity
{

    private static final DPLogger log = new DPLogger("TComm.GatewayConnectivityImpl");
    private IGatewayConnectivity mGatewayConnectivity;
    private final Set mListeners = Collections.synchronizedSet(new HashSet(2));
    protected final AtomicInteger mState = new AtomicInteger(0);

    public GatewayConnectivityImpl()
    {
    }

    private boolean isValidState(int i)
    {
        return i >= 0 && i <= 4;
    }

    private void notifyStateClosed(int i, String s)
    {
        log.debug("notifyStateClosed", "gateway connection closed", new Object[] {
            "statusCode", Integer.valueOf(i), "closeReason", ClosedConnectionReasonFactory.getReasonForStatusCode(i), "message", s, "number of listeners", Integer.valueOf(mListeners.size())
        });
        Set set = mListeners;
        set;
        JVM INSTR monitorenter ;
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((amazon.communication.GatewayConnectivity.GatewayConnectivityMonitor)iterator.next()).onGatewayConnectionClosed(new ConnectionClosedDetails(i, s))) { }
        break MISSING_BLOCK_LABEL_130;
        s;
        set;
        JVM INSTR monitorexit ;
        throw s;
        set;
        JVM INSTR monitorexit ;
    }

    private void notifyStateOpened()
    {
        log.debug("notifyStateOpened", "gateway connection opened", new Object[] {
            "number of listeners", Integer.valueOf(mListeners.size())
        });
        Set set = mListeners;
        set;
        JVM INSTR monitorenter ;
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((amazon.communication.GatewayConnectivity.GatewayConnectivityMonitor)iterator.next()).onGatewayConnectionEstablished()) { }
        break MISSING_BLOCK_LABEL_82;
        Exception exception;
        exception;
        set;
        JVM INSTR monitorexit ;
        throw exception;
        set;
        JVM INSTR monitorexit ;
    }

    public void deregisterGatewayConnectivityMonitor(amazon.communication.GatewayConnectivity.GatewayConnectivityMonitor gatewayconnectivitymonitor)
    {
label0:
        {
            log.debug("deregisterGatewayConnectivityMonitor", "monitor", new Object[] {
                gatewayconnectivitymonitor
            });
            if (gatewayconnectivitymonitor == null)
            {
                throw new IllegalArgumentException("GatewayConnectivityMonitor must not be null");
            }
            synchronized (mListeners)
            {
                if (!mListeners.contains(gatewayconnectivitymonitor))
                {
                    break label0;
                }
                mListeners.remove(gatewayconnectivitymonitor);
            }
            return;
        }
        throw new IllegalArgumentException("GatewayConnectivityMonitor isn't registered");
        gatewayconnectivitymonitor;
        set;
        JVM INSTR monitorexit ;
        throw gatewayconnectivitymonitor;
    }

    public int getGatewayConnectionState()
        throws TCommServiceDownException
    {
        int i;
        try
        {
            i = mGatewayConnectivity.getGatewayConnectionState();
            mState.set(i);
        }
        catch (RemoteException remoteexception)
        {
            throw new TCommServiceDownException(remoteexception);
        }
        return i;
    }

    public void onConnectionSetInitialState(int i)
        throws RemoteException
    {
        log.verbose("onConnectionSetInitialState", "Setting initial connection state", new Object[] {
            "state", Integer.valueOf(i)
        });
        try
        {
            FailFast.expectTrue(isValidState(i));
            mState.set(i);
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            log.warn("onConnectionSetInitialState", "Exception occurred!", new Object[] {
                runtimeexception
            });
            throw runtimeexception;
        }
    }

    public void onConnectionStateChanged(int i, int j, String s)
        throws RemoteException
    {
        log.verbose("onConnectionStateChanged", "Connection state changed", new Object[] {
            "state", Integer.valueOf(i), "statusCode", Integer.valueOf(j), "message", s
        });
        int k;
        FailFast.expectTrue(isValidState(i));
        k = mState.getAndSet(i);
        if (k != 4 && i == 4)
        {
            try
            {
                notifyStateClosed(j, s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                log.warn("onConnectionStateChanged", "Exception occurred!", new Object[] {
                    s
                });
            }
            break MISSING_BLOCK_LABEL_119;
        }
        if (k == 2 || i != 2)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        notifyStateOpened();
        return;
        throw s;
    }

    public int registerGatewayConnectivityMonitor(amazon.communication.GatewayConnectivity.GatewayConnectivityMonitor gatewayconnectivitymonitor)
    {
        log.debug("registerGatewayConnectivityMonitor", "monitor", new Object[] {
            gatewayconnectivitymonitor
        });
        if (gatewayconnectivitymonitor == null)
        {
            throw new IllegalArgumentException("GatewayConnectivityMonitor must not be null");
        } else
        {
            mListeners.add(gatewayconnectivitymonitor);
            return mState.get();
        }
    }

    public void setGatewayConnectivityInterface(IGatewayConnectivity igatewayconnectivity)
    {
        if (igatewayconnectivity == null)
        {
            throw new IllegalArgumentException("connectivity must not be null");
        }
        if (mGatewayConnectivity != null)
        {
            throw new IllegalStateException("mGatewayConnectivity is already set");
        } else
        {
            mGatewayConnectivity = igatewayconnectivity;
            return;
        }
    }

}
