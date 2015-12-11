// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            jniLivenessAndTMJNI

public class LandmarkPoint
{

    private long a;
    protected boolean swigCMemOwn;

    public LandmarkPoint()
    {
        this(jniLivenessAndTMJNI.new_LandmarkPoint__SWIG_2(), true);
    }

    public LandmarkPoint(float f)
    {
        this(jniLivenessAndTMJNI.new_LandmarkPoint__SWIG_1(f), true);
    }

    public LandmarkPoint(float f, float f1)
    {
        this(jniLivenessAndTMJNI.new_LandmarkPoint__SWIG_0(f, f1), true);
    }

    protected LandmarkPoint(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(LandmarkPoint landmarkpoint)
    {
        if (landmarkpoint == null)
        {
            return 0L;
        } else
        {
            return landmarkpoint.a;
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
                jniLivenessAndTMJNI.delete_LandmarkPoint(a);
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

    public float getX()
    {
        return jniLivenessAndTMJNI.LandmarkPoint_getX(a, this);
    }

    public float getY()
    {
        return jniLivenessAndTMJNI.LandmarkPoint_getY(a, this);
    }
}
