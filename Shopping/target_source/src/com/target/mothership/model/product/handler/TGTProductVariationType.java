// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.model.product.interfaces.ProductVariationDimensions;

class TGTProductVariationType
    implements ProductVariationDimensions
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductVariationType a(Parcel parcel)
        {
            return new TGTProductVariationType(parcel);
        }

        public TGTProductVariationType[] a(int i)
        {
            return new TGTProductVariationType[i];
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
    private String mVariationType1;
    private String mVariationType2;

    TGTProductVariationType()
    {
    }

    TGTProductVariationType(Parcel parcel)
    {
        mVariationType1 = parcel.readString();
        mVariationType2 = parcel.readString();
    }

    public String a()
    {
        return mVariationType1;
    }

    public void a(String s)
    {
        mVariationType1 = s;
    }

    public String b()
    {
        return mVariationType2;
    }

    public void b(String s)
    {
        mVariationType2 = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mVariationType1);
        parcel.writeString(mVariationType2);
    }

}
