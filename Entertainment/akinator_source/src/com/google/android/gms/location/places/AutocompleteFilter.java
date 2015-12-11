// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.location.places:
//            zzc

public class AutocompleteFilter
    implements SafeParcelable
{

    public static final zzc CREATOR = new zzc();
    final int mVersionCode;
    final boolean zzaFW;
    final List zzaFX;
    private final Set zzaFY;

    AutocompleteFilter(int i, boolean flag, Collection collection)
    {
        mVersionCode = i;
        zzaFW = flag;
        if (collection == null)
        {
            collection = Collections.emptyList();
        } else
        {
            collection = new ArrayList(collection);
        }
        zzaFX = collection;
        if (zzaFX.isEmpty())
        {
            zzaFY = Collections.emptySet();
            return;
        } else
        {
            zzaFY = Collections.unmodifiableSet(new HashSet(zzaFX));
            return;
        }
    }

    public static AutocompleteFilter create(Collection collection)
    {
        return zza(true, collection);
    }

    public static AutocompleteFilter zza(boolean flag, Collection collection)
    {
        return new AutocompleteFilter(0, flag, collection);
    }

    public int describeContents()
    {
        zzc zzc1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof AutocompleteFilter))
            {
                return false;
            }
            obj = (AutocompleteFilter)obj;
            if (!zzaFY.equals(((AutocompleteFilter) (obj)).zzaFY) || zzaFW != ((AutocompleteFilter) (obj)).zzaFW)
            {
                return false;
            }
        }
        return true;
    }

    public Set getPlaceTypes()
    {
        return zzaFY;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Boolean.valueOf(zzaFW), zzaFY
        });
    }

    public String toString()
    {
        com.google.android.gms.common.internal.zzw.zza zza1 = zzw.zzv(this);
        if (!zzaFW)
        {
            zza1.zzg("restrictedToPlaces", Boolean.valueOf(zzaFW));
        }
        zza1.zzg("placeTypes", zzaFY);
        return zza1.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc zzc1 = CREATOR;
        zzc.zza(this, parcel, i);
    }

    public boolean zzwM()
    {
        return zzaFW;
    }

}
