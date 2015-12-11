// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.aio.downloader.adapter.ListAdapter;
import com.aio.downloader.cleaner.JunkActivity;
import com.aio.downloader.model.PackagesInfo;
import com.aio.downloader.model.Programe;
import com.aio.downloader.unstall.MyAppActivity;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.SharedPreferencesConfig;
import com.aio.downloader.views.ClearView;
import com.aio.downloader.views.DeletableEditText;
import com.aio.downloader.views.HorizontalListView;
import com.aio.downloader.views.LImageButton;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.umeng.analytics.MobclickAgent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.aio.downloader.activity:
//            AppDetailsActivity, FunActivity1, MySettingsActivity

public class FloatCleanerMaster extends Activity
    implements android.view.View.OnClickListener, AdListener
{

    private File AIOBATTERY;
    private File AIOBATTERYAPK;
    private File AIOCALLERAPK;
    private File AIOCALLERDOWN;
    private File AIOCRUSHAPK;
    private File AIOCRUSHSWF;
    private com.aio.downloader.views.ClearView.OnAngelChangeListener CVlistener;
    private File PRO_DIR;
    private File PRO_DIR_FOME;
    private File PRO_DIR_TO;
    private ImageView adulttopgift;
    private android.view.View.OnClickListener bglistener;
    private int cWidth;
    private TextView clear_count;
    private ConnectivityManager cm;
    private int current;
    private ClearView cv;
    private DeletableEditText float_search_view;
    private LImageButton float_searchimg;
    private int hSpacing;
    private List infos;
    private boolean isfbshow;
    private ImageView iv_airplane;
    private ImageView iv_auto_rotate;
    private ImageView iv_brightness;
    private ImageView iv_buletooth;
    private ImageView iv_cricle;
    private ImageView iv_flash;
    private ImageView iv_float_set;
    private ImageView iv_gps;
    private ImageView iv_sleep;
    private ImageView iv_vibaration;
    private ImageView iv_wifi;
    private List list;
    private LinearLayout ll_auto_rotate;
    private LinearLayout ll_brightness;
    private LinearLayout ll_flash;
    private LinearLayout ll_float_fun;
    private LinearLayout ll_float_gift;
    private LinearLayout ll_gps;
    private LinearLayout ll_sleep;
    private LinearLayout ll_wifi;
    private HorizontalListView lv_float_recenct_app;
    private AudioManager mAudioManager;
    private BluetoothAdapter mBluetoothAdapter;
    private GridView mGridView;
    private int mRandom;
    private HorizontalScrollView mScrollView;
    private int max;
    private NativeAd nativeAdfb;
    PackageInfo packageInfo;
    private int state_blue;
    private TextView tv_airplane;
    private TextView tv_auto_rotate;
    private TextView tv_buletooth;
    private TextView tv_flash;
    private TextView tv_gps;
    private TextView tv_vibaration;
    private TextView tv_wifi;
    private WifiManager wm;
    private int y;

    public FloatCleanerMaster()
    {
        PRO_DIR_FOME = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.apk").toString());
        PRO_DIR_TO = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.swf").toString());
        PRO_DIR = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner").toString());
        AIOCALLERDOWN = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("caller.swf").toString());
        AIOCALLERAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("caller.apk").toString());
        AIOCRUSHSWF = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("crush.swf").toString());
        AIOCRUSHAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("crush.apk").toString());
        AIOBATTERY = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("battery.swf").toString());
        AIOBATTERYAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("battery.apk").toString());
        mRandom = 0;
        packageInfo = null;
        y = 0;
        cWidth = 120;
        hSpacing = 10;
        infos = new ArrayList();
        isfbshow = false;
        CVlistener = new com.aio.downloader.views.ClearView.OnAngelChangeListener() {

            final FloatCleanerMaster this$0;

            public void OnAngelChanged(int i)
            {
                SpannableString spannablestring = new SpannableString((new StringBuilder(String.valueOf((i * 100) / 360))).append("%").toString());
                spannablestring.setSpan(new AbsoluteSizeSpan(35), spannablestring.length() - 1, spannablestring.length(), 33);
                clear_count.setText(spannablestring);
            }

            
            {
                this$0 = FloatCleanerMaster.this;
                super();
            }
        };
        bglistener = new android.view.View.OnClickListener() {

            final FloatCleanerMaster this$0;

            public void onClick(View view)
            {
                switch (view.getId())
                {
                default:
                    return;

                case 2131165653: 
                    clearMemory(getApplicationContext());
                    break;
                }
                cv.setAngle(formatMemory(getApplicationContext()));
            }

            
            {
                this$0 = FloatCleanerMaster.this;
                super();
            }
        };
    }

    private int dip2px(Context context, float f)
    {
        return (int)(f * context.getResources().getDisplayMetrics().density + 0.5F);
    }

    private void facebookad()
    {
        nativeAdfb.registerViewForInteraction(adulttopgift);
    }

    private void findclick()
    {
        ll_brightness.setOnClickListener(this);
        ll_wifi.setOnClickListener(this);
        ll_gps.setOnClickListener(this);
        ll_flash.setOnClickListener(this);
        ll_auto_rotate.setOnClickListener(this);
        ll_sleep.setOnClickListener(this);
        ll_float_fun.setOnClickListener(this);
        cv.SetonAngelchanged(CVlistener);
        cv.setAngle(formatMemory(getApplicationContext()));
        clear_count.setOnClickListener(bglistener);
        iv_float_set.setOnClickListener(this);
        adulttopgift.setOnClickListener(new android.view.View.OnClickListener() {

            final FloatCleanerMaster this$0;

            public void onClick(View view)
            {
                SharedPreferencesConfig.SetClickTime(getApplicationContext(), System.currentTimeMillis() + 30000L);
                adulttopgift.setImageResource(0x7f020090);
                if (isfbshow) goto _L2; else goto _L1
_L1:
                mRandom = (int)(Math.random() * 4D) + 1;
                if (mRandom != 1) goto _L4; else goto _L3
_L3:
                try
                {
                    packageInfo = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                if (packageInfo != null) goto _L6; else goto _L5
_L5:
                if (!PRO_DIR_FOME.exists()) goto _L8; else goto _L7
_L7:
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                view.addFlags(0x10000000);
                startActivity(view);
_L2:
                return;
_L8:
                if (PRO_DIR_TO.exists())
                {
                    (new AsyncTask() {

                        final _cls3 this$1;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            Myutils.copyfile(PRO_DIR_TO, PRO_DIR_FOME, Boolean.valueOf(false));
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
                            void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                            void1.addFlags(0x10000000);
                            startActivity(void1);
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    }).execute(new Void[0]);
                    return;
                } else
                {
                    view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                    view.putExtra("myid", "com.evzapp.cleanmaster");
                    view.addFlags(0x10000000);
                    startActivity(view);
                    return;
                }
_L6:
                view = getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
                view.addFlags(0x10000000);
                startActivity(view);
                return;
_L4:
                if (mRandom != 2)
                {
                    break MISSING_BLOCK_LABEL_539;
                }
                try
                {
                    packageInfo = getApplicationContext().getPackageManager().getPackageInfo("com.freepezzle.hexcrush", 0);
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                if (packageInfo != null)
                {
                    break MISSING_BLOCK_LABEL_517;
                }
                try
                {
                    if (AIOCRUSHAPK.exists() && getFileSizes(AIOCRUSHAPK) >= 0x19ee4cL)
                    {
                        view = new Intent("android.intent.action.VIEW");
                        view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCRUSHAPK).toString()), "application/vnd.android.package-archive");
                        startActivity(view);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                    return;
                }
                if (AIOCRUSHSWF.exists() && getFileSizes(AIOCRUSHSWF) >= 0x19ee4cL)
                {
                    (new AsyncTask() {

                        final _cls3 this$1;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            Myutils.copyfile(AIOCRUSHSWF, AIOCRUSHAPK, Boolean.valueOf(false));
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
                            void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCRUSHAPK).toString()), "application/vnd.android.package-archive");
                            startActivity(void1);
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    }).execute(new Void[0]);
                    return;
                }
                view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                view.putExtra("myid", "com.freepezzle.hexcrush");
                startActivity(view);
                return;
                view = getPackageManager().getLaunchIntentForPackage("com.freepezzle.hexcrush");
                startActivity(view);
                return;
                if (mRandom != 3)
                {
                    continue; /* Loop/switch isn't completed */
                }
                try
                {
                    packageInfo = getPackageManager().getPackageInfo("com.allinone.callerid", 0);
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                if (packageInfo != null)
                {
                    break MISSING_BLOCK_LABEL_779;
                }
                try
                {
                    if (AIOCALLERAPK.exists() && getFileSizes(AIOCALLERAPK) >= 0x357458L)
                    {
                        view = new Intent("android.intent.action.VIEW");
                        view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCALLERAPK).toString()), "application/vnd.android.package-archive");
                        view.addFlags(0x10000000);
                        startActivity(view);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                    return;
                }
                if (AIOCALLERDOWN.exists() && getFileSizes(AIOCALLERDOWN) >= 0x357458L)
                {
                    (new AsyncTask() {

                        final _cls3 this$1;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            Myutils.copyfile(AIOCALLERDOWN, AIOCALLERAPK, Boolean.valueOf(false));
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
                            void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCALLERAPK).toString()), "application/vnd.android.package-archive");
                            void1.addFlags(0x10000000);
                            startActivity(void1);
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    }).execute(new Void[0]);
                    return;
                }
                view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                view.putExtra("myid", "com.allinone.callerid");
                view.addFlags(0x10000000);
                startActivity(view);
                return;
                view = getPackageManager().getLaunchIntentForPackage("com.allinone.callerid");
                view.addFlags(0x10000000);
                startActivity(view);
                return;
                if (mRandom != 4) goto _L2; else goto _L9
_L9:
                try
                {
                    packageInfo = getPackageManager().getPackageInfo("com.aioapp.battery", 0);
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                if (packageInfo != null)
                {
                    break MISSING_BLOCK_LABEL_1048;
                }
                try
                {
                    if (AIOBATTERYAPK.exists() && getFileSizes(AIOBATTERYAPK) >= 0x377effL)
                    {
                        view = new Intent("android.intent.action.VIEW");
                        view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOBATTERYAPK).toString()), "application/vnd.android.package-archive");
                        view.addFlags(0x10000000);
                        startActivity(view);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                    return;
                }
                if (AIOBATTERY.exists() && getFileSizes(AIOBATTERY) >= 0x377effL)
                {
                    (new AsyncTask() {

                        final _cls3 this$1;

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
                            startActivity(void1);
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    }).execute(new Void[0]);
                    return;
                }
                view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                view.putExtra("myid", "com.aioapp.battery");
                view.addFlags(0x10000000);
                startActivity(view);
                return;
                view = getPackageManager().getLaunchIntentForPackage("com.aioapp.battery");
                view.addFlags(0x10000000);
                startActivity(view);
                return;
            }


            
            {
                this$0 = FloatCleanerMaster.this;
                super();
            }
        });
    }

    private int formatMemory(Context context)
    {
        long l;
        if (totalMemory() < 0L)
        {
            l = getTotalMemory2(context);
        } else
        {
            l = totalMemory();
        }
        return (int)(((l - getAvailMemory(context)) * 360L) / l);
    }

    public static boolean getAirplaneMode(Context context)
    {
        return android.provider.Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1;
    }

    private int getScreenBrightness(Context context)
    {
        int i;
        try
        {
            i = android.provider.Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return 255;
        }
        return i;
    }

    private int getScreenMode(Context context)
    {
        int i;
        try
        {
            i = android.provider.Settings.System.getInt(context.getContentResolver(), "screen_brightness_mode");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return 0;
        }
        return i;
    }

    private int getScreenOffTime(Context context)
    {
        int i;
        try
        {
            i = android.provider.Settings.System.getInt(context.getContentResolver(), "screen_off_timeout");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return 0;
        }
        return i;
    }

    private void init()
    {
        iv_brightness = (ImageView)findViewById(0x7f0701b3);
        ll_brightness = (LinearLayout)findViewById(0x7f0701b2);
        ll_wifi = (LinearLayout)findViewById(0x7f0701b4);
        iv_wifi = (ImageView)findViewById(0x7f0701b5);
        tv_wifi = (TextView)findViewById(0x7f0701b6);
        ll_gps = (LinearLayout)findViewById(0x7f0701b7);
        iv_gps = (ImageView)findViewById(0x7f0701b8);
        tv_gps = (TextView)findViewById(0x7f0701b9);
        ll_flash = (LinearLayout)findViewById(0x7f0701ba);
        iv_flash = (ImageView)findViewById(0x7f0701bb);
        tv_flash = (TextView)findViewById(0x7f0701bc);
        findViewById(0x7f0701bd).setOnClickListener(this);
        findViewById(0x7f0701be).setOnClickListener(this);
        ll_auto_rotate = (LinearLayout)findViewById(0x7f0701bf);
        iv_auto_rotate = (ImageView)findViewById(0x7f0701c0);
        tv_auto_rotate = (TextView)findViewById(0x7f0701c1);
        ll_sleep = (LinearLayout)findViewById(0x7f0701c2);
        iv_sleep = (ImageView)findViewById(0x7f0701c3);
        findViewById(0x7f0701c4).setOnClickListener(this);
        iv_vibaration = (ImageView)findViewById(0x7f0701c5);
        tv_vibaration = (TextView)findViewById(0x7f0701c6);
        findViewById(0x7f0701c7).setOnClickListener(this);
        iv_airplane = (ImageView)findViewById(0x7f0701c8);
        tv_airplane = (TextView)findViewById(0x7f0701c9);
        findViewById(0x7f0701ca).setOnClickListener(this);
        iv_buletooth = (ImageView)findViewById(0x7f0701cb);
        tv_buletooth = (TextView)findViewById(0x7f0701cc);
        findViewById(0x7f0701cd).setOnClickListener(this);
        ll_float_fun = (LinearLayout)findViewById(0x7f0701af);
        cv = (ClearView)findViewById(0x7f0701d3);
        clear_count = (TextView)findViewById(0x7f0701d5);
        findViewById(0x7f0701cf).setOnClickListener(this);
        findViewById(0x7f0701ce).setOnClickListener(this);
        findViewById(0x7f0701d0).setOnClickListener(this);
        iv_float_set = (ImageView)findViewById(0x7f0701d2);
        lv_float_recenct_app = (HorizontalListView)findViewById(0x7f0701d6);
        ll_float_gift = (LinearLayout)findViewById(0x7f0701b0);
        adulttopgift = (ImageView)findViewById(0x7f0701b1);
        adulttopgift.setImageResource(0x7f02008f);
        iv_cricle = (ImageView)findViewById(0x7f0701d4);
        iv_cricle.setOnClickListener(bglistener);
        findViewById(0x7f0701ad).setOnClickListener(this);
        findViewById(0x7f0701ae).setOnClickListener(this);
    }

    private void saveScreenBrightness(int i, Context context)
    {
        try
        {
            android.provider.Settings.System.putInt(context.getContentResolver(), "screen_brightness", i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    private void setScreenMode(int i, Context context)
    {
        try
        {
            android.provider.Settings.System.putInt(context.getContentResolver(), "screen_brightness_mode", i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    private void setScreenOffTime(int i, Context context)
    {
        try
        {
            android.provider.Settings.System.putInt(context.getContentResolver(), "screen_off_timeout", i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    public void clearMemory(Context context)
    {
        context = (ActivityManager)context.getSystemService("activity");
        Iterator iterator = context.getRunningAppProcesses().iterator();
        do
        {
            android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo;
            do
            {
                if (!iterator.hasNext())
                {
                    return;
                }
                runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)iterator.next();
            } while (runningappprocessinfo.importance < 300 || runningappprocessinfo.processName.equals("com.evzapp.cleanmaster") || runningappprocessinfo.processName.equals(getPackageName()));
            context.killBackgroundProcesses(runningappprocessinfo.processName);
        } while (true);
    }

    public long getAvailMemory(Context context)
    {
        context = (ActivityManager)context.getSystemService("activity");
        android.app.ActivityManager.MemoryInfo memoryinfo = new android.app.ActivityManager.MemoryInfo();
        context.getMemoryInfo(memoryinfo);
        return memoryinfo.availMem;
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

    public List getRunningProcess()
    {
        PackagesInfo packagesinfo;
        PackageManager packagemanager;
        ArrayList arraylist;
        Object obj;
        packagesinfo = new PackagesInfo(this);
        obj = ((ActivityManager)getSystemService("activity")).getRunningAppProcesses();
        packagemanager = getPackageManager();
        arraylist = new ArrayList();
        obj = ((List) (obj)).iterator();
_L2:
        android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo;
        if (!((Iterator) (obj)).hasNext())
        {
            return arraylist;
        }
        runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)((Iterator) (obj)).next();
        int i = packagemanager.getApplicationInfo(runningappprocessinfo.processName, 0).flags;
        if ((i & 1) != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
_L3:
        if (!runningappprocessinfo.processName.equals("system") && !runningappprocessinfo.processName.contains("google") && !runningappprocessinfo.processName.startsWith("android") && !runningappprocessinfo.processName.equals("com.android.phone") && !runningappprocessinfo.processName.equals(getPackageName()) && packagesinfo.getInfo(runningappprocessinfo.processName) != null)
        {
            Log.e("toggletag", (new StringBuilder("toggletag=")).append(runningappprocessinfo.processName).toString());
            Programe programe = new Programe();
            programe.setIcon(packagesinfo.getInfo(runningappprocessinfo.processName).loadIcon(packagemanager));
            programe.setName(packagesinfo.getInfo(runningappprocessinfo.processName).loadLabel(packagemanager).toString());
            programe.setPackagename(runningappprocessinfo.processName);
            System.out.println(packagesinfo.getInfo(runningappprocessinfo.processName).loadLabel(packagemanager).toString());
            arraylist.add(programe);
        }
        if (true) goto _L2; else goto _L1
_L1:
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
          goto _L3
    }

    public long getTotalMemory2(Context context)
    {
        context = (ActivityManager)context.getSystemService("activity");
        android.app.ActivityManager.MemoryInfo memoryinfo = new android.app.ActivityManager.MemoryInfo();
        context.getMemoryInfo(memoryinfo);
        return memoryinfo.totalMem;
    }

    public boolean isOPen(Context context)
    {
        context = (LocationManager)context.getSystemService("location");
        boolean flag = context.isProviderEnabled("gps");
        boolean flag1 = context.isProviderEnabled("network");
        return flag || flag1;
    }

    public void onAdClicked(Ad ad)
    {
        adulttopgift.setImageResource(0x7f020090);
    }

    public void onAdLoaded(Ad ad)
    {
        if (nativeAdfb == null || nativeAdfb != ad)
        {
            return;
        } else
        {
            nativeAdfb.unregisterView();
            facebookad();
            isfbshow = true;
            return;
        }
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131165613 2131165650: default 172
    //                   2131165613 1401
    //                   2131165614 1406
    //                   2131165615 1344
    //                   2131165616 172
    //                   2131165617 172
    //                   2131165618 173
    //                   2131165619 172
    //                   2131165620 386
    //                   2131165621 172
    //                   2131165622 172
    //                   2131165623 467
    //                   2131165624 172
    //                   2131165625 172
    //                   2131165626 514
    //                   2131165627 172
    //                   2131165628 172
    //                   2131165629 529
    //                   2131165630 570
    //                   2131165631 585
    //                   2131165632 172
    //                   2131165633 172
    //                   2131165634 674
    //                   2131165635 172
    //                   2131165636 890
    //                   2131165637 172
    //                   2131165638 172
    //                   2131165639 993
    //                   2131165640 172
    //                   2131165641 172
    //                   2131165642 1008
    //                   2131165643 172
    //                   2131165644 172
    //                   2131165645 1107
    //                   2131165646 1129
    //                   2131165647 1382
    //                   2131165648 1148
    //                   2131165649 172
    //                   2131165650 1363;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L5 _L1 _L6 _L1 _L1 _L7 _L1 _L1 _L8 _L1 _L1 _L9 _L10 _L11 _L1 _L1 _L12 _L1 _L13 _L1 _L1 _L14 _L1 _L1 _L15 _L1 _L1 _L16 _L17 _L18 _L19 _L1 _L20
_L17:
        break MISSING_BLOCK_LABEL_1129;
_L19:
        break MISSING_BLOCK_LABEL_1148;
_L4:
        break MISSING_BLOCK_LABEL_1344;
_L20:
        break MISSING_BLOCK_LABEL_1363;
_L18:
        break MISSING_BLOCK_LABEL_1382;
_L2:
        break MISSING_BLOCK_LABEL_1401;
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_1406;
_L21:
        return;
_L5:
        Log.e("floattag", (new StringBuilder("bright=")).append(getScreenBrightness(this)).toString());
        if (getScreenMode(getApplicationContext()) == 1)
        {
            setScreenMode(0, getApplicationContext());
            saveScreenBrightness(63, getApplicationContext());
        }
        if (getScreenBrightness(this) >= 0 && getScreenBrightness(this) < 64)
        {
            saveScreenBrightness(64, getApplicationContext());
            iv_brightness.setBackgroundResource(0x7f0200a0);
            return;
        }
        if (getScreenBrightness(this) >= 64 && getScreenBrightness(this) < 127)
        {
            saveScreenBrightness(127, getApplicationContext());
            iv_brightness.setBackgroundResource(0x7f0200a1);
            return;
        }
        if (getScreenBrightness(this) >= 127 && getScreenBrightness(this) < 255)
        {
            saveScreenBrightness(255, getApplicationContext());
            iv_brightness.setBackgroundResource(0x7f02009f);
            return;
        }
        if (getScreenBrightness(this) == 255)
        {
            setScreenMode(1, getApplicationContext());
            iv_brightness.setBackgroundResource(0x7f0200a2);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (wm.getWifiState() == 1)
        {
            wm.setWifiEnabled(true);
            iv_wifi.setBackgroundResource(0x7f0200b0);
            tv_wifi.setTextColor(0xff2196f3);
        }
        if (wm.getWifiState() == 3)
        {
            wm.setWifiEnabled(false);
            iv_wifi.setBackgroundResource(0x7f0200af);
            tv_wifi.setTextColor(0xffa1afb7);
            return;
        }
        if (true) goto _L21; else goto _L7
_L7:
        view = new Intent();
        view.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        view.setFlags(0x10000000);
        try
        {
            startActivity(view);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            view.setAction("android.settings.SETTINGS");
        }
        try
        {
            startActivity(view);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
_L8:
        startActivity(new Intent("android.settings.INTERNAL_STORAGE_SETTINGS"));
        return;
_L9:
        try
        {
            view = new Intent();
            view.setClassName("com.android.calculator2", "com.android.calculator2.Calculator");
            startActivity(view);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Toast.makeText(getApplicationContext(), "Your phone doesn't support.", 0).show();
        }
        return;
_L10:
        startActivity(new Intent("android.intent.action.SET_ALARM"));
        return;
_L11:
        if (android.provider.Settings.System.getInt(getApplicationContext().getContentResolver(), "accelerometer_rotation", 0) == 0)
        {
            android.provider.Settings.System.putInt(getApplicationContext().getContentResolver(), "accelerometer_rotation", 1);
            iv_auto_rotate.setBackgroundResource(0x7f0200a6);
            tv_auto_rotate.setTextColor(0xff2196f3);
            return;
        } else
        {
            android.provider.Settings.System.putInt(getApplicationContext().getContentResolver(), "accelerometer_rotation", 0);
            iv_auto_rotate.setBackgroundResource(0x7f0200a5);
            tv_auto_rotate.setTextColor(0xffa1afb7);
            return;
        }
_L12:
        if (getScreenOffTime(getApplicationContext()) == 0x927c0)
        {
            setScreenOffTime(15000, getApplicationContext());
            iv_sleep.setBackgroundResource(0x7f0200a8);
            return;
        }
        if (getScreenOffTime(getApplicationContext()) == 15000)
        {
            setScreenOffTime(30000, getApplicationContext());
            iv_sleep.setBackgroundResource(0x7f0200ab);
            return;
        }
        if (getScreenOffTime(getApplicationContext()) == 30000)
        {
            setScreenOffTime(60000, getApplicationContext());
            iv_sleep.setBackgroundResource(0x7f0200a9);
            return;
        }
        if (getScreenOffTime(getApplicationContext()) == 60000)
        {
            setScreenOffTime(0x1d4c0, getApplicationContext());
            iv_sleep.setBackgroundResource(0x7f0200aa);
            return;
        }
        if (getScreenOffTime(getApplicationContext()) == 0x1d4c0)
        {
            setScreenOffTime(0x493e0, getApplicationContext());
            iv_sleep.setBackgroundResource(0x7f0200ac);
            return;
        }
        if (getScreenOffTime(getApplicationContext()) == 0x493e0)
        {
            setScreenOffTime(0x927c0, getApplicationContext());
            iv_sleep.setBackgroundResource(0x7f0200a7);
            return;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L13:
        if (y == 2)
        {
            y = 0;
        }
        if (y == 1)
        {
            iv_vibaration.setBackgroundResource(0x7f0200ae);
            mAudioManager.setRingerMode(1);
            tv_vibaration.setTextColor(0xff2196f3);
            y = 2;
        }
        if (y == 0)
        {
            iv_vibaration.setBackgroundResource(0x7f0200ad);
            mAudioManager.setStreamVolume(2, max, max);
            tv_vibaration.setTextColor(0xffa1afb7);
            y = 1;
            return;
        }
        if (true) goto _L21; else goto _L14
_L14:
        startActivity(new Intent("android.settings.AIRPLANE_MODE_SETTINGS"));
        return;
_L15:
        if (mBluetoothAdapter == null)
        {
            Toast.makeText(getApplicationContext(), "This machine is not found bluetooth hardware or drivers\uFF01", 0).show();
            return;
        }
        int i = mBluetoothAdapter.getState();
        if (i == 10)
        {
            mBluetoothAdapter.enable();
            iv_buletooth.setBackgroundResource(0x7f02009e);
            tv_buletooth.setTextColor(0xff2196f3);
        }
        if (i == 12)
        {
            mBluetoothAdapter.disable();
            iv_buletooth.setBackgroundResource(0x7f02009d);
            tv_buletooth.setTextColor(0xffa1afb7);
            return;
        }
        if (true) goto _L21; else goto _L16
_L16:
        view = new Intent();
        view.setAction("android.media.action.STILL_IMAGE_CAMERA");
        startActivity(view);
        return;
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/cleaner/JunkActivity));
        return;
        view = null;
        PackageInfo packageinfo = getPackageManager().getPackageInfo("com.freepezzle.hexcrush", 0);
        view = packageinfo;
_L23:
        if (view != null)
        {
            break MISSING_BLOCK_LABEL_1329;
        }
        try
        {
            if (AIOCRUSHAPK.exists() && getFileSizes(AIOCRUSHAPK) >= 0x19ee4cL)
            {
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCRUSHAPK).toString()), "application/vnd.android.package-archive");
                startActivity(view);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
            return;
        }
        break; /* Loop/switch isn't completed */
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
        if (true) goto _L23; else goto _L22
_L22:
        if (AIOCRUSHSWF.exists() && getFileSizes(AIOCRUSHSWF) >= 0x19ee4cL)
        {
            (new AsyncTask() {

                final FloatCleanerMaster this$0;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    Myutils.copyfile(AIOCRUSHSWF, AIOCRUSHAPK, Boolean.valueOf(false));
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
                    void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCRUSHAPK).toString()), "application/vnd.android.package-archive");
                    startActivity(void1);
                }

            
            {
                this$0 = FloatCleanerMaster.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
        view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
        view.putExtra("myid", "com.freepezzle.hexcrush");
        startActivity(view);
        return;
        startActivity(getPackageManager().getLaunchIntentForPackage("com.freepezzle.hexcrush"));
        return;
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/FunActivity1));
        return;
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/MySettingsActivity));
        return;
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/unstall/MyAppActivity));
        return;
        finish();
        return;
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/MySettingsActivity));
        return;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030042);
        MobclickAgent.onEvent(getApplicationContext(), "floatwindow_show");
        init();
        findclick();
        nativeAdfb = new NativeAd(this, "340186902832477_401790893338744");
        nativeAdfb.setAdListener(this);
        nativeAdfb.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        wm = (WifiManager)getSystemService("wifi");
        cm = (ConnectivityManager)getSystemService("connectivity");
        mAudioManager = (AudioManager)getApplicationContext().getSystemService("audio");
        current = mAudioManager.getStreamVolume(2);
        max = mAudioManager.getStreamMaxVolume(2);
        try
        {
            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            if (mBluetoothAdapter != null)
            {
                state_blue = mBluetoothAdapter.getState();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            return;
        }
    }

    public void onError(Ad ad, AdError aderror)
    {
    }

    protected void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(getApplicationContext());
    }

    protected void onResume()
    {
        Object obj;
        List list1;
        int i;
        super.onResume();
        MobclickAgent.onResume(getApplicationContext());
        Log.e("floattag", (new StringBuilder("bright=")).append(getScreenBrightness(this)).toString());
        if (getScreenBrightness(this) == 1)
        {
            iv_brightness.setBackgroundResource(0x7f0200a2);
        } else
        if (getScreenBrightness(this) > 0 && getScreenBrightness(this) <= 64)
        {
            iv_brightness.setBackgroundResource(0x7f0200a0);
        } else
        if (getScreenBrightness(this) > 64 && getScreenBrightness(this) <= 127)
        {
            iv_brightness.setBackgroundResource(0x7f0200a1);
        } else
        if (getScreenBrightness(this) > 127 && getScreenBrightness(this) <= 255)
        {
            iv_brightness.setBackgroundResource(0x7f02009f);
        }
        if (wm.getWifiState() == 1)
        {
            iv_wifi.setBackgroundResource(0x7f0200af);
            tv_wifi.setTextColor(0xffa1afb7);
        }
        if (wm.getWifiState() == 3)
        {
            iv_wifi.setBackgroundResource(0x7f0200b0);
            tv_wifi.setTextColor(0xff2196f3);
        }
        if (isOPen(getApplicationContext()))
        {
            iv_gps.setBackgroundResource(0x7f020092);
            tv_gps.setTextColor(0xff2196f3);
        } else
        {
            iv_gps.setBackgroundResource(0x7f020091);
            tv_gps.setTextColor(0xffa1afb7);
        }
        if (android.provider.Settings.System.getInt(getApplicationContext().getContentResolver(), "accelerometer_rotation", 0) == 0)
        {
            iv_auto_rotate.setBackgroundResource(0x7f0200a5);
            tv_auto_rotate.setTextColor(0xffa1afb7);
        } else
        {
            iv_auto_rotate.setBackgroundResource(0x7f0200a6);
            tv_auto_rotate.setTextColor(0xff2196f3);
        }
        if (getScreenOffTime(getApplicationContext()) == 0x927c0)
        {
            iv_sleep.setBackgroundResource(0x7f0200a7);
        } else
        if (getScreenOffTime(getApplicationContext()) == 15000)
        {
            iv_sleep.setBackgroundResource(0x7f0200a8);
        } else
        if (getScreenOffTime(getApplicationContext()) == 30000)
        {
            iv_sleep.setBackgroundResource(0x7f0200ab);
        } else
        if (getScreenOffTime(getApplicationContext()) == 60000)
        {
            iv_sleep.setBackgroundResource(0x7f0200a9);
        } else
        if (getScreenOffTime(getApplicationContext()) == 0x1d4c0)
        {
            iv_sleep.setBackgroundResource(0x7f0200aa);
        } else
        if (getScreenOffTime(getApplicationContext()) == 0x493e0)
        {
            iv_sleep.setBackgroundResource(0x7f0200ac);
        }
        if (current > 0)
        {
            iv_vibaration.setBackgroundResource(0x7f0200ad);
            tv_vibaration.setTextColor(0xffa1afb7);
        }
        if (current == 0)
        {
            iv_vibaration.setBackgroundResource(0x7f0200ae);
            tv_vibaration.setTextColor(0xff2196f3);
        }
        if (getAirplaneMode(getApplicationContext()))
        {
            iv_airplane.setBackgroundResource(0x7f02009b);
            tv_airplane.setTextColor(0xff2196f3);
        } else
        {
            iv_airplane.setBackgroundResource(0x7f02009a);
            tv_airplane.setTextColor(0xffa1afb7);
        }
        if (state_blue == 10)
        {
            iv_buletooth.setBackgroundResource(0x7f02009d);
            tv_buletooth.setTextColor(0xffa1afb7);
        }
        if (state_blue == 12)
        {
            iv_buletooth.setBackgroundResource(0x7f02009e);
            tv_buletooth.setTextColor(0xff2196f3);
        }
        list = getRunningProcess();
        if (list.size() != 0) goto _L2; else goto _L1
_L1:
        infos.clear();
        obj = getPackageManager();
        list1 = ((PackageManager) (obj)).getInstalledApplications(8192);
        i = 0;
_L6:
        if (i < list1.size()) goto _L4; else goto _L3
_L3:
        list = infos;
_L2:
        obj = new ListAdapter(list, getApplicationContext());
        lv_float_recenct_app.setAdapter(((android.widget.ListAdapter) (obj)));
        lv_float_recenct_app.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final FloatCleanerMaster this$0;

            public void onItemClick(AdapterView adapterview, View view, int j, long l)
            {
                try
                {
                    adapterview = getPackageManager().getLaunchIntentForPackage(((Programe)list.get(j)).getPackagename());
                    adapterview.addFlags(0x10000000);
                    startActivity(adapterview);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (AdapterView adapterview)
                {
                    Toast.makeText(getApplicationContext(), (new StringBuilder(String.valueOf(((Programe)list.get(j)).getPackagename()))).append(" program is protected").toString(), 0).show();
                }
            }

            
            {
                this$0 = FloatCleanerMaster.this;
                super();
            }
        });
        return;
_L4:
        ApplicationInfo applicationinfo = (ApplicationInfo)list1.get(i);
        if ((((ApplicationInfo)list1.get(i)).flags & 1) == 0)
        {
            Programe programe = new Programe();
            programe.setName(((PackageManager) (obj)).getApplicationLabel((ApplicationInfo)list1.get(i)).toString());
            programe.setIcon(((ApplicationInfo)list1.get(i)).loadIcon(((PackageManager) (obj))));
            programe.setPackagename(((ApplicationInfo)list1.get(i)).packageName);
            infos.add(programe);
            if (((ApplicationInfo)list1.get(i)).packageName.equals("com.allinone.free") && ((ApplicationInfo)list1.get(i)).packageName.equals("com.aio.downloader"))
            {
                infos.remove(programe);
            }
        }
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public long totalMemory()
    {
        Object obj;
        Object obj3;
        obj = null;
        obj3 = null;
        Object obj1 = new BufferedReader(new FileReader("/proc/meminfo"));
        int i = Integer.valueOf(((BufferedReader) (obj1)).readLine().split("\\s+")[1]).intValue();
        long l = i * 1024;
        if (obj1 != null)
        {
            try
            {
                ((BufferedReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        return l;
        Object obj2;
        obj2;
        obj1 = obj3;
_L4:
        obj = obj1;
        ((IOException) (obj2)).printStackTrace();
        if (obj1 != null)
        {
            try
            {
                ((BufferedReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        return 0L;
        obj1;
_L2:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        throw obj1;
        obj2;
        obj = obj1;
        obj1 = obj2;
        if (true) goto _L2; else goto _L1
_L1:
        obj2;
        if (true) goto _L4; else goto _L3
_L3:
    }

















}
