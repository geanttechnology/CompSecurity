// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.location.places:
//            zza, zzd

public final class NearbyAlertFilter extends zza
    implements SafeParcelable
{

    public static final zzd CREATOR = new zzd();
    final int mVersionCode;
    final List zzaFX;
    private final Set zzaFY;
    final List zzaFZ;
    final List zzaGa;
    private final Set zzaGb;
    private final Set zzaGc;

    NearbyAlertFilter(int i, List list, List list1, List list2)
    {
        mVersionCode = i;
        if (list1 == null)
        {
            list1 = Collections.emptyList();
        } else
        {
            list1 = Collections.unmodifiableList(list1);
        }
        zzaFX = list1;
        if (list2 == null)
        {
            list1 = Collections.emptyList();
        } else
        {
            list1 = Collections.unmodifiableList(list2);
        }
        zzaGa = list1;
        if (list == null)
        {
            list = Collections.emptyList();
        } else
        {
            list = Collections.unmodifiableList(list);
        }
        zzaFZ = list;
        zzaFY = zzs(zzaFX);
        zzaGc = zzs(zzaGa);
        zzaGb = zzs(zzaFZ);
    }

    public static NearbyAlertFilter zza(Collection collection, Collection collection1, Collection collection2)
    {
        if ((collection == null || collection.isEmpty()) && (collection1 == null || collection1.isEmpty()) && (collection2 == null || collection2.isEmpty()))
        {
            throw new IllegalArgumentException("NearbyAlertFilters must contain at least onePlaceId, PlaceType, or UserDataType to match results with.");
        } else
        {
            return new NearbyAlertFilter(0, zzf(collection), zzf(collection1), zzf(collection2));
        }
    }

    public int describeContents()
    {
        zzd zzd1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof NearbyAlertFilter))
            {
                return false;
            }
            obj = (NearbyAlertFilter)obj;
            if (!zzaFY.equals(((NearbyAlertFilter) (obj)).zzaFY) || !zzaGc.equals(((NearbyAlertFilter) (obj)).zzaGc) || !zzaGb.equals(((NearbyAlertFilter) (obj)).zzaGb))
            {
                return false;
            }
        }
        return true;
    }

    public Set getPlaceIds()
    {
        return zzaGb;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzaFY, zzaGc, zzaGb
        });
    }

    public String toString()
    {
        com.google.android.gms.common.internal.zzw.zza zza1 = zzw.zzv(this);
        if (!zzaFY.isEmpty())
        {
            zza1.zzg("types", zzaFY);
        }
        if (!zzaGb.isEmpty())
        {
            zza1.zzg("placeIds", zzaGb);
        }
        if (!zzaGc.isEmpty())
        {
            zza1.zzg("requestedUserDataTypes", zzaGc);
        }
        return zza1.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd zzd1 = CREATOR;
        zzd.zza(this, parcel, i);
    }

}
