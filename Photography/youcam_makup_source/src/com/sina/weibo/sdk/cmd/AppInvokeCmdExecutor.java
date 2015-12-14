// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.cmd;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Message;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.SDKNotification;
import java.util.List;

// Referenced classes of package com.sina.weibo.sdk.cmd:
//            CmdExecutor, AppInvokeCmd, BaseCmd

class AppInvokeCmdExecutor
    implements CmdExecutor
{

    private static final int NOTIFICATION_ID = 2;
    private static final int SHOW_NOTICIATION = 1;
    private Context mContext;
    private NotificationHandler mHandler;

    public AppInvokeCmdExecutor(Context context)
    {
        mContext = context.getApplicationContext();
        mHandler = new NotificationHandler(mContext.getMainLooper());
    }

    private static PendingIntent buildInvokePendingIntent(Context context, AppInvokeCmd appinvokecmd)
    {
        Object obj1;
        String s1;
        obj1 = null;
        String s = appinvokecmd.getScheme();
        s1 = appinvokecmd.getUrl();
        appinvokecmd = buildOpenSchemeIntent(s, appinvokecmd.getAppPackage());
        if (appinvokecmd == null) goto _L2; else goto _L1
_L1:
        List list = context.getPackageManager().queryIntentActivities(appinvokecmd, 0x10000);
        if (list == null || list.isEmpty()) goto _L2; else goto _L3
_L3:
        Object obj = appinvokecmd;
        if (appinvokecmd == null)
        {
            obj = buildOpenUrlIntent(s1);
        }
        appinvokecmd = obj1;
        if (obj != null)
        {
            ((Intent) (obj)).setFlags(0x10000000);
            appinvokecmd = PendingIntent.getActivity(context, 0, ((Intent) (obj)), 0x8000000);
        }
        return appinvokecmd;
_L2:
        appinvokecmd = null;
        if (true) goto _L3; else goto _L4
_L4:
    }

    private static Intent buildOpenSchemeIntent(String s, String s1)
    {
        if (!TextUtils.isEmpty(s) && Uri.parse(s).isHierarchical())
        {
            s = Uri.parse(s);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(s);
            intent.setPackage(s1);
            return intent;
        } else
        {
            return null;
        }
    }

    private static Intent buildOpenUrlIntent(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            s = Uri.parse(s);
            String s1 = s.getScheme();
            if (s1.equalsIgnoreCase("http") || s1.equalsIgnoreCase("https"))
            {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(s);
                return intent;
            }
        }
        return null;
    }

    private static void showNotification(Context context, AppInvokeCmd appinvokecmd)
    {
        com.sina.weibo.sdk.utils.SDKNotification.SDKNotificationBuilder.buildUpon().setNotificationContent(appinvokecmd.getNotificationText()).setNotificationPendingIntent(buildInvokePendingIntent(context, appinvokecmd)).setNotificationTitle(appinvokecmd.getNotificationTitle()).setTickerText(appinvokecmd.getNotificationText()).build(context).show(2);
    }

    public boolean doExecutor(AppInvokeCmd appinvokecmd)
    {
        if (appinvokecmd == null || TextUtils.isEmpty(appinvokecmd.getNotificationText()) || TextUtils.isEmpty(appinvokecmd.getScheme()))
        {
            return false;
        } else
        {
            Message message = mHandler.obtainMessage();
            message.what = 1;
            message.obj = appinvokecmd;
            mHandler.sendMessageDelayed(message, appinvokecmd.getNotificationDelay());
            return true;
        }
    }

    public volatile boolean doExecutor(BaseCmd basecmd)
    {
        return doExecutor((AppInvokeCmd)basecmd);
    }



    private class NotificationHandler extends Handler
    {

        final AppInvokeCmdExecutor this$0;

        public void handleMessage(Message message)
        {
            super.handleMessage(message);
            switch (message.what)
            {
            default:
                return;

            case 1: // '\001'
                AppInvokeCmdExecutor.showNotification(mContext, (AppInvokeCmd)message.obj);
                break;
            }
        }

        public NotificationHandler(Looper looper)
        {
            this$0 = AppInvokeCmdExecutor.this;
            super(looper);
        }
    }

}
