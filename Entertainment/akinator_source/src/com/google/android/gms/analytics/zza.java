// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzk;
import com.google.android.gms.analytics.internal.zzn;
import com.google.android.gms.analytics.internal.zzu;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.measurement.zzc;
import com.google.android.gms.measurement.zzf;
import com.google.android.gms.measurement.zzi;
import java.util.List;
import java.util.ListIterator;

// Referenced classes of package com.google.android.gms.analytics:
//            zzb

public class zza extends zzf
{

    private final com.google.android.gms.analytics.internal.zzf zzLf;
    private boolean zzLg;

    public zza(com.google.android.gms.analytics.internal.zzf zzf1)
    {
        super(zzf1.zziw(), zzf1.zzit());
        zzLf = zzf1;
    }

    public void enableAdvertisingIdCollection(boolean flag)
    {
        zzLg = flag;
    }

    protected void zza(zzc zzc1)
    {
        zzc1 = (zzjo)zzc1.zze(com/google/android/gms/internal/zzjo);
        if (TextUtils.isEmpty(zzc1.getClientId()))
        {
            zzc1.setClientId(zzLf.zziL().zzjt());
        }
        if (zzLg && TextUtils.isEmpty(zzc1.zzib()))
        {
            com.google.android.gms.analytics.internal.zza zza1 = zzLf.zziK();
            zzc1.zzaV(zza1.zzig());
            zzc1.zzG(zza1.zzic());
        }
    }

    public void zzaP(String s)
    {
        zzx.zzcr(s);
        zzaQ(s);
        zzyq().add(new zzb(zzLf, s));
    }

    public void zzaQ(String s)
    {
        s = zzb.zzaR(s);
        ListIterator listiterator = zzyq().listIterator();
        do
        {
            if (!listiterator.hasNext())
            {
                break;
            }
            if (s.equals(((zzi)listiterator.next()).zzhI()))
            {
                listiterator.remove();
            }
        } while (true);
    }

    com.google.android.gms.analytics.internal.zzf zzhF()
    {
        return zzLf;
    }

    public zzc zzhG()
    {
        zzc zzc1 = zzyp().zzye();
        zzc1.zzb(zzLf.zziB().zzjb());
        zzc1.zzb(zzLf.zziC().zzki());
        zzd(zzc1);
        return zzc1;
    }
}
