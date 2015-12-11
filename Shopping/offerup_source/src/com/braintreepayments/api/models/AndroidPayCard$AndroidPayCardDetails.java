// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

class <init>
    implements Parcelable, Serializable
{

    public static final android.os.AndroidPayCardDetails._cls1 CREATOR = new _cls1();
    private String mCardType;
    private String mLastTwo;

    public int describeContents()
    {
        return 0;
    }

    protected String getCardType()
    {
        return mCardType;
    }

    protected String getLastTwo()
    {
        return mLastTwo;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mCardType);
        parcel.writeString(mLastTwo);
    }


    public _cls1()
    {
    }

    private _cls1(Parcel parcel)
    {
        mCardType = parcel.readString();
        mLastTwo = parcel.readString();
    }

    mLastTwo(Parcel parcel, mLastTwo mlasttwo)
    {
        this(parcel);
    }

    class _cls1
        implements android.os.Parcelable.Creator
    {

        public final AndroidPayCard.AndroidPayCardDetails createFromParcel(Parcel parcel)
        {
            return new AndroidPayCard.AndroidPayCardDetails(parcel, null);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final AndroidPayCard.AndroidPayCardDetails[] newArray(int i)
        {
            return new AndroidPayCard.AndroidPayCardDetails[i];
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
