// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

// Referenced classes of package com.google.android.gms.internal:
//            zzba, zzhs, zziz, zzaz, 
//            zzdz

public class zzay
    implements zzba
{

    private final VersionInfoParcel zzpb;
    private final Object zzpd = new Object();
    private final WeakHashMap zzqX = new WeakHashMap();
    private final ArrayList zzqY = new ArrayList();
    private final Context zzqZ;
    private final zzdz zzra;

    public zzay(Context context, VersionInfoParcel versioninfoparcel, zzdz zzdz)
    {
        zzqZ = context.getApplicationContext();
        zzpb = versioninfoparcel;
        zzra = zzdz;
    }

    public zzaz zza(AdSizeParcel adsizeparcel, zzhs zzhs1)
    {
        return zza(adsizeparcel, zzhs1, zzhs1.zzBD.getView());
    }

    public zzaz zza(AdSizeParcel adsizeparcel, zzhs zzhs1, View view)
    {
label0:
        {
            synchronized (zzpd)
            {
                if (!zzd(zzhs1))
                {
                    break label0;
                }
                adsizeparcel = (zzaz)zzqX.get(zzhs1);
            }
            return adsizeparcel;
        }
        adsizeparcel = new zzaz(adsizeparcel, zzhs1, zzpb, view, zzra);
        adsizeparcel.zza(this);
        zzqX.put(zzhs1, adsizeparcel);
        zzqY.add(adsizeparcel);
        obj;
        JVM INSTR monitorexit ;
        return adsizeparcel;
        adsizeparcel;
        obj;
        JVM INSTR monitorexit ;
        throw adsizeparcel;
    }

    public void zza(zzaz zzaz1)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (!zzaz1.zzcd())
        {
            zzqY.remove(zzaz1);
            Iterator iterator = zzqX.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                if (((java.util.Map.Entry)iterator.next()).getValue() == zzaz1)
                {
                    iterator.remove();
                }
            } while (true);
        }
        break MISSING_BLOCK_LABEL_77;
        zzaz1;
        obj;
        JVM INSTR monitorexit ;
        throw zzaz1;
        obj;
        JVM INSTR monitorexit ;
    }

    public boolean zzd(zzhs zzhs1)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        zzhs1 = (zzaz)zzqX.get(zzhs1);
        if (zzhs1 == null) goto _L2; else goto _L1
_L1:
        if (!zzhs1.zzcd()) goto _L2; else goto _L3
_L3:
        boolean flag = true;
_L5:
        obj;
        JVM INSTR monitorexit ;
        return flag;
        zzhs1;
        obj;
        JVM INSTR monitorexit ;
        throw zzhs1;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void zze(zzhs zzhs1)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        zzhs1 = (zzaz)zzqX.get(zzhs1);
        if (zzhs1 == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        zzhs1.zzcb();
        obj;
        JVM INSTR monitorexit ;
        return;
        zzhs1;
        obj;
        JVM INSTR monitorexit ;
        throw zzhs1;
    }

    public void zzf(zzhs zzhs1)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        zzhs1 = (zzaz)zzqX.get(zzhs1);
        if (zzhs1 == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        zzhs1.stop();
        obj;
        JVM INSTR monitorexit ;
        return;
        zzhs1;
        obj;
        JVM INSTR monitorexit ;
        throw zzhs1;
    }

    public void zzg(zzhs zzhs1)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        zzhs1 = (zzaz)zzqX.get(zzhs1);
        if (zzhs1 == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        zzhs1.pause();
        obj;
        JVM INSTR monitorexit ;
        return;
        zzhs1;
        obj;
        JVM INSTR monitorexit ;
        throw zzhs1;
    }

    public void zzh(zzhs zzhs1)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        zzhs1 = (zzaz)zzqX.get(zzhs1);
        if (zzhs1 == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        zzhs1.resume();
        obj;
        JVM INSTR monitorexit ;
        return;
        zzhs1;
        obj;
        JVM INSTR monitorexit ;
        throw zzhs1;
    }
}
