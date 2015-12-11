// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.reviews;

import java.util.ArrayList;
import org.json.JSONObject;

// Referenced classes of package com.bestbuy.android.api.lib.models.reviews:
//            RatingAndReview, Error

public class ReviewResponse
{

    private ArrayList errors;
    private boolean hasErrors;
    private int limit;
    private String locale;
    private int offset;
    private ArrayList reviews;
    private int totalResults;

    public ReviewResponse()
    {
    }

    public static ReviewResponse loadReviewResponseData(JSONObject jsonobject)
    {
        ReviewResponse reviewresponse = new ReviewResponse();
        reviewresponse.hasErrors = jsonobject.optBoolean("HasErrors");
        reviewresponse.offset = jsonobject.optInt("Offset");
        reviewresponse.totalResults = jsonobject.optInt("TotalResults");
        reviewresponse.locale = jsonobject.optString("Locale");
        reviewresponse.limit = jsonobject.optInt("Limit");
        if (jsonobject.optJSONArray("Results") != null)
        {
            reviewresponse.reviews = RatingAndReview.loadRatingsAndReviewsData(jsonobject);
        }
        if (jsonobject.optJSONArray("Errors") != null)
        {
            reviewresponse.errors = Error.loadErrorsData(jsonobject.optJSONArray("Errors"));
        }
        return reviewresponse;
    }

    public ArrayList getErrors()
    {
        return errors;
    }

    public int getLimit()
    {
        return limit;
    }

    public String getLocale()
    {
        return locale;
    }

    public int getOffset()
    {
        return offset;
    }

    public ArrayList getReviews()
    {
        return reviews;
    }

    public int getTotalResults()
    {
        return totalResults;
    }

    public boolean isHasErrors()
    {
        return hasErrors;
    }
}
