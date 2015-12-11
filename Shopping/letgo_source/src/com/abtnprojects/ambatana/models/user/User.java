// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.user;

import android.os.Parcel;
import android.os.Parcelable;

public class User
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public User createFromParcel(Parcel parcel)
        {
            return new User(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public User[] newArray(int i)
        {
            return new User[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private final String avatarUrl;
    private final String city;
    private final String countryCode;
    private final String id;
    private final boolean isRichy;
    private final String name;
    private final String zipCode;

    protected User(Parcel parcel)
    {
        boolean flag = true;
        super();
        id = parcel.readString();
        name = parcel.readString();
        avatarUrl = parcel.readString();
        if (parcel.readByte() != 1)
        {
            flag = false;
        }
        isRichy = flag;
        zipCode = parcel.readString();
        city = parcel.readString();
        countryCode = parcel.readString();
    }

    public User(String s, String s1, String s2, boolean flag, String s3, String s4, String s5)
    {
        id = s;
        name = s1;
        avatarUrl = s2;
        isRichy = flag;
        zipCode = s3;
        city = s4;
        countryCode = s5;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAvatarUrl()
    {
        return avatarUrl;
    }

    public String getCity()
    {
        return city;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public boolean isRichy()
    {
        return isRichy;
    }

    public String toString()
    {
        return (new StringBuilder()).append("User{id='").append(id).append('\'').append(", name='").append(name).append('\'').append(", avatarUrl='").append(avatarUrl).append('\'').append(", isRichy=").append(isRichy).append(", zipCode='").append(zipCode).append('\'').append(", city='").append(city).append('\'').append(", countryCode='").append(countryCode).append('\'').append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(avatarUrl);
        if (isRichy)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeString(zipCode);
        parcel.writeString(city);
        parcel.writeString(countryCode);
    }

}
