// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.result;

import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

// Referenced classes of package com.google.android.gms.fitness.result:
//            zzf

public class DataStatsResult
    implements Result, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzf();
    private final int mVersionCode;
    private final Status zzQA;
    private final List zzaqM;

    DataStatsResult(int i, Status status, List list)
    {
        mVersionCode = i;
        zzQA = status;
        zzaqM = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public Status getStatus()
    {
        return zzQA;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzf.zza(this, parcel, i);
    }

    List zzsF()
    {
        return zzaqM;
    }

}
