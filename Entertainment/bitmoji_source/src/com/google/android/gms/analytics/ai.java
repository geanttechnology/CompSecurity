// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.content.Context;
import java.util.Map;

// Referenced classes of package com.google.android.gms.analytics:
//            k, aj, aa, j

class ai extends k
{
    private static class a
        implements k.a
    {

        private final aj uJ = new aj();

        public void a(String s, int i)
        {
            if ("ga_sessionTimeout".equals(s))
            {
                uJ.uM = i;
                return;
            } else
            {
                aa.w((new StringBuilder()).append("int configuration name not recognized:  ").append(s).toString());
                return;
            }
        }

        public void a(String s, String s1)
        {
            uJ.uQ.put(s, s1);
        }

        public void b(String s, String s1)
        {
            if ("ga_trackingId".equals(s))
            {
                uJ.uK = s1;
                return;
            }
            if ("ga_sampleFrequency".equals(s))
            {
                try
                {
                    uJ.uL = Double.parseDouble(s1);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    aa.t((new StringBuilder()).append("Error parsing ga_sampleFrequency value: ").append(s1).toString());
                }
                return;
            } else
            {
                aa.w((new StringBuilder()).append("string configuration name not recognized:  ").append(s).toString());
                return;
            }
        }

        public j bz()
        {
            return cA();
        }

        public void c(String s, boolean flag)
        {
            boolean flag1 = true;
            boolean flag2 = true;
            int i = 1;
            if ("ga_autoActivityTracking".equals(s))
            {
                s = uJ;
                if (!flag)
                {
                    i = 0;
                }
                s.uN = i;
                return;
            }
            if ("ga_anonymizeIp".equals(s))
            {
                s = uJ;
                int j;
                if (flag)
                {
                    j = ((flag1) ? 1 : 0);
                } else
                {
                    j = 0;
                }
                s.uO = j;
                return;
            }
            if ("ga_reportUncaughtExceptions".equals(s))
            {
                s = uJ;
                int l;
                if (flag)
                {
                    l = ((flag2) ? 1 : 0);
                } else
                {
                    l = 0;
                }
                s.uP = l;
                return;
            } else
            {
                aa.w((new StringBuilder()).append("bool configuration name not recognized:  ").append(s).toString());
                return;
            }
        }

        public aj cA()
        {
            return uJ;
        }

        public a()
        {
        }
    }


    public ai(Context context)
    {
        super(context, new a());
    }
}
