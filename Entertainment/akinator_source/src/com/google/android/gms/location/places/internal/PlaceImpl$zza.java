// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            PlaceImpl, PlaceLocalization

public static class mVersionCode
{

    private String mName;
    private int mVersionCode;
    private LatLng zzaFS;
    private String zzaFU;
    private Uri zzaFV;
    private float zzaHk;
    private LatLngBounds zzaHl;
    private String zzaHm;
    private boolean zzaHn;
    private float zzaHo;
    private int zzaHp;
    private long zzaHq;
    private String zzaHs;
    private List zzaHt;
    private boolean zzaHu;
    private Bundle zzaHy;
    private List zzaHz;
    private String zzapU;
    private String zzwN;

    public mVersionCode zza(LatLng latlng)
    {
        zzaFS = latlng;
        return this;
    }

    public zzaFS zza(LatLngBounds latlngbounds)
    {
        zzaHl = latlngbounds;
        return this;
    }

    public zzaHl zzai(boolean flag)
    {
        zzaHn = flag;
        return this;
    }

    public zzaHn zzaj(boolean flag)
    {
        zzaHu = flag;
        return this;
    }

    public zzaHu zzdA(String s)
    {
        zzwN = s;
        return this;
    }

    public zzwN zzdB(String s)
    {
        mName = s;
        return this;
    }

    public mName zzdC(String s)
    {
        zzapU = s;
        return this;
    }

    public zzapU zzdD(String s)
    {
        zzaFU = s;
        return this;
    }

    public zzaFU zzf(float f)
    {
        zzaHk = f;
        return this;
    }

    public zzaHk zzg(float f)
    {
        zzaHo = f;
        return this;
    }

    public zzaHo zzhs(int i)
    {
        zzaHp = i;
        return this;
    }

    public zzaHp zzl(Uri uri)
    {
        zzaFV = uri;
        return this;
    }

    public zzaFV zzt(List list)
    {
        zzaHz = list;
        return this;
    }

    public zzaHz zzu(List list)
    {
        zzaHt = list;
        return this;
    }

    public PlaceImpl zzxn()
    {
        return new PlaceImpl(mVersionCode, zzwN, zzaHz, Collections.emptyList(), zzaHy, mName, zzapU, zzaFU, zzaHs, zzaHt, zzaFS, zzaHk, zzaHl, zzaHm, zzaFV, zzaHn, zzaHo, zzaHp, zzaHq, zzaHu, PlaceLocalization.zza(mName, zzapU, zzaFU, zzaHs, zzaHt));
    }

    public ion()
    {
        mVersionCode = 0;
    }
}
