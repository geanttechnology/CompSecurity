// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;

// Referenced classes of package com.shazam.android.service.player:
//            e

public class PlayerMediaButtonReceiver extends BroadcastReceiver
{

    private static e a;

    public PlayerMediaButtonReceiver()
    {
    }

    public static void a(e e1)
    {
        a = e1;
    }

    public void onReceive(Context context, Intent intent)
    {
        if (a != null && "android.intent.action.MEDIA_BUTTON".equals(intent.getAction()))
        {
            a.a((KeyEvent)intent.getParcelableExtra("android.intent.extra.KEY_EVENT"));
        }
    }
}
