// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.aio.downloader.activity.AppDetailsActivity;
import com.aio.downloader.activity.PaidforFreeActivity1;
import com.umeng.analytics.MobclickAgent;

// Referenced classes of package com.aio.downloader.service:
//            ServiceUpdate

class this._cls0 extends BroadcastReceiver
{

    final ServiceUpdate this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("update"))
        {
            MobclickAgent.onEvent(getApplicationContext(), "update_not_click");
            context = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
            context.putExtra("myid", appid);
            context.putExtra("linkurl", ServiceUpdate.access$22(ServiceUpdate.this));
            context.putExtra("wocao", 1);
            context.putExtra("caocao", 0);
            context.putExtra("myupver", ServiceUpdate.access$23(ServiceUpdate.this));
            context.setFlags(0x10000000);
            startActivity(context);
        } else
        {
            if (intent.getAction().equals("pick"))
            {
                MobclickAgent.onEvent(getApplicationContext(), "pick_apps_click");
                context = new Intent(context, com/aio/downloader/activity/AppDetailsActivity);
                context.putExtra("myid", ServiceUpdate.access$13(ServiceUpdate.this));
                context.setFlags(0x10000000);
                context.putExtra("linkurl", "");
                context.putExtra("caocao", 0);
                startActivity(context);
                return;
            }
            if (intent.getAction().equals("pick_big"))
            {
                MobclickAgent.onEvent(getApplicationContext(), "pick_big_click");
                context = new Intent(context, com/aio/downloader/activity/AppDetailsActivity);
                context.putExtra("myid", ServiceUpdate.access$18(ServiceUpdate.this));
                context.setFlags(0x10000000);
                context.putExtra("linkurl", "");
                context.putExtra("caocao", 0);
                startActivity(context);
                return;
            }
            if (intent.getAction().equals("paid"))
            {
                MobclickAgent.onEvent(getApplicationContext(), "paid_click");
                context = new Intent(context, com/aio/downloader/activity/PaidforFreeActivity1);
                context.setFlags(0x10000000);
                context.putExtra("caocao", 0);
                startActivity(context);
                return;
            }
            if (intent.getAction().equals("status_bar_download_success"))
            {
                MobclickAgent.onEvent(context, "downloadsuccess_click");
                context = new Intent("android.intent.action.VIEW");
                context.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ServiceUpdate.access$24(ServiceUpdate.this)).toString()), "application/vnd.android.package-archive");
                context.addFlags(0x10000000);
                startActivity(context);
                return;
            }
            if (intent.getAction().equals("status_bar_download_install"))
            {
                MobclickAgent.onEvent(context, "installsuccess_click");
                intent = context.getPackageManager().getLaunchIntentForPackage(ServiceUpdate.access$25(ServiceUpdate.this));
                intent.addFlags(0x10000000);
                context.startActivity(intent);
                return;
            }
        }
    }

    vity1()
    {
        this$0 = ServiceUpdate.this;
        super();
    }
}
