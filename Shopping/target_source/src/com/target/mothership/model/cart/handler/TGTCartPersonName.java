// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.common.PersonName;

public class TGTCartPersonName
    implements PersonName
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTCartPersonName a(Parcel parcel)
        {
            return new TGTCartPersonName(parcel);
        }

        public TGTCartPersonName[] a(int i)
        {
            return new TGTCartPersonName[i];
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
    private String mGivenName;
    private String mMiddleName;
    private String mSurname;

    TGTCartPersonName()
    {
    }

    private TGTCartPersonName(Parcel parcel)
    {
        mGivenName = parcel.readString();
        mMiddleName = parcel.readString();
        mSurname = parcel.readString();
    }


    public String a()
    {
        return mGivenName;
    }

    public void a(String s)
    {
        mGivenName = s;
    }

    public String b()
    {
        return mMiddleName;
    }

    public void b(String s)
    {
        mMiddleName = s;
    }

    public String c()
    {
        return mSurname;
    }

    public void c(String s)
    {
        mSurname = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mGivenName);
        parcel.writeString(mMiddleName);
        parcel.writeString(mSurname);
    }

}
