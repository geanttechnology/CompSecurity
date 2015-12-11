// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package commonlib.manager;

import java.lang.ref.WeakReference;

// Referenced classes of package commonlib.manager:
//            PaginatedSyncManager, SyncManager

protected static class  extends 
{

    protected void performSync()
        throws Exception
    {
        PaginatedSyncManager paginatedsyncmanager = (PaginatedSyncManager)syncManagerRef.get();
        if (paginatedsyncmanager != null)
        {
            paginatedsyncmanager.doSync(info, 0, Math.max(PaginatedSyncManager.access$000(paginatedsyncmanager), paginatedsyncmanager.getNextOffset()));
        }
    }

    public ( , Object obj, SyncManager syncmanager)
    {
        super(, obj, syncmanager);
    }
}
