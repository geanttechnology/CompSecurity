// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.push.PushMessage;
import com.urbanairship.richpush.RichPushInbox;
import com.urbanairship.richpush.RichPushManager;
import com.urbanairship.richpush.RichPushMessage;

// Referenced classes of package com.urbanairship.actions:
//            Action, ActionArguments, Situation, ActionValue, 
//            ActionResult

public class OpenRichPushInboxAction extends Action
{

    public static final String DEFAULT_REGISTRY_NAME = "open_mc_action";
    public static final String DEFAULT_REGISTRY_SHORT_NAME = "^mc";
    public static final String MESSAGE_ID_PLACEHOLDER = "auto";

    public OpenRichPushInboxAction()
    {
    }

    private void startInboxActivity(Context context)
    {
        Intent intent = (new Intent("com.urbanairship.VIEW_RICH_PUSH_INBOX")).setPackage(UAirship.getPackageName()).addFlags(0x30000000);
        if (intent.resolveActivity(context.getPackageManager()) == null)
        {
            Logger.error("Unable to view the inbox. Add the intent filter to an activity that can handle viewing the inbox: <intent-filter><action android:name=\"com.urbanairship.VIEW_RICH_PUSH_INBOX\" /><category android:name=\"android.intent.category.DEFAULT\" /></intent-filter>");
            return;
        } else
        {
            context.startActivity(intent);
            return;
        }
    }

    private void startInboxMessageActivity(Context context, RichPushMessage richpushmessage)
    {
        richpushmessage = (new Intent()).setPackage(UAirship.getPackageName()).addFlags(0x30000000).setData(Uri.fromParts("message", richpushmessage.getMessageId(), null));
        richpushmessage.setAction("com.urbanairship.VIEW_RICH_PUSH_MESSAGE");
        if (richpushmessage.resolveActivity(context.getPackageManager()) == null)
        {
            richpushmessage.setAction("com.urbanairship.actions.SHOW_LANDING_PAGE_INTENT_ACTION");
            if (richpushmessage.resolveActivity(context.getPackageManager()) == null)
            {
                Logger.error("Unable to view the inbox message. Add the intent filter to an activity that can handle viewing an inbox message: <intent-filter><action android:name=\"com.urbanairship.VIEW_RICH_PUSH_MESSAGE\" /><data android:scheme=\"message\"/><category android:name=\"android.intent.category.DEFAULT\" /></intent-filter>");
                return;
            }
        }
        context.startActivity(richpushmessage);
    }

    public boolean acceptsArguments(ActionArguments actionarguments)
    {
        switch (_cls2..SwitchMap.com.urbanairship.actions.Situation[actionarguments.getSituation().ordinal()])
        {
        default:
            return false;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            return true;
        }
    }

    public ActionResult perform(final ActionArguments message)
    {
        String s = message.getValue().getString();
        if (!"auto".equalsIgnoreCase(s)) goto _L2; else goto _L1
_L1:
        PushMessage pushmessage = (PushMessage)message.getMetadata().getParcelable("com.urbanairship.PUSH_MESSAGE");
        if (pushmessage == null || pushmessage.getRichPushMessageId() == null) goto _L4; else goto _L3
_L3:
        message = pushmessage.getRichPushMessageId();
_L6:
        message = UAirship.shared().getRichPushManager().getRichPushInbox().getMessage(message);
        (new Handler(Looper.getMainLooper())).post(new _cls1());
        return ActionResult.newEmptyResult();
_L4:
        if (message.getMetadata().containsKey("com.urbanairship.RICH_PUSH_ID_METADATA"))
        {
            message = message.getMetadata().getString("com.urbanairship.RICH_PUSH_ID_METADATA");
            continue; /* Loop/switch isn't completed */
        }
_L2:
        message = s;
        if (true) goto _L6; else goto _L5
_L5:
    }



    private class _cls2
    {

        static final int $SwitchMap$com$urbanairship$actions$Situation[];

        static 
        {
            $SwitchMap$com$urbanairship$actions$Situation = new int[Situation.values().length];
            try
            {
                $SwitchMap$com$urbanairship$actions$Situation[Situation.PUSH_OPENED.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$urbanairship$actions$Situation[Situation.WEB_VIEW_INVOCATION.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$urbanairship$actions$Situation[Situation.MANUAL_INVOCATION.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$urbanairship$actions$Situation[Situation.FOREGROUND_NOTIFICATION_ACTION_BUTTON.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$urbanairship$actions$Situation[Situation.BACKGROUND_NOTIFICATION_ACTION_BUTTON.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$urbanairship$actions$Situation[Situation.PUSH_RECEIVED.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class _cls1
        implements Runnable
    {

        final OpenRichPushInboxAction this$0;
        final RichPushMessage val$message;

        public void run()
        {
            if (message != null)
            {
                startInboxMessageActivity(UAirship.getApplicationContext(), message);
                return;
            } else
            {
                startInboxActivity(UAirship.getApplicationContext());
                return;
            }
        }

        _cls1()
        {
            this$0 = OpenRichPushInboxAction.this;
            message = richpushmessage;
            super();
        }
    }

}
