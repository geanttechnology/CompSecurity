// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mrz.impl.smartEngines.swig;


// Referenced classes of package com.jumio.mrz.impl.smartEngines.swig:
//            mrzjniInterfaceJNI, MrzOcrString, MrzOcrChar

public class MrzField
{

    private long a;
    protected boolean swigCMemOwn;

    public MrzField()
    {
        this(mrzjniInterfaceJNI.new_MrzField__SWIG_0(), true);
    }

    protected MrzField(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public MrzField(String s)
    {
        this(mrzjniInterfaceJNI.new_MrzField__SWIG_3(s), true);
    }

    public MrzField(String s, boolean flag)
    {
        this(mrzjniInterfaceJNI.new_MrzField__SWIG_2(s, flag), true);
    }

    public MrzField(String s, boolean flag, double d)
    {
        this(mrzjniInterfaceJNI.new_MrzField__SWIG_1(s, flag, d), true);
    }

    public MrzField(String s, boolean flag, double d, MrzOcrString mrzocrstring, MrzOcrChar mrzocrchar)
    {
        this(mrzjniInterfaceJNI.new_MrzField__SWIG_4(s, flag, d, MrzOcrString.getCPtr(mrzocrstring), mrzocrstring, MrzOcrChar.getCPtr(mrzocrchar), mrzocrchar), true);
    }

    protected static long getCPtr(MrzField mrzfield)
    {
        if (mrzfield == null)
        {
            return 0L;
        } else
        {
            return mrzfield.a;
        }
    }

    public int calculateChecksum()
    {
        return mrzjniInterfaceJNI.MrzField_calculateChecksum(a, this);
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
                mrzjniInterfaceJNI.delete_MrzField(a);
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
        return mrzjniInterfaceJNI.MrzField_getAsString(a, this);
    }

    public MrzOcrChar getChecksumOcrChar()
    {
        return new MrzOcrChar(mrzjniInterfaceJNI.MrzField_getChecksumOcrChar(a, this), false);
    }

    public double getConfidence()
    {
        return mrzjniInterfaceJNI.MrzField_getConfidence(a, this);
    }

    public MrzOcrString getOcrString()
    {
        return new MrzOcrString(mrzjniInterfaceJNI.MrzField_getOcrString(a, this), false);
    }

    public boolean hasChecksumOcrChar()
    {
        return mrzjniInterfaceJNI.MrzField_hasChecksumOcrChar(a, this);
    }

    public boolean hasCorrectChecksum()
    {
        return mrzjniInterfaceJNI.MrzField_hasCorrectChecksum(a, this);
    }

    public boolean isAccepted()
    {
        return mrzjniInterfaceJNI.MrzField_isAccepted(a, this);
    }
}
