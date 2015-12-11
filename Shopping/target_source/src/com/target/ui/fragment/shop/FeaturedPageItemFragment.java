// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop;

import com.target.mothership.common.params.PageItemParams;
import com.target.ui.analytics.a.ba;
import com.target.ui.util.deep_link.PromotionParams;

// Referenced classes of package com.target.ui.fragment.shop:
//            PageItemFragment

public class FeaturedPageItemFragment extends PageItemFragment
{

    public FeaturedPageItemFragment()
    {
    }

    public static FeaturedPageItemFragment a(PageItemParams pageitemparams)
    {
        FeaturedPageItemFragment featuredpageitemfragment = new FeaturedPageItemFragment();
        featuredpageitemfragment.setArguments(b(pageitemparams));
        return featuredpageitemfragment;
    }

    public static FeaturedPageItemFragment a(PromotionParams promotionparams)
    {
        FeaturedPageItemFragment featuredpageitemfragment = new FeaturedPageItemFragment();
        featuredpageitemfragment.setArguments(b(promotionparams));
        return featuredpageitemfragment;
    }

    private void b(long l)
    {
        if (s())
        {
            return;
        } else
        {
            ba.a(l, this).e();
            return;
        }
    }

    public static FeaturedPageItemFragment d()
    {
        FeaturedPageItemFragment featuredpageitemfragment = new FeaturedPageItemFragment();
        featuredpageitemfragment.setArguments(j());
        return featuredpageitemfragment;
    }

    protected void a(long l)
    {
        b(l);
    }

    protected PageItemFragment.b b()
    {
        return PageItemFragment.b.FEATURED;
    }

    protected void c()
    {
    }

    public void e()
    {
        b(0L);
    }
}
