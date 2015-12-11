// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShippingOption

public static class costLineItems
{
    public static class Cost
    {

        public String currency;
        public double value;

        public Cost()
        {
        }
    }

    public static class CostLineItems
    {

        public Cost lineItemCost;
        public String lineItemName;

        public CostLineItems()
        {
        }
    }

    public static final class CostPlanTypes extends Enum
    {

        private static final CostPlanTypes $VALUES[];
        public static final CostPlanTypes DISCOUNTED;
        public static final CostPlanTypes RETAIL;

        public static CostPlanTypes valueOf(String s)
        {
            return (CostPlanTypes)Enum.valueOf(com/ebay/nautilus/domain/data/ShippingOption$ShippingCostPlan$CostPlanTypes, s);
        }

        public static CostPlanTypes[] values()
        {
            return (CostPlanTypes[])$VALUES.clone();
        }

        static 
        {
            RETAIL = new CostPlanTypes("RETAIL", 0);
            DISCOUNTED = new CostPlanTypes("DISCOUNTED", 1);
            $VALUES = (new CostPlanTypes[] {
                RETAIL, DISCOUNTED
            });
        }

        private CostPlanTypes(String s, int i)
        {
            super(s, i);
        }
    }


    public Cost cost;
    public ArrayList costLineItems;
    public String type;

    public CostLineItems getPostageCostLineItem()
    {
        for (Iterator iterator = costLineItems.iterator(); iterator.hasNext();)
        {
            CostLineItems costlineitems = (CostLineItems)iterator.next();
            if (costlineitems.lineItemName.equals("POSTAGE_COST"))
            {
                return costlineitems;
            }
        }

        return null;
    }

    public CostPlanTypes()
    {
        costLineItems = new ArrayList();
    }
}
