// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice;

import android.app.Activity;
import android.content.Context;
import com.baidu.android.pushservice.apiproxy.BridgePushManager;
import java.util.List;

// Referenced classes of package com.baidu.android.pushservice:
//            LoadExecutor, PushNotificationBuilder

public class PushManager
{

    private static final String a = "com.baidu.pushservice.PushSettings.connect_state";

    public PushManager()
    {
    }

    private static boolean a(Context context)
    {
        int i;
        try
        {
            i = android.provider.Settings.System.getInt(context.getContentResolver(), "com.baidu.pushservice.PushSettings.connect_state");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return i == 1;
    }

    public static void activityStarted(Activity activity)
    {
        LoadExecutor.excuteMethod(new Runnable(activity) {

            private final Activity a;

            public void run()
            {
                BridgePushManager.activityStarted(a);
            }

            
            {
                a = activity;
                super();
            }
        }, activity);
    }

    public static void activityStoped(Activity activity)
    {
        LoadExecutor.excuteMethod(new Runnable(activity) {

            private final Activity a;

            public void run()
            {
                BridgePushManager.activityStoped(a);
            }

            
            {
                a = activity;
                super();
            }
        }, activity);
    }

    public static void bind(Context context, int i)
    {
        LoadExecutor.excuteMethod(new Runnable(context, i) {

            private final Context a;
            private final int b;

            public void run()
            {
                BridgePushManager.bind(a, b);
            }

            
            {
                a = context;
                b = i;
                super();
            }
        }, context);
    }

    public static void bindGroup(Context context, String s)
    {
        LoadExecutor.excuteMethod(new Runnable(context, s) {

            private final Context a;
            private final String b;

            public void run()
            {
                BridgePushManager.bindGroup(a, b);
            }

            
            {
                a = context;
                b = s;
                super();
            }
        }, context);
    }

    public static void delTags(Context context, List list)
    {
        LoadExecutor.excuteMethod(new Runnable(context, list) {

            private final Context a;
            private final List b;

            public void run()
            {
                BridgePushManager.delTags(a, b);
            }

            
            {
                a = context;
                b = list;
                super();
            }
        }, context);
    }

    public static void deleteMessages(Context context, String as[])
    {
        LoadExecutor.excuteMethod(new Runnable(context, as) {

            private final Context a;
            private final String b[];

            public void run()
            {
                BridgePushManager.deleteMessages(a, b);
            }

            
            {
                a = context;
                b = as;
                super();
            }
        }, context);
    }

    public static void disableLbs(Context context)
    {
        LoadExecutor.excuteMethod(new Runnable(context) {

            private final Context a;

            public void run()
            {
                BridgePushManager.disableLbs(a);
            }

            
            {
                a = context;
                super();
            }
        }, context);
    }

    public static void enableLbs(Context context)
    {
        LoadExecutor.excuteMethod(new Runnable(context) {

            private final Context a;

            public void run()
            {
                BridgePushManager.enableLbs(a);
            }

            
            {
                a = context;
                super();
            }
        }, context);
    }

    public static void fetchGroupMessages(Context context, String s, int i, int j)
    {
        LoadExecutor.excuteMethod(new Runnable(context, s, i, j) {

            private final Context a;
            private final String b;
            private final int c;
            private final int d;

            public void run()
            {
                BridgePushManager.fetchGroupMessages(a, b, c, d);
            }

            
            {
                a = context;
                b = s;
                c = i;
                d = j;
                super();
            }
        }, context);
    }

    public static void fetchMessages(Context context, int i, int j)
    {
        LoadExecutor.excuteMethod(new Runnable(context, i, j) {

            private final Context a;
            private final int b;
            private final int c;

            public void run()
            {
                BridgePushManager.fetchMessages(a, b, c);
            }

            
            {
                a = context;
                b = i;
                c = j;
                super();
            }
        }, context);
    }

    public static void getGroupInfo(Context context, String s)
    {
        LoadExecutor.excuteMethod(new Runnable(context, s) {

            private final Context a;
            private final String b;

            public void run()
            {
                BridgePushManager.getGroupInfo(a, b);
            }

            
            {
                a = context;
                b = s;
                super();
            }
        }, context);
    }

    public static void getGroupList(Context context)
    {
        LoadExecutor.excuteMethod(new Runnable(context) {

            private final Context a;

            public void run()
            {
                BridgePushManager.getGroupList(a);
            }

            
            {
                a = context;
                super();
            }
        }, context);
    }

    public static void getGroupMessageCounts(Context context, String s)
    {
        LoadExecutor.excuteMethod(new Runnable(context, s) {

            private final Context a;
            private final String b;

            public void run()
            {
                BridgePushManager.getGroupMessageCounts(a, b);
            }

            
            {
                a = context;
                b = s;
                super();
            }
        }, context);
    }

    public static void getMessageCounts(Context context)
    {
        LoadExecutor.excuteMethod(new Runnable(context) {

            private final Context a;

            public void run()
            {
                BridgePushManager.getMessageCounts(a);
            }

            
            {
                a = context;
                super();
            }
        }, context);
    }

    public static void init(Context context, String s)
    {
        LoadExecutor.excuteMethod(new Runnable(context, s) {

            private final Context a;
            private final String b;

            public void run()
            {
                BridgePushManager.init(a, b);
            }

            
            {
                a = context;
                b = s;
                super();
            }
        }, context);
    }

    public static void init(Context context, String s, String s1)
    {
        LoadExecutor.excuteMethod(new Runnable(context, s, s1) {

            private final Context a;
            private final String b;
            private final String c;

            public void run()
            {
                BridgePushManager.init(a, b, c);
            }

            
            {
                a = context;
                b = s;
                c = s1;
                super();
            }
        }, context);
    }

    public static void initFromAKSK(Context context, String s)
    {
        LoadExecutor.excuteMethod(new Runnable(context, s) {

            private final Context a;
            private final String b;

            public void run()
            {
                BridgePushManager.initFromAKSK(a, b);
            }

            
            {
                a = context;
                b = s;
                super();
            }
        }, context);
    }

    public static boolean isConnected(Context context)
    {
        while (context == null || !a(context)) 
        {
            return false;
        }
        return true;
    }

    public static boolean isPushEnabled(Context context)
    {
        boolean flag;
        try
        {
            context.getClassLoader().loadClass("com.baidu.android.pushservice.internal.PushManager");
            flag = BridgePushManager.isPushEnabled(context);
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            (new Thread(context) {

                private final Context a;

                public void run()
                {
                    LoadExecutor.loadPush(a);
                }

            
            {
                a = context;
                super();
            }
            }).start();
            return false;
        }
        return flag;
    }

    public static void listTags(Context context)
    {
        LoadExecutor.excuteMethod(new Runnable(context) {

            private final Context a;

            public void run()
            {
                BridgePushManager.listTags(a);
            }

            
            {
                a = context;
                super();
            }
        }, context);
    }

    public static void resumeWork(Context context)
    {
        LoadExecutor.excuteMethod(new Runnable(context) {

            private final Context a;

            public void run()
            {
                BridgePushManager.resumeWork(a);
            }

            
            {
                a = context;
                super();
            }
        }, context);
    }

    public static void sdkBind(Context context, int i, String s, int j)
    {
        LoadExecutor.excuteMethod(new Runnable(context, i, s, j) {

            private final Context a;
            private final int b;
            private final String c;
            private final int d;

            public void run()
            {
                BridgePushManager.sdkBind(a, b, c, d);
            }

            
            {
                a = context;
                b = i;
                c = s;
                d = j;
                super();
            }
        }, context);
    }

    public static void sdkStartWork(Context context, String s, int i)
    {
        LoadExecutor.excuteMethod(new Runnable(context, s, i) {

            private final Context a;
            private final String b;
            private final int c;

            public void run()
            {
                BridgePushManager.sdkStartWork(a, b, c);
            }

            
            {
                a = context;
                b = s;
                c = i;
                super();
            }
        }, context);
    }

    public static void sendMsgToUser(Context context, String s, String s1, String s2, String s3)
    {
        LoadExecutor.excuteMethod(new Runnable(context, s, s1, s2, s3) {

            private final Context a;
            private final String b;
            private final String c;
            private final String d;
            private final String e;

            public void run()
            {
                BridgePushManager.sendMsgToUser(a, b, c, d, e);
            }

            
            {
                a = context;
                b = s;
                c = s1;
                d = s2;
                e = s3;
                super();
            }
        }, context);
    }

    public static void setAccessToken(Context context, String s)
    {
        LoadExecutor.excuteMethod(new Runnable(context, s) {

            private final Context a;
            private final String b;

            public void run()
            {
                BridgePushManager.setAccessToken(a, b);
            }

            
            {
                a = context;
                b = s;
                super();
            }
        }, context);
    }

    public static void setApiKey(Context context, String s)
    {
        LoadExecutor.excuteMethod(new Runnable(context, s) {

            private final Context a;
            private final String b;

            public void run()
            {
                BridgePushManager.setApiKey(a, b);
            }

            
            {
                a = context;
                b = s;
                super();
            }
        }, context);
    }

    public static void setBduss(Context context, String s)
    {
        LoadExecutor.excuteMethod(new Runnable(context, s) {

            private final Context a;
            private final String b;

            public void run()
            {
                BridgePushManager.setBduss(a, b);
            }

            
            {
                a = context;
                b = s;
                super();
            }
        }, context);
    }

    public static void setDefaultNotificationBuilder(Context context, PushNotificationBuilder pushnotificationbuilder)
    {
        LoadExecutor.excuteMethod(new Runnable(context, pushnotificationbuilder) {

            private final Context a;
            private final PushNotificationBuilder b;

            public void run()
            {
                BridgePushManager.setDefaultNotificationBuilder(a, b.getInner());
            }

            
            {
                a = context;
                b = pushnotificationbuilder;
                super();
            }
        }, context);
    }

    public static void setMediaNotificationBuilder(Context context, PushNotificationBuilder pushnotificationbuilder)
    {
        LoadExecutor.excuteMethod(new Runnable(context, pushnotificationbuilder) {

            private final Context a;
            private final PushNotificationBuilder b;

            public void run()
            {
                BridgePushManager.setMediaNotificationBuilder(a, b.getInner());
            }

            
            {
                a = context;
                b = pushnotificationbuilder;
                super();
            }
        }, context);
    }

    public static void setNotificationBuilder(Context context, int i, PushNotificationBuilder pushnotificationbuilder)
    {
        LoadExecutor.excuteMethod(new Runnable(context, i, pushnotificationbuilder) {

            private final Context a;
            private final int b;
            private final PushNotificationBuilder c;

            public void run()
            {
                BridgePushManager.setNotificationBuilder(a, b, c.getInner());
            }

            
            {
                a = context;
                b = i;
                c = pushnotificationbuilder;
                super();
            }
        }, context);
    }

    public static void setTags(Context context, List list)
    {
        LoadExecutor.excuteMethod(new Runnable(context, list) {

            private final Context a;
            private final List b;

            public void run()
            {
                BridgePushManager.setTags(a, b);
            }

            
            {
                a = context;
                b = list;
                super();
            }
        }, context);
    }

    public static void startWork(Context context, int i, String s)
    {
        LoadExecutor.excuteMethod(new Runnable(context, i, s) {

            private final Context a;
            private final int b;
            private final String c;

            public void run()
            {
                BridgePushManager.startWork(a, b, c);
            }

            
            {
                a = context;
                b = i;
                c = s;
                super();
            }
        }, context);
    }

    public static void startWork(Context context, String s, String s1)
    {
        LoadExecutor.excuteMethod(new Runnable(context, s, s1) {

            private final Context a;
            private final String b;
            private final String c;

            public void run()
            {
                BridgePushManager.startWork(a, b, c);
            }

            
            {
                a = context;
                b = s;
                c = s1;
                super();
            }
        }, context);
    }

    public static void stopWork(Context context)
    {
        LoadExecutor.excuteMethod(new Runnable(context) {

            private final Context a;

            public void run()
            {
                BridgePushManager.stopWork(a);
            }

            
            {
                a = context;
                super();
            }
        }, context);
    }

    public static void tryConnect(Context context)
    {
        LoadExecutor.excuteMethod(new Runnable(context) {

            private final Context a;

            public void run()
            {
                BridgePushManager.tryConnect(a);
            }

            
            {
                a = context;
                super();
            }
        }, context);
    }

    public static void unbind(Context context)
    {
        LoadExecutor.excuteMethod(new Runnable(context) {

            private final Context a;

            public void run()
            {
                BridgePushManager.unbind(a);
            }

            
            {
                a = context;
                super();
            }
        }, context);
    }

    public static void unbindGroup(Context context, String s)
    {
        LoadExecutor.excuteMethod(new Runnable(context, s) {

            private final Context a;
            private final String b;

            public void run()
            {
                BridgePushManager.unbindGroup(a, b);
            }

            
            {
                a = context;
                b = s;
                super();
            }
        }, context);
    }
}
