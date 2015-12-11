// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import com.groupon.mvc.model.TripAdvisorReviews;
import com.groupon.view.TripAdvisorReviewSection;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public class TripAdvisorReviewsViewHolder extends RecyclerItemViewHolder
{

    TripAdvisorReviewSection tripAdvisorReviewSection;

    public TripAdvisorReviewsViewHolder(View view)
    {
        super(view);
    }

    public void populateViews()
    {
        tripAdvisorReviewSection.updateViews(((TripAdvisorReviews)model).hotelReviews, ((TripAdvisorReviews)model).uuid, ((TripAdvisorReviews)model).dealType);
    }
}
