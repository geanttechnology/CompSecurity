// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.service;

import cn.jpush.android.data.d;

// Referenced classes of package cn.jpush.android.service:
//            PushService, ServiceInterface

final class j
    implements Runnable
{

    final d a;
    final PushService b;

    j(PushService pushservice, d d)
    {
        b = pushservice;
        a = d;
        super();
    }

    public final void run()
    {
        ServiceInterface.a(b.getApplicationContext(), a);
    }
}
