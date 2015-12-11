// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.aio.downloader.activity.AppDetailsActivity;
import com.aio.downloader.dialog.ChangeDialog;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.SharedPreferencesConfig;
import com.aio.downloader.utils.publicTools;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.io.FileInputStream;

public class BatteryChanageReceiver extends BroadcastReceiver
{

    private static IntentFilter mIntentFilter;
    private static BatteryChanageReceiver mReceiver = new BatteryChanageReceiver();
    private File AIOBATTERY;
    private File AIOBATTERYAPK;
    private int battery[] = {
        98, 96, 94, 92, 90, 88, 86, 84, 82, 80, 
        78, 76, 74, 72, 70, 68, 66, 64, 62, 60, 
        58, 56, 54, 52, 50, 48, 46, 44, 42, 40, 
        38, 36, 34, 32, 30, 28, 26, 24, 22, 20, 
        18, 16, 14, 12, 10, 8, 6, 4, 2
    };
    private ChangeDialog changeDialog;
    private String fenzhong;
    private boolean isCharging;
    private android.view.View.OnClickListener itemsOnClick4;
    private int level;
    private String xiaoshi;

    public BatteryChanageReceiver()
    {
        AIOBATTERY = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("battery.swf").toString());
        AIOBATTERYAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("battery.apk").toString());
    }

    public static void registerReceiver(Context context)
    {
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        mIntentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        mIntentFilter.addAction("com.aio.downloader.service.BatteryChanageReceiver");
        context.registerReceiver(mReceiver, mIntentFilter);
    }

    public static void unregisterReceiver(Context context)
    {
        context.unregisterReceiver(mReceiver);
    }

    public long getFileSizes(File file)
        throws Exception
    {
        if (file.exists())
        {
            return (long)(new FileInputStream(file)).available();
        } else
        {
            file.createNewFile();
            return 0L;
        }
    }

    public void onReceive(final Context arg0, Intent intent)
    {
        int i;
        intent = arg0.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        level = intent.getIntExtra("level", -1);
        i = intent.getIntExtra("status", -1);
        Object obj;
        boolean flag;
        if (i != 2 && i != 5)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        try
        {
            isCharging = flag;
            if (level >= battery[48])
            {
                xiaoshi = "01";
                fenzhong = "22";
            }
            if (level >= battery[47])
            {
                xiaoshi = "01";
                fenzhong = "21";
            }
            if (level >= battery[46])
            {
                xiaoshi = "01";
                fenzhong = "20";
            }
            if (level >= battery[45])
            {
                xiaoshi = "01";
                fenzhong = "18";
            }
            if (level >= battery[44])
            {
                xiaoshi = "01";
                fenzhong = "17";
            }
            if (level >= battery[43])
            {
                xiaoshi = "01";
                fenzhong = "16";
            }
            if (level >= battery[42])
            {
                xiaoshi = "01";
                fenzhong = "15";
            }
            if (level >= battery[41])
            {
                xiaoshi = "01";
                fenzhong = "14";
            }
            if (level >= battery[40])
            {
                xiaoshi = "01";
                fenzhong = "13";
            }
            if (level >= battery[39])
            {
                xiaoshi = "01";
                fenzhong = "11";
            }
            if (level >= battery[38])
            {
                xiaoshi = "01";
                fenzhong = "10";
            }
            if (level >= battery[37])
            {
                xiaoshi = "01";
                fenzhong = "09";
            }
            if (level >= battery[36])
            {
                xiaoshi = "01";
                fenzhong = "08";
            }
            if (level >= battery[35])
            {
                xiaoshi = "01";
                fenzhong = "07";
            }
            if (level >= battery[34])
            {
                xiaoshi = "01";
                fenzhong = "06";
            }
            if (level >= battery[33])
            {
                xiaoshi = "01";
                fenzhong = "05";
            }
            if (level >= battery[32])
            {
                xiaoshi = "01";
                fenzhong = "04";
            }
            if (level >= battery[31])
            {
                xiaoshi = "01";
                fenzhong = "03";
            }
            if (level >= battery[30])
            {
                xiaoshi = "01";
                fenzhong = "02";
            }
            if (level >= battery[29])
            {
                xiaoshi = "01";
                fenzhong = "00";
            }
            if (level >= battery[28])
            {
                xiaoshi = "00";
                fenzhong = "59";
            }
            if (level >= battery[27])
            {
                xiaoshi = "00";
                fenzhong = "58";
            }
            if (level >= battery[26])
            {
                xiaoshi = "00";
                fenzhong = "57";
            }
            if (level >= battery[25])
            {
                xiaoshi = "00";
                fenzhong = "56";
            }
            if (level >= battery[24])
            {
                xiaoshi = "00";
                fenzhong = "55";
            }
            if (level >= battery[23])
            {
                xiaoshi = "00";
                fenzhong = "54";
            }
            if (level >= battery[22])
            {
                xiaoshi = "00";
                fenzhong = "53";
            }
            if (level >= battery[21])
            {
                xiaoshi = "00";
                fenzhong = "52";
            }
            if (level >= battery[20])
            {
                xiaoshi = "00";
                fenzhong = "50";
            }
            if (level >= battery[19])
            {
                xiaoshi = "00";
                fenzhong = "49";
            }
            if (level >= battery[18])
            {
                xiaoshi = "00";
                fenzhong = "47";
            }
            if (level >= battery[17])
            {
                xiaoshi = "00";
                fenzhong = "45";
            }
            if (level >= battery[16])
            {
                xiaoshi = "00";
                fenzhong = "42";
            }
            if (level >= battery[15])
            {
                xiaoshi = "00";
                fenzhong = "39";
            }
            if (level >= battery[14])
            {
                xiaoshi = "00";
                fenzhong = "37";
            }
            if (level >= battery[13])
            {
                xiaoshi = "00";
                fenzhong = "35";
            }
            if (level >= battery[12])
            {
                xiaoshi = "00";
                fenzhong = "33";
            }
            if (level >= battery[11])
            {
                xiaoshi = "00";
                fenzhong = "32";
            }
            if (level >= battery[10])
            {
                xiaoshi = "00";
                fenzhong = "30";
            }
            if (level >= battery[9])
            {
                xiaoshi = "00";
                fenzhong = "26";
            }
            if (level >= battery[8])
            {
                xiaoshi = "00";
                fenzhong = "24";
            }
            if (level >= battery[7])
            {
                xiaoshi = "00";
                fenzhong = "22";
            }
            if (level >= battery[6])
            {
                xiaoshi = "00";
                fenzhong = "21";
            }
            if (level >= battery[5])
            {
                xiaoshi = "00";
                fenzhong = "19";
            }
            if (level >= battery[4])
            {
                xiaoshi = "00";
                fenzhong = "15";
            }
            if (level >= battery[3])
            {
                xiaoshi = "00";
                fenzhong = "10";
            }
            if (level >= battery[2])
            {
                xiaoshi = "00";
                fenzhong = "09";
            }
            if (level >= battery[1])
            {
                xiaoshi = "00";
                fenzhong = "07";
            }
            if (level >= battery[0])
            {
                xiaoshi = "00";
                fenzhong = "05";
            }
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent) { }
        intent = null;
        obj = arg0.getPackageManager().getPackageInfo("com.aioapp.battery", 0);
        intent = ((Intent) (obj));
_L2:
        if (isCharging && intent == null && System.currentTimeMillis() > SharedPreferencesConfig.GetChangeTime(arg0))
        {
            SharedPreferencesConfig.SetChangeTime(arg0, System.currentTimeMillis() + 0x2932e00L);
            (new Thread() {

                final BatteryChanageReceiver this$0;

                public void run()
                {
                    super.run();
                    publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=battery_charging");
                }

            
            {
                this$0 = BatteryChanageReceiver.this;
                super();
            }
            }).start();
            MobclickAgent.onEvent(arg0, "batterychange");
            itemsOnClick4 = new android.view.View.OnClickListener() {

                final BatteryChanageReceiver this$0;
                private final Context val$arg0;

                public void onClick(View view)
                {
                    view.getId();
                    JVM INSTR tableswitch 2131165496 2131165497: default 28
                //                               2131165496 326
                //                               2131165497 29;
                       goto _L1 _L2 _L3
_L1:
                    return;
_L3:
                    MobclickAgent.onEvent(arg0, "batterychange_click");
                    (new Thread() {

                        final _cls2 this$1;

                        public void run()
                        {
                            super.run();
                            publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=battery_charging_click");
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    }).start();
                    view = null;
                    android.content.pm.PackageInfo packageinfo;
                    try
                    {
                        packageinfo = arg0.getPackageManager().getPackageInfo("com.aioapp.battery", 0);
                    }
                    catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1)
                    {
                        namenotfoundexception1.printStackTrace();
                        continue; /* Loop/switch isn't completed */
                    }
                    view = packageinfo;
_L12:
                    if (view != null) goto _L5; else goto _L4
_L4:
                    if (!AIOBATTERYAPK.exists() || getFileSizes(AIOBATTERYAPK) < 0x377effL) goto _L7; else goto _L6
_L6:
                    view = new Intent("android.intent.action.VIEW");
                    view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOBATTERYAPK).toString()), "application/vnd.android.package-archive");
                    view.addFlags(0x10000000);
                    arg0.startActivity(view);
_L10:
                    changeDialog.dismiss();
                    return;
_L7:
                    if (!AIOBATTERY.exists() || getFileSizes(AIOBATTERY) < 0x377effL) goto _L9; else goto _L8
_L8:
                    (arg0. new AsyncTask() {

                        final _cls2 this$1;
                        private final Context val$arg0;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            Myutils.copyfile(AIOBATTERY, AIOBATTERYAPK, Boolean.valueOf(false));
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
                            void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOBATTERYAPK).toString()), "application/vnd.android.package-archive");
                            void1.addFlags(0x10000000);
                            arg0.startActivity(void1);
                        }

            
            {
                this$1 = final__pcls2;
                arg0 = Context.this;
                super();
            }
                    }).execute(new Void[0]);
                      goto _L10
_L9:
                    try
                    {
                        view = new Intent(arg0, com/aio/downloader/activity/AppDetailsActivity);
                        view.putExtra("myid", "com.aioapp.battery");
                        view.putExtra("xiazaidianchi", 1);
                        view.addFlags(0x10000000);
                        arg0.startActivity(view);
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        view.printStackTrace();
                    }
                      goto _L10
_L5:
                    view = arg0.getPackageManager().getLaunchIntentForPackage("com.aioapp.battery");
                    view.addFlags(0x10000000);
                    arg0.startActivity(view);
                      goto _L10
_L2:
                    changeDialog.dismiss();
                    return;
                    if (true) goto _L12; else goto _L11
_L11:
                }


            
            {
                this$0 = BatteryChanageReceiver.this;
                arg0 = context;
                super();
            }
            };
            changeDialog = new ChangeDialog(arg0, 0x7f0c0010, itemsOnClick4, xiaoshi, fenzhong, level);
            changeDialog.setCanceledOnTouchOutside(true);
            changeDialog.getWindow().setType(2003);
            changeDialog.show();
            intent = changeDialog.getWindow();
            obj = intent.getAttributes();
            intent.setGravity(80);
            obj.width = ((WindowManager)arg0.getSystemService("window")).getDefaultDisplay().getWidth();
            intent.setAttributes(((android.view.WindowManager.LayoutParams) (obj)));
        }
        return;
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }




}
