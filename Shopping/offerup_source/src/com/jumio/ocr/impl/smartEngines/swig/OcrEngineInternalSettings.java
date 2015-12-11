// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI

public class OcrEngineInternalSettings
{

    private long a;
    protected boolean swigCMemOwn;

    protected OcrEngineInternalSettings(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public static OcrEngineInternalSettings createFromFilesystem(String s)
    {
        long l = jniInterfaceJNI.OcrEngineInternalSettings_createFromFilesystem(s);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new OcrEngineInternalSettings(l, false);
        }
    }

    protected static long getCPtr(OcrEngineInternalSettings ocrengineinternalsettings)
    {
        if (ocrengineinternalsettings == null)
        {
            return 0L;
        } else
        {
            return ocrengineinternalsettings.a;
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
                jniInterfaceJNI.delete_OcrEngineInternalSettings(a);
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
