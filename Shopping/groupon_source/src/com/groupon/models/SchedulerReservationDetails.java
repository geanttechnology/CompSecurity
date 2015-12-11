// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.groupon.models.support.ParcelableCreator;
import java.util.Date;

public class SchedulerReservationDetails
    implements Parcelable
{

    public static android.os.Parcelable.Creator CREATOR = new ParcelableCreator(com/groupon/models/SchedulerReservationDetails);
    public Date endDateTime;
    public long expires_at;
    public String id;
    public int partySize;
    public String phone;
    public Date startDateTime;
    public String timezone;

    public SchedulerReservationDetails()
    {
    }

    public SchedulerReservationDetails(Parcel parcel)
    {
        id = parcel.readString();
        expires_at = parcel.readLong();
        partySize = parcel.readInt();
        phone = parcel.readString();
        startDateTime = new Date(parcel.readLong());
        endDateTime = new Date(parcel.readLong());
        timezone = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeLong(expires_at);
        parcel.writeInt(partySize);
        parcel.writeString(phone);
        parcel.writeLong(startDateTime.getTime());
        parcel.writeLong(endDateTime.getTime());
        parcel.writeString(timezone);
    }

}
