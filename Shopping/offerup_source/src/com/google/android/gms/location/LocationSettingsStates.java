// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;

// Referenced classes of package com.google.android.gms.location:
//            zzh

public final class LocationSettingsStates
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzh();
    private final int mVersionCode;
    private final boolean zzaEQ;
    private final boolean zzaER;
    private final boolean zzaES;
    private final boolean zzaET;
    private final boolean zzaEU;
    private final boolean zzaEV;
    private final boolean zzaEW;

    LocationSettingsStates(int i, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5, 
            boolean flag6)
    {
        mVersionCode = i;
        zzaEQ = flag;
        zzaER = flag1;
        zzaES = flag2;
        zzaET = flag3;
        zzaEU = flag4;
        zzaEV = flag5;
        zzaEW = flag6;
    }

    public static LocationSettingsStates fromIntent(Intent intent)
    {
        return (LocationSettingsStates)zzc.zza(intent, "com.google.android.gms.location.LOCATION_SETTINGS_STATES", CREATOR);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final int getVersionCode()
    {
        return mVersionCode;
    }

    public final boolean isBlePresent()
    {
        return zzaEV;
    }

    public final boolean isBleUsable()
    {
        return zzaES;
    }

    public final boolean isGpsPresent()
    {
        return zzaET;
    }

    public final boolean isGpsUsable()
    {
        return zzaEQ;
    }

    public final boolean isLocationPresent()
    {
        return zzaET || zzaEU;
    }

    public final boolean isLocationUsable()
    {
        return zzaEQ || zzaER;
    }

    public final boolean isNetworkLocationPresent()
    {
        return zzaEU;
    }

    public final boolean isNetworkLocationUsable()
    {
        return zzaER;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzh.zza(this, parcel, i);
    }

    public final boolean zzwA()
    {
        return zzaEW;
    }

}
