// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;


// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzq, zzf, zzaa, zzaf, 
//            zzp

public class zzz extends zzq
{
    private static class zza
        implements zzq.zza
    {

        private final zzf zzME;
        private final zzaa zzOY = new zzaa();

        public void zzc(String s, boolean flag)
        {
            if ("ga_dryRun".equals(s))
            {
                s = zzOY;
                int i;
                if (flag)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                s.zzPd = i;
                return;
            } else
            {
                zzME.zziu().zzd("Bool xml configuration name not recognized", s);
                return;
            }
        }

        public void zzd(String s, int i)
        {
            if ("ga_dispatchPeriod".equals(s))
            {
                zzOY.zzPc = i;
                return;
            } else
            {
                zzME.zziu().zzd("Int xml configuration name not recognized", s);
                return;
            }
        }

        public zzp zzjz()
        {
            return zzkn();
        }

        public zzaa zzkn()
        {
            return zzOY;
        }

        public void zzl(String s, String s1)
        {
        }

        public void zzm(String s, String s1)
        {
            if ("ga_appName".equals(s))
            {
                zzOY.zzOZ = s1;
                return;
            }
            if ("ga_appVersion".equals(s))
            {
                zzOY.zzPa = s1;
                return;
            }
            if ("ga_logLevel".equals(s))
            {
                zzOY.zzPb = s1;
                return;
            } else
            {
                zzME.zziu().zzd("String xml configuration name not recognized", s);
                return;
            }
        }

        public zza(zzf zzf1)
        {
            zzME = zzf1;
        }
    }


    public zzz(zzf zzf)
    {
        super(zzf, new zza(zzf));
    }
}
