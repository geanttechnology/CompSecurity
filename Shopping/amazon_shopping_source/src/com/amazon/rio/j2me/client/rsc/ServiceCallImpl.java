// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.rsc;

import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.trans.IServiceConnection;
import com.amazon.rio.j2me.client.util.LifecycleException;
import com.amazon.rio.j2me.client.util.Logger;
import com.amazon.rio.j2me.client.util.Worker;
import com.amazon.rio.j2me.client.util.WorkerPool;
import com.amazon.rio.j2me.common.rsc.RscResponseHeader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.rsc:
//            ServiceCall, ServiceCallState, ClientRequestReply, RscRequestHeaderWriter, 
//            RscResponseHeaderReader, ServiceCallInvoker

public class ServiceCallImpl
    implements ServiceCall
{
    private static class ServiceCallImplInfo
    {

        private long endTime;
        private String errorString;
        private String method;
        private long startTime;
        private ServiceCallState state;

        protected long getEndTime()
        {
            return endTime;
        }

        protected String getErrorString()
        {
            return errorString;
        }

        protected String getMethod()
        {
            return method;
        }

        protected long getStartTime()
        {
            return startTime;
        }

        protected ServiceCallState getState()
        {
            return state;
        }

        public ServiceCallImplInfo(ServiceCallImpl servicecallimpl)
        {
            startTime = -1L;
            endTime = -1L;
            method = "";
            state = ServiceCallState.NOT_STARTED;
            errorString = "";
            if (servicecallimpl != null)
            {
                startTime = servicecallimpl.getStartTime();
                endTime = servicecallimpl.getEndTime();
                method = servicecallimpl.getMethod();
                state = servicecallimpl.getState();
                if (servicecallimpl.getError() != null)
                {
                    errorString = servicecallimpl.getError().toString();
                }
            }
        }
    }


    private static int _nextId = 0;
    private static final DataStore dataStore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
    private static final Logger logger = com.amazon.mShop.platform.Platform.Factory.getInstance().getLogger(com/amazon/rio/j2me/client/rsc/ServiceCallImpl);
    private static ServiceCallImplInfo sLastServiceCallInfo;
    private static final WorkerPool workerPool = WorkerPool.getInstance();
    private final boolean allowCookies;
    private final String applicationID;
    private final ClientRequestReply clientRequestReply;
    private final String cookieJarKey;
    private long endTime;
    private Exception error;
    private final int id = getId();
    private final String method;
    private final boolean secure;
    private final String secureCookieJarKey;
    private final IServiceConnection serverConnection;
    private final ServiceCallInvoker serviceCallInvoker;
    private final String serviceName;
    private long startTime;
    private ServiceCallState state;

    ServiceCallImpl(ServiceCallInvoker servicecallinvoker, String s, String s1, String s2, boolean flag, boolean flag1, IServiceConnection iserviceconnection, 
            ClientRequestReply clientrequestreply)
    {
        startTime = -1L;
        endTime = -1L;
        state = ServiceCallState.NOT_STARTED;
        serviceCallInvoker = servicecallinvoker;
        serviceName = s;
        method = s1;
        if ("home_v38".equals(s1))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        secure = flag;
        allowCookies = flag1;
        serverConnection = iserviceconnection;
        clientRequestReply = clientrequestreply;
        servicecallinvoker = s2;
        if (s2 != null)
        {
            int i = iserviceconnection.getUrl().indexOf(';');
            servicecallinvoker = s2;
            if (i >= 0)
            {
                servicecallinvoker = (new StringBuilder()).append(s2).append(";connParams=").append(iserviceconnection.getUrl().substring(i).replace(';', '/').replace('=', '@')).toString();
            }
        }
        s1 = servicecallinvoker;
        if (sLastServiceCallInfo != null)
        {
            s1 = servicecallinvoker;
            if (sLastServiceCallInfo.getState() == ServiceCallState.COMPLETED)
            {
                long l = sLastServiceCallInfo.getEndTime() - sLastServiceCallInfo.getStartTime();
                s1 = servicecallinvoker;
                if (l > 0L)
                {
                    float f = (float)l / 1000F;
                    s1 = (new StringBuilder()).append(servicecallinvoker).append(";ttg=").append(sLastServiceCallInfo.getMethod()).append(":").append(f).toString();
                }
            }
        }
        servicecallinvoker = s1;
        if (sLastServiceCallInfo != null)
        {
            servicecallinvoker = s1;
            if (sLastServiceCallInfo.getErrorString() != null)
            {
                servicecallinvoker = (new StringBuilder()).append(s1).append(";prevCallFailed=").append(sLastServiceCallInfo.getMethod()).append(":").append(sLastServiceCallInfo.getErrorString().replace(';', '_').replace('=', ' ')).toString();
            }
        }
        applicationID = servicecallinvoker;
        cookieJarKey = (new StringBuilder()).append("cookieJar.").append(s).toString();
        secureCookieJarKey = (new StringBuilder()).append("secureCookieJar.").append(s).toString();
    }

    private static int getId()
    {
        com/amazon/rio/j2me/client/rsc/ServiceCallImpl;
        JVM INSTR monitorenter ;
        int i;
        i = _nextId;
        _nextId = i + 1;
        com/amazon/rio/j2me/client/rsc/ServiceCallImpl;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    private void setState(ServiceCallState servicecallstate)
    {
        this;
        JVM INSTR monitorenter ;
        state = servicecallstate;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        servicecallstate;
        throw servicecallstate;
    }

    public boolean allowCookies()
    {
        return allowCookies;
    }

    public void cancel()
    {
        this;
        JVM INSTR monitorenter ;
        if (!getState().isTerminalState())
        {
            break MISSING_BLOCK_LABEL_15;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        setState(ServiceCallState.CANCELLED);
        this;
        JVM INSTR monitorexit ;
        try
        {
            final Worker worker = workerPool.acquireWorker();
            worker.execute("serverConnection.cancel()", new Runnable() {

                final ServiceCallImpl this$0;
                final Worker val$worker;

                public void run()
                {
                    serverConnection.cancel();
                    ServiceCallImpl.workerPool.releaseWorker(worker);
                    return;
                    Object obj;
                    obj;
                    ServiceCallImpl.logger.error((new StringBuilder()).append("serverConnection.cancel() failed: id=").append(id).append(" exp=").append(obj).toString());
                    ServiceCallImpl.workerPool.releaseWorker(worker);
                    return;
                    obj;
                    ServiceCallImpl.workerPool.releaseWorker(worker);
                    throw obj;
                }

            
            {
                this$0 = ServiceCallImpl.this;
                worker = worker1;
                super();
            }
            });
            return;
        }
        catch (LifecycleException lifecycleexception)
        {
            throw new RuntimeException((new StringBuilder()).append("unable to obtain worker to cancel connection: exp= ").append(lifecycleexception.toString()).toString());
        }
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String getApplicationID()
    {
        return applicationID;
    }

    public ClientRequestReply getClientRequestReply()
    {
        return clientRequestReply;
    }

    public long getEndTime()
    {
        return endTime;
    }

    public Exception getError()
    {
        return error;
    }

    public String getMethod()
    {
        return method;
    }

    public ServiceCallInvoker getServiceCallInvoker()
    {
        return serviceCallInvoker;
    }

    public String getServiceName()
    {
        return serviceName;
    }

    public long getStartTime()
    {
        return startTime;
    }

    public ServiceCallState getState()
    {
        this;
        JVM INSTR monitorenter ;
        ServiceCallState servicecallstate = state;
        this;
        JVM INSTR monitorexit ;
        return servicecallstate;
        Exception exception;
        exception;
        throw exception;
    }

    void invoke()
    {
        startTime = System.currentTimeMillis();
        this;
        JVM INSTR monitorenter ;
        if (getState() != ServiceCallState.NOT_STARTED)
        {
            throw new IllegalStateException((new StringBuilder()).append("ServiceCallImpl expected to be in ").append(ServiceCallState.NOT_STARTED).append(" state: ").append(this).toString());
        }
        break MISSING_BLOCK_LABEL_134;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        Object obj;
        obj;
        this;
        JVM INSTR monitorenter ;
        if (getState() != ServiceCallState.CANCELLED)
        {
            setState(ServiceCallState.ERROR);
        }
        this;
        JVM INSTR monitorexit ;
        if (getState() != ServiceCallState.CANCELLED)
        {
            break MISSING_BLOCK_LABEL_719;
        }
        clientRequestReply.cancelled(this);
        serverConnection.cancel();
        endTime = System.currentTimeMillis();
        sLastServiceCallInfo = new ServiceCallImplInfo(this);
        return;
        setState(ServiceCallState.EXECUTING);
        this;
        JVM INSTR monitorexit ;
        byte abyte3[];
        obj = new ByteArrayOutputStream();
        clientRequestReply.produceRequestData(((java.io.OutputStream) (obj)), this);
        abyte3 = ((ByteArrayOutputStream) (obj)).toByteArray();
        byte abyte0[];
        Object obj1;
        obj = null;
        obj1 = null;
        abyte0 = ((byte []) (obj1));
        byte abyte2[];
        if (!allowCookies)
        {
            break MISSING_BLOCK_LABEL_223;
        }
        abyte2 = dataStore.getByteArray(cookieJarKey);
        obj = abyte2;
        abyte0 = ((byte []) (obj1));
        if (!secure)
        {
            break MISSING_BLOCK_LABEL_223;
        }
        abyte0 = dataStore.getByteArray(secureCookieJarKey);
        obj = abyte2;
        obj1 = new ByteArrayOutputStream();
        RscRequestHeaderWriter.writeHeader(((java.io.OutputStream) (obj1)), getServiceName(), getMethod(), applicationID, ((byte []) (obj)), abyte0);
        obj = ((ByteArrayOutputStream) (obj1)).toByteArray();
        if (!getState().isTerminalState())
        {
            break MISSING_BLOCK_LABEL_313;
        }
        if (getState() == ServiceCallState.CANCELLED)
        {
            clientRequestReply.cancelled(this);
        }
        serverConnection.cancel();
        endTime = System.currentTimeMillis();
        sLastServiceCallInfo = new ServiceCallImplInfo(this);
        return;
        serverConnection.addCustomHeaders(method);
        obj = serverConnection.send(new byte[][] {
            obj, abyte3
        });
        if (!getState().isTerminalState())
        {
            break MISSING_BLOCK_LABEL_407;
        }
        if (getState() == ServiceCallState.CANCELLED)
        {
            clientRequestReply.cancelled(this);
        }
        serverConnection.cancel();
        endTime = System.currentTimeMillis();
        sLastServiceCallInfo = new ServiceCallImplInfo(this);
        return;
        RscResponseHeader rscresponseheader;
        obj = new DataInputStream(((java.io.InputStream) (obj)));
        rscresponseheader = RscResponseHeaderReader.readHeader(((DataInputStream) (obj)));
        obj1 = rscresponseheader.getException();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_469;
        }
        throw new IOException(((String) (obj1)));
        obj;
        serverConnection.cancel();
        endTime = System.currentTimeMillis();
        sLastServiceCallInfo = new ServiceCallImplInfo(this);
        throw obj;
        byte abyte1[] = rscresponseheader.getCookieJar();
        if (!allowCookies || abyte1 == null)
        {
            break MISSING_BLOCK_LABEL_498;
        }
        dataStore.putByteArray(cookieJarKey, abyte1);
        if (!secure)
        {
            break MISSING_BLOCK_LABEL_534;
        }
        rscresponseheader = rscresponseheader.getSecureCookieJar();
        if (!allowCookies || rscresponseheader == null)
        {
            break MISSING_BLOCK_LABEL_534;
        }
        dataStore.putByteArray(secureCookieJarKey, rscresponseheader);
        clientRequestReply.consumeReply(((java.io.InputStream) (obj)), this);
        serverConnection.close();
        this;
        JVM INSTR monitorenter ;
        if (!getState().isTerminalState())
        {
            setState(ServiceCallState.COMPLETED);
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        serverConnection.cancel();
        endTime = System.currentTimeMillis();
        sLastServiceCallInfo = new ServiceCallImplInfo(this);
        return;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        logger.error((new StringBuilder()).append("invoke() ERROR: post consumeReply exception=").append(obj).append(" this=").append(this).toString());
        serverConnection.cancel();
        this;
        JVM INSTR monitorenter ;
        if (!getState().isTerminalState())
        {
            setState(ServiceCallState.COMPLETED);
        }
        this;
        JVM INSTR monitorexit ;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        this;
        JVM INSTR monitorenter ;
        if (!getState().isTerminalState())
        {
            setState(ServiceCallState.COMPLETED);
        }
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        error = ((Exception) (obj));
        logger.error((new StringBuilder()).append("invoke() ERROR: exception=").append(obj).append(" this=").append(this).toString());
        serverConnection.cancel();
        if (!(obj instanceof IOException))
        {
            break MISSING_BLOCK_LABEL_817;
        }
        clientRequestReply.communicationError(((Exception) (obj)), this);
_L3:
        serverConnection.cancel();
        endTime = System.currentTimeMillis();
        sLastServiceCallInfo = new ServiceCallImplInfo(this);
        return;
        clientRequestReply.internalError(((Exception) (obj)), this);
          goto _L3
    }

    public boolean isSecure()
    {
        return secure;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append('[');
        stringbuffer.append("state=").append(getState());
        stringbuffer.append(", id=").append(id);
        stringbuffer.append(", serverConnection=").append(serverConnection);
        stringbuffer.append(']');
        return stringbuffer.toString();
    }





}
