// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.Places;

public class zzq
    implements PlacePhotoMetadata
{

    private int mIndex;
    private final int zzAG;
    private final int zzAH;
    private final String zzaHL;
    private final CharSequence zzaHM;

    public zzq(String s, int i, int j, CharSequence charsequence, int k)
    {
        zzaHL = s;
        zzAG = i;
        zzAH = j;
        zzaHM = charsequence;
        mIndex = k;
    }

    static String zza(zzq zzq1)
    {
        return zzq1.zzaHL;
    }

    static int zzb(zzq zzq1)
    {
        return zzq1.mIndex;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzq))
            {
                return false;
            }
            obj = (zzq)obj;
            if (((zzq) (obj)).zzAG != zzAG || ((zzq) (obj)).zzAH != zzAH || !zzw.equal(((zzq) (obj)).zzaHL, zzaHL) || !zzw.equal(((zzq) (obj)).zzaHM, zzaHM))
            {
                return false;
            }
        }
        return true;
    }

    public Object freeze()
    {
        return zzxp();
    }

    public CharSequence getAttributions()
    {
        return zzaHM;
    }

    public int getMaxHeight()
    {
        return zzAH;
    }

    public int getMaxWidth()
    {
        return zzAG;
    }

    public PendingResult getPhoto(GoogleApiClient googleapiclient)
    {
        return getScaledPhoto(googleapiclient, getMaxWidth(), getMaxHeight());
    }

    public PendingResult getScaledPhoto(GoogleApiClient googleapiclient, int i, int j)
    {
        return googleapiclient.zza(new _cls1(Places.zzaGz, googleapiclient, i, j));
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(zzAG), Integer.valueOf(zzAH), zzaHL, zzaHM
        });
    }

    public boolean isDataValid()
    {
        return true;
    }

    public PlacePhotoMetadata zzxp()
    {
        return this;
    }

    private class _cls1 extends com.google.android.gms.location.places.zzf.zza
    {

        final int zzaHN;
        final int zzaHO;
        final zzq zzaHP;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
        {
            zza((zze)zzb1);
        }

        protected void zza(zze zze1)
        {
            zze1.zza(new zzf(this), zzq.zza(zzaHP), zzaHN, zzaHO, zzq.zzb(zzaHP));
        }

        _cls1(com.google.android.gms.common.api.Api.zzc zzc, GoogleApiClient googleapiclient, int i, int j)
        {
            zzaHP = zzq.this;
            zzaHN = i;
            zzaHO = j;
            super(zzc, googleapiclient);
        }
    }

}
