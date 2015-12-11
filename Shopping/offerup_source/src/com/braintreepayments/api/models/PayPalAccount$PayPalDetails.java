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

    public static final android.os.Account.PayPalDetails._cls1 CREATOR = new _cls1();
    private String mEmail;

    private String getEmail()
    {
        return mEmail;
    }

    private void setEmail(String s)
    {
        mEmail = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mEmail);
    }




    public _cls1()
    {
    }

    private _cls1(Parcel parcel)
    {
        mEmail = parcel.readString();
    }

    mEmail(Parcel parcel, mEmail memail)
    {
        this(parcel);
    }

    class _cls1
        implements android.os.Parcelable.Creator
    {

        public final PayPalAccount.PayPalDetails createFromParcel(Parcel parcel)
        {
            return new PayPalAccount.PayPalDetails(parcel, null);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final PayPalAccount.PayPalDetails[] newArray(int i)
        {
            return new PayPalAccount.PayPalDetails[i];
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
