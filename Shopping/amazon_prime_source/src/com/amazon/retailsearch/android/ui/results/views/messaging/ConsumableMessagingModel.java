// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.Shipping;
import com.amazon.searchapp.retailsearch.model.ShippingStatus;
import java.util.List;

public class ConsumableMessagingModel
{
    public static class Builder
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
            consumablemessagingmodel1.setStyledBadgeMessage(shipping.getMessage());
            consumablemessagingmodel1.setBadgeMessage(badgeMessage);
            if (shipping.getPrime() == null)
            {
                break; /* Loop/switch isn't completed */
            }
            consumablemessagingmodel = consumablemessagingmodel1;
            if (shipping.getPrime().getHasBadge())
            {
                consumablemessagingmodel1.setBadgeId(shipping.getPrime().getBadgeAssetId());
                consumablemessagingmodel = consumablemessagingmodel1;
                if (shipping.getPrime().getBadgeLink() != null)
                {
                    consumablemessagingmodel1.setBadgeText(shipping.getPrime().getBadgeLink().getText());
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
                    consumablemessagingmodel1.setBadgeId(shipping.getBadgeAssetId());
                    consumablemessagingmodel = consumablemessagingmodel1;
                    if (shipping.getBadgeLink() != null)
                    {
                        consumablemessagingmodel1.setBadgeText(shipping.getBadgeLink().getText());
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
                    consumablemessagingmodel1.setBadgeId(shipping.getAddOn().getBadgeAssetId());
                    consumablemessagingmodel = consumablemessagingmodel1;
                    if (shipping.getAddOn().getBadgeLink() != null)
                    {
                        consumablemessagingmodel1.setBadgeText(shipping.getAddOn().getBadgeLink().getText());
                        return consumablemessagingmodel1;
                    }
                }
            }
            if (true) goto _L4; else goto _L6
_L6:
        }

        public Builder setBadgeMessage(String s)
        {
            badgeMessage = s;
            return this;
        }

        public Builder setStyledBadgeMessage(List list)
        {
            styledBadgeMessage = list;
            return this;
        }

        public Builder()
        {
        }
    }


    private String badgeId;
    private String badgeMessage;
    private String badgeText;
    private List styledBadgeMessage;

    public ConsumableMessagingModel()
    {
    }

    private void setBadgeId(String s)
    {
        badgeId = s;
    }

    private void setBadgeMessage(String s)
    {
        badgeMessage = s;
    }

    private void setBadgeText(String s)
    {
        badgeText = s;
    }

    private void setStyledBadgeMessage(List list)
    {
        styledBadgeMessage = list;
    }

    public String getBadgeId()
    {
        return badgeId;
    }

    public String getBadgeMessage()
    {
        return badgeMessage;
    }

    public String getBadgeText()
    {
        return badgeText;
    }

    public List getStyledBadgeMessage()
    {
        return styledBadgeMessage;
    }




}
