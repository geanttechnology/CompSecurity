// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI, DetectionInternalSettings

public class DetectionInternalSettingsFactory
{

    private long a;
    protected boolean swigCMemOwn;

    public DetectionInternalSettingsFactory()
    {
        this(jniInterfaceJNI.new_DetectionInternalSettingsFactory(), true);
    }

    protected DetectionInternalSettingsFactory(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public static DetectionInternalSettings createFromFileSystem(String s)
    {
        long l = jniInterfaceJNI.DetectionInternalSettingsFactory_createFromFileSystem(s);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new DetectionInternalSettings(l, false);
        }
    }

    protected static long getCPtr(DetectionInternalSettingsFactory detectioninternalsettingsfactory)
    {
        if (detectioninternalsettingsfactory == null)
        {
            return 0L;
        } else
        {
            return detectioninternalsettingsfactory.a;
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
                jniInterfaceJNI.delete_DetectionInternalSettingsFactory(a);
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
}
