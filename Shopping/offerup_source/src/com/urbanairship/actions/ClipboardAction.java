// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions;

import android.os.Handler;
import android.os.Looper;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;

// Referenced classes of package com.urbanairship.actions:
//            Action, ActionArguments, Situation, ActionValue, 
//            ActionResult

public class ClipboardAction extends Action
{

    public static final String DEFAULT_REGISTRY_NAME = "clipboard_action";
    public static final String DEFAULT_REGISTRY_SHORT_NAME = "^c";
    public static final String LABEL_KEY = "label";
    public static final String TEXT_KEY = "text";

    public ClipboardAction()
    {
    }

    public boolean acceptsArguments(ActionArguments actionarguments)
    {
        if (actionarguments.getSituation() != Situation.PUSH_RECEIVED)
        {
            if (actionarguments.getValue().getMap() != null)
            {
                return actionarguments.getValue().getMap().get("text").isString();
            }
            if (actionarguments.getValue().getString() != null)
            {
                return true;
            }
        }
        return false;
    }

    public ActionResult perform(ActionArguments actionarguments)
    {
        final String label;
        final String text;
        if (actionarguments.getValue().getMap() != null)
        {
            text = actionarguments.getValue().getMap().get("text").getString();
            label = actionarguments.getValue().getMap().get("label").getString();
        } else
        {
            text = actionarguments.getValue().getString();
            label = null;
        }
        (new Handler(Looper.getMainLooper())).post(new _cls1());
        return ActionResult.newResult(actionarguments.getValue());
    }

    private class _cls1
        implements Runnable
    {

        final ClipboardAction this$0;
        final String val$label;
        final String val$text;

        public void run()
        {
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                ((ClipboardManager)UAirship.getApplicationContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(label, text));
                return;
            } else
            {
                ((android.text.ClipboardManager)UAirship.getApplicationContext().getSystemService("clipboard")).setText(text);
                return;
            }
        }

        _cls1()
        {
            this$0 = ClipboardAction.this;
            label = s;
            text = s1;
            super();
        }
    }

}
