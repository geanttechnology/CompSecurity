// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.opengl.GLES10;

// Referenced classes of package android.support.v7:
//            aiu, aix, ajk

public final class ajr
{

    private static aiu a;

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

    public static int a(aiu aiu1)
    {
        int i = aiu1.a();
        int j = aiu1.b();
        int k = a.a();
        int l = a.b();
        return Math.max((int)Math.ceil((float)i / (float)k), (int)Math.ceil((float)j / (float)l));
    }

    public static int a(aiu aiu1, aiu aiu2, aix aix1, boolean flag)
    {
        boolean flag1;
        int l;
        int i1;
        int j1;
        int k1;
        flag1 = true;
        l = aiu1.a();
        i1 = aiu1.b();
        j1 = aiu2.a();
        k1 = aiu2.b();
        static class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[aix.values().length];
                try
                {
                    a[aix.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[aix.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[aix1.ordinal()];
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

    public static aiu a(ajk ajk1, aiu aiu1)
    {
        int j = ajk1.a();
        int i = j;
        if (j <= 0)
        {
            i = aiu1.a();
        }
        int k = ajk1.b();
        j = k;
        if (k <= 0)
        {
            j = aiu1.b();
        }
        return new aiu(i, j);
    }

    public static float b(aiu aiu1, aiu aiu2, aix aix1, boolean flag)
    {
label0:
        {
            int k = aiu1.a();
            int l = aiu1.b();
            int i = aiu2.a();
            int j = aiu2.b();
            float f = (float)k / (float)i;
            float f1 = (float)l / (float)j;
            if (aix1 == aix.a && f >= f1 || aix1 == aix.b && f < f1)
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
        a = new aiu(i, i);
    }
}
