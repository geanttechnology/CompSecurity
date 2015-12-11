// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            jniLivenessAndTMJNI

public class HierarchicalClusteringSettings
{

    private long a;
    protected boolean swigCMemOwn;

    public HierarchicalClusteringSettings()
    {
        this(jniLivenessAndTMJNI.new_HierarchicalClusteringSettings__SWIG_4(), true);
    }

    public HierarchicalClusteringSettings(int i)
    {
        this(jniLivenessAndTMJNI.new_HierarchicalClusteringSettings__SWIG_3(i), true);
    }

    public HierarchicalClusteringSettings(int i, int j)
    {
        this(jniLivenessAndTMJNI.new_HierarchicalClusteringSettings__SWIG_2(i, j), true);
    }

    public HierarchicalClusteringSettings(int i, int j, int k)
    {
        this(jniLivenessAndTMJNI.new_HierarchicalClusteringSettings__SWIG_1(i, j, k), true);
    }

    public HierarchicalClusteringSettings(int i, int j, int k, int l)
    {
        this(jniLivenessAndTMJNI.new_HierarchicalClusteringSettings__SWIG_0(i, j, k, l), true);
    }

    protected HierarchicalClusteringSettings(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(HierarchicalClusteringSettings hierarchicalclusteringsettings)
    {
        if (hierarchicalclusteringsettings == null)
        {
            return 0L;
        } else
        {
            return hierarchicalclusteringsettings.a;
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
                jniLivenessAndTMJNI.delete_HierarchicalClusteringSettings(a);
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

    public int getBranching()
    {
        return jniLivenessAndTMJNI.HierarchicalClusteringSettings_getBranching(a, this);
    }

    public int getLeafMaxSize()
    {
        return jniLivenessAndTMJNI.HierarchicalClusteringSettings_getLeafMaxSize(a, this);
    }

    public int getMaxChecks()
    {
        return jniLivenessAndTMJNI.HierarchicalClusteringSettings_getMaxChecks(a, this);
    }

    public int getTrees()
    {
        return jniLivenessAndTMJNI.HierarchicalClusteringSettings_getTrees(a, this);
    }
}
