// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import com.aio.downloader.activity.AppDetailsActivity;
import com.aio.downloader.dialog.InstallfirstDialog;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.publicTools;
import com.umeng.analytics.MobclickAgent;
import java.io.File;

// Referenced classes of package com.aio.downloader.service:
//            ServiceGallery

class this._cls1 extends Thread
{

    final this._cls1 this$1;

    public void run()
    {
        super.run();
        publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=install_click");
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/service/ServiceGallery$3

/* anonymous class */
    class ServiceGallery._cls3
        implements android.view.View.OnClickListener
    {

        final ServiceGallery this$0;

        public void onClick(View view)
        {
            view.getId();
            JVM INSTR tableswitch 2131165516 2131165517: default 28
        //                       2131165516 281
        //                       2131165517 29;
               goto _L1 _L2 _L3
_L1:
            return;
_L3:
            MobclickAgent.onEvent(getApplicationContext(), "first_install_cleaner_click");
            (new ServiceGallery._cls3._cls1()).start();
            view = null;
            android.content.pm.PackageInfo packageinfo;
            try
            {
                packageinfo = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                namenotfoundexception.printStackTrace();
                continue; /* Loop/switch isn't completed */
            }
            view = packageinfo;
_L5:
            if (view == null)
            {
                if (ServiceGallery.access$4(ServiceGallery.this).exists())
                {
                    view = new Intent("android.intent.action.VIEW");
                    view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ServiceGallery.access$5(ServiceGallery.this)).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                    view.addFlags(0x10000000);
                    startActivity(view);
                } else
                if (ServiceGallery.access$6(ServiceGallery.this).exists())
                {
                    (new ServiceGallery._cls3._cls2()).execute(new Void[0]);
                } else
                {
                    view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                    view.putExtra("myid", "com.evzapp.cleanmaster");
                    view.addFlags(0x10000000);
                    startActivity(view);
                }
            } else
            {
                view = getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
                view.addFlags(0x10000000);
                startActivity(view);
            }
            ServiceGallery.access$0(ServiceGallery.this).dismiss();
            return;
_L2:
            ServiceGallery.access$0(ServiceGallery.this).dismiss();
            return;
            if (true) goto _L5; else goto _L4
_L4:
        }


            
            {
                this$0 = ServiceGallery.this;
                super();
            }

        // Unreferenced inner class com/aio/downloader/service/ServiceGallery$3$2

/* anonymous class */
        class ServiceGallery._cls3._cls2 extends AsyncTask
        {

            final ServiceGallery._cls3 this$1;

            protected volatile transient Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                Myutils.copyfile(ServiceGallery.access$6(this$0), ServiceGallery.access$4(this$0), Boolean.valueOf(false));
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
                void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ServiceGallery.access$5(this$0)).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                void1.addFlags(0x10000000);
                startActivity(void1);
            }

                    
                    {
                        this$1 = ServiceGallery._cls3.this;
                        super();
                    }
        }

    }

}
