// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.store;

import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import java.io.File;

// Referenced classes of package com.amazon.gallery.framework.data.store:
//            CloudDriveAssetDiskEvictor

public static interface onMap
{

    public abstract void evict(onMap onmap, File file, ComponentProfiler componentprofiler, int i);
}
