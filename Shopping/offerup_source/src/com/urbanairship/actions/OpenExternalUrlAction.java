// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions;

import android.content.Context;
import android.content.Intent;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.util.UriUtils;

// Referenced classes of package com.urbanairship.actions:
//            Action, ActionArguments, Situation, ActionValue, 
//            ActionResult

public class OpenExternalUrlAction extends Action
{

    public static final String DEFAULT_REGISTRY_NAME = "open_external_url_action";
    public static final String DEFAULT_REGISTRY_SHORT_NAME = "^u";

    public OpenExternalUrlAction()
    {
    }

    public boolean acceptsArguments(ActionArguments actionarguments)
    {
        _cls1..SwitchMap.com.urbanairship.actions.Situation[actionarguments.getSituation().ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 42
    //                   2 42
    //                   3 42
    //                   4 42;
           goto _L1 _L2 _L2 _L2 _L2
_L1:
        return false;
_L2:
        if (UriUtils.parse(actionarguments.getValue().getString()) != null)
        {
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public ActionResult perform(ActionArguments actionarguments)
    {
        Object obj = UriUtils.parse(actionarguments.getValue().getString());
        Logger.info((new StringBuilder("Opening URI: ")).append(obj).toString());
        obj = new Intent("android.intent.action.VIEW", ((android.net.Uri) (obj)));
        ((Intent) (obj)).addFlags(0x10000000);
        UAirship.getApplicationContext().startActivity(((Intent) (obj)));
        return ActionResult.newResult(actionarguments.getValue());
    }

    private class _cls1
    {

        static final int $SwitchMap$com$urbanairship$actions$Situation[];

        static 
        {
            $SwitchMap$com$urbanairship$actions$Situation = new int[Situation.values().length];
            try
            {
                $SwitchMap$com$urbanairship$actions$Situation[Situation.PUSH_OPENED.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$urbanairship$actions$Situation[Situation.WEB_VIEW_INVOCATION.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$urbanairship$actions$Situation[Situation.MANUAL_INVOCATION.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$urbanairship$actions$Situation[Situation.FOREGROUND_NOTIFICATION_ACTION_BUTTON.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
