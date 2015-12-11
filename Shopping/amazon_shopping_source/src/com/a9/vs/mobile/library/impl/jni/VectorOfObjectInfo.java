// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, ObjectInfo

public class VectorOfObjectInfo
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public VectorOfObjectInfo()
    {
        this(A9VSMobileJNI.new_VectorOfObjectInfo__SWIG_0(), true);
    }

    public VectorOfObjectInfo(long l)
    {
        this(A9VSMobileJNI.new_VectorOfObjectInfo__SWIG_1(l), true);
    }

    protected VectorOfObjectInfo(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(VectorOfObjectInfo vectorofobjectinfo)
    {
        if (vectorofobjectinfo == null)
        {
            return 0L;
        } else
        {
            return vectorofobjectinfo.swigCPtr;
        }
    }

    public void add(ObjectInfo objectinfo)
    {
        A9VSMobileJNI.VectorOfObjectInfo_add(swigCPtr, this, ObjectInfo.getCPtr(objectinfo), objectinfo);
    }

    public long capacity()
    {
        return A9VSMobileJNI.VectorOfObjectInfo_capacity(swigCPtr, this);
    }

    public void clear()
    {
        A9VSMobileJNI.VectorOfObjectInfo_clear(swigCPtr, this);
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
                A9VSMobileJNI.delete_VectorOfObjectInfo(swigCPtr);
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

    public ObjectInfo get(int i)
    {
        return new ObjectInfo(A9VSMobileJNI.VectorOfObjectInfo_get(swigCPtr, this, i), false);
    }

    public boolean isEmpty()
    {
        return A9VSMobileJNI.VectorOfObjectInfo_isEmpty(swigCPtr, this);
    }

    public void reserve(long l)
    {
        A9VSMobileJNI.VectorOfObjectInfo_reserve(swigCPtr, this, l);
    }

    public void set(int i, ObjectInfo objectinfo)
    {
        A9VSMobileJNI.VectorOfObjectInfo_set(swigCPtr, this, i, ObjectInfo.getCPtr(objectinfo), objectinfo);
    }

    public long size()
    {
        return A9VSMobileJNI.VectorOfObjectInfo_size(swigCPtr, this);
    }
}
