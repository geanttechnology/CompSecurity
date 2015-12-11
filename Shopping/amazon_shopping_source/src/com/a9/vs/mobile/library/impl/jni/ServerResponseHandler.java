// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, ServerResponse

public class ServerResponseHandler
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected ServerResponseHandler(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(ServerResponseHandler serverresponsehandler)
    {
        if (serverresponsehandler == null)
        {
            return 0L;
        } else
        {
            return serverresponsehandler.swigCPtr;
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
                A9VSMobileJNI.delete_ServerResponseHandler(swigCPtr);
            }
            swigCPtr = 0L;
        }
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

    public void handleServerResponse(ServerResponse serverresponse)
    {
        A9VSMobileJNI.ServerResponseHandler_handleServerResponse(swigCPtr, this, ServerResponse.getCPtr(serverresponse), serverresponse);
    }
}
