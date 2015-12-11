// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            jniLivenessAndTMJNI

public class FaceRect
{

    private long a;
    protected boolean swigCMemOwn;

    public FaceRect()
    {
        this(jniLivenessAndTMJNI.new_FaceRect__SWIG_4(), true);
    }

    public FaceRect(int i)
    {
        this(jniLivenessAndTMJNI.new_FaceRect__SWIG_3(i), true);
    }

    public FaceRect(int i, int j)
    {
        this(jniLivenessAndTMJNI.new_FaceRect__SWIG_2(i, j), true);
    }

    public FaceRect(int i, int j, int k)
    {
        this(jniLivenessAndTMJNI.new_FaceRect__SWIG_1(i, j, k), true);
    }

    public FaceRect(int i, int j, int k, int l)
    {
        this(jniLivenessAndTMJNI.new_FaceRect__SWIG_0(i, j, k, l), true);
    }

    protected FaceRect(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(FaceRect facerect)
    {
        if (facerect == null)
        {
            return 0L;
        } else
        {
            return facerect.a;
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
                jniLivenessAndTMJNI.delete_FaceRect(a);
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
        return jniLivenessAndTMJNI.FaceRect_getHeight(a, this);
    }

    public int getWidth()
    {
        return jniLivenessAndTMJNI.FaceRect_getWidth(a, this);
    }

    public int getX()
    {
        return jniLivenessAndTMJNI.FaceRect_getX(a, this);
    }

    public int getY()
    {
        return jniLivenessAndTMJNI.FaceRect_getY(a, this);
    }

    public void setHeight(int i)
    {
        jniLivenessAndTMJNI.FaceRect_setHeight(a, this, i);
    }

    public void setWidth(int i)
    {
        jniLivenessAndTMJNI.FaceRect_setWidth(a, this, i);
    }

    public void setX(int i)
    {
        jniLivenessAndTMJNI.FaceRect_setX(a, this, i);
    }

    public void setY(int i)
    {
        jniLivenessAndTMJNI.FaceRect_setY(a, this, i);
    }
}
