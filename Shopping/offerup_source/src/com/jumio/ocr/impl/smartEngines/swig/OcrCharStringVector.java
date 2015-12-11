// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI, OcrCharVariants

public class OcrCharStringVector
{

    private long a;
    protected boolean swigCMemOwn;

    public OcrCharStringVector()
    {
        this(jniInterfaceJNI.new_OcrCharStringVector__SWIG_0(), true);
    }

    public OcrCharStringVector(long l)
    {
        this(jniInterfaceJNI.new_OcrCharStringVector__SWIG_1(l), true);
    }

    protected OcrCharStringVector(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(OcrCharStringVector ocrcharstringvector)
    {
        if (ocrcharstringvector == null)
        {
            return 0L;
        } else
        {
            return ocrcharstringvector.a;
        }
    }

    public void add(OcrCharVariants ocrcharvariants)
    {
        jniInterfaceJNI.OcrCharStringVector_add(a, this, OcrCharVariants.getCPtr(ocrcharvariants), ocrcharvariants);
    }

    public long capacity()
    {
        return jniInterfaceJNI.OcrCharStringVector_capacity(a, this);
    }

    public void clear()
    {
        jniInterfaceJNI.OcrCharStringVector_clear(a, this);
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
                jniInterfaceJNI.delete_OcrCharStringVector(a);
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

    public OcrCharVariants get(int i)
    {
        return new OcrCharVariants(jniInterfaceJNI.OcrCharStringVector_get(a, this, i), false);
    }

    public boolean isEmpty()
    {
        return jniInterfaceJNI.OcrCharStringVector_isEmpty(a, this);
    }

    public void reserve(long l)
    {
        jniInterfaceJNI.OcrCharStringVector_reserve(a, this, l);
    }

    public void set(int i, OcrCharVariants ocrcharvariants)
    {
        jniInterfaceJNI.OcrCharStringVector_set(a, this, i, OcrCharVariants.getCPtr(ocrcharvariants), ocrcharvariants);
    }

    public long size()
    {
        return jniInterfaceJNI.OcrCharStringVector_size(a, this);
    }
}
