// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.maps.model:
//            zzg, LatLng

public final class PointOfInterest
    implements SafeParcelable
{

    public static final zzg CREATOR = new zzg();
    private final int mVersionCode;
    public final String name;
    public final LatLng zzaKr;
    public final String zzaKs;

    PointOfInterest(int i, LatLng latlng, String s, String s1)
    {
        mVersionCode = i;
        zzaKr = latlng;
        zzaKs = s;
        name = s1;
    }

    public final int describeContents()
    {
        return 0;
    }

    final int getVersionCode()
    {
        return mVersionCode;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzg.zza(this, parcel, i);
    }

}
