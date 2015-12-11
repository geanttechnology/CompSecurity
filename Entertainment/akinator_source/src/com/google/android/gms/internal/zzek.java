// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzec, zzeh, zzcg, zzed, 
//            zzei, zzid, zzem, zzee

public class zzek
    implements zzec
{

    private final Context mContext;
    private final zzcg zzoo;
    private final zzem zzox;
    private final Object zzpd = new Object();
    private final zzee zzzA;
    private final long zzzB;
    private final long zzzC;
    private boolean zzzD;
    private zzeh zzzE;
    private final boolean zzzn;
    private final AdRequestInfoParcel zzzz;

    public zzek(Context context, AdRequestInfoParcel adrequestinfoparcel, zzem zzem, zzee zzee, boolean flag, long l, 
            long l1, zzcg zzcg1)
    {
        zzzD = false;
        mContext = context;
        zzzz = adrequestinfoparcel;
        zzox = zzem;
        zzzA = zzee;
        zzzn = flag;
        zzzB = l;
        zzzC = l1;
        zzoo = zzcg1;
    }

    public void cancel()
    {
        synchronized (zzpd)
        {
            zzzD = true;
            if (zzzE != null)
            {
                zzzE.cancel();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public zzei zzc(List list)
    {
        zzce zzce;
        Iterator iterator;
        zzb.zzaF("Starting mediation.");
        obj = new ArrayList();
        zzce = zzoo.zzdn();
        iterator = list.iterator();
_L4:
        zzed zzed1;
        Iterator iterator1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_376;
        }
        zzed1 = (zzed)iterator.next();
        zzb.zzaG((new StringBuilder()).append("Trying mediation network: ").append(zzed1.zzyN).toString());
        iterator1 = zzed1.zzyO.iterator();
_L2:
        String s;
        zzce zzce1;
label0:
        {
            if (!iterator1.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            s = (String)iterator1.next();
            zzce1 = zzoo.zzdn();
            synchronized (zzpd)
            {
                if (!zzzD)
                {
                    break label0;
                }
                obj = new zzei(-1);
            }
            return ((zzei) (obj));
        }
        zzzE = new zzeh(mContext, s, zzox, zzzA, zzed1, zzzz.zzEn, zzzz.zzqn, zzzz.zzqj, zzzn, zzzz.zzqB, zzzz.zzqD);
        list;
        JVM INSTR monitorexit ;
        list = zzzE.zza(zzzB, zzzC);
        if (((zzei) (list)).zzzt == 0)
        {
            zzb.zzaF("Adapter succeeded.");
            zzoo.zze("mediation_network_succeed", s);
            if (!((List) (obj)).isEmpty())
            {
                zzoo.zze("mediation_networks_fail", TextUtils.join(",", ((Iterable) (obj))));
            }
            zzoo.zza(zzce1, new String[] {
                "mls"
            });
            zzoo.zza(zzce, new String[] {
                "ttm"
            });
            return list;
        }
        break MISSING_BLOCK_LABEL_322;
        obj;
        list;
        JVM INSTR monitorexit ;
        throw obj;
        ((List) (obj)).add(s);
        zzoo.zza(zzce1, new String[] {
            "mlf"
        });
        if (((zzei) (list)).zzzv != null)
        {
            zzid.zzIE.post(new _cls1(list));
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (true) goto _L4; else goto _L3
_L3:
        if (!((List) (obj)).isEmpty())
        {
            zzoo.zze("mediation_networks_fail", TextUtils.join(",", ((Iterable) (obj))));
        }
        return new zzei(1);
    }

    /* member class not found */
    class _cls1 {}

}
