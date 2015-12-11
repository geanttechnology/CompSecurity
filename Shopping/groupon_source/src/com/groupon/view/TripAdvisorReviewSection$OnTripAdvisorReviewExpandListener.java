// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;
import com.groupon.models.nst.TravelReviewsClickExtraInfo;
import com.groupon.tracking.mobile.EncodedNSTField;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.v3.util.ScrollEventRecyclerView;

// Referenced classes of package com.groupon.view:
//            TripAdvisorReviewSection

private class <init>
    implements com.groupon.adapter.it>
{

    final TripAdvisorReviewSection this$0;

    public void onReviewExpand(String s, double d, int i, int j)
    {
        reviewList.getLayoutParams().ner = reviewList.getHeight() + j;
        reviewList.setLayoutParams(reviewList.getLayoutParams());
        content.getLayoutParams().ner = content.getHeight() + j;
        content.setLayoutParams(content.getLayoutParams());
        logger.logClick("", "travel_reviews_item_click", TripAdvisorReviewSection.access$200(TripAdvisorReviewSection.this), new EncodedNSTField() {

            final TripAdvisorReviewSection.OnTripAdvisorReviewExpandListener this$1;

            public String toEncodedString()
            {
                return TripAdvisorReviewSection.access$100(this$0);
            }

            
            {
                this$1 = TripAdvisorReviewSection.OnTripAdvisorReviewExpandListener.this;
                super();
            }
        }, new TravelReviewsClickExtraInfo("TA", s, Double.valueOf(d), Integer.valueOf(i)));
    }

    private _cls1.this._cls1()
    {
        this$0 = TripAdvisorReviewSection.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
