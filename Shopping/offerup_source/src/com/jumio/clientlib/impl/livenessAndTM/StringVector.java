// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            jniLivenessAndTMJNI

public class StringVector
{

    private long a;
    protected boolean swigCMemOwn;

    public StringVector()
    {
        this(jniLivenessAndTMJNI.new_StringVector__SWIG_0(), true);
    }

    public StringVector(long l)
    {
        this(jniLivenessAndTMJNI.new_StringVector__SWIG_1(l), true);
    }

    protected StringVector(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(StringVector stringvector)
    {
        if (stringvector == null)
        {
            return 0L;
        } else
        {
            return stringvector.a;
        }
    }

    public void add(String s)
    {
        jniLivenessAndTMJNI.StringVector_add(a, this, s);
    }

    public long capacity()
    {
        return jniLivenessAndTMJNI.StringVector_capacity(a, this);
    }

    public void clear()
    {
        jniLivenessAndTMJNI.StringVector_clear(a, this);
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
                jniLivenessAndTMJNI.delete_StringVector(a);
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

    public String get(int i)
    {
        return jniLivenessAndTMJNI.StringVector_get(a, this, i);
    }

    public boolean isEmpty()
    {
        return jniLivenessAndTMJNI.StringVector_isEmpty(a, this);
    }

    public void reserve(long l)
    {
        jniLivenessAndTMJNI.StringVector_reserve(a, this, l);
    }

    public void set(int i, String s)
    {
        jniLivenessAndTMJNI.StringVector_set(a, this, i, s);
    }

    public long size()
    {
        return jniLivenessAndTMJNI.StringVector_size(a, this);
    }
}
