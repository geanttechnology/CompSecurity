// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShippingLabelOrder

static class _cls1 extends BaseDataMapped
{

    public static final android.os..OrderLineItemProp CREATOR = new android.os.Parcelable.Creator() {

        public ShippingLabelOrder.OrderLineItem createFromParcel(Parcel parcel)
        {
            return (ShippingLabelOrder.OrderLineItem)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShippingLabelOrder$OrderLineItem);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShippingLabelOrder.OrderLineItem[] newArray(int i)
        {
            return new ShippingLabelOrder.OrderLineItem[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String key;
    public String value;


    _cls1()
    {
    }
}
