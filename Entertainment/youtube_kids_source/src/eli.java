// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Comparator;
import java.util.List;

final class eli extends elf
{

    eli(String s, int i)
    {
        super(s, 2);
    }

    final int a(Comparator comparator, Object obj, List list, int i)
    {
        int j;
        for (j = 0; j < i;)
        {
            int k = j + i >>> 1;
            if (comparator.compare(list.get(k), obj) < 0)
            {
                j = k + 1;
            } else
            {
                i = k;
            }
        }

        return j;
    }
}
