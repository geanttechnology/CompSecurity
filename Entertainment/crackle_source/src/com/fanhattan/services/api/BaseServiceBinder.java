// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

public abstract class BaseServiceBinder
{
    final class MyServiceConnection
        implements ServiceConnection
    {

        private RebindRunnable mReBindRunnable;
        private volatile Object mService;
        final BaseServiceBinder this$0;

        private boolean bind()
        {
            boolean flag1 = false;
            boolean flag = flag1;
            Intent intent;
            try
            {
                intent = getIntent();
            }
            catch (Exception exception)
            {
                Log.e(mTag, "Impossible to find service");
                return flag;
            }
            flag = flag1;
            mContext.startService(intent);
            flag = flag1;
            flag1 = mContext.bindService(intent, this, 1);
            if (flag1)
            {
                break MISSING_BLOCK_LABEL_61;
            }
            flag = flag1;
            Log.e(mTag, "Could not bind to service.");
            return flag1;
        }

        private boolean unbind()
        {
            boolean flag = false;
            Object obj = mService;
            if (obj != null)
            {
                beforeServiceDisconnected(obj);
                try
                {
                    mContext.unbindService(this);
                }
                catch (IllegalArgumentException illegalargumentexception)
                {
                    Log.e(mTag, "Unable to unbind service (already unbound)");
                    return false;
                }
                flag = true;
            }
            return flag;
        }

        public Object getService()
        {
            return mService;
        }

        public void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            mService = castService(ibinder);
            synchronized (mBoundLock)
            {
                mBound = true;
                mBoundLock.notifyAll();
            }
            BaseServiceBinder.this.onServiceConnected(mService);
            return;
            ibinder;
            componentname;
            JVM INSTR monitorexit ;
            throw ibinder;
        }

        public void onServiceDisconnected(ComponentName componentname)
        {
            Log.w(mTag, "Service unexpectedly disconnected.");
            mService = null;
            synchronized (mBoundLock)
            {
                mBound = false;
                mBoundLock.notifyAll();
            }
            if (mAutoReconnect)
            {
                startRebindThread();
            }
            onServiceUnexpectedlyDisconnected();
            return;
            exception;
            componentname;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void startRebindThread()
        {
            if (mReBindRunnable != null)
            {
                mReBindRunnable.finish();
            }
            mReBindRunnable = new RebindRunnable();
            (new Thread(mReBindRunnable, "Rebind to service attempts")).start();
        }



        MyServiceConnection()
        {
            this$0 = BaseServiceBinder.this;
            super();
        }
    }

    class MyServiceConnection.RebindRunnable
        implements Runnable
    {

        private boolean finish;
        final MyServiceConnection this$1;

        public void finish()
        {
            finish = true;
        }

        public void run()
        {
            int i;
            boolean flag;
            i = 0;
            flag = false;
_L2:
            int j;
            boolean flag1;
            if (finish || flag || i >= 10)
            {
                break; /* Loop/switch isn't completed */
            }
            j = i + 1;
            flag1 = bind();
            i = j;
            flag = flag1;
            if (flag1)
            {
                continue; /* Loop/switch isn't completed */
            }
            Thread.sleep(1000L);
            i = j;
            flag = flag1;
            continue; /* Loop/switch isn't completed */
            InterruptedException interruptedexception;
            interruptedexception;
            i = j;
            flag = flag1;
            if (true) goto _L2; else goto _L1
_L1:
        }

        MyServiceConnection.RebindRunnable()
        {
            this$1 = MyServiceConnection.this;
            super();
        }
    }


    public static final String REBIND_ATTEMPTS_THREAD_NAME = "Rebind to service attempts";
    private static final int RECONNECT_ATTEMPTS = 10;
    public static final long RECONNECT_TIME_BETWEEN_ATTEMPTS_IN_MS = 1000L;
    private final boolean mAutoReconnect;
    private boolean mBound;
    private final Object mBoundLock = new Object();
    protected final Context mContext;
    private final MyServiceConnection mServiceConnection = new MyServiceConnection();
    private final String mTag;

    public BaseServiceBinder(Context context, boolean flag, String s)
    {
        if (context == null || s == null)
        {
            throw new IllegalAccessError();
        } else
        {
            mContext = context;
            mAutoReconnect = flag;
            mTag = s;
            mBound = false;
            return;
        }
    }

    protected void beforeServiceDisconnected(Object obj)
    {
    }

    protected boolean bind()
    {
        return mServiceConnection.bind();
    }

    protected abstract Object castService(IBinder ibinder);

    protected abstract Intent getIntent();

    protected Object getService()
    {
        return mServiceConnection.getService();
    }

    public boolean isBound()
    {
        boolean flag;
        synchronized (mBoundLock)
        {
            flag = mBound;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void onServiceConnected(Object obj)
    {
    }

    protected void onServiceUnexpectedlyDisconnected()
    {
    }

    protected boolean unbind()
    {
        return mServiceConnection.unbind();
    }

    public boolean waitServiceBinding(long l)
    {
        boolean flag = false;
        Object obj = mBoundLock;
        obj;
        JVM INSTR monitorenter ;
_L2:
        boolean flag1 = mBound;
        if (flag1 || flag)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        mBoundLock.wait(l);
        flag = true;
        continue; /* Loop/switch isn't completed */
        flag1 = mBound;
        obj;
        JVM INSTR monitorexit ;
        return flag1;
        Object obj1;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        if (true) goto _L2; else goto _L1
_L1:
    }



/*
    static boolean access$302(BaseServiceBinder baseservicebinder, boolean flag)
    {
        baseservicebinder.mBound = flag;
        return flag;
    }

*/


}
