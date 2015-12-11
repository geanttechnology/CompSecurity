// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mrz.impl.smartEngines.swig;


// Referenced classes of package com.jumio.mrz.impl.smartEngines.swig:
//            mrzjniInterfaceJNI, MrzOcrCharVector

public class MrzOcrString
{

    private long a;
    protected boolean swigCMemOwn;

    public MrzOcrString()
    {
        this(mrzjniInterfaceJNI.new_MrzOcrString__SWIG_0(), true);
    }

    protected MrzOcrString(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public MrzOcrString(MrzOcrCharVector mrzocrcharvector)
    {
        this(mrzjniInterfaceJNI.new_MrzOcrString__SWIG_1(MrzOcrCharVector.getCPtr(mrzocrcharvector), mrzocrcharvector), true);
    }

    protected static long getCPtr(MrzOcrString mrzocrstring)
    {
        if (mrzocrstring == null)
        {
            return 0L;
        } else
        {
            return mrzocrstring.a;
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
                mrzjniInterfaceJNI.delete_MrzOcrString(a);
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

    public MrzOcrCharVector getOcrChars()
    {
        return new MrzOcrCharVector(mrzjniInterfaceJNI.MrzOcrString_getOcrChars(a, this), false);
    }
}
