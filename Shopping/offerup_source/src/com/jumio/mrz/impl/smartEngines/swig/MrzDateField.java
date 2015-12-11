// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mrz.impl.smartEngines.swig;


// Referenced classes of package com.jumio.mrz.impl.smartEngines.swig:
//            MrzField, mrzjniInterfaceJNI, MrzDate, MrzOcrString, 
//            MrzOcrChar

public class MrzDateField extends MrzField
{

    private long a;

    public MrzDateField()
    {
        this(mrzjniInterfaceJNI.new_MrzDateField__SWIG_0(), true);
    }

    protected MrzDateField(long l, boolean flag)
    {
        super(mrzjniInterfaceJNI.MrzDateField_SWIGUpcast(l), flag);
        a = l;
    }

    public MrzDateField(MrzDate mrzdate)
    {
        this(mrzjniInterfaceJNI.new_MrzDateField__SWIG_3(MrzDate.getCPtr(mrzdate), mrzdate), true);
    }

    public MrzDateField(MrzDate mrzdate, boolean flag)
    {
        this(mrzjniInterfaceJNI.new_MrzDateField__SWIG_2(MrzDate.getCPtr(mrzdate), mrzdate, flag), true);
    }

    public MrzDateField(MrzDate mrzdate, boolean flag, double d)
    {
        this(mrzjniInterfaceJNI.new_MrzDateField__SWIG_1(MrzDate.getCPtr(mrzdate), mrzdate, flag, d), true);
    }

    public MrzDateField(MrzDate mrzdate, boolean flag, double d, MrzOcrString mrzocrstring, MrzOcrChar mrzocrchar)
    {
        this(mrzjniInterfaceJNI.new_MrzDateField__SWIG_4(MrzDate.getCPtr(mrzdate), mrzdate, flag, d, MrzOcrString.getCPtr(mrzocrstring), mrzocrstring, MrzOcrChar.getCPtr(mrzocrchar), mrzocrchar), true);
    }

    protected static long getCPtr(MrzDateField mrzdatefield)
    {
        if (mrzdatefield == null)
        {
            return 0L;
        } else
        {
            return mrzdatefield.a;
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
                mrzjniInterfaceJNI.delete_MrzDateField(a);
            }
            a = 0L;
        }
        super.delete();
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

    public MrzDate getAsMrzDate()
    {
        return new MrzDate(mrzjniInterfaceJNI.MrzDateField_getAsMrzDate(a, this), false);
    }
}
