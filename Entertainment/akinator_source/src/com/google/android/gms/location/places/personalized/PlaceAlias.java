// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.location.places.personalized:
//            zzc

public class PlaceAlias
    implements SafeParcelable
{

    public static final zzc CREATOR = new zzc();
    public static final PlaceAlias zzaHY = new PlaceAlias(0, "Home");
    public static final PlaceAlias zzaHZ = new PlaceAlias(0, "Work");
    final int mVersionCode;
    private final String zzaIa;

    PlaceAlias(int i, String s)
    {
        mVersionCode = i;
        zzaIa = s;
    }

    public int describeContents()
    {
        zzc zzc1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof PlaceAlias))
        {
            return false;
        } else
        {
            obj = (PlaceAlias)obj;
            return zzw.equal(zzaIa, ((PlaceAlias) (obj)).zzaIa);
        }
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzaIa
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("alias", zzaIa).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc zzc1 = CREATOR;
        zzc.zza(this, parcel, i);
    }

    public String zzxq()
    {
        return zzaIa;
    }

}
