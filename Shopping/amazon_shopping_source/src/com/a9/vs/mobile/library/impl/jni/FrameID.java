// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI

public class FrameID
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public FrameID()
    {
        this(A9VSMobileJNI.new_FrameID(), true);
    }

    protected FrameID(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(FrameID frameid)
    {
        if (frameid == null)
        {
            return 0L;
        } else
        {
            return frameid.swigCPtr;
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
                A9VSMobileJNI.delete_FrameID(swigCPtr);
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

    public String getId()
    {
        return A9VSMobileJNI.FrameID_id_get(swigCPtr, this);
    }

    public void setId(String s)
    {
        A9VSMobileJNI.FrameID_id_set(swigCPtr, this, s);
    }
}
