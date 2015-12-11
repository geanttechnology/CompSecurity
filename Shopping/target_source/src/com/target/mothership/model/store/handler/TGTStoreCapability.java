// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.common.store.a;
import com.target.mothership.model.store.interfaces.StoreCapability;
import com.target.mothership.model.store.interfaces.StoreOperatingHours;
import com.target.mothership.util.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TGTStoreCapability
    implements Parcelable, StoreCapability
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTStoreCapability a(Parcel parcel)
        {
            return new TGTStoreCapability(parcel);
        }

        public TGTStoreCapability[] a(int i)
        {
            return new TGTStoreCapability[i];
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
    private e mEndDate;
    private List mHours;
    private String mName;
    private List mPhoneNumbers;
    private Date mStartDate;
    private a mType;

    public TGTStoreCapability()
    {
    }

    private TGTStoreCapability(Parcel parcel)
    {
        mName = parcel.readString();
        mType = com.target.mothership.common.store.a.values()[parcel.readInt()];
        long l = parcel.readLong();
        Date date;
        if (l == -1L)
        {
            date = null;
        } else
        {
            date = new Date(l);
        }
        mStartDate = date;
        mEndDate = e.c((Date)parcel.readSerializable());
        mHours = new ArrayList();
        parcel.readList(mHours, com/target/mothership/model/store/interfaces/StoreOperatingHours.getClassLoader());
        mPhoneNumbers = new ArrayList();
        parcel.readList(mPhoneNumbers, com/target/mothership/model/store/interfaces/StoreOperatingHours.getClassLoader());
    }


    public String a()
    {
        return mName;
    }

    public void a(a a1)
    {
        mType = a1;
    }

    public void a(String s)
    {
        mName = s;
    }

    public void a(Date date)
    {
        mStartDate = date;
    }

    public void a(List list)
    {
        mHours = list;
    }

    public List b()
    {
        return mHours;
    }

    public void b(Date date)
    {
        mEndDate = k.a(date);
    }

    public void b(List list)
    {
        mPhoneNumbers = list;
    }

    public List c()
    {
        return mPhoneNumbers;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mName);
        parcel.writeInt(mType.ordinal());
        long l;
        if (mStartDate != null)
        {
            l = mStartDate.getTime();
        } else
        {
            l = -1L;
        }
        parcel.writeLong(l);
        parcel.writeSerializable((Serializable)mEndDate.d());
        parcel.writeList(mHours);
        parcel.writeList(mPhoneNumbers);
    }

}
