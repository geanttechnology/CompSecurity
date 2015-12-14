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
        this(zza1, new zza(zzid.zzIE));
    }

    zzo(com.google.android.gms.ads.internal.zza zza1, zza zza2)
    {
        zzpI = false;
        zzpJ = false;
        zzpK = 0L;
        zzpG = zza2;
        zzx = new Runnable(new WeakReference(zza1)) {

            final WeakReference zzpL;
            final zzo zzpM;

            public void run()
            {
                zzo.zza(zzpM, false);
                com.google.android.gms.ads.internal.zza zza3 = (com.google.android.gms.ads.internal.zza)zzpL.get();
                if (zza3 != null)
                {
                    zza3.zzd(zzo.zza(zzpM));
                }
            }

            
            {
                zzpM = zzo.this;
                zzpL = weakreference;
                super();
            }
        };
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
                zzb.zzaG((new StringBuilder("Scheduling ad refresh ")).append(l).append(" milliseconds from now.").toString());
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

    private class zza
    {

        private final Handler mHandler;

        public boolean postDelayed(Runnable runnable, long l)
        {
            return mHandler.postDelayed(runnable, l);
        }

        public void removeCallbacks(Runnable runnable)
        {
            mHandler.removeCallbacks(runnable);
        }

        public zza(Handler handler)
        {
            mHandler = handler;
        }
    }

}
