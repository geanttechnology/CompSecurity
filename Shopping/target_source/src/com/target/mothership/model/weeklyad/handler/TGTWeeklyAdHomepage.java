// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdHomepage;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdPromotion;
import java.util.ArrayList;
import java.util.List;

class TGTWeeklyAdHomepage
    implements Parcelable, WeeklyAdHomepage
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTWeeklyAdHomepage a(Parcel parcel)
        {
            return new TGTWeeklyAdHomepage(parcel);
        }

        public TGTWeeklyAdHomepage[] a(int i)
        {
            return new TGTWeeklyAdHomepage[i];
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
    private WeeklyAdPromotion mFeaturedPromotion;
    private String mImageUrl;
    private List mOtherPromotions;

    public TGTWeeklyAdHomepage()
    {
    }

    private TGTWeeklyAdHomepage(Parcel parcel)
    {
        mFeaturedPromotion = (WeeklyAdPromotion)parcel.readParcelable(com/target/mothership/model/weeklyad/interfaces/WeeklyAdPromotion.getClassLoader());
        mOtherPromotions = new ArrayList();
        parcel.readList(mOtherPromotions, com/target/mothership/model/weeklyad/interfaces/WeeklyAdPromotion.getClassLoader());
        mImageUrl = parcel.readString();
    }


    public WeeklyAdPromotion a()
    {
        return mFeaturedPromotion;
    }

    public void a(WeeklyAdPromotion weeklyadpromotion)
    {
        mFeaturedPromotion = weeklyadpromotion;
    }

    public void a(String s)
    {
        mImageUrl = s;
    }

    public void a(List list)
    {
        mOtherPromotions = list;
    }

    public List b()
    {
        return mOtherPromotions;
    }

    public String c()
    {
        return mImageUrl;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mFeaturedPromotion, 0);
        parcel.writeList(mOtherPromotions);
        parcel.writeString(mImageUrl);
    }

}
