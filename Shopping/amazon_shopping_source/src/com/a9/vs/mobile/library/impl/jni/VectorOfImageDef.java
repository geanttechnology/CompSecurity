// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, ImageDef

public class VectorOfImageDef
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public VectorOfImageDef()
    {
        this(A9VSMobileJNI.new_VectorOfImageDef__SWIG_0(), true);
    }

    public VectorOfImageDef(long l)
    {
        this(A9VSMobileJNI.new_VectorOfImageDef__SWIG_1(l), true);
    }

    protected VectorOfImageDef(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(VectorOfImageDef vectorofimagedef)
    {
        if (vectorofimagedef == null)
        {
            return 0L;
        } else
        {
            return vectorofimagedef.swigCPtr;
        }
    }

    public void add(ImageDef imagedef)
    {
        A9VSMobileJNI.VectorOfImageDef_add(swigCPtr, this, imagedef.swigValue());
    }

    public long capacity()
    {
        return A9VSMobileJNI.VectorOfImageDef_capacity(swigCPtr, this);
    }

    public void clear()
    {
        A9VSMobileJNI.VectorOfImageDef_clear(swigCPtr, this);
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
                A9VSMobileJNI.delete_VectorOfImageDef(swigCPtr);
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

    public ImageDef get(int i)
    {
        return ImageDef.swigToEnum(A9VSMobileJNI.VectorOfImageDef_get(swigCPtr, this, i));
    }

    public boolean isEmpty()
    {
        return A9VSMobileJNI.VectorOfImageDef_isEmpty(swigCPtr, this);
    }

    public void reserve(long l)
    {
        A9VSMobileJNI.VectorOfImageDef_reserve(swigCPtr, this, l);
    }

    public void set(int i, ImageDef imagedef)
    {
        A9VSMobileJNI.VectorOfImageDef_set(swigCPtr, this, i, imagedef.swigValue());
    }

    public long size()
    {
        return A9VSMobileJNI.VectorOfImageDef_size(swigCPtr, this);
    }
}
