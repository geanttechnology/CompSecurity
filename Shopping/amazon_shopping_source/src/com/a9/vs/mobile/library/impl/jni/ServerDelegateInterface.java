// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, ServerRequest

public class ServerDelegateInterface
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected ServerDelegateInterface(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(ServerDelegateInterface serverdelegateinterface)
    {
        if (serverdelegateinterface == null)
        {
            return 0L;
        } else
        {
            return serverdelegateinterface.swigCPtr;
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
                A9VSMobileJNI.delete_ServerDelegateInterface(swigCPtr);
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

    public boolean sendServerRequest(ServerRequest serverrequest)
    {
        return A9VSMobileJNI.ServerDelegateInterface_sendServerRequest(swigCPtr, this, ServerRequest.getCPtr(serverrequest), serverrequest);
    }
}
