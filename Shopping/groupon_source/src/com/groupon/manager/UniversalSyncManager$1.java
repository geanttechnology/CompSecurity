// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.manager.sync_process.AbstractPaginatedSyncManagerProcess;
import com.groupon.manager.sync_process.AbstractSyncManagerProcess;
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
    final int val$limit;
    final int val$offset;

    public Object call()
        throws Exception
    {
        if (abstractPaginatedSyncManagerProcess != null)
        {
            abstractPaginatedSyncManagerProcess.doDatabaseWorkOnNetworkError(val$info, val$offset, val$limit);
        }
        for (Iterator iterator = abstractSyncManagerProcessList.iterator(); iterator.hasNext(); ((AbstractSyncManagerProcess)iterator.next()).doDatabaseWorkOnNetworkError(val$info)) { }
        return null;
    }

    ncManagerProcess()
    {
        this$0 = final_universalsyncmanager;
        val$info = universalinfo;
        val$offset = i;
        val$limit = I.this;
        super();
    }
}
