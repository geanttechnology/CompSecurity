// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.mopub.mobileads:
//            u

final class tReceiver extends BroadcastReceiver
{

    final u a;

    public final void onReceive(Context context, Intent intent)
    {
        boolean flag;
        if (u.a(a) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && intent != null)
        {
            context = intent.getAction();
            if ("android.intent.action.USER_PRESENT".equals(context))
            {
                u.a(a, 0);
                return;
            }
            if ("android.intent.action.SCREEN_OFF".equals(context))
            {
                u.a(a, 8);
                return;
            }
        }
    }

    tReceiver(u u1)
    {
        a = u1;
        super();
    }
}
