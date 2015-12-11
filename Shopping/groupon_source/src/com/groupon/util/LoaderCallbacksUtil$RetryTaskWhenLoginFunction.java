// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import commonlib.manager.SyncManager;

// Referenced classes of package com.groupon.util:
//            CheckedFunction0, LoaderCallbacksUtil

protected static class taskToRetry
    implements CheckedFunction0
{

    protected final SyncManager syncManager;
    protected final Runnable taskToRetry;

    public void execute()
        throws Exception
    {
        syncManager.execute(taskToRetry);
    }

    public (SyncManager syncmanager, Runnable runnable)
    {
        syncManager = syncmanager;
        taskToRetry = runnable;
    }
}
