// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services;

import android.os.Handler;
import java.util.TimerTask;

// Referenced classes of package io.presage.services:
//            AbstractPresageService

final class b extends TimerTask
{

    final AbstractPresageService a;

    b(AbstractPresageService abstractpresageservice)
    {
        a = abstractpresageservice;
        super();
    }

    public final void run()
    {
        if (a.d)
        {
            return;
        } else
        {
            a.d = true;
            AbstractPresageService.b(a);
            AbstractPresageService.c(a).sendEmptyMessage(0);
            return;
        }
    }
}
