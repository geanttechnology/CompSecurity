// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListing;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdPage;
import com.target.mothership.util.p;
import java.util.ArrayList;
import java.util.List;

class TGTWeeklyAdPage
    implements Parcelable, WeeklyAdPage
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTWeeklyAdPage a(Parcel parcel)
        {
            return new TGTWeeklyAdPage(parcel);
        }

        public TGTWeeklyAdPage[] a(int i)
        {
            return new TGTWeeklyAdPage[i];
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
    private String mDisplayPageNumber;
    private String mImageUrl;
    private List mListings;

    public TGTWeeklyAdPage()
    {
    }

    private TGTWeeklyAdPage(Parcel parcel)
    {
        mDisplayPageNumber = parcel.readString();
        mImageUrl = parcel.readString();
        mListings = new ArrayList();
        parcel.readList(mListings, com/target/mothership/model/weeklyad/interfaces/WeeklyAdListing.getClassLoader());
    }


    public String a()
    {
        return mImageUrl;
    }

    public String a(int i)
    {
        return p.a(mImageUrl, i);
    }

    public void a(String s)
    {
        mDisplayPageNumber = s;
    }

    public void a(List list)
    {
        mListings = list;
    }

    public List b()
    {
        return mListings;
    }

    public void b(String s)
    {
        mImageUrl = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mDisplayPageNumber);
        parcel.writeString(mImageUrl);
        parcel.writeList(mListings);
    }

}
