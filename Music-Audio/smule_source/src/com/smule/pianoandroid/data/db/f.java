// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.db;

import java.util.Comparator;

// Referenced classes of package com.smule.pianoandroid.data.db:
//            g

public class f
    implements Comparator
{

    public f()
    {
    }

    public int a(g g1, g g2)
    {
        if (g1.b < g2.b)
        {
            return -1;
        }
        return g1.b != g2.b ? 1 : 0;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((g)obj, (g)obj1);
    }
}
