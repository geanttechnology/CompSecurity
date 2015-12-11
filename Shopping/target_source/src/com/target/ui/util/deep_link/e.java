// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;

import android.os.Bundle;
import com.target.mothership.common.product.ProductIdentifier;

// Referenced classes of package com.target.ui.util.deep_link:
//            m, PromotionParams

public class e
{

    private final Bundle mArgs = new Bundle();
    private m mMarketingTags;
    private PromotionParams mPromotionParams;
    private String mSource;
    private String mTrackingId;

    public e()
    {
        mMarketingTags = new m();
    }

    public m a()
    {
        return mMarketingTags;
    }

    public void a(ProductIdentifier productidentifier)
    {
        mArgs.putParcelable("pdpProductIdentifier", productidentifier);
    }

    public void a(PromotionParams promotionparams)
    {
        mPromotionParams = promotionparams;
    }

    public void a(String s)
    {
        mSource = s;
    }

    public com.google.a.a.e b()
    {
        return com.google.a.a.e.c((ProductIdentifier)mArgs.getParcelable("pdpProductIdentifier"));
    }

    public void b(String s)
    {
        mTrackingId = s;
    }

    public com.google.a.a.e c()
    {
        return com.google.a.a.e.c(mPromotionParams);
    }

    public com.google.a.a.e d()
    {
        return com.google.a.a.e.c(mSource);
    }

    public com.google.a.a.e e()
    {
        return com.google.a.a.e.c(mTrackingId);
    }
}
