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
//            ServiceUpdate

class this._cls0
    implements android.view.ener
{

    final ServiceUpdate this$0;

    public void onClick(View view)
    {
        switch (view.getId())
        {
        case 2131166057: 
        case 2131166058: 
        default:
            return;

        case 2131166056: 
            ServiceUpdate.access$21(ServiceUpdate.this).dismiss();
            return;

        case 2131166059: 
            MobclickAgent.onEvent(getApplicationContext(), "simulate_call_click");
            break;
        }
        if (!ServiceUpdate.access$52(ServiceUpdate.this).exists() || getFileSizes(ServiceUpdate.access$52(ServiceUpdate.this)) < 0x4e87bdL) goto _L2; else goto _L1
_L1:
        view = new Intent("android.intent.action.VIEW");
        view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ServiceUpdate.access$52(ServiceUpdate.this)).toString()), "application/vnd.android.package-archive");
        view.addFlags(0x10000000);
        getApplicationContext().startActivity(view);
_L4:
        ServiceUpdate.access$21(ServiceUpdate.this).dismiss();
        return;
_L2:
        if (ServiceUpdate.access$53(ServiceUpdate.this).exists() && getFileSizes(ServiceUpdate.access$53(ServiceUpdate.this)) >= 0x4e87bdL)
        {
            (new AsyncTask() {

                final ServiceUpdate._cls5 this$1;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    Myutils.copyfile(ServiceUpdate.access$53(this$0), ServiceUpdate.access$52(this$0), Boolean.valueOf(false));
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
                    void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ServiceUpdate.access$52(this$0)).toString()), "application/vnd.android.package-archive");
                    void1.addFlags(0x10000000);
                    getApplicationContext().startActivity(void1);
                }

            
            {
                this$1 = ServiceUpdate._cls5.this;
                super();
            }
            }).execute(new Void[0]);
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
            view.putExtra("myid", "com.allinone.callerid");
            view.addFlags(0x10000000);
            getApplicationContext().startActivity(view);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }


    _cls1.this._cls1()
    {
        this$0 = ServiceUpdate.this;
        super();
    }
}
