// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

// Referenced classes of package com.google.android.gms.gcm:
//            c, e, f

private class d extends Thread
{

    final c a;
    private final String b;
    private final f c;
    private final Bundle d;

    public void run()
    {
        int i = a.a(new e(b, d));
        c.a(i);
        com.google.android.gms.gcm.c.a(a, b);
        return;
        Object obj;
        obj;
        Log.e("GcmTaskService", (new StringBuilder()).append("Error reporting result of operation to scheduler for ").append(b).toString());
        com.google.android.gms.gcm.c.a(a, b);
        return;
        obj;
        com.google.android.gms.gcm.c.a(a, b);
        throw obj;
    }

    (c c1, String s, IBinder ibinder, Bundle bundle)
    {
        a = c1;
        super();
        b = s;
        c = a(ibinder);
        d = bundle;
    }
}
