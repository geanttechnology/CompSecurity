// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoteControlReceiver extends BroadcastReceiver
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/videoplay/RemoteControlReceiver);

    public RemoteControlReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if ("android.intent.action.MEDIA_BUTTON".equals(intent.getAction()))
        {
            intent = (KeyEvent)intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
            Intent intent1 = new Intent("com.xfinity.playerlib.videoplay.KEY_PRESSED");
            intent1.putExtra("android.intent.extra.KEY_EVENT", intent);
            context.sendBroadcast(intent1);
        }
    }

}
