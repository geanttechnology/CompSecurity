// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.smule.android.network.models:
//            AccountIcon

public class Track
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Track a(Parcel parcel)
        {
            return new Track(parcel);
        }

        public Track[] a(int i)
        {
            return new Track[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    public AccountIcon accountIcon;
    public long createdAt;

    public Track()
    {
    }

    public Track(Parcel parcel)
    {
        accountIcon = (AccountIcon)parcel.readParcelable(com/smule/android/network/models/AccountIcon.getClassLoader());
        createdAt = parcel.readLong();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(accountIcon, 0);
        parcel.writeLong(createdAt);
    }

}
