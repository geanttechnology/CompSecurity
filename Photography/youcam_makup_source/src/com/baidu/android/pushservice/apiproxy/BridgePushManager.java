// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice.apiproxy;

import android.app.Activity;
import android.content.Context;
import com.baidu.android.pushservice.internal.PushManager;
import java.util.List;

// Referenced classes of package com.baidu.android.pushservice.apiproxy:
//            BridgePushNotificationBuilder

public class BridgePushManager
{

    public BridgePushManager()
    {
    }

    public static void activityStarted(Activity activity)
    {
        PushManager.activityStarted(activity);
    }

    public static void activityStoped(Activity activity)
    {
        PushManager.activityStoped(activity);
    }

    public static void bind(Context context, int i)
    {
        PushManager.bind(context, i);
    }

    public static void bindGroup(Context context, String s)
    {
        PushManager.bindGroup(context, s);
    }

    public static void delTags(Context context, List list)
    {
        PushManager.delTags(context, list);
    }

    public static void deleteMessages(Context context, String as[])
    {
        PushManager.deleteMessages(context, as);
    }

    public static void disableLbs(Context context)
    {
        PushManager.disableLbs(context);
    }

    public static void enableLbs(Context context)
    {
        PushManager.enableLbs(context);
    }

    public static void fetchGroupMessages(Context context, String s, int i, int j)
    {
        PushManager.fetchGroupMessages(context, s, i, j);
    }

    public static void fetchMessages(Context context, int i, int j)
    {
        PushManager.fetchMessages(context, i, j);
    }

    public static void getGroupInfo(Context context, String s)
    {
        PushManager.getGroupInfo(context, s);
    }

    public static void getGroupList(Context context)
    {
        PushManager.getGroupList(context);
    }

    public static void getGroupMessageCounts(Context context, String s)
    {
        PushManager.getGroupMessageCounts(context, s);
    }

    public static void getMessageCounts(Context context)
    {
        PushManager.getMessageCounts(context);
    }

    public static void init(Context context, String s)
    {
        PushManager.init(context, s);
    }

    public static void init(Context context, String s, String s1)
    {
        PushManager.init(context, s, s1);
    }

    public static void initFromAKSK(Context context, String s)
    {
        PushManager.initFromAKSK(context, s);
    }

    public static boolean isConnected(Context context)
    {
        return PushManager.isConnected(context);
    }

    public static boolean isPushEnabled(Context context)
    {
        return PushManager.isPushEnabled(context);
    }

    public static void listTags(Context context)
    {
        PushManager.listTags(context);
    }

    public static void resumeWork(Context context)
    {
        PushManager.resumeWork(context);
    }

    public static void sdkBind(Context context, int i, String s, int j)
    {
        PushManager.sdkBind(context, i, s, j);
    }

    public static void sdkStartWork(Context context, String s, int i)
    {
        PushManager.sdkStartWork(context, s, i);
    }

    public static void sendMsgToUser(Context context, String s, String s1, String s2, String s3)
    {
        PushManager.sendMsgToUser(context, s, s1, s2, s3);
    }

    public static void setAccessToken(Context context, String s)
    {
        PushManager.setAccessToken(context, s);
    }

    public static void setApiKey(Context context, String s)
    {
        PushManager.setApiKey(context, s);
    }

    public static void setBduss(Context context, String s)
    {
        PushManager.setBduss(context, s);
    }

    public static void setDefaultNotificationBuilder(Context context, BridgePushNotificationBuilder bridgepushnotificationbuilder)
    {
        PushManager.setDefaultNotificationBuilder(context, bridgepushnotificationbuilder.getInner());
    }

    public static void setMediaNotificationBuilder(Context context, BridgePushNotificationBuilder bridgepushnotificationbuilder)
    {
        PushManager.setMediaNotificationBuilder(context, bridgepushnotificationbuilder.getInner());
    }

    public static void setNotificationBuilder(Context context, int i, BridgePushNotificationBuilder bridgepushnotificationbuilder)
    {
        try
        {
            PushManager.setNotificationBuilder(context, i, bridgepushnotificationbuilder.getInner());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    public static void setTags(Context context, List list)
    {
        PushManager.setTags(context, list);
    }

    public static void startWork(Context context, int i, String s)
    {
        PushManager.startWork(context, i, s);
    }

    public static void startWork(Context context, String s, String s1)
    {
        PushManager.startWork(context, s, s1);
    }

    public static void stopWork(Context context)
    {
        PushManager.stopWork(context);
    }

    public static void tryConnect(Context context)
    {
        PushManager.tryConnect(context);
    }

    public static void unbind(Context context)
    {
        PushManager.unbind(context);
    }

    public static void unbindGroup(Context context, String s)
    {
        PushManager.unbindGroup(context, s);
    }
}
