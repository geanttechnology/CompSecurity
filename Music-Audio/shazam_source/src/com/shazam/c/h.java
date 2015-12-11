// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c;

import com.shazam.b.a.a;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.shazam.c:
//            i

public final class h
    implements i
{

    private final a a;
    private int b;

    public h(a a1)
    {
        b = 0x7fffffff;
        a = a1;
        b = 0x7fffffff;
    }

    public h(a a1, int j)
    {
        b = 0x7fffffff;
        a = a1;
        b = j;
    }

    public final Object a(Object obj)
    {
        int k = 0;
        obj = (List)obj;
        ArrayList arraylist;
        int j;
        if (obj != null)
        {
            j = Math.min(((List) (obj)).size(), b);
        } else
        {
            j = 0;
        }
        arraylist = new ArrayList(j);
        for (; k < j; k++)
        {
            arraylist.add(k, a.a(((List) (obj)).get(k)));
        }

        return arraylist;
    }
}
