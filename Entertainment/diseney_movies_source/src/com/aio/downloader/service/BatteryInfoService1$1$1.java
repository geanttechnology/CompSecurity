// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.aio.downloader.dialog.Batterylow;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.SharedPreferencesConfig;
import com.aio.downloader.utils.publicTools;
import com.umeng.analytics.MobclickAgent;
import java.io.File;

// Referenced classes of package com.aio.downloader.service:
//            BatteryInfoService1

class val.context
    implements Runnable
{

    final tion.printStackTrace this$1;
    private final Context val$context;

    public void run()
    {
        android.content.pm.PackageInfo packageinfo = null;
        android.content.pm.PackageInfo packageinfo1 = val$context.getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
        packageinfo = packageinfo1;
_L2:
        if (packageinfo == null && System.currentTimeMillis() > SharedPreferencesConfig.GetPowerAPPClickTime(getApplicationContext()))
        {
            (new Thread() {

                final BatteryInfoService1._cls1._cls1 this$2;

                public void run()
                {
                    super.run();
                    publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=battery_apps");
                }

            
            {
                this$2 = BatteryInfoService1._cls1._cls1.this;
                super();
            }
            }).start();
            MobclickAgent.onEvent(val$context, "batteryapp");
            SharedPreferencesConfig.SetPowerAPPClickTime(getApplicationContext(), System.currentTimeMillis() + 0x1499700L);
            emsOnClick4 = new android.view.View.OnClickListener() {

                final BatteryInfoService1._cls1._cls1 this$2;
                private final Context val$context;

                public void onClick(View view)
                {
                    switch (view.getId())
                    {
                    default:
                        return;

                    case 2131165487: 
                        batterylow.dismiss();
                        return;

                    case 2131165488: 
                        MobclickAgent.onEvent(context, "batteryapp_click");
                        break;
                    }
                    (new Thread() {

                        final _cls2 this$3;

                        public void run()
                        {
                            super.run();
                            publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=battery_apps_click");
                        }

            
            {
                this$3 = _cls2.this;
                super();
            }
                    }).start();
                    view = null;
                    android.content.pm.PackageInfo packageinfo2 = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
                    view = packageinfo2;
_L1:
                    android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
                    if (view == null)
                    {
                        if (BatteryInfoService1.access$2(this$0).exists())
                        {
                            view = new Intent("android.intent.action.VIEW");
                            view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(BatteryInfoService1.access$3(this$0)).append(File.separator).append("cleaner.apk").toString()), "application