// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.page_item.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.model.page_item.interfaces.ImageInfo;
import com.target.mothership.model.page_item.interfaces.WeeklyAdInfo;

class TGTWeeklyAdInfo
    implements WeeklyAdInfo
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTWeeklyAdInfo a(Parcel parcel)
        {
            return new TGTWeeklyAdInfo(parcel);
        }

        public TGTWeeklyAdInfo[] a(int i)
        {
            return new TGTWeeklyAdInfo[i];
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
    private ImageInfo mImageInfo;
    private String mScrubbedCoverCode;

    public TGTWeeklyAdInfo()
    {
    }

    private TGTWeeklyAdInfo(Parcel parcel)
    {
        mImageInfo = (ImageInfo)parcel.readParcelable(com/target/mothership/model/page_item/interfaces/ImageInfo.getClassLoader());
        mScrubbedCoverCode = parcel.readString();
    }


    public e a()
    {
        return e.c(mImageInfo);
    }

    public void a(ImageInfo imageinfo)
    {
        mImageInfo = imageinfo;
    }

    public void a(String s)
    {
        mScrubbedCoverCode = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mImageInfo, i);
        parcel.writeString(mScrubbedCoverCode);
    }

}
