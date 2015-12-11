// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            jniLivenessAndTMJNI, LibImage

public class FramesVector
{

    private long a;
    protected boolean swigCMemOwn;

    public FramesVector()
    {
        this(jniLivenessAndTMJNI.new_FramesVector__SWIG_0(), true);
    }

    public FramesVector(long l)
    {
        this(jniLivenessAndTMJNI.new_FramesVector__SWIG_1(l), true);
    }

    protected FramesVector(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(FramesVector framesvector)
    {
        if (framesvector == null)
        {
            return 0L;
        } else
        {
            return framesvector.a;
        }
    }

    public void add(LibImage libimage)
    {
        jniLivenessAndTMJNI.FramesVector_add(a, this, LibImage.getCPtr(libimage), libimage);
    }

    public long capacity()
    {
        return jniLivenessAndTMJNI.FramesVector_capacity(a, this);
    }

    public void clear()
    {
        jniLivenessAndTMJNI.FramesVector_clear(a, this);
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
                jniLivenessAndTMJNI.delete_FramesVector(a);
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

    public LibImage get(int i)
    {
        long l = jniLivenessAndTMJNI.FramesVector_get(a, this, i);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new LibImage(l, true);
        }
    }

    public boolean isEmpty()
    {
        return jniLivenessAndTMJNI.FramesVector_isEmpty(a, this);
    }

    public void reserve(long l)
    {
        jniLivenessAndTMJNI.FramesVector_reserve(a, this, l);
    }

    public void set(int i, LibImage libimage)
    {
        jniLivenessAndTMJNI.FramesVector_set(a, this, i, LibImage.getCPtr(libimage), libimage);
    }

    public long size()
    {
        return jniLivenessAndTMJNI.FramesVector_size(a, this);
    }
}
