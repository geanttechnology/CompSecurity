// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI

public class DetectionSettings
{

    private long a;
    protected boolean swigCMemOwn;

    public DetectionSettings()
    {
        this(jniInterfaceJNI.new_DetectionSettings(), true);
    }

    protected DetectionSettings(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(DetectionSettings detectionsettings)
    {
        if (detectionsettings == null)
        {
            return 0L;
        } else
        {
            return detectionsettings.a;
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
                jniInterfaceJNI.delete_DetectionSettings(a);
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

    public double getRoiBottomMargin()
    {
        return jniInterfaceJNI.DetectionSettings_getRoiBottomMargin(a, this);
    }

    public double getRoiHorizontalDeviation()
    {
        return jniInterfaceJNI.DetectionSettings_getRoiHorizontalDeviation(a, this);
    }

    public double getRoiLeftMargin()
    {
        return jniInterfaceJNI.DetectionSettings_getRoiLeftMargin(a, this);
    }

    public double getRoiRightMargin()
    {
        return jniInterfaceJNI.DetectionSettings_getRoiRightMargin(a, this);
    }

    public double getRoiTopMargin()
    {
        return jniInterfaceJNI.DetectionSettings_getRoiTopMargin(a, this);
    }

    public double getRoiVerticalDeviation()
    {
        return jniInterfaceJNI.DetectionSettings_getRoiVerticalDeviation(a, this);
    }

    public void setRoiBottomMargin(double d)
    {
        jniInterfaceJNI.DetectionSettings_setRoiBottomMargin(a, this, d);
    }

    public void setRoiHorizontalDeviation(double d)
    {
        jniInterfaceJNI.DetectionSettings_setRoiHorizontalDeviation(a, this, d);
    }

    public void setRoiLeftMargin(double d)
    {
        jniInterfaceJNI.DetectionSettings_setRoiLeftMargin(a, this, d);
    }

    public void setRoiRightMargin(double d)
    {
        jniInterfaceJNI.DetectionSettings_setRoiRightMargin(a, this, d);
    }

    public void setRoiTopMargin(double d)
    {
        jniInterfaceJNI.DetectionSettings_setRoiTopMargin(a, this, d);
    }

    public void setRoiVerticalDeviation(double d)
    {
        jniInterfaceJNI.DetectionSettings_setRoiVerticalDeviation(a, this, d);
    }
}
