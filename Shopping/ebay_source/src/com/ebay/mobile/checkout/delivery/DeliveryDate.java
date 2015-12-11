// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.delivery;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.Date;
import java.util.List;

class DeliveryDate extends BaseDataMapped
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public DeliveryDate createFromParcel(Parcel parcel)
        {
            return (DeliveryDate)DataMapperFactory.readParcelJson(parcel, com/ebay/mobile/checkout/delivery/DeliveryDate);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public DeliveryDate[] newArray(int i)
        {
            return new DeliveryDate[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final Date date;
    public final List timeSlots;

    public DeliveryDate(Date date1, List list)
    {
        date = date1;
        timeSlots = list;
    }

}
