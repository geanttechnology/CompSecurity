// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.ServiceConnectedHandler;
import amazon.communication.ServiceConnectivityListener;
import amazon.communication.TCommServiceDownException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import com.amazon.dp.logger.DPLogger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.amazon.communication:
//            StackDumper

public class AndroidTCommServiceConnection
    implements ServiceConnection
{
    protected static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State BINDING;
        public static final State BOUND;
        public static final State UNBOUND;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/amazon/communication/AndroidTCommServiceConnection$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            UNBOUND = new State("UNBOUND", 0);
            BINDING = new State("BINDING", 1);
            BOUND = new State("BOUND", 2);
            $VALUES = (new State[] {
                UNBOUND, BINDING, BOUND
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    protected static final int BIND_SERVICE_WAIT_MS = 10000;
    public static final String TCOMM_INTENT_ACTION = "com.amazon.communication.TCOMM";
    private static final DPLogger log = new DPLogger("TComm.AndroidTCommServiceConnection");
    protected final Context mContext;
    protected final Condition mServiceConnectedCondition;
    protected final List mServiceConnectedHandlers = new CopyOnWriteArrayList();
    protected final Lock mServiceConnectedLock = new ReentrantLock();
    protected final List mServiceConnectivityListeners = new CopyOnWriteArrayList();
    protected State mState;
    protected IBinder mTCommService;

    public AndroidTCommServiceConnection(Context context)
    {
        mState = State.UNBOUND;
        mContext = context;
        mServiceConnectedCondition = mServiceConnectedLock.newCondition();
    }

    private void notifyServiceConnected()
    {
        log.debug("notifyServiceConnected", "notifying listeners", new Object[] {
            "mServiceConnectivityListeners.size()", Integer.valueOf(mServiceConnectivityListeners.size())
        });
        for (Iterator iterator = mServiceConnectivityListeners.iterator(); iterator.hasNext(); ((ServiceConnectivityListener)iterator.next()).onServiceConnected()) { }
    }

    private void notifyServiceConnectedHandlers()
    {
        log.debug("notifyServiceConnectedHandlers", "notifying handlers", new Object[] {
            "mServiceConnectedHandlers.size()", Integer.valueOf(mServiceConnectedHandlers.size())
        });
        for (Iterator iterator = mServiceConnectedHandlers.iterator(); iterator.hasNext(); ((ServiceConnectedHandler)iterator.next()).onServiceConnected()) { }
    }

    private void notifyServiceDisconnected()
    {
        log.debug("notifyServiceDisconnected", "notifying listeners", new Object[] {
            "mServiceConnectivityListeners.size()", Integer.valueOf(mServiceConnectivityListeners.size())
        });
        for (Iterator iterator = mServiceConnectivityListeners.iterator(); iterator.hasNext(); ((ServiceConnectivityListener)iterator.next()).onServiceDisconnected()) { }
    }

    public void bindTCommService()
    {
        mServiceConnectedLock.lock();
        if (mState == State.UNBOUND)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        log.info("bindTCommService", "state is not UNBOUND, doing nothing", new Object[] {
            "current state", mState
        });
        mServiceConnectedLock.unlock();
        return;
        boolean flag = mContext.bindService(new Intent("com.amazon.communication.TCOMM"), this, 5);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        mState = State.BINDING;
        log.debug("bindTCommService", "bound service", new Object[] {
            "bindResult", Boolean.valueOf(flag)
        });
        mServiceConnectedLock.unlock();
        return;
        Exception exception;
        exception;
        mServiceConnectedLock.unlock();
        throw exception;
    }

    public void deregisterServiceConnectivityListener(ServiceConnectivityListener serviceconnectivitylistener)
    {
        if (serviceconnectivitylistener == null)
        {
            throw new IllegalArgumentException("listener must not be null");
        }
        mServiceConnectedLock.lock();
        mServiceConnectivityListeners.remove(serviceconnectivitylistener);
        mServiceConnectedLock.unlock();
        return;
        serviceconnectivitylistener;
        mServiceConnectedLock.unlock();
        throw serviceconnectivitylistener;
    }

    public IBinder getBinder()
        throws TCommServiceDownException
    {
        mServiceConnectedLock.lock();
        log.debug("getService", "getting service binder", new Object[] {
            "state", mState
        });
        if (mState == State.UNBOUND)
        {
            throw new IllegalStateException("Service is unbound. getService should only be called when service is binding or bound");
        }
        break MISSING_BLOCK_LABEL_93;
        Object obj;
        obj;
        log.debug("getService", "interrupted waiting for service binder", new Object[0]);
        throw new TCommServiceDownException("Interrupted waiting for service binder", ((Exception) (obj)));
        obj;
        mServiceConnectedLock.unlock();
        throw obj;
        IBinder ibinder;
        if (mState == State.BINDING)
        {
            log.info("getService", "state is BINDING, waiting", new Object[0]);
            long l = System.currentTimeMillis();
            if (!mServiceConnectedCondition.await(10000L, TimeUnit.MILLISECONDS))
            {
                log.debug("getService", "timed out waiting for service binder", new Object[] {
                    "BIND_SERVICE_WAIT_MS", Integer.valueOf(10000)
                });
                if (!"user".equals(Build.TYPE))
                {
                    (new StackDumper(mContext)).dumpStack("com.amazon.tcomm");
                }
                throw new TCommServiceDownException("Timed out waiting for service binder after 10000 (ms)");
            }
            long l1 = System.currentTimeMillis();
            log.debug("getService", "finished waiting for service to bind", new Object[] {
                "elapsed", Long.valueOf(l1 - l)
            });
        }
        if (mState != State.BOUND)
        {
            throw new IllegalStateException("TComm service is not bound. This statement should never be reached!");
        }
        ibinder = mTCommService;
        mServiceConnectedLock.unlock();
        return ibinder;
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        mServiceConnectedLock.lock();
        log.debug("onServiceConnected", "service connected", new Object[] {
            "componentName", componentname, "state", mState
        });
        if (mState != State.BINDING && mState != State.UNBOUND) goto _L2; else goto _L1
_L1:
        mTCommService = ibinder;
        mState = State.BOUND;
        notifyServiceConnectedHandlers();
        notifyServiceConnected();
        mServiceConnectedCondition.signalAll();
_L4:
        mServiceConnectedLock.unlock();
        return;
_L2:
        log.debug("onServiceConnected", "state is not BINDING or UNBOUND, doing nothing", new Object[] {
            "state", mState
        });
        if (true) goto _L4; else goto _L3
_L3:
        componentname;
        mServiceConnectedLock.unlock();
        throw componentname;
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        mServiceConnectedLock.lock();
        log.debug("onServiceDisconnected", "service disconnected", new Object[] {
            "componentName", componentname, "state", mState
        });
        if (mState == State.UNBOUND || mState == State.BINDING) goto _L2; else goto _L1
_L1:
        mTCommService = null;
        mState = State.BINDING;
        notifyServiceDisconnected();
_L4:
        mServiceConnectedLock.unlock();
        return;
_L2:
        log.debug("onServiceDisconnected", "state is BINDING or UNBOUND, doing nothing", new Object[0]);
        if (true) goto _L4; else goto _L3
_L3:
        componentname;
        mServiceConnectedLock.unlock();
        throw componentname;
    }

    public void registerServiceConnectedHandler(ServiceConnectedHandler serviceconnectedhandler)
    {
        if (serviceconnectedhandler == null)
        {
            throw new IllegalArgumentException("handler must not be null");
        }
        mServiceConnectedLock.lock();
        mServiceConnectedHandlers.add(serviceconnectedhandler);
        if (mState == State.BOUND)
        {
            serviceconnectedhandler.onServiceConnected();
        }
        mServiceConnectedLock.unlock();
        return;
        serviceconnectedhandler;
        mServiceConnectedLock.unlock();
        throw serviceconnectedhandler;
    }

    public void registerServiceConnectivityListener(ServiceConnectivityListener serviceconnectivitylistener)
    {
        if (serviceconnectivitylistener == null)
        {
            throw new IllegalArgumentException("listener must not be null");
        }
        mServiceConnectedLock.lock();
        mServiceConnectivityListeners.add(serviceconnectivitylistener);
        if (mState == State.BOUND)
        {
            serviceconnectivitylistener.onServiceConnected();
        }
        mServiceConnectedLock.unlock();
        return;
        serviceconnectivitylistener;
        mServiceConnectedLock.unlock();
        throw serviceconnectivitylistener;
    }

    public void unbindTCommService()
    {
        mServiceConnectedLock.lock();
        if (mState == State.UNBOUND) goto _L2; else goto _L1
_L1:
        mContext.unbindService(this);
        log.debug("unbindTCommService", "unbound service", new Object[0]);
        mState = State.UNBOUND;
        mTCommService = null;
_L4:
        mServiceConnectedLock.unlock();
        mServiceConnectedHandlers.clear();
        return;
_L2:
        log.info("unbindTCommService", "state is not BOUND, doing nothing", new Object[] {
            "current state", mState
        });
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        mServiceConnectedLock.unlock();
        throw exception;
    }

}
