// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Set;

// Referenced classes of package com.google.android.gms.location.places:
//            zze, PlaceFilter, NearbyAlertFilter

public final class NearbyAlertRequest
    implements SafeParcelable
{

    public static final zze CREATOR = new zze();
    private final int mVersionCode;
    private final int zzaEi;
    private final int zzaGd;
    private final PlaceFilter zzaGe = null;
    private final NearbyAlertFilter zzaGf;
    private final boolean zzaGg;
    private final int zzaGh;

    NearbyAlertRequest(int i, int j, int k, PlaceFilter placefilter, NearbyAlertFilter nearbyalertfilter, boolean flag, int l)
    {
        mVersionCode = i;
        zzaEi = j;
        zzaGd = k;
        zzaGg = flag;
        if (nearbyalertfilter != null)
        {
            zzaGf = nearbyalertfilter;
        } else
        if (placefilter != null)
        {
            if (zza(placefilter))
            {
                zzaGf = NearbyAlertFilter.zza(placefilter.getPlaceIds(), placefilter.getPlaceTypes(), placefilter.zzwS());
            } else
            {
                zzaGf = null;
            }
        } else
        {
            zzaGf = null;
        }
        zzaGh = l;
    }

    private static boolean zza(PlaceFilter placefilter)
    {
        return placefilter.getPlaceTypes() != null && !placefilter.getPlaceTypes().isEmpty() || placefilter.getPlaceIds() != null && !placefilter.getPlaceIds().isEmpty() || placefilter.zzwS() != null && !placefilter.zzwS().isEmpty();
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof NearbyAlertRequest))
            {
                return false;
            }
            obj = (NearbyAlertRequest)obj;
            if (zzaEi != ((NearbyAlertRequest) (obj)).zzaEi || zzaGd != ((NearbyAlertRequest) (obj)).zzaGd || !zzw.equal(zzaGe, ((NearbyAlertRequest) (obj)).zzaGe) || !zzw.equal(zzaGf, ((NearbyAlertRequest) (obj)).zzaGf))
            {
                return false;
            }
        }
        return true;
    }

    public final int getVersionCode()
    {
        return mVersionCode;
    }

    public final int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(zzaEi), Integer.valueOf(zzaGd)
        });
    }

    public final String toString()
    {
        return zzw.zzv(this).zzg("transitionTypes", Integer.valueOf(zzaEi)).zzg("loiteringTimeMillis", Integer.valueOf(zzaGd)).zzg("nearbyAlertFilter", zzaGf).toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zze.zza(this, parcel, i);
    }

    public final int zzwK()
    {
        return zzaEi;
    }

    public final int zzwN()
    {
        return zzaGd;
    }

    public final PlaceFilter zzwO()
    {
        return null;
    }

    public final NearbyAlertFilter zzwP()
    {
        return zzaGf;
    }

    public final boolean zzwQ()
    {
        return zzaGg;
    }

    public final int zzwR()
    {
        return zzaGh;
    }

}
