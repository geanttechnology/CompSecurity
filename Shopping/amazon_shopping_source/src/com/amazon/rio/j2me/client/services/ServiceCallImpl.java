// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services;

import com.amazon.rio.j2me.client.rsc.ServiceCall;
import com.amazon.rio.j2me.client.rsc.ServiceCallInvoker;
import com.amazon.rio.j2me.client.rsc.ServiceCallState;

// Referenced classes of package com.amazon.rio.j2me.client.services:
//            ServiceCall, RioEventListener

public class ServiceCallImpl
    implements com.amazon.rio.j2me.client.services.ServiceCall
{

    private boolean allDataReceived;
    private final RioEventListener eventListener;
    private ServiceCall underlyingCall;

    public ServiceCallImpl(RioEventListener rioeventlistener)
    {
        eventListener = rioeventlistener;
        underlyingCall = null;
    }

    public void allDataReceived()
    {
        this;
        JVM INSTR monitorenter ;
        allDataReceived = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void cancel()
    {
        getUnderlyingCall().cancel();
    }

    public RioEventListener getEventListener()
    {
        return eventListener;
    }

    public String getMethod()
    {
        return underlyingCall.getMethod();
    }

    public ServiceCall getUnderlyingCall()
    {
        this;
        JVM INSTR monitorenter ;
        if (underlyingCall == null)
        {
            throw new IllegalStateException("This really should never happen: attempt to access underlyingCall before object initialized!");
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        ServiceCall servicecall = underlyingCall;
        this;
        JVM INSTR monitorexit ;
        return servicecall;
    }

    public void replay()
    {
        this;
        JVM INSTR monitorenter ;
        if (!allDataReceived && !getUnderlyingCall().getState().isTerminalState())
        {
            throw new RuntimeException("can't replay call until after original call completes");
        }
        break MISSING_BLOCK_LABEL_39;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        setUnderlyingCall(underlyingCall.getServiceCallInvoker().invoke(underlyingCall.getServiceName(), underlyingCall.getMethod(), underlyingCall.getApplicationID(), underlyingCall.isSecure(), underlyingCall.allowCookies(), underlyingCall.getClientRequestReply()));
        allDataReceived = false;
        this;
        JVM INSTR monitorexit ;
    }

    public void setUnderlyingCall(ServiceCall servicecall)
    {
        this;
        JVM INSTR monitorenter ;
        underlyingCall = servicecall;
        this;
        JVM INSTR monitorexit ;
        return;
        servicecall;
        throw servicecall;
    }
}
