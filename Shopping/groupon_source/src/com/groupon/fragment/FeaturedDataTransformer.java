// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.abtest.GtgAbTestHelper;
import com.groupon.models.EndlessList;
import com.groupon.models.gdt.GtgMockDealSummary;

// Referenced classes of package com.groupon.fragment:
//            DataTransformer

public class FeaturedDataTransformer extends DataTransformer
{

    private final GtgAbTestHelper gtgAbTestHelper;

    public FeaturedDataTransformer(GtgAbTestHelper gtgabtesthelper)
    {
        gtgAbTestHelper = gtgabtesthelper;
    }

    protected void addGtgMockCardsWhenNeeded(EndlessList endlesslist)
    {
label0:
        {
            if (!endlesslist.isEmpty())
            {
                if (!gtgAbTestHelper.isGtgJumpoffCardOnFeatured())
                {
                    break label0;
                }
                endlesslist.add(0, new GtgMockDealSummary("gtg_mock_jumpoff_deal_summary_remote_id"));
            }
            return;
        }
        super.addGtgMockCardsWhenNeeded(endlesslist);
    }
}
