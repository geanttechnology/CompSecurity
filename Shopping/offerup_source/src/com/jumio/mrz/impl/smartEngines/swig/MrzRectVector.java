// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mrz.impl.smartEngines.swig;


// Referenced classes of package com.jumio.mrz.impl.smartEngines.swig:
//            mrzjniInterfaceJNI, MrzRect

public class MrzRectVector
{

    private long a;
    protected boolean swigCMemOwn;

    public MrzRectVector()
    {
        this(mrzjniInterfaceJNI.new_MrzRectVector__SWIG_0(), true);
    }

    public MrzRectVector(long l)
    {
        this(mrzjniInterfaceJNI.new_MrzRectVector__SWIG_1(l), true);
    }

    protected MrzRectVector(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(MrzRectVector mrzrectvector)
    {
        if (mrzrectvector == null)
        {
            return 0L;
        } else
        {
            return mrzrectvector.a;
        }
    }

    public void add(MrzRect mrzrect)
    {
        mrzjniInterfaceJNI.MrzRectVector_add(a, this, MrzRect.getCPtr(mrzrect), mrzrect);
    }

    public long capacity()
    {
        return mrzjniInterfaceJNI.MrzRectVector_capacity(a, this);
    }

    public void clear()
    {
        mrzjniInterfaceJNI.MrzRectVector_clear(a, this);
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
                mrzjniInterfaceJNI.delete_MrzRectVector(a);
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

    public MrzRect get(int i)
    {
        return new MrzRect(mrzjniInterfaceJNI.MrzRectVector_get(a, this, i), false);
    }

    public boolean isEmpty()
    {
        return mrzjniInterfaceJNI.MrzRectVector_isEmpty(a, this);
    }

    public void reserve(long l)
    {
        mrzjniInterfaceJNI.MrzRectVector_reserve(a, this, l);
    }

    public void set(int i, MrzRect mrzrect)
    {
        mrzjniInterfaceJNI.MrzRectVector_set(a, this, i, MrzRect.getCPtr(mrzrect), mrzrect);
    }

    public long size()
    {
        return mrzjniInterfaceJNI.MrzRectVector_size(a, this);
    }
}
