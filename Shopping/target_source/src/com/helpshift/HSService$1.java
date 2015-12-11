// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import com.helpshift.i.k;
import com.helpshift.i.m;

// Referenced classes of package com.helpshift:
//            HSService, l

class a extends Handler
{

    final HSService a;

    public void handleMessage(Message message)
    {
        if (HSService.a(a))
        {
            if (!HSService.b(a).booleanValue() && HSService.b() != null)
            {
                HSService.b().a();
            }
            HSService.a(a, Boolean.valueOf(true));
            message = k.a(a, HSService.b());
            HSService.c(a).f(message, new Handler());
            return;
        } else
        {
            HSService.a(a, Boolean.valueOf(false));
            a.stopSelf();
            return;
        }
    }

    (HSService hsservice)
    {
        a = hsservice;
        super();
    }
}
