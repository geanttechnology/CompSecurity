// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;

// Referenced classes of package com.google.android.gms.common.internal:
//            l, u

public final class b
    implements ServiceConnection
{

    final l a;
    private final int b;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        u.a(ibinder, "Expecting a valid IBinder");
        l.a(a, a(ibinder));
        a.c(b);
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        a.a.sendMessage(a.a.obtainMessage(4, b, 1));
    }

    public (l l1, int i)
    {
        a = l1;
        super();
        b = i;
    }
}
