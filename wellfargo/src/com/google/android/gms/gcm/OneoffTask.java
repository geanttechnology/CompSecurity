// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.os.Parcel;

// Referenced classes of package com.google.android.gms.gcm:
//            Task, d

public class OneoffTask extends Task
{

    public static final android.os.Parcelable.Creator CREATOR = new d();
    private final long a;
    private final long b;

    private OneoffTask(Parcel parcel)
    {
        super(parcel);
        a = parcel.readLong();
        b = parcel.readLong();
    }

    OneoffTask(Parcel parcel, d d1)
    {
        this(parcel);
    }

    public long a()
    {
        return a;
    }

    public long b()
    {
        return b;
    }

    public String toString()
    {
        return (new StringBuilder()).append(super.toString()).append(" ").append("windowStart=").append(a()).append(" ").append("windowEnd=").append(b()).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeLong(a);
        parcel.writeLong(b);
    }

}
