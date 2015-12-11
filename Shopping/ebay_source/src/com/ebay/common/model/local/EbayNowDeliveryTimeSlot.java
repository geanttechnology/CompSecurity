// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.local;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.Date;

public class EbayNowDeliveryTimeSlot extends BaseDataMapped
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public EbayNowDeliveryTimeSlot createFromParcel(Parcel parcel)
        {
            return (EbayNowDeliveryTimeSlot)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/local/EbayNowDeliveryTimeSlot);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public EbayNowDeliveryTimeSlot[] newArray(int i)
        {
            return new EbayNowDeliveryTimeSlot[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public Date end;
    public String reservationToken;
    public String serviceType;
    public Date start;
    public Date validUntil;

    public EbayNowDeliveryTimeSlot()
    {
    }

    public String toString()
    {
        return (new StringBuilder()).append("EbayNowDeliveryTimeSlot [reservationToken=").append(reservationToken).append(", serviceType=").append(serviceType).append(", start=").append(start).append(", end=").append(end).append(", validUntil=").append(validUntil).append("]").toString();
    }

}
