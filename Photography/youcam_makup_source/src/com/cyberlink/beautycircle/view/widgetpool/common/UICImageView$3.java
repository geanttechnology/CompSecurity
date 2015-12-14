// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            UICImageView

class a extends BroadcastReceiver
{

    final UICImageView a;

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") && UICImageView.c(a) != null)
        {
            intent = UICImageView.c(a).getActiveNetworkInfo();
            boolean flag;
            if (intent != null && intent.isConnectedOrConnecting())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                if (context != null)
                {
                    context.unregisterReceiver(this);
                }
                UICImageView.d(a);
            }
        }
    }

    (UICImageView uicimageview)
    {
        a = uicimageview;
        super();
    }
}
