// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzac, zzl, zziq

public class zzih
{

    private static zzl zzIZ;
    public static final zza zzJa = new _cls1();
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
        zzc zzc1 = new zzc(null);
        zzIZ.zze(new zzb(s, zza1, zzc1));
        return zzc1;
    }

    public zziq zza(String s, Map map)
    {
        zzc zzc1 = new zzc(null);
        s = new _cls3(s, zzc1, new _cls2(s, zzc1), map);
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

        zzc(_cls1 _pcls1)
        {
            this();
        }
    }


    private class zzb extends zzk
    {

        private final zza zzJe;
        private final zzm.zzb zzaG;

        protected zzm zza(zzi zzi1)
        {
            return zzm.zza(new ByteArrayInputStream(zzi1.data), zzx.zzb(zzi1));
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
            class _cls1
                implements zzm.zza
            {

                final zzm.zzb zzJf;
                final zza zzJg;

                public void zze(zzr zzr)
                {
                    zzJf.zzb(zzJg.zzfF());
                }

                _cls1(zzm.zzb zzb1, zza zza1)
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

            }

            super(0, s, new _cls1(zzb1, zza1));
            zzJe = zza1;
            zzaG = zzb1;
        }
    }


    private class _cls3 extends zzab
    {

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

        _cls3(String s, zzm.zzb zzb1, zzm.zza zza1, Map map)
        {
            zzJc = zzih.this;
            zzJd = map;
            super(s, zzb1, zza1);
        }
    }


    private class _cls2
        implements zzm.zza
    {

        final zzc zzJb;
        final zzih zzJc;
        final String zzyc;

        public void zze(zzr zzr1)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder("Failed to load URL: ")).append(zzyc).append("\n").append(zzr1.toString()).toString());
            zzJb.zzb(null);
        }

        _cls2(String s, zzc zzc1)
        {
            zzJc = zzih.this;
            zzyc = s;
            zzJb = zzc1;
            super();
        }
    }


    private class _cls1
        implements zza
    {

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

        _cls1()
        {
        }
    }

}
