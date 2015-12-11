// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mrz.impl.smartEngines.swig;


// Referenced classes of package com.jumio.mrz.impl.smartEngines.swig:
//            mrzjniInterfaceJNI

public class MrzEngineInternalSettings
{

    private long a;
    protected boolean swigCMemOwn;

    protected MrzEngineInternalSettings(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public static MrzEngineInternalSettings createFromFilesystem(String s)
    {
        long l = mrzjniInterfaceJNI.MrzEngineInternalSettings_createFromFilesystem(s);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new MrzEngineInternalSettings(l, false);
        }
    }

    protected static long getCPtr(MrzEngineInternalSettings mrzengineinternalsettings)
    {
        if (mrzengineinternalsettings == null)
        {
            return 0L;
        } else
        {
            return mrzengineinternalsettings.a;
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
                mrzjniInterfaceJNI.delete_MrzEngineInternalSettings(a);
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
