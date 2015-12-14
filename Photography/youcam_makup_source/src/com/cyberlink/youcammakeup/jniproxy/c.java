// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            DianaProxyJNI, ac, af, ab, 
//            ak, aa, ah, d, 
//            u

public class c
{

    protected boolean a;
    private long b;

    protected c(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    public c(String s)
    {
        this(DianaProxyJNI.new_CDianaProxy(s), true);
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
                DianaProxyJNI.delete_CDianaProxy(b);
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

    public boolean a(int i)
    {
        return DianaProxyJNI.CDianaProxy_SetImage(b, this, i);
    }

    public boolean a(int i, int j, float f, ac ac1, ac ac2, af af1, ab ab1, 
            ab ab2, ak ak1, ak ak2, aa aa1, ah ah1, ah ah2)
    {
        return DianaProxyJNI.CDianaProxy_QueryFaceThinningPoint(b, this, i, j, f, ac.a(ac1), ac1, ac.a(ac2), ac2, af.a(af1), af1, ab.a(ab1), ab1, ab.a(ab2), ab2, ak.a(ak1), ak1, ak.a(ak2), ak2, aa.a(aa1), aa1, ah.a(ah1), ah1, ah.a(ah2), ah2);
    }

    public boolean a(int i, int j, float f, ac ac1, ah ah1, ah ah2)
    {
        return DianaProxyJNI.CDianaProxy_QueryEyeEnlargePoint(b, this, i, j, f, ac.a(ac1), ac1, ah.a(ah1), ah1, ah.a(ah2), ah2);
    }

    public boolean a(d d1, d d2, u u1)
    {
        return DianaProxyJNI.CDianaProxy_ApplyPipelineEffects(b, this, d.a(d1), d1, d.a(d2), d2, u.a(u1), u1);
    }

    public boolean b(int i)
    {
        return DianaProxyJNI.CDianaProxy_ReleaseImage(b, this, i);
    }

    protected void finalize()
    {
        a();
    }
}
