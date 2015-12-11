// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            OcrCharStringVector, jniInterfaceJNI, OcrConfidence

public class OcrField
{

    private long a;
    protected boolean swigCMemOwn;

    protected OcrField(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public OcrField(OcrCharStringVector ocrcharstringvector, boolean flag)
    {
        this(jniInterfaceJNI.new_OcrField__SWIG_0(OcrCharStringVector.getCPtr(ocrcharstringvector), ocrcharstringvector, flag), true);
    }

    public OcrField(OcrField ocrfield)
    {
        this(jniInterfaceJNI.new_OcrField__SWIG_1(getCPtr(ocrfield), ocrfield), true);
    }

    protected static long getCPtr(OcrField ocrfield)
    {
        if (ocrfield == null)
        {
            return 0L;
        } else
        {
            return ocrfield.a;
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
                jniInterfaceJNI.delete_OcrField(a);
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

    public String getAsString()
    {
        return jniInterfaceJNI.OcrField_getAsString(a, this);
    }

    public OcrConfidence getConfidence()
    {
        return new OcrConfidence(jniInterfaceJNI.OcrField_getConfidence(a, this), true);
    }

    public long getLength()
    {
        return jniInterfaceJNI.OcrField_getLength(a, this);
    }

    public OcrCharStringVector getOcrCharVariants()
    {
        return new OcrCharStringVector(jniInterfaceJNI.OcrField_getOcrCharVariants(a, this), false);
    }

    public boolean getToAcceptFlag()
    {
        return jniInterfaceJNI.OcrField_getToAcceptFlag(a, this);
    }
}
