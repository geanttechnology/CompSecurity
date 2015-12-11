// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop;

import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.h;
import com.target.mothership.services.x;
import com.target.ui.util.deep_link.PromotionParams;

// Referenced classes of package com.target.ui.fragment.shop:
//            PageItemFragment

class val.promotionParams extends h
{

    final PageItemFragment this$0;
    final PromotionParams val$promotionParams;

    public String a()
    {
        return PageItemFragment.d(PageItemFragment.this);
    }

    public void a(Guest guest)
    {
        PageItemFragment.a(PageItemFragment.this, val$promotionParams, guest);
    }

    public void a(x x1)
    {
        PageItemFragment.b(PageItemFragment.this, getString(0x7f090495));
    }

    public volatile void a(Object obj)
    {
        a((Guest)obj);
    }

    public void b(Object obj)
    {
        a((x)obj);
    }

    est()
    {
        this$0 = final_pageitemfragment;
        val$promotionParams = PromotionParams.this;
        super();
    }
}
