// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI

public class OcrPoint
{

    private long a;
    protected boolean swigCMemOwn;

    public OcrPoint()
    {
        this(jniInterfaceJNI.new_OcrPoint__SWIG_2(), true);
    }

    public OcrPoint(int i)
    {
        this(jniInterfaceJNI.new_OcrPoint__SWIG_1(i), true);
    }

    public OcrPoint(int i, int j)
    {
        this(jniInterfaceJNI.new_OcrPoint__SWIG_0(i, j), true);
    }

    protected OcrPoint(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public OcrPoint(OcrPoint ocrpoint)
    {
        this(jniInterfaceJNI.new_OcrPoint__SWIG_3(getCPtr(ocrpoint), ocrpoint), true);
    }

    protected static long getCPtr(OcrPoint ocrpoint)
    {
        if (ocrpoint == null)
        {
            return 0L;
        } else
        {
            return ocrpoint.a;
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
                jniInterfaceJNI.delete_OcrPoint(a);
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

    public int getX()
    {
        return jniInterfaceJNI.OcrPoint_getX(a, this);
    }

    public int getY()
    {
        return jniInterfaceJNI.OcrPoint_getY(a, this);
    }
}
