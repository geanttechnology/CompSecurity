// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI, OcrCharStringVector, ResultAcceptorInterfaceSettings

public class ResultAcceptorInterface
{

    private long a;
    protected boolean swigCMemOwn;

    public ResultAcceptorInterface()
    {
        this(jniInterfaceJNI.new_ResultAcceptorInterface(), true);
        jniInterfaceJNI.ResultAcceptorInterface_director_connect(this, a, swigCMemOwn, true);
    }

    protected ResultAcceptorInterface(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(ResultAcceptorInterface resultacceptorinterface)
    {
        if (resultacceptorinterface == null)
        {
            return 0L;
        } else
        {
            return resultacceptorinterface.a;
        }
    }

    public void accept(ResultAcceptorInterfaceSettings.FieldName fieldname, OcrCharStringVector ocrcharstringvector, int i, int j, ResultAcceptorInterfaceSettings resultacceptorinterfacesettings, boolean flag)
    {
        if (getClass() == com/jumio/ocr/impl/smartEngines/swig/ResultAcceptorInterface)
        {
            jniInterfaceJNI.ResultAcceptorInterface_accept(a, this, fieldname.swigValue(), OcrCharStringVector.getCPtr(ocrcharstringvector), ocrcharstringvector, i, j, ResultAcceptorInterfaceSettings.getCPtr(resultacceptorinterfacesettings), resultacceptorinterfacesettings, flag);
            return;
        } else
        {
            jniInterfaceJNI.ResultAcceptorInterface_acceptSwigExplicitResultAcceptorInterface(a, this, fieldname.swigValue(), OcrCharStringVector.getCPtr(ocrcharstringvector), ocrcharstringvector, i, j, ResultAcceptorInterfaceSettings.getCPtr(resultacceptorinterfacesettings), resultacceptorinterfacesettings, flag);
            return;
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
                jniInterfaceJNI.delete_ResultAcceptorInterface(a);
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

    protected void swigDirectorDisconnect()
    {
        swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership()
    {
        swigCMemOwn = false;
        jniInterfaceJNI.ResultAcceptorInterface_change_ownership(this, a, false);
    }

    public void swigTakeOwnership()
    {
        swigCMemOwn = true;
        jniInterfaceJNI.ResultAcceptorInterface_change_ownership(this, a, true);
    }
}
