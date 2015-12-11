// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.HashSet;

// Referenced classes of package com.amazon.device.ads:
//            at, bb, cl, cm, 
//            bg

final class aj
{
    static final class a
    {

        private final HashSet a = new HashSet();
        private boolean b;

        static float a()
        {
            return cm.a().b.g;
        }

        final boolean a(Context context)
        {
            HashSet hashset;
            if (b)
            {
                return true;
            }
            hashset = new HashSet();
            int j;
            if (!at.a(8))
            {
                break MISSING_BLOCK_LABEL_100;
            }
            String s = at.a(context);
            context = context.getPackageManager().getPackageArchiveInfo(s, 1).activities;
            j = context.length;
            int i = 0;
_L2:
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            hashset.add(((ActivityInfo) (context[i])).name);
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            boolean flag;
            b = hashset.containsAll(a);
            flag = b;
            return flag;
            context;
            b = true;
            return true;
        }

        a()
        {
            b = false;
            a.add("com.amazon.device.ads.AdActivity");
        }
    }


    private static a a = new a();

    public static double a(double d)
    {
        if (at.a(19))
        {
            d = 1.0D;
        }
        return d;
    }

    public static double a(int i, int j, int k, int l)
    {
        double d;
label0:
        {
            double d1 = (double)k / (double)i;
            double d3 = (double)l / (double)j;
            if (d3 >= d1)
            {
                d = d1;
                if (d1 != 0.0D)
                {
                    break label0;
                }
            }
            d = d1;
            if (d3 != 0.0D)
            {
                d = d3;
            }
        }
        double d2 = d;
        if (d == 0.0D)
        {
            d2 = 1.0D;
        }
        return d2;
    }

    public static float a()
    {
        return a.a();
    }

    public static int a(int i)
    {
        return (int)((float)i / a.a());
    }

    static void a(bb bb1, cl cl1)
    {
        if (bb1 != null)
        {
            if ("Wifi".equals(bb1.a))
            {
                cl1.a(ck.a.W);
            } else
            {
                cl1.a(ck.a.Y, bb1.a);
            }
        }
        bb1 = cm.a().b;
        if (((bg) (bb1)).h != null)
        {
            cl1.a(ck.a.X, ((bg) (bb1)).h);
        }
    }

    static boolean a(Context context)
    {
        return a.a(context);
    }

    public static int b(int i)
    {
        return (int)((float)i * a.a());
    }

}
