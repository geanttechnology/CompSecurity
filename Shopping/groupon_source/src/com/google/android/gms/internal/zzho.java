// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzac, zzl, zzhv, zzhs, 
//            zzr, zzab, zza

public class zzho
{
    public static interface zza
    {
    }

    private class zzc extends zzhs
        implements zzm.zzb
    {

        final zzho zzGx;

        public void zzb(Object obj)
        {
            super.zzf(obj);
        }

        private zzc()
        {
            zzGx = zzho.this;
            super();
        }

    }


    private static zzl zzGu;
    public static final zza zzGv = new zza() {

    };
    private static final Object zzoW = new Object();

    public zzho(Context context)
    {
        zzGu = zzN(context);
    }

    private static zzl zzN(Context context)
    {
        synchronized (zzoW)
        {
            if (zzGu == null)
            {
                zzGu = zzac.zza(context.getApplicationContext());
            }
            context = zzGu;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public zzhv zzb(String s, Map map)
    {
        zzc zzc1 = new zzc();
        s = new zzab(s, zzc1, new zzm.zza(s, zzc1) {

            final zzc zzGw;
            final zzho zzGx;
            final String zzwJ;

            public void zze(zzr zzr1)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC((new StringBuilder()).append("Failed to load URL: ").append(zzwJ).append("\n").append(zzr1.toString()).toString());
                zzGw.zzb(null);
            }

            
            {
                zzGx = zzho.this;
                zzwJ = s;
                zzGw = zzc1;
                super();
            }
        }, map) {

            final zzho zzGx;
            final Map zzGy;

            public Map getHeaders()
                throws com.google.android.gms.internal.zza
            {
                if (zzGy == null)
                {
                    return super.getHeaders();
                } else
                {
                    return zzGy;
                }
            }

            
            {
                zzGx = zzho.this;
                zzGy = map;
                super(s, zzb1, zza1);
            }
        };
        zzGu.zze(s);
        return zzc1;
    }

}
