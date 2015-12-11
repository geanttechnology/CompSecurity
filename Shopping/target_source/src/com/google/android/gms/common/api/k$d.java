// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.b.dw;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

// Referenced classes of package com.google.android.gms.common.api:
//            k

private class <init>
    implements <init>, <init>
{

    final k a;

    public void a(int i)
    {
    }

    public void a(Bundle bundle)
    {
        k.c(a).a(new <init>(a));
    }

    public void a(ConnectionResult connectionresult)
    {
        k.a(a).lock();
        if (!k.b(a, connectionresult)) goto _L2; else goto _L1
_L1:
        k.d(a);
        k.e(a);
_L4:
        k.a(a).unlock();
        return;
_L2:
        k.a(a, connectionresult);
        if (true) goto _L4; else goto _L3
_L3:
        connectionresult;
        k.a(a).unlock();
        throw connectionresult;
    }

    private onResult(k k1)
    {
        a = k1;
        super();
    }

    a(k k1, a a1)
    {
        this(k1);
    }
}
