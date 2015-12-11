// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class abr extends BroadcastReceiver
{

    private abr()
    {
    }

    abr(abq._cls1 _pcls1)
    {
        this();
    }

    public void onReceive(Context context, Intent intent)
    {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction()))
        {
            abq.a(true);
        } else
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()))
        {
            abq.a(false);
            return;
        }
    }
}
