// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.promotion.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.model.promotion.interfaces.PromotionDetail;
import com.target.mothership.util.k;
import com.target.mothership.util.p;

public class TGTPromotionDetail
    implements Parcelable, PromotionDetail
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTPromotionDetail a(Parcel parcel)
        {
            return new TGTPromotionDetail(parcel);
        }

        public TGTPromotionDetail[] a(int i)
        {
            return new TGTPromotionDetail[i];
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
    private String mAction;
    private String mDescription;
    private String mImageUrl;
    private String mTitle;
    private String mValue;

    public TGTPromotionDetail()
    {
    }

    private TGTPromotionDetail(Parcel parcel)
    {
        mTitle = parcel.readString();
        mDescription = parcel.readString();
        mImageUrl = parcel.readString();
        mValue = parcel.readString();
        mAction = parcel.readString();
    }


    public e a(int i)
    {
        if (mImageUrl == null)
        {
            return com.google.a.a.e.e();
        } else
        {
            return com.google.a.a.e.b(p.a(mImageUrl, i));
        }
    }

    public String a()
    {
        return mTitle;
    }

    public void a(String s)
    {
        mTitle = s;
    }

    public e b()
    {
        return k.a(mImageUrl);
    }

    public void b(String s)
    {
        mDescription = s;
    }

    public String c()
    {
        return mValue;
    }

    public void c(String s)
    {
        mImageUrl = s;
    }

    public void d(String s)
    {
        mValue = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void e(String s)
    {
        mAction = s;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mTitle);
        parcel.writeString(mDescription);
        parcel.writeString(mImageUrl);
        parcel.writeString(mValue);
        parcel.writeString(mAction);
    }

}
