// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI, OcrChar

public class OcrCharVector
{

    private long a;
    protected boolean swigCMemOwn;

    public OcrCharVector()
    {
        this(jniInterfaceJNI.new_OcrCharVector__SWIG_0(), true);
    }

    public OcrCharVector(long l)
    {
        this(jniInterfaceJNI.new_OcrCharVector__SWIG_1(l), true);
    }

    protected OcrCharVector(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(OcrCharVector ocrcharvector)
    {
        if (ocrcharvector == null)
        {
            return 0L;
        } else
        {
            return ocrcharvector.a;
        }
    }

    public void add(OcrChar ocrchar)
    {
        jniInterfaceJNI.OcrCharVector_add(a, this, OcrChar.getCPtr(ocrchar), ocrchar);
    }

    public long capacity()
    {
        return jniInterfaceJNI.OcrCharVector_capacity(a, this);
    }

    public void clear()
    {
        jniInterfaceJNI.OcrCharVector_clear(a, this);
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
                jniInterfaceJNI.delete_OcrCharVector(a);
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

    public OcrChar get(int i)
    {
        return new OcrChar(jniInterfaceJNI.OcrCharVector_get(a, this, i), false);
    }

    public boolean isEmpty()
    {
        return jniInterfaceJNI.OcrCharVector_isEmpty(a, this);
    }

    public void reserve(long l)
    {
        jniInterfaceJNI.OcrCharVector_reserve(a, this, l);
    }

    public void set(int i, OcrChar ocrchar)
    {
        jniInterfaceJNI.OcrCharVector_set(a, this, i, OcrChar.getCPtr(ocrchar), ocrchar);
    }

    public long size()
    {
        return jniInterfaceJNI.OcrCharVector_size(a, this);
    }
}
