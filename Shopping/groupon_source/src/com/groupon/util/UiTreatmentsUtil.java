// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.db.models.Deal;
import com.groupon.db.models.UiTreatment;
import com.groupon.service.core.AbTestService;
import java.util.List;

public class UiTreatmentsUtil
{

    private static final String UI_TREATMENT_THIRD_PARTY_LINKOUT_UUID = "bac5f409-23d9-4020-8cc5-90c9fc078994";
    private AbTestService abTestService;

    public UiTreatmentsUtil()
    {
    }

    public boolean isExperimentEnabled()
    {
        return abTestService.isVariantEnabledAndUSCA("thirdPartyLinkout1509", "on");
    }

    public boolean isThirdPartyLinkoutDeal(Deal deal)
    {
        deal = deal.getUiTreatment();
        return isExperimentEnabled() && deal.size() > 0 && ((UiTreatment)deal.get(0)).uuid.equals("bac5f409-23d9-4020-8cc5-90c9fc078994");
    }
}
