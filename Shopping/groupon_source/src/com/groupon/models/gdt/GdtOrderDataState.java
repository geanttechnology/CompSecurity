// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.gdt;

import android.os.Parcel;
import android.os.Parcelable;

public class GdtOrderDataState
    implements Parcelable
{
    private static class GdtOrderDataStateCreator
        implements android.os.Parcelable.Creator
    {

        public GdtOrderDataState createFromParcel(Parcel parcel)
        {
            return new GdtOrderDataState(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public GdtOrderDataState[] newArray(int i)
        {
            return new GdtOrderDataState[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        private GdtOrderDataStateCreator()
        {
        }

    }


    public static final android.os.Parcelable.Creator CREATOR = new GdtOrderDataStateCreator();
    public String merchantPlaceId;
    public String orderId;
    public boolean voucherRedeemed;

    public GdtOrderDataState()
    {
    }

    private GdtOrderDataState(Parcel parcel)
    {
        orderId = parcel.readString();
        merchantPlaceId = parcel.readString();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        voucherRedeemed = flag;
    }


    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(orderId);
        parcel.writeString(merchantPlaceId);
        byte byte0;
        if (voucherRedeemed)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
    }

}
