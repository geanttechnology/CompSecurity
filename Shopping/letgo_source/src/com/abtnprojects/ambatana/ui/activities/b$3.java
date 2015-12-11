// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.aqo;
import android.view.MenuItem;
import com.parse.ParseUser;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            b

class a extends BroadcastReceiver
{

    final b a;

    public void onReceive(Context context, Intent intent)
    {
        boolean flag = true;
        context = intent.getAction();
        aqo.a("Broadcast received : %s", new Object[] {
            context
        });
        if (context != null)
        {
            if (context.equals("com.abtnprojects.ambatana.receivers.AmbatanaBroadcastPushReceiver.USER_LOCATION_CHANGED"))
            {
                a.w = ParseUser.getCurrentUser();
            } else
            if (context.equals(com.abtnprojects.ambatana.a.toString()) && intent != null && intent.hasExtra(com.abtnprojects.ambatana.a.toString()))
            {
                int i = intent.getIntExtra(com.abtnprojects.ambatana.a.toString(), 0);
                if (a.u != null)
                {
                    context = a.u;
                    if (i <= 0)
                    {
                        flag = false;
                    }
                    context.setVisible(flag);
                    return;
                }
            }
        }
    }

    (b b1)
    {
        a = b1;
        super();
    }
}
