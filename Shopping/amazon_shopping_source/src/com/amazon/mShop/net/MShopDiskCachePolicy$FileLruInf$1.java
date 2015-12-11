// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import java.util.Comparator;

// Referenced classes of package com.amazon.mShop.net:
//            MShopDiskCachePolicy

static final class 
    implements Comparator
{

    public int compare( ,  1)
    {
        if (.astModifiedTime == 1.astModifiedTime)
        {
            return 0;
        }
        return .astModifiedTime <= 1.astModifiedTime ? -1 : 1;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((compare)obj, (compare)obj1);
    }

    ()
    {
    }
}
