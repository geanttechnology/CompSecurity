// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mrz.impl.smartEngines.swig;


// Referenced classes of package com.jumio.mrz.impl.smartEngines.swig:
//            mrzjniInterfaceJNI

public class MrzEngineSessionSettings
{

    private long a;
    protected boolean swigCMemOwn;

    public MrzEngineSessionSettings()
    {
        this(mrzjniInterfaceJNI.new_MrzEngineSessionSettings(), true);
    }

    protected MrzEngineSessionSettings(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(MrzEngineSessionSettings mrzenginesessionsettings)
    {
        if (mrzenginesessionsettings == null)
        {
            return 0L;
        } else
        {
            return mrzenginesessionsettings.a;
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
                mrzjniInterfaceJNI.delete_MrzEngineSessionSettings(a);
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

    public boolean get_cnis_support_enabled()
    {
        return mrzjniInterfaceJNI.MrzEngineSessionSettings_get_cnis_support_enabled(a, this);
    }

    public boolean get_m3z_support_enabled()
    {
        return mrzjniInterfaceJNI.MrzEngineSessionSettings_get_m3z_support_enabled(a, this);
    }

    public boolean get_mrp_support_enabled()
    {
        return mrzjniInterfaceJNI.MrzEngineSessionSettings_get_mrp_support_enabled(a, this);
    }

    public boolean get_mrva_support_enabled()
    {
        return mrzjniInterfaceJNI.MrzEngineSessionSettings_get_mrva_support_enabled(a, this);
    }

    public boolean get_mrvb_support_enabled()
    {
        return mrzjniInterfaceJNI.MrzEngineSessionSettings_get_mrvb_support_enabled(a, this);
    }

    public int get_number_of_threads()
    {
        return mrzjniInterfaceJNI.MrzEngineSessionSettings_get_number_of_threads(a, this);
    }

    public boolean get_should_postprocess()
    {
        return mrzjniInterfaceJNI.MrzEngineSessionSettings_get_should_postprocess(a, this);
    }

    public boolean get_should_recognize_in_parallel()
    {
        return mrzjniInterfaceJNI.MrzEngineSessionSettings_get_should_recognize_in_parallel(a, this);
    }

    public boolean get_should_reject_by_focus()
    {
        return mrzjniInterfaceJNI.MrzEngineSessionSettings_get_should_reject_by_focus(a, this);
    }

    public boolean get_should_reject_by_output()
    {
        return mrzjniInterfaceJNI.MrzEngineSessionSettings_get_should_reject_by_output(a, this);
    }

    public boolean get_should_reject_by_segmentation()
    {
        return mrzjniInterfaceJNI.MrzEngineSessionSettings_get_should_reject_by_segmentation(a, this);
    }

    public boolean get_should_segment_best_effort()
    {
        return mrzjniInterfaceJNI.MrzEngineSessionSettings_get_should_segment_best_effort(a, this);
    }

    public boolean get_should_segment_in_parallel()
    {
        return mrzjniInterfaceJNI.MrzEngineSessionSettings_get_should_segment_in_parallel(a, this);
    }

    public boolean get_td1_support_enabled()
    {
        return mrzjniInterfaceJNI.MrzEngineSessionSettings_get_td1_support_enabled(a, this);
    }

    public boolean get_td2_support_enabled()
    {
        return mrzjniInterfaceJNI.MrzEngineSessionSettings_get_td2_support_enabled(a, this);
    }

    public void set_cnis_support_enabled(boolean flag)
    {
        mrzjniInterfaceJNI.MrzEngineSessionSettings_set_cnis_support_enabled(a, this, flag);
    }

    public void set_m3z_support_enabled(boolean flag)
    {
        mrzjniInterfaceJNI.MrzEngineSessionSettings_set_m3z_support_enabled(a, this, flag);
    }

    public void set_mrp_support_enabled(boolean flag)
    {
        mrzjniInterfaceJNI.MrzEngineSessionSettings_set_mrp_support_enabled(a, this, flag);
    }

    public void set_mrva_support_enabled(boolean flag)
    {
        mrzjniInterfaceJNI.MrzEngineSessionSettings_set_mrva_support_enabled(a, this, flag);
    }

    public void set_mrvb_support_enabled(boolean flag)
    {
        mrzjniInterfaceJNI.MrzEngineSessionSettings_set_mrvb_support_enabled(a, this, flag);
    }

    public void set_number_of_threads(int i)
    {
        mrzjniInterfaceJNI.MrzEngineSessionSettings_set_number_of_threads(a, this, i);
    }

    public void set_should_postprocess(boolean flag)
    {
        mrzjniInterfaceJNI.MrzEngineSessionSettings_set_should_postprocess(a, this, flag);
    }

    public void set_should_recognize_in_parallel(boolean flag)
    {
        mrzjniInterfaceJNI.MrzEngineSessionSettings_set_should_recognize_in_parallel(a, this, flag);
    }

    public void set_should_reject_by_focus(boolean flag)
    {
        mrzjniInterfaceJNI.MrzEngineSessionSettings_set_should_reject_by_focus(a, this, flag);
    }

    public void set_should_reject_by_output(boolean flag)
    {
        mrzjniInterfaceJNI.MrzEngineSessionSettings_set_should_reject_by_output(a, this, flag);
    }

    public void set_should_reject_by_segmentation(boolean flag)
    {
        mrzjniInterfaceJNI.MrzEngineSessionSettings_set_should_reject_by_segmentation(a, this, flag);
    }

    public void set_should_segment_best_effort(boolean flag)
    {
        mrzjniInterfaceJNI.MrzEngineSessionSettings_set_should_segment_best_effort(a, this, flag);
    }

    public void set_should_segment_in_parallel(boolean flag)
    {
        mrzjniInterfaceJNI.MrzEngineSessionSettings_set_should_segment_in_parallel(a, this, flag);
    }

    public void set_td1_support_enabled(boolean flag)
    {
        mrzjniInterfaceJNI.MrzEngineSessionSettings_set_td1_support_enabled(a, this, flag);
    }

    public void set_td2_support_enabled(boolean flag)
    {
        mrzjniInterfaceJNI.MrzEngineSessionSettings_set_td2_support_enabled(a, this, flag);
    }
}
