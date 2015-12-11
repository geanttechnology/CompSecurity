// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.urbanairship.Autopilot;
import com.urbanairship.Logger;

// Referenced classes of package com.urbanairship.push:
//            PushMessage

public abstract class BaseIntentReceiver extends BroadcastReceiver
{

    public static final int RESULT_ACTIVITY_LAUNCHED = 1;
    public static final int RESULT_ACTIVITY_NOT_LAUNCHED = -1;

    public BaseIntentReceiver()
    {
    }

    private void handleDismissedIntent(Context context, Intent intent)
    {
        int i = intent.getIntExtra("com.urbanairship.push.NOTIFICATION_ID", -1);
        PushMessage pushmessage = (PushMessage)intent.getParcelableExtra("com.urbanairship.push.EXTRA_PUSH_MESSAGE");
        if (pushmessage == null)
        {
            Logger.error((new StringBuilder("BaseIntentReceiver - Intent is missing push message for: ")).append(intent.getAction()).toString());
            return;
        } else
        {
            onNotificationDismissed(context, pushmessage, i);
            return;
        }
    }

    private void handlePushOpened(Context context, Intent intent)
    {
        int i = intent.getIntExtra("com.urbanairship.push.NOTIFICATION_ID", -1);
        PushMessage pushmessage = (PushMessage)intent.getParcelableExtra("com.urbanairship.push.EXTRA_PUSH_MESSAGE");
        if (pushmessage == null)
        {
            Logger.error((new StringBuilder("BaseIntentReceiver - Intent is missing push message for: ")).append(intent.getAction()).toString());
        } else
        {
            boolean flag;
            if (intent.hasExtra("com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_ID"))
            {
                flag = onNotificationActionOpened(context, pushmessage, i, intent.getStringExtra("com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_ID"), intent.getBooleanExtra("com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_FOREGROUND", false));
            } else
            {
                flag = onNotificationOpened(context, pushmessage, i);
            }
            if (isOrderedBroadcast() && getResultCode() != 1)
            {
                if (flag)
                {
                    i = 1;
                } else
                {
                    i = -1;
                }
                setResultCode(i);
                return;
            }
        }
    }

    private void handlePushReceived(Context context, Intent intent)
    {
        PushMessage pushmessage = (PushMessage)intent.getParcelableExtra("com.urbanairship.push.EXTRA_PUSH_MESSAGE");
        if (pushmessage == null)
        {
            Logger.error((new StringBuilder("BaseIntentReceiver - Intent is missing push message for: ")).append(intent.getAction()).toString());
            return;
        }
        if (intent.hasExtra("com.urbanairship.push.NOTIFICATION_ID"))
        {
            onPushReceived(context, pushmessage, intent.getIntExtra("com.urbanairship.push.NOTIFICATION_ID", -1));
            return;
        } else
        {
            onBackgroundPushReceived(context, pushmessage);
            return;
        }
    }

    private void handleRegistrationIntent(Context context, Intent intent)
    {
        if (intent.hasExtra("com.urbanairship.push.EXTRA_ERROR"))
        {
            onChannelRegistrationFailed(context);
            return;
        }
        String s = intent.getStringExtra("com.urbanairship.push.EXTRA_CHANNEL_ID");
        if (s == null)
        {
            Logger.error((new StringBuilder("BaseIntentReceiver - Intent is missing channel ID for: ")).append(intent.getAction()).toString());
            return;
        } else
        {
            onChannelRegistrationSucceeded(context, s);
            return;
        }
    }

    protected abstract void onBackgroundPushReceived(Context context, PushMessage pushmessage);

    protected abstract void onChannelRegistrationFailed(Context context);

    protected abstract void onChannelRegistrationSucceeded(Context context, String s);

    protected abstract boolean onNotificationActionOpened(Context context, PushMessage pushmessage, int i, String s, boolean flag);

    protected void onNotificationDismissed(Context context, PushMessage pushmessage, int i)
    {
    }

    protected abstract boolean onNotificationOpened(Context context, PushMessage pushmessage, int i);

    protected abstract void onPushReceived(Context context, PushMessage pushmessage, int i);

    public void onReceive(Context context, Intent intent)
    {
        String s;
        byte byte0;
        Autopilot.automaticTakeOff(context);
        if (intent == null || intent.getAction() == null)
        {
            return;
        }
        s = intent.getAction();
        Logger.info((new StringBuilder()).append(getClass().getSimpleName()).append(" - Received intent with action: ").append(s).toString());
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 4: default 104
    //                   -1779743672: 144
    //                   -1678512904: 174
    //                   -618294128: 159
    //                   122500866: 189;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_189;
_L6:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            handlePushReceived(context, intent);
            return;

        case 1: // '\001'
            handlePushOpened(context, intent);
            return;

        case 2: // '\002'
            handleRegistrationIntent(context, intent);
            return;

        case 3: // '\003'
            handleDismissedIntent(context, intent);
            break;
        }
        break MISSING_BLOCK_LABEL_224;
_L2:
        if (s.equals("com.urbanairship.push.RECEIVED"))
        {
            byte0 = 0;
        }
          goto _L6
_L4:
        if (s.equals("com.urbanairship.push.OPENED"))
        {
            byte0 = 1;
        }
          goto _L6
_L3:
        if (s.equals("com.urbanairship.push.CHANNEL_UPDATED"))
        {
            byte0 = 2;
        }
          goto _L6
        if (s.equals("com.urbanairship.push.DISMISSED"))
        {
            byte0 = 3;
        }
          goto _L6
    }
}
