// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            zzy

public static final class zzsU
{

    private Date zzaT;
    private Location zzaX;
    private boolean zzoN;
    private int zzsR;
    private int zzsU;
    private String zzsV;
    private String zzsX;
    private final Bundle zzsZ = new Bundle();
    private final HashMap zztA = new HashMap();
    private final HashSet zztB = new HashSet();
    private final HashSet zztC = new HashSet();
    private String zztb;
    private final Bundle zztu = new Bundle();
    private final HashSet zztz = new HashSet();

    static Date zza(zzsU zzsu)
    {
        return zzsu.zzaT;
    }

    static String zzb(zzaT zzat)
    {
        return zzat.zzsX;
    }

    static int zzc(zzsX zzsx)
    {
        return zzsx.zzsR;
    }

    static HashSet zzd(zzsR zzsr)
    {
        return zzsr.zztz;
    }

    static Location zze(zztz zztz1)
    {
        return zztz1.zzaX;
    }

    static boolean zzf(zzaX zzax)
    {
        return zzax.zzoN;
    }

    static Bundle zzg(zzoN zzon)
    {
        return zzon.zztu;
    }

    static HashMap zzh(zztu zztu1)
    {
        return zztu1.zztA;
    }

    static String zzi(zztA zzta)
    {
        return zzta.zzsV;
    }

    static String zzj(zzsV zzsv)
    {
        return zzsv.zztb;
    }

    static int zzk(zztb zztb1)
    {
        return zztb1.zzsU;
    }

    static HashSet zzl(zzsU zzsu)
    {
        return zzsu.zztB;
    }

    static Bundle zzm(zztB zztb1)
    {
        return zztb1.zzsZ;
    }

    static HashSet zzn(zzsZ zzsz)
    {
        return zzsz.zztC;
    }

    public void setManualImpressionsEnabled(boolean flag)
    {
        zzoN = flag;
    }

    public void zzF(String s)
    {
        zztz.add(s);
    }

    public void zzG(String s)
    {
        zztB.add(s);
    }

    public void zzH(String s)
    {
        zztB.remove(s);
    }

    public void zzI(String s)
    {
        zzsX = s;
    }

    public void zzJ(String s)
    {
        zzsV = s;
    }

    public void zzK(String s)
    {
        zztb = s;
    }

    public void zzL(String s)
    {
        zztC.add(s);
    }

    public void zza(NetworkExtras networkextras)
    {
        if (networkextras instanceof AdMobExtras)
        {
            zza(com/google/ads/mediation/admob/AdMobAdapter, ((AdMobExtras)networkextras).getExtras());
            return;
        } else
        {
            zztA.put(networkextras.getClass(), networkextras);
            return;
        }
    }

    public void zza(Class class1, Bundle bundle)
    {
        zztu.putBundle(class1.getName(), bundle);
    }

    public void zza(Date date)
    {
        zzaT = date;
    }

    public void zzb(Location location)
    {
        zzaX = location;
    }

    public void zzb(Class class1, Bundle bundle)
    {
        if (zztu.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null)
        {
            zztu.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        zztu.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(class1.getName(), bundle);
    }

    public void zzb(String s, String s1)
    {
        zzsZ.putString(s, s1);
    }

    public void zzj(boolean flag)
    {
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        zzsU = i;
    }

    public void zzm(int i)
    {
        zzsR = i;
    }

    public ras()
    {
        zzsR = -1;
        zzoN = false;
        zzsU = -1;
    }
}
