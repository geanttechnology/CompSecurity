// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.groupon.db.models.HotelReview;
import java.util.List;

// Referenced classes of package com.groupon.adapter:
//            TripAdvisorReviewAdapter

private class actionType
    implements android.view.stener
{

    private final String actionType;
    private final int reviewPos;
    private final TextView reviewText;
    private final int startingHeight;
    final TripAdvisorReviewAdapter this$0;

    public void onGlobalLayout()
    {
        int i = reviewText.getHeight() - startingHeight;
        if (i != 0)
        {
            TripAdvisorReviewAdapter.access$200(TripAdvisorReviewAdapter.this).onReviewExpand(actionType, ((HotelReview)TripAdvisorReviewAdapter.access$100(TripAdvisorReviewAdapter.this).get(reviewPos)).rating, reviewPos + 1, i);
        }
        reviewText.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    public I(TextView textview, int i, int j, String s)
    {
        this$0 = TripAdvisorReviewAdapter.this;
        super();
        reviewText = textview;
        reviewPos = i;
        startingHeight = j;
        actionType = s;
    }
}
