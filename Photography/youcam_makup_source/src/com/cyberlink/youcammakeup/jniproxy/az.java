// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI, av

public class az
{

    protected boolean a;
    private long b;

    public az()
    {
        this(UIVenusJNI.new_UILookParameters(), true);
    }

    protected az(long l1, boolean flag)
    {
        a = flag;
        b = l1;
    }

    protected static long a(az az1)
    {
        if (az1 == null)
        {
            return 0L;
        } else
        {
            return az1.b;
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
                UIVenusJNI.delete_UILookParameters(b);
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

    public void a(int i1)
    {
        UIVenusJNI.UILookParameters_setAntiShineIntensity(b, this, i1);
    }

    public void a(av av1)
    {
        UIVenusJNI.UILookParameters_setEyeShadowIntensity(b, this, av.a(av1), av1);
    }

    public int b()
    {
        return UIVenusJNI.UILookParameters_getAntiShineIntensity(b, this);
    }

    public void b(int i1)
    {
        UIVenusJNI.UILookParameters_setSkinSmoothIntensity(b, this, i1);
    }

    public void b(av av1)
    {
        UIVenusJNI.UILookParameters_setEyeShadowShimmerIntensity(b, this, av.a(av1), av1);
    }

    public int c()
    {
        return UIVenusJNI.UILookParameters_getSkinSmoothIntensity(b, this);
    }

    public void c(int i1)
    {
        UIVenusJNI.UILookParameters_setFaceContourIntensity(b, this, i1);
    }

    public void c(av av1)
    {
        UIVenusJNI.UILookParameters_getEyeShadowIntensity(b, this, av.a(av1), av1);
    }

    public int d()
    {
        return UIVenusJNI.UILookParameters_getFaceContourIntensity(b, this);
    }

    public void d(int i1)
    {
        UIVenusJNI.UILookParameters_setNoseEnhancementIntentsity(b, this, i1);
    }

    public void d(av av1)
    {
        UIVenusJNI.UILookParameters_getEyeShadowShimmerIntensity(b, this, av.a(av1), av1);
    }

    public int e()
    {
        return UIVenusJNI.UILookParameters_getNoseEnhancementIntentsity(b, this);
    }

    public void e(int i1)
    {
        UIVenusJNI.UILookParameters_setSparkleEyeIntensity(b, this, i1);
    }

    public int f()
    {
        return UIVenusJNI.UILookParameters_getSparkleEyeIntensity(b, this);
    }

    public void f(int i1)
    {
        UIVenusJNI.UILookParameters_setEyeBrowIntensity(b, this, i1);
    }

    protected void finalize()
    {
        a();
    }

    public int g()
    {
        return UIVenusJNI.UILookParameters_getEyeBrowIntensity(b, this);
    }

    public void g(int i1)
    {
        UIVenusJNI.UILookParameters_setEyeBrowHiddenIntensity(b, this, i1);
    }

    public int h()
    {
        return UIVenusJNI.UILookParameters_getEyeBrowHiddenIntensity(b, this);
    }

    public void h(int i1)
    {
        UIVenusJNI.UILookParameters_setDoubleEyelidsIntensity(b, this, i1);
    }

    public int i()
    {
        return UIVenusJNI.UILookParameters_getDoubleEyelidsIntensity(b, this);
    }

    public void i(int i1)
    {
        UIVenusJNI.UILookParameters_setEyeContactsIntensity(b, this, i1);
    }

    public int j()
    {
        return UIVenusJNI.UILookParameters_getEyeContactsIntensity(b, this);
    }

    public void j(int i1)
    {
        UIVenusJNI.UILookParameters_setEyeShadowCount(b, this, i1);
    }

    public int k()
    {
        return UIVenusJNI.UILookParameters_getEyeShadowCount(b, this);
    }

    public void k(int i1)
    {
        UIVenusJNI.UILookParameters_setEyeLinerIntensity(b, this, i1);
    }

    public int l()
    {
        return UIVenusJNI.UILookParameters_getEyeLinerIntensity(b, this);
    }

    public void l(int i1)
    {
        UIVenusJNI.UILookParameters_setEyeLashIntensity(b, this, i1);
    }

    public int m()
    {
        return UIVenusJNI.UILookParameters_getEyeLashIntensity(b, this);
    }

    public void m(int i1)
    {
        UIVenusJNI.UILookParameters_setLipStickIntensity(b, this, i1);
    }

    public int n()
    {
        return UIVenusJNI.UILookParameters_getLipStickIntensity(b, this);
    }

    public void n(int i1)
    {
        UIVenusJNI.UILookParameters_setHairDyeIntensity(b, this, i1);
    }

    public int o()
    {
        return UIVenusJNI.UILookParameters_getHairDyeIntensity(b, this);
    }

    public void o(int i1)
    {
        UIVenusJNI.UILookParameters_setSkinToneIntensity(b, this, i1);
    }

    public int p()
    {
        return UIVenusJNI.UILookParameters_getSkinToneIntensity(b, this);
    }

    public void p(int i1)
    {
        UIVenusJNI.UILookParameters_setBlushIntensity(b, this, i1);
    }

    public int q()
    {
        return UIVenusJNI.UILookParameters_getBlushIntensity(b, this);
    }

    public void r()
    {
        UIVenusJNI.UILookParameters_dumpDebugString(b, this);
    }
}
