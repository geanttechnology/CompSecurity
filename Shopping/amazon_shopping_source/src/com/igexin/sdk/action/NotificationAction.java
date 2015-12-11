// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.action;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.widget.RemoteViews;
import com.igexin.sdk.CallbackListener;
import com.igexin.sdk.Consts;
import com.igexin.sdk.SdkService;
import com.igexin.sdk.bean.BaseBean;
import com.igexin.sdk.bean.NotificationBean;
import com.igexin.sdk.bean.PushMessageBean;
import com.igexin.sdk.data.BasicDataManager;
import com.igexin.sdk.db.DBHelper;
import com.igexin.sdk.task.DownloadRealImageTask;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.igexin.sdk.action:
//            AbstractPushMessageAction, PushMessageAction

public class NotificationAction
    implements AbstractPushMessageAction
{

    public static HashMap notificationMap = new HashMap();

    public NotificationAction()
    {
    }

    private PendingIntent getPendingIntent(String s, String s1, String s2)
    {
        Intent intent = new Intent("com.igexin.sdk.action.doaction");
        intent.putExtra("taskid", s);
        intent.putExtra("messageid", s1);
        intent.putExtra("appid", Consts.VPUSH_APPID);
        intent.putExtra("actionid", s2);
        intent.putExtra("accesstoken", BasicDataManager.internalBroadcastAccessToken);
        s = new Random();
        return PendingIntent.getBroadcast(SdkService.getInstance(), s.nextInt(1000), intent, 0x8000000);
    }

    public boolean executeAction(PushMessageBean pushmessagebean, BaseBean basebean)
    {
        if (pushmessagebean != null && basebean != null && (basebean instanceof NotificationBean))
        {
            showNotification(pushmessagebean.getTaskId(), pushmessagebean.getMessageId(), (NotificationBean)basebean);
        }
        return true;
    }

    public BaseBean parseAction(JSONObject jsonobject)
    {
        NotificationBean notificationbean1;
        int j;
        notificationbean1 = new NotificationBean();
        notificationbean1.setType(jsonobject.getString("type"));
        notificationbean1.setActionId(jsonobject.getString("actionid"));
        notificationbean1.setDoActionId(jsonobject.getString("do"));
        String s = jsonobject.getString("title");
        String s1 = jsonobject.getString("text");
        notificationbean1.setTitle(s);
        notificationbean1.setContent(s1);
        if (!jsonobject.has("logo"))
        {
            break MISSING_BLOCK_LABEL_155;
        }
        if (jsonobject.getString("logo").lastIndexOf(".png") == -1 && jsonobject.getString("logo").lastIndexOf(".jpeg") == -1)
        {
            break MISSING_BLOCK_LABEL_282;
        }
        j = jsonobject.getString("logo").indexOf(".png");
        int i;
        i = j;
        if (j != -1)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        i = jsonobject.getString("logo").indexOf(".jpeg");
        notificationbean1.setLogo(jsonobject.getString("logo").substring(0, i));
_L1:
        if (jsonobject.has("logo_url") && jsonobject.getString("logo_url").startsWith("http"))
        {
            notificationbean1.setUrl_logo(jsonobject.getString("logo_url"));
        }
        if (jsonobject.has("banner_url") && jsonobject.getString("banner_url").startsWith("http"))
        {
            notificationbean1.setBanner_url(jsonobject.getString("banner_url"));
        }
        if (jsonobject.has("is_noclear"))
        {
            notificationbean1.setIs_noclear(jsonobject.getBoolean("is_noclear"));
        }
        if (jsonobject.has("is_novibrate"))
        {
            notificationbean1.setIs_novibrate(jsonobject.getBoolean("is_novibrate"));
        }
        NotificationBean notificationbean = notificationbean1;
        if (!jsonobject.has("is_noring"))
        {
            break MISSING_BLOCK_LABEL_298;
        }
        notificationbean1.setIs_noring(jsonobject.getBoolean("is_noring"));
        return notificationbean1;
        notificationbean1.setLogo("null");
          goto _L1
        jsonobject;
        jsonobject.printStackTrace();
        notificationbean = null;
        return notificationbean;
    }

    public com.igexin.sdk.Consts.ActionPrepareState prepareExecuteAction(PushMessageBean pushmessagebean, BaseBean basebean)
    {
        NotificationBean notificationbean;
label0:
        {
            com.igexin.sdk.Consts.ActionPrepareState actionpreparestate = com.igexin.sdk.Consts.ActionPrepareState.success;
            notificationbean = (NotificationBean)basebean;
            final String logo_url = notificationbean.getUrl_logo();
            final String banner_url = notificationbean.getBanner_url();
            final String taskId = pushmessagebean.getTaskId();
            final String messageId = pushmessagebean.getMessageId();
            final String actionId = notificationbean.getActionId();
            basebean = actionpreparestate;
            if (SdkService.getInstance().getResources().getIdentifier("notification", "layout", SdkService.pkgName) != 0)
            {
                pushmessagebean = actionpreparestate;
                if (logo_url != null)
                {
                    pushmessagebean = SdkService.getInstance().getDownloadImgCache(logo_url);
                    if (pushmessagebean.equals(""))
                    {
                        (new DownloadRealImageTask(logo_url, taskId, actionId, 2, new CallbackListener() {

                            String catchId;
                            NotificationBean notificationBean;
                            PushMessageBean pushMessageBean;
                            final NotificationAction this$0;
                            final String val$actionId;
                            final String val$logo_url;
                            final String val$messageId;
                            final String val$taskId;

                            public void exceptionHandler(Exception exception)
                            {
                                System.out.println("download logo img failed!");
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
                                    contentvalues.put("imageurl", logo_url);
                                    contentvalues.put("imagesrc", ((String) (obj)));
                                    contentvalues.put("taskid", taskId);
                                    contentvalues.put("createtime", Long.valueOf(System.currentTimeMillis()));
                                    notificationBean.setUrl_logo_src(((String) (obj)));
                                    SdkService.getInstance().getDBHelper().insert("image", contentvalues);
                                }
                                if (PushMessageAction.getInstance().getPrepareWaitActionCounts(taskId, true) == 0)
                                {
                                    PushMessageAction.getInstance().executePushMessageAction(pushMessageBean, "1");
                                }
                            }

            
            {
                this$0 = NotificationAction.this;
                taskId = s;
                messageId = s1;
                actionId = s2;
                logo_url = s3;
                super();
                catchId = PushMessageAction.getInstance().getPushMessageCacheId(taskId, messageId);
                pushMessageBean = (PushMessageBean)BasicDataManager.pushMessageMap.get(catchId);
                notificationBean = (NotificationBean)pushMessageBean.getBean(actionId);
            }
                        })).start();
                        pushmessagebean = com.igexin.sdk.Consts.ActionPrepareState.wait;
                    } else
                    {
                        notificationbean.setUrl_logo_src(pushmessagebean);
                        pushmessagebean = actionpreparestate;
                    }
                }
                basebean = pushmessagebean;
                if (banner_url != null)
                {
                    basebean = SdkService.getInstance().getDownloadImgCache(banner_url);
                    if (!basebean.equals(""))
                    {
                        break label0;
                    }
                    (new DownloadRealImageTask(banner_url, taskId, actionId, 3, new CallbackListener() {

                        String catchId;
                        NotificationBean notificationBean;
                        PushMessageBean pushMessageBean;
                        final NotificationAction this$0;
                        final String val$actionId;
                        final String val$banner_url;
                        final String val$messageId;
                        final String val$taskId;

                        public void exceptionHandler(Exception exception)
                        {
                            System.out.println("download banner img failed!");
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
                                contentvalues.put("imageurl", banner_url);
                                contentvalues.put("imagesrc", ((String) (obj)));
                                contentvalues.put("taskid", taskId);
                                contentvalues.put("createtime", Long.valueOf(System.currentTimeMillis()));
                                notificationBean.setBanner_url_src(((String) (obj)));
                                SdkService.getInstance().getDBHelper().insert("image", contentvalues);
                            }
                            if (PushMessageAction.getInstance().getPrepareWaitActionCounts(taskId, true) == 0)
                            {
                                PushMessageAction.getInstance().executePushMessageAction(pushMessageBean, "1");
                            }
                        }

            
            {
                this$0 = NotificationAction.this;
                taskId = s;
                messageId = s1;
                actionId = s2;
                banner_url = s3;
                super();
                catchId = PushMessageAction.getInstance().getPushMessageCacheId(taskId, messageId);
                pushMessageBean = (PushMessageBean)BasicDataManager.pushMessageMap.get(catchId);
                notificationBean = (NotificationBean)pushMessageBean.getBean(actionId);
            }
                    })).start();
                    basebean = com.igexin.sdk.Consts.ActionPrepareState.wait;
                }
            }
            return basebean;
        }
        notificationbean.setBanner_url_src(basebean);
        return pushmessagebean;
    }

    public void showNotification(String s, String s1, NotificationBean notificationbean)
    {
        String s2 = SdkService.getInstance().getPackageName();
        int k = (int)System.currentTimeMillis();
        s = getPendingIntent(s, s1, notificationbean.getDoActionId());
        s1 = (NotificationManager)SdkService.getInstance().getSystemService("notification");
        Notification notification = new Notification();
        notification.tickerText = notificationbean.getContent();
        notification.defaults = 4;
        notification.ledARGB = 0xff00ff00;
        notification.ledOnMS = 1000;
        notification.ledOffMS = 3000;
        notification.flags = 1;
        int i;
        if (!notificationbean.isIs_noclear())
        {
            notification.flags = notification.flags | 0x10;
        } else
        {
            notification.flags = notification.flags | 0x20;
        }
        if (!notificationbean.isIs_noring())
        {
            notification.defaults = notification.defaults | 1;
        }
        if (!notificationbean.isIs_novibrate())
        {
            notification.defaults = notification.defaults | 2;
        }
        i = SdkService.getInstance().getResources().getIdentifier("push", "drawable", s2);
        if (!"null".equals(notificationbean.getLogo()))
        {
            if (notificationbean.getLogo().startsWith("@"))
            {
                String s3 = notificationbean.getLogo();
                if (s3.substring(1, s3.length()).endsWith("email"))
                {
                    notification.icon = 0x108008f;
                } else
                if (i != 0)
                {
                    notification.icon = i;
                } else
                {
                    notification.icon = 0x1080093;
                }
            } else
            {
                int j = SdkService.getInstance().getResources().getIdentifier(notificationbean.getLogo(), "drawable", s2);
                if (j != 0)
                {
                    notification.icon = j;
                } else
                if (i != 0)
                {
                    notification.icon = i;
                } else
                {
                    notification.icon = 0x1080093;
                }
            }
        } else
        if (i != 0)
        {
            notification.icon = i;
        } else
        {
            notification.icon = 0x1080093;
        }
        i = SdkService.getInstance().getResources().getIdentifier("notification", "layout", s2);
        if (notificationbean.getBanner_url() == null && notificationbean.getUrl_logo() == null || i == 0)
        {
            notification.setLatestEventInfo(SdkService.getInstance(), notificationbean.getTitle(), notificationbean.getContent(), s);
        } else
        {
            notification.contentView = new RemoteViews(s2, i);
            int l = SdkService.getInstance().getResources().getIdentifier("notification_icon", "id", s2);
            int i1 = SdkService.getInstance().getResources().getIdentifier("notification_background", "id", s2);
            Object obj1 = notificationbean.getUrl_logo_src();
            Object obj = notificationbean.getBanner_url_src();
            boolean flag1 = false;
            boolean flag = flag1;
            if (obj1 != null)
            {
                obj1 = BitmapFactory.decodeFile(((String) (obj1)));
                flag = flag1;
                if (obj1 != null)
                {
                    notification.contentView.setImageViewBitmap(l, ((android.graphics.Bitmap) (obj1)));
                    flag = true;
                }
            }
            if (!flag)
            {
                notification.contentView.setImageViewResource(l, notification.icon);
            }
            if (obj != null)
            {
                obj = BitmapFactory.decodeFile(((String) (obj)));
                if (obj != null)
                {
                    notification.contentView.setImageViewBitmap(i1, ((android.graphics.Bitmap) (obj)));
                }
            }
            notification.contentView.setTextViewText(SdkService.getInstance().getResources().getIdentifier("notification_title", "id", s2), notificationbean.getTitle());
            notification.contentView.setTextViewText(SdkService.getInstance().getResources().getIdentifier("notification_name", "id", s2), notificationbean.getContent());
            notification.contentIntent = s;
        }
        s1.notify(k, notification);
    }

}
