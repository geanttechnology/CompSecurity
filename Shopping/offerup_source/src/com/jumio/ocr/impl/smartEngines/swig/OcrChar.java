// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI

public class OcrChar
{

    private long a;
    protected boolean swigCMemOwn;

    public OcrChar()
    {
        this(jniInterfaceJNI.new_OcrChar__SWIG_0(), true);
    }

    public OcrChar(char c, double d)
    {
        this(jniInterfaceJNI.new_OcrChar__SWIG_1(c, d), true);
    }

    protected OcrChar(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(OcrChar ocrchar)
    {
        if (ocrchar == null)
        {
            return 0L;
        } else
        {
            return ocrchar.a;
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
                jniInterfaceJNI.delete_OcrChar(a);
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

    public char getCharacter()
    {
        return jniInterfaceJNI.OcrChar_getCharacter(a, this);
    }

    public double getProbability()
    {
        return jniInterfaceJNI.OcrChar_getProbability(a, this);
    }
}
