// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.action;

import com.igexin.sdk.bean.BaseBean;
import com.igexin.sdk.bean.PushMessageBean;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.igexin.sdk.action:
//            AbstractPushMessageAction, PushMessageAction

public class GotoAction
    implements AbstractPushMessageAction
{

    public GotoAction()
    {
    }

    public boolean executeAction(PushMessageBean pushmessagebean, BaseBean basebean)
    {
        if (pushmessagebean != null && basebean != null)
        {
            PushMessageAction.getInstance().executePushMessageAction(pushmessagebean, basebean.getDoActionId());
        }
        return true;
    }

    public BaseBean parseAction(JSONObject jsonobject)
    {
        BaseBean basebean;
        try
        {
            basebean = new BaseBean();
            basebean.setType(jsonobject.getString("type"));
            basebean.setActionId(jsonobject.getString("actionid"));
            basebean.setDoActionId(jsonobject.getString("do"));
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
            return null;
        }
        return basebean;
    }

    public com.igexin.sdk.Consts.ActionPrepareState prepareExecuteAction(PushMessageBean pushmessagebean, BaseBean basebean)
    {
        return com.igexin.sdk.Consts.ActionPrepareState.success;
    }
}
