// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics.session.poller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.analytics.util.Preconditions;

public class ScreenStateBroadcastReceiver extends BroadcastReceiver
{
    static class Logic
    {

        private ScreenStateChangeListener screenChangeListener;

        public void onReceive(Context context, Intent intent)
        {
            context = intent.getAction();
            if (context.equals("android.intent.action.SCREEN_ON"))
            {
                screenChangeListener.onScreenOn();
            } else
            if (context.equals("android.intent.action.SCREEN_OFF"))
            {
                screenChangeListener.onScreenOff();
                return;
            }
        }

        public Logic(ScreenStateChangeListener screenstatechangelistener)
        {
            screenChangeListener = (ScreenStateChangeListener)Preconditions.checkNotNull(screenstatechangelistener);
        }
    }

    public static interface ScreenStateChangeListener
    {

        public abstract void onScreenOff();

        public abstract void onScreenOn();
    }


    private final Logic logic;

    public ScreenStateBroadcastReceiver(ScreenStateChangeListener screenstatechangelistener)
    {
        logic = new Logic(screenstatechangelistener);
    }

    public void onReceive(Context context, Intent intent)
    {
        logic.onReceive(context, intent);
    }
}
