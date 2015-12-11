// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics.session.poller;

import android.content.Context;
import android.content.Intent;
import com.amazon.analytics.util.Preconditions;

// Referenced classes of package com.amazon.analytics.session.poller:
//            ScreenStateBroadcastReceiver

static class StateChangeListener
{

    private StateChangeListener screenChangeListener;

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

    public StateChangeListener(StateChangeListener statechangelistener)
    {
        screenChangeListener = (StateChangeListener)Preconditions.checkNotNull(statechangelistener);
    }
}
