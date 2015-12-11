// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Context;
import android.content.Intent;
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

// Referenced classes of package com.aio.downloader.activity:
//            AppDetailsActivity

public class WidgePaidActivity extends BaseActivity
{

    private File PRO_DIR;
    private File PRO_DIR_FOME;
    private File PRO_DIR_TO;

    public WidgePaidActivity()
    {
        PRO_DIR_FOME = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.apk").toString());
        PRO_DIR_TO = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.swf").toString());
        PRO_DIR = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner").toString());
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        MobclickAgent.onEvent(getApplicationContext(), "shortcut_cleaner_click");
        bundle = null;
        android.content.pm.PackageInfo packageinfo = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
        bundle = packageinfo;
_L2:
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        if (PRO_DIR_FOME.exists())
        {
            bundle = new Intent("android.intent.action.VIEW");
            bundle.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
            bundle.addFlags(0x10000000);
            startActivity(bundle);
            return;
        }
        break; /* Loop/switch isn't completed */
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        if (PRO_DIR_TO.exists())
        {
            (new AsyncTask() {

                final WidgePaidActivity this$0;

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
                this$0 = WidgePaidActivity.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        } else
        {
            bundle = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
            bundle.putExtra("myid", "com.evzapp.cleanmaster");
            bundle.addFlags(0x10000000);
            startActivity(bundle);
            return;
        }
        bundle = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
        bundle.addFlags(0x10000000);
        startActivity(bundle);
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
