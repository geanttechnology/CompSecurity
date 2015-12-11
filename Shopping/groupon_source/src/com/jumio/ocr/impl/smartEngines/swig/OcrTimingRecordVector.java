// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI, OcrTimingRecord

public class OcrTimingRecordVector
{

    private long a;
    protected boolean swigCMemOwn;

    public OcrTimingRecordVector()
    {
        this(jniInterfaceJNI.new_OcrTimingRecordVector__SWIG_0(), true);
    }

    public OcrTimingRecordVector(long l)
    {
        this(jniInterfaceJNI.new_OcrTimingRecordVector__SWIG_1(l), true);
    }

    protected OcrTimingRecordVector(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(OcrTimingRecordVector ocrtimingrecordvector)
    {
        if (ocrtimingrecordvector == null)
        {
            return 0L;
        } else
        {
            return ocrtimingrecordvector.a;
        }
    }

    public void add(OcrTimingRecord ocrtimingrecord)
    {
        jniInterfaceJNI.OcrTimingRecordVector_add(a, this, OcrTimingRecord.getCPtr(ocrtimingrecord), ocrtimingrecord);
    }

    public long capacity()
    {
        return jniInterfaceJNI.OcrTimingRecordVector_capacity(a, this);
    }

    public void clear()
    {
        jniInterfaceJNI.OcrTimingRecordVector_clear(a, this);
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
                jniInterfaceJNI.delete_OcrTimingRecordVector(a);
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

    public OcrTimingRecord get(int i)
    {
        return new OcrTimingRecord(jniInterfaceJNI.OcrTimingRecordVector_get(a, this, i), false);
    }

    public boolean isEmpty()
    {
        return jniInterfaceJNI.OcrTimingRecordVector_isEmpty(a, this);
    }

    public void reserve(long l)
    {
        jniInterfaceJNI.OcrTimingRecordVector_reserve(a, this, l);
    }

    public void set(int i, OcrTimingRecord ocrtimingrecord)
    {
        jniInterfaceJNI.OcrTimingRecordVector_set(a, this, i, OcrTimingRecord.getCPtr(ocrtimingrecord), ocrtimingrecord);
    }

    public long size()
    {
        return jniInterfaceJNI.OcrTimingRecordVector_size(a, this);
    }
}
