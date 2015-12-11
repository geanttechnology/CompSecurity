// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.model.product.interfaces.ProductLimitedAvailability;

public class TGTProductLimitedAvailability
    implements ProductLimitedAvailability
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductLimitedAvailability a(Parcel parcel)
        {
            return new TGTProductLimitedAvailability(parcel);
        }

        public TGTProductLimitedAvailability[] a(int i)
        {
            return new TGTProductLimitedAvailability[i];
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
    private boolean mIsApproximateFlag;
    private int mQuantity;

    TGTProductLimitedAvailability()
    {
    }

    private TGTProductLimitedAvailability(Parcel parcel)
    {
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsApproximateFlag = flag;
        mQuantity = parcel.readInt();
    }


    public void a(int i)
    {
        mQuantity = i;
    }

    public void a(boolean flag)
    {
        mIsApproximateFlag = flag;
    }

    public boolean a()
    {
        return mIsApproximateFlag;
    }

    public int b()
    {
        return mQuantity;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        byte byte0;
        if (mIsApproximateFlag)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeInt(mQuantity);
    }

}
