// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

public class DisplayBroadcastReceiver extends BroadcastReceiver
{

    final Context a;
    boolean b;
    Point c;

    public DisplayBroadcastReceiver(Context context)
    {
        a = context;
        c = new Point();
        context = new IntentFilter();
        context.addAction("android.intent.action.HDMI_PLUGGED");
        context = a.registerReceiver(null, context);
        onReceive(a, context);
    }

    private void c()
    {
        this;
        JVM INSTR monitorenter ;
        ((WindowManager)a.getSystemService("window")).getDefaultDisplay().getSize(c);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a()
    {
        Object obj = new IntentFilter();
        ((IntentFilter) (obj)).addAction("android.intent.action.HDMI_PLUGGED");
        obj = a.registerReceiver(this, ((IntentFilter) (obj)));
        onReceive(a, ((Intent) (obj)));
    }

    public void b()
    {
        a.unregisterReceiver(this);
    }

    public void onReceive(Context context, Intent intent)
    {
        if (intent != null)
        {
            if ((context = intent.getAction()) != null && context.equals("android.intent.action.HDMI_PLUGGED"))
            {
                b = intent.getBooleanExtra("state", false);
                c();
                return;
            }
        }
    }
}
