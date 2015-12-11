// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.location.internal:
//            zze

public final class FusedLocationProviderResult
    implements Result, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zze();
    public static final FusedLocationProviderResult zzaFr;
    private final int mVersionCode;
    private final Status zzSC;

    FusedLocationProviderResult(int i, Status status)
    {
        mVersionCode = i;
        zzSC = status;
    }

    public FusedLocationProviderResult(Status status)
    {
        this(1, status);
    }

    public int describeContents()
    {
        return 0;
    }

    public Status getStatus()
    {
        return zzSC;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zze.zza(this, parcel, i);
    }

    static 
    {
        zzaFr = new FusedLocationProviderResult(Status.zzabb);
    }
}
