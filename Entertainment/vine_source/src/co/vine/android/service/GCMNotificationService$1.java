// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;

// Referenced classes of package co.vine.android.service:
//            GCMNotificationService

class this._cls0
    implements ServiceConnection
{

    final GCMNotificationService this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        GCMNotificationService.access$002(GCMNotificationService.this, new Messenger(ibinder));
        GCMNotificationService.access$102(GCMNotificationService.this, true);
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        GCMNotificationService.access$002(GCMNotificationService.this, null);
        GCMNotificationService.access$102(GCMNotificationService.this, false);
    }

    ()
    {
        this$0 = GCMNotificationService.this;
        super();
    }
}
