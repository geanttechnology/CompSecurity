// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.Date;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShippingTrackingEvent

public class ShippingPackageInfo extends BaseDataMapped
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ShippingPackageInfo createFromParcel(Parcel parcel)
        {
            return (ShippingPackageInfo)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShippingPackageInfo);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShippingPackageInfo[] newArray(int i)
        {
            return new ShippingPackageInfo[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public Date scheduledDeliveryTimeMax;
    public Date scheduledDeliveryTimeMin;
    public ShippingTrackingEvent shippingTrackingEvent;
    public String storeId;

    public ShippingPackageInfo()
    {
        shippingTrackingEvent = ShippingTrackingEvent.NOT_SET;
    }

}
