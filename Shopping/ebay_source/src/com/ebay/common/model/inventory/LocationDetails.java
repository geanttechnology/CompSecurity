// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.inventory;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.common.model.ParcelableHelper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.common.model.inventory:
//            LocationAddress

public class LocationDetails extends ParcelableHelper
    implements Parcelable
{
    public static class Day extends ParcelableHelper
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Day createFromParcel(Parcel parcel)
            {
                return new Day(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public Day[] newArray(int i)
            {
                return new Day[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public Date date;
        public int dayOfWeek;
        public List intervals;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            writeOptDate(parcel, date);
            parcel.writeInt(dayOfWeek);
            parcel.writeTypedList(intervals);
        }


        public Day()
        {
            intervals = new ArrayList();
        }

        public Day(Parcel parcel)
        {
            this();
            date = readOptDate(parcel);
            dayOfWeek = parcel.readInt();
            parcel.readTypedList(intervals, Interval.CREATOR);
        }
    }

    public static class Hours extends ParcelableHelper
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Hours createFromParcel(Parcel parcel)
            {
                return new Hours(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public Hours[] newArray(int i)
            {
                return new Hours[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public List days;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeTypedList(days);
        }


        public Hours()
        {
            days = new ArrayList();
        }

        public Hours(Parcel parcel)
        {
            this();
            parcel.readTypedList(days, Day.CREATOR);
        }
    }

    public static class Interval
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Interval createFromParcel(Parcel parcel)
            {
                return new Interval(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public Interval[] newArray(int i)
            {
                return new Interval[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public String close;
        public String open;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(open);
            parcel.writeString(close);
        }


        public Interval()
        {
        }

        public Interval(Parcel parcel)
        {
            open = parcel.readString();
            close = parcel.readString();
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public LocationDetails createFromParcel(Parcel parcel)
        {
            return new LocationDetails(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public LocationDetails[] newArray(int i)
        {
            return new LocationDetails[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public LocationAddress address;
    public Hours hours;
    public String id;
    public String name;
    public String phone;
    public String pickupInstructions;
    public String url;
    public Hours utcHours;
    public String utcOffset;

    public LocationDetails()
    {
    }

    LocationDetails(Parcel parcel)
    {
        id = parcel.readString();
        name = parcel.readString();
        address = (LocationAddress)LocationAddress.CREATOR.createFromParcel(parcel);
        pickupInstructions = readOptString(parcel);
        hours = (Hours)readOptParcelable(parcel);
        utcHours = (Hours)readOptParcelable(parcel);
        phone = readOptString(parcel);
        url = readOptString(parcel);
        utcOffset = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeString(name);
        address.writeToParcel(parcel, i);
        writeOptString(parcel, pickupInstructions);
        writeOptParcelable(parcel, hours, i);
        writeOptParcelable(parcel, utcHours, i);
        writeOptString(parcel, phone);
        writeOptString(parcel, url);
        parcel.writeString(utcOffset);
    }

}
