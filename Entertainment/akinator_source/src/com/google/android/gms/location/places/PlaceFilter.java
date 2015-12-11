// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.location.places:
//            zza, zzg

public final class PlaceFilter extends com.google.android.gms.location.places.zza
    implements SafeParcelable
{
    public static final class zza
    {

        private boolean zzaGl;
        private Collection zzaGm;
        private Collection zzaGn;
        private String zzaGo[];

        public PlaceFilter zzwU()
        {
            List list = null;
            ArrayList arraylist;
            ArrayList arraylist1;
            if (zzaGm != null)
            {
                arraylist = new ArrayList(zzaGm);
            } else
            {
                arraylist = null;
            }
            if (zzaGn != null)
            {
                arraylist1 = new ArrayList(zzaGn);
            } else
            {
                arraylist1 = null;
            }
            if (zzaGo != null)
            {
                list = Arrays.asList(zzaGo);
            }
            return new PlaceFilter(arraylist, zzaGl, list, arraylist1);
        }

        private zza()
        {
            zzaGm = null;
            zzaGl = false;
            zzaGn = null;
            zzaGo = null;
        }

    }


    public static final zzg CREATOR = new zzg();
    final int mVersionCode;
    final List zzaFX;
    private final Set zzaFY;
    final List zzaFZ;
    final List zzaGa;
    private final Set zzaGb;
    private final Set zzaGc;
    final boolean zzaGl;

    public PlaceFilter()
    {
        this(false, null);
    }

    PlaceFilter(int i, List list, boolean flag, List list1, List list2)
    {
        mVersionCode = i;
        if (list == null)
        {
            list = Collections.emptyList();
        } else
        {
            list = Collections.unmodifiableList(list);
        }
        zzaFX = list;
        zzaGl = flag;
        if (list2 == null)
        {
            list = Collections.emptyList();
        } else
        {
            list = Collections.unmodifiableList(list2);
        }
        zzaGa = list;
        if (list1 == null)
        {
            list = Collections.emptyList();
        } else
        {
            list = Collections.unmodifiableList(list1);
        }
        zzaFZ = list;
        zzaFY = zzs(zzaFX);
        zzaGc = zzs(zzaGa);
        zzaGb = zzs(zzaFZ);
    }

    public PlaceFilter(Collection collection, boolean flag, Collection collection1, Collection collection2)
    {
        this(0, zzf(collection), flag, zzf(collection1), zzf(collection2));
    }

    public PlaceFilter(boolean flag, Collection collection)
    {
        this(null, flag, collection, null);
    }

    public static PlaceFilter zzwT()
    {
        return (new zza()).zzwU();
    }

    public int describeContents()
    {
        zzg zzg1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof PlaceFilter))
            {
                return false;
            }
            obj = (PlaceFilter)obj;
            if (!zzaFY.equals(((PlaceFilter) (obj)).zzaFY) || zzaGl != ((PlaceFilter) (obj)).zzaGl || !zzaGc.equals(((PlaceFilter) (obj)).zzaGc) || !zzaGb.equals(((PlaceFilter) (obj)).zzaGb))
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

    public Set getPlaceTypes()
    {
        return zzaFY;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzaFY, Boolean.valueOf(zzaGl), zzaGc, zzaGb
        });
    }

    public boolean isRestrictedToPlacesOpenNow()
    {
        return zzaGl;
    }

    public String toString()
    {
        com.google.android.gms.common.internal.zzw.zza zza1 = zzw.zzv(this);
        if (!zzaFY.isEmpty())
        {
            zza1.zzg("types", zzaFY);
        }
        zza1.zzg("requireOpenNow", Boolean.valueOf(zzaGl));
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
        zzg zzg1 = CREATOR;
        zzg.zza(this, parcel, i);
    }

    public Set zzwS()
    {
        return zzaGc;
    }

}
