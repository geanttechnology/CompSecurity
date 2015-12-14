// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

public final class zzes
    implements MediationAdRequest
{

    private final Date zzaT;
    private final Set zzaV;
    private final boolean zzaW;
    private final Location zzaX;
    private final int zzsR;
    private final int zzzI;

    public zzes(Date date, int i, Set set, Location location, boolean flag, int j)
    {
        zzaT = date;
        zzsR = i;
        zzaV = set;
        zzaX = location;
        zzaW = flag;
        zzzI = j;
    }

    public final Date getBirthday()
    {
        return zzaT;
    }

    public final int getGender()
    {
        return zzsR;
    }

    public final Set getKeywords()
    {
        return zzaV;
    }

    public final Location getLocation()
    {
        return zzaX;
    }

    public final boolean isTesting()
    {
        return zzaW;
    }

    public final int taggedForChildDirectedTreatment()
    {
        return zzzI;
    }
}
