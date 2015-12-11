// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.model.product.interfaces.ProductChokingHazard;

public class TGTProductChokingHazard
    implements ProductChokingHazard
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductChokingHazard a(Parcel parcel)
        {
            return new TGTProductChokingHazard(parcel);
        }

        public TGTProductChokingHazard[] a(int i)
        {
            return new TGTProductChokingHazard[i];
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
    private String mMessage;

    TGTProductChokingHazard()
    {
    }

    private TGTProductChokingHazard(Parcel parcel)
    {
        mCode = parcel.readString();
        mMessage = parcel.readString();
    }


    public String a()
    {
        return mMessage;
    }

    public void a(String s)
    {
        mCode = s;
    }

    public void b(String s)
    {
        mMessage = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mCode);
        parcel.writeString(mMessage);
    }

}
