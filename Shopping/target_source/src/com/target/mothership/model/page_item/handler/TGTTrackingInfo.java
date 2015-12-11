// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.page_item.handler;

import android.os.Parcel;
import com.target.mothership.model.page_item.interfaces.TrackingInfo;

class TGTTrackingInfo
    implements TrackingInfo
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTTrackingInfo a(Parcel parcel)
        {
            return new TGTTrackingInfo(parcel);
        }

        public TGTTrackingInfo[] a(int i)
        {
            return new TGTTrackingInfo[i];
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
    private String mBannerName;
    private Integer mPromoLaunchWeekNumber;
    private String mTrackingId;

    public TGTTrackingInfo()
    {
    }

    private TGTTrackingInfo(Parcel parcel)
    {
        mBannerName = parcel.readString();
        int i = parcel.readInt();
        Integer integer;
        if (i == -1)
        {
            integer = null;
        } else
        {
            integer = Integer.valueOf(i);
        }
        mPromoLaunchWeekNumber = integer;
        mTrackingId = parcel.readString();
    }


    public String a()
    {
        return mTrackingId;
    }

    public void a(Integer integer)
    {
        mPromoLaunchWeekNumber = integer;
    }

    public void a(String s)
    {
        mBannerName = s;
    }

    public void b(String s)
    {
        mTrackingId = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mBannerName);
        if (mPromoLaunchWeekNumber == null)
        {
            i = -1;
        } else
        {
            i = mPromoLaunchWeekNumber.intValue();
        }
        parcel.writeInt(i);
        parcel.writeString(mTrackingId);
    }

}
