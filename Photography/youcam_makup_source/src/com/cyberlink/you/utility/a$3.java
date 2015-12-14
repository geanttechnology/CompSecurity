// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import java.util.Comparator;

// Referenced classes of package com.cyberlink.you.utility:
//            a, j

final class 
    implements Comparator
{

    public final int a(j j1, j j2)
    {
        if (j1.b >= j2.b)
        {
            if (j1.b > j2.b)
            {
                return 1;
            }
            if (j1.c < j2.c)
            {
                return 1;
            }
            if (j1.c <= j2.c)
            {
                return 0;
            }
        }
        return -1;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((j)obj, (j)obj1);
    }

    public final boolean equals(Object obj)
    {
        return false;
    }

    ()
    {
    }
}
