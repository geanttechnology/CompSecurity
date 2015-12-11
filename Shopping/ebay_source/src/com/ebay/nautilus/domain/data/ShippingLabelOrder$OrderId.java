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

    public static final android.os.aseDataMapped CREATOR = new android.os.Parcelable.Creator() {

        public ShippingLabelOrder.OrderId createFromParcel(Parcel parcel)
        {
            return (ShippingLabelOrder.OrderId)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShippingLabelOrder$OrderId);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShippingLabelOrder.OrderId[] newArray(int i)
        {
            return new ShippingLabelOrder.OrderId[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String itemId;
    public String transactionId;


    _cls1()
    {
    }
}
