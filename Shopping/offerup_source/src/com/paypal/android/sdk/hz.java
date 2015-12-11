// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.net.Socket;

// Referenced classes of package com.paypal.android.sdk:
//            iu, gp, iz

public final class hz
{

    private String a;
    private Socket b;
    private iu c;
    private gp d;
    private iz e;
    private boolean f;

    public hz(String s, Socket socket)
    {
        c = iu.a;
        d = gp.c;
        e = iz.a;
        a = s;
        f = true;
        b = socket;
    }

    static gp a(hz hz1)
    {
        return hz1.d;
    }

    static iz b(hz hz1)
    {
        return hz1.e;
    }

    static boolean c(hz hz1)
    {
        return hz1.f;
    }

    static iu d(hz hz1)
    {
        return hz1.c;
    }

    static String e(hz hz1)
    {
        return hz1.a;
    }

    static Socket f(hz hz1)
    {
        return hz1.b;
    }

    public final hz a(gp gp1)
    {
        d = gp1;
        return this;
    }
}
