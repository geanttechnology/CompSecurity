// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.concurrent.TimeUnit;

public abstract class BoundServiceCaller
{

    private static final long CONNECTION_TIMEOUT;
    private static final String TAG = com/amazon/identity/auth/device/framework/BoundServiceCaller.getName();
    private final int mBindingFlags;
    private ServiceConnection mConnection;
    private final Context mContext;
    private final Object mLocker[] = new Object[0];
    private boolean mServiceConnectionWasEstablished;
    private final Intent mServiceIntent;

    public BoundServiceCaller(Context context, Intent intent, int i)
    {
        if (context == null || intent == null)
        {
            throw new IllegalArgumentException();
        }
        mContext = context;
        mServiceIntent = intent;
        mServiceConnectionWasEstablished = false;
        mConnection = new ServiceConnection() {

            final BoundServiceCaller this$0;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                String _tmp = BoundServiceCaller.TAG;
                String.format("Connected to service: %s", new Object[] {
                    componentname.toString()
                });
                mServiceConnectionWasEstablished = true;
                try
                {
                    useService(componentname, ibinder);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (IBinder ibinder)
                {
                    MAPLog.e(BoundServiceCaller.TAG, String.format("Service died: %s", new Object[] {
                        componentname.toString()
                    }));
                }
                unbind();
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                synchronized (mLocker)
                {
                    mConnection = null;
                }
                serviceDisconnected();
                String _tmp = BoundServiceCaller.TAG;
                String.format("Disconnected from service: %s", new Object[] {
                    componentname.toString()
                });
            }

            
            {
                this$0 = BoundServiceCaller.this;
                super();
            }
        };
        int j = i | 4;
        i = j;
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            i = j | 0x10;
        }
        mBindingFlags = i;
    }

    public final boolean call()
    {
        synchronized (mLocker)
        {
            if (mConnection == null)
            {
                throw new IllegalStateException("Attempted to reuse a BoundServiceCaller.  Call method can only be executed once.");
            }
            break MISSING_BLOCK_LABEL_29;
        }
        boolean flag = mContext.bindService(mServiceIntent, mConnection, mBindingFlags);
        aobj;
        JVM INSTR monitorexit ;
        if (!flag)
        {
            MAPLog.e(TAG, "Failed to bind to service.");
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
                    MAPLog.e(BoundServiceCaller.TAG, String.format("Application timed out trying to bind to %s", new Object[] {
                        mServiceIntent.getComponent().getPackageName()
                    }));
                    mConnection = null;
                    aobj1;
                    JVM INSTR monitorexit ;
                    serviceTimedOut();
                    return;
                    exception1;
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

    protected void serviceDisconnected()
    {
    }

    protected void serviceTimedOut()
    {
    }

    protected void unbind()
    {
        Object aobj[] = mLocker;
        aobj;
        JVM INSTR monitorenter ;
        ServiceConnection serviceconnection = mConnection;
        if (serviceconnection == null) goto _L2; else goto _L1
_L1:
        mContext.unbindService(mConnection);
_L3:
        mConnection = null;
_L2:
        aobj;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        MAPLog.w(TAG, String.format("IllegalArgumentException is received during unbinding from %s. Ignored.", new Object[] {
            mServiceIntent.getComponent().getPackageName()
        }));
          goto _L3
        obj;
        throw obj;
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
    static boolean access$102(BoundServiceCaller boundservicecaller, boolean flag)
    {
        boundservicecaller.mServiceConnectionWasEstablished = flag;
        return flag;
    }

*/



/*
    static ServiceConnection access$302(BoundServiceCaller boundservicecaller, ServiceConnection serviceconnection)
    {
        boundservicecaller.mConnection = serviceconnection;
        return serviceconnection;
    }

*/

}
