// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.b;

import com.google.a.a.f;

// Referenced classes of package com.target.ui.analytics.b:
//            a

public class c extends com.target.ui.analytics.b.a
{
    public static class a
    {

        private static final int UNSET = -1;
        private int daysSinceFirstUse;
        private int daysSinceLastUpgrade;
        private int daysSinceLastUse;
        private int engagedDaysLifetime;
        private int engagedDaysSinceUpgrade;
        private int engagedDaysThisMonth;

        private void b()
        {
            int ai[] = new int[6];
            ai[0] = engagedDaysLifetime;
            ai[1] = engagedDaysThisMonth;
            ai[2] = engagedDaysSinceUpgrade;
            ai[3] = daysSinceFirstUse;
            ai[4] = daysSinceLastUse;
            ai[5] = daysSinceLastUpgrade;
            int j = ai.length;
            int i = 0;
            while (i < j) 
            {
                int k = ai[i];
                boolean flag;
                if (k >= 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                com.google.a.a.f.a(flag, (new StringBuilder()).append("One or more fields unset or invalid.  Bad value: ").append(k).toString());
                i++;
            }
        }

        public a a(int i)
        {
            engagedDaysLifetime = i;
            return this;
        }

        public c a()
        {
            b();
            return new c(engagedDaysLifetime, engagedDaysThisMonth, engagedDaysSinceUpgrade, daysSinceFirstUse, daysSinceLastUse, daysSinceLastUpgrade);
        }

        public a b(int i)
        {
            engagedDaysThisMonth = i;
            return this;
        }

        public a c(int i)
        {
            engagedDaysSinceUpgrade = i;
            return this;
        }

        public a d(int i)
        {
            daysSinceFirstUse = i;
            return this;
        }

        public a e(int i)
        {
            daysSinceLastUse = i;
            return this;
        }

        public a f(int i)
        {
            daysSinceLastUpgrade = i;
            return this;
        }

        private a()
        {
            engagedDaysLifetime = -1;
            engagedDaysThisMonth = -1;
            engagedDaysSinceUpgrade = -1;
            daysSinceFirstUse = -1;
            daysSinceLastUse = -1;
            daysSinceLastUpgrade = -1;
        }

    }


    public final int daysSinceFirstUse;
    public final int daysSinceLastUpgrade;
    public final int daysSinceLastUse;
    public final int engagedDaysLifetime;
    public final int engagedDaysSinceUpgrade;
    public final int engagedDaysThisMonth;

    private c(int i, int j, int k, int l, int i1, int j1)
    {
        engagedDaysLifetime = i;
        engagedDaysThisMonth = j;
        engagedDaysSinceUpgrade = k;
        daysSinceFirstUse = l;
        daysSinceLastUse = i1;
        daysSinceLastUpgrade = j1;
    }


    public static a b()
    {
        return new a();
    }
}
