// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpreviews;

import com.bestbuy.android.api.lib.models.summariesNpriceBlock.CustomerRatings;
import gu;
import java.io.Serializable;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdpreviews:
//            DistilledReviewSummary

public class ReviewsResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private CustomerRatings customerRatings;
    private DistilledReviewSummary distilledReviewSummary;
    private boolean hasErrors;
    private ArrayList results;
    private int totalResults;

    public ReviewsResponse()
    {
    }

    public CustomerRatings getCustomerRatings()
    {
        return customerRatings;
    }

    public DistilledReviewSummary getDistilledReviewSummary()
    {
        return distilledReviewSummary;
    }

    public ArrayList getResults()
    {
        return results;
    }

    public int getTotalResults()
    {
        return totalResults;
    }

    public boolean isHasErrors()
    {
        return hasErrors;
    }

    public void setCustomerRatings(CustomerRatings customerratings)
    {
        customerRatings = customerratings;
    }

    public void setDistilledReviewSummary(DistilledReviewSummary distilledreviewsummary)
    {
        distilledReviewSummary = distilledreviewsummary;
    }

    public void setHasErrors(boolean flag)
    {
        hasErrors = flag;
    }

    public void setResults(ArrayList arraylist)
    {
        results = arraylist;
    }

    public void setTotalResults(int i)
    {
        totalResults = i;
    }
}
