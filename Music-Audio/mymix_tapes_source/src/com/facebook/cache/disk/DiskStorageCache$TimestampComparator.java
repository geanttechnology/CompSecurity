// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.disk;

import java.util.Comparator;

// Referenced classes of package com.facebook.cache.disk:
//            DiskStorageCache

private static class threshold
    implements Comparator
{

    private final long threshold;

    public int compare(threshold threshold1, threshold threshold2)
    {
        long l;
        long l1;
        if (threshold1.threshold() <= threshold)
        {
            l = threshold1.threshold();
        } else
        {
            l = 0L;
        }
        if (threshold2.threshold() <= threshold)
        {
            l1 = threshold2.threshold();
        } else
        {
            l1 = 0L;
        }
        if (l < l1)
        {
            return -1;
        }
        return l1 <= l ? 0 : 1;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((compare)obj, (compare)obj1);
    }

    public (long l)
    {
        threshold = l;
    }
}
