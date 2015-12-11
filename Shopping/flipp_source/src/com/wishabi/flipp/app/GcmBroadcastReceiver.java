// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.bl;
import android.support.v4.app.bp;
import android.support.v4.app.bq;
import android.support.v4.app.bs;

// Referenced classes of package com.wishabi.flipp.app:
//            MainActivity

public class GcmBroadcastReceiver extends BroadcastReceiver
{

    public GcmBroadcastReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        intent = intent.getExtras();
        Object obj;
        String s;
        if (intent != null)
        {
            if ((obj = intent.getString("title")) != null && (s = intent.getString("message")) != null)
            {
                intent = intent.getString("url");
                Resources resources;
                if (intent == null)
                {
                    intent = null;
                } else
                {
                    intent = Uri.parse(intent);
                }
                resources = context.getResources();
                if (resources != null)
                {
                    Intent intent1 = new Intent(context, com/wishabi/flipp/app/MainActivity);
                    if (intent != null)
                    {
                        intent1.setData(intent);
                    }
                    intent1.putExtra("EXTRA_OPENED_BY_PUSH_PLATFORM", "gcm");
                    intent = PendingIntent.getActivity(context, 1, intent1, 0x8000000);
                    obj = (new bq(context)).a(((CharSequence) (obj))).b(s).a((new bp()).a(s)).a(0x7f0200c9);
                    obj.y = resources.getColor(0x7f09005d);
                    obj.d = intent;
                    obj.j = 2;
                    intent = ((bq) (obj)).a();
                    intent = bl.a().a(intent);
                    ((NotificationManager)context.getSystemService("notification")).notify(0, intent);
                    return;
                }
            }
        }
    }
}
