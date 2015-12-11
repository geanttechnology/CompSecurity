// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.model.product.interfaces.ProductCartWheel;

public class TGTProductCartWheel
    implements ProductCartWheel
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductCartWheel a(Parcel parcel)
        {
            return new TGTProductCartWheel(parcel);
        }

        public TGTProductCartWheel[] a(int i)
        {
            return new TGTProductCartWheel[i];
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
    private String mActionUri;
    private String mDescription;
    private String mImageUri;
    private boolean mIsPresent;
    private int mOfferId;
    private String mOfferUuid;
    private String mTitle;

    TGTProductCartWheel()
    {
    }

    private TGTProductCartWheel(Parcel parcel)
    {
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsPresent = flag;
        mOfferId = parcel.readInt();
        mOfferUuid = parcel.readString();
        mActionUri = parcel.readString();
        mTitle = parcel.readString();
        mDescription = parcel.readString();
        mImageUri = parcel.readString();
    }


    public void a(int i)
    {
        mOfferId = i;
    }

    public void a(String s)
    {
        mOfferUuid = s;
    }

    public void a(boolean flag)
    {
        mIsPresent = flag;
    }

    public boolean a()
    {
        return mIsPresent;
    }

    public String b()
    {
        return mActionUri;
    }

    public void b(String s)
    {
        mActionUri = s;
    }

    public void c(String s)
    {
        mTitle = s;
    }

    public void d(String s)
    {
        mDescription = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void e(String s)
    {
        mImageUri = s;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        byte byte0;
        if (mIsPresent)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeInt(mOfferId);
        parcel.writeString(mOfferUuid);
        parcel.writeString(mActionUri);
        parcel.writeString(mTitle);
        parcel.writeString(mDescription);
        parcel.writeString(mImageUri);
    }

}
