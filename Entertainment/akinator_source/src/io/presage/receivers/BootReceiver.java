// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.receivers;

import android.content.Context;
import android.content.Intent;
import io.presage.Presage;
import io.presage.utils.do.a;
import io.presage.utils.e;
import java.util.HashMap;

// Referenced classes of package io.presage.receivers:
//            AbstractReceiver

public class BootReceiver extends AbstractReceiver
{

    public BootReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if (("android.intent.action.BOOT_COMPLETED".equals(intent.getAction()) || "io.presage.receivers.BootReceiver.RESTART_SERVICE".equals(intent.getAction()) || "android.intent.action.DATE_CHANGED".equals(intent.getAction())) && Presage.getInstance().getService() == null)
        {
            Presage.getInstance().setContext(context.getApplicationContext());
            Presage.getInstance().start();
        }
        context = new HashMap();
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction()))
        {
            context.put("event", "boot_completed");
        }
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()))
        {
            Presage.getInstance().pause();
            context.put("event", "screen_off");
        }
        if ("android.intent.action.SCREEN_ON".equals(intent.getAction()))
        {
            Presage.getInstance().restart();
            context.put("event", "screen_on");
        }
        if (!context.isEmpty())
        {
            e.b(new String[] {
                "BootReceiver", "Send event:", context.get("event").toString()
            });
            a().a("event", context);
        }
    }
}
