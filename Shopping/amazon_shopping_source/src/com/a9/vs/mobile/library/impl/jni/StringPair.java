// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI

public class StringPair
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public StringPair()
    {
        this(A9VSMobileJNI.new_StringPair__SWIG_0(), true);
    }

    protected StringPair(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    public StringPair(StringPair stringpair)
    {
        this(A9VSMobileJNI.new_StringPair__SWIG_2(getCPtr(stringpair), stringpair), true);
    }

    public StringPair(String s, String s1)
    {
        this(A9VSMobileJNI.new_StringPair__SWIG_1(s, s1), true);
    }

    protected static long getCPtr(StringPair stringpair)
    {
        if (stringpair == null)
        {
            return 0L;
        } else
        {
            return stringpair.swigCPtr;
        }
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
                A9VSMobileJNI.delete_StringPair(swigCPtr);
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

    public String getFirst()
    {
        return A9VSMobileJNI.StringPair_first_get(swigCPtr, this);
    }

    public String getSecond()
    {
        return A9VSMobileJNI.StringPair_second_get(swigCPtr, this);
    }

    public void setFirst(String s)
    {
        A9VSMobileJNI.StringPair_first_set(swigCPtr, this, s);
    }

    public void setSecond(String s)
    {
        A9VSMobileJNI.StringPair_second_set(swigCPtr, this, s);
    }
}
