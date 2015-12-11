// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.delivery;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.Date;

public class DeliverySchedulingParams extends BaseDataMapped
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public DeliverySchedulingParams createFromParcel(Parcel parcel)
        {
            return (DeliverySchedulingParams)DataMapperFactory.readParcelJson(parcel, com/ebay/mobile/checkout/delivery/DeliverySchedulingParams);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public DeliverySchedulingParams[] newArray(int i)
        {
            return new DeliverySchedulingParams[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String deliveryInstructions;
    public String phoneNumber;
    public String selectedLogisticsPlanOptionId;
    public String selectedLogisticsPlanOptionToken;
    public String selectedReservationToken;
    public Date selectedTimeSlotEnd;
    public Date selectedTimeSlotStart;
    public String sellerId;
    public String sellerName;
    public String storeId;
    public String zoneId;

    public DeliverySchedulingParams()
    {
    }

    public DeliverySchedulingParams(String s, String s1, String s2, String s3, String s4, String s5, Date date, 
            Date date1)
    {
        phoneNumber = s;
        sellerName = s1;
        sellerId = s2;
        storeId = s3;
        zoneId = s4;
        deliveryInstructions = s5;
        selectedTimeSlotStart = date;
        selectedTimeSlotEnd = date1;
    }

}
