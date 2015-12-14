// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;

import android.content.Context;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.network.http.senna.sync.manager.SyncManager;
import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.gallery.thor.app:
//            NoFreeTime

public class FreeTimeWrapper extends NoFreeTime
{

    public FreeTimeWrapper(Context context, SyncManager syncmanager, TagDao tagdao, MediaItemDao mediaitemdao, Profiler profiler, Executor executor)
    {
    }
}
