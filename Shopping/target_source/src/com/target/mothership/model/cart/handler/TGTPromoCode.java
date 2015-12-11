// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.PromoCode;

class TGTPromoCode
    implements PromoCode
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTPromoCode a(Parcel parcel)
        {
            return new TGTPromoCode(parcel);
        }

        public TGTPromoCode[] a(int i)
        {
            return new TGTPromoCode[i];
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
    private String mCode;
    private String mDescription;

    TGTPromoCode()
    {
    }

    private TGTPromoCode(Parcel parcel)
    {
        mDescription = parcel.readString();
        mCode = parcel.readString();
    }


    public String a()
    {
        return mDescription;
    }

    public void a(String s)
    {
        mDescription = s;
    }

    public String b()
    {
        return mCode;
    }

    public void b(String s)
    {
        mCode = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mDescription);
        parcel.writeString(mCode);
    }

}
