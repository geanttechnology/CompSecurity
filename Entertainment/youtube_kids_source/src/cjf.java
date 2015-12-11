// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Comparator;

final class cjf
    implements Comparator
{

    private final arp a;
    private final boolean b;
    private final boolean c;
    private boolean d;

    cjf(arp arp1, boolean flag, boolean flag1)
    {
        a = arp1;
        b = flag;
        c = flag1;
    }

    static void a(cjf cjf1, boolean flag)
    {
        cjf1.d = flag;
    }

    public final int compare(Object obj, Object obj1)
    {
        int k;
        int l;
        int i1;
        obj = (bwb)obj;
        obj1 = (bwb)obj1;
        k = ((bwb) (obj)).c();
        i1 = ((bwb) (obj1)).c();
        if (!d)
        {
            break MISSING_BLOCK_LABEL_246;
        }
        l = k;
        if (!b) goto _L2; else goto _L1
_L1:
        int i;
        i = k;
        if (((bwb) (obj)).d())
        {
            i = k * 1000;
        }
        l = i;
        if (!((bwb) (obj1)).d()) goto _L2; else goto _L3
_L3:
        l = i1 * 1000;
        k = i;
_L4:
        int j1;
        int j = k;
        if (((bwb) (obj)).a.l)
        {
            j = k * 100;
        }
        k = l;
        if (((bwb) (obj1)).a.l)
        {
            k = l * 100;
        }
        i1 = k;
        j1 = j;
        if (c)
        {
            long l1 = a.a();
            i1 = k;
            j1 = j;
            if (l1 != -1L)
            {
                l = j;
                if ((long)((bwb) (obj)).a.e <= l1)
                {
                    l = j * 10;
                }
                i1 = k;
                j1 = l;
                if ((long)((bwb) (obj1)).a.e <= l1)
                {
                    i1 = k * 10;
                    j1 = l;
                }
            }
        }
_L5:
        if (j1 > i1)
        {
            return -1;
        }
        return j1 != i1 ? 1 : 0;
_L2:
        k = l;
        l = i1;
          goto _L4
        j1 = k;
          goto _L5
    }
}
