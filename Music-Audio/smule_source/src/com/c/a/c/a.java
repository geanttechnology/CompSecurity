// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.c;

import com.c.a.b.a.f;
import com.c.a.b.a.l;

public final class a
{

    public static int a(f f1, f f2, l l1, boolean flag)
    {
        int i;
        int j;
        int k;
        int i1;
        int j1;
        int k1;
        j = f1.a();
        i = f1.b();
        j1 = f2.a();
        k1 = f2.b();
        k = j / j1;
        i1 = i / k1;
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[l.values().length];
                try
                {
                    a[l.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[l.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[l1.ordinal()];
        JVM INSTR tableswitch 1 2: default 68
    //                   1 79
    //                   2 153;
           goto _L1 _L2 _L3
_L1:
        i = 1;
_L8:
        if (i < 1)
        {
            return 1;
        } else
        {
            return i;
        }
_L2:
        if (!flag) goto _L5; else goto _L4
_L4:
        boolean flag1 = true;
        i1 = j;
        k = i;
        j = ((flag1) ? 1 : 0);
_L9:
        if (i1 / 2 >= j1) goto _L7; else goto _L6
_L6:
        i = j;
        if (k / 2 < k1) goto _L8; else goto _L7
_L7:
        i1 /= 2;
        k /= 2;
        j *= 2;
          goto _L9
_L5:
        i = Math.max(k, i1);
          goto _L8
_L3:
        if (!flag) goto _L11; else goto _L10
_L10:
        boolean flag2 = true;
        i1 = j;
        k = i;
        j = ((flag2) ? 1 : 0);
_L14:
        i = j;
        if (i1 / 2 < j1) goto _L8; else goto _L12
_L12:
        i = j;
        if (k / 2 < k1) goto _L8; else goto _L13
_L13:
        i1 /= 2;
        k /= 2;
        j *= 2;
          goto _L14
_L11:
        i = Math.min(k, i1);
          goto _L8
    }

    public static f a(com.c.a.b.e.a a1, f f1)
    {
        int j = a1.a();
        int i = j;
        if (j <= 0)
        {
            i = f1.a();
        }
        int k = a1.b();
        j = k;
        if (k <= 0)
        {
            j = f1.b();
        }
        return new f(i, j);
    }

    public static float b(f f1, f f2, l l1, boolean flag)
    {
label0:
        {
            int k = f1.a();
            int i1 = f1.b();
            int i = f2.a();
            int j = f2.b();
            float f3 = (float)k / (float)i;
            float f4 = (float)i1 / (float)j;
            if (l1 == l.a && f3 >= f4 || l1 == l.b && f3 < f4)
            {
                j = (int)((float)i1 / f3);
            } else
            {
                i = (int)((float)k / f4);
            }
            f4 = 1.0F;
            if (flag || i >= k || j >= i1)
            {
                f3 = f4;
                if (!flag)
                {
                    break label0;
                }
                f3 = f4;
                if (i == k)
                {
                    break label0;
                }
                f3 = f4;
                if (j == i1)
                {
                    break label0;
                }
            }
            f3 = (float)i / (float)k;
        }
        return f3;
    }
}
