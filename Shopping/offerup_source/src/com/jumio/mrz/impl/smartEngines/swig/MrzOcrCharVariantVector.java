// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mrz.impl.smartEngines.swig;


// Referenced classes of package com.jumio.mrz.impl.smartEngines.swig:
//            mrzjniInterfaceJNI, MrzOcrCharVariant

public class MrzOcrCharVariantVector
{

    private long a;
    protected boolean swigCMemOwn;

    public MrzOcrCharVariantVector()
    {
        this(mrzjniInterfaceJNI.new_MrzOcrCharVariantVector__SWIG_0(), true);
    }

    public MrzOcrCharVariantVector(long l)
    {
        this(mrzjniInterfaceJNI.new_MrzOcrCharVariantVector__SWIG_1(l), true);
    }

    protected MrzOcrCharVariantVector(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(MrzOcrCharVariantVector mrzocrcharvariantvector)
    {
        if (mrzocrcharvariantvector == null)
        {
            return 0L;
        } else
        {
            return mrzocrcharvariantvector.a;
        }
    }

    public void add(MrzOcrCharVariant mrzocrcharvariant)
    {
        mrzjniInterfaceJNI.MrzOcrCharVariantVector_add(a, this, MrzOcrCharVariant.getCPtr(mrzocrcharvariant), mrzocrcharvariant);
    }

    public long capacity()
    {
        return mrzjniInterfaceJNI.MrzOcrCharVariantVector_capacity(a, this);
    }

    public void clear()
    {
        mrzjniInterfaceJNI.MrzOcrCharVariantVector_clear(a, this);
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (a != 0L)
        {
            if (swigCMemOwn)
            {
                swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzOcrCharVariantVector(a);
            }
            a = 0L;
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

    public MrzOcrCharVariant get(int i)
    {
        return new MrzOcrCharVariant(mrzjniInterfaceJNI.MrzOcrCharVariantVector_get(a, this, i), false);
    }

    public boolean isEmpty()
    {
        return mrzjniInterfaceJNI.MrzOcrCharVariantVector_isEmpty(a, this);
    }

    public void reserve(long l)
    {
        mrzjniInterfaceJNI.MrzOcrCharVariantVector_reserve(a, this, l);
    }

    public void set(int i, MrzOcrCharVariant mrzocrcharvariant)
    {
        mrzjniInterfaceJNI.MrzOcrCharVariantVector_set(a, this, i, MrzOcrCharVariant.getCPtr(mrzocrcharvariant), mrzocrcharvariant);
    }

    public long size()
    {
        return mrzjniInterfaceJNI.MrzOcrCharVariantVector_size(a, this);
    }
}
