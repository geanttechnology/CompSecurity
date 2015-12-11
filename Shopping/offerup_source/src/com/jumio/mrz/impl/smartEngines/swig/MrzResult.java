// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mrz.impl.smartEngines.swig;


// Referenced classes of package com.jumio.mrz.impl.smartEngines.swig:
//            mrzjniInterfaceJNI, MrzDateField, MrzField, MrzOcrChar, 
//            StringVector, MrzOcrStringVector

public class MrzResult
{

    private long a;
    protected boolean swigCMemOwn;

    public MrzResult()
    {
        this(mrzjniInterfaceJNI.new_MrzResult__SWIG_0(), true);
    }

    protected MrzResult(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public MrzResult(MrzResult mrzresult)
    {
        this(mrzjniInterfaceJNI.new_MrzResult__SWIG_1(getCPtr(mrzresult), mrzresult), true);
    }

    protected static long getCPtr(MrzResult mrzresult)
    {
        if (mrzresult == null)
        {
            return 0L;
        } else
        {
            return mrzresult.a;
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
                mrzjniInterfaceJNI.delete_MrzResult(a);
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

    public MrzDateField getBirthdate()
    {
        return new MrzDateField(mrzjniInterfaceJNI.MrzResult_getBirthdate(a, this), false);
    }

    public MrzField getCountry()
    {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getCountry(a, this), false);
    }

    public MrzField getDepartmentCode()
    {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getDepartmentCode(a, this), false);
    }

    public MrzField getDocNum()
    {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getDocNum(a, this), false);
    }

    public MrzField getDocNumFormatted()
    {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getDocNumFormatted(a, this), false);
    }

    public MrzField getDocType()
    {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getDocType(a, this), false);
    }

    public MrzField getDocTypeCode()
    {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getDocTypeCode(a, this), false);
    }

    public MrzDateField getExpidate()
    {
        return new MrzDateField(mrzjniInterfaceJNI.MrzResult_getExpidate(a, this), false);
    }

    public MrzField getFirstName()
    {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getFirstName(a, this), false);
    }

    public MrzDateField getIssuedate()
    {
        return new MrzDateField(mrzjniInterfaceJNI.MrzResult_getIssuedate(a, this), false);
    }

    public MrzOcrChar getMrzCompositeCheckDigit()
    {
        return new MrzOcrChar(mrzjniInterfaceJNI.MrzResult_getMrzCompositeCheckDigit(a, this), false);
    }

    public StringVector getMrzLines()
    {
        return new StringVector(mrzjniInterfaceJNI.MrzResult_getMrzLines(a, this), false);
    }

    public MrzOcrStringVector getMrzOcrLines()
    {
        return new MrzOcrStringVector(mrzjniInterfaceJNI.MrzResult_getMrzOcrLines(a, this), false);
    }

    public MrzField getNationality()
    {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getNationality(a, this), false);
    }

    public MrzField getOptData1()
    {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getOptData1(a, this), false);
    }

    public MrzField getOptData2()
    {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getOptData2(a, this), false);
    }

    public MrzField getSecondName()
    {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getSecondName(a, this), false);
    }

    public MrzField getSex()
    {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getSex(a, this), false);
    }

    public boolean hasCorrectCompositeChecksum()
    {
        return mrzjniInterfaceJNI.MrzResult_hasCorrectCompositeChecksum(a, this);
    }

    public void setBirthdate(MrzDateField mrzdatefield)
    {
        mrzjniInterfaceJNI.MrzResult_setBirthdate(a, this, MrzDateField.getCPtr(mrzdatefield), mrzdatefield);
    }

    public void setCountry(MrzField mrzfield)
    {
        mrzjniInterfaceJNI.MrzResult_setCountry(a, this, MrzField.getCPtr(mrzfield), mrzfield);
    }

    public void setDepartmentCode(MrzField mrzfield)
    {
        mrzjniInterfaceJNI.MrzResult_setDepartmentCode(a, this, MrzField.getCPtr(mrzfield), mrzfield);
    }

    public void setDocNum(MrzField mrzfield)
    {
        mrzjniInterfaceJNI.MrzResult_setDocNum(a, this, MrzField.getCPtr(mrzfield), mrzfield);
    }

    public void setDocNumFormatted(MrzField mrzfield)
    {
        mrzjniInterfaceJNI.MrzResult_setDocNumFormatted(a, this, MrzField.getCPtr(mrzfield), mrzfield);
    }

    public void setDocType(MrzField mrzfield)
    {
        mrzjniInterfaceJNI.MrzResult_setDocType(a, this, MrzField.getCPtr(mrzfield), mrzfield);
    }

    public void setDocTypeCode(MrzField mrzfield)
    {
        mrzjniInterfaceJNI.MrzResult_setDocTypeCode(a, this, MrzField.getCPtr(mrzfield), mrzfield);
    }

    public void setExpidate(MrzDateField mrzdatefield)
    {
        mrzjniInterfaceJNI.MrzResult_setExpidate(a, this, MrzDateField.getCPtr(mrzdatefield), mrzdatefield);
    }

    public void setFirstName(MrzField mrzfield)
    {
        mrzjniInterfaceJNI.MrzResult_setFirstName(a, this, MrzField.getCPtr(mrzfield), mrzfield);
    }

    public void setIssuedate(MrzDateField mrzdatefield)
    {
        mrzjniInterfaceJNI.MrzResult_setIssuedate(a, this, MrzDateField.getCPtr(mrzdatefield), mrzdatefield);
    }

    public void setMrzCompositeCheckDigit(MrzOcrChar mrzocrchar)
    {
        mrzjniInterfaceJNI.MrzResult_setMrzCompositeCheckDigit(a, this, MrzOcrChar.getCPtr(mrzocrchar), mrzocrchar);
    }

    public void setMrzLines(StringVector stringvector)
    {
        mrzjniInterfaceJNI.MrzResult_setMrzLines(a, this, StringVector.getCPtr(stringvector), stringvector);
    }

    public void setMrzOcrLines(MrzOcrStringVector mrzocrstringvector)
    {
        mrzjniInterfaceJNI.MrzResult_setMrzOcrLines(a, this, MrzOcrStringVector.getCPtr(mrzocrstringvector), mrzocrstringvector);
    }

    public void setNationality(MrzField mrzfield)
    {
        mrzjniInterfaceJNI.MrzResult_setNationality(a, this, MrzField.getCPtr(mrzfield), mrzfield);
    }

    public void setOptData1(MrzField mrzfield)
    {
        mrzjniInterfaceJNI.MrzResult_setOptData1(a, this, MrzField.getCPtr(mrzfield), mrzfield);
    }

    public void setOptData2(MrzField mrzfield)
    {
        mrzjniInterfaceJNI.MrzResult_setOptData2(a, this, MrzField.getCPtr(mrzfield), mrzfield);
    }

    public void setSecondName(MrzField mrzfield)
    {
        mrzjniInterfaceJNI.MrzResult_setSecondName(a, this, MrzField.getCPtr(mrzfield), mrzfield);
    }

    public void setSex(MrzField mrzfield)
    {
        mrzjniInterfaceJNI.MrzResult_setSex(a, this, MrzField.getCPtr(mrzfield), mrzfield);
    }
}
