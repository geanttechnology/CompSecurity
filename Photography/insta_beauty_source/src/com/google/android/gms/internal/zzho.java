// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzac, zzl, zzhv

public class zzho
{

    private static zzl zzGu;
    public static final zza zzGv = new _cls1();
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

    public zzhv zza(String s, zza zza1)
    {
        zzc zzc1 = new zzc(null);
        zzGu.zze(new zzb(s, zza1, zzc1));
        return zzc1;
    }

    public zzhv zzb(String s, Map map)
    {
        zzc zzc1 = new zzc(null);
        s = new _cls3(s, zzc1, new _cls2(s, zzc1), map);
        zzGu.zze(s);
        return zzc1;
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

        zzc(_cls1 _pcls1)
        {
            this();
        }
    }


    private class zzb extends zzk
    {

        private final zza zzGz;
        private final zzm.zzb zzaH;

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
            zzaH.zzb(zzGz.zzh(inputstream));
        }

        public zzb(String s, zza zza1, zzm.zzb zzb1)
        {
            class _cls1
                implements zzm.zza
            {

                final zzm.zzb zzGA;
                final zza zzGB;

                public void zze(zzr zzr)
                {
                    zzGA.zzb(zzGB.zzft());
                }

                _cls1(zzm.zzb zzb1, zza zza1)
                {
                    zzGA = zzb1;
                    zzGB = zza1;
                    super();
                }

                private class zza
                {

                    public abstract Object zzft();

                    public abstract Object zzh(InputStream inputstream);
                }

            }

            super(0, s, new _cls1(zzb1, zza1));
            zzGz = zza1;
            zzaH = zzb1;
        }
    }


    private class _cls3 extends zzab
    {

        final zzho zzGx;
        final Map zzGy;

        public Map getHeaders()
        {
            if (zzGy == null)
            {
                return super.getHeaders();
            } else
            {
                return zzGy;
            }
        }

        _cls3(String s, zzm.zzb zzb1, zzm.zza zza1, Map map)
        {
            zzGx = zzho.this;
            zzGy = map;
            super(s, zzb1, zza1);
        }
    }


    private class _cls2
        implements zzm.zza
    {

        final zzc zzGw;
        final zzho zzGx;
        final String zzwJ;

        public void zze(zzr zzr1)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC((new StringBuilder()).append("Failed to load URL: ").append(zzwJ).append("\n").append(zzr1.toString()).toString());
            zzGw.zzb(null);
        }

        _cls2(String s, zzc zzc1)
        {
            zzGx = zzho.this;
            zzwJ = s;
            zzGw = zzc1;
            super();
        }
    }


    private class _cls1
        implements zza
    {

        public Object zzft()
        {
            return zzgu();
        }

        public Void zzgu()
        {
            return null;
        }

        public Object zzh(InputStream inputstream)
        {
            return zzi(inputstream);
        }

        public Void zzi(InputStream inputstream)
        {
            return null;
        }

        _cls1()
        {
        }
    }

}
