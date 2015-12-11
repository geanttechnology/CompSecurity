// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.guest.interfaces.OrderItemStatus;
import java.util.Date;

public class TGTOrderItemStatus
    implements Parcelable, OrderItemStatus
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTOrderItemStatus a(Parcel parcel)
        {
            return new TGTOrderItemStatus(parcel);
        }

        public TGTOrderItemStatus[] a(int i)
        {
            return new TGTOrderItemStatus[i];
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
    private Date mCompletionDate;
    private String mStatus;

    public TGTOrderItemStatus()
    {
    }

    private TGTOrderItemStatus(Parcel parcel)
    {
        long l = parcel.readLong();
        Date date;
        if (l == -1L)
        {
            date = null;
        } else
        {
            date = new Date(l);
        }
        mCompletionDate = date;
        mStatus = parcel.readString();
    }


    public void a(String s)
    {
        mStatus = s;
    }

    public void a(Date date)
    {
        mCompletionDate = date;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        long l;
        if (mCompletionDate != null)
        {
            l = mCompletionDate.getTime();
        } else
        {
            l = -1L;
        }
        parcel.writeLong(l);
        parcel.writeString(mStatus);
    }

}
