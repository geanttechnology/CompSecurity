// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.mobile:
//            Item

public class CheckoutItem extends BaseDataMapped
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CheckoutItem createFromParcel(Parcel parcel)
        {
            return (CheckoutItem)DataMapperFactory.readParcelJson(parcel, com/ebay/mobile/CheckoutItem);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public CheckoutItem[] newArray(int i)
        {
            return new CheckoutItem[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final Date addedToCartAt;
    public final boolean autoPay;
    public final boolean buyItNowAvailable;
    public final ItemCurrency currentPrice;
    public final boolean ebayPaymentProcessEnabled;
    public final Date endDate;
    public final boolean hasReservePrice;
    public final long id;
    public final boolean isTransacted;
    public final String location;
    public final long primaryCategoryId;
    public int quantity;
    public final boolean reserveMet;
    public final long secondaryCategoryId;
    public final long sellerFeedbackScore;
    public final String sellerUserId;
    public final long shopCartLineItemId;
    public final String site;
    public final List variationOptions;
    public boolean watched;

    public CheckoutItem()
    {
        id = 0L;
        primaryCategoryId = 0L;
        secondaryCategoryId = 0L;
        quantity = 0;
        site = null;
        location = null;
        sellerUserId = null;
        endDate = null;
        currentPrice = null;
        watched = false;
        autoPay = false;
        reserveMet = false;
        hasReservePrice = false;
        buyItNowAvailable = false;
        ebayPaymentProcessEnabled = false;
        isTransacted = false;
        addedToCartAt = null;
        shopCartLineItemId = 0L;
        sellerFeedbackScore = 0L;
        variationOptions = null;
    }

    public CheckoutItem(Item item)
    {
        id = item.id;
        primaryCategoryId = item.primaryCategoryId;
        secondaryCategoryId = item.secondaryCategoryId;
        quantity = item.quantity;
        site = item.site;
        location = item.location;
        sellerUserId = item.sellerUserId;
        endDate = item.endDate;
        currentPrice = item.currentPrice;
        watched = item.watched;
        autoPay = item.autoPay;
        reserveMet = item.isReserveMet;
        hasReservePrice = item.hasReservePrice;
        buyItNowAvailable = item.buyItNowAvailable;
        ebayPaymentProcessEnabled = item.ebayPaymentProcessEnabled;
        addedToCartAt = new Date();
        shopCartLineItemId = 0L;
        sellerFeedbackScore = item.sellerFeedbackScore;
        isTransacted = item.isTransacted;
        variationOptions = item.variationSpecifics;
    }

    public CheckoutItem(com.ebay.nautilus.domain.data.ShoppingCart.Item item)
    {
        id = item.ebayItemId.longValue();
        quantity = item.requestedQuantity;
        sellerUserId = item.sellerUserId;
        endDate = item.itemEndTime;
        currentPrice = item.itemPrice.sitePrice.toItemCurrency();
        watched = false;
        autoPay = item.requiresImmediatePayment;
        reserveMet = item.isReserveMet;
        hasReservePrice = item.hasReservePrice;
        buyItNowAvailable = item.isBuyItNowAvailable;
        primaryCategoryId = item.primaryCategoryId.longValue();
        secondaryCategoryId = item.secondaryCategoryId.longValue();
        site = item.site.idString;
        location = item.location;
        ebayPaymentProcessEnabled = item.isEbayPaymentProcessEnabled;
        isTransacted = item.isTransacted;
        variationOptions = item.variationSpecifics;
        addedToCartAt = item.addedToCartAt;
        shopCartLineItemId = item.lineItemId.longValue();
        sellerFeedbackScore = item.sellerFeedbackScore.longValue();
    }

}
