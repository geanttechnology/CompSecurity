// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class GoogleWalletMetaData
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    String displayName;
    String lastFour;

    private GoogleWalletMetaData()
    {
    }

    GoogleWalletMetaData(_cls1 _pcls1)
    {
        this();
    }

    public GoogleWalletMetaData(String s, String s1)
    {
        displayName = s;
        lastFour = s1;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getLastFour()
    {
        return lastFour;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(displayName);
        parcel.writeString(lastFour);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final GoogleWalletMetaData createFromParcel(Parcel parcel)
        {
            GoogleWalletMetaData googlewalletmetadata = new GoogleWalletMetaData(null);
            googlewalletmetadata.displayName = parcel.readString();
            googlewalletmetadata.lastFour = parcel.readString();
            return googlewalletmetadata;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final GoogleWalletMetaData[] newArray(int i)
        {
            return new GoogleWalletMetaData[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls1()
        {
        }
    }

}
