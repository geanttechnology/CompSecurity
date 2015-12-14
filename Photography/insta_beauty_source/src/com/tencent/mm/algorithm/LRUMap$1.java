// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.algorithm;

import java.util.Comparator;

// Referenced classes of package com.tencent.mm.algorithm:
//            LRUMap

class g
    implements Comparator
{

    final LRUMap g;

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((java.util.)obj, (java.util.)obj1);
    }

    public int compare(java.util. , java.util. 1)
    {
        return ((meVal).getValue()).t.compareTo(((meVal)1.getValue()).t);
    }

    meVal(LRUMap lrumap)
    {
        g = lrumap;
        super();
    }
}
