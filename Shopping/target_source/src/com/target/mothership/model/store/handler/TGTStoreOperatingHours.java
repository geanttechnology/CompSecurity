// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.model.store.interfaces.StoreOperatingHours;
import com.target.mothership.util.TimeOfDay;

class TGTStoreOperatingHours
    implements Parcelable, StoreOperatingHours
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTStoreOperatingHours a(Parcel parcel)
        {
            return new TGTStoreOperatingHours(parcel);
        }

        public TGTStoreOperatingHours[] a(int i)
        {
            return new TGTStoreOperatingHours[i];
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
    private final TimeOfDay mBeginTime;
    private final boolean mClosed;
    private final TimeOfDay mEndTime;
    private final String mName;
    private final boolean mOpen24Hours;
    private final String mShortName;

    private TGTStoreOperatingHours(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        mName = parcel.readString();
        mShortName = parcel.readString();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mOpen24Hours = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mClosed = flag;
        mBeginTime = (TimeOfDay)parcel.readParcelable(com/target/mothership/util/TimeOfDay.getClassLoader());
        mEndTime = (TimeOfDay)parcel.readParcelable(com/target/mothership/util/TimeOfDay.getClassLoader());
    }


    TGTStoreOperatingHours(String s, String s1, String s2, String s3)
    {
        boolean flag1 = true;
        super();
        mName = s;
        mShortName = s1;
        mBeginTime = TimeOfDay.a(s2);
        mEndTime = TimeOfDay.a(s3);
        boolean flag;
        if (mBeginTime != null && mBeginTime.a() == 0 && mEndTime != null && mEndTime.a() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mOpen24Hours = flag;
        if (mBeginTime == null && mEndTime == null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mClosed = flag;
    }

    public String a()
    {
        return mName;
    }

    public String b()
    {
        return mShortName;
    }

    public boolean c()
    {
        return mOpen24Hours;
    }

    public boolean d()
    {
        return mClosed;
    }

    public int describeContents()
    {
        return 0;
    }

    public e e()
    {
        return com.google.a.a.e.c(mBeginTime);
    }

    public e f()
    {
        return com.google.a.a.e.c(mEndTime);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(mName);
        parcel.writeString(mShortName);
        byte byte0;
        if (mOpen24Hours)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mClosed)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeParcelable(mBeginTime, 0);
        parcel.writeParcelable(mEndTime, 0);
    }

}
