// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.deals;

import com.ebay.nautilus.domain.data.cos.base.DateTime;
import com.ebay.nautilus.domain.data.experience.type.base.TextualDisplay;
import com.ebay.nautilus.domain.data.experience.type.base.TextualDisplayValue;

public class DealsListingSummary
{
    public static class CountdownTimer
    {

        public TextualDisplay displayText;
        public TextualDisplay expired;
        public String pattern;
        public DateTime value;

        public CountdownTimer()
        {
        }
    }

    public static final class DeliveryOption extends Enum
    {

        private static final DeliveryOption $VALUES[];
        public static final DeliveryOption EBAY_NOW;
        public static final DeliveryOption FREE_SHIPPING;
        public static final DeliveryOption PICKUP_IN_STORE;
        public static final DeliveryOption UNKNOWN;

        public static DeliveryOption valueOf(String s)
        {
            return (DeliveryOption)Enum.valueOf(com/ebay/nautilus/domain/data/experience/deals/DealsListingSummary$DeliveryOption, s);
        }

        public static DeliveryOption[] values()
        {
            return (DeliveryOption[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new DeliveryOption("UNKNOWN", 0);
            PICKUP_IN_STORE = new DeliveryOption("PICKUP_IN_STORE", 1);
            EBAY_NOW = new DeliveryOption("EBAY_NOW", 2);
            FREE_SHIPPING = new DeliveryOption("FREE_SHIPPING", 3);
            $VALUES = (new DeliveryOption[] {
                UNKNOWN, PICKUP_IN_STORE, EBAY_NOW, FREE_SHIPPING
            });
        }

        private DeliveryOption(String s, int i)
        {
            super(s, i);
        }
    }


    public CountdownTimer dealTimeRemaining;
    public TextualDisplayValue delivery;
    public TextualDisplayValue priceLegalText;

    public DealsListingSummary()
    {
    }
}
