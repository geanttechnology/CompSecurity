// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import com.aio.downloader.utils.Myutils;
import com.umeng.analytics.MobclickAgent;
import java.io.File;

// Referenced classes of package com.aio.downloader.activity:
//            AppDetailsActivity

class this._cls0
    implements android.view.ilsActivity._cls24
{

    final AppDetailsActivity this$0;

    public void onClick(View view)
    {
        MobclickAgent.onEvent(AppDetailsActivity.this, "pdt_caller_click");
        view = null;
        android.content.pm.PackageInfo packageinfo = getPackageManager().getPackageInfo("com.freepezzle.hexcrush", 0);
        view = packageinfo;
_L1:
        if (view != null)
        {
            break MISSING_BLOCK_LABEL_216;
        }
        android.content.pm.FoundException foundexception;
        try
        {
            if (AppDetailsActivity.access$72(AppDetailsActivity.this).exists() && getFileSizes(AppDetailsActivity.access$72(AppDetailsActivity.this)) >= 0x19ee4cL)
            {
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AppDetailsActivity.access$72(AppDetailsActivity.this)).toString()), "application/vnd.android.package-archive");
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
        break MISSING_BLOCK_LABEL_124;
        foundexception;
        foundexception.printStackTrace();
          goto _L1
        if (AppDetailsActivity.access$73(AppDetailsActivity.this).exists() && getFileSizes(AppDetailsActivity.access$73(AppDetailsActivity.this)) >= 0x19ee4cL)
        {
            (new AsyncTask() {

                final AppDetailsActivity._cls24 this$1;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    Myutils.copyfile(AppDetailsActivity.access$73(this$0), AppDetailsActivity.access$72(this$0), Boolean.valueOf(false));
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
                    void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AppDetailsActivity.access$72(this$0)).toString()), "application/vnd.android.package-archive");
                    startActivity(void1);
                }

            
            {
                this$1 = AppDetailsActivity._cls24.this;
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
    }


    _cls1.this._cls1()
    {
        this$0 = AppDetailsActivity.this;
        super();
    }
}
