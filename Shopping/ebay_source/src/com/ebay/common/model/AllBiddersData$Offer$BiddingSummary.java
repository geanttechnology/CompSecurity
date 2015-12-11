// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.common.model:
//            AllBiddersData

public static class itemBidDetails
{

    public int bidActivityWithSeller;
    public int bidRetractions;
    public int bidsToUniqueCategories;
    public int bidsToUniqueSellers;
    public List itemBidDetails;
    public String summaryDays;
    public int totalBids;

    public ()
    {
        itemBidDetails = new ArrayList();
    }
}
