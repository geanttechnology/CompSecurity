// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

public class ShipmentTrackingScanDetail
    implements Parcelable, Comparable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ShipmentTrackingScanDetail createFromParcel(Parcel parcel)
        {
            return new ShipmentTrackingScanDetail(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShipmentTrackingScanDetail[] newArray(int i)
        {
            return new ShipmentTrackingScanDetail[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String eventCity;
    public String eventCode;
    public String eventDesc;
    public String eventPostalCode;
    public String eventStateOrProvince;
    public String eventStatus;
    public Date eventTime;

    public ShipmentTrackingScanDetail()
    {
    }

    private ShipmentTrackingScanDetail(Parcel parcel)
    {
        eventStatus = parcel.readString();
        eventDesc = parcel.readString();
        Date date;
        if (1 == parcel.readInt())
        {
            date = new Date(parcel.readLong());
        } else
        {
            date = null;
        }
        eventTime = date;
        eventCity = parcel.readString();
        eventStateOrProvince = parcel.readString();
        eventPostalCode = parcel.readString();
        eventCode = parcel.readString();
    }


    public int compareTo(ShipmentTrackingScanDetail shipmenttrackingscandetail)
    {
        boolean flag = false;
        int i = ((flag) ? 1 : 0);
        if (shipmenttrackingscandetail != null)
        {
            i = ((flag) ? 1 : 0);
            if (shipmenttrackingscandetail.eventTime != null)
            {
                i = ((flag) ? 1 : 0);
                if (eventTime != null)
                {
                    i = eventTime.compareTo(shipmenttrackingscandetail.eventTime);
                }
            }
        }
        return i;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((ShipmentTrackingScanDetail)obj);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(eventStatus);
        parcel.writeString(eventDesc);
        if (eventTime != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (eventTime != null)
        {
            parcel.writeLong(eventTime.getTime());
        }
        parcel.writeString(eventCity);
        parcel.writeString(eventStateOrProvince);
        parcel.writeString(eventPostalCode);
        parcel.writeString(eventCode);
    }

}
