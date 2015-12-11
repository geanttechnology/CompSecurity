// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

// Referenced classes of package com.google.android.gms.common.api:
//            k

class a
    implements Runnable
{

    final ConnectionResult a;
    final k b;

    public void run()
    {
        k.a(b).lock();
        k.a(b, a);
        k.a(b).unlock();
        return;
        Exception exception;
        exception;
        k.a(b).unlock();
        throw exception;
    }

    onResult(k k1, ConnectionResult connectionresult)
    {
        b = k1;
        a = connectionresult;
        super();
    }
}
