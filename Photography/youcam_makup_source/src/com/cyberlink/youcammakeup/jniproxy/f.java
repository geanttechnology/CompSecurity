// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;

import java.nio.ByteBuffer;

// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI, aj, ah, ai, 
//            av, ax, bn, y, 
//            az, bi, bj, bl, 
//            d, bm, r, bk

public class f
{

    static final boolean b;
    protected boolean a;
    private long c;

    protected f(long l, boolean flag)
    {
        a = flag;
        c = l;
    }

    public f(String s, String s1, String s2, String s3)
    {
        this(UIVenusJNI.new_CUIVenus(s, s1, s2, s3), true);
    }

    public int a(int l, aj aj1)
    {
        return UIVenusJNI.CUIVenus_GetFaceInfos__SWIG_0(c, this, l, aj.a(aj1), aj1);
    }

    public int a(ah ah1)
    {
        return UIVenusJNI.CUIVenus_ContinueWarpWigInLocal(c, this, ah.a(ah1), ah1);
    }

    public int a(ai ai1, av av1)
    {
        return UIVenusJNI.CUIVenus_GetEyebrowOriginalColor(c, this, ai.a(ai1), ai1, av.a(av1), av1);
    }

    public int a(ai ai1, ax ax1)
    {
        return UIVenusJNI.CUIVenus_GetIrisRadius__SWIG_0(c, this, ai.a(ai1), ai1, ax.a(ax1), ax1);
    }

    public int a(ai ai1, bn bn1)
    {
        return UIVenusJNI.CUIVenus_GetAutoWigLuminanceParameter(c, this, ai.a(ai1), ai1, bn.a(bn1), bn1);
    }

    public int a(ai ai1, y y1)
    {
        return UIVenusJNI.CUIVenus_GetFaceAlignmentData__SWIG_0(c, this, ai.a(ai1), ai1, y.a(y1), y1);
    }

    public int a(az az1, int l, az az2)
    {
        return UIVenusJNI.CUIVenus_GetLookParameters(c, this, az.a(az1), az1, l, az.a(az2), az2);
    }

    public int a(bi bi1, ah ah1)
    {
        return UIVenusJNI.CUIVenus_StartWarpWigInLocal(c, this, bi.a(bi1), bi1, ah.a(ah1), ah1);
    }

    public int a(bj bj1)
    {
        return UIVenusJNI.CUIVenus_ExtractUserProfile(c, this, bj.a(bj1), bj1);
    }

    public int a(bl bl1, d d1)
    {
        return UIVenusJNI.CUIVenus_GetWarpedWigModel(c, this, bl.a(bl1), bl1, com.cyberlink.youcammakeup.jniproxy.d.a(d1), d1);
    }

    public int a(bm bm1, float f1)
    {
        return UIVenusJNI.CUIVenus_ChangeWigColor(c, this, bm.a(bm1), bm1, f1);
    }

    public int a(d d1)
    {
        return UIVenusJNI.CUIVenus_AnalyzeImage(c, this, com.cyberlink.youcammakeup.jniproxy.d.a(d1), d1);
    }

    public int a(d d1, ah ah1, ah ah2, int l, ai ai1, y y1, bi bi1)
    {
        return UIVenusJNI.CUIVenus_GetEyewearNaturalLookingModelAndTranslation(c, this, com.cyberlink.youcammakeup.jniproxy.d.a(d1), d1, ah.a(ah1), ah1, ah.a(ah2), ah2, l, ai.a(ai1), ai1, y.a(y1), y1, bi.a(bi1), bi1);
    }

    public int a(d d1, ah ah1, ah ah2, ah ah3, ah ah4, ai ai1, y y1, 
            bi bi1, bi bi2)
    {
        return UIVenusJNI.CUIVenus_GetEarringNaturalLookingModelAndTranslation(c, this, com.cyberlink.youcammakeup.jniproxy.d.a(d1), d1, ah.a(ah1), ah1, ah.a(ah2), ah2, ah.a(ah3), ah3, ah.a(ah4), ah4, ai.a(ai1), ai1, y.a(y1), y1, bi.a(bi1), bi1, bi.a(bi2), bi2);
    }

    public int a(d d1, ah ah1, ah ah2, ah ah3, y y1)
    {
        return UIVenusJNI.CUIVenus_ManualGetFaceAlignmentData(c, this, com.cyberlink.youcammakeup.jniproxy.d.a(d1), d1, ah.a(ah1), ah1, ah.a(ah2), ah2, ah.a(ah3), ah3, y.a(y1), y1);
    }

    public int a(d d1, ah ah1, ah ah2, ai ai1, y y1, bi bi1)
    {
        return UIVenusJNI.CUIVenus_GetHairbandNaturalLookingModelAndTranslation(c, this, com.cyberlink.youcammakeup.jniproxy.d.a(d1), d1, ah.a(ah1), ah1, ah.a(ah2), ah2, ai.a(ai1), ai1, y.a(y1), y1, bi.a(bi1), bi1);
    }

    public int a(d d1, ai ai1, y y1)
    {
        return UIVenusJNI.CUIVenus_AutoDetectHairDyeMask(c, this, com.cyberlink.youcammakeup.jniproxy.d.a(d1), d1, ai.a(ai1), ai1, y.a(y1), y1);
    }

    public int a(d d1, r r1)
    {
        return UIVenusJNI.CUIVenus_GenerateHairDyeThumbnail(c, this, com.cyberlink.youcammakeup.jniproxy.d.a(d1), d1, r.a(r1), r1);
    }

    public int a(d d1, ByteBuffer bytebuffer, boolean flag, int l)
    {
        if (!b && !bytebuffer.isDirect())
        {
            throw new AssertionError("Buffer must be allocated direct.");
        } else
        {
            return UIVenusJNI.CUIVenus_UpdateHairDyeMask(c, this, com.cyberlink.youcammakeup.jniproxy.d.a(d1), d1, bytebuffer, flag, l);
        }
    }

    public int a(String s)
    {
        return UIVenusJNI.CUIVenus_SetUserProfileFolder(c, this, s);
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (c != 0L)
        {
            if (a)
            {
                a = false;
                UIVenusJNI.delete_CUIVenus(c);
            }
            c = 0L;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(boolean flag)
    {
        UIVenusJNI.CUIVenus_FlipWig(c, this, flag);
    }

    public void a(boolean flag, float f1)
    {
        UIVenusJNI.CUIVenus_SetSkinSmoothFilterStatus(c, this, flag, f1);
    }

    public void a(byte abyte0[], int l, int i1, int j1, boolean flag)
    {
        UIVenusJNI.CUIVenus_SendFrameBuffer(c, this, abyte0, l, i1, j1, flag);
    }

    public void a(Object aobj[], int l, int i1)
    {
        UIVenusJNI.CUIVenus_InitialEyeModelCommonInfo(c, this, aobj, l, i1);
    }

    public boolean a(int l)
    {
        return UIVenusJNI.CUIVenus_SetLipstickIntensity(c, this, l);
    }

    public boolean a(ai ai1)
    {
        return UIVenusJNI.CUIVenus_DetectOpenMouth(c, this, ai.a(ai1), ai1);
    }

    public boolean a(d d1, d d2, bk bk1)
    {
        return UIVenusJNI.CUIVenus_GetMakeupImage(c, this, com.cyberlink.youcammakeup.jniproxy.d.a(d1), d1, com.cyberlink.youcammakeup.jniproxy.d.a(d2), d2, bk.a(bk1), bk1);
    }

    public boolean a(Object obj)
    {
        return UIVenusJNI.CUIVenus_GetInternalModelState(c, this, obj);
    }

    public boolean a(Object obj, int l)
    {
        return UIVenusJNI.CUIVenus_GetFaceInfos__SWIG_1(c, this, obj, l);
    }

    public boolean a(Object obj, Object obj1)
    {
        return UIVenusJNI.CUIVenus_GetFaceAlignmentData__SWIG_1(c, this, obj, obj1);
    }

    public boolean a(Object obj, Object obj1, int l, int i1, int j1, int ai1[], float f1, 
            float f2, boolean flag)
    {
        return UIVenusJNI.CUIVenus_AnalyzeLiveImage(c, this, obj, obj1, l, i1, j1, ai1, f1, f2, flag);
    }

    public boolean a(String s, String s1)
    {
        return UIVenusJNI.CUIVenus_SetInternalModelPaths(c, this, s, s1);
    }

    public boolean a(byte abyte0[], Object aobj[], int l, int i1, int j1, int k1, int l1)
    {
        return UIVenusJNI.CUIVenus_PreprocessEyelinerModel(c, this, abyte0, aobj, l, i1, j1, k1, l1);
    }

    public boolean a(int ai1[], Object aobj[], int ai2[], int ai3[], int l, int i1, int j1, 
            int k1, int l1, int ai4[], int i2, int j2, int k2, byte abyte0[], 
            byte abyte1[], byte abyte2[])
    {
        return UIVenusJNI.CUIVenus_PreprocessEyeshadowModel(c, this, ai1, aobj, ai2, ai3, l, i1, j1, k1, l1, ai4, i2, j2, k2, abyte0, abyte1, abyte2);
    }

    public boolean a(Object aobj[], Object obj, Object obj1, Object obj2, Object obj3)
    {
        return UIVenusJNI.CUIVenus_GetMakeupMetadata(c, this, aobj, obj, obj1, obj2, obj3);
    }

    public int b(bl bl1, d d1)
    {
        return UIVenusJNI.CUIVenus_EndWarpWigInLocal(c, this, bl.a(bl1), bl1, com.cyberlink.youcammakeup.jniproxy.d.a(d1), d1);
    }

    public int b(d d1)
    {
        return UIVenusJNI.CUIVenus_GetHairDyeMask(c, this, com.cyberlink.youcammakeup.jniproxy.d.a(d1), d1);
    }

    public int b(d d1, ah ah1, ah ah2, ai ai1, y y1, bi bi1)
    {
        return UIVenusJNI.CUIVenus_GetNecklaceNaturalLookingModelAndTranslation(c, this, com.cyberlink.youcammakeup.jniproxy.d.a(d1), d1, ah.a(ah1), ah1, ah.a(ah2), ah2, ai.a(ai1), ai1, y.a(y1), y1, bi.a(bi1), bi1);
    }

    public void b(boolean flag)
    {
        UIVenusJNI.CUIVenus_setIsHoudini(c, this, flag);
    }

    public boolean b()
    {
        return UIVenusJNI.CUIVenus_IsModelLoaded(c, this);
    }

    public boolean b(Object obj)
    {
        return UIVenusJNI.CUIVenus_GetFaceRectangle(c, this, obj);
    }

    public boolean b(Object obj, Object obj1)
    {
        return UIVenusJNI.CUIVenus_GetIrisRadius__SWIG_1(c, this, obj, obj1);
    }

    public boolean b(String s)
    {
        return UIVenusJNI.CUIVenus_DumpWigOffsetData(c, this, s);
    }

    public boolean b(byte abyte0[], Object aobj[], int l, int i1, int j1, int k1, int l1)
    {
        return UIVenusJNI.CUIVenus_PreprocessEyelashModel(c, this, abyte0, aobj, l, i1, j1, k1, l1);
    }

    public int c(d d1)
    {
        return UIVenusJNI.CUIVenus_SetHairDyeMask(c, this, com.cyberlink.youcammakeup.jniproxy.d.a(d1), d1);
    }

    public boolean c()
    {
        return UIVenusJNI.CUIVenus_IsLocalMoveWigDone(c, this);
    }

    public boolean c(Object obj)
    {
        return UIVenusJNI.CUIVenus_SetLipstickProfile(c, this, obj);
    }

    public boolean c(String s)
    {
        return UIVenusJNI.CUIVenus_LoadWigOffsetData(c, this, s);
    }

    public void d()
    {
        UIVenusJNI.CUIVenus_ReleaseWigOffsetData(c, this);
    }

    public void e()
    {
        UIVenusJNI.CUIVenus_UndoWarpWig(c, this);
    }

    public void f()
    {
        UIVenusJNI.CUIVenus_RedoWarpWig(c, this);
    }

    protected void finalize()
    {
        a();
    }

    public void g()
    {
        UIVenusJNI.CUIVenus_ResetWarpWig(c, this);
    }

    public int h()
    {
        return UIVenusJNI.CUIVenus_QueryHairDetectionProgress(c, this);
    }

    public boolean i()
    {
        return UIVenusJNI.CUIVenus_ReleaseMakeupBuffer(c, this);
    }

    public boolean j()
    {
        return UIVenusJNI.CUIVenus_MakeupLiveInitialize(c, this);
    }

    public boolean k()
    {
        return UIVenusJNI.CUIVenus_MakeupLiveUnInitialize(c, this);
    }

    static 
    {
        boolean flag;
        if (!com/cyberlink/youcammakeup/jniproxy/f.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
    }
}
