// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            DetectionSettings, DetectionInternalSettings, jniInterfaceJNI, DetectionResult

public class DetectionEngine
{

    private long a;
    protected boolean swigCMemOwn;

    protected DetectionEngine(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public DetectionEngine(DetectionSettings detectionsettings, DetectionInternalSettings detectioninternalsettings)
    {
        this(jniInterfaceJNI.new_DetectionEngine(DetectionSettings.getCPtr(detectionsettings), detectionsettings, DetectionInternalSettings.getCPtr(detectioninternalsettings), detectioninternalsettings), true);
    }

    protected static long getCPtr(DetectionEngine detectionengine)
    {
        if (detectionengine == null)
        {
            return 0L;
        } else
        {
            return detectionengine.a;
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
                jniInterfaceJNI.delete_DetectionEngine(a);
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

    public DetectionResult processRawImage(byte abyte0[], int i, int j, int k, int l)
    {
        return new DetectionResult(jniInterfaceJNI.DetectionEngine_processRawImage(a, this, abyte0, i, j, k, l), true);
    }

    public void resetSession()
    {
        jniInterfaceJNI.DetectionEngine_resetSession(a, this);
    }
}
