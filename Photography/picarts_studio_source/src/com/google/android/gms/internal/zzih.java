// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.io.InputStream;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzac, zzl, zziq, zzr, 
//            zzab

public class zzih
{

    private static zzl zzIZ;
    public static final zza zzJa = new zza() {

        public final Object zzfF()
        {
            return zzgL();
        }

        public final Void zzgL()
        {
            return null;
        }

        public final Object zzh(InputStream inputstream)
        {
            return zzi(inputstream);
        }

        public final Void zzi(InputStream inputstream)
        {
            return null;
        }

    };
    private static final Object zzpy = new Object();

    public zzih(Context context)
    {
        zzIZ = zzP(context);
    }

    private static zzl zzP(Context context)
    {
        synchronized (zzpy)
        {
            if (zzIZ == null)
            {
                zzIZ = zzac.zza(context.getApplicationContext());
            }
            context = zzIZ;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public zziq zza(String s, zza zza1)
    {
        zzc zzc1 = new zzc();
        zzIZ.zze(new zzb(s, zza1, zzc1));
        return zzc1;
    }

    public zziq zza(String s, Map map)
    {
        zzc zzc1 = new zzc();
        s = new zzab(s, zzc1, new zzm.zza(s, zzc1) {

            final zzc zzJb;
            final zzih zzJc;
            final String zzyc;

            public void zze(zzr zzr1)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder("Failed to load URL: ")).append(zzyc).append("\n").append(zzr1.toString()).toString());
                zzJb.zzb(null);
            }

            
            {
                zzJc = zzih.this;
                zzyc = s;
                zzJb = zzc;
                super();
            }
        }, map) {

            final zzih zzJc;
            final Map zzJd;

            public Map getHeaders()
            {
                if (zzJd == null)
                {
                    return super.getHeaders();
                } else
                {
                    return zzJd;
                }
            }

            
            {
                zzJc = zzih.this;
                zzJd = map;
                super(s, zzb, zza1);
            }
        };
        zzIZ.zze(s);
        return zzc1;
    }


    private class zzc extends zzin
        implements zzm.zzb
    {

        final zzih zzJc;

        public void zzb(Object obj)
        {
            super.zzf(obj);
        }

        private zzc()
        {
            zzJc = zzih.this;
            super();
        }

    }


    private class zzb extends zzk
    {

        private final zza zzJe;
        private final zzm.zzb zzaG;

        protected zzm zza(zzi zzi1)
        {
            return zzm.zza(new ByteArrayInputStream(zzi1.data), com.google.android.gms.internal.zzx.zzb(zzi1));
        }

        protected void zza(Object obj)
        {
            zzj((InputStream)obj);
        }

        protected void zzj(InputStream inputstream)
        {
            zzaG.zzb(zzJe.zzh(inputstream));
        }

        public zzb(String s, zza zza1, zzm.zzb zzb1)
        {
            super(0, s, new zzm.zza(zzb1, zza1) {

                final zzm.zzb zzJf;
                final zza zzJg;

                public void zze(zzr zzr)
                {
                    zzJf.zzb(zzJg.zzfF());
                }

                
                {
                    zzJf = zzb1;
                    zzJg = zza1;
                    super();
                }

                private class zza
                {

                    public abstract Object zzfF();

                    public abstract Object zzh(InputStream inputstream);
                }

            });
            zzJe = zza1;
            zzaG = zzb1;
        }
    }

}
