// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.disk;


// Referenced classes of package com.facebook.cache.disk:
//            DiskStorageCache

public static class mDefaultCacheSizeLimit
{

    public final long mCacheSizeLimitMinimum;
    public final long mDefaultCacheSizeLimit;
    public final long mLowDiskSpaceCacheSizeLimit;

    public (long l, long l1, long l2)
    {
        mCacheSizeLimitMinimum = l;
        mLowDiskSpaceCacheSizeLimit = l1;
        mDefaultCacheSizeLimit = l2;
    }
}
