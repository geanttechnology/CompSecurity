// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import com.aio.downloader.mydownload.BaseActivity;
import com.aio.downloader.utils.Myutils;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.io.FileInputStream;

// Referenced classes of package com.aio.downloader.activity:
//            AppDetailsActivity

public class WidgeGametActivity extends BaseActivity
{

    private File AIOBATTERY;
    private File AIOBATTERYAPK;
    private Intent intent;
    private PackageInfo packageInfo;

    public WidgeGametActivity()
    {
        AIOBATTERY = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("battery.swf").toString());
        AIOBATTERYAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("battery.apk").toString());
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

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        MobclickAgent.onEvent(getApplicationContext(), "shortcut_battery_click");
        try
        {
            packageInfo = getPackageManager().getPackageInfo("com.aioapp.battery", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        if (packageInfo != null)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        try
        {
            if (AIOBATTERYAPK.exists() && getFileSizes(AIOBATTERYAPK) >= 0x377effL)
            {
                intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOBATTERYAPK).toString()), "application/vnd.android.package-archive");
                intent.addFlags(0x10000000);
                startActivity(intent);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            return;
        }
        if (AIOBATTERY.exists() && getFileSizes(AIOBATTERY) >= 0x377effL)
        {
            (new AsyncTask() {

                final WidgeGametActivity this$0;

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
                this$0 = WidgeGametActivity.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
        intent = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
        intent.putExtra("myid", "com.aioapp.battery");
        intent.addFlags(0x10000000);
        startActivity(intent);
        return;
        intent = getPackageManager().getLaunchIntentForPackage("com.aioapp.battery");
        intent.addFlags(0x10000000);
        startActivity(intent);
        return;
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            moveTaskToBack(true);
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    protected void onPause()
    {
        super.onPause();
        finish();
    }


}
