// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.ArrayList;

public class ShippingLabelOrder extends BaseDataMapped
{
    static class OrderId extends BaseDataMapped
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public OrderId createFromParcel(Parcel parcel)
            {
                return (OrderId)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShippingLabelOrder$OrderId);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public OrderId[] newArray(int i)
            {
                return new OrderId[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public String itemId;
        public String transactionId;


        OrderId()
        {
        }
    }

    public static class OrderLineItem extends BaseDataMapped
    {

        public ArrayList entry;
        public String itemRefId;
        public ShippingLabelPackage.Specs.Weight itemWeight;
        public long quantity;
        public String title;
        public ShippingOption.ShippingCostPlan.Cost unitItemValue;

        public OrderLineItem()
        {
            entry = new ArrayList();
        }
    }

    static class OrderLineItem.OrderLineItemProp extends BaseDataMapped
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public OrderLineItem createFromParcel(Parcel parcel)
            {
                return (OrderLineItem)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShippingLabelOrder$OrderLineItem);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public OrderLineItem[] newArray(int i)
            {
                return new OrderLineItem[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public String key;
        public String value;


        OrderLineItem.OrderLineItemProp()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ShippingLabelOrder createFromParcel(Parcel parcel)
        {
            return (ShippingLabelOrder)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShippingLabelOrder);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShippingLabelOrder[] newArray(int i)
        {
            return new ShippingLabelOrder[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public ShippingOption.ShippingCostPlan.Cost buyerPaidShippingCost;
    public ArrayList lineItems;
    public OrderId orderId;
    public ShippingOption.ShippingCostPlan.Cost orderTotalCost;
    public String planCode;
    public String thumbUrl;

    public ShippingLabelOrder()
    {
        lineItems = new ArrayList();
    }

}
