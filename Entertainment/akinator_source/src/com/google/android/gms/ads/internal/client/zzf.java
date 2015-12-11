// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            AdRequestParcel, SearchAdRequestParcel

public final class zzf
{

    private Bundle mExtras;
    private Location zzaX;
    private boolean zzoN;
    private long zzsQ;
    private int zzsR;
    private List zzsS;
    private boolean zzsT;
    private int zzsU;
    private String zzsV;
    private SearchAdRequestParcel zzsW;
    private String zzsX;
    private Bundle zzsY;
    private Bundle zzsZ;
    private List zzta;
    private String zztb;
    private String zztc;

    public zzf()
    {
        zzsQ = -1L;
        mExtras = new Bundle();
        zzsR = -1;
        zzsS = new ArrayList();
        zzsT = false;
        zzsU = -1;
        zzoN = false;
        zzsV = null;
        zzsW = null;
        zzaX = null;
        zzsX = null;
        zzsY = new Bundle();
        zzsZ = new Bundle();
        zzta = new ArrayList();
        zztb = null;
        zztc = null;
    }

    public zzf(AdRequestParcel adrequestparcel)
    {
        zzsQ = adrequestparcel.zzsB;
        mExtras = adrequestparcel.extras;
        zzsR = adrequestparcel.zzsC;
        zzsS = adrequestparcel.zzsD;
        zzsT = adrequestparcel.zzsE;
        zzsU = adrequestparcel.zzsF;
        zzoN = adrequestparcel.zzsG;
        zzsV = adrequestparcel.zzsH;
        zzsW = adrequestparcel.zzsI;
        zzaX = adrequestparcel.zzsJ;
        zzsX = adrequestparcel.zzsK;
        zzsY = adrequestparcel.zzsL;
        zzsZ = adrequestparcel.zzsM;
        zzta = adrequestparcel.zzsN;
        zztb = adrequestparcel.zzsO;
        zztc = adrequestparcel.zzsP;
    }

    public zzf zza(Location location)
    {
        zzaX = location;
        return this;
    }

    public AdRequestParcel zzcA()
    {
        return new AdRequestParcel(6, zzsQ, mExtras, zzsR, zzsS, zzsT, zzsU, zzoN, zzsV, zzsW, zzaX, zzsX, zzsY, zzsZ, zzta, zztb, zztc);
    }
}
