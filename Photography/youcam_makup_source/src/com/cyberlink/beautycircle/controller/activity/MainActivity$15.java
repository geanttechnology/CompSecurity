// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.c;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            MainActivity

class a extends BroadcastReceiver
{

    final MainActivity a;

    public void onReceive(Context context, Intent intent)
    {
        if (!c.a())
        {
            a.a(context.getString(m.bc_server_connect_fail), true);
            return;
        } else
        {
            a.m();
            return;
        }
    }

    (MainActivity mainactivity)
    {
        a = mainactivity;
        super();
    }
}
