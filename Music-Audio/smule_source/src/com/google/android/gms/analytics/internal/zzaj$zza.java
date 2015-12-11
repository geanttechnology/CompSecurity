// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzc, zzak, zze, zzo

class > extends zzc
    implements >
{

    private final zzak zzIH = new zzak();

    public void zzc(String s, int i)
    {
        if ("ga_sessionTimeout".equals(s))
        {
            zzIH.zzIJ = i;
            return;
        } else
        {
            zzd("int configuration name not recognized", s);
            return;
        }
    }

    public void zzc(String s, boolean flag)
    {
        boolean flag1 = true;
        boolean flag2 = true;
        int i = 1;
        if ("ga_autoActivityTracking".equals(s))
        {
            s = zzIH;
            if (!flag)
            {
                i = 0;
            }
            s.zzIK = i;
            return;
        }
        if ("ga_anonymizeIp".equals(s))
        {
            s = zzIH;
            int j;
            if (flag)
            {
                j = ((flag1) ? 1 : 0);
            } else
            {
                j = 0;
            }
            s.zzIL = j;
            return;
        }
        if ("ga_reportUncaughtExceptions".equals(s))
        {
            s = zzIH;
            int k;
            if (flag)
            {
                k = ((flag2) ? 1 : 0);
            } else
            {
                k = 0;
            }
            s.zzIM = k;
            return;
        } else
        {
            zzd("bool configuration name not recognized", s);
            return;
        }
    }

    public zzo zzhO()
    {
        return zzjq();
    }

    public void zzj(String s, String s1)
    {
        zzIH.zzIN.put(s, s1);
    }

    public zzak zzjq()
    {
        return zzIH;
    }

    public void zzk(String s, String s1)
    {
        if ("ga_trackingId".equals(s))
        {
            zzIH.zzEm = s1;
            return;
        }
        if ("ga_sampleFrequency".equals(s))
        {
            try
            {
                zzIH.zzII = Double.parseDouble(s1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                zzc("Error parsing ga_sampleFrequency value", s1, s);
            }
            return;
        } else
        {
            zzd("string configuration name not recognized", s);
            return;
        }
    }

    public (zze zze)
    {
        super(zze);
    }
}
