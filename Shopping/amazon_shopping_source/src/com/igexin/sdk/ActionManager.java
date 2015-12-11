// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk;

import com.igexin.sdk.bean.PushMessageBean;
import com.igexin.sdk.data.BasicDataManager;
import com.igexin.sdk.data.ConfigDataManager;
import com.igexin.sdk.data.PhoneInfo;
import com.igexin.sdk.task.FeedbackTask;
import com.igexin.sdk.task.GetConfigTask;
import com.igexin.sdk.task.RegisterTask;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;

// Referenced classes of package com.igexin.sdk:
//            Consts, CallbackListener

public class ActionManager
{

    private static ActionManager instance;

    public ActionManager()
    {
    }

    public static ActionManager getInstance()
    {
        if (instance == null)
        {
            instance = new ActionManager();
        }
        return instance;
    }

    public void feedback(PushMessageBean pushmessagebean, String s, CallbackListener callbacklistener)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("action", "slavefeedback");
        hashmap.put("vcid", BasicDataManager.vcid);
        hashmap.put("appid", Consts.VPUSH_APPID);
        hashmap.put("taskid_master", pushmessagebean.getMasterTaskId());
        hashmap.put("message_master", pushmessagebean.getMasterMessageId());
        hashmap.put("taskid", pushmessagebean.getTaskId());
        hashmap.put("messageid", pushmessagebean.getMessageId());
        hashmap.put("actionid", s);
        hashmap.put("result", "ok");
        hashmap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        pushmessagebean = JSONObject.toJSONString(hashmap).getBytes();
        (new FeedbackTask(Consts.PS_URL, pushmessagebean, callbacklistener, ConfigDataManager.getEncryptEnable())).start();
    }

    public void getConfig(CallbackListener callbacklistener)
    {
        try
        {
            HashMap hashmap = new HashMap();
            hashmap.put("action", "sdkconfig");
            hashmap.put("cid", BasicDataManager.vcid);
            hashmap.put("appid", Consts.VPUSH_APPID);
            hashmap.put("sdk_version", "v1.0.0");
            byte abyte0[] = JSONObject.toJSONString(hashmap).getBytes();
            (new GetConfigTask(Consts.PS_URL, abyte0, callbacklistener)).start();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (CallbackListener callbacklistener)
        {
            callbacklistener.printStackTrace();
        }
    }

    public void register(List list, boolean flag, boolean flag1, CallbackListener callbacklistener)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("action", "slavebind");
        hashmap.put("vcid", BasicDataManager.vcid);
        hashmap.put("registerid", BasicDataManager.regId);
        hashmap.put("appid", Consts.VPUSH_APPID);
        hashmap.put("master_cids", list);
        hashmap.put("info", BasicDataManager.phoneInfo.getJsonMap());
        hashmap.put("isCIDUpdate", Boolean.valueOf(flag));
        hashmap.put("isInfoUpdate", Boolean.valueOf(flag1));
        list = JSONObject.toJSONString(hashmap).getBytes();
        (new RegisterTask(Consts.PS_URL, list, callbacklistener, ConfigDataManager.getEncryptEnable())).start();
    }
}
