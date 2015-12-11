// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzid;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zza

public class zzo
{

    private final zza zzpG;
    private AdRequestParcel zzpH;
    private boolean zzpI;
    private boolean zzpJ;
    private long zzpK;
    private final Runnable zzx;

    public zzo(zza zza1)
    {
    /* block-local class not found */
    class zza {}

        this(zza1, new zza(zzid.zzIE));
    }

    zzo(zza zza1, zza zza2)
    {
        zzpI = false;
        zzpJ = false;
        zzpK = 0L;
        zzpG = zza2;
        zzx = new _cls1(new WeakReference(zza1));
    }

    static AdRequestParcel zza(zzo zzo1)
    {
        return zzo1.zzpH;
    }

    static boolean zza(zzo zzo1, boolean flag)
    {
        zzo1.zzpI = flag;
        return flag;
    }

    public void cancel()
    {
        zzpI = false;
        zzpG.removeCallbacks(zzx);
    }

    public void pause()
    {
        zzpJ = true;
        if (zzpI)
        {
            zzpG.removeCallbacks(zzx);
        }
    }

    public void resume()
    {
        zzpJ = false;
        if (zzpI)
        {
            zzpI = false;
            zza(zzpH, zzpK);
        }
    }

    public void zza(AdRequestParcel adrequestparcel, long l)
    {
        if (zzpI)
        {
            zzb.zzaH("An ad refresh is already scheduled.");
        } else
        {
            zzpH = adrequestparcel;
            zzpI = true;
            zzpK = l;
            if (!zzpJ)
            {
                zzb.zzaG((new StringBuilder()).append("Scheduling ad refresh ").append(l).append(" milliseconds from now.").toString());
                zzpG.postDelayed(zzx, l);
                return;
            }
        }
    }

    public boolean zzbp()
    {
        return zzpI;
    }

    public void zzg(AdRequestParcel adrequestparcel)
    {
        zza(adrequestparcel, 60000L);
    }

    /* member class not found */
    class _cls1 {}

}
