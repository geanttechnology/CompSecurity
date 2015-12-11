// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.os.Message;
import java.util.Map;

// Referenced classes of package com.paypal.android.sdk:
//            ck, bg, bc, ba, 
//            ch, cf, cj, z, 
//            a, bi

public class bb
    implements ck
{

    private final a a;
    private final ba b;
    private final bg c = new bg();
    private final bc d = new bc(this);
    private cf e;

    public bb(a a1, ba ba1)
    {
        a = a1;
        b = ba1;
    }

    static void a(bb bb1, cj cj1)
    {
        bb1.c.a(cj1);
    }

    public final String a(ch ch1)
    {
        (new StringBuilder("mEnvironment:")).append(b).append(" mEnvironment.getEndpoints():").append(b.c());
        if (b != null && b.c() != null)
        {
            return (String)b.c().get(ch1.a());
        } else
        {
            return null;
        }
    }

    public final void a()
    {
        e.a();
    }

    public final void a(bi bi)
    {
        c.a(bi);
    }

    public final void a(cf cf1)
    {
        if (e != null)
        {
            throw new IllegalStateException();
        } else
        {
            e = cf1;
            return;
        }
    }

    public final void a(cj cj1)
    {
        cj1.l();
        z.a().e();
        if (!cj1.a())
        {
            Message message = new Message();
            message.what = 2;
            message.obj = cj1;
            d.sendMessage(message);
        }
    }

    public final void b()
    {
        c.a();
    }

    public final void b(cj cj1)
    {
        e.a(cj1);
    }

    public final String c()
    {
        return b.a();
    }

    public final a d()
    {
        return a;
    }

    public final String e()
    {
        return b.b();
    }

    static 
    {
        com/paypal/android/sdk/bb.getSimpleName();
    }
}
