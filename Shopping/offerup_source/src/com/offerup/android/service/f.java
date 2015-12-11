// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.service;

import android.content.Context;
import android.support.v4.e.a;
import android.util.Log;
import com.b.a.a.g;

// Referenced classes of package com.offerup.android.service:
//            d, ApplicationStartupService

final class f
    implements Runnable
{

    private Context a;
    private ApplicationStartupService b;

    private f(ApplicationStartupService applicationstartupservice, Context context)
    {
        b = applicationstartupservice;
        super();
        a = context;
    }

    f(ApplicationStartupService applicationstartupservice, Context context, byte byte0)
    {
        this(applicationstartupservice, context);
    }

    public final void run()
    {
        try
        {
            if (android.support.v4.e.a.b(a))
            {
                (new d(b, (byte)0)).execute(new Void[0]);
            }
            return;
        }
        catch (Throwable throwable)
        {
            g.c(ApplicationStartupService.c(b), Log.getStackTraceString(throwable));
        }
    }
}
