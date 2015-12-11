// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.action;

import android.content.ContentValues;
import com.igexin.sdk.CallbackListener;
import com.igexin.sdk.SdkService;
import com.igexin.sdk.bean.PopupBean;
import com.igexin.sdk.bean.PushMessageBean;
import com.igexin.sdk.data.BasicDataManager;
import com.igexin.sdk.db.DBHelper;
import java.io.PrintStream;
import java.util.Map;

// Referenced classes of package com.igexin.sdk.action:
//            PopupAction, PushMessageAction

class val.actionId
    implements CallbackListener
{

    String catchId;
    PopupBean popupBean;
    PushMessageBean pushMessageBean;
    final PopupAction this$0;
    final String val$actionId;
    final String val$imgUrl;
    final String val$messageId;
    final String val$taskId;

    public void exceptionHandler(Exception exception)
    {
        System.out.println("download popup img failed!");
        if (PushMessageAction.getInstance().getPrepareWaitActionCounts(val$taskId, true) == 0)
        {
            PushMessageAction.getInstance().executePushMessageAction(pushMessageBean, "1");
        }
    }

    public void getCallbackData(Object obj)
    {
        obj = (String)obj;
        if (!"".equals(obj))
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("imageurl", val$imgUrl);
            contentvalues.put("imagesrc", ((String) (obj)));
            contentvalues.put("taskid", val$taskId);
            contentvalues.put("createtime", Long.valueOf(System.currentTimeMillis()));
            popupBean.setImg_src(((String) (obj)));
            SdkService.getInstance().getDBHelper().insert("image", contentvalues);
        }
        if (PushMessageAction.getInstance().getPrepareWaitActionCounts(val$taskId, true) == 0)
        {
            PushMessageAction.getInstance().executePushMessageAction(pushMessageBean, "1");
        }
    }

    ()
    {
        this$0 = final_popupaction;
        val$taskId = s;
        val$messageId = s1;
        val$actionId = s2;
        val$imgUrl = String.this;
        super();
        catchId = PushMessageAction.getInstance().getPushMessageCacheId(val$taskId, val$messageId);
        pushMessageBean = (PushMessageBean)BasicDataManager.pushMessageMap.get(catchId);
        popupBean = (PopupBean)pushMessageBean.getBean(val$actionId);
    }
}
