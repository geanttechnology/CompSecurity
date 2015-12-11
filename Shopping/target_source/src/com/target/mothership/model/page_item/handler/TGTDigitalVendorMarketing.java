// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.page_item.handler;

import android.os.Parcel;
import com.target.mothership.model.page_item.interfaces.DigitalVendorMarketing;

class TGTDigitalVendorMarketing
    implements DigitalVendorMarketing
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTDigitalVendorMarketing a(Parcel parcel)
        {
            return new TGTDigitalVendorMarketing(parcel);
        }

        public TGTDigitalVendorMarketing[] a(int i)
        {
            return new TGTDigitalVendorMarketing[i];
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
    private String mAdvertisingUnitId;
    private String mPageType;
    private String mUrl;

    public TGTDigitalVendorMarketing()
    {
    }

    private TGTDigitalVendorMarketing(Parcel parcel)
    {
        mAdvertisingUnitId = parcel.readString();
        mPageType = parcel.readString();
        mUrl = parcel.readString();
    }


    public String a()
    {
        return mUrl;
    }

    public void a(String s)
    {
        mAdvertisingUnitId = s;
    }

    public void b(String s)
    {
        mPageType = s;
    }

    public void c(String s)
    {
        mUrl = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mAdvertisingUnitId);
        parcel.writeString(mPageType);
        parcel.writeString(mUrl);
    }

}
