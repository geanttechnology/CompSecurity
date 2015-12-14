// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.b;

import android.opengl.GLES10;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.assist.c;

public final class a
{

    private static c a;

    private static int a(int i, int j, int k, boolean flag)
    {
        int l = a.a();
        for (int i1 = a.b(); i / k > l || j / k > i1;)
        {
            if (flag)
            {
                k *= 2;
            } else
            {
                k++;
            }
        }

        return k;
    }

    public static int a(c c1)
    {
        int i = c1.a();
        int j = c1.b();
        int k = a.a();
        int l = a.b();
        return Math.max((int)Math.ceil((float)i / (float)k), (int)Math.ceil((float)j / (float)l));
    }

    public static int a(c c1, c c2, ViewScaleType viewscaletype, boolean flag)
    {
        boolean flag1;
        int l;
        int i1;
        int j1;
        int k1;
        flag1 = true;
        l = c1.a();
        i1 = c1.b();
        j1 = c2.a();
        k1 = c2.b();
        _cls1.a[viewscaletype.ordinal()];
        JVM INSTR tableswitch 1 2: default 56
    //                   1 80
    //                   2 150;
           goto _L1 _L2 _L3
_L1:
        int i = 1;
_L5:
        if (i < 1)
        {
            i = ((flag1) ? 1 : 0);
        }
        return a(l, i1, i, flag);
_L2:
        if (flag)
        {
            int l1 = l / 2;
            int j2 = i1 / 2;
            int j = 1;
            do
            {
                if (l1 / j <= j1)
                {
                    i = j;
                    if (j2 / j <= k1)
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                }
                j *= 2;
            } while (true);
        }
        i = Math.max(l / j1, i1 / k1);
        continue; /* Loop/switch isn't completed */
_L3:
        if (flag)
        {
            int i2 = l / 2;
            int k2 = i1 / 2;
            int k = 1;
            do
            {
                i = k;
                if (i2 / k <= j1)
                {
                    continue; /* Loop/switch isn't completed */
                }
                i = k;
                if (k2 / k <= k1)
                {
                    continue; /* Loop/switch isn't completed */
                }
                k *= 2;
            } while (true);
        }
        i = Math.min(l / j1, i1 / k1);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static c a(com.nostra13.universalimageloader.core.c.a a1, c c1)
    {
        int j = a1.a();
        int i = j;
        if (j <= 0)
        {
            i = c1.a();
        }
        int k = a1.b();
        j = k;
        if (k <= 0)
        {
            j = c1.b();
        }
        return new c(i, j);
    }

    public static float b(c c1, c c2, ViewScaleType viewscaletype, boolean flag)
    {
label0:
        {
            int k = c1.a();
            int l = c1.b();
            int i = c2.a();
            int j = c2.b();
            float f = (float)k / (float)i;
            float f1 = (float)l / (float)j;
            if (viewscaletype == ViewScaleType.a && f >= f1 || viewscaletype == ViewScaleType.b && f < f1)
            {
                j = (int)((float)l / f);
            } else
            {
                i = (int)((float)k / f1);
            }
            f1 = 1.0F;
            if (flag || i >= k || j >= l)
            {
                f = f1;
                if (!flag)
                {
                    break label0;
                }
                f = f1;
                if (i == k)
                {
                    break label0;
                }
                f = f1;
                if (j == l)
                {
                    break label0;
                }
            }
            f = (float)i / (float)k;
        }
        return f;
    }

    static 
    {
        int ai[] = new int[1];
        GLES10.glGetIntegerv(3379, ai, 0);
        int i = Math.max(ai[0], 2048);
        a = new c(i, i);
    }

    /* member class not found */
    class _cls1 {}

}
