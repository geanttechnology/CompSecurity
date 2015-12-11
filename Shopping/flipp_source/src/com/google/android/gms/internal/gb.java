// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

// Referenced classes of package com.google.android.gms.internal:
//            fw, ge

final class gb
    implements ServiceConnection
{

    final fw a;

    gb(fw fw1)
    {
        a = fw1;
        super();
    }

    public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        a.b(ibinder);
    }

    public final void onServiceDisconnected(ComponentName componentname)
    {
        fw.a(a, null);
        fw.a(a).a();
    }
}
