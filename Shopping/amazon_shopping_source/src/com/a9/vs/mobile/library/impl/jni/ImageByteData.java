// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI

public class ImageByteData
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public ImageByteData()
    {
        this(A9VSMobileJNI.new_ImageByteData(), true);
    }

    protected ImageByteData(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(ImageByteData imagebytedata)
    {
        if (imagebytedata == null)
        {
            return 0L;
        } else
        {
            return imagebytedata.swigCPtr;
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
                A9VSMobileJNI.delete_ImageByteData(swigCPtr);
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
        return A9VSMobileJNI.ImageByteData_getData(swigCPtr, this);
    }

    public int getHeight()
    {
        return A9VSMobileJNI.ImageByteData_getHeight(swigCPtr, this);
    }

    public int getLength()
    {
        return A9VSMobileJNI.ImageByteData_getLength(swigCPtr, this);
    }

    public int getWidth()
    {
        return A9VSMobileJNI.ImageByteData_getWidth(swigCPtr, this);
    }
}
