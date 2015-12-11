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
import android.os.Handler;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.aio.downloader.adapter.ListAdapter;
import com.aio.downloader.cleaner.JunkActivity;
import com.aio.downloader.cleaner.PhoneBoostActivity;
import com.aio.downloader.model.PackagesInfo;
import com.aio.downloader.model.Programe;
import com.aio.downloader.unstall.MyAppActivity;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.views.DeletableEditText;
import com.aio.downloader.views.LImageButton;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity, MySettingsActivity, AppRecommendKeywordsActivity, AppDetailsActivity

public class FloatActivity extends Activity
    implements android.view.View.OnClickListener
{

    private File AIOCRUSHAPK;
    private File AIOCRUSHSWF;
    private int cWidth;
    private ConnectivityManager cm;
    private int current;
    private DeletableEditText float_search_view;
    private LImageButton float_searchimg;
    private int hSpacing;
    private List infos;
    private ImageView iv_airplane;
    private ImageView iv_auto_rotate;
    private ImageView iv_brightness;
    private ImageView iv_buletooth;
    private ImageView iv_flash;
    private ImageView iv_gps;
    private ImageView iv_sleep;
    private ImageView iv_vibaration;
    private ImageView iv_wifi;
    private List list;
    private LinearLayout ll_auto_rotate;
    private LinearLayout ll_brightness;
    private LinearLayout ll_flash;
    private LinearLayout ll_gps;
    private LinearLayout ll_sleep;
    private LinearLayout ll_wifi;
    private AudioManager mAudioManager;
    private BluetoothAdapter mBluetoothAdapter;
    private GridView mGridView;
    private HorizontalScrollView mScrollView;
    private int max;
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

    public FloatActivity()
    {
        y = 0;
        cWidth = 120;
        hSpacing = 10;
        infos = new ArrayList();
        AIOCRUSHSWF = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("crush.swf").toString());
        AIOCRUSHAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("crush.apk").toString());
    }

    private int dip2px(Context context, float f)
    {
        return (int)(f * context.getResources().getDisplayMetrics().density + 0.5F);
    }

    private void findclick()
    {
        ll_brightness.setOnClickListener(this);
        ll_wifi.setOnClickListener(this);
        ll_gps.setOnClickListener(this);
        ll_flash.setOnClickListener(this);
        ll_auto_rotate.setOnClickListener(this);
        ll_sleep.setOnClickListener(this);
        findViewById(0x7f0701e2).setOnClickListener(this);
        findViewById(0x7f0701e3).setOnClickListener(this);
        findViewById(0x7f0701e4).setOnClickListener(this);
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
        findViewById(0x7f0701da).setOnClickListener(this);
        findViewById(0x7f0701e5).setOnClickListener(this);
        findViewById(0x7f0701e1).setOnClickListener(this);
        float_search_view = (DeletableEditText)findViewById(0x7f0701dd);
        float_searchimg = (LImageButton)findViewById(0x7f0701dc);
        float_searchimg.setOnClickListener(this);
        findViewById(0x7f0701de).setOnClickListener(this);
        mGridView = (GridView)findViewById(0x7f0701e0);
        mScrollView = (HorizontalScrollView)findViewById(0x7f0701df);
        mScrollView.setHorizontalScrollBarEnabled(false);
        TextView textview = (TextView)findViewById(0x7f0701e7);
        findViewById(0x7f0701e8).setOnClickListener(this);
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
        }
        catch (Exception exception) { }
        float_search_view.setOnKeyListener(new android.view.View.OnKeyListener() {

            final FloatActivity this$0;

            public boolean onKey(View view, int i, KeyEvent keyevent)
            {
                if (keyevent.getAction() == 0 && i == 66)
                {
                    try
                    {
                        ((InputMethodManager)float_search_view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(float_search_view.getWindowToken(), 0);
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view) { }
                    try
                    {
                        if (float_search_view.getText().toString().equals(""))
                        {
                            float_search_view.setText("AIO Cleaner");
                        }
                        view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppRecommendKeywordsActivity);
                        view.putExtra("searchid", float_search_view.getText().toString());
                        view.putExtra("searchint", 1);
                        view.setFlags(0x10000000);
                        startActivity(view);
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return false;
                    }
                }
                return false;
            }

            
            {
                this$0 = FloatActivity.this;
                super();
            }
        });
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

    public boolean isOPen(Context context)
    {
        context = (LocationManager)context.getSystemService("location");
        boolean flag = context.isProviderEnabled("gps");
        boolean flag1 = context.isProviderEnabled("network");
        return flag || flag1;
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 20: default 176
    //                   2131165618: 177
    //                   2131165620: 390
    //                   2131165623: 471
    //                   2131165626: 518
    //                   2131165629: 533
    //                   2131165630: 574
    //                   2131165631: 589
    //                   2131165634: 678
    //                   2131165636: 894
    //                   2131165639: 997
    //                   2131165642: 1012
    //                   2131165645: 1111
    //                   2131165658: 1133
    //                   2131165660: 1225
    //                   2131165662: 1314
    //                   2131165665: 1192
    //                   2131165666: 1333
    //                   2131165667: 1352
    //                   2131165668: 1371
    //                   2131165669: 1173;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21
_L14:
        break MISSING_BLOCK_LABEL_1133;
_L21:
        break MISSING_BLOCK_LABEL_1173;
_L17:
        break MISSING_BLOCK_LABEL_1192;
_L15:
        break MISSING_BLOCK_LABEL_1225;
_L16:
        break MISSING_BLOCK_LABEL_1314;
_L18:
        break MISSING_BLOCK_LABEL_1333;
_L19:
        break MISSING_BLOCK_LABEL_1352;
_L1:
        break; /* Loop/switch isn't completed */
_L20:
        break MISSING_BLOCK_LABEL_1371;
_L22:
        return;
_L2:
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
_L3:
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
        if (true) goto _L22; else goto _L4
_L4:
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
_L5:
        startActivity(new Intent("android.settings.INTERNAL_STORAGE_SETTINGS"));
        return;
_L6:
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
_L7:
        startActivity(new Intent("android.intent.action.SET_ALARM"));
        return;
_L8:
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
_L9:
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
_L10:
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
        if (true) goto _L22; else goto _L11
_L11:
        startActivity(new Intent("android.settings.AIRPLANE_MODE_SETTINGS"));
        return;
_L12:
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
        if (true) goto _L22; else goto _L13
_L13:
        view = new Intent();
        view.setAction("android.media.action.STILL_IMAGE_CAMERA");
        startActivity(view);
        return;
        view = new Intent(getApplicationContext(), com/aio/downloader/activity/MyMainActivity);
        view.putExtra("acquire_url_start", "");
        view.setFlags(0x10000000);
        startActivity(view);
        return;
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/MySettingsActivity));
        return;
        view = new Intent();
        view.setAction("android.intent.action.VIEW");
        view.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.evzapp.cleanmaster"));
        startActivity(view);
        return;
        if (float_search_view.getText().toString().equals(""))
        {
            float_search_view.setText("AIO Cleaner");
        }
        view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppRecommendKeywordsActivity);
        view.putExtra("searchid", float_search_view.getText().toString());
        view.putExtra("searchint", 1);
        view.setFlags(0x10000000);
        startActivity(view);
        return;
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/unstall/MyAppActivity));
        return;
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/cleaner/PhoneBoostActivity));
        return;
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/cleaner/JunkActivity));
        return;
        view = null;
        android.content.pm.PackageInfo packageinfo = getPackageManager().getPackageInfo("com.freepezzle.hexcrush", 0);
        view = packageinfo;
_L24:
        if (view != null)
        {
            break MISSING_BLOCK_LABEL_1552;
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
        if (true) goto _L24; else goto _L23
_L23:
        if (AIOCRUSHSWF.exists() && getFileSizes(AIOCRUSHSWF) >= 0x19ee4cL)
        {
            (new AsyncTask() {

                final FloatActivity this$0;

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
                this$0 = FloatActivity.this;
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
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        MobclickAgent.onEvent(getApplicationContext(), "floatwindow_show");
        setContentView(0x7f030044);
        init();
        findclick();
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
        obj = new ListAdapter(list, this);
        mGridView.setAdapter(((android.widget.ListAdapter) (obj)));
        obj = new android.widget.LinearLayout.LayoutParams(dip2px(getApplicationContext(), 55F) * 10, -2);
        mGridView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        mGridView.setColumnWidth(dip2px(getApplicationContext(), 40F));
        mGridView.setHorizontalSpacing(dip2px(getApplicationContext(), 15F));
        mGridView.setVerticalSpacing(dip2px(getApplicationContext(), 20F));
        mGridView.setStretchMode(0);
        mGridView.setNumColumns(10);
        mGridView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final FloatActivity this$0;

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
                this$0 = FloatActivity.this;
                super();
            }
        });
        (new Handler()).postDelayed(new Runnable() {

            final FloatActivity this$0;

            public void run()
            {
                ((InputMethodManager)float_search_view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(float_search_view.getWindowToken(), 0);
            }

            
            {
                this$0 = FloatActivity.this;
                super();
            }
        }, 400L);
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




}
