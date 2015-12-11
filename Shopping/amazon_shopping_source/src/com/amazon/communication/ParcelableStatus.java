// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableStatus
    implements Parcelable
{
    static class Creator
        implements android.os.Parcelable.Creator
    {

        public ParcelableStatus createFromParcel(Parcel parcel)
        {
            return new ParcelableStatus(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ParcelableStatus[] newArray(int i)
        {
            return new ParcelableStatus[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        Creator()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    private int mStatusCode;
    private String mStatusMessage;

    public ParcelableStatus()
    {
    }

    public ParcelableStatus(Parcel parcel)
    {
        readFromParcel(parcel);
    }

    public int describeContents()
    {
        return 0;
    }

    public void readFromParcel(Parcel parcel)
    {
        mStatusCode = parcel.readInt();
        mStatusMessage = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(mStatusCode);
        parcel.writeString(mStatusMessage);
    }

}
