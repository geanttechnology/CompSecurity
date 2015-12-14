// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.store;

import android.content.Context;

// Referenced classes of package com.amazon.gallery.framework.data.store:
//            DiskEvictorConfig, CloudDriveAssetDiskEvictor, DiskEvictor

public class DiskEvictorFactory
{

    protected DiskEvictorConfig config;
    protected Context context;

    public DiskEvictorFactory(Context context1)
    {
        this(context1, new DiskEvictorConfig());
    }

    public DiskEvictorFactory(Context context1, DiskEvictorConfig diskevictorconfig)
    {
        context = context1;
        config = diskevictorconfig;
    }

    public DiskEvictor createDiskEvictor()
    {
        return new CloudDriveAssetDiskEvictor(context.getCacheDir(), config.getCloudSourceCapacity(), config.getDeviceSourceCapacity(), 200);
    }

    public DiskEvictorConfig getConfig()
    {
        return config;
    }
}
