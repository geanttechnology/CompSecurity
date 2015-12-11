// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.model.common;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.apptentive.android.sdk.module.engagement.interaction.model.common:
//            DismissAction, LaunchInteractionAction, Action

public class onAction
{

    public static Action parseAction(String s)
    {
        onAction onaction;
        onaction = nown;
        JSONObject jsonobject = new JSONObject(s);
        if (jsonobject.has("action"))
        {
            onaction = se(jsonobject.getString("action"));
        }
        hMap.com.apptentive.android.sdk.module.engagement.interaction.model.common.Action.Type[onaction.inal()];
        JVM INSTR tableswitch 1 2: default 84
    //                   1 64
    //                   2 73;
           goto _L1 _L2 _L3
_L2:
        return new DismissAction(s);
_L3:
        s = new LaunchInteractionAction(s);
        return s;
_L1:
        return null;
        s;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public onAction()
    {
    }
}
