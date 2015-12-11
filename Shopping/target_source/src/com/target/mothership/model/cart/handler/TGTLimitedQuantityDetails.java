// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.LimitedQuantityDetails;

public class TGTLimitedQuantityDetails
    implements LimitedQuantityDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTLimitedQuantityDetails a(Parcel parcel)
        {
            return new TGTLimitedQuantityDetails(parcel);
        }

        public TGTLimitedQuantityDetails[] a(int i)
        {
            return new TGTLimitedQuantityDetails[i];
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
    private boolean mIsLimitedQuantityEligible;
    private int mLimitedQuantity;
    private int mLimitedQuantityThreshold;

    TGTLimitedQuantityDetails()
    {
    }

    private TGTLimitedQuantityDetails(Parcel parcel)
    {
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsLimitedQuantityEligible = flag;
        mLimitedQuantity = parcel.readInt();
        mLimitedQuantityThreshold = parcel.readInt();
    }


    public void a(int i)
    {
        mLimitedQuantity = i;
    }

    public void a(boolean flag)
    {
        mIsLimitedQuantityEligible = flag;
    }

    public boolean a()
    {
        return mIsLimitedQuantityEligible;
    }

    public int b()
    {
        return mLimitedQuantity;
    }

    public void b(int i)
    {
        mLimitedQuantityThreshold = i;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        byte byte0;
        if (mIsLimitedQuantityEligible)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeInt(mLimitedQuantity);
        parcel.writeInt(mLimitedQuantityThreshold);
    }

}
