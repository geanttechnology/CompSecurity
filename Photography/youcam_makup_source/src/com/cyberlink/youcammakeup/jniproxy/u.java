// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            DianaProxyJNI, y

public class u
{

    protected boolean a;
    private long b;

    public u()
    {
        this(DianaProxyJNI.new_UIDianaPipelineSettings__SWIG_0(), true);
    }

    protected u(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    public u(u u1)
    {
        this(DianaProxyJNI.new_UIDianaPipelineSettings__SWIG_1(a(u1), u1), true);
    }

    protected static long a(u u1)
    {
        if (u1 == null)
        {
            return 0L;
        } else
        {
            return u1.b;
        }
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (b != 0L)
        {
            if (a)
            {
                a = false;
                DianaProxyJNI.delete_UIDianaPipelineSettings(b);
            }
            b = 0L;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(int i)
    {
        DianaProxyJNI.UIDianaPipelineSettings_configCacheMode(b, this, i);
    }

    public void a(int i, boolean flag)
    {
        DianaProxyJNI.UIDianaPipelineSettings_configTeethWhitening(b, this, i, flag);
    }

    public void a(y y1)
    {
        DianaProxyJNI.UIDianaPipelineSettings_configFeaturePoints(b, this, y.a(y1), y1);
    }

    public void a(boolean flag)
    {
        DianaProxyJNI.UIDianaPipelineSettings_configRedEyeRemoval(b, this, flag);
    }

    public y b()
    {
        return new y(DianaProxyJNI.UIDianaPipelineSettings_queryFeaturePoints(b, this), true);
    }

    public void b(int i)
    {
        DianaProxyJNI.UIDianaPipelineSettings_configEyeEnlargement(b, this, i);
    }

    public void c(int i)
    {
        DianaProxyJNI.UIDianaPipelineSettings_configEyeBagRemoval(b, this, i);
    }

    public void d(int i)
    {
        DianaProxyJNI.UIDianaPipelineSettings_configFaceThinning(b, this, i);
    }

    protected void finalize()
    {
        a();
    }
}
