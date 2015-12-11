// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            zzt

public class PlacesParams
    implements SafeParcelable
{

    public static final zzt CREATOR = new zzt();
    public static final PlacesParams zzaHQ = new PlacesParams("com.google.android.gms", Locale.getDefault(), null);
    public final int versionCode;
    public final String zzaGG;
    public final String zzaHR;
    public final String zzaHS;
    public final String zzaHT;
    public final String zzaHU;
    public final int zzaHV;

    public PlacesParams(int i, String s, String s1, String s2, String s3, String s4, int j)
    {
        versionCode = i;
        zzaHR = s;
        zzaHS = s1;
        zzaHT = s2;
        zzaGG = s3;
        zzaHU = s4;
        zzaHV = j;
    }

    public PlacesParams(String s, Locale locale, String s1)
    {
        this(1, s, locale.toString(), s1, null, null, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public PlacesParams(String s, Locale locale, String s1, String s2, String s3)
    {
        this(1, s, locale.toString(), s1, s2, s3, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public int describeContents()
    {
        zzt zzt1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || !(obj instanceof PlacesParams))
            {
                return false;
            }
            obj = (PlacesParams)obj;
            if (!zzaHS.equals(((PlacesParams) (obj)).zzaHS) || !zzaHR.equals(((PlacesParams) (obj)).zzaHR) || !zzw.equal(zzaHT, ((PlacesParams) (obj)).zzaHT) || !zzw.equal(zzaGG, ((PlacesParams) (obj)).zzaGG) || !zzw.equal(zzaHU, ((PlacesParams) (obj)).zzaHU))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzaHR, zzaHS, zzaHT, zzaGG, zzaHU
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("clientPackageName", zzaHR).zzg("locale", zzaHS).zzg("accountName", zzaHT).zzg("gCoreClientName", zzaGG).zzg("chargedPackageName", zzaHU).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzt zzt1 = CREATOR;
        zzt.zza(this, parcel, i);
    }

}
