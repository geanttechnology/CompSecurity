// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import com.aio.downloader.activity.AppDetailsActivity;
import com.aio.downloader.dialog.UninstallDailog;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.publicTools;
import com.umeng.analytics.MobclickAgent;
import java.io.File;

// Referenced classes of package com.aio.downloader.service:
//            GetBroadcast

class val.context extends AsyncTask
{

    final val.context this$1;
    private final Context val$context;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        Myutils.copyfile(GetBroadcast.access$3(_fld0), GetBroadcast.access$1(_fld0), Boolean.valueOf(false));
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
        void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(GetBroadcast.access$2(_fld0)).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
        void1.addFlags(0x10000000);
        val$context.startActivity(void1);
    }

    l.context()
    {
        this$1 = final_context1;
        val$context = Context.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/service/GetBroadcast$5

/* anonymous class */
    class GetBroadcast._cls5
        implements android.view.View.OnClickListener
    {

        final GetBroadcast this$0;
        private final Context val$context;

        public void onClick(View view)
        {
            switch (view.getId())
            {
            case 2131165329: 
            default:
                return;

            case 2131165328: 
                GetBroadcast.access$4(GetBroadcast.this).dismiss();
                return;

            case 2131165330: 
                MobclickAgent.onEvent(context, "UnInstall_click");
                break;
            }
            (new GetBroadcast._cls5._cls1()).start();
            view = null;
            android.content.pm.PackageInfo packageinfo = context.getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
            view = packageinfo;
_L1:
            android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
            if (view == null)
            {
                if (GetBroadcast.access$1(GetBroadcast.this).exists())
                {
                    view = new Intent("android.intent.action.VIEW");
                    view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(GetBroadcast.access$2(GetBroadcast.this)).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                    view.addFlags(0x10000000);
                    context.startActivity(view);
                } else
                if (GetBroadcast.access$3(GetBroadcast.this).exists())
                {
                    (context. new GetBroadcast._cls5._cls2()).execute(new Void[0]);
                } else
                {
                    view = new Intent(context, com/aio/downloader/activity/AppDetailsActivity);
                    view.putExtra("myid", "com.evzapp.cleanmaster");
                    view.addFlags(0x10000000);
                    context.startActivity(view);
                }
            } else
            {
                view = context.getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
                view.addFlags(0x10000000);
                context.startActivity(view);
            }
            GetBroadcast.access$4(GetBroadcast.this).dismiss();
            return;
            namenotfoundexception;
            namenotfoundexception.printStackTrace();
              goto _L1
        }


            
            {
                this$0 = final_getbroadcast;
                context = Context.this;
                super();
            }

        // Unreferenced inner class com/aio/downloader/service/GetBroadcast$5$1

/* anonymous class */
        class GetBroadcast._cls5._cls1 extends Thread
        {

            final GetBroadcast._cls5 this$1;

            public void run()
            {
                super.run();
                publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=uninstall_click");
            }

                    
                    {
                        this$1 = GetBroadcast._cls5.this;
                        super();
                    }
        }

    }

}
