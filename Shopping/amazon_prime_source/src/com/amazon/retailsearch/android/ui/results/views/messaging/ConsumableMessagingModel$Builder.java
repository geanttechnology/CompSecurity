// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.Shipping;
import com.amazon.searchapp.retailsearch.model.ShippingStatus;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            ConsumableMessagingModel

public static class a
{

    private String badgeMessage;
    private List styledBadgeMessage;

    public ConsumableMessagingModel build(Shipping shipping)
    {
        if (shipping != null && (shipping.getPrime() != null || shipping.getAddOn() != null || !Utils.isEmpty(shipping.getAdditionalStatus()))) goto _L2; else goto _L1
_L1:
        ConsumableMessagingModel consumablemessagingmodel = null;
_L4:
        return consumablemessagingmodel;
_L2:
        ConsumableMessagingModel consumablemessagingmodel1;
        consumablemessagingmodel1 = new ConsumableMessagingModel();
        ConsumableMessagingModel.access$000(consumablemessagingmodel1, shipping.getMessage());
        ConsumableMessagingModel.access$100(consumablemessagingmodel1, badgeMessage);
        if (shipping.getPrime() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        consumablemessagingmodel = consumablemessagingmodel1;
        if (shipping.getPrime().getHasBadge())
        {
            ConsumableMessagingModel.access$200(consumablemessagingmodel1, shipping.getPrime().getBadgeAssetId());
            consumablemessagingmodel = consumablemessagingmodel1;
            if (shipping.getPrime().getBadgeLink() != null)
            {
                ConsumableMessagingModel.access$300(consumablemessagingmodel1, shipping.getPrime().getBadgeLink().getText());
                return consumablemessagingmodel1;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (Utils.isEmpty(shipping.getAdditionalStatus()))
        {
            break; /* Loop/switch isn't completed */
        }
        shipping = (ShippingStatus)shipping.getAdditionalStatus().get(0);
        consumablemessagingmodel = consumablemessagingmodel1;
        if (shipping != null)
        {
            consumablemessagingmodel = consumablemessagingmodel1;
            if (shipping.getHasBadge())
            {
                ConsumableMessagingModel.access$200(consumablemessagingmodel1, shipping.getBadgeAssetId());
                consumablemessagingmodel = consumablemessagingmodel1;
                if (shipping.getBadgeLink() != null)
                {
                    ConsumableMessagingModel.access$300(consumablemessagingmodel1, shipping.getBadgeLink().getText());
                    return consumablemessagingmodel1;
                }
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
        consumablemessagingmodel = consumablemessagingmodel1;
        if (shipping.getAddOn() != null)
        {
            consumablemessagingmodel = consumablemessagingmodel1;
            if (shipping.getAddOn().getHasBadge())
            {
                ConsumableMessagingModel.access$200(consumablemessagingmodel1, shipping.getAddOn().getBadgeAssetId());
                consumablemessagingmodel = consumablemessagingmodel1;
                if (shipping.getAddOn().getBadgeLink() != null)
                {
                    ConsumableMessagingModel.access$300(consumablemessagingmodel1, shipping.getAddOn().getBadgeLink().getText());
                    return consumablemessagingmodel1;
                }
            }
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    public _cls00 setBadgeMessage(String s)
    {
        badgeMessage = s;
        return this;
    }

    public badgeMessage setStyledBadgeMessage(List list)
    {
        styledBadgeMessage = list;
        return this;
    }

    public a()
    {
    }
}
