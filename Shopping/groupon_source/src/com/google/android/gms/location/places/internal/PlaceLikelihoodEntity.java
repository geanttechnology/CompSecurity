// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            zzl, PlaceImpl

public class PlaceLikelihoodEntity
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzl();
    final int zzCY;
    final PlaceImpl zzaAK;
    final float zzaAL;

    PlaceLikelihoodEntity(int i, PlaceImpl placeimpl, float f)
    {
        zzCY = i;
        zzaAK = placeimpl;
        zzaAL = f;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof PlaceLikelihoodEntity))
            {
                return false;
            }
            obj = (PlaceLikelihoodEntity)obj;
            if (!zzaAK.equals(((PlaceLikelihoodEntity) (obj)).zzaAK) || zzaAL != ((PlaceLikelihoodEntity) (obj)).zzaAL)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return zzt.hashCode(new Object[] {
            zzaAK, Float.valueOf(zzaAL)
        });
    }

    public String toString()
    {
        return zzt.zzt(this).zzg("place", zzaAK).zzg("likelihood", Float.valueOf(zzaAL)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzl.zza(this, parcel, i);
    }

}
