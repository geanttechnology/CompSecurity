// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.rsc;

import com.amazon.rio.j2me.client.trans.ServerConnectionFactory;
import com.amazon.rio.j2me.client.util.LifecycleException;
import com.amazon.rio.j2me.client.util.Worker;
import com.amazon.rio.j2me.client.util.WorkerPool;

// Referenced classes of package com.amazon.rio.j2me.client.rsc:
//            ServiceCallInvoker, ServiceCallImpl, ClientRequestReply, ServiceCall

public class AsynchronousServiceCallInvoker
    implements ServiceCallInvoker
{

    private final ServerConnectionFactory secureServerConnectionFactory;
    private final ServerConnectionFactory serverConnectionFactory;
    private final int threadPriority;
    private final WorkerPool workerPool;

    public AsynchronousServiceCallInvoker(ServerConnectionFactory serverconnectionfactory, ServerConnectionFactory serverconnectionfactory1)
    {
        this(serverconnectionfactory, serverconnectionfactory1, 5);
    }

    public AsynchronousServiceCallInvoker(ServerConnectionFactory serverconnectionfactory, ServerConnectionFactory serverconnectionfactory1, int i)
    {
        workerPool = WorkerPool.getInstance();
        serverConnectionFactory = serverconnectionfactory;
        secureServerConnectionFactory = serverconnectionfactory1;
        threadPriority = i;
    }

    public ServiceCall invoke(final String serviceCall, final String worker, String s, boolean flag, boolean flag1, ClientRequestReply clientrequestreply)
    {
        com.amazon.rio.j2me.client.trans.IServiceConnection iserviceconnection;
        if ("home_v38".equals(worker))
        {
            iserviceconnection = serverConnectionFactory.getServerConnection();
        } else
        {
            iserviceconnection = secureServerConnectionFactory.getServerConnection();
        }
        serviceCall = new ServiceCallImpl(this, serviceCall, worker, s, flag, flag1, iserviceconnection, clientrequestreply);
        try
        {
            worker = workerPool.acquireWorker();
            worker.setPriority(threadPriority);
            worker.execute("serviceCall.invoke()", new Runnable() {

                final AsynchronousServiceCallInvoker this$0;
                final ServiceCallImpl val$serviceCall;
                final Worker val$worker;

                public void run()
                {
                    serviceCall.invoke();
                    workerPool.releaseWorker(worker);
                }

            
            {
                this$0 = AsynchronousServiceCallInvoker.this;
                serviceCall = servicecallimpl;
                worker = worker1;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (final String serviceCall)
        {
            throw new RuntimeException(serviceCall.toString());
        }
        return serviceCall;
    }

}
