// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.model.product.interfaces.ProductRgbValue;
import com.target.mothership.util.k;

public class TGTProductRgbValue
    implements ProductRgbValue
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductRgbValue a(Parcel parcel)
        {
            return new TGTProductRgbValue(parcel);
        }

        public TGTProductRgbValue[] a(int i)
        {
            return new TGTProductRgbValue[i];
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
    private int mBlueColor;
    private int mGreenColor;
    private int mRedColor;
    private int mRgbColor;
    private String mRgbColorHex;

    TGTProductRgbValue()
    {
    }

    private TGTProductRgbValue(Parcel parcel)
    {
        mRedColor = parcel.readInt();
        mGreenColor = parcel.readInt();
        mBlueColor = parcel.readInt();
        mRgbColorHex = parcel.readString();
        mRgbColor = parcel.readInt();
    }


    public int a()
    {
        return mRgbColor;
    }

    public void a(int i)
    {
        mRedColor = i;
    }

    public void a(String s)
    {
        mRgbColorHex = s;
    }

    public void b(int i)
    {
        mGreenColor = i;
    }

    public void c(int i)
    {
        mBlueColor = i;
    }

    public void d(int i)
    {
        mRgbColor = i;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof TGTProductRgbValue))
            {
                return false;
            }
            obj = (TGTProductRgbValue)obj;
            if (!k.a(mRedColor, ((TGTProductRgbValue) (obj)).mRedColor) || !k.a(mGreenColor, ((TGTProductRgbValue) (obj)).mGreenColor) || !k.a(mBlueColor, ((TGTProductRgbValue) (obj)).mBlueColor) || !k.a(mRgbColor, ((TGTProductRgbValue) (obj)).mRgbColor) || !k.a(mRgbColorHex, ((TGTProductRgbValue) (obj)).mRgbColorHex))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = mRedColor;
        int l = mGreenColor;
        int i1 = mBlueColor;
        int j1 = mRgbColor;
        int i;
        if (mRgbColorHex != null)
        {
            i = mRgbColorHex.hashCode();
        } else
        {
            i = 0;
        }
        return i + (((j * 31 + l) * 31 + i1) * 31 + j1) * 31;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(mRedColor);
        parcel.writeInt(mGreenColor);
        parcel.writeInt(mBlueColor);
        parcel.writeString(mRgbColorHex);
        parcel.writeInt(mRgbColor);
    }

}
