// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import com.groupon.callbacks.OnMerchantRecommendationsClickEventListener;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Merchant;
import com.groupon.db.models.Recommendation;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.mvc.model.MerchantRecommendation;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.MerchantRecommendationsUtil;
import java.util.Collection;
import java.util.Collections;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            RecyclerItemViewController

public class MerchantRecommendationsController extends RecyclerItemViewController
{

    private Deal deal;
    private Logger logger;
    private MerchantRecommendationsUtil merchantRecommendationsUtil;
    private OnMerchantRecommendationsClickEventListener recommendationsClickListener;

    public MerchantRecommendationsController(Context context)
    {
        super(context);
    }

    public OnMerchantRecommendationsClickEventListener getCallback()
    {
        return recommendationsClickListener;
    }

    public volatile Object getCallback()
    {
        return getCallback();
    }

    protected Collection getDealTips(Deal deal1)
    {
        if (deal1.merchant == null)
        {
            return Collections.emptyList();
        } else
        {
            return deal1.merchant.tips;
        }
    }

    public void processData()
    {
        boolean flag = false;
        Recommendation recommendation = merchantRecommendationsUtil.extractMerchantRecommendation(deal);
        String s = merchantRecommendationsUtil.generateMerchantRecommendationLabelHtml(recommendation);
        if (recommendation != null && !recommendation.prominentDisplay || Strings.isEmpty(s))
        {
            setState(0);
            return;
        }
        if (getDealTips(deal).size() > 0)
        {
            flag = true;
        }
        model = new MerchantRecommendation();
        ((MerchantRecommendation)model).merchantRecommendationLabelHtml = s;
        ((MerchantRecommendation)model).hasMerchantTips = flag;
        logger.logImpression("", "dd_ugc_recommendation", deal.remoteId, "", JsonEncodedNSTField.NULL_JSON_NST_FIELD);
        setState(2);
    }

    public void setDeal(Deal deal1)
    {
        setState(1);
        deal = deal1;
    }

    public void setRecommendationsClickListener(OnMerchantRecommendationsClickEventListener onmerchantrecommendationsclickeventlistener)
    {
        recommendationsClickListener = onmerchantrecommendationsclickeventlistener;
    }
}
