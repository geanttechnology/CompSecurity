// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.gdt;

import com.groupon.db.models.DealSummary;

public class GtgMockDealSummary extends DealSummary
{

    public static final String GTG_MOCK_JUMPOFF_DEAL_SUMMARY_REMOTE_ID = "gtg_mock_jumpoff_deal_summary_remote_id";
    public static final String GTG_MOCK_PROMO_DEAL_SUMMARY_REMOTE_ID = "gtg_mock_promo_deal_summary_remote_id";

    public GtgMockDealSummary(String s)
    {
        remoteId = s;
    }
}
