// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            jniLivenessAndTMJNI, LandmarkPoint

public class LandmarkVector
{

    private long a;
    protected boolean swigCMemOwn;

    public LandmarkVector()
    {
        this(jniLivenessAndTMJNI.new_LandmarkVector__SWIG_0(), true);
    }

    public LandmarkVector(long l)
    {
        this(jniLivenessAndTMJNI.new_LandmarkVector__SWIG_1(l), true);
    }

    protected LandmarkVector(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(LandmarkVector landmarkvector)
    {
        if (landmarkvector == null)
        {
            return 0L;
        } else
        {
            return landmarkvector.a;
        }
    }

    public void add(LandmarkPoint landmarkpoint)
    {
        jniLivenessAndTMJNI.LandmarkVector_add(a, this, LandmarkPoint.getCPtr(landmarkpoint), landmarkpoint);
    }

    public long capacity()
    {
        return jniLivenessAndTMJNI.LandmarkVector_capacity(a, this);
    }

    public void clear()
    {
        jniLivenessAndTMJNI.LandmarkVector_clear(a, this);
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
                jniLivenessAndTMJNI.delete_LandmarkVector(a);
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

    public LandmarkPoint get(int i)
    {
        return new LandmarkPoint(jniLivenessAndTMJNI.LandmarkVector_get(a, this, i), false);
    }

    public boolean isEmpty()
    {
        return jniLivenessAndTMJNI.LandmarkVector_isEmpty(a, this);
    }

    public void reserve(long l)
    {
        jniLivenessAndTMJNI.LandmarkVector_reserve(a, this, l);
    }

    public void set(int i, LandmarkPoint landmarkpoint)
    {
        jniLivenessAndTMJNI.LandmarkVector_set(a, this, i, LandmarkPoint.getCPtr(landmarkpoint), landmarkpoint);
    }

    public long size()
    {
        return jniLivenessAndTMJNI.LandmarkVector_size(a, this);
    }
}
