// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.util.Arrays;

// Referenced classes of package com.google.android.gms.d:
//            kw, ky

public final class la
{

    public static final Object a = new Object();

    public static int a(float af[])
    {
        if (af == null || af.length == 0)
        {
            return 0;
        } else
        {
            return Arrays.hashCode(af);
        }
    }

    public static int a(int ai[])
    {
        if (ai == null || ai.length == 0)
        {
            return 0;
        } else
        {
            return Arrays.hashCode(ai);
        }
    }

    public static int a(long al[])
    {
        if (al == null || al.length == 0)
        {
            return 0;
        } else
        {
            return Arrays.hashCode(al);
        }
    }

    public static int a(Object aobj[])
    {
        int k = 0;
        int i;
        int j;
        if (aobj == null)
        {
            i = 0;
        } else
        {
            i = aobj.length;
        }
        for (j = 0; j < i;)
        {
            Object obj = aobj[j];
            int l = k;
            if (obj != null)
            {
                l = k * 31 + obj.hashCode();
            }
            j++;
            k = l;
        }

        return k;
    }

    public static void a(kw kw1, kw kw2)
    {
        if (kw1.r != null)
        {
            kw2.r = kw1.r.d();
        }
    }

    public static boolean a(float af[], float af1[])
    {
        if (af == null || af.length == 0)
        {
            return af1 == null || af1.length == 0;
        } else
        {
            return Arrays.equals(af, af1);
        }
    }

    public static boolean a(int ai[], int ai1[])
    {
        if (ai == null || ai.length == 0)
        {
            return ai1 == null || ai1.length == 0;
        } else
        {
            return Arrays.equals(ai, ai1);
        }
    }

    public static boolean a(long al[], long al1[])
    {
        if (al == null || al.length == 0)
        {
            return al1 == null || al1.length == 0;
        } else
        {
            return Arrays.equals(al, al1);
        }
    }

    public static boolean a(Object aobj[], Object aobj1[])
    {
        int j;
        int k;
        int l;
        boolean flag3;
        flag3 = false;
        if (aobj == null)
        {
            k = 0;
        } else
        {
            k = aobj.length;
        }
        if (aobj1 == null)
        {
            l = 0;
        } else
        {
            l = aobj1.length;
        }
        j = 0;
_L7:
        int i;
        boolean flag;
        boolean flag1;
        boolean flag2;
        for (i = 0; i < k && aobj[i] == null; i++) { }
        for (; j < l && aobj1[j] == null; j++) { }
        if (i >= k)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (j >= l)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag || !flag1) goto _L2; else goto _L1
_L1:
        flag2 = true;
_L4:
        return flag2;
_L2:
        flag2 = flag3;
        if (flag != flag1) goto _L4; else goto _L3
_L3:
        flag2 = flag3;
        if (!aobj[i].equals(aobj1[j])) goto _L4; else goto _L5
_L5:
        j++;
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

}
