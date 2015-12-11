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
    implements android.view.ervice1._cls1._cls1._cls2
{

    final on.printStackTrace this$2;
    private final Context val$context;

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131165487: 
            erylow.dismiss();
            return;

        case 2131165488: 
            MobclickAgent.onEvent(val$context, "batteryapp_click");
            break;
        }
        (new Thread() {

            final BatteryInfoService1._cls1._cls1._cls2 this$3;

            public void run()
            {
                super.run();
                publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=battery_apps_click");
            }

            
            {
                this$3 = BatteryInfoService1._cls1._cls1._cls2.this;
                super();
            }
        }).start();
        view = null;
        android.content.pm.PackageInfo packageinfo = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
        view = packageinfo;
_L1:
        android.content.pm.dException dexception;
        if (view == null)
        {
            if (BatteryInfoService1.access$2(_fld0).exists())
            {
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(BatteryInfoService1.access$3(_fld0)).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                view.addFlags(0x10000000);
                startActivity(view);
            } else
            if (BatteryInfoService1.access$4(_fld0).exists())
            {
                (new AsyncTask() {

                    final BatteryInfoService1._cls1._cls1._cls2 this$3;

                    protected volatile transient Object doInBackground(Object aobj[])
                    {
                        return doInBackground((Void[])aobj);
                    }

                    protected transient Void doInBackground(Void avoid[])
                    {
                        Myutils.copyfile(BatteryInfoService1.access$4(this$0), BatteryInfoService1.access$2(this$0), Boolean.valueOf(false));
                        return null;
                    }

                    protected volatile void onPostExecute(Object obj)
                    {
                        onPostExecute((Void)obj);
                    }

                    protected void onPostExecute(Void void1)
                    {
                        super.onPostExecute(void1);
                        void1 = new Intent("android.intent.action.VIEW");
                        void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(BatteryInfoService1.access$3(this$0)).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                        void1.addFlags(0x10000000);
                        startActivity(void1);
                    }

            
            {
                this$3 = BatteryInfoService1._cls1._cls1._cls2.this;
                super();
            }
                }).execute(new Void[0]);
            }
        } else
        {
            view = getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
            view.addFlags(0x10000000);
            startActivity(view);
        }
        erylow.dismiss();
        return;
        dexception;
        dexception.printStackTrace();
          goto _L1
    }


    ATTERYAPK()
    {
        this$2 = final_atteryapk;
        val$context = Context.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/service/BatteryInfoService1$1

/* anonymous class */
    class BatteryInfoService1._cls1 extends BroadcastReceiver
    {

        private File AIOBATTERY;
        private File AIOBATTERYAPK;
        private Batterylow batterylow;
        private android.view.View.OnClickListener itemsOnClick4;
        final BatteryInfoService1 this$0;

        public void onReceive(Context context1, Intent intent)
        {
            NotificationManager notificationmanager = (NotificationManager)context1.getSystemService("notification");
            if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED"))
            {
                int i = intent.getIntExtra("level", 0);
                if (i <= 30 && BatteryInfoService1.access$0(BatteryInfoService1.this) == 0)
                {
                    intent = BatteryInfoService1.this;
                    BatteryInfoService1.access$1(intent, BatteryInfoService1.access$0(intent) + 1);
                    Log.e("asd", (new StringBuilder("level=")).append(i).toString());
                    (new Handler()).postDelayed(context1. new BatteryInfoService1._cls1._cls1(), 20000L);
                }
            }
        }






            
            {
                this$0 = BatteryInfoService1.this;
                super();
                AIOBATTERY = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("battery.swf").toString());
                AIOBATTERYAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("battery.apk").toString());
            }
    }


    // Unreferenced inner class com/aio/downloader/service/BatteryInfoService1$1$1

/* anonymous class */
    class BatteryInfoService1._cls1._cls1
        implements Runnable
    {

        final BatteryInfoService1._cls1 this$1;
        private final Context val$context;

        public void run()
        {
            android.content.pm.PackageInfo packageinfo = null;
            android.content.pm.PackageInfo packageinfo1 = context.getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
            packageinfo = packageinfo1;
_L2:
            if (packageinfo == null && System.currentTimeMillis() > SharedPreferencesConfig.GetPowerAPPClickTime(getApplicationContext()))
            {
                (new BatteryInfoService1._cls1._cls1._cls1()).start();
                MobclickAgent.onEvent(context, "batteryapp");
                SharedPreferencesConfig.SetPowerAPPClickTime(getApplicationContext(), System.currentTimeMillis() + 0x1499700L);
                itemsOnClick4 = context. new BatteryInfoService1._cls1._cls1._cls2();
                batterylow = new Batterylow(context, 0x7f0c0010, itemsOnClick4);
                batterylow.setCanceledOnTouchOutside(true);
                batterylow.getWindow().setType(2003);
                batterylow.show();
                Window window = batterylow.getWindow();
                android.view.WindowManager.LayoutParams layoutparams = window.getAttributes();
                window.setGravity(80);
                layoutparams.width = ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getWidth();
                window.setAttributes(layoutparams);
            }
            return;
            android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
            namenotfoundexception;
            namenotfoundexception.printStackTrace();
            if (true) goto _L2; else goto _L1
_L1:
        }


            
            {
                this$1 = final__pcls1;
                context = Context.this;
                super();
            }

        // Unreferenced inner class com/aio/downloader/service/BatteryInfoService1$1$1$1

/* anonymous class */
        class BatteryInfoService1._cls1._cls1._cls1 extends Thread
        {

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
        }

    }

}
