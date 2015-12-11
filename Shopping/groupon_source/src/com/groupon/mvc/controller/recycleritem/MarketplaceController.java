// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import com.groupon.callbacks.OnMarketplaceEventListener;
import com.groupon.db.models.Deal;
import com.groupon.mvc.model.Marketplace;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.DealUtils;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            RecyclerItemViewController

public class MarketplaceController extends RecyclerItemViewController
{
    private class OnExpandTextButtonClickListener
        implements OnMarketplaceEventListener
    {

        final MarketplaceController this$0;

        public void onExpandTextClick(boolean flag)
        {
            Logger logger1 = logger;
            String s;
            if (flag)
            {
                s = "marketplace_section_collapse";
            } else
            {
                s = "marketplace_section_expand";
            }
            logger1.logClick("goods_connected_marketplace", s, pageViewId, Logger.NULL_NST_FIELD);
        }

        private OnExpandTextButtonClickListener()
        {
            this$0 = MarketplaceController.this;
            super();
        }

    }


    private Deal deal;
    private boolean goodsConnectedMarketPlace1504Enabled;
    private Logger logger;
    private String pageViewId;

    public MarketplaceController(Context context)
    {
        super(context);
    }

    public OnMarketplaceEventListener getCallback()
    {
        return new OnExpandTextButtonClickListener();
    }

    public volatile Object getCallback()
    {
        return getCallback();
    }

    public void processData()
    {
        if (!goodsConnectedMarketPlace1504Enabled || !DealUtils.isConnectedMarketplaceDeal(deal))
        {
            setState(0);
            return;
        } else
        {
            model = new Marketplace();
            ((Marketplace)model).connectedMarketPlaceDisplayText = deal.connectedMarketPlaceDisplayText;
            setState(2);
            return;
        }
    }

    public void setDeal(Deal deal1)
    {
        setState(1);
        deal = deal1;
    }

    public void setGoodsConnectedMarketPlace1504Enabled(boolean flag)
    {
        setState(1);
        goodsConnectedMarketPlace1504Enabled = flag;
    }

    public void setPageViewId(String s)
    {
        setState(1);
        pageViewId = s;
    }


}
