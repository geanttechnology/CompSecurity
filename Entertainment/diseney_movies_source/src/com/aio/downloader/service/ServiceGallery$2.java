// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import com.aio.downloader.activity.AppDetailsActivity;
import com.aio.downloader.dialog.GralleryDialog;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.publicTools;
import com.umeng.analytics.MobclickAgent;
import java.io.File;

// Referenced classes of package com.aio.downloader.service:
//            ServiceGallery

class this._cls0
    implements android.view.ner
{

    final ServiceGallery this$0;

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131165718: 
            ServiceGallery.access$1(ServiceGallery.this).dismiss();
            return;

        case 2131165719: 
            Log.e("qwer", "ll_gallery_onclick");
            break;
        }
        (new Thread() {

            final ServiceGallery._cls2 this$1;

            public void run()
            {
                super.run();
                publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=gallery_click");
            }

            
            {
                this$1 = ServiceGallery._cls2.this;
                super();
            }
        }).start();
        MobclickAgent.onEvent(getApplicationContext(), "gallery_click");
        ServiceGallery.access$1(ServiceGallery.this).dismiss();
        try
        {
            if (ServiceGallery.access$2(ServiceGallery.this).exists() && getFileSizes(ServiceGallery.access$2(ServiceGallery.this)) >= 0x1bff04L)
            {
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ServiceGallery.access$2(ServiceGallery.this)).toString()), "application/vnd.android.package-archive");
                view.addFlags(0x10000000);
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
        if (ServiceGallery.access$3(ServiceGallery.this).exists() && getFileSizes(ServiceGallery.access$3(ServiceGallery.this)) >= 0x1bff04L)
        {
            (new AsyncTask() {

                final ServiceGallery._cls2 this$1;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    Myutils.copyfile(ServiceGallery.access$3(this$0), ServiceGallery.access$2(this$0), Boolean.valueOf(false));
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
                    void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ServiceGallery.access$2(this$0)).toString()), "application/vnd.android.package-archive");
                    void1.addFlags(0x10000000);
                    startActivity(void1);
                }

            
            {
                this$1 = ServiceGallery._cls2.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
        view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
        view.putExtra("myid", "com.androidapp.gallary3d");
        view.addFlags(0x10000000);
        startActivity(view);
        return;
    }


    _cls2.this._cls1()
    {
        this$0 = ServiceGallery.this;
        super();
    }
}
