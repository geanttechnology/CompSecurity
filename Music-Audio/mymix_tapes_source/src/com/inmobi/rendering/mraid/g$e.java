// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.inmobi.commons.core.utilities.Logger;

// Referenced classes of package com.inmobi.rendering.mraid:
//            g

final class er extends BroadcastReceiver
{

    final g a;
    private final String b = com/inmobi/rendering/mraid/g$e.getSimpleName();

    public void onReceive(Context context, Intent intent)
    {
        if (intent != null)
        {
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()))
            {
                Logger.a(com.inmobi.commons.core.utilities.er.InternalLogLevel.INTERNAL, b, "Screen OFF");
                if (b == a.c)
                {
                    g.a(a, true);
                    a.pause();
                }
            } else
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction()))
            {
                Logger.a(com.inmobi.commons.core.utilities.er.InternalLogLevel.INTERNAL, b, "Screen ON");
                if (g.a(a) && c == a.c)
                {
                    g.a(a, false);
                    a.a();
                    return;
                }
            }
        }
    }

    es.Logger(g g1)
    {
        a = g1;
        super();
    }
}
