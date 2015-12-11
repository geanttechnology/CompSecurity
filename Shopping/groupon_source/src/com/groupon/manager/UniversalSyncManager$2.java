// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.manager.sync_process.AbstractPaginatedSyncManagerProcess;
import com.groupon.manager.sync_process.SyncManagerTaskRunner;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.groupon.manager:
//            UniversalSyncManager, UniversalInfo

class val.limit
    implements Callable
{

    final UniversalSyncManager this$0;
    final UniversalInfo val$info;
    final InputStream val$inputStreamClone;
    final int val$limit;
    final Object val$objectClone;
    final int val$offset;
    final List val$runners;

    public Object call()
        throws Exception
    {
        for (Iterator iterator = val$runners.iterator(); iterator.hasNext(); ((SyncManagerTaskRunner)iterator.next()).runBatchTask()) { }
        if (abstractPaginatedSyncManagerProcess != null)
        {
            abstractPaginatedSyncManagerProcess.triggerDatabaseTask(val$inputStreamClone, val$objectClone, val$info, val$offset, val$limit);
        }
        return null;
    }

    ginatedSyncManagerProcess()
    {
        this$0 = final_universalsyncmanager;
        val$runners = list;
        val$inputStreamClone = inputstream;
        val$objectClone = obj;
        val$info = universalinfo;
        val$offset = i;
        val$limit = I.this;
        super();
    }
}
