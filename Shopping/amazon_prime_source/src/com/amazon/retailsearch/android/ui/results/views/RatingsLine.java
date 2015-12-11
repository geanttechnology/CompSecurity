// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            RetailSearchResultView, RatingsLineModel

public class RatingsLine extends TextView
    implements RetailSearchResultView
{

    public RatingsLine(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public void buildView(RatingsLineModel ratingslinemodel, ResultLayoutType resultlayouttype)
    {
        if (ratingslinemodel == null || resultlayouttype == null)
        {
            setVisibility(8);
            return;
        } else
        {
            resultlayouttype = new StyledSpannableString(resultlayouttype, getContext());
            resultlayouttype.appendImage(ratingslinemodel.getStarsDrawable(), ratingslinemodel.getStarAccessibilityText(), Integer.valueOf(com.amazon.retailsearch.R.style.Results_Ratings));
            resultlayouttype.append((new StringBuilder()).append(" ").append(ratingslinemodel.getReviewCountText()).toString(), com.amazon.retailsearch.R.style.Results_Ratings);
            setText(resultlayouttype);
            setContentDescription((new StringBuilder()).append(ratingslinemodel.getStarAccessibilityText()).append(" ").append(ratingslinemodel.getCountAccessibilityText()).toString());
            setVisibility(0);
            return;
        }
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((RatingsLineModel)obj, resultlayouttype);
    }
}
