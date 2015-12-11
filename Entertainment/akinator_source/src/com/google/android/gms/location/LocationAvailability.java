// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.location:
//            LocationAvailabilityCreator

public final class LocationAvailability
    implements SafeParcelable
{

    public static final LocationAvailabilityCreator CREATOR = new LocationAvailabilityCreator();
    private final int mVersionCode;
    int zzaEA;
    int zzaEB;
    long zzaEC;
    int zzaED;

    LocationAvailability(int i, int j, int k, int l, long l1)
    {
        mVersionCode = i;
        zzaED = j;
        zzaEA = k;
        zzaEB = l;
        zzaEC = l1;
    }

    public static LocationAvailability extractLocationAvailability(Intent intent)
    {
        if (!hasLocationAvailability(intent))
        {
            return null;
        } else
        {
            return (LocationAvailability)intent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
        }
    }

    public static boolean hasLocationAvailability(Intent intent)
    {
        if (intent == null)
        {
            return false;
        } else
        {
            return intent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof LocationAvailability)
        {
            if (zzaED == ((LocationAvailability) (obj = (LocationAvailability)obj)).zzaED && zzaEA == ((LocationAvailability) (obj)).zzaEA && zzaEB == ((LocationAvailability) (obj)).zzaEB && zzaEC == ((LocationAvailability) (obj)).zzaEC)
            {
                return true;
            }
        }
        return false;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(zzaED), Integer.valueOf(zzaEA), Integer.valueOf(zzaEB), Long.valueOf(zzaEC)
        });
    }

    public boolean isLocationAvailable()
    {
        return zzaED < 1000;
    }

    public String toString()
    {
        return (new StringBuilder()).append("LocationAvailability[isLocationAvailable: ").append(isLocationAvailable()).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        LocationAvailabilityCreator.zza(this, parcel, i);
    }

}
