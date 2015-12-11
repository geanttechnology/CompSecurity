// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, BusinessCardEntity

public class VectorOfBusinessCardEntities
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public VectorOfBusinessCardEntities()
    {
        this(A9VSMobileJNI.new_VectorOfBusinessCardEntities__SWIG_0(), true);
    }

    public VectorOfBusinessCardEntities(long l)
    {
        this(A9VSMobileJNI.new_VectorOfBusinessCardEntities__SWIG_1(l), true);
    }

    protected VectorOfBusinessCardEntities(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(VectorOfBusinessCardEntities vectorofbusinesscardentities)
    {
        if (vectorofbusinesscardentities == null)
        {
            return 0L;
        } else
        {
            return vectorofbusinesscardentities.swigCPtr;
        }
    }

    public void add(BusinessCardEntity businesscardentity)
    {
        A9VSMobileJNI.VectorOfBusinessCardEntities_add(swigCPtr, this, BusinessCardEntity.getCPtr(businesscardentity), businesscardentity);
    }

    public long capacity()
    {
        return A9VSMobileJNI.VectorOfBusinessCardEntities_capacity(swigCPtr, this);
    }

    public void clear()
    {
        A9VSMobileJNI.VectorOfBusinessCardEntities_clear(swigCPtr, this);
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
                A9VSMobileJNI.delete_VectorOfBusinessCardEntities(swigCPtr);
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

    public BusinessCardEntity get(int i)
    {
        return new BusinessCardEntity(A9VSMobileJNI.VectorOfBusinessCardEntities_get(swigCPtr, this, i), false);
    }

    public boolean isEmpty()
    {
        return A9VSMobileJNI.VectorOfBusinessCardEntities_isEmpty(swigCPtr, this);
    }

    public void reserve(long l)
    {
        A9VSMobileJNI.VectorOfBusinessCardEntities_reserve(swigCPtr, this, l);
    }

    public void set(int i, BusinessCardEntity businesscardentity)
    {
        A9VSMobileJNI.VectorOfBusinessCardEntities_set(swigCPtr, this, i, BusinessCardEntity.getCPtr(businesscardentity), businesscardentity);
    }

    public long size()
    {
        return A9VSMobileJNI.VectorOfBusinessCardEntities_size(swigCPtr, this);
    }
}
