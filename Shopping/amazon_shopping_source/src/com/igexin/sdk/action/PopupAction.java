// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.action;

import android.content.ContentValues;
import android.content.Intent;
import com.igexin.sdk.CallbackListener;
import com.igexin.sdk.SdkActivity;
import com.igexin.sdk.SdkService;
import com.igexin.sdk.bean.BaseBean;
import com.igexin.sdk.bean.ButtonBean;
import com.igexin.sdk.bean.PopupBean;
import com.igexin.sdk.bean.PushMessageBean;
import com.igexin.sdk.data.BasicDataManager;
import com.igexin.sdk.db.DBHelper;
import com.igexin.sdk.task.DownloadRealImageTask;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.igexin.sdk.action:
//            AbstractPushMessageAction, PushMessageAction

public class PopupAction
    implements AbstractPushMessageAction
{

    public PopupAction()
    {
    }

    public boolean executeAction(PushMessageBean pushmessagebean, BaseBean basebean)
    {
        basebean = new Intent();
        basebean.putExtra("action", "popup");
        basebean.putExtra("messageId", pushmessagebean.getMessageId());
        basebean.putExtra("taskId", pushmessagebean.getTaskId());
        basebean.setFlags(0x14000000);
        basebean.setAction((new StringBuilder()).append("com.igexin.action.popupact.").append(SdkService.getInstance().getPackageName()).toString());
        basebean.setClass(SdkService.getInstance(), com/igexin/sdk/SdkActivity);
        SdkService.getInstance().startActivity(basebean);
        return true;
    }

    public BaseBean parseAction(JSONObject jsonobject)
    {
        if (!SdkService.getInstance().isSdkActivitySet())
        {
            break MISSING_BLOCK_LABEL_200;
        }
        PopupBean popupbean;
        ArrayList arraylist;
        popupbean = new PopupBean();
        popupbean.setType(jsonobject.getString("type"));
        popupbean.setActionId(jsonobject.getString("actionid"));
        popupbean.setDoActionId(jsonobject.getString("do"));
        popupbean.setTitle(jsonobject.getString("title"));
        popupbean.setContent(jsonobject.getString("text"));
        if (jsonobject.has("img"))
        {
            popupbean.setImageUrl(jsonobject.getString("img"));
        }
        if (!jsonobject.has("buttons"))
        {
            break MISSING_BLOCK_LABEL_193;
        }
        arraylist = new ArrayList();
        jsonobject = jsonobject.getJSONArray("buttons");
        if (jsonobject.length() <= 0) goto _L2; else goto _L1
_L1:
        int i = 0;
_L3:
        if (i >= jsonobject.length())
        {
            break; /* Loop/switch isn't completed */
        }
        ButtonBean buttonbean = new ButtonBean();
        JSONObject jsonobject1 = jsonobject.getJSONObject(i);
        buttonbean.setText(jsonobject1.getString("text"));
        buttonbean.setDoActionId(jsonobject1.getString("do"));
        arraylist.add(buttonbean);
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        popupbean.setButtons(arraylist);
        return popupbean;
        jsonobject;
        jsonobject.printStackTrace();
        return null;
    }

    public com.igexin.sdk.Consts.ActionPrepareState prepareExecuteAction(PushMessageBean pushmessagebean, BaseBean basebean)
    {
        com.igexin.sdk.Consts.ActionPrepareState actionpreparestate;
label0:
        {
            actionpreparestate = com.igexin.sdk.Consts.ActionPrepareState.success;
            basebean = (PopupBean)basebean;
            final String imgUrl = basebean.getImageUrl();
            final String taskId = pushmessagebean.getTaskId();
            final String messageId = pushmessagebean.getMessageId();
            final String actionId = basebean.getActionId();
            pushmessagebean = actionpreparestate;
            if (imgUrl != null)
            {
                pushmessagebean = actionpreparestate;
                if (imgUrl.startsWith("http://"))
                {
                    pushmessagebean = SdkService.getInstance().getDownloadImgCache(imgUrl);
                    if (!pushmessagebean.equals(""))
                    {
                        break label0;
                    }
                    (new DownloadRealImageTask(imgUrl, taskId, actionId, 1, new CallbackListener() {

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
                            if (PushMessageAction.getInstance().getPrepareWaitActionCounts(taskId, true) == 0)
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
                                contentvalues.put("imageurl", imgUrl);
                                contentvalues.put("imagesrc", ((String) (obj)));
                                contentvalues.put("taskid", taskId);
                                contentvalues.put("createtime", Long.valueOf(System.currentTimeMillis()));
                                popupBean.setImg_src(((String) (obj)));
                                SdkService.getInstance().getDBHelper().insert("image", contentvalues);
                            }
                            if (PushMessageAction.getInstance().getPrepareWaitActionCounts(taskId, true) == 0)
                            {
                                PushMessageAction.getInstance().executePushMessageAction(pushMessageBean, "1");
                            }
                        }

            
            {
                this$0 = PopupAction.this;
                taskId = s;
                messageId = s1;
                actionId = s2;
                imgUrl = s3;
                super();
                catchId = PushMessageAction.getInstance().getPushMessageCacheId(taskId, messageId);
                pushMessageBean = (PushMessageBean)BasicDataManager.pushMessageMap.get(catchId);
                popupBean = (PopupBean)pushMessageBean.getBean(actionId);
            }
                    })).start();
                    pushmessagebean = com.igexin.sdk.Consts.ActionPrepareState.wait;
                }
            }
            return pushmessagebean;
        }
        basebean.setImg_src(pushmessagebean);
        return actionpreparestate;
    }
}
