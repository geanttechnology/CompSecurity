// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.amazon.identity.auth.device.callback.AsyncToSyncAdapter;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            BoundServiceCaller

public abstract class SyncBoundServiceCaller extends AsyncToSyncAdapter
{

    private static final Executor THREAD_POOL = Executors.newFixedThreadPool(4, ThreadUtils.getNamedThreadFactory("MAP-SyncBoundServiceCallerThreadPool"));
    private final BoundServiceCaller mServiceCaller;

    public SyncBoundServiceCaller(Context context, Intent intent, int i)
    {
        mServiceCaller = new BoundServiceCaller(context, intent, i) {

            final SyncBoundServiceCaller this$0;

            protected void useService(final ComponentName componentName, IBinder ibinder)
                throws RemoteException
            {
                SyncBoundServiceCaller.THREAD_POOL.execute(ibinder. new Runnable() {

                    final _cls1 this$1;
                    final ComponentName val$componentName;
                    final IBinder val$service;

                    public void run()
                    {
                        useService(componentName, service);
                    }

            
            {
                this$1 = final__pcls1;
                componentName = componentname;
                service = IBinder.this;
                super();
            }
                });
            }

            protected void useService(IBinder ibinder)
                throws RemoteException
            {
            }

            
            {
                this$0 = SyncBoundServiceCaller.this;
                super(context, intent, i);
            }
        };
    }

    protected void doneUsingService()
    {
        mServiceCaller.unbind();
        asyncOperationComplete();
    }

    protected void startAsyncOperation()
    {
        if (!mServiceCaller.call())
        {
            doneUsingService();
        }
    }

    protected void useService(ComponentName componentname, IBinder ibinder)
    {
        useService(ibinder);
    }

    protected void useService(IBinder ibinder)
    {
    }


}
