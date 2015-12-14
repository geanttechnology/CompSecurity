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
import com.amazon.identity.platform.metric.MetricsHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            SSOIntentFactory

public abstract class BoundServiceManager
    implements ServiceConnection
{
    public static abstract class BoundServiceCallback
    {

        public abstract void onError();

        public abstract void useService(Object obj)
            throws RemoteException;

        public BoundServiceCallback()
        {
        }
    }

    private static class OnErrorRunnable
        implements Runnable
    {

        private final BoundServiceCallback mCallback;

        public void run()
        {
            mCallback.onError();
        }

        OnErrorRunnable(BoundServiceCallback boundservicecallback)
        {
            mCallback = boundservicecallback;
        }
    }

    private class RunnableBoundServiceCallback
        implements Runnable
    {

        private final BoundServiceCallback mCallback;
        final BoundServiceManager this$0;

        public void run()
        {
            synchronized (BoundServiceManager.this)
            {
                obj = mBoundService;
            }
            if (obj == null)
            {
                MAPLog.w(BoundServiceManager.TAG, "Service was disconnected before task could execute; re-enqueuing task to run after service re-connects.");
                callbackWhenServiceIsAvailable(mCallback);
                return;
            }
            try
            {
                mCallback.useService(obj);
                return;
            }
            catch (RemoteException remoteexception)
            {
                mCallback.onError();
            }
        }


        RunnableBoundServiceCallback(BoundServiceCallback boundservicecallback)
        {
            this$0 = BoundServiceManager.this;
            super();
            mCallback = boundservicecallback;
        }
    }


    static final long CONNECTION_TIMEOUT;
    private static final String TAG = com/amazon/identity/auth/device/framework/BoundServiceManager.getName();
    private boolean mBindInitiated;
    private Object mBoundService;
    private ComponentName mComponentName;
    private final Context mContext;
    private final Executor mExecutor;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final List mOutstandingCallbacks = new LinkedList();
    private List mQueue;
    private final String mServiceClassName;

    public BoundServiceManager(Context context, String s, Executor executor)
    {
        mContext = context.getApplicationContext();
        mServiceClassName = s;
        mExecutor = executor;
    }

    private void callbackWhenServiceIsAvailable(BoundServiceCallback boundservicecallback)
    {
        this;
        JVM INSTR monitorenter ;
        boundservicecallback = new RunnableBoundServiceCallback(boundservicecallback);
        if (mBoundService != null) goto _L2; else goto _L1
_L1:
        if (mQueue == null)
        {
            mQueue = new ArrayList();
            mHandler.postDelayed(new Runnable() {

                final BoundServiceManager this$0;

                public void run()
                {
label0:
                    {
                        synchronized (BoundServiceManager.this)
                        {
                            if (mBoundService == null)
                            {
                                break label0;
                            }
                        }
                        return;
                    }
                    Object obj1;
                    MAPLog.e(BoundServiceManager.TAG, (new StringBuilder("Application timed out trying to bind to ")).append(mComponentName).toString());
                    obj1 = mQueue;
                    mQueue;
                    obj;
                    JVM INSTR monitorexit ;
                    if (obj1 != null)
                    {
                        MetricsHelper.incrementCounter("BindTimeout", new String[0]);
                        for (obj = ((List) (obj1)).iterator(); ((Iterator) (obj)).hasNext(); mExecutor.execute(new OnErrorRunnable(((RunnableBoundServiceCallback) (obj1)).mCallback)))
                        {
                            obj1 = (RunnableBoundServiceCallback)((Iterator) (obj)).next();
                        }

                    }
                    break MISSING_BLOCK_LABEL_136;
                    exception;
                    throw exception;
                }

            
            {
                this$0 = BoundServiceManager.this;
                super();
            }
            }, CONNECTION_TIMEOUT);
        }
        mQueue.add(boundservicecallback);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        mExecutor.execute(boundservicecallback);
        if (true) goto _L4; else goto _L3
_L3:
        boundservicecallback;
        throw boundservicecallback;
    }

    private ComponentName getComponentName()
    {
        this;
        JVM INSTR monitorenter ;
        if (mComponentName == null) goto _L2; else goto _L1
_L1:
        ComponentName componentname = mComponentName;
_L3:
        this;
        JVM INSTR monitorexit ;
        return componentname;
_L2:
        mComponentName = SSOIntentFactory.findSSOComponent(mContext, mServiceClassName, SSOIntentFactory.SERVICE_FINDER);
        if (mComponentName != null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        MAPLog.e(TAG, (new StringBuilder("Couldn't find ")).append(mServiceClassName).toString());
_L4:
        componentname = mComponentName;
          goto _L3
        String s = TAG;
        (new StringBuilder("Found service ")).append(mComponentName).toString();
          goto _L4
        Exception exception;
        exception;
        throw exception;
    }

    protected abstract Object asInterface(IBinder ibinder);

    public void doneUsingService(BoundServiceCallback boundservicecallback)
    {
        this;
        JVM INSTR monitorenter ;
        mOutstandingCallbacks.remove(boundservicecallback);
        this;
        JVM INSTR monitorexit ;
        return;
        boundservicecallback;
        throw boundservicecallback;
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        this;
        JVM INSTR monitorenter ;
        componentname = TAG;
        (new StringBuilder("onServiceConnected: ")).append(mComponentName).toString();
        mBoundService = asInterface(ibinder);
        componentname = mQueue;
        mQueue = null;
        this;
        JVM INSTR monitorexit ;
        if (componentname != null)
        {
            for (componentname = componentname.iterator(); componentname.hasNext(); mExecutor.execute(ibinder))
            {
                ibinder = (RunnableBoundServiceCallback)componentname.next();
            }

        }
        break MISSING_BLOCK_LABEL_95;
        componentname;
        throw componentname;
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        this;
        JVM INSTR monitorenter ;
        componentname = TAG;
        (new StringBuilder("onServiceDisconnected: ")).append(mComponentName).toString();
        mBoundService = null;
        BoundServiceCallback boundservicecallback;
        for (componentname = mOutstandingCallbacks.iterator(); componentname.hasNext(); mExecutor.execute(new OnErrorRunnable(boundservicecallback)))
        {
            boundservicecallback = (BoundServiceCallback)componentname.next();
        }

        break MISSING_BLOCK_LABEL_85;
        componentname;
        throw componentname;
        mOutstandingCallbacks.clear();
        this;
        JVM INSTR monitorexit ;
    }

    public void startUsingServiceAsynchronously(BoundServiceCallback boundservicecallback)
    {
        this;
        JVM INSTR monitorenter ;
        mOutstandingCallbacks.add(boundservicecallback);
        this;
        JVM INSTR monitorexit ;
        return;
        boundservicecallback;
        throw boundservicecallback;
    }

    public boolean tryToBind()
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        if (mBoundService == null) goto _L2; else goto _L1
_L1:
        String s = TAG;
        (new StringBuilder("already bound: ")).append(mComponentName).toString();
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (mBindInitiated)
        {
            String s1 = TAG;
            (new StringBuilder("bind already initiated: ")).append(mComponentName).toString();
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_78;
        Object obj;
        obj;
        throw obj;
        ComponentName componentname = getComponentName();
        if (componentname == null)
        {
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        Intent intent;
        intent = new Intent();
        intent.setComponent(componentname);
        if (mContext.bindService(intent, this, 21))
        {
            String s2 = TAG;
            (new StringBuilder("binding: ")).append(mComponentName).toString();
            mBindInitiated = true;
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_194;
        s2;
        MetricsHelper.incrementCounter("BindFailed", new String[0]);
        MAPLog.w(TAG, (new StringBuilder("bind failed: ")).append(mComponentName).toString(), s2);
        flag = false;
        continue; /* Loop/switch isn't completed */
        MetricsHelper.incrementCounter("BindFailed", new String[0]);
        MAPLog.w(TAG, (new StringBuilder("bind failed: ")).append(mComponentName).toString());
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void useService(BoundServiceCallback boundservicecallback)
    {
        this;
        JVM INSTR monitorenter ;
        if (tryToBind()) goto _L2; else goto _L1
_L1:
        boundservicecallback.onError();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        callbackWhenServiceIsAvailable(boundservicecallback);
        if (true) goto _L4; else goto _L3
_L3:
        boundservicecallback;
        throw boundservicecallback;
    }

    public boolean useServiceIfAlreadyBound(BoundServiceCallback boundservicecallback)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = mBoundService;
        if (obj != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        callbackWhenServiceIsAvailable(boundservicecallback);
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
        boundservicecallback;
        throw boundservicecallback;
    }

    static 
    {
        CONNECTION_TIMEOUT = TimeUnit.MILLISECONDS.convert(3L, TimeUnit.SECONDS);
    }






/*
    static List access$302$39f4b877(BoundServiceManager boundservicemanager)
    {
        boundservicemanager.mQueue = null;
        return null;
    }

*/


}
