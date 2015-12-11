// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

// Referenced classes of package com.google.analytics.tracking.android:
//            an, b, d, e

final class c
    implements ServiceConnection
{

    final b a;

    c(b b1)
    {
        a = b1;
        super();
    }

    public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        an.c((new StringBuilder("service connected, binder: ")).append(ibinder).toString());
        try
        {
            if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(ibinder.getInterfaceDescriptor()))
            {
                an.c("bound to service");
                a.e = com.google.android.gms.analytics.internal.c.a(ibinder);
                a.b.a();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (ComponentName componentname) { }
        a.d.unbindService(this);
        a.a = null;
        a.c.a(2);
    }

    public final void onServiceDisconnected(ComponentName componentname)
    {
        an.c((new StringBuilder("service disconnected: ")).append(componentname).toString());
        a.a = null;
        a.b.b();
    }
}
