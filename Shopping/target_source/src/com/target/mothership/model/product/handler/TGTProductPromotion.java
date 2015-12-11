// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.model.product.interfaces.ProductPromotion;

public class TGTProductPromotion
    implements ProductPromotion
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductPromotion a(Parcel parcel)
        {
            return new TGTProductPromotion(parcel);
        }

        public TGTProductPromotion[] a(int i)
        {
            return new TGTProductPromotion[i];
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
    private String mLegalDisclaimer;
    private String mShortDescription;

    TGTProductPromotion()
    {
    }

    private TGTProductPromotion(Parcel parcel)
    {
        mLegalDisclaimer = parcel.readString();
        mShortDescription = parcel.readString();
    }


    public String a()
    {
        return mLegalDisclaimer;
    }

    public void a(String s)
    {
        mLegalDisclaimer = s;
    }

    public String b()
    {
        return mShortDescription;
    }

    public void b(String s)
    {
        mShortDescription = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mLegalDisclaimer);
        parcel.writeString(mShortDescription);
    }

}
