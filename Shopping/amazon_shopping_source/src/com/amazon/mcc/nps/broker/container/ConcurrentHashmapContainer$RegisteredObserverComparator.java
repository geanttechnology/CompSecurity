// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.nps.broker.container;

import java.util.Comparator;

// Referenced classes of package com.amazon.mcc.nps.broker.container:
//            ConcurrentHashmapContainer

private static class <init>
    implements Comparator
{

    public int compare(<init> <init>1, <init> <init>2)
    {
        byte byte0 = 0;
        int i;
        int j;
        if (<init>1 == null)
        {
            i = 0;
        } else
        {
            i = <init>1.y();
        }
        if (<init>2 == null)
        {
            j = 0;
        } else
        {
            j = <init>2.y();
        }
        if (i > j)
        {
            byte0 = -1;
        } else
        if (i < j)
        {
            return 1;
        }
        return byte0;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((compare)obj, (compare)obj1);
    }

    private a()
    {
    }

    a(a a)
    {
        this();
    }
}
