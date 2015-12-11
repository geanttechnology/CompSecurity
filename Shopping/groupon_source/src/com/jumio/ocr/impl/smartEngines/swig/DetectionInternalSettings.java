// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI

public class DetectionInternalSettings
{

    private long a;
    protected boolean swigCMemOwn;

    public DetectionInternalSettings()
    {
        this(jniInterfaceJNI.new_DetectionInternalSettings(), true);
        jniInterfaceJNI.DetectionInternalSettings_director_connect(this, a, swigCMemOwn, true);
    }

    protected DetectionInternalSettings(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(DetectionInternalSettings detectioninternalsettings)
    {
        if (detectioninternalsettings == null)
        {
            return 0L;
        } else
        {
            return detectioninternalsettings.a;
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
                jniInterfaceJNI.delete_DetectionInternalSettings(a);
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
        jniInterfaceJNI.DetectionInternalSettings_change_ownership(this, a, false);
    }

    public void swigTakeOwnership()
    {
        swigCMemOwn = true;
        jniInterfaceJNI.DetectionInternalSettings_change_ownership(this, a, true);
    }
}
