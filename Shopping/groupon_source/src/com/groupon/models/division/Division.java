// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.division;

import android.os.Parcel;
import android.os.Parcelable;
import com.groupon.models.support.ParcelableCreator;
import com.groupon.util.GeoPoint;

public class Division
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new ParcelableCreator(com/groupon/models/division/Division);
    public GeoPoint geoPoint;
    public String id;
    public boolean isReserveEnabled;
    public long latE6;
    public long lngE6;
    public String name;
    public Division parent;
    public String timezone;
    public String timezoneIdentifier;
    public int timezoneOffsetInSeconds;

    public Division()
    {
        id = "";
        name = "";
        timezoneIdentifier = "";
        timezone = "";
    }

    public Division(Parcel parcel)
    {
        id = "";
        name = "";
        timezoneIdentifier = "";
        timezone = "";
        id = parcel.readString();
        name = parcel.readString();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isReserveEnabled = flag;
        timezoneIdentifier = parcel.readString();
        timezone = parcel.readString();
        timezoneOffsetInSeconds = parcel.readInt();
        parent = (Division)parcel.readParcelable(com/groupon/models/division/Division.getClassLoader());
        latE6 = parcel.readLong();
        lngE6 = parcel.readLong();
        geoPoint = new GeoPoint((int)latE6, (int)lngE6);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (this == obj)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj instanceof Division)
            {
                obj = (Division)obj;
                flag = flag1;
                if (id.equals(((Division) (obj)).id))
                {
                    return name.equals(((Division) (obj)).name);
                }
            }
        }
        return flag;
    }

    public String getIdOrParentId()
    {
        if (!hasParent())
        {
            return id;
        } else
        {
            return parent.id;
        }
    }

    public String getParentId()
    {
        if (!hasParent())
        {
            return null;
        } else
        {
            return parent.id;
        }
    }

    public boolean hasParent()
    {
        return parent != null;
    }

    public int hashCode()
    {
        return id.hashCode() * 31 + name.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeString(name);
        byte byte0;
        if (isReserveEnabled)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeString(timezoneIdentifier);
        parcel.writeString(timezone);
        parcel.writeInt(timezoneOffsetInSeconds);
        parcel.writeParcelable(parent, i);
        parcel.writeDouble(latE6);
        parcel.writeDouble(lngE6);
    }

}
