// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI

public class ByteArray
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public ByteArray()
    {
        this(A9VSMobileJNI.new_ByteArray__SWIG_0(), true);
    }

    protected ByteArray(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    public ByteArray(ByteArray bytearray)
    {
        this(A9VSMobileJNI.new_ByteArray__SWIG_1(getCPtr(bytearray), bytearray), true);
    }

    protected static long getCPtr(ByteArray bytearray)
    {
        if (bytearray == null)
        {
            return 0L;
        } else
        {
            return bytearray.swigCPtr;
        }
    }

    public void clear()
    {
        A9VSMobileJNI.ByteArray_clear(swigCPtr, this);
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
                A9VSMobileJNI.delete_ByteArray(swigCPtr);
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

    public byte[] getData()
    {
        return A9VSMobileJNI.ByteArray_getData(swigCPtr, this);
    }

    public int getLength()
    {
        return A9VSMobileJNI.ByteArray_getLength(swigCPtr, this);
    }
}
