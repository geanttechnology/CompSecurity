// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.store;

import com.amazon.gallery.foundation.metrics.Profiler;

// Referenced classes of package com.amazon.gallery.framework.data.store:
//            Asset

public interface DiskEvictor
{

    public abstract void cleanUp();

    public abstract void onStoreAsset(Asset asset, boolean flag);

    public abstract void setProfiler(Profiler profiler);

    public abstract boolean shouldPerformCleanup();
}
