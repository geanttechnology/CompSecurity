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

private final class <init>
    implements <init>, <init>
{

    final m a;

    public final void a(int i)
    {
    }

    public final void a(Bundle bundle)
    {
        a.d.a(new <init>(a));
    }

    public final void a(ConnectionResult connectionresult)
    {
        a.b.lock();
        if (!a.a(connectionresult)) goto _L2; else goto _L1
_L1:
        a.i();
        a.h();
_L4:
        a.b.unlock();
        return;
_L2:
        a.b(connectionresult);
        if (true) goto _L4; else goto _L3
_L3:
        connectionresult;
        a.b.unlock();
        throw connectionresult;
    }

    private onResult(m m1)
    {
        a = m1;
        super();
    }

    a(m m1, byte byte0)
    {
        this(m1);
    }
}
