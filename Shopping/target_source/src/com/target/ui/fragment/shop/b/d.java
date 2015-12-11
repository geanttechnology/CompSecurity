// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop.b;

import android.support.v4.app.Fragment;
import com.target.ui.fragment.shop.FeaturedPageItemFragment;
import com.target.ui.model.shop.ShopOverrides;
import com.target.ui.util.deep_link.PromotionParams;
import java.util.Random;

// Referenced classes of package com.target.ui.fragment.shop.b:
//            e

public class d
    implements e
{

    private static final String LABEL = "featured";

    public d()
    {
    }

    private Fragment b(PromotionParams promotionparams, ShopOverrides shopoverrides)
    {
        if (shopoverrides != null)
        {
            promotionparams = FeaturedPageItemFragment.a(shopoverrides.a());
        } else
        if (promotionparams != null)
        {
            promotionparams = FeaturedPageItemFragment.a(promotionparams);
        } else
        {
            promotionparams = FeaturedPageItemFragment.d();
        }
        promotionparams.a(false);
        return promotionparams;
    }

    public Fragment a(PromotionParams promotionparams, ShopOverrides shopoverrides)
    {
        return b(promotionparams, shopoverrides);
    }

    public String a()
    {
        return "featured";
    }

    public long b()
    {
        return ID_GENERATOR_FOR_CHANGING_FRAGMENTS.nextLong();
    }
}
