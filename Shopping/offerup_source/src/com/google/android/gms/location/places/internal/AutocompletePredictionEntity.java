// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.text.style.CharacterStyle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            zza, zzc

public class AutocompletePredictionEntity
    implements SafeParcelable, AutocompletePrediction
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    private static final List zzaGN = Collections.emptyList();
    final int mVersionCode;
    final List zzaFT;
    final String zzaGO;
    final List zzaGP;
    final int zzaGQ;
    final String zzaGR;
    final List zzaGS;
    final String zzaGT;
    final List zzaGU;
    final String zzaGt;

    AutocompletePredictionEntity(int i, String s, List list, int j, String s1, List list1, String s2, 
            List list2, String s3, List list3)
    {
        mVersionCode = i;
        zzaGt = s;
        zzaFT = list;
        zzaGQ = j;
        zzaGO = s1;
        zzaGP = list1;
        zzaGR = s2;
        zzaGS = list2;
        zzaGT = s3;
        zzaGU = list3;
    }

    public static AutocompletePredictionEntity zza(String s, List list, int i, String s1, List list1, String s2, List list2, String s3, 
            List list3)
    {
        return new AutocompletePredictionEntity(0, s, list, i, (String)zzx.zzw(s1), list1, s2, list2, s3, list3);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof AutocompletePredictionEntity))
            {
                return false;
            }
            obj = (AutocompletePredictionEntity)obj;
            if (!zzw.equal(zzaGt, ((AutocompletePredictionEntity) (obj)).zzaGt) || !zzw.equal(zzaFT, ((AutocompletePredictionEntity) (obj)).zzaFT) || !zzw.equal(Integer.valueOf(zzaGQ), Integer.valueOf(((AutocompletePredictionEntity) (obj)).zzaGQ)) || !zzw.equal(zzaGO, ((AutocompletePredictionEntity) (obj)).zzaGO) || !zzw.equal(zzaGP, ((AutocompletePredictionEntity) (obj)).zzaGP) || !zzw.equal(zzaGR, ((AutocompletePredictionEntity) (obj)).zzaGR) || !zzw.equal(zzaGS, ((AutocompletePredictionEntity) (obj)).zzaGS) || !zzw.equal(zzaGT, ((AutocompletePredictionEntity) (obj)).zzaGT) || !zzw.equal(zzaGU, ((AutocompletePredictionEntity) (obj)).zzaGU))
            {
                return false;
            }
        }
        return true;
    }

    public Object freeze()
    {
        return zzwV();
    }

    public String getDescription()
    {
        return zzaGO;
    }

    public CharSequence getFullText(CharacterStyle characterstyle)
    {
        return zzc.zza(zzaGO, zzaGP, characterstyle);
    }

    public List getMatchedSubstrings()
    {
        return zzaGP;
    }

    public String getPlaceId()
    {
        return zzaGt;
    }

    public List getPlaceTypes()
    {
        return zzaFT;
    }

    public CharSequence getPrimaryText(CharacterStyle characterstyle)
    {
        return zzc.zza(zzaGR, zzaGS, characterstyle);
    }

    public CharSequence getSecondaryText(CharacterStyle characterstyle)
    {
        return zzc.zza(zzaGT, zzaGU, characterstyle);
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzaGt, zzaFT, Integer.valueOf(zzaGQ), zzaGO, zzaGP, zzaGR, zzaGS, zzaGT, zzaGU
        });
    }

    public boolean isDataValid()
    {
        return true;
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("placeId", zzaGt).zzg("placeTypes", zzaFT).zzg("fullText", zzaGO).zzg("fullTextMatchedSubstrings", zzaGP).zzg("primaryText", zzaGR).zzg("primaryTextMatchedSubstrings", zzaGS).zzg("secondaryText", zzaGT).zzg("secondaryTextMatchedSubstrings", zzaGU).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.location.places.internal.zza.zza(this, parcel, i);
    }

    public AutocompletePrediction zzwV()
    {
        return this;
    }

}
