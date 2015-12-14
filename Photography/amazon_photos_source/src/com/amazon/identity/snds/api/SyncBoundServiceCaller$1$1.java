// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.snds.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.identity.snds.api:
//            SyncBoundServiceCaller, BoundServiceCaller

class val.service
    implements Runnable
{

    final val.service this$1;
    final ComponentName val$componentName;
    final IBinder val$service;

    public void run()
    {
        useService(val$componentName, val$service);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$componentName = componentname;
        val$service = IBinder.this;
        super();
    }

    // Unreferenced inner class com/amazon/identity/snds/api/SyncBoundServiceCaller$1

/* anonymous class */
    class SyncBoundServiceCaller._cls1 extends BoundServiceCaller
    {

        final SyncBoundServiceCaller this$0;

        protected void useService(final ComponentName componentName, IBinder ibinder)
            throws RemoteException
        {
            SyncBoundServiceCaller.access$000().execute(ibinder. new SyncBoundServiceCaller._cls1._cls1());
        }

        protected void useService(IBinder ibinder)
            throws RemoteException
        {
        }

            
            {
                this$0 = SyncBoundServiceCaller.this;
                super(context, intent, i);
            }
    }

}
