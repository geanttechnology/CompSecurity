// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class cum extends BroadcastReceiver
{

    private cur a;

    cum(cul cul, cur cur1)
    {
        a = cur1;
        super();
    }

    public final void onReceive(Context context, Intent intent)
    {
        if ("com.google.android.youtube.action.controller_notification_prev".equals(intent.getAction()))
        {
            a.f();
        } else
        {
            if ("com.google.android.youtube.action.controller_notification_play_pause".equals(intent.getAction()))
            {
                a.d();
                return;
            }
            if ("com.google.android.youtube.action.controller_notification_next".equals(intent.getAction()))
            {
                a.g();
                return;
            }
            if ("com.google.android.youtube.action.controller_notification_close".equals(intent.getAction()))
            {
                a.h();
                return;
            }
            if ("com.google.android.youtube.action.controller_notification_replay".equals(intent.getAction()))
            {
                a.e();
                return;
            }
        }
    }
}
