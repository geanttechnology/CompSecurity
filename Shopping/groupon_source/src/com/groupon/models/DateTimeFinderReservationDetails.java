// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeFinderReservationDetails
    implements Parcelable
{
    private static class DateTimeFinderReservationDetailsCreator
        implements android.os.Parcelable.Creator
    {

        public DateTimeFinderReservationDetails createFromParcel(Parcel parcel)
        {
            return new DateTimeFinderReservationDetails(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public DateTimeFinderReservationDetails[] newArray(int i)
        {
            return new DateTimeFinderReservationDetails[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        private DateTimeFinderReservationDetailsCreator()
        {
        }

    }


    public static final android.os.Parcelable.Creator CREATOR = new DateTimeFinderReservationDetailsCreator();
    public String optionId;
    public boolean partialIntent;
    public int partySize;
    public Date reservationDate;
    public com.groupon.db.models.Features.SearchIntentCategory searchIntentCategory;
    public String segmentId;
    public TimeZone timeZone;

    public DateTimeFinderReservationDetails()
    {
    }

    private DateTimeFinderReservationDetails(Parcel parcel)
    {
        optionId = parcel.readString();
        partySize = parcel.readInt();
        reservationDate = (Date)parcel.readSerializable();
        timeZone = (TimeZone)parcel.readSerializable();
        segmentId = parcel.readString();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        partialIntent = flag;
        searchIntentCategory = (com.groupon.db.models.Features.SearchIntentCategory)parcel.readSerializable();
    }


    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(optionId);
        parcel.writeInt(partySize);
        parcel.writeSerializable(reservationDate);
        parcel.writeSerializable(timeZone);
        parcel.writeString(segmentId);
        byte byte0;
        if (partialIntent)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeSerializable(searchIntentCategory);
    }

}
