// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mrz.impl.smartEngines.swig;


// Referenced classes of package com.jumio.mrz.impl.smartEngines.swig:
//            mrzjniInterfaceJNI

public class MrzEngineSessionHelpers
{

    private long a;
    protected boolean swigCMemOwn;

    public MrzEngineSessionHelpers()
    {
        this(mrzjniInterfaceJNI.new_MrzEngineSessionHelpers(), true);
    }

    protected MrzEngineSessionHelpers(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(MrzEngineSessionHelpers mrzenginesessionhelpers)
    {
        if (mrzenginesessionhelpers == null)
        {
            return 0L;
        } else
        {
            return mrzenginesessionhelpers.a;
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
                mrzjniInterfaceJNI.delete_MrzEngineSessionHelpers(a);
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

    public double get_optimal_aspect_ratio()
    {
        return mrzjniInterfaceJNI.MrzEngineSessionHelpers_get_optimal_aspect_ratio(a, this);
    }

    public void set_optimal_aspect_ratio(double d)
    {
        mrzjniInterfaceJNI.MrzEngineSessionHelpers_set_optimal_aspect_ratio(a, this, d);
    }
}
