// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

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
import java.io.FileInputStream;

// Referenced classes of package com.aio.downloader.activity:
//            AppDetailsActivity

public class HexCrushActivity extends BaseActivity
{

    private File AIOCRUSHAPK;
    private File AIOCRUSHSWF;

    public HexCrushActivity()
    {
        AIOCRUSHSWF = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("crush.swf").toString());
        AIOCRUSHAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("crush.apk").toString());
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
        MobclickAgent.onEvent(getApplicationContext(), "shortcut_crush_click");
        bundle = null;
        android.content.pm.PackageInfo packageinfo = getPackageManager().getPackageInfo("com.freepezzle.hexcrush", 0);
        bundle = packageinfo;
_L1:
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        try
        {
            if (AIOCRUSHAPK.exists() && getFileSizes(AIOCRUSHAPK) >= 0x19ee4cL)
            {
                bundle = new Intent("android.intent.action.VIEW");
                bundle.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCRUSHAPK).toString()), "application/vnd.android.package-archive");
                startActivity(bundle);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            return;
        }
        break MISSING_BLOCK_LABEL_111;
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
          goto _L1
        if (AIOCRUSHSWF.exists() && getFileSizes(AIOCRUSHSWF) >= 0x19ee4cL)
        {
            (new AsyncTask() {

                final HexCrushActivity this$0;

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
                this$0 = HexCrushActivity.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
        bundle = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
        bundle.putExtra("myid", "com.freepezzle.hexcrush");
        startActivity(bundle);
        return;
        startActivity(getPackageManager().getLaunchIntentForPackage("com.freepezzle.hexcrush"));
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
