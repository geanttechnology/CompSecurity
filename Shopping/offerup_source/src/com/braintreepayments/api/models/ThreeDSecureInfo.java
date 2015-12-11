// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ThreeDSecureInfo
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private boolean mLiabilityShiftPossible;
    private boolean mLiabilityShifted;

    public ThreeDSecureInfo()
    {
    }

    private ThreeDSecureInfo(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mLiabilityShifted = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mLiabilityShiftPossible = flag;
    }

    ThreeDSecureInfo(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean isLiabilityShiftPossible()
    {
        return mLiabilityShiftPossible;
    }

    public boolean isLiabilityShifted()
    {
        return mLiabilityShifted;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        byte byte0;
        if (mLiabilityShifted)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mLiabilityShiftPossible)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final ThreeDSecureInfo createFromParcel(Parcel parcel)
        {
            return new ThreeDSecureInfo(parcel, null);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final ThreeDSecureInfo[] newArray(int i)
        {
            return new ThreeDSecureInfo[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls1()
        {
        }
    }

}
