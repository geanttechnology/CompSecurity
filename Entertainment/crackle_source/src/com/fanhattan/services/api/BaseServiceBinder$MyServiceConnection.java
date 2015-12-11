// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

// Referenced classes of package com.fanhattan.services.api:
//            BaseServiceBinder

final class this._cls0
    implements ServiceConnection
{
    class RebindRunnable
        implements Runnable
    {

        private boolean finish;
        final BaseServiceBinder.MyServiceConnection this$1;

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

        RebindRunnable()
        {
            this$1 = BaseServiceBinder.MyServiceConnection.this;
            super();
        }
    }


    private RebindRunnable mReBindRunnable;
    private volatile Object mService;
    final BaseServiceBinder this$0;

    private boolean bind()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        android.content.Intent intent;
        try
        {
            intent = getIntent();
        }
        catch (Exception exception)
        {
            Log.e(BaseServiceBinder.access$400(BaseServiceBinder.this), "Impossible to find service");
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
        Log.e(BaseServiceBinder.access$400(BaseServiceBinder.this), "Could not bind to service.");
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
                Log.e(BaseServiceBinder.access$400(BaseServiceBinder.this), "Unable to unbind service (already unbound)");
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
        synchronized (BaseServiceBinder.access$200(BaseServiceBinder.this))
        {
            BaseServiceBinder.access$302(BaseServiceBinder.this, true);
            BaseServiceBinder.access$200(BaseServiceBinder.this).notifyAll();
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
        Log.w(BaseServiceBinder.access$400(BaseServiceBinder.this), "Service unexpectedly disconnected.");
        mService = null;
        synchronized (BaseServiceBinder.access$200(BaseServiceBinder.this))
        {
            BaseServiceBinder.access$302(BaseServiceBinder.this, false);
            BaseServiceBinder.access$200(BaseServiceBinder.this).notifyAll();
        }
        if (BaseServiceBinder.access$500(BaseServiceBinder.this))
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



    RebindRunnable.this._cls1()
    {
        this$0 = BaseServiceBinder.this;
        super();
    }
}
