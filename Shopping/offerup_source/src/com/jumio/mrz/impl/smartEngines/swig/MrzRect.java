// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mrz.impl.smartEngines.swig;


// Referenced classes of package com.jumio.mrz.impl.smartEngines.swig:
//            mrzjniInterfaceJNI

public class MrzRect
{

    private long a;
    protected boolean swigCMemOwn;

    public MrzRect()
    {
        this(mrzjniInterfaceJNI.new_MrzRect__SWIG_4(), true);
    }

    public MrzRect(int i)
    {
        this(mrzjniInterfaceJNI.new_MrzRect__SWIG_3(i), true);
    }

    public MrzRect(int i, int j)
    {
        this(mrzjniInterfaceJNI.new_MrzRect__SWIG_2(i, j), true);
    }

    public MrzRect(int i, int j, int k)
    {
        this(mrzjniInterfaceJNI.new_MrzRect__SWIG_1(i, j, k), true);
    }

    public MrzRect(int i, int j, int k, int l)
    {
        this(mrzjniInterfaceJNI.new_MrzRect__SWIG_0(i, j, k, l), true);
    }

    protected MrzRect(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(MrzRect mrzrect)
    {
        if (mrzrect == null)
        {
            return 0L;
        } else
        {
            return mrzrect.a;
        }
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
                mrzjniInterfaceJNI.delete_MrzRect(a);
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

    public int getHeight()
    {
        return mrzjniInterfaceJNI.MrzRect_getHeight(a, this);
    }

    public int getWidth()
    {
        return mrzjniInterfaceJNI.MrzRect_getWidth(a, this);
    }

    public int getX()
    {
        return mrzjniInterfaceJNI.MrzRect_getX(a, this);
    }

    public int getY()
    {
        return mrzjniInterfaceJNI.MrzRect_getY(a, this);
    }

    public void setHeight(int i)
    {
        mrzjniInterfaceJNI.MrzRect_setHeight(a, this, i);
    }

    public void setWidth(int i)
    {
        mrzjniInterfaceJNI.MrzRect_setWidth(a, this, i);
    }

    public void setX(int i)
    {
        mrzjniInterfaceJNI.MrzRect_setX(a, this, i);
    }

    public void setY(int i)
    {
        mrzjniInterfaceJNI.MrzRect_setY(a, this, i);
    }
}
