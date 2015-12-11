// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.os.Parcel;

// Referenced classes of package com.google.android.gms.gcm:
//            Task

public class OneoffTask extends Task
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Object createFromParcel(Parcel parcel)
        {
            return zzdV(parcel);
        }

        public Object[] newArray(int i)
        {
            return zzgh(i);
        }

        public OneoffTask zzdV(Parcel parcel)
        {
            return new OneoffTask(parcel);
        }

        public OneoffTask[] zzgh(int i)
        {
            return new OneoffTask[i];
        }

    };
    private final long zzavZ;
    private final long zzawa;

    private OneoffTask(Parcel parcel)
    {
        super(parcel);
        zzavZ = parcel.readLong();
        zzawa = parcel.readLong();
    }


    public long getWindowEnd()
    {
        return zzawa;
    }

    public long getWindowStart()
    {
        return zzavZ;
    }

    public String toString()
    {
        return (new StringBuilder()).append(super.toString()).append(" ").append("windowStart=").append(getWindowStart()).append(" ").append("windowEnd=").append(getWindowEnd()).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeLong(zzavZ);
        parcel.writeLong(zzawa);
    }

}
