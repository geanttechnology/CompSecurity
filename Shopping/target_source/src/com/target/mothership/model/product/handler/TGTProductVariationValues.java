// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.model.product.interfaces.ProductVariationValues;

public class TGTProductVariationValues
    implements ProductVariationValues
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductVariationValues a(Parcel parcel)
        {
            return new TGTProductVariationValues(parcel);
        }

        public TGTProductVariationValues[] a(int i)
        {
            return new TGTProductVariationValues[i];
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
    private String mVariation01;
    private String mVariation02;

    TGTProductVariationValues()
    {
    }

    private TGTProductVariationValues(Parcel parcel)
    {
        mVariation01 = parcel.readString();
        mVariation02 = parcel.readString();
    }


    public String a()
    {
        return mVariation01;
    }

    public void a(String s)
    {
        mVariation01 = s;
    }

    public String b()
    {
        return mVariation02;
    }

    public void b(String s)
    {
        mVariation02 = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mVariation01);
        parcel.writeString(mVariation02);
    }

}
