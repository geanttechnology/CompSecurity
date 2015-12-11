// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.inventory;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.common.model.ParcelableHelper;
import com.ebay.nautilus.domain.data.Address;

// Referenced classes of package com.ebay.common.model.inventory:
//            LocationAddress, LocationDetails

public final class StoreAvailability extends ParcelableHelper
    implements Parcelable
{
    public static final class AvailabilityType extends Enum
        implements Parcelable
    {

        private static final AvailabilityType $VALUES[];
        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public AvailabilityType createFromParcel(Parcel parcel)
            {
                return AvailabilityType.valueOf(parcel.readString());
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public AvailabilityType[] newArray(int i)
            {
                return new AvailabilityType[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public static final AvailabilityType IN_STOCK;
        public static final AvailabilityType OUT_OF_STOCK;
        public static final AvailabilityType SHIP_TO_STORE;

        public static AvailabilityType valueOf(String s)
        {
            return (AvailabilityType)Enum.valueOf(com/ebay/common/model/inventory/StoreAvailability$AvailabilityType, s);
        }

        public static AvailabilityType[] values()
        {
            return (AvailabilityType[])$VALUES.clone();
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(toString());
        }

        static 
        {
            IN_STOCK = new AvailabilityType("IN_STOCK", 0);
            OUT_OF_STOCK = new AvailabilityType("OUT_OF_STOCK", 1);
            SHIP_TO_STORE = new AvailabilityType("SHIP_TO_STORE", 2);
            $VALUES = (new AvailabilityType[] {
                IN_STOCK, OUT_OF_STOCK, SHIP_TO_STORE
            });
        }

        private AvailabilityType(String s, int i)
        {
            super(s, i);
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public StoreAvailability createFromParcel(Parcel parcel)
        {
            return new StoreAvailability(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public StoreAvailability[] newArray(int i)
        {
            return new StoreAvailability[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public LocationAddress address;
    public AvailabilityType availability;
    public double distance;
    public Long fulfillmentTime;
    public LocationDetails.Hours hours;
    public String locationId;
    public String name;
    public String phone;
    public String pickupInstructions;
    public Integer quantity;
    public String url;
    public LocationDetails.Hours utcHours;
    public String utcOffset;

    public StoreAvailability()
    {
    }

    public StoreAvailability(Parcel parcel)
    {
        distance = parcel.readDouble();
        availability = (AvailabilityType)parcel.readParcelable(com/ebay/common/model/inventory/StoreAvailability$AvailabilityType.getClassLoader());
        locationId = parcel.readString();
        name = parcel.readString();
        address = (LocationAddress)LocationAddress.CREATOR.createFromParcel(parcel);
        phone = readOptString(parcel);
        pickupInstructions = readOptString(parcel);
        fulfillmentTime = readOptLong(parcel);
        url = readOptString(parcel);
        quantity = readOptInt(parcel);
        utcOffset = parcel.readString();
        hours = (LocationDetails.Hours)readOptParcelable(parcel);
        utcHours = (LocationDetails.Hours)readOptParcelable(parcel);
    }

    public StoreAvailability(LocationDetails locationdetails)
    {
        if (locationdetails != null)
        {
            distance = 0.0D;
            availability = AvailabilityType.IN_STOCK;
            locationId = locationdetails.id;
            name = locationdetails.name;
            address = locationdetails.address;
            phone = locationdetails.phone;
            pickupInstructions = locationdetails.pickupInstructions;
            url = locationdetails.url;
            utcOffset = locationdetails.utcOffset;
            hours = locationdetails.hours;
            utcHours = locationdetails.utcHours;
        }
    }

    public StoreAvailability(String s, Address address1)
    {
        locationId = s;
        address = new LocationAddress(address1);
        availability = AvailabilityType.IN_STOCK;
        name = address1.addressFields.getName();
        phone = address1.addressFields.getPhone();
        url = address1.getUrl();
        pickupInstructions = address1.getPickupInstructions();
        distance = 0.0D;
        utcOffset = null;
        utcHours = null;
        hours = null;
        fulfillmentTime = Long.valueOf(0L);
        quantity = Integer.valueOf(0);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof StoreAvailability)
        {
            flag = flag1;
            if (locationId.equals(((StoreAvailability)obj).locationId))
            {
                flag = true;
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return locationId.hashCode() + 527;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeDouble(distance);
        parcel.writeParcelable(availability, 0);
        parcel.writeString(locationId);
        parcel.writeString(name);
        address.writeToParcel(parcel, i);
        writeOptString(parcel, phone);
        writeOptString(parcel, pickupInstructions);
        writeOptLong(parcel, fulfillmentTime);
        writeOptString(parcel, url);
        writeOptInt(parcel, quantity);
        parcel.writeString(utcOffset);
        writeOptParcelable(parcel, hours, i);
        writeOptParcelable(parcel, utcHours, i);
    }

}
