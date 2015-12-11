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
import com.aio.downloader.dialog.ChangeDialog;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.publicTools;
import com.umeng.analytics.MobclickAgent;
import java.io.File;

// Referenced classes of package com.aio.downloader.service:
//            BatteryChanageReceiver

class val.arg0
    implements android.view.ageReceiver._cls2
{

    final BatteryChanageReceiver this$0;
    private final Context val$arg0;

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131165496 2131165497: default 28
    //                   2131165496 326
    //                   2131165497 29;
           goto _L1 _L2 _L3
_L1:
        return;
_L3:
        MobclickAgent.onEvent(val$arg0, "batterychange_click");
        (new Thread() {

            final BatteryChanageReceiver._cls2 this$1;

            public void run()
            {
                super.run();
                publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=battery_charging_click");
            }

            
            {
                this$1 = BatteryChanageReceiver._cls2.this;
                super();
            }
        }).start();
        view = null;
        android.content.pm.PackageInfo packageinfo;
        try
        {
            packageinfo = val$arg0.getPackageManager().getPackageInfo("com.aioapp.battery", 0);
        }
        catch (android.content.pm.ndException ndexception)
        {
            ndexception.printStackTrace();
            continue; /* Loop/switch isn't completed */
        }
        view = packageinfo;
_L12:
        if (view != null) goto _L5; else goto _L4
_L4:
        if (!BatteryChanageReceiver.access$0(BatteryChanageReceiver.this).exists() || getFileSizes(BatteryChanageReceiver.access$0(BatteryChanageReceiver.this)) < 0x377effL) goto _L7; else goto _L6
_L6:
        view = new Intent("android.intent.action.VIEW");
        view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(BatteryChanageReceiver.access$0(BatteryChanageReceiver.this)).toString()), "application/vnd.android.package-archive");
        view.addFlags(0x10000000);
        val$arg0.startActivity(view);
_L10:
        BatteryChanageReceiver.access$2(BatteryChanageReceiver.this).dismiss();
        return;
_L7:
        if (!BatteryChanageReceiver.access$1(BatteryChanageReceiver.this).exists() || getFileSizes(BatteryChanageReceiver.access$1(BatteryChanageReceiver.this)) < 0x377effL) goto _L9; else goto _L8
_L8:
        (new AsyncTask() {

            final BatteryChanageReceiver._cls2 this$1;
            private final Context val$arg0;

            protected volatile transient Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                Myutils.copyfile(BatteryChanageReceiver.access$1(this$0), BatteryChanageReceiver.access$0(this$0), Boolean.valueOf(false));
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
                void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(BatteryChanageReceiver.access$0(this$0)).toString()), "application/vnd.android.package-archive");
                void1.addFlags(0x10000000);
                arg0.startActivity(void1);
            }

            
            {
                this$1 = BatteryChanageReceiver._cls2.this;
                arg0 = context;
                super();
            }
        }).execute(new Void[0]);
          goto _L10
_L9:
        try
        {
            view = new Intent(val$arg0, com/aio/downloader/activity/AppDetailsActivity);
            view.putExtra("myid", "com.aioapp.battery");
            view.putExtra("xiazaidianchi", 1);
            view.addFlags(0x10000000);
            val$arg0.startActivity(view);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
          goto _L10
_L5:
        view = val$arg0.getPackageManager().getLaunchIntentForPackage("com.aioapp.battery");
        view.addFlags(0x10000000);
        val$arg0.startActivity(view);
          goto _L10
_L2:
        BatteryChanageReceiver.access$2(BatteryChanageReceiver.this).dismiss();
        return;
        if (true) goto _L12; else goto _L11
_L11:
    }


    _cls2.val.arg0()
    {
        this$0 = final_batterychanagereceiver;
        val$arg0 = Context.this;
        super();
    }
}
