// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import com.bestbuy.android.api.lib.models.pdpreviews.DistilledReviewSummary;
import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdp:
//            OverviewResponse

public class PDPOverviewResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private DistilledReviewSummary distilledReviewSummary;
    private OverviewResponse overview;

    public PDPOverviewResponse()
    {
    }

    public DistilledReviewSummary getDistilledReviewSummary()
    {
        return distilledReviewSummary;
    }

    public OverviewResponse getOverview()
    {
        return overview;
    }

    public void setDistilledReviewSummary(DistilledReviewSummary distilledreviewsummary)
    {
        distilledReviewSummary = distilledreviewsummary;
    }

    public void setOverview(OverviewResponse overviewresponse)
    {
        overview = overviewresponse;
    }
}
