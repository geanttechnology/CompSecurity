// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.os.Parcel;

// Referenced classes of package com.google.android.gms.gcm:
//            Task

public class PeriodicTask extends Task
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Object createFromParcel(Parcel parcel)
        {
            return zzdX(parcel);
        }

        public Object[] newArray(int i)
        {
            return zzgj(i);
        }

        public PeriodicTask zzdX(Parcel parcel)
        {
            return new PeriodicTask(parcel);
        }

        public PeriodicTask[] zzgj(int i)
        {
            return new PeriodicTask[i];
        }

    };
    protected long mFlexInSeconds;
    protected long mIntervalInSeconds;

    private PeriodicTask(Parcel parcel)
    {
        super(parcel);
        mIntervalInSeconds = -1L;
        mFlexInSeconds = -1L;
        mIntervalInSeconds = parcel.readLong();
        mFlexInSeconds = parcel.readLong();
    }


    public long getFlex()
    {
        return mFlexInSeconds;
    }

    public long getPeriod()
    {
        return mIntervalInSeconds;
    }

    public String toString()
    {
        return (new StringBuilder()).append(super.toString()).append(" ").append("period=").append(getPeriod()).append(" ").append("flex=").append(getFlex()).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeLong(mIntervalInSeconds);
        parcel.writeLong(mFlexInSeconds);
    }

}
