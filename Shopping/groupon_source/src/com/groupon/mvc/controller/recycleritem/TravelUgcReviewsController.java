// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Merchant;
import com.groupon.mvc.model.TravelUgcReviews;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            RecyclerItemViewController

public class TravelUgcReviewsController extends RecyclerItemViewController
{

    private Deal deal;
    private boolean isTravelUGCReviewsEnabled;

    public TravelUgcReviewsController(Context context)
    {
        super(context);
        isTravelUGCReviewsEnabled = false;
    }

    public void processData()
    {
        Object obj;
        boolean flag;
        if (deal.merchant == null)
        {
            obj = Collections.emptyList();
        } else
        {
            obj = new ArrayList(deal.merchant.tips);
        }
        if (isTravelUGCReviewsEnabled && (Strings.notEmpty(deal.derivedMerchantRecommendationPercentMessage) && Strings.notEmpty(deal.derivedMerchantRecommendationTotalMessage) || !((List) (obj)).isEmpty()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            setState(0);
            return;
        }
        model = new TravelUgcReviews();
        ((TravelUgcReviews)model).uuid = deal.uuid;
        TravelUgcReviews travelugcreviews = (TravelUgcReviews)model;
        String s;
        if (deal.isTravelBookableDeal)
        {
            s = "bookingDeal";
        } else
        {
            s = "voucherDeal";
        }
        travelugcreviews.dealType = s;
        ((TravelUgcReviews)model).merchantTips = ((List) (obj));
        ((TravelUgcReviews)model).percentMessage = deal.derivedMerchantRecommendationPercentMessage;
        ((TravelUgcReviews)model).totalMessage = deal.derivedMerchantRecommendationTotalMessage;
        setState(2);
    }

    public void setDeal(Deal deal1)
    {
        setState(1);
        deal = deal1;
    }

    public void setTravelUGCReviewsEnabled(boolean flag)
    {
        isTravelUGCReviewsEnabled = flag;
    }
}
