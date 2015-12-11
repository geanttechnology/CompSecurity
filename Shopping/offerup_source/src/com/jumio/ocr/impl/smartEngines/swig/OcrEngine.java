// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            OcrEngineBase, jniInterfaceJNI, OcrEngineInternalSettings, OcrEngineSession, 
//            ResultAcceptorInterface, OcrEngineBaseSession

public class OcrEngine extends OcrEngineBase
{

    private long a;

    protected OcrEngine(long l, boolean flag)
    {
        super(jniInterfaceJNI.OcrEngine_SWIGUpcast(l), flag);
        a = l;
    }

    public OcrEngine(OcrEngineInternalSettings ocrengineinternalsettings)
    {
        this(jniInterfaceJNI.new_OcrEngine(OcrEngineInternalSettings.getCPtr(ocrengineinternalsettings), ocrengineinternalsettings), true);
        jniInterfaceJNI.OcrEngine_director_connect(this, a, swigCMemOwn, true);
    }

    protected static long getCPtr(OcrEngine ocrengine)
    {
        if (ocrengine == null)
        {
            return 0L;
        } else
        {
            return ocrengine.a;
        }
    }

    public volatile OcrEngineBaseSession createSession()
    {
        return createSession();
    }

    public volatile OcrEngineBaseSession createSession(ResultAcceptorInterface resultacceptorinterface)
    {
        return createSession(resultacceptorinterface);
    }

    public OcrEngineSession createSession()
    {
        long l = jniInterfaceJNI.OcrEngine_createSession__SWIG_1(a, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new OcrEngineSession(l, true);
        }
    }

    public OcrEngineSession createSession(ResultAcceptorInterface resultacceptorinterface)
    {
        long l = jniInterfaceJNI.OcrEngine_createSession__SWIG_0(a, this, ResultAcceptorInterface.getCPtr(resultacceptorinterface), resultacceptorinterface);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new OcrEngineSession(l, true);
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
                jniInterfaceJNI.delete_OcrEngine(a);
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

    protected void swigDirectorDisconnect()
    {
        swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership()
    {
        swigCMemOwn = false;
        jniInterfaceJNI.OcrEngine_change_ownership(this, a, false);
    }

    public void swigTakeOwnership()
    {
        swigCMemOwn = true;
        jniInterfaceJNI.OcrEngine_change_ownership(this, a, true);
    }
}
