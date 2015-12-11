// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import b.a.a.d;

// Referenced classes of package b.a.a.d:
//            l, u

final class h extends l
{

    protected h(d d, int i)
    {
        super(d, i, false, i);
    }

    public final int a(u u, String s, int i)
    {
        int i1 = super.a(u, s, i);
        if (i1 >= 0) goto _L2; else goto _L1
_L1:
        int k;
        return i1;
_L2:
        int j;
label0:
        {
            if (i1 == (k = b + i))
            {
                continue; /* Loop/switch isn't completed */
            }
            j = k;
            if (!c)
            {
                break label0;
            }
            i = s.charAt(i);
            if (i != 45)
            {
                j = k;
                if (i != 43)
                {
                    break label0;
                }
            }
            j = k + 1;
        }
        if (i1 > j)
        {
            return ~(j + 1);
        }
        if (i1 < j)
        {
            return ~i1;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
