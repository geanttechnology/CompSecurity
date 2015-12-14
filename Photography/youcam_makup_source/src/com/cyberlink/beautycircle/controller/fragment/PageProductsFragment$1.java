// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import com.cyberlink.beautycircle.model.CampaignGroup;
import com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            PageProductsFragment

class a extends m
{

    final PageProductsFragment a;

    public void a(int i)
    {
        PageProductsFragment.b(a).setCampaignGroup(null);
    }

    public void a(CampaignGroup campaigngroup)
    {
        PageProductsFragment.a(a, campaigngroup);
        PageProductsFragment.b(a).setCampaignGroup(PageProductsFragment.a(a));
    }

    public void b(Object obj)
    {
        a((CampaignGroup)obj);
    }

    (PageProductsFragment pageproductsfragment)
    {
        a = pageproductsfragment;
        super();
    }
}
