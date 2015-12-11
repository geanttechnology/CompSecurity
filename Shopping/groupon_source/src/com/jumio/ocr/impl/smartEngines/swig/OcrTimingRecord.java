// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI

public class OcrTimingRecord
{

    private long a;
    protected boolean swigCMemOwn;

    public OcrTimingRecord()
    {
        this(jniInterfaceJNI.new_OcrTimingRecord__SWIG_0(), true);
    }

    public OcrTimingRecord(double d, long l, String s, String s1)
    {
        this(jniInterfaceJNI.new_OcrTimingRecord__SWIG_1(d, l, s, s1), true);
    }

    protected OcrTimingRecord(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(OcrTimingRecord ocrtimingrecord)
    {
        if (ocrtimingrecord == null)
        {
            return 0L;
        } else
        {
            return ocrtimingrecord.a;
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
                jniInterfaceJNI.delete_OcrTimingRecord(a);
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

    public long getCallCount()
    {
        return jniInterfaceJNI.OcrTimingRecord_getCallCount(a, this);
    }

    public String getComment()
    {
        return jniInterfaceJNI.OcrTimingRecord_getComment(a, this);
    }

    public String getName()
    {
        return jniInterfaceJNI.OcrTimingRecord_getName(a, this);
    }

    public double getTotalTime()
    {
        return jniInterfaceJNI.OcrTimingRecord_getTotalTime(a, this);
    }
}
