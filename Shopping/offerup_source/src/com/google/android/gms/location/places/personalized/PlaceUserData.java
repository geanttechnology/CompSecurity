// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.places.personalized:
//            zze

public class PlaceUserData
    implements SafeParcelable
{

    public static final zze CREATOR = new zze();
    final int mVersionCode;
    private final String zzRs;
    private final String zzaGt;
    private final List zzaIb;
    private final List zzaIc;
    private final List zzaId;

    PlaceUserData(int i, String s, String s1, List list, List list1, List list2)
    {
        mVersionCode = i;
        zzRs = s;
        zzaGt = s1;
        zzaIb = list;
        zzaIc = list1;
        zzaId = list2;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof PlaceUserData))
            {
                return false;
            }
            obj = (PlaceUserData)obj;
            if (!zzRs.equals(((PlaceUserData) (obj)).zzRs) || !zzaGt.equals(((PlaceUserData) (obj)).zzaGt) || !zzaIb.equals(((PlaceUserData) (obj)).zzaIb) || !zzaIc.equals(((PlaceUserData) (obj)).zzaIc) || !zzaId.equals(((PlaceUserData) (obj)).zzaId))
            {
                return false;
            }
        }
        return true;
    }

    public String getPlaceId()
    {
        return zzaGt;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzRs, zzaGt, zzaIb, zzaIc, zzaId
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("accountName", zzRs).zzg("placeId", zzaGt).zzg("testDataImpls", zzaIb).zzg("placeAliases", zzaIc).zzg("hereContents", zzaId).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zze.zza(this, parcel, i);
    }

    public String zzxr()
    {
        return zzRs;
    }

    public List zzxs()
    {
        return zzaIc;
    }

    public List zzxt()
    {
        return zzaId;
    }

    public List zzxu()
    {
        return zzaIb;
    }

}
