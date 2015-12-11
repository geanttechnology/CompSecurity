// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShoppingCart, CurrencyAmount

public static class seedCategoryId extends BaseDataMapped
    implements Parcelable, Comparable
{
    public static final class OfferType extends Enum
    {

        private static final OfferType $VALUES[];
        public static final OfferType BundleOffer;
        public static final OfferType MarkDownSale;
        public static final OfferType None;
        public static final OfferType OrderSubTotalOffer;
        public static final OfferType PromotionalShipping;
        public static final OfferType RebateOffer;
        public static final OfferType SaleAndClearence;
        public static final OfferType SaleEvent;
        public static final OfferType TargetedOffer;
        public static final OfferType VerticalOffer;

        public static OfferType from(String s)
        {
            try
            {
                s = valueOf(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return None;
            }
            return s;
        }

        public static OfferType valueOf(String s)
        {
            return (OfferType)Enum.valueOf(com/ebay/nautilus/domain/data/ShoppingCart$Promotion$OfferType, s);
        }

        public static OfferType[] values()
        {
            return (OfferType[])$VALUES.clone();
        }

        static 
        {
            None = new OfferType("None", 0);
            BundleOffer = new OfferType("BundleOffer", 1);
            OrderSubTotalOffer = new OfferType("OrderSubTotalOffer", 2);
            SaleEvent = new OfferType("SaleEvent", 3);
            PromotionalShipping = new OfferType("PromotionalShipping", 4);
            SaleAndClearence = new OfferType("SaleAndClearence", 5);
            VerticalOffer = new OfferType("VerticalOffer", 6);
            RebateOffer = new OfferType("RebateOffer", 7);
            MarkDownSale = new OfferType("MarkDownSale", 8);
            TargetedOffer = new OfferType("TargetedOffer", 9);
            $VALUES = (new OfferType[] {
                None, BundleOffer, OrderSubTotalOffer, SaleEvent, PromotionalShipping, SaleAndClearence, VerticalOffer, RebateOffer, MarkDownSale, TargetedOffer
            });
        }

        private OfferType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class PromotionType extends Enum
    {

        private static final PromotionType $VALUES[];
        public static final PromotionType BillMeLaterPromotionalOffer;
        public static final PromotionType None;
        public static final PromotionType SME;
        public static final PromotionType SellerDiscountedPromotionalOffer;
        public static final PromotionType ShippingPromotionalOffer;
        public final boolean isSellerPromotion;

        public static PromotionType from(String s)
        {
            if (TextUtils.isEmpty(s))
            {
                return None;
            }
            try
            {
                s = valueOf(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return None;
            }
            return s;
        }

        public static PromotionType valueOf(String s)
        {
            return (PromotionType)Enum.valueOf(com/ebay/nautilus/domain/data/ShoppingCart$Promotion$PromotionType, s);
        }

        public static PromotionType[] values()
        {
            return (PromotionType[])$VALUES.clone();
        }

        static 
        {
            Non