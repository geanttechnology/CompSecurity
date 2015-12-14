// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.cyberlink.you.chat.n;
import java.util.Locale;

// Referenced classes of package com.cyberlink.you:
//            a

class astReceiver extends BroadcastReceiver
{

    final a a;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getAction();
        if (context != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!context.equals("android.intent.action.SCREEN_OFF"))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!com.cyberlink.you.a.i(a))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!com.cyberlink.you.a.j(a)) goto _L1; else goto _L3
_L3:
        Log.w("ConnectionManager", "Screen Off: Stamina Enabled, disconnect");
        n.b = false;
        n.a().e();
        return;
        if (!Build.MANUFACTURER.toUpperCase(Locale.US).contains("SONY")) goto _L1; else goto _L4
_L4:
        com.cyberlink.you.a.c(a, false);
        com.cyberlink.you.a.a(a, "");
        com.cyberlink.you.a.b(a, "");
        return;
        if (!context.equals("android.intent.action.SCREEN_ON") || !com.cyberlink.you.a.i(a) || !com.cyberlink.you.a.j(a)) goto _L1; else goto _L5
_L5:
        Log.w("ConnectionManager", "Screen On: Stamina Enabled, reconnect");
        a.e();
        return;
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
