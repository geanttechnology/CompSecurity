// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mrz.impl.smartEngines.swig;


// Referenced classes of package com.jumio.mrz.impl.smartEngines.swig:
//            mrzjniInterfaceJNI, MrzOcrString

public class MrzOcrStringVector
{

    private long a;
    protected boolean swigCMemOwn;

    public MrzOcrStringVector()
    {
        this(mrzjniInterfaceJNI.new_MrzOcrStringVector__SWIG_0(), true);
    }

    public MrzOcrStringVector(long l)
    {
        this(mrzjniInterfaceJNI.new_MrzOcrStringVector__SWIG_1(l), true);
    }

    protected MrzOcrStringVector(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(MrzOcrStringVector mrzocrstringvector)
    {
        if (mrzocrstringvector == null)
        {
            return 0L;
        } else
        {
            return mrzocrstringvector.a;
        }
    }

    public void add(MrzOcrString mrzocrstring)
    {
        mrzjniInterfaceJNI.MrzOcrStringVector_add(a, this, MrzOcrString.getCPtr(mrzocrstring), mrzocrstring);
    }

    public long capacity()
    {
        return mrzjniInterfaceJNI.MrzOcrStringVector_capacity(a, this);
    }

    public void clear()
    {
        mrzjniInterfaceJNI.MrzOcrStringVector_clear(a, this);
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
                mrzjniInterfaceJNI.delete_MrzOcrStringVector(a);
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

    public MrzOcrString get(int i)
    {
        return new MrzOcrString(mrzjniInterfaceJNI.MrzOcrStringVector_get(a, this, i), false);
    }

    public boolean isEmpty()
    {
        return mrzjniInterfaceJNI.MrzOcrStringVector_isEmpty(a, this);
    }

    public void reserve(long l)
    {
        mrzjniInterfaceJNI.MrzOcrStringVector_reserve(a, this, l);
    }

    public void set(int i, MrzOcrString mrzocrstring)
    {
        mrzjniInterfaceJNI.MrzOcrStringVector_set(a, this, i, MrzOcrString.getCPtr(mrzocrstring), mrzocrstring);
    }

    public long size()
    {
        return mrzjniInterfaceJNI.MrzOcrStringVector_size(a, this);
    }
}
