// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI

public class OcrConfidence
{

    private long a;
    protected boolean swigCMemOwn;

    public OcrConfidence(double d, double d1)
    {
        this(jniInterfaceJNI.new_OcrConfidence(d, d1), true);
    }

    protected OcrConfidence(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(OcrConfidence ocrconfidence)
    {
        if (ocrconfidence == null)
        {
            return 0L;
        } else
        {
            return ocrconfidence.a;
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
                jniInterfaceJNI.delete_OcrConfidence(a);
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

    public double getAverage()
    {
        return jniInterfaceJNI.OcrConfidence_getAverage(a, this);
    }

    public double getMinimum()
    {
        return jniInterfaceJNI.OcrConfidence_getMinimum(a, this);
    }
}
