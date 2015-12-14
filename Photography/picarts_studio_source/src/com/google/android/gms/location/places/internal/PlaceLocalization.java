// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            zzo

public final class PlaceLocalization
    implements SafeParcelable
{

    public static final zzo CREATOR = new zzo();
    public final String address;
    public final String name;
    public final int versionCode;
    public final String zzaHC;
    public final String zzaHD;
    public final List zzaHE;

    public PlaceLocalization(int i, String s, String s1, String s2, String s3, List list)
    {
        versionCode = i;
        name = s;
        address = s1;
        zzaHC = s2;
        zzaHD = s3;
        zzaHE = list;
    }

    public static PlaceLocalization zza(String s, String s1, String s2, String s3, List list)
    {
        return new PlaceLocalization(0, s, s1, s2, s3, list);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof PlaceLocalization))
            {
                return false;
            }
            obj = (PlaceLocalization)obj;
            if (!zzw.equal(name, ((PlaceLocalization) (obj)).name) || !zzw.equal(address, ((PlaceLocalization) (obj)).address) || !zzw.equal(zzaHC, ((PlaceLocalization) (obj)).zzaHC) || !zzw.equal(zzaHD, ((PlaceLocalization) (obj)).zzaHD) || !zzw.equal(zzaHE, ((PlaceLocalization) (obj)).zzaHE))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return zzw.hashCode(new Object[] {
            name, address, zzaHC, zzaHD
        });
    }

    public final String toString()
    {
        return zzw.zzv(this).zzg("name", name).zzg("address", address).zzg("internationalPhoneNumber", zzaHC).zzg("regularOpenHours", zzaHD).zzg("attributions", zzaHE).toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzo.zza(this, parcel, i);
    }

}
