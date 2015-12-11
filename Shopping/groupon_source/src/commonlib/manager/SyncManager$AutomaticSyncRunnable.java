// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package commonlib.manager;

import java.lang.ref.WeakReference;

// Referenced classes of package commonlib.manager:
//            SyncManager

protected static class _cls9 extends _cls9
{

    protected void performSync()
        throws Exception
    {
        SyncManager syncmanager = (SyncManager)syncManagerRef.get();
        if (syncmanager != null)
        {
            syncmanager.doSync(this);
        }
    }

    public void run()
    {
        super.syncManagerRef();
        SyncManager syncmanager = (SyncManager)syncManagerRef.get();
        if (syncmanager != null)
        {
            syncmanager.scheduleNextSync(this, SyncManager.access$000(syncmanager));
        }
        return;
        Exception exception;
        exception;
        SyncManager syncmanager1 = (SyncManager)syncManagerRef.get();
        if (syncmanager1 != null)
        {
            syncmanager1.scheduleNextSync(this, SyncManager.access$000(syncmanager1));
        }
        throw exception;
    }

    public _cls9(_cls9 _pcls9, Object obj, SyncManager syncmanager)
    {
        super(_pcls9, obj, syncmanager);
    }
}
