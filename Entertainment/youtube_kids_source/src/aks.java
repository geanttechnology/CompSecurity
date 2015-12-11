// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

final class aks extends BroadcastReceiver
{

    private akj a;

    aks(akj akj1)
    {
        a = akj1;
        super();
    }

    public final void onReceive(Context context, Intent intent)
    {
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()))
        {
            if (a.i() != amj.e)
            {
                akj.g(a).a(amj.c);
                akj.f(a).sendEmptyMessage(1);
            }
        } else
        if ("android.intent.action.SCREEN_ON".equals(intent.getAction()))
        {
            context = a;
            ((akj) (context)).g.removeMessages(1);
            if (((akj) (context)).d.d == amj.c)
            {
                if (((akj) (context)).f == null)
                {
                    ((akj) (context)).e.b("We should reconnect, but we lost the screen");
                    return;
                } else
                {
                    ((akj) (context)).d.a(amj.a);
                    ((akj) (context)).b.registerReceiver(((akj) (context)).c, akj.a);
                    ((akj) (context)).g.sendEmptyMessage(7);
                    return;
                }
            }
        }
    }
}
