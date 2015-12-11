// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Merchant;
import com.groupon.db.models.Recommendation;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.models.tips.MerchantTipsConverter;
import com.groupon.mvc.model.Tips;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.MerchantRecommendationsUtil;
import java.util.Collection;
import java.util.Collections;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            RecyclerItemViewController

public class TipsController extends RecyclerItemViewController
{

    public static final String DD_UGC_TIPS = "dd_ugc_tips";
    private Deal deal;
    private Logger logger;
    private MerchantRecommendationsUtil merchantRecommendationsUtil;
    private MerchantTipsConverter merchantTipsConverter;

    public TipsController(Context context)
    {
        super(context);
    }

    public volatile Object getCallback()
    {
        return getCallback();
    }

    public Void getCallback()
    {
        return null;
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
        Collection collection = getDealTips(deal);
        boolean flag;
        if (collection.size() > 0)
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
        Object obj = merchantRecommendationsUtil.extractMerchantRecommendation(deal);
        if (obj != null && !((Recommendation) (obj)).prominentDisplay)
        {
            obj = merchantRecommendationsUtil.generateMerchantRecommendationLabelHtml(((Recommendation) (obj)));
        } else
        {
            obj = null;
        }
        model = new Tips();
        ((Tips)model).merchantRecommendationLabelHtml = ((String) (obj));
        ((Tips)model).merchantTips = merchantTipsConverter.convertFrom(collection);
        logger.logImpression("", "dd_ugc_tips", deal.remoteId, "", JsonEncodedNSTField.NULL_JSON_NST_FIELD);
        setState(2);
    }

    public void setDeal(Deal deal1)
    {
        setState(1);
        deal = deal1;
    }
}
