// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import com.groupon.mvc.model.TravelUgcReviews;
import com.groupon.view.UgcTipsSection;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public class TravelUgcReviewsViewHolder extends RecyclerItemViewHolder
{

    UgcTipsSection ugcTipsSection;

    public TravelUgcReviewsViewHolder(View view)
    {
        super(view);
    }

    public void populateViews()
    {
        ugcTipsSection.updateViews(((TravelUgcReviews)model).uuid, ((TravelUgcReviews)model).dealType, ((TravelUgcReviews)model).merchantTips, ((TravelUgcReviews)model).percentMessage, ((TravelUgcReviews)model).totalMessage);
    }
}
