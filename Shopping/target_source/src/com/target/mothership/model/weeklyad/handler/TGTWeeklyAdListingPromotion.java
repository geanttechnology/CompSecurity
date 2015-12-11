// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingPromotion;

class TGTWeeklyAdListingPromotion
    implements Parcelable, WeeklyAdListingPromotion
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTWeeklyAdListingPromotion a(Parcel parcel)
        {
            return new TGTWeeklyAdListingPromotion(parcel);
        }

        public TGTWeeklyAdListingPromotion[] a(int i)
        {
            return new TGTWeeklyAdListingPromotion[i];
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
    private String mDescription;
    private String mLegalDisclaimer;

    public TGTWeeklyAdListingPromotion()
    {
    }

    private TGTWeeklyAdListingPromotion(Parcel parcel)
    {
        mDescription = parcel.readString();
        mLegalDisclaimer = parcel.readString();
    }


    public String a()
    {
        return mDescription;
    }

    public void a(String s)
    {
        mDescription = s;
    }

    public void b(String s)
    {
        mLegalDisclaimer = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mDescription);
        parcel.writeString(mLegalDisclaimer);
    }

}
