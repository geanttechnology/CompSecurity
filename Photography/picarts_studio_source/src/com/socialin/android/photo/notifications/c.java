// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.picsart.studio.ads.g;
import com.socialin.android.e;

// Referenced classes of package com.socialin.android.photo.notifications:
//            a

final class c extends BroadcastReceiver
{

    private a a;

    private c(a a1)
    {
        a = a1;
        super();
    }

    c(a a1, byte byte0)
    {
        this(a1);
    }

    public final void onReceive(Context context, Intent intent)
    {
        int i;
        if (!com.socialin.android.photo.notifications.a.j(a))
        {
            return;
        }
        i = intent.getIntExtra("extra.result.code", 2);
        context = intent.getExtras().getString("extra.result.action");
        if (i == 2) goto _L2; else goto _L1
_L1:
        i = -1;
        context.hashCode();
        JVM INSTR lookupswitch 3: default 76
    //                   -328627421: 112
    //                   558589027: 140
    //                   1055201153: 126;
           goto _L3 _L4 _L5 _L6
_L3:
        i;
        JVM INSTR tableswitch 0 2: default 104
    //                   0 154
    //                   1 154
    //                   2 162;
           goto _L2 _L7 _L7 _L8
_L2:
        com.socialin.android.photo.notifications.a.h(a);
        return;
_L4:
        if (context.equals("action.refresh"))
        {
            i = 0;
        }
          goto _L3
_L6:
        if (context.equals("action.update"))
        {
            i = 1;
        }
          goto _L3
_L5:
        if (context.equals("action.delete"))
        {
            i = 2;
        }
          goto _L3
_L7:
        a.e();
        return;
_L8:
        if (com.socialin.android.photo.notifications.a.f(a) != null && !com.socialin.android.photo.notifications.a.f(a).isEmpty())
        {
            com.socialin.android.photo.notifications.a.f(a).clear();
            com.socialin.android.photo.notifications.a.i(a).a(0);
            com.socialin.android.photo.notifications.a.g(a);
        }
          goto _L2
    }
}
