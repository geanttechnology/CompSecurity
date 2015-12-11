// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            jniLivenessAndTMJNI, HierarchicalClusteringSettings

public class FrameProcessingSettingsTemplateMatcher
{

    private long a;
    protected boolean swigCMemOwn;

    public FrameProcessingSettingsTemplateMatcher()
    {
        this(jniLivenessAndTMJNI.new_FrameProcessingSettingsTemplateMatcher__SWIG_5(), true);
    }

    public FrameProcessingSettingsTemplateMatcher(int i)
    {
        this(jniLivenessAndTMJNI.new_FrameProcessingSettingsTemplateMatcher__SWIG_4(i), true);
    }

    public FrameProcessingSettingsTemplateMatcher(int i, boolean flag)
    {
        this(jniLivenessAndTMJNI.new_FrameProcessingSettingsTemplateMatcher__SWIG_3(i, flag), true);
    }

    public FrameProcessingSettingsTemplateMatcher(int i, boolean flag, HierarchicalClusteringSettings hierarchicalclusteringsettings)
    {
        this(jniLivenessAndTMJNI.new_FrameProcessingSettingsTemplateMatcher__SWIG_2(i, flag, HierarchicalClusteringSettings.getCPtr(hierarchicalclusteringsettings), hierarchicalclusteringsettings), true);
    }

    public FrameProcessingSettingsTemplateMatcher(int i, boolean flag, HierarchicalClusteringSettings hierarchicalclusteringsettings, int j)
    {
        this(jniLivenessAndTMJNI.new_FrameProcessingSettingsTemplateMatcher__SWIG_1(i, flag, HierarchicalClusteringSettings.getCPtr(hierarchicalclusteringsettings), hierarchicalclusteringsettings, j), true);
    }

    public FrameProcessingSettingsTemplateMatcher(int i, boolean flag, HierarchicalClusteringSettings hierarchicalclusteringsettings, int j, int k)
    {
        this(jniLivenessAndTMJNI.new_FrameProcessingSettingsTemplateMatcher__SWIG_0(i, flag, HierarchicalClusteringSettings.getCPtr(hierarchicalclusteringsettings), hierarchicalclusteringsettings, j, k), true);
    }

    protected FrameProcessingSettingsTemplateMatcher(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(FrameProcessingSettingsTemplateMatcher frameprocessingsettingstemplatematcher)
    {
        if (frameprocessingsettingstemplatematcher == null)
        {
            return 0L;
        } else
        {
            return frameprocessingsettingstemplatematcher.a;
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
                jniLivenessAndTMJNI.delete_FrameProcessingSettingsTemplateMatcher(a);
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

    public HierarchicalClusteringSettings getClusteringSettings()
    {
        return new HierarchicalClusteringSettings(jniLivenessAndTMJNI.FrameProcessingSettingsTemplateMatcher_getClusteringSettings(a, this), false);
    }

    public int getMaxKeyPointsToDetect()
    {
        return jniLivenessAndTMJNI.FrameProcessingSettingsTemplateMatcher_getMaxKeyPointsToDetect(a, this);
    }

    public int getNumImagesToKeep()
    {
        return jniLivenessAndTMJNI.FrameProcessingSettingsTemplateMatcher_getNumImagesToKeep(a, this);
    }

    public int getNumSuccessMatchesToComplete()
    {
        return jniLivenessAndTMJNI.FrameProcessingSettingsTemplateMatcher_getNumSuccessMatchesToComplete(a, this);
    }

    public boolean getUseClustring()
    {
        return jniLivenessAndTMJNI.FrameProcessingSettingsTemplateMatcher_getUseClustring(a, this);
    }
}
