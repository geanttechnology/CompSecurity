// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            zzm, PlaceImpl

public class PlaceLikelihoodEntity
    implements SafeParcelable, PlaceLikelihood
{

    public static final android.os.Parcelable.Creator CREATOR = new zzm();
    final int mVersionCode;
    final PlaceImpl zzaHA;
    final float zzaHB;

    PlaceLikelihoodEntity(int i, PlaceImpl placeimpl, float f)
    {
        mVersionCode = i;
        zzaHA = placeimpl;
        zzaHB = f;
    }

    public static PlaceLikelihoodEntity zza(PlaceImpl placeimpl, float f)
    {
        return new PlaceLikelihoodEntity(0, (PlaceImpl)zzx.zzw(placeimpl), f);
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
            if (!zzaHA.equals(((PlaceLikelihoodEntity) (obj)).zzaHA) || zzaHB != ((PlaceLikelihoodEntity) (obj)).zzaHB)
            {
                return false;
            }
        }
        return true;
    }

    public Object freeze()
    {
        return zzxo();
    }

    public float getLikelihood()
    {
        return zzaHB;
    }

    public Place getPlace()
    {
        return zzaHA;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzaHA, Float.valueOf(zzaHB)
        });
    }

    public boolean isDataValid()
    {
        return true;
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("place", zzaHA).zzg("likelihood", Float.valueOf(zzaHB)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzm.zza(this, parcel, i);
    }

    public PlaceLikelihood zzxo()
    {
        return this;
    }

}
