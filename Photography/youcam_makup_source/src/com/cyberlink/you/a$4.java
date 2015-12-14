// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package com.cyberlink.you:
//            a

class astReceiver extends BroadcastReceiver
{

    final a a;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getAction();
        break MISSING_BLOCK_LABEL_5;
        if (context != null && context.equals(com.cyberlink.you.a.k(a)))
        {
            com.cyberlink.you.a.e(a, true);
            context = intent.getExtras();
            if (context != null)
            {
                boolean flag = context.getBoolean("state");
                com.cyberlink.you.a.f(a, Boolean.valueOf(flag).booleanValue());
                return;
            }
        }
        return;
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
