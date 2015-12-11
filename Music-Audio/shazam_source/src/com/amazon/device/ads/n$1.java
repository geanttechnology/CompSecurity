// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.amazon.device.ads:
//            n, h, d

final class eceiver extends BroadcastReceiver
{

    final n a;

    public final void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF") && n.a(a))
        {
            n.b(a).j.a();
        }
    }

    eceiver(n n1)
    {
        a = n1;
        super();
    }
}
