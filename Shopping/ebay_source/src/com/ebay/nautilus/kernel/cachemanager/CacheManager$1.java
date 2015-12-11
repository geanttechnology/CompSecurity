// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.cachemanager;

import java.util.Comparator;

// Referenced classes of package com.ebay.nautilus.kernel.cachemanager:
//            CacheManager

static final class leMeta
    implements Comparator
{

    public int compare(leMeta lemeta, leMeta lemeta1)
    {
        long l = lemeta1.lastModified - lemeta.lastModified;
        if (l > 0L)
        {
            return 1;
        }
        if (l < 0L)
        {
            return -1;
        } else
        {
            return lemeta1.compareTo(lemeta);
        }
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((leMeta)obj, (leMeta)obj1);
    }

    leMeta()
    {
    }
}
