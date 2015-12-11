// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mrz.impl.smartEngines.swig;


// Referenced classes of package com.jumio.mrz.impl.smartEngines.swig:
//            mrzjniInterfaceJNI, MrzOcrCharVariantVector

public class MrzOcrChar
{

    private long a;
    protected boolean swigCMemOwn;

    public MrzOcrChar()
    {
        this(mrzjniInterfaceJNI.new_MrzOcrChar__SWIG_0(), true);
    }

    protected MrzOcrChar(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public MrzOcrChar(MrzOcrCharVariantVector mrzocrcharvariantvector, boolean flag, boolean flag1, boolean flag2)
    {
        this(mrzjniInterfaceJNI.new_MrzOcrChar__SWIG_1(MrzOcrCharVariantVector.getCPtr(mrzocrcharvariantvector), mrzocrcharvariantvector, flag, flag1, flag2), true);
    }

    protected static long getCPtr(MrzOcrChar mrzocrchar)
    {
        if (mrzocrchar == null)
        {
            return 0L;
        } else
        {
            return mrzocrchar.a;
        }
    }

    public char GetChar()
    {
        return mrzjniInterfaceJNI.MrzOcrChar_GetChar(a, this);
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
                mrzjniInterfaceJNI.delete_MrzOcrChar(a);
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

    public MrzOcrCharVariantVector getOcrCharVariants()
    {
        return new MrzOcrCharVariantVector(mrzjniInterfaceJNI.MrzOcrChar_getOcrCharVariants(a, this), false);
    }

    public boolean isCorrected()
    {
        return mrzjniInterfaceJNI.MrzOcrChar_isCorrected(a, this);
    }

    public boolean isFoundInDictionary()
    {
        return mrzjniInterfaceJNI.MrzOcrChar_isFoundInDictionary(a, this);
    }

    public boolean isHighlighted()
    {
        return mrzjniInterfaceJNI.MrzOcrChar_isHighlighted(a, this);
    }
}
