// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class ach extends BroadcastReceiver
{

    private acd a;

    ach(acd acd1)
    {
        a = acd1;
        super();
    }

    public final void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF"))
        {
            context = a.f;
            if (((ack) (context)).a != 1)
            {
                context.a(5);
            }
        }
    }
}
