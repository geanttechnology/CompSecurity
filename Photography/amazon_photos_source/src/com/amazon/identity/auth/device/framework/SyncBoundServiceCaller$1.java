// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            BoundServiceCaller, SyncBoundServiceCaller

class  extends BoundServiceCaller
{

    final SyncBoundServiceCaller this$0;

    protected void useService(final ComponentName componentName, final IBinder service)
        throws RemoteException
    {
        SyncBoundServiceCaller.access$000().execute(new Runnable() {

            final SyncBoundServiceCaller._cls1 this$1;
            final ComponentName val$componentName;
            final IBinder val$service;

            public void run()
            {
                useService(componentName, service);
            }

            
            {
                this$1 = SyncBoundServiceCaller._cls1.this;
                componentName = componentname;
                service = ibinder;
                super();
            }
        });
    }

    protected void useService(IBinder ibinder)
        throws RemoteException
    {
    }

    _cls1.val.service(Context context, Intent intent, int i)
    {
        this$0 = SyncBoundServiceCaller.this;
        super(context, intent, i);
    }
}
