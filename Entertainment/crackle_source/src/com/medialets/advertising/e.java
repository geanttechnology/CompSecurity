// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

// Referenced classes of package com.medialets.advertising:
//            AdManager, AdManagerService, a

final class e
    implements ServiceConnection
{

    private AdManager a;

    e(AdManager admanager)
    {
        a = admanager;
        super();
    }

    public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        a.mService = ((AdManagerService.AdBinder)ibinder).getService();
        if (a.mUseTestServers)
        {
            a.mService.useTestServers();
        }
        if (a.a != null)
        {
            a.mService.setApplicationId(a.a);
        }
        if (a.b != null)
        {
            a.mService.setApplicationVersion(a.b);
        }
        if (AdManager.a(a) != null)
        {
            a.mService.setDataSource(AdManager.a(a));
        }
        a.mService.onConnected();
        if (a.mServiceListener != null)
        {
            a.mServiceListener.onServiceConnected();
        }
    }

    public final void onServiceDisconnected(ComponentName componentname)
    {
        com.medialets.advertising.a.c("Service disconnected.");
        a.mServiceListener = null;
        a.mService = null;
    }
}
