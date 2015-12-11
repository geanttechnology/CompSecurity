// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import com.aio.downloader.activity.AppDetailsActivity;
import com.aio.downloader.dialog.CallerOutDialog1;
import com.aio.downloader.utils.Myutils;
import com.umeng.analytics.MobclickAgent;
import java.io.File;

// Referenced classes of package com.aio.downloader.service:
//            PhoneStateReceiver

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
        Myutils.copyfile(PhoneStateReceiver.access$2(_fld0), PhoneStateReceiver.access$1(_fld0), Boolean.valueOf(false));
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
        void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PhoneStateReceiver.access$1(_fld0)).toString()), "application/vnd.android.package-archive");
        void1.addFlags(0x10000000);
        val$context.startActivity(void1);
    }

    l.context()
    {
        this$1 = final_context1;
        val$context = Context.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/service/PhoneStateReceiver$3

/* anonymous class */
    class PhoneStateReceiver._cls3
        implements android.view.View.OnClickListener
    {

        final PhoneStateReceiver this$0;
        private final Context val$context;

        public void onClick(View view)
        {
            switch (view.getId())
            {
            case 2131166057: 
            case 2131166058: 
            default:
                return;

            case 2131166056: 
                PhoneStateReceiver.access$3(PhoneStateReceiver.this).dismiss();
                return;

            case 2131166059: 
                MobclickAgent.onEvent(context, "simulate_call_click");
                break;
            }
            if (!PhoneStateReceiver.access$1(PhoneStateReceiver.this).exists() || getFileSizes(PhoneStateReceiver.access$1(PhoneStateReceiver.this)) < 0x4e87bdL) goto _L2; else goto _L1
_L1:
            view = new Intent("android.intent.action.VIEW");
            view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PhoneStateReceiver.access$1(PhoneStateReceiver.this)).toString()), "application/vnd.android.package-archive");
            view.addFlags(0x10000000);
            context.startActivity(view);
_L4:
            PhoneStateReceiver.access$3(PhoneStateReceiver.this).dismiss();
            return;
_L2:
            if (PhoneStateReceiver.access$2(PhoneStateReceiver.this).exists() && getFileSizes(PhoneStateReceiver.access$2(PhoneStateReceiver.this)) >= 0x4e87bdL)
            {
                (context. new PhoneStateReceiver._cls3._cls1()).execute(new Void[0]);
                continue; /* Loop/switch isn't completed */
            }
            try
            {
                view = new Intent(context, com/aio/downloader/activity/AppDetailsActivity);
                view.putExtra("myid", "com.allinone.callerid");
                view.addFlags(0x10000000);
                context.startActivity(view);
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view.printStackTrace();
            }
            if (true) goto _L4; else goto _L3
_L3:
        }


            
            {
                this$0 = final_phonestatereceiver;
                context = Context.this;
                super();
            }
    }

}
