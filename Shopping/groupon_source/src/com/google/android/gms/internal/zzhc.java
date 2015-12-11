// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

// Referenced classes of package com.google.android.gms.internal:
//            zzhl, zzhd, zzgc, zzcb, 
//            zzbk, zzbj, zzbi

public class zzhc
{

    private Context mContext;
    private boolean zzEd;
    private boolean zzEe;
    private final String zzFE;
    private final zzhd zzFF;
    private BigInteger zzFG;
    private final HashSet zzFH = new HashSet();
    private final HashMap zzFI = new HashMap();
    private boolean zzFJ;
    private int zzFK;
    private zzcb zzFL;
    private zzbk zzFM;
    private final LinkedList zzFN = new LinkedList();
    private Boolean zzFO;
    private String zzFP;
    private VersionInfoParcel zzoM;
    private boolean zzpb;
    private final Object zzqt = new Object();
    private zzbj zzrw;
    private zzbi zzrx;
    private final zzgc zzry = null;

    public zzhc(zzhl zzhl1)
    {
        zzFG = BigInteger.ONE;
        zzFJ = false;
        zzEd = true;
        zzFK = 0;
        zzpb = false;
        zzFL = null;
        zzEe = true;
        zzrw = null;
        zzFM = null;
        zzrx = null;
        zzFO = null;
        zzFE = zzhl1.zzgn();
        zzFF = new zzhd(zzFE);
    }

    public void zzb(Boolean boolean1)
    {
        synchronized (zzqt)
        {
            zzFO = boolean1;
        }
        return;
        boolean1;
        obj;
        JVM INSTR monitorexit ;
        throw boolean1;
    }

    public String zzc(int i, String s)
    {
        Resources resources;
        if (zzoM.zzGJ)
        {
            resources = mContext.getResources();
        } else
        {
            resources = GooglePlayServicesUtil.getRemoteResource(mContext);
        }
        if (resources == null)
        {
            return s;
        } else
        {
            return resources.getString(i);
        }
    }

    public void zzc(Throwable throwable, boolean flag)
    {
        (new zzgc(mContext, zzoM, null, null)).zza(throwable, flag);
    }

    public String zzgb()
    {
        String s;
        synchronized (zzqt)
        {
            s = zzFP;
        }
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Boolean zzgc()
    {
        Boolean boolean1;
        synchronized (zzqt)
        {
            boolean1 = zzFO;
        }
        return boolean1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
