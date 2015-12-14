// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.result;

import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.fitness.result:
//            zzl

public class SyncInfoResult
    implements Result, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzl();
    private final int mVersionCode;
    private final Status zzQA;
    private final long zzXR;

    SyncInfoResult(int i, Status status, long l)
    {
        mVersionCode = i;
        zzQA = status;
        zzXR = l;
    }

    private boolean zzb(SyncInfoResult syncinforesult)
    {
        return zzQA.equals(syncinforesult.zzQA) && zzw.equal(Long.valueOf(zzXR), Long.valueOf(syncinforesult.zzXR));
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof SyncInfoResult) && zzb((SyncInfoResult)obj);
    }

    public Status getStatus()
    {
        return zzQA;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzQA, Long.valueOf(zzXR)
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("status", zzQA).zzg("timestamp", Long.valueOf(zzXR)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzl.zza(this, parcel, i);
    }

    public long zzsH()
    {
        return zzXR;
    }

}
