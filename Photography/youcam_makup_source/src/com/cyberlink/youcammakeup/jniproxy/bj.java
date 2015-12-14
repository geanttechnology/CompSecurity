// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI

public class bj
{

    protected boolean a;
    private long b;

    public bj()
    {
        this(UIVenusJNI.new_UIUserProfile__SWIG_0(), true);
    }

    protected bj(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(bj bj1)
    {
        if (bj1 == null)
        {
            return 0L;
        } else
        {
            return bj1.b;
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
                UIVenusJNI.delete_UIUserProfile(b);
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

    public int b()
    {
        return UIVenusJNI.UIUserProfile_getStatus(b, this);
    }

    public int c()
    {
        return UIVenusJNI.UIUserProfile_getGender(b, this);
    }

    public int d()
    {
        return UIVenusJNI.UIUserProfile_getSkinColor(b, this);
    }

    public int e()
    {
        return UIVenusJNI.UIUserProfile_getHairColor(b, this);
    }

    public int f()
    {
        return UIVenusJNI.UIUserProfile_getEyebrowColor(b, this);
    }

    protected void finalize()
    {
        a();
    }

    public int g()
    {
        return UIVenusJNI.UIUserProfile_getIrisColor(b, this);
    }

    public int h()
    {
        return UIVenusJNI.UIUserProfile_getLipColor(b, this);
    }
}
