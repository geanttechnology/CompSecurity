// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.sso;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class ReturnValueOrError
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ReturnValueOrError createFromParcel(Parcel parcel)
        {
            return new ReturnValueOrError(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ReturnValueOrError[] newArray(int i)
        {
            return new ReturnValueOrError[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final int RESPONSE_CODE_SUCCESS = 1;
    private final Bundle mResponse;
    private final int mResponseCode;
    private final String mResponseMessage;

    public ReturnValueOrError(int i, String s)
    {
        mResponse = null;
        mResponseCode = i;
        mResponseMessage = s;
    }

    public ReturnValueOrError(Bundle bundle)
    {
        mResponse = bundle;
        mResponseCode = 1;
        mResponseMessage = null;
    }

    private ReturnValueOrError(Parcel parcel)
    {
        mResponse = parcel.readBundle();
        mResponseCode = parcel.readInt();
        mResponseMessage = parcel.readString();
    }


    public int describeContents()
    {
        return 0;
    }

    public Bundle getResponse()
    {
        return mResponse;
    }

    public int getResponseCode()
    {
        return mResponseCode;
    }

    public String getResponseMessage()
    {
        return mResponseMessage;
    }

    public boolean isError()
    {
        return mResponseCode != 1;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeBundle(mResponse);
        parcel.writeInt(mResponseCode);
        parcel.writeString(mResponseMessage);
    }

}
