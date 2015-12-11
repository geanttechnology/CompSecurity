// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import com.amazon.searchapp.retailsearch.model.Points;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            LoyaltyPointsModel

public static class 
{

    public LoyaltyPointsModel build(Points points)
    {
        if (points == null || points.getLabel() == null)
        {
            return null;
        } else
        {
            LoyaltyPointsModel loyaltypointsmodel = new LoyaltyPointsModel();
            LoyaltyPointsModel.access$000(loyaltypointsmodel, points.getLabel());
            return loyaltypointsmodel;
        }
    }

    public ()
    {
    }
}
