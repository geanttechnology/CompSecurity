// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI

public class OcrException extends Exception
{

    private long a;
    protected boolean swigCMemOwn;

    protected OcrException(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public OcrException(String s)
    {
        this(jniInterfaceJNI.new_OcrException(s), true);
    }

    protected static long getCPtr(OcrException ocrexception)
    {
        if (ocrexception == null)
        {
            return 0L;
        } else
        {
            return ocrexception.a;
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
                jniInterfaceJNI.delete_OcrException(a);
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

    public String getMessage()
    {
        return what();
    }

    public String what()
    {
        return jniInterfaceJNI.OcrException_what(a, this);
    }
}
