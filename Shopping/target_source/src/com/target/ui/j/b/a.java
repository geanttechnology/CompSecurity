// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.j.b;


// Referenced classes of package com.target.ui.j.b:
//            g, i, e, b, 
//            c, h, f, d

public class a
{

    private static a sInstance;
    private b mCartRecommendationsTestingOptions;
    private c mDealsTabTestingOptions;
    private d mInStoreExperienceTestingOptions;
    private e mListOrGridTestingOptions;
    private f mPayPalTestingOptions;
    private g mPdpExpressCheckoutTestingOptions;
    private h mPlpGridProductInfoTestingOptions;
    private i mPurchaseCTATestingOptions;

    private a()
    {
        mPdpExpressCheckoutTestingOptions = new g();
        mPurchaseCTATestingOptions = new i();
        mListOrGridTestingOptions = new e();
        mCartRecommendationsTestingOptions = new b();
        mDealsTabTestingOptions = new c();
        mPlpGridProductInfoTestingOptions = new h();
        mPayPalTestingOptions = new f();
        mInStoreExperienceTestingOptions = new d();
    }

    public static a a()
    {
        if (sInstance == null)
        {
            sInstance = new a();
        }
        return sInstance;
    }

    public g b()
    {
        return mPdpExpressCheckoutTestingOptions;
    }

    public i c()
    {
        return mPurchaseCTATestingOptions;
    }

    public e d()
    {
        return mListOrGridTestingOptions;
    }

    public b e()
    {
        return mCartRecommendationsTestingOptions;
    }

    public c f()
    {
        return mDealsTabTestingOptions;
    }

    public h g()
    {
        return mPlpGridProductInfoTestingOptions;
    }

    public d h()
    {
        return mInStoreExperienceTestingOptions;
    }
}
