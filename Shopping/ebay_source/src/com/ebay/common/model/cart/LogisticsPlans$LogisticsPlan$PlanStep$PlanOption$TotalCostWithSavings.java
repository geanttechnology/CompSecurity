// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import com.ebay.nautilus.domain.data.CurrencyAmount;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.common.model.cart:
//            LogisticsPlans

public static class ChargeInfoAttribute
    implements Serializable
{
    public static final class AddtionalCharges
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public ArrayList additionalCharge;

        public AddtionalCharges()
        {
        }
    }

    public static final class Adjustment
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public AddtionalCharges additionalCharges;

        public Adjustment()
        {
        }
    }

    public static final class ChargeInfo
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public ArrayList attribute;
        public CurrencyAmount cost;
        public String type;

        public ChargeInfo()
        {
        }
    }

    public static final class ChargeInfoAttribute
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        public String currencyId;
        public String currencyValue;
        public String format;
        public String name;

        public CurrencyAmount getAmount()
        {
            return new CurrencyAmount(currencyValue, currencyId);
        }

        public ChargeInfoAttribute()
        {
        }
    }


    private static final long serialVersionUID = 1L;
    public Adjustment adjustment;
    public CurrencyAmount baseCost;
    public CurrencyAmount subTotal;
    public CurrencyAmount totalCost;

    private CurrencyAmount getAmountForChargeByNameAndAttribute(String s, String s1)
    {
label0:
        {
            ChargeInfo chargeinfo;
label1:
            {
                if (adjustment == null || adjustment.additionalCharges == null || adjustment.additionalCharges.additionalCharge == null)
                {
                    break label0;
                }
                Object obj = adjustment.additionalCharges.additionalCharge.iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break label0;
                    }
                    chargeinfo = (ChargeInfo)((Iterator) (obj)).next();
                } while (chargeinfo == null || !s.equals(chargeinfo.type));
                if (s1 == null || chargeinfo.attribute == null)
                {
                    break label1;
                }
                s = chargeinfo.attribute.iterator();
                do
                {
                    if (!s.hasNext())
                    {
                        break label1;
                    }
                    obj = (ChargeInfoAttribute)s.next();
                } while (obj == null || !s1.equals(((ChargeInfoAttribute) (obj)).name));
                return ((ChargeInfoAttribute) (obj)).getAmount();
            }
            return chargeinfo.cost;
        }
        return null;
    }

    public CurrencyAmount getConvienceCharge()
    {
        return getAmountForChargeByNameAndAttribute("ConvenienceCharge", null);
    }

    public CurrencyAmount getImportCharge()
    {
        return getAmountForChargeByNameAndAttribute("ImportCharge", null);
    }

    public CurrencyAmount getMinimumOrderAmount()
    {
        return getAmountForChargeByNameAndAttribute("ConvenienceCharge", "MinimumOrderAmountToWaiveCharge");
    }

    public ChargeInfoAttribute()
    {
    }
}
