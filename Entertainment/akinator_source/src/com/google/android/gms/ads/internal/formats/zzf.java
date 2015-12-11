// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzcm;
import com.google.android.gms.internal.zzmi;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.google.android.gms.ads.internal.formats:
//            zzh, zza

public class zzf extends com.google.android.gms.internal.zzcu.zza
    implements zzh.zza
{

    private final Object zzpd = new Object();
    private final String zzwA;
    private final zzmi zzwB;
    private final zzmi zzwC;
    private final zza zzww;
    private zzh zzwx;

    public zzf(String s, zzmi zzmi1, zzmi zzmi2, zza zza1)
    {
        zzwA = s;
        zzwB = zzmi1;
        zzwC = zzmi2;
        zzww = zza1;
    }

    public List getAvailableAssetNames()
    {
        boolean flag = false;
        String as[] = new String[zzwB.size() + zzwC.size()];
        int j = 0;
        int i = 0;
        int k;
        int l;
        do
        {
            k = ((flag) ? 1 : 0);
            l = i;
            if (j >= zzwB.size())
            {
                break;
            }
            as[i] = (String)zzwB.keyAt(j);
            i++;
            j++;
        } while (true);
        while (k < zzwC.size()) 
        {
            as[l] = (String)zzwC.keyAt(k);
            k++;
            l++;
        }
        return Arrays.asList(as);
    }

    public String getCustomTemplateId()
    {
        return zzwA;
    }

    public void performClick(String s)
    {
label0:
        {
            synchronized (zzpd)
            {
                if (zzwx != null)
                {
                    break label0;
                }
                zzb.e("Attempt to call performClick before ad initialized.");
            }
            return;
        }
        zzwx.zza(s, null, null);
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void recordImpression()
    {
label0:
        {
            synchronized (zzpd)
            {
                if (zzwx != null)
                {
                    break label0;
                }
                zzb.e("Attempt to perform recordImpression before ad initialized.");
            }
            return;
        }
        zzwx.recordImpression();
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String zzU(String s)
    {
        return (String)zzwC.get(s);
    }

    public zzcm zzV(String s)
    {
        return (zzcm)zzwB.get(s);
    }

    public void zza(zzh zzh1)
    {
        synchronized (zzpd)
        {
            zzwx = zzh1;
        }
        return;
        zzh1;
        obj;
        JVM INSTR monitorexit ;
        throw zzh1;
    }

    public String zzdy()
    {
        return "3";
    }

    public zza zzdz()
    {
        return zzww;
    }
}
