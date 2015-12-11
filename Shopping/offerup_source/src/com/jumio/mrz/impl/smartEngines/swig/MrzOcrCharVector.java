// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mrz.impl.smartEngines.swig;


// Referenced classes of package com.jumio.mrz.impl.smartEngines.swig:
//            mrzjniInterfaceJNI, MrzOcrChar

public class MrzOcrCharVector
{

    private long a;
    protected boolean swigCMemOwn;

    public MrzOcrCharVector()
    {
        this(mrzjniInterfaceJNI.new_MrzOcrCharVector__SWIG_0(), true);
    }

    public MrzOcrCharVector(long l)
    {
        this(mrzjniInterfaceJNI.new_MrzOcrCharVector__SWIG_1(l), true);
    }

    protected MrzOcrCharVector(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(MrzOcrCharVector mrzocrcharvector)
    {
        if (mrzocrcharvector == null)
        {
            return 0L;
        } else
        {
            return mrzocrcharvector.a;
        }
    }

    public void add(MrzOcrChar mrzocrchar)
    {
        mrzjniInterfaceJNI.MrzOcrCharVector_add(a, this, MrzOcrChar.getCPtr(mrzocrchar), mrzocrchar);
    }

    public long capacity()
    {
        return mrzjniInterfaceJNI.MrzOcrCharVector_capacity(a, this);
    }

    public void clear()
    {
        mrzjniInterfaceJNI.MrzOcrCharVector_clear(a, this);
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
                mrzjniInterfaceJNI.delete_MrzOcrCharVector(a);
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

    public MrzOcrChar get(int i)
    {
        return new MrzOcrChar(mrzjniInterfaceJNI.MrzOcrCharVector_get(a, this, i), false);
    }

    public boolean isEmpty()
    {
        return mrzjniInterfaceJNI.MrzOcrCharVector_isEmpty(a, this);
    }

    public void reserve(long l)
    {
        mrzjniInterfaceJNI.MrzOcrCharVector_reserve(a, this, l);
    }

    public void set(int i, MrzOcrChar mrzocrchar)
    {
        mrzjniInterfaceJNI.MrzOcrCharVector_set(a, this, i, MrzOcrChar.getCPtr(mrzocrchar), mrzocrchar);
    }

    public long size()
    {
        return mrzjniInterfaceJNI.MrzOcrCharVector_size(a, this);
    }
}
