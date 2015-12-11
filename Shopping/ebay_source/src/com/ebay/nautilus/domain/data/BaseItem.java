// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.Date;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ItemCurrency

public class BaseItem extends BaseDataMapped
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public BaseItem createFromParcel(Parcel parcel)
        {
            return (BaseItem)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/BaseItem);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public BaseItem[] newArray(int i)
        {
            return new BaseItem[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("BaseItem", 3, "BaseItem");
    public ItemCurrency bestOfferAmount;
    public boolean bestOfferEnabled;
    public String bestOfferStatus;
    public int bidCount;
    public boolean buyItNowAvailable;
    public ItemCurrency buyItNowPrice;
    public ItemCurrency convertedBuyItNowPrice;
    public ItemCurrency convertedCurrentPrice;
    public ItemCurrency currentPrice;
    public Date endDate;
    public boolean fromSaaS;
    public long id;
    public String imageUrl;
    public boolean inStorePickup;
    public Long orderId;
    public ItemCurrency originalRetailPrice;
    public String pricingTreatment;
    public ItemCurrency shippingCost;
    public BaseCommonType.Text title;
    public Long transactionId;
    public String unitPriceQuantity;
    public String unitPriceType;

    public BaseItem()
    {
    }

}
