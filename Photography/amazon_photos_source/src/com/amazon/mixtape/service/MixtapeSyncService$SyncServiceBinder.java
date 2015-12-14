// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import android.os.Binder;

// Referenced classes of package com.amazon.mixtape.service:
//            MixtapeSyncService, AccountSync, SyncProgressObserver

public class this._cls0 extends Binder
{

    final MixtapeSyncService this$0;

    public void addSyncProgressObserver(SyncProgressObserver syncprogressobserver)
    {
        MixtapeSyncService.access$000().addSyncProgressObserver(syncprogressobserver);
    }

    public void removeSyncProgressObserver(SyncProgressObserver syncprogressobserver)
    {
        MixtapeSyncService.access$000().removeSyncProgressObserver(syncprogressobserver);
    }

    public ()
    {
        this$0 = MixtapeSyncService.this;
        super();
    }
}
