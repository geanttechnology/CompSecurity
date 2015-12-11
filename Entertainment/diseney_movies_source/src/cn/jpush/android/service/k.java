// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.service;

import cn.jpush.android.util.x;

// Referenced classes of package cn.jpush.android.service:
//            PushService

final class k
    implements Runnable
{

    final PushService a;

    k(PushService pushservice)
    {
        a = pushservice;
        super();
    }

    public final void run()
    {
        PushService.a(a, true);
        PushService.a(a, false, true, true);
        x.c();
        PushService.b(a);
        PushService.a(a, false);
    }
}
