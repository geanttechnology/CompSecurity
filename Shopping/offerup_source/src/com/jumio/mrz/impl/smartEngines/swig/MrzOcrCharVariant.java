// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mrz.impl.smartEngines.swig;


// Referenced classes of package com.jumio.mrz.impl.smartEngines.swig:
//            mrzjniInterfaceJNI

public class MrzOcrCharVariant
{

    private long a;
    protected boolean swigCMemOwn;

    public MrzOcrCharVariant()
    {
        this(mrzjniInterfaceJNI.new_MrzOcrCharVariant__SWIG_0(), true);
    }

    public MrzOcrCharVariant(char c, double d)
    {
        this(mrzjniInterfaceJNI.new_MrzOcrCharVariant__SWIG_1(c, d), true);
    }

    protected MrzOcrCharVariant(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(MrzOcrCharVariant mrzocrcharvariant)
    {
        if (mrzocrcharvariant == null)
        {
            return 0L;
        } else
        {
            return mrzocrcharvariant.a;
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
                mrzjniInterfaceJNI.delete_MrzOcrCharVariant(a);
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
        return mrzjniInterfaceJNI.MrzOcrCharVariant_getCharacter(a, this);
    }

    public double getConfidence()
    {
        return mrzjniInterfaceJNI.MrzOcrCharVariant_getConfidence(a, this);
    }
}
