// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzbh

public class zzbi
{

    private final Object zzpd = new Object();
    private int zzrX;
    private List zzrY;

    public zzbi()
    {
        zzrY = new LinkedList();
    }

    public boolean zza(zzbh zzbh1)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (zzrY.contains(zzbh1))
        {
            return true;
        }
        obj;
        JVM INSTR monitorexit ;
        return false;
        zzbh1;
        obj;
        JVM INSTR monitorexit ;
        throw zzbh1;
    }

    public boolean zzb(zzbh zzbh1)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = zzrY.iterator();
_L2:
        zzbh zzbh2;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_68;
            }
            zzbh2 = (zzbh)iterator.next();
        } while (zzbh1 == zzbh2);
        if (!zzbh2.zzcm().equals(zzbh1.zzcm())) goto _L2; else goto _L1
_L1:
        iterator.remove();
        obj;
        JVM INSTR monitorexit ;
        return true;
        obj;
        JVM INSTR monitorexit ;
        return false;
        zzbh1;
        obj;
        JVM INSTR monitorexit ;
        throw zzbh1;
    }

    public void zzc(zzbh zzbh1)
    {
        synchronized (zzpd)
        {
            if (zzrY.size() >= 10)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaF((new StringBuilder()).append("Queue is full, current size = ").append(zzrY.size()).toString());
                zzrY.remove(0);
            }
            int i = zzrX;
            zzrX = i + 1;
            zzbh1.zzg(i);
            zzrY.add(zzbh1);
        }
        return;
        zzbh1;
        obj;
        JVM INSTR monitorexit ;
        throw zzbh1;
    }

    public zzbh zzcs()
    {
        zzbh zzbh1;
label0:
        {
            zzbh1 = null;
            synchronized (zzpd)
            {
                if (zzrY.size() != 0)
                {
                    break label0;
                }
                com.google.android.gms.ads.internal.util.client.zzb.zzaF("Queue empty");
            }
            return null;
        }
        if (zzrY.size() < 2)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        int i = 0x80000000;
        Iterator iterator = zzrY.iterator();
_L1:
        zzbh zzbh2;
        int j;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_101;
        }
        zzbh2 = (zzbh)iterator.next();
        j = zzbh2.getScore();
        if (j > i)
        {
            zzbh1 = zzbh2;
            i = j;
        }
          goto _L1
        zzrY.remove(zzbh1);
        obj;
        JVM INSTR monitorexit ;
        return zzbh1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        exception = (zzbh)zzrY.get(0);
        exception.zzcn();
        obj;
        JVM INSTR monitorexit ;
        return exception;
    }
}
