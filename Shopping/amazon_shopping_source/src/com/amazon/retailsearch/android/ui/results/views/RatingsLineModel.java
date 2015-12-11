// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.amazon.retailsearch.android.ui.results.ProductUtil;
import com.amazon.searchapp.retailsearch.model.Ratings;

public class RatingsLineModel
{
    public static class Builder
    {

        private int getStarRating(Ratings ratings)
        {
            if (ratings != null)
            {
                return (int)Math.round(ratings.getRating() * 2D);
            } else
            {
                return 0;
            }
        }

        private Drawable getStarsDrawable(Resources resources, int i)
        {
            switch (i)
            {
            default:
                return resources.getDrawable(com.amazon.retailsearch.R.drawable.stars_1);

            case 10: // '\n'
                return resources.getDrawable(com.amazon.retailsearch.R.drawable.stars_5);

            case 9: // '\t'
                return resources.getDrawable(com.amazon.retailsearch.R.drawable.stars_4_5);

            case 8: // '\b'
                return resources.getDrawable(com.amazon.retailsearch.R.drawable.stars_4);

            case 7: // '\007'
                return resources.getDrawable(com.amazon.retailsearch.R.drawable.stars_3_5);

            case 6: // '\006'
                return resources.getDrawable(com.amazon.retailsearch.R.drawable.stars_3);

            case 5: // '\005'
                return resources.getDrawable(com.amazon.retailsearch.R.drawable.stars_2_5);

            case 4: // '\004'
                return resources.getDrawable(com.amazon.retailsearch.R.drawable.stars_2);

            case 3: // '\003'
                return resources.getDrawable(com.amazon.retailsearch.R.drawable.stars_1_5);
            }
        }

        public RatingsLineModel build(Ratings ratings, Resources resources)
        {
            if (ratings == null || resources == null)
            {
                return null;
            }
            RatingsLineModel ratingslinemodel = new RatingsLineModel();
            int i = getStarRating(ratings);
            if (i > 10 || i < 2)
            {
                return null;
            } else
            {
                ratingslinemodel.setStarsDrawable(getStarsDrawable(resources, i));
                resources = resources.getQuantityString(com.amazon.retailsearch.R.plurals.access_item_view_review_star, (int)Math.ceil(ratings.getRating()));
                ratingslinemodel.setAccessibilityText((new StringBuilder()).append(ratings.getRating()).append(" ").append(resources).toString());
                ratingslinemodel.setReviewCountText((new StringBuilder()).append("(").append(ProductUtil.formatNumber(ratings.getCount())).append(")").toString());
                return ratingslinemodel;
            }
        }

        public Builder()
        {
        }
    }


    private String accessibilityText;
    private String reviewCountText;
    private Drawable starsDrawable;

    public RatingsLineModel()
    {
    }

    private void setAccessibilityText(String s)
    {
        accessibilityText = s;
    }

    private void setReviewCountText(String s)
    {
        reviewCountText = s;
    }

    private void setStarsDrawable(Drawable drawable)
    {
        starsDrawable = drawable;
    }

    public String getAccessibilityText()
    {
        return accessibilityText;
    }

    public String getReviewCountText()
    {
        return reviewCountText;
    }

    public Drawable getStarsDrawable()
    {
        return starsDrawable;
    }



}
