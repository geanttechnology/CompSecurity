// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import java.io.File;

// Referenced classes of package com.amazon.mShop.net:
//            MShopDiskCachePolicy, MShopDiskCache

static final class leLruInf
    implements sor
{

    public int evict(leLruInf lelruinf)
    {
        return MShopDiskCache.deleteCachedFile(lelruinf);
    }

    public volatile int evict(Object obj)
    {
        return evict((leLruInf)obj);
    }

    public int getSize(leLruInf lelruinf)
    {
        return MShopDiskCache.getFileUsedSize(lelruinf);
    }

    public volatile int getSize(Object obj)
    {
        return getSize((leLruInf)obj);
    }

    public void setAccessTime(leLruInf lelruinf, long l)
    {
        lelruinf.mFile.setLastModified(l);
        lelruinf.mLastModifiedTime = l;
    }

    public volatile void setAccessTime(Object obj, long l)
    {
        setAccessTime((leLruInf)obj, l);
    }

    leLruInf()
    {
    }
}
