// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mrz.impl.smartEngines.swig;


// Referenced classes of package com.jumio.mrz.impl.smartEngines.swig:
//            mrzjniInterfaceJNI

public class MrzDate
{

    private long a;
    protected boolean swigCMemOwn;

    public MrzDate()
    {
        this(mrzjniInterfaceJNI.new_MrzDate__SWIG_3(), true);
    }

    public MrzDate(int i)
    {
        this(mrzjniInterfaceJNI.new_MrzDate__SWIG_2(i), true);
    }

    public MrzDate(int i, int j)
    {
        this(mrzjniInterfaceJNI.new_MrzDate__SWIG_1(i, j), true);
    }

    public MrzDate(int i, int j, int k)
    {
        this(mrzjniInterfaceJNI.new_MrzDate__SWIG_0(i, j, k), true);
    }

    protected MrzDate(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public MrzDate(MrzDate mrzdate)
    {
        this(mrzjniInterfaceJNI.new_MrzDate__SWIG_4(getCPtr(mrzdate), mrzdate), true);
    }

    protected static long getCPtr(MrzDate mrzdate)
    {
        if (mrzdate == null)
        {
            return 0L;
        } else
        {
            return mrzdate.a;
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
                mrzjniInterfaceJNI.delete_MrzDate(a);
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

    public int getDay()
    {
        return mrzjniInterfaceJNI.MrzDate_getDay(a, this);
    }

    public int getMonth()
    {
        return mrzjniInterfaceJNI.MrzDate_getMonth(a, this);
    }

    public int getYear()
    {
        return mrzjniInterfaceJNI.MrzDate_getYear(a, this);
    }

    public boolean isDayPresent()
    {
        return mrzjniInterfaceJNI.MrzDate_isDayPresent(a, this);
    }

    public boolean isMonthPresent()
    {
        return mrzjniInterfaceJNI.MrzDate_isMonthPresent(a, this);
    }

    public boolean isYearPresent()
    {
        return mrzjniInterfaceJNI.MrzDate_isYearPresent(a, this);
    }

    public void setDay(int i)
    {
        mrzjniInterfaceJNI.MrzDate_setDay(a, this, i);
    }

    public void setMonth(int i)
    {
        mrzjniInterfaceJNI.MrzDate_setMonth(a, this, i);
    }

    public void setYear(int i)
    {
        mrzjniInterfaceJNI.MrzDate_setYear(a, this, i);
    }
}
