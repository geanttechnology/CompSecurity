// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import com.aio.downloader.utils.Myutils;
import com.umeng.analytics.MobclickAgent;
import java.io.File;

// Referenced classes of package com.aio.downloader.activity:
//            FunImagePagerActivity, AppDetailsActivity

class this._cls0
    implements android.view.agerActivity._cls3
{

    final FunImagePagerActivity this$0;

    public void onClick(View view)
    {
        Log.e("qwer", "fun_gallery");
        MobclickAgent.onEvent(getApplicationContext(), "fun_gallery");
        try
        {
            if (FunImagePagerActivity.access$12(FunImagePagerActivity.this).exists() && getFileSizes(FunImagePagerActivity.access$12(FunImagePagerActivity.this)) >= 0x1bff04L)
            {
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(FunImagePagerActivity.access$12(FunImagePagerActivity.this)).toString()), "application/vnd.android.package-archive");
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
        if (FunImagePagerActivity.access$13(FunImagePagerActivity.this).exists() && getFileSizes(FunImagePagerActivity.access$12(FunImagePagerActivity.this)) >= 0x1bff04L)
        {
            (new AsyncTask() {

                final FunImagePagerActivity._cls3 this$1;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    Myutils.copyfile(FunImagePagerActivity.access$13(this$0), FunImagePagerActivity.access$12(this$0), Boolean.valueOf(false));
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
                    void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(FunImagePagerActivity.access$12(this$0)).toString()), "application/vnd.android.package-archive");
                    void1.addFlags(0x10000000);
                    startActivity(void1);
                }

            
            {
                this$1 = FunImagePagerActivity._cls3.this;
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


    _cls1.this._cls1()
    {
        this$0 = FunImagePagerActivity.this;
        super();
    }
}
