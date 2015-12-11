// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.action;

import android.content.Intent;
import android.net.Uri;
import com.igexin.sdk.SdkService;
import com.igexin.sdk.bean.BaseBean;
import com.igexin.sdk.bean.PushMessageBean;
import com.igexin.sdk.bean.StartWebBean;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.igexin.sdk.action:
//            AbstractPushMessageAction, PushMessageAction

public class StartWebAction
    implements AbstractPushMessageAction
{

    public StartWebAction()
    {
    }

    public boolean executeAction(PushMessageBean pushmessagebean, BaseBean basebean)
    {
        basebean = (StartWebBean)basebean;
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(0x10000000);
        intent.setData(Uri.parse(basebean.getFinalUrl()));
        SdkService.getInstance().startActivity(intent);
        PushMessageAction.getInstance().executePushMessageAction(pushmessagebean, basebean.getDoActionId());
        return true;
    }

    public BaseBean parseAction(JSONObject jsonobject)
    {
        StartWebBean startwebbean;
        String s = jsonobject.getString("url");
        if (s.equals("") || !s.startsWith("http://"))
        {
            break MISSING_BLOCK_LABEL_131;
        }
        startwebbean = new StartWebBean();
        startwebbean.setType(jsonobject.getString("type"));
        startwebbean.setActionId(jsonobject.getString("actionid"));
        startwebbean.setDoActionId(jsonobject.getString("do"));
        startwebbean.setUrl(s);
        if (jsonobject.has("is_withcid") && jsonobject.getString("is_withcid").equals("true"))
        {
            startwebbean.setWithCid(true);
        }
        if (jsonobject.has("is_withnettype") && jsonobject.getString("is_withnettype").equals("true"))
        {
            startwebbean.setNetType(true);
        }
        return startwebbean;
        jsonobject;
        jsonobject.printStackTrace();
        return null;
    }

    public com.igexin.sdk.Consts.ActionPrepareState prepareExecuteAction(PushMessageBean pushmessagebean, BaseBean basebean)
    {
        return com.igexin.sdk.Consts.ActionPrepareState.success;
    }
}
