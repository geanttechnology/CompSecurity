// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.urbanairship.UAirship;
import com.urbanairship.push.PushMessage;
import com.urbanairship.richpush.RichPushInbox;
import com.urbanairship.richpush.RichPushManager;

// Referenced classes of package com.urbanairship.actions:
//            Action, ActionArguments, Situation, ActionValue, 
//            ActionResult

public class OverlayRichPushMessageAction extends Action
{

    public static final String DEFAULT_REGISTRY_NAME = "open_mc_overlay_action";
    public static final String DEFAULT_REGISTRY_SHORT_NAME = "^mco";
    public static final String MESSAGE_ID_PLACEHOLDER = "auto";

    public OverlayRichPushMessageAction()
    {
    }

    public boolean acceptsArguments(ActionArguments actionarguments)
    {
        _cls2..SwitchMap.com.urbanairship.actions.Situation[actionarguments.getSituation().ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 42
    //                   2 42
    //                   3 42
    //                   4 42;
           goto _L1 _L2 _L2 _L2 _L2
_L1:
        return false;
_L2:
        if (actionarguments.getValue().getString() != null)
        {
            if ("auto".equalsIgnoreCase(actionarguments.getValue().getString()))
            {
                if (actionarguments.getMetadata().containsKey("com.urbanairship.RICH_PUSH_ID_METADATA") || actionarguments.getMetadata().containsKey("com.urbanairship.PUSH_MESSAGE"))
                {
                    return true;
                }
            } else
            {
                return true;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public ActionResult perform(ActionArguments actionarguments)
    {
        final Object message = actionarguments.getValue().getString();
        if (!((String) (message)).equalsIgnoreCase("auto")) goto _L2; else goto _L1
_L1:
        PushMessage pushmessage = (PushMessage)actionarguments.getMetadata().getParcelable("com.urbanairship.PUSH_MESSAGE");
        if (pushmessage == null || pushmessage.getRichPushMessageId() == null) goto _L4; else goto _L3
_L3:
        actionarguments = pushmessage.getRichPushMessageId();
_L6:
        message = UAirship.shared().getRichPushManager().getRichPushInbox().getMessage(actionarguments);
        if (message == null)
        {
            return ActionResult.newErrorResult(new Exception((new StringBuilder("Unable to find message with ID ")).append(actionarguments).toString()));
        } else
        {
            (new Handler(Looper.getMainLooper())).post(new _cls1());
            return ActionResult.newEmptyResult();
        }
_L4:
        if (actionarguments.getMetadata().containsKey("com.urbanairship.RICH_PUSH_ID_METADATA"))
        {
            actionarguments = actionarguments.getMetadata().getString("com.urbanairship.RICH_PUSH_ID_METADATA");
            continue; /* Loop/switch isn't completed */
        }
_L2:
        actionarguments = ((ActionArguments) (message));
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

        final OverlayRichPushMessageAction this$0;
        final RichPushMessage val$message;

        public void run()
        {
            Intent intent = (new Intent("com.urbanairship.actions.SHOW_LANDING_PAGE_INTENT_ACTION")).setPackage(UAirship.getPackageName()).addFlags(0x30000000).setData(Uri.fromParts("message", message.getMessageId(), null));
            try
            {
                UAirship.getApplicationContext().startActivity(intent);
                return;
            }
            catch (ActivityNotFoundException activitynotfoundexception)
            {
                Logger.error("Unable to view the inbox message in a landing page. The landing page activity is either missing in the manifest or does not include the message scheme in its intent filter.");
            }
        }

        _cls1()
        {
            this$0 = OverlayRichPushMessageAction.this;
            message = richpushmessage;
            super();
        }
    }

}
