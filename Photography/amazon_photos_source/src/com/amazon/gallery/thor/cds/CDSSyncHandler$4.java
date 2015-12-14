// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.amazon.gallery.foundation.utils.log.GLogger;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            CDSSyncHandler, GalleryMetadataSyncService

class this._cls0
    implements ServiceConnection
{

    final CDSSyncHandler this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        if (!CDSSyncHandler.access$800(CDSSyncHandler.this))
        {
            GLogger.i(CDSSyncHandler.access$000(), "Sync observation is currently not active, unbinding service", new Object[0]);
            componentname = (Activity)CDSSyncHandler.access$900(CDSSyncHandler.this).get();
            if (componentname != null)
            {
                componentname.unbindService(this);
            }
            return;
        } else
        {
            GLogger.i(CDSSyncHandler.access$000(), "%s successfully bound to %s", new Object[] {
                CDSSyncHandler.access$000(), com/amazon/gallery/thor/cds/GalleryMetadataSyncService.getName()
            });
            CDSSyncHandler.access$1000(CDSSyncHandler.this).set(true);
            CDSSyncHandler.access$1102(CDSSyncHandler.this, (com.amazon.mixtape.service.e.SyncServiceBinder)ibinder);
            CDSSyncHandler.access$1100(CDSSyncHandler.this).addSyncProgressObserver(CDSSyncHandler.access$1200(CDSSyncHandler.this));
            return;
        }
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        GLogger.i(CDSSyncHandler.access$000(), "%s successfully unbound from %s", new Object[] {
            CDSSyncHandler.access$000(), com/amazon/gallery/thor/cds/GalleryMetadataSyncService.getName()
        });
        CDSSyncHandler.access$1100(CDSSyncHandler.this).removeSyncProgressObserver(CDSSyncHandler.access$1200(CDSSyncHandler.this));
        CDSSyncHandler.access$1000(CDSSyncHandler.this).set(false);
        CDSSyncHandler.access$1102(CDSSyncHandler.this, null);
    }

    .SyncServiceBinder()
    {
        this$0 = CDSSyncHandler.this;
        super();
    }
}
