// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.ArrayList;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShippingLabelOrder

public static class entry extends BaseDataMapped
{
    static class OrderLineItemProp extends BaseDataMapped
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

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


        OrderLineItemProp()
        {
        }
    }


    public ArrayList entry;
    public String itemRefId;
    public  itemWeight;
    public long quantity;
    public String title;
    public ost unitItemValue;

    public OrderLineItemProp()
    {
        entry = new ArrayList();
    }
}
