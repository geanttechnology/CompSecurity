// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.signin.d;
import java.util.concurrent.locks.Lock;

// Referenced classes of package com.google.android.gms.common.api:
//            m

private class <init>
    implements <init>, <init>
{

    final m a;

    public void onConnected(Bundle bundle)
    {
        m.f(a).a(new <init>(a));
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        m.c(a).lock();
        if (!m.b(a, connectionresult)) goto _L2; else goto _L1
_L1:
        m.i(a);
        m.j(a);
_L4:
        m.c(a).unlock();
        return;
_L2:
        m.a(a, connectionresult);
        if (true) goto _L4; else goto _L3
_L3:
        connectionresult;
        m.c(a).unlock();
        throw connectionresult;
    }

    public void onConnectionSuspended(int i)
    {
    }

    private onResult(m m1)
    {
        a = m1;
        super();
    }

    a(m m1, a a1)
    {
        this(m1);
    }
}
