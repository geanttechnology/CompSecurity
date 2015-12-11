// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            ServerDelegateInterface, A9VSMobileJNI, ServerResponse, ServerRequest

public class ServerDelegate extends ServerDelegateInterface
{

    private long swigCPtr;

    public ServerDelegate()
    {
        this(A9VSMobileJNI.new_ServerDelegate(), true);
        A9VSMobileJNI.ServerDelegate_director_connect(this, swigCPtr, swigCMemOwn, true);
    }

    protected ServerDelegate(long l, boolean flag)
    {
        super(A9VSMobileJNI.ServerDelegate_SWIGUpcast(l), flag);
        swigCPtr = l;
    }

    protected static long getCPtr(ServerDelegate serverdelegate)
    {
        if (serverdelegate == null)
        {
            return 0L;
        } else
        {
            return serverdelegate.swigCPtr;
        }
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (swigCPtr != 0L)
        {
            if (swigCMemOwn)
            {
                swigCMemOwn = false;
                A9VSMobileJNI.delete_ServerDelegate(swigCPtr);
            }
            swigCPtr = 0L;
        }
        super.delete();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void finalize()
    {
        delete();
    }

    public void pushServerResponse(ServerResponse serverresponse)
    {
        A9VSMobileJNI.ServerDelegate_pushServerResponse(swigCPtr, this, ServerResponse.getCPtr(serverresponse), serverresponse);
    }

    public boolean sendServerRequest(ServerRequest serverrequest)
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/ServerDelegate)
        {
            return A9VSMobileJNI.ServerDelegate_sendServerRequest(swigCPtr, this, ServerRequest.getCPtr(serverrequest), serverrequest);
        } else
        {
            return A9VSMobileJNI.ServerDelegate_sendServerRequestSwigExplicitServerDelegate(swigCPtr, this, ServerRequest.getCPtr(serverrequest), serverrequest);
        }
    }

    protected boolean sendServerRequestImpl(ServerRequest serverrequest)
    {
        return A9VSMobileJNI.ServerDelegate_sendServerRequestImpl(swigCPtr, this, ServerRequest.getCPtr(serverrequest), serverrequest);
    }

    protected void swigDirectorDisconnect()
    {
        swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership()
    {
        swigCMemOwn = false;
        A9VSMobileJNI.ServerDelegate_change_ownership(this, swigCPtr, false);
    }

    public void swigTakeOwnership()
    {
        swigCMemOwn = true;
        A9VSMobileJNI.ServerDelegate_change_ownership(this, swigCPtr, true);
    }
}
