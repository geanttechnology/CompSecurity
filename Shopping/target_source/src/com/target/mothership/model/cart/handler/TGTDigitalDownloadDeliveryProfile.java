// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.DigitalDownloadDeliveryProfile;

class TGTDigitalDownloadDeliveryProfile
    implements DigitalDownloadDeliveryProfile
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTDigitalDownloadDeliveryProfile a(Parcel parcel)
        {
            return new TGTDigitalDownloadDeliveryProfile(parcel);
        }

        public TGTDigitalDownloadDeliveryProfile[] a(int i)
        {
            return new TGTDigitalDownloadDeliveryProfile[i];
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
    private String mDeliveredToEmail;
    private String mDeliveredToName;

    public TGTDigitalDownloadDeliveryProfile()
    {
    }

    private TGTDigitalDownloadDeliveryProfile(Parcel parcel)
    {
        mDeliveredToEmail = parcel.readString();
        mDeliveredToName = parcel.readString();
    }


    public String a()
    {
        return mDeliveredToName;
    }

    public void a(String s)
    {
        mDeliveredToName = s;
    }

    public void b(String s)
    {
        mDeliveredToEmail = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mDeliveredToEmail);
        parcel.writeString(mDeliveredToName);
    }

}
