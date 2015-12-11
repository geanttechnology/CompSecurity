// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mrz.impl.smartEngines.swig;


// Referenced classes of package com.jumio.mrz.impl.smartEngines.swig:
//            mrzjniInterfaceJNI, MrzRectVector

public class MrzRectMatrix
{

    private long a;
    protected boolean swigCMemOwn;

    public MrzRectMatrix()
    {
        this(mrzjniInterfaceJNI.new_MrzRectMatrix__SWIG_0(), true);
    }

    public MrzRectMatrix(long l)
    {
        this(mrzjniInterfaceJNI.new_MrzRectMatrix__SWIG_1(l), true);
    }

    protected MrzRectMatrix(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(MrzRectMatrix mrzrectmatrix)
    {
        if (mrzrectmatrix == null)
        {
            return 0L;
        } else
        {
            return mrzrectmatrix.a;
        }
    }

    public void add(MrzRectVector mrzrectvector)
    {
        mrzjniInterfaceJNI.MrzRectMatrix_add(a, this, MrzRectVector.getCPtr(mrzrectvector), mrzrectvector);
    }

    public long capacity()
    {
        return mrzjniInterfaceJNI.MrzRectMatrix_capacity(a, this);
    }

    public void clear()
    {
        mrzjniInterfaceJNI.MrzRectMatrix_clear(a, this);
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
                mrzjniInterfaceJNI.delete_MrzRectMatrix(a);
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

    public MrzRectVector get(int i)
    {
        return new MrzRectVector(mrzjniInterfaceJNI.MrzRectMatrix_get(a, this, i), false);
    }

    public boolean isEmpty()
    {
        return mrzjniInterfaceJNI.MrzRectMatrix_isEmpty(a, this);
    }

    public void reserve(long l)
    {
        mrzjniInterfaceJNI.MrzRectMatrix_reserve(a, this, l);
    }

    public void set(int i, MrzRectVector mrzrectvector)
    {
        mrzjniInterfaceJNI.MrzRectMatrix_set(a, this, i, MrzRectVector.getCPtr(mrzrectvector), mrzrectvector);
    }

    public long size()
    {
        return mrzjniInterfaceJNI.MrzRectMatrix_size(a, this);
    }
}
