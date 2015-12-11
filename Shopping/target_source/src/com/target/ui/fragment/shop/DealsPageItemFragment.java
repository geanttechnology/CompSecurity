// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop;

import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.ui.analytics.a.ba;

// Referenced classes of package com.target.ui.fragment.shop:
//            PageItemFragment

public class DealsPageItemFragment extends PageItemFragment
{

    public DealsPageItemFragment()
    {
    }

    public static DealsPageItemFragment a(PromotionRequest promotionrequest)
    {
        DealsPageItemFragment dealspageitemfragment = new DealsPageItemFragment();
        dealspageitemfragment.setArguments(b(promotionrequest));
        return dealspageitemfragment;
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

    public static DealsPageItemFragment d()
    {
        DealsPageItemFragment dealspageitemfragment = new DealsPageItemFragment();
        dealspageitemfragment.setArguments(j());
        return dealspageitemfragment;
    }

    protected void a(long l)
    {
        b(l);
    }

    protected PageItemFragment.b b()
    {
        return PageItemFragment.b.DEALS;
    }

    protected void c()
    {
    }

    public void e()
    {
        b(0L);
    }

    protected boolean i()
    {
        return true;
    }
}
