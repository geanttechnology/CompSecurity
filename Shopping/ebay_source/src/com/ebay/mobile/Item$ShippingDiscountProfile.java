// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import android.os.Parcel;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.ItemWeight;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.mobile:
//            Item

public static class _cls1 extends BaseDataMapped
{

    public static final android.os.eDataMapped CREATOR = new android.os.Parcelable.Creator() {

        public Item.ShippingDiscountProfile createFromParcel(Parcel parcel)
        {
            return (Item.ShippingDiscountProfile)DataMapperFactory.readParcelJson(parcel, com/ebay/mobile/Item$ShippingDiscountProfile);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Item.ShippingDiscountProfile[] newArray(int i)
        {
            return new Item.ShippingDiscountProfile[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public ItemCurrency eachAdditionalAmount;
    public ItemCurrency eachAdditionalAmountOff;
    public Float eachAdditionalPercentOff;
    public String id;
    public String mappedId;
    public String name;
    public ItemWeight weightOff;


    public _cls1()
    {
    }
}
