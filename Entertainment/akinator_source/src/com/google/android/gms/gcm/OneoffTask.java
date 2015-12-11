// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.gcm:
//            Task

public class OneoffTask extends Task
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private final long zzaCC;
    private final long zzaCD;

    private OneoffTask(Parcel parcel)
    {
        super(parcel);
        zzaCC = parcel.readLong();
        zzaCD = parcel.readLong();
    }

    OneoffTask(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    private OneoffTask(Builder builder)
    {
        super(builder);
    /* block-local class not found */
    class Builder {}

        zzaCC = Builder.zza(builder);
        zzaCD = Builder.zzb(builder);
    }

    OneoffTask(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public long getWindowEnd()
    {
        return zzaCD;
    }

    public long getWindowStart()
    {
        return zzaCC;
    }

    public void toBundle(Bundle bundle)
    {
        super.toBundle(bundle);
        bundle.putLong("window_start", zzaCC);
        bundle.putLong("window_end", zzaCD);
    }

    public String toString()
    {
        return (new StringBuilder()).append(super.toString()).append(" ").append("windowStart=").append(getWindowStart()).append(" ").append("windowEnd=").append(getWindowEnd()).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeLong(zzaCC);
        parcel.writeLong(zzaCD);
    }


    /* member class not found */
    class _cls1 {}

}
