// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.InitiatedPayPal;

public class TGTInitiatedPayPal
    implements InitiatedPayPal
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTInitiatedPayPal a(Parcel parcel)
        {
            return new TGTInitiatedPayPal(parcel);
        }

        public TGTInitiatedPayPal[] a(int i)
        {
            return new TGTInitiatedPayPal[i];
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
    private String mLink;
    private String mToken;

    public TGTInitiatedPayPal()
    {
    }

    protected TGTInitiatedPayPal(Parcel parcel)
    {
        mLink = parcel.readString();
        mToken = parcel.readString();
    }

    public String a()
    {
        return mLink;
    }

    public void a(String s)
    {
        mLink = s;
    }

    public String b()
    {
        return mToken;
    }

    public void b(String s)
    {
        mToken = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mLink);
        parcel.writeString(mToken);
    }

}
