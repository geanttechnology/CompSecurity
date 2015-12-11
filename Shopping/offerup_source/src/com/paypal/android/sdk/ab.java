// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.TimerTask;

// Referenced classes of package com.paypal.android.sdk:
//            z, ax, ak, ap

final class ab extends TimerTask
{

    private z a;

    ab(z z1)
    {
        a = z1;
        super();
    }

    public final void run()
    {
        z.g(a);
        z.g();
        (new StringBuilder("****** LoadConfigurationTask #")).append(z.h(a));
        ax.b();
        ak ak1 = new ak(z.i(a), z.j(a), z.k(a));
        ap.a().a(ak1);
    }
}
