// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.jpush.android.util.x;

// Referenced classes of package cn.jpush.android.service:
//            a, c

final class b extends Handler
{

    final a a;
    private c b;

    public b(a a1, Looper looper, c c1)
    {
        a = a1;
        super(looper);
        b = null;
        b = c1;
    }

    public final void handleMessage(Message message)
    {
        super.handleMessage(message);
        if (a.a)
        {
            x.b();
            return;
        }
        if (b != null)
        {
            b.a(cn.jpush.android.service.a.a(a), cn.jpush.android.service.a.b(a));
        }
        cn.jpush.android.service.a.c(a).sendEmptyMessageDelayed(0, 2000L);
    }
}
