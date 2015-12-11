// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.action;

import com.igexin.sdk.bean.BaseBean;
import com.igexin.sdk.bean.PushMessageBean;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.igexin.sdk.action:
//            AbstractPushMessageAction

public class EndAction
    implements AbstractPushMessageAction
{

    public EndAction()
    {
    }

    public boolean executeAction(PushMessageBean pushmessagebean, BaseBean basebean)
    {
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
