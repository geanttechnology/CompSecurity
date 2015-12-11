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
import com.aio.downloader.dialog.CallerOutDialog;
import com.aio.downloader.utils.Myutils;
import com.umeng.analytics.MobclickAgent;
import java.io.File;

// Referenced classes of package com.aio.downloader.service:
//            PhoneStateReceiver

class val.context
    implements android.view.ateReceiver._cls1
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
            PhoneStateReceiver.access$0(PhoneStateReceiver.this).dismiss();
            return;

        case 2131166059: 
            MobclickAgent.onEvent(val$context, "call_state_ringing_click");
            break;
        }
        if (!PhoneStateReceiver.access$1(PhoneStateReceiver.this).exists() || getFileSizes(PhoneStateReceiver.access$1(PhoneStateReceiver.this)) < 0x4e87bdL) goto _L2; else goto _L1
_L1:
        view = new Intent("android.intent.action.VIEW");
        view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PhoneStateReceiver.access$1(PhoneStateReceiver.this)).toString()), "application/vnd.android.package-archive");
        view.addFlags(0x10000000);
        val$context.startActivity(view);
_L4:
        PhoneStateReceiver.access$0(PhoneStateReceiver.this).dismiss();
        return;
_L2:
        if (PhoneStateReceiver.access$2(PhoneStateReceiver.this).exists() && getFileSizes(PhoneStateReceiver.access$2(PhoneStateReceiver.this)) >= 0x4e87bdL)
        {
            (new AsyncTask() {

                final PhoneStateReceiver._cls1 this$1;
                private final Context val$context;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    Myutils.copyfile(PhoneStateReceiver.access$2(this$0), PhoneStateReceiver.access$1(this$0), Boolean.valueOf(false));
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
                    void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PhoneStateReceiver.access$1(this$0)).toString()), "application/vnd.android.package-archive");
                    void1.addFlags(0x10000000);
                    context.startActivity(void1);
                }

            
            {
                this$1 = PhoneStateReceiver._cls1.this;
                context = context1;
                super();
            }
            }).execute(new Void[0]);
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            view = new Intent(val$context, com/aio/downloader/activity/AppDetailsActivity);
            view.putExtra("myid", "com.allinone.callerid");
            view.addFlags(0x10000000);
            val$context.startActivity(view);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }


    _cls1.val.context()
    {
        this$0 = final_phonestatereceiver;
        val$context = Context.this;
        super();
    }
}
