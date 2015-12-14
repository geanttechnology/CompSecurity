// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.disk;


// Referenced classes of package com.facebook.cache.disk:
//            DiskStorageCache, DiskCacheConfig, DefaultDiskStorageSupplier, DiskStorageSupplier

public class DiskCacheFactory
{

    public DiskCacheFactory()
    {
    }

    public static DiskStorageCache newDiskStorageCache(DiskCacheConfig diskcacheconfig)
    {
        return new DiskStorageCache(newDiskStorageSupplier(diskcacheconfig), new DiskStorageCache.Params(diskcacheconfig.getMinimumSizeLimit(), diskcacheconfig.getLowDiskSpaceSizeLimit(), diskcacheconfig.getDefaultSizeLimit()), diskcacheconfig.getCacheEventListener(), diskcacheconfig.getCacheErrorLogger(), diskcacheconfig.getDiskTrimmableRegistry());
    }

    private static DiskStorageSupplier newDiskStorageSupplier(DiskCacheConfig diskcacheconfig)
    {
        return new DefaultDiskStorageSupplier(diskcacheconfig.getVersion(), diskcacheconfig.getBaseDirectoryPathSupplier(), diskcacheconfig.getBaseDirectoryName(), diskcacheconfig.getCacheErrorLogger());
    }
}
