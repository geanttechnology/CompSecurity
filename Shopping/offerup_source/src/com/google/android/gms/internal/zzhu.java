// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.Future;

// Referenced classes of package com.google.android.gms.internal:
//            zzid, zzhv, zzby, zzbu, 
//            zzmx, zzbj, zzbi, zzbk, 
//            zzgq, zzhx, zzht, zzhw, 
//            zzib, zzay, zzdz, zzbz, 
//            zzcb, zzca

public class zzhu
    implements zzib.zzb
{

    private Context mContext;
    private boolean zzGg;
    private boolean zzGh;
    private final String zzHP;
    private final zzhv zzHQ;
    private BigInteger zzHR;
    private final HashSet zzHS = new HashSet();
    private final HashMap zzHT = new HashMap();
    private boolean zzHU;
    private int zzHV;
    private zzca zzHW;
    private zzbk zzHX;
    private final LinkedList zzHY = new LinkedList();
    private Boolean zzHZ;
    private String zzIa;
    private boolean zzIb;
    private boolean zzIc;
    private zzay zzov;
    private boolean zzpA;
    private VersionInfoParcel zzpb;
    private final Object zzpd = new Object();
    private zzbj zzsa;
    private zzbi zzsb;
    private final zzgq zzsc = null;

    public zzhu(zzid zzid1)
    {
        zzHR = BigInteger.ONE;
        zzHU = false;
        zzGg = true;
        zzHV = 0;
        zzpA = false;
        zzHW = null;
        zzGh = true;
        zzsa = null;
        zzHX = null;
        zzsb = null;
        zzHZ = null;
        zzIb = false;
        zzIc = false;
        zzHP = zzid1.zzgD();
        zzHQ = new zzhv(zzHP);
    }

    public String getSessionId()
    {
        return zzHP;
    }

    public void zzA(boolean flag)
    {
        synchronized (zzpd)
        {
            zzGh = flag;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzB(boolean flag)
    {
        synchronized (zzpd)
        {
            zzIb = flag;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public zzbk zzE(Context context)
    {
label0:
        {
            if (!((Boolean)zzby.zzuT.get()).booleanValue() || !zzmx.zzqx() || zzgl())
            {
                return null;
            }
            synchronized (zzpd)
            {
                if (zzsa != null)
                {
                    break MISSING_BLOCK_LABEL_77;
                }
                if (context instanceof Activity)
                {
                    break label0;
                }
            }
            return null;
        }
        zzsa = new zzbj((Application)context.getApplicationContext(), (Activity)context);
        if (zzsb == null)
        {
            zzsb = new zzbi();
        }
        if (zzHX == null)
        {
            zzHX = new zzbk(zzsa, zzsb, new zzgq(mContext, zzpb, null, null));
        }
        zzHX.zzct();
        context = zzHX;
        obj;
        JVM INSTR monitorexit ;
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public Bundle zza(Context context, zzhw zzhw1, String s)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        Bundle bundle;
        bundle = new Bundle();
        bundle.putBundle("app", zzHQ.zze(context, s));
        context = new Bundle();
        String s1;
        for (s = zzHT.keySet().iterator(); s.hasNext(); context.putBundle(s1, ((zzhx)zzHT.get(s1)).toBundle()))
        {
            s1 = (String)s.next();
        }

        break MISSING_BLOCK_LABEL_105;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
        bundle.putBundle("slots", context);
        context = new ArrayList();
        for (s = zzHS.iterator(); s.hasNext(); context.add(((zzht)s.next()).toBundle())) { }
        bundle.putParcelableArrayList("ads", context);
        zzhw1.zza(zzHS);
        zzHS.clear();
        obj;
        JVM INSTR monitorexit ;
        return bundle;
    }

    public Future zza(Context context, boolean flag)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (flag == zzGg)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        zzGg = flag;
        context = zzib.zza(context, flag);
        return context;
        obj;
        JVM INSTR monitorexit ;
        return null;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void zza(zzht zzht1)
    {
        synchronized (zzpd)
        {
            zzHS.add(zzht1);
        }
        return;
        zzht1;
        obj;
        JVM INSTR monitorexit ;
        throw zzht1;
    }

    public void zza(String s, zzhx zzhx1)
    {
        synchronized (zzpd)
        {
            zzHT.put(s, zzhx1);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void zza(Thread thread)
    {
        com.google.android.gms.internal.zzgq.zza(mContext, thread, zzpb);
    }

    public void zzb(Context context, VersionInfoParcel versioninfoparcel)
    {
        synchronized (zzpd)
        {
            if (!zzpA)
            {
                mContext = context.getApplicationContext();
                zzpb = versioninfoparcel;
                zzib.zza(context, this);
                com.google.android.gms.internal.zzib.zzb(context, this);
                zza(Thread.currentThread());
                zzIa = zzp.zzbv().zzf(context, versioninfoparcel.zzJu);
                if (zzmx.zzqE() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted())
                {
                    zzIc = true;
                }
                zzov = new zzay(context.getApplicationContext(), zzpb, new zzdz(context.getApplicationContext(), zzpb, (String)zzby.zzul.get()));
                zzgw();
                zzp.zzbF().zzx(mContext);
                zzpA = true;
            }
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void zzb(Boolean boolean1)
    {
        synchronized (zzpd)
        {
            zzHZ = boolean1;
        }
        return;
        boolean1;
        obj;
        JVM INSTR monitorexit ;
        throw boolean1;
    }

    public void zzb(HashSet hashset)
    {
        synchronized (zzpd)
        {
            zzHS.addAll(hashset);
        }
        return;
        hashset;
        obj;
        JVM INSTR monitorexit ;
        throw hashset;
    }

    public void zzc(Throwable throwable, boolean flag)
    {
        (new zzgq(mContext, zzpb, null, null)).zza(throwable, flag);
    }

    public String zzd(int i, String s)
    {
        Resources resources;
        if (zzpb.zzJx)
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

    public void zzd(Bundle bundle)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (!bundle.containsKey("use_https")) goto _L2; else goto _L1
_L1:
        boolean flag = bundle.getBoolean("use_https");
_L5:
        zzGg = flag;
        if (!bundle.containsKey("webview_cache_version")) goto _L4; else goto _L3
_L3:
        int i = bundle.getInt("webview_cache_version");
_L6:
        zzHV = i;
        return;
_L2:
        flag = zzGg;
          goto _L5
_L4:
        i = zzHV;
          goto _L6
        bundle;
        obj;
        JVM INSTR monitorexit ;
        throw bundle;
          goto _L5
    }

    public boolean zzgl()
    {
        boolean flag;
        synchronized (zzpd)
        {
            flag = zzGh;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String zzgm()
    {
        String s;
        synchronized (zzpd)
        {
            s = zzHR.toString();
            zzHR = zzHR.add(BigInteger.ONE);
        }
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public zzhv zzgn()
    {
        zzhv zzhv1;
        synchronized (zzpd)
        {
            zzhv1 = zzHQ;
        }
        return zzhv1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public zzca zzgo()
    {
        zzca zzca;
        synchronized (zzpd)
        {
            zzca = zzHW;
        }
        return zzca;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean zzgp()
    {
        boolean flag;
        synchronized (zzpd)
        {
            flag = zzHU;
            zzHU = true;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean zzgq()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (zzGg || zzIc)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String zzgr()
    {
        String s;
        synchronized (zzpd)
        {
            s = zzIa;
        }
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Boolean zzgs()
    {
        Boolean boolean1;
        synchronized (zzpd)
        {
            boolean1 = zzHZ;
        }
        return boolean1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public zzay zzgt()
    {
        return zzov;
    }

    public boolean zzgu()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (zzHV >= ((Integer)zzby.zzvh.get()).intValue())
        {
            break MISSING_BLOCK_LABEL_58;
        }
        zzHV = ((Integer)zzby.zzvh.get()).intValue();
        zzib.zza(mContext, zzHV);
        return true;
        obj;
        JVM INSTR monitorexit ;
        return false;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean zzgv()
    {
        boolean flag;
        synchronized (zzpd)
        {
            flag = zzIb;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void zzgw()
    {
        zzbz zzbz1 = new zzbz(mContext, zzpb.zzJu);
        try
        {
            zzHW = zzp.zzbA().zza(zzbz1);
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Cannot initialize CSI reporter.", illegalargumentexception);
        }
    }
}
