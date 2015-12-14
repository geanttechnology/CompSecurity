// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI, s, ae, r, 
//            bc, bb, z, au, 
//            am, ai, y, av, 
//            bi, bl, bm

public class bk
{

    protected boolean a;
    private long b;

    public bk()
    {
        this(UIVenusJNI.new_UIVenusPipelineSettings__SWIG_0(), true);
    }

    protected bk(long l1, boolean flag)
    {
        a = flag;
        b = l1;
    }

    public bk(bk bk1)
    {
        this(UIVenusJNI.new_UIVenusPipelineSettings__SWIG_1(a(bk1), bk1), true);
    }

    protected static long a(bk bk1)
    {
        if (bk1 == null)
        {
            return 0L;
        } else
        {
            return bk1.b;
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
                UIVenusJNI.delete_UIVenusPipelineSettings(b);
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
        UIVenusJNI.UIVenusPipelineSettings_configCacheMode(b, this, i1);
    }

    public void a(int i1, float f1, int j1, s s1, ae ae1, ae ae2)
    {
        UIVenusJNI.UIVenusPipelineSettings_configEyeContact(b, this, i1, f1, j1, com.cyberlink.youcammakeup.jniproxy.s.a(s1), s1, ae.a(ae1), ae1, ae.a(ae2), ae2);
    }

    public void a(int i1, float f1, r r1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configHairDye(b, this, i1, f1, com.cyberlink.youcammakeup.jniproxy.r.a(r1), r1);
    }

    public void a(int i1, int j1, ae ae1, bc bc1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configEyeshadowTattooLeft(b, this, i1, j1, ae.a(ae1), ae1, bc.a(bc1), bc1);
    }

    public void a(int i1, int j1, r r1, ae ae1, ae ae2, bb bb1, bb bb2, 
            bb bb3, String s1, boolean flag, boolean flag1, int k1, z z1, z z2)
    {
        UIVenusJNI.UIVenusPipelineSettings_configBrow(b, this, i1, j1, com.cyberlink.youcammakeup.jniproxy.r.a(r1), r1, ae.a(ae1), ae1, ae.a(ae2), ae2, bb.a(bb1), bb1, bb.a(bb2), bb2, bb.a(bb3), bb3, s1, flag, flag1, k1, z.a(z1), z1, z.a(z2), z2);
    }

    public void a(int i1, r r1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configSkinTone(b, this, i1, com.cyberlink.youcammakeup.jniproxy.r.a(r1), r1);
    }

    public void a(int i1, r r1, ae ae1, bc bc1, String s1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configDoubleEyelid(b, this, i1, com.cyberlink.youcammakeup.jniproxy.r.a(r1), r1, ae.a(ae1), ae1, bc.a(bc1), bc1, s1);
    }

    public void a(int i1, r r1, ae ae1, bc bc1, String s1, int j1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configEyeliner(b, this, i1, com.cyberlink.youcammakeup.jniproxy.r.a(r1), r1, ae.a(ae1), ae1, bc.a(bc1), bc1, s1, j1);
    }

    public void a(int i1, r r1, String s1, String s2, boolean flag)
    {
        UIVenusJNI.UIVenusPipelineSettings_configBlush(b, this, i1, com.cyberlink.youcammakeup.jniproxy.r.a(r1), r1, s1, s2, flag);
    }

    public void a(int i1, boolean flag, int j1, int k1, int l1, int i2)
    {
        UIVenusJNI.UIVenusPipelineSettings_configClassicLipstick(b, this, i1, flag, j1, k1, l1, i2);
    }

    public void a(int i1, boolean flag, int j1, int k1, int l1, int i2, int j2, 
            int k2, int l2, int i3, int j3)
    {
        UIVenusJNI.UIVenusPipelineSettings_configKoreanStyleLipstick(b, this, i1, flag, j1, k1, l1, i2, j2, k2, l2, i3, j3);
    }

    public void a(ae ae1, au au1, am am1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configFaceArt(b, this, ae.a(ae1), ae1, au.a(au1), au1, am.a(am1), am1);
    }

    public void a(ai ai1, y y1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configFaceData(b, this, ai.a(ai1), ai1, y.a(y1), y1);
    }

    public void a(av av1, s s1, av av2, ae ae1, bc bc1, String s2, ae ae2, 
            av av3, int i1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configEyeshadow(b, this, av.a(av1), av1, com.cyberlink.youcammakeup.jniproxy.s.a(s1), s1, av.a(av2), av2, ae.a(ae1), ae1, bc.a(bc1), bc1, s2, ae.a(ae2), ae2, av.a(av3), av3, i1);
    }

    public void a(bi bi1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configWigTransform(b, this, bi.a(bi1), bi1);
    }

    public void a(bl bl1)
    {
        UIVenusJNI.UIVenusPipelineSettings_getWarpedWigImageInfo(b, this, bl.a(bl1), bl1);
    }

    public void a(z z1, z z2)
    {
        UIVenusJNI.UIVenusPipelineSettings_getOriginalEyeBrow(b, this, z.a(z1), z1, z.a(z2), z2);
    }

    public void a(boolean flag)
    {
        UIVenusJNI.UIVenusPipelineSettings_configAutoSpotRemoval(b, this, flag);
    }

    public void a(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, bi bi1, bm bm1, 
            ae ae1, int i1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configWig(b, this, flag, flag1, flag2, flag3, flag4, bi.a(bi1), bi1, bm.a(bm1), bm1, ae.a(ae1), ae1, i1);
    }

    public int b()
    {
        return UIVenusJNI.UIVenusPipelineSettings_queryCacheMode(b, this);
    }

    public void b(int i1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configAntiShine(b, this, i1);
    }

    public void b(int i1, int j1, ae ae1, bc bc1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configEyeshadowTattooRight(b, this, i1, j1, ae.a(ae1), ae1, bc.a(bc1), bc1);
    }

    public void b(int i1, r r1, ae ae1, bc bc1, String s1, int j1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configEyelash(b, this, i1, com.cyberlink.youcammakeup.jniproxy.r.a(r1), r1, ae.a(ae1), ae1, bc.a(bc1), bc1, s1, j1);
    }

    public void b(ae ae1, au au1, am am1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configFaceWidget(b, this, ae.a(ae1), ae1, au.a(au1), au1, am.a(am1), am1);
    }

    public void b(bi bi1)
    {
        UIVenusJNI.UIVenusPipelineSettings_getWarpedWigTransform(b, this, bi.a(bi1), bi1);
    }

    public void b(z z1, z z2)
    {
        UIVenusJNI.UIVenusPipelineSettings_configOriginalEyeBrow(b, this, z.a(z1), z1, z.a(z2), z2);
    }

    public void b(boolean flag)
    {
        UIVenusJNI.UIVenusPipelineSettings_UpdateEyeBrowAutoHiddenFlag(b, this, flag);
    }

    public ai c()
    {
        return new ai(UIVenusJNI.UIVenusPipelineSettings_queryFaceRect(b, this), true);
    }

    public void c(int i1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configSkinSmooth(b, this, i1);
    }

    public void c(int i1, int j1, ae ae1, bc bc1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configEyelinerTattooLeft(b, this, i1, j1, ae.a(ae1), ae1, bc.a(bc1), bc1);
    }

    public void c(boolean flag)
    {
        UIVenusJNI.UIVenusPipelineSettings_UpdateEyeBrowAutoMatchFlag(b, this, flag);
    }

    public y d()
    {
        return new y(UIVenusJNI.UIVenusPipelineSettings_queryFeaturePoints(b, this), true);
    }

    public void d(int i1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configFaceContour(b, this, i1);
    }

    public void d(int i1, int j1, ae ae1, bc bc1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configEyelinerTattooRight(b, this, i1, j1, ae.a(ae1), ae1, bc.a(bc1), bc1);
    }

    public void d(boolean flag)
    {
        UIVenusJNI.UIVenusPipelineSettings_setEnableWig(b, this, flag);
    }

    public void e(int i1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configNoseEnhancement(b, this, i1);
    }

    public void e(int i1, int j1, ae ae1, bc bc1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configEyelashTattooLeftUpper(b, this, i1, j1, ae.a(ae1), ae1, bc.a(bc1), bc1);
    }

    public void e(boolean flag)
    {
        UIVenusJNI.UIVenusPipelineSettings_setIsWigModelChange(b, this, flag);
    }

    public boolean e()
    {
        return UIVenusJNI.UIVenusPipelineSettings_getBrowAutoHiddenFlag(b, this);
    }

    public void f(int i1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configSparkleEye(b, this, i1);
    }

    public void f(int i1, int j1, ae ae1, bc bc1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configEyelashTattooLeftLower(b, this, i1, j1, ae.a(ae1), ae1, bc.a(bc1), bc1);
    }

    public void f(boolean flag)
    {
        UIVenusJNI.UIVenusPipelineSettings_configMouthOpen(b, this, flag);
    }

    public boolean f()
    {
        return UIVenusJNI.UIVenusPipelineSettings_getBrowAutoMatchFlag(b, this);
    }

    protected void finalize()
    {
        a();
    }

    public int g()
    {
        return UIVenusJNI.UIVenusPipelineSettings_getBrowHiddenIntensity(b, this);
    }

    public void g(int i1, int j1, ae ae1, bc bc1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configEyelashTattooRightUpper(b, this, i1, j1, ae.a(ae1), ae1, bc.a(bc1), bc1);
    }

    public void h(int i1, int j1, ae ae1, bc bc1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configEyelashTattooRightLower(b, this, i1, j1, ae.a(ae1), ae1, bc.a(bc1), bc1);
    }

    public boolean h()
    {
        return UIVenusJNI.UIVenusPipelineSettings_isModelBrowRectAllZero(b, this);
    }

    public void i()
    {
        UIVenusJNI.UIVenusPipelineSettings_configEyelashTattooResetAll(b, this);
    }

    public void i(int i1, int j1, ae ae1, bc bc1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configEyebrowTattooLeft(b, this, i1, j1, ae.a(ae1), ae1, bc.a(bc1), bc1);
    }

    public ae j()
    {
        return new ae(UIVenusJNI.UIVenusPipelineSettings_getWigCache(b, this), true);
    }

    public void j(int i1, int j1, ae ae1, bc bc1)
    {
        UIVenusJNI.UIVenusPipelineSettings_configEyebrowTattooRight(b, this, i1, j1, ae.a(ae1), ae1, bc.a(bc1), bc1);
    }

    public boolean k()
    {
        return UIVenusJNI.UIVenusPipelineSettings_getEnableWig(b, this);
    }

    public boolean l()
    {
        return UIVenusJNI.UIVenusPipelineSettings_getIsWigModelChange(b, this);
    }

    public boolean m()
    {
        return UIVenusJNI.UIVenusPipelineSettings_isForceApplyWigPosition(b, this);
    }

    public boolean n()
    {
        return UIVenusJNI.UIVenusPipelineSettings_getEnableEyeContact(b, this);
    }

    public s o()
    {
        return new s(UIVenusJNI.UIVenusPipelineSettings_getEyeContactColor(b, this), true);
    }

    public int p()
    {
        return UIVenusJNI.UIVenusPipelineSettings_getEyeContactIntensity(b, this);
    }

    public float q()
    {
        return UIVenusJNI.UIVenusPipelineSettings_getEyeContactIntensitySize(b, this);
    }

    public int r()
    {
        return UIVenusJNI.UIVenusPipelineSettings_getEyeContactIrisRadius(b, this);
    }

    public ae s()
    {
        return new ae(UIVenusJNI.UIVenusPipelineSettings_getEyeContactModelCache(b, this), true);
    }

    public ae t()
    {
        return new ae(UIVenusJNI.UIVenusPipelineSettings_getEyeContactMaskModelCache(b, this), true);
    }

    public boolean u()
    {
        return UIVenusJNI.UIVenusPipelineSettings_getEnableEyeBrow(b, this);
    }

    public boolean v()
    {
        return UIVenusJNI.UIVenusPipelineSettings_getEnableHairDye(b, this);
    }
}
