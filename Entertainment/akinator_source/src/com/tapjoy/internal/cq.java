// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


public final class cq
{

    private final String a[] = new String[512];

    public cq()
    {
    }

    public final String a(char ac[], int i, int j)
    {
        String s;
        boolean flag1;
        int j1;
        flag1 = false;
        int k = i;
        int l = 0;
        for (; k < i + j; k++)
        {
            l = l * 31 + ac[k];
        }

        k = l >>> 20 ^ l >>> 12 ^ l;
        j1 = (k ^ (k >>> 7 ^ k >>> 4)) & a.length - 1;
        s = a[j1];
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.length() == j) goto _L4; else goto _L3
_L3:
        boolean flag = flag1;
_L5:
        if (flag)
        {
            return s;
        }
        break; /* Loop/switch isn't completed */
_L4:
        for (int i1 = 0; i1 < j; i1++)
        {
            flag = flag1;
            if (ac[i + i1] != s.charAt(i1))
            {
                continue; /* Loop/switch isn't completed */
            }
        }

        flag = true;
        if (true) goto _L5; else goto _L2
_L2:
        ac = new String(ac, i, j);
        a[j1] = ac;
        return ac;
    }
}
