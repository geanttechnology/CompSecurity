// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzc, zzal, zzf, zzp

class > extends zzc
    implements >
{

    private final zzal zzPI = new zzal();

    public void zzc(String s, boolean flag)
    {
        boolean flag1 = true;
        boolean flag2 = true;
        int i = 1;
        if ("ga_autoActivityTracking".equals(s))
        {
            s = zzPI;
            if (!flag)
            {
                i = 0;
            }
            s.zzPL = i;
            return;
        }
        if ("ga_anonymizeIp".equals(s))
        {
            s = zzPI;
            int j;
            if (flag)
            {
                j = ((flag1) ? 1 : 0);
            } else
            {
                j = 0;
            }
            s.zzPM = j;
            return;
        }
        if ("ga_reportUncaughtExceptions".equals(s))
        {
            s = zzPI;
            int k;
            if (flag)
            {
                k = ((flag2) ? 1 : 0);
            } else
            {
                k = 0;
            }
            s.zzPN = k;
            return;
        } else
        {
            zzd("bool configuration name not recognized", s);
            return;
        }
    }

    public void zzd(String s, int i)
    {
        if ("ga_sessionTimeout".equals(s))
        {
            zzPI.zzPK = i;
            return;
        } else
        {
            zzd("int configuration name not recognized", s);
            return;
        }
    }

    public zzp zzjz()
    {
        return zzlb();
    }

    public void zzl(String s, String s1)
    {
        zzPI.zzPO.put(s, s1);
    }

    public zzal zzlb()
    {
        return zzPI;
    }

    public void zzm(String s, String s1)
    {
        if ("ga_trackingId".equals(s))
        {
            zzPI.zzLq = s1;
            return;
        }
        if ("ga_sampleFrequency".equals(s))
        {
            try
            {
                zzPI.zzPJ = Double.parseDouble(s1);
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

    public (zzf zzf)
    {
        super(zzf);
    }
}
