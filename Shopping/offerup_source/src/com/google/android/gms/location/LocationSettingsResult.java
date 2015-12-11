// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.location:
//            zzg, LocationSettingsStates

public final class LocationSettingsResult
    implements Result, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzg();
    private final int mVersionCode;
    private final Status zzSC;
    private final LocationSettingsStates zzaEP;

    LocationSettingsResult(int i, Status status, LocationSettingsStates locationsettingsstates)
    {
        mVersionCode = i;
        zzSC = status;
        zzaEP = locationsettingsstates;
    }

    public LocationSettingsResult(Status status)
    {
        this(1, status, null);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final LocationSettingsStates getLocationSettingsStates()
    {
        return zzaEP;
    }

    public final Status getStatus()
    {
        return zzSC;
    }

    public final int getVersionCode()
    {
        return mVersionCode;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzg.zza(this, parcel, i);
    }

}
