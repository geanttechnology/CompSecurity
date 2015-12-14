// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.snds.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import java.util.concurrent.TimeUnit;

public abstract class BoundServiceCaller
{

    private static final long CONNECTION_TIMEOUT;
    private static final String TAG = com/amazon/identity/snds/api/BoundServiceCaller.getName();
    private final int mBindingFlags;
    private ServiceConnection mConnection;
    private final Context mContext;
    private Object mLocker[];
    private boolean mServiceConnectionWasEstablished;
    private final Intent mServiceIntent;

    public BoundServiceCaller(Context context, Intent intent, int i)
    {
        mLocker = new Object[0];
        if (context == null || intent == null)
        {
            throw new IllegalArgumentException();
        } else
        {
            mContext = context;
            mServiceIntent = intent;
            mServiceConnectionWasEstablished = false;
            mConnection = new ServiceConnection() {

                final BoundServiceCaller this$0;

                public void onServiceConnected(ComponentName componentname, IBinder ibinder)
                {
                    mServiceConnectionWasEstablished = true;
                    try
                    {
                        useService(componentname, ibinder);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (ComponentName componentname)
                    {
                        unbind();
                    }
                }

                public void onServiceDisconnected(ComponentName componentname)
                {
                    synchronized (mLocker)
                    {
                        mConnection = null;
                    }
                    return;
                    exception;
                    componentname;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                this$0 = BoundServiceCaller.this;
                super();
            }
            };
            mBindingFlags = i;
            return;
        }
    }

    private void safeUnbind()
    {
        try
        {
            mContext.unbindService(mConnection);
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            return;
        }
    }

    public final boolean call()
    {
        Object aobj[] = mLocker;
        aobj;
        JVM INSTR monitorenter ;
        if (mConnection == null)
        {
            throw new IllegalStateException("Attempted to reuse a BoundServiceCaller.  Call method can only be executed once.");
        }
        break MISSING_BLOCK_LABEL_29;
        Exception exception;
        exception;
        aobj;
        JVM INSTR monitorexit ;
        throw exception;
        boolean flag = mContext.bindService(mServiceIntent, mConnection, mBindingFlags | 4);
        aobj;
        JVM INSTR monitorexit ;
        if (!flag)
        {
            return false;
        } else
        {
            (new Handler(Looper.getMainLooper())).postDelayed(new Runnable() {

                final BoundServiceCaller this$0;

                public void run()
                {
label0:
                    {
                        synchronized (mLocker)
                        {
                            if (!mServiceConnectionWasEstablished)
                            {
                                break label0;
                            }
                        }
                        return;
                    }
                    mConnection = null;
                    aobj1;
                    JVM INSTR monitorexit ;
                    serviceTimedOut();
                    return;
                    exception1;
                    aobj1;
                    JVM INSTR monitorexit ;
                    throw exception1;
                }

            
            {
                this$0 = BoundServiceCaller.this;
                super();
            }
            }, CONNECTION_TIMEOUT);
            return flag;
        }
    }

    protected void serviceTimedOut()
    {
    }

    protected void unbind()
    {
        synchronized (mLocker)
        {
            if (mConnection != null)
            {
                safeUnbind();
                mConnection = null;
            }
        }
        return;
        exception;
        aobj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void useService(ComponentName componentname, IBinder ibinder)
        throws RemoteException
    {
        useService(ibinder);
    }

    protected void useService(IBinder ibinder)
        throws RemoteException
    {
    }

    static 
    {
        CONNECTION_TIMEOUT = TimeUnit.MILLISECONDS.convert(3L, TimeUnit.SECONDS);
    }



/*
    static boolean access$002(BoundServiceCaller boundservicecaller, boolean flag)
    {
        boundservicecaller.mServiceConnectionWasEstablished = flag;
        return flag;
    }

*/



/*
    static ServiceConnection access$202(BoundServiceCaller boundservicecaller, ServiceConnection serviceconnection)
    {
        boundservicecaller.mConnection = serviceconnection;
        return serviceconnection;
    }

*/
}
