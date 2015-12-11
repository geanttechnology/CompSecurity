// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.rsc;

import com.amazon.rio.j2me.client.util.Worker;
import com.amazon.rio.j2me.client.util.WorkerPool;

// Referenced classes of package com.amazon.rio.j2me.client.rsc:
//            AsynchronousServiceCallInvoker, ServiceCallImpl

class val.worker
    implements Runnable
{

    final AsynchronousServiceCallInvoker this$0;
    final ServiceCallImpl val$serviceCall;
    final Worker val$worker;

    public void run()
    {
        val$serviceCall.invoke();
        AsynchronousServiceCallInvoker.access$000(AsynchronousServiceCallInvoker.this).releaseWorker(val$worker);
    }

    ()
    {
        this$0 = final_asynchronousservicecallinvoker;
        val$serviceCall = servicecallimpl;
        val$worker = Worker.this;
        super();
    }
}
