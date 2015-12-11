// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.model.product.interfaces.ProductFeature;

public class TGTProductFeature
    implements ProductFeature
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductFeature a(Parcel parcel)
        {
            return new TGTProductFeature(parcel);
        }

        public TGTProductFeature[] a(int i)
        {
            return new TGTProductFeature[i];
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
    private String mName;
    private String mValue;

    TGTProductFeature()
    {
    }

    private TGTProductFeature(Parcel parcel)
    {
        mName = parcel.readString();
        mValue = parcel.readString();
    }


    public String a()
    {
        return mName;
    }

    public void a(String s)
    {
        mName = s;
    }

    public String b()
    {
        return mValue;
    }

    public void b(String s)
    {
        mValue = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mName);
        parcel.writeString(mValue);
    }

}
