// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.content.SharedPreferences;
import android.net.Uri;
import com.amazon.gallery.framework.network.http.senna.SennaSyncListener;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            SyncNotificationObserver

private class uri
    implements Runnable
{

    final SyncNotificationObserver this$0;
    private final Uri uri;

    public void run()
    {
        if (!SyncNotificationObserver.access$000(SyncNotificationObserver.this).equals(uri) || !SyncNotificationObserver.access$100(SyncNotificationObserver.this).getBoolean("coldBootStatus", false)) goto _L2; else goto _L1
_L1:
        SyncNotificationObserver.access$200(SyncNotificationObserver.this, REMENTAL);
_L4:
        if (!SyncNotificationObserver.access$400(SyncNotificationObserver.this).getAndSet(true))
        {
            SyncNotificationObserver.access$500(SyncNotificationObserver.this).onFirstSyncCompleted();
        }
        return;
_L2:
        if (SyncNotificationObserver.access$300(SyncNotificationObserver.this).equals(uri))
        {
            SyncNotificationObserver.access$200(SyncNotificationObserver.this, DBOOT);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public (Uri uri1)
    {
        this$0 = SyncNotificationObserver.this;
        super();
        uri = uri1;
    }
}
