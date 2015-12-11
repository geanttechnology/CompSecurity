// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.rsc;

import com.amazon.rio.j2me.client.trans.IServiceConnection;
import com.amazon.rio.j2me.client.util.Logger;
import com.amazon.rio.j2me.client.util.Worker;
import com.amazon.rio.j2me.client.util.WorkerPool;

// Referenced classes of package com.amazon.rio.j2me.client.rsc:
//            ServiceCallImpl

class val.worker
    implements Runnable
{

    final ServiceCallImpl this$0;
    final Worker val$worker;

    public void run()
    {
        ServiceCallImpl.access$000(ServiceCallImpl.this).cancel();
        ServiceCallImpl.access$300().releaseWorker(val$worker);
        return;
        Object obj;
        obj;
        ServiceCallImpl.access$200().error((new StringBuilder()).append("serverConnection.cancel() failed: id=").append(ServiceCallImpl.access$100(ServiceCallImpl.this)).append(" exp=").append(obj).toString());
        ServiceCallImpl.access$300().releaseWorker(val$worker);
        return;
        obj;
        ServiceCallImpl.access$300().releaseWorker(val$worker);
        throw obj;
    }

    on()
    {
        this$0 = final_servicecallimpl;
        val$worker = Worker.this;
        super();
    }
}
