// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.service;

import android.content.Context;
import android.support.v4.e.a;

// Referenced classes of package com.offerup.android.service:
//            ApplicationStartupService, c

final class b
    implements Runnable
{

    private Context a;
    private ApplicationStartupService b;

    private b(ApplicationStartupService applicationstartupservice, Context context)
    {
        b = applicationstartupservice;
        super();
        a = context;
    }

    b(ApplicationStartupService applicationstartupservice, Context context, byte byte0)
    {
        this(applicationstartupservice, context);
    }

    public final void run()
    {
        if (android.support.v4.e.a.b(a))
        {
            ApplicationStartupService.b(b);
            (new c(b, a, (byte)0)).execute(new Void[0]);
        }
    }
}
