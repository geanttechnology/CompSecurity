// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.lucasr.smoothie;


// Referenced classes of package org.lucasr.smoothie:
//            ItemManager, ItemLoader

public static final class mThreadPoolSize
{

    private static final int DEFAULT_PRELOAD_ITEMS_COUNT = 4;
    private static final boolean DEFAULT_PRELOAD_ITEMS_ENABLED = false;
    private static final int DEFAULT_THREAD_POOL_SIZE = 2;
    private final ItemLoader mItemLoader;
    private int mPreloadItemsCount;
    private boolean mPreloadItemsEnabled;
    private int mThreadPoolSize;

    public ItemManager build()
    {
        return new ItemManager(mItemLoader, mPreloadItemsEnabled, mPreloadItemsCount, mThreadPoolSize, null);
    }

    public mThreadPoolSize setPreloadItemsCount(int i)
    {
        mPreloadItemsCount = i;
        return this;
    }

    public mPreloadItemsCount setPreloadItemsEnabled(boolean flag)
    {
        mPreloadItemsEnabled = flag;
        return this;
    }

    public mPreloadItemsEnabled setThreadPoolSize(int i)
    {
        mThreadPoolSize = i;
        return this;
    }

    public (ItemLoader itemloader)
    {
        mItemLoader = itemloader;
        mPreloadItemsEnabled = false;
        mPreloadItemsCount = 4;
        mThreadPoolSize = 2;
    }
}
