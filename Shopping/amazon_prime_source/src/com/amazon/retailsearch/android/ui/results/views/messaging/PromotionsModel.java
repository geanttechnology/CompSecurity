// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import com.amazon.searchapp.retailsearch.entity.PromotionEntity;
import com.amazon.searchapp.retailsearch.model.Promotion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PromotionsModel
{
    public static class Builder
    {

        private boolean hasAutoRip;
        private boolean hidePantryPromotion;
        private List promotions;

        public PromotionsModel build()
        {
            if (promotions != null && promotions.size() >= 0) goto _L2; else goto _L1
_L1:
            if (!hasAutoRip) goto _L4; else goto _L3
_L3:
            PromotionEntity promotionentity = new PromotionEntity();
            promotionentity.setType("AUTO_RIP");
            promotions = new ArrayList();
            promotions.add(promotionentity);
_L6:
            return (new PromotionsModel()).setPromotions(promotions).setHasAutoRip(hasAutoRip);
_L4:
            return null;
_L2:
            if (hidePantryPromotion)
            {
                ArrayList arraylist = new ArrayList(promotions.size());
                Iterator iterator = promotions.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Promotion promotion = (Promotion)iterator.next();
                    if (!promotion.getType().equalsIgnoreCase("PANTRY"))
                    {
                        arraylist.add(promotion);
                    }
                } while (true);
                setPromotions(arraylist);
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        public Builder setHasAutoRip(boolean flag)
        {
            hasAutoRip = flag;
            return this;
        }

        public Builder setHidePantryPromotion(boolean flag)
        {
            hidePantryPromotion = flag;
            return this;
        }

        public Builder setPromotions(List list)
        {
            promotions = list;
            return this;
        }

        public Builder()
        {
            hidePantryPromotion = false;
        }
    }


    private boolean hasAutoRip;
    private List promotions;

    public PromotionsModel()
    {
    }

    private PromotionsModel setHasAutoRip(boolean flag)
    {
        hasAutoRip = flag;
        return this;
    }

    private PromotionsModel setPromotions(List list)
    {
        promotions = list;
        return this;
    }

    public List getPromotions()
    {
        return promotions;
    }

    public boolean hasAutoRip()
    {
        return hasAutoRip;
    }


}
