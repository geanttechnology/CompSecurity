// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.views.BadgeView;
import java.io.File;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.aio.downloader.activity:
//            AppActivity1

class this._cls0 extends BroadcastReceiver
{

    final AppActivity1 this$0;

    public void onReceive(Context context, Intent intent)
    {
        try
        {
            AppActivity1.access$1(AppActivity1.this, new FinalDBChen(AppActivity1.this, getDatabasePath("download2.db").getAbsolutePath()));
            AppActivity1.access$3(AppActivity1.this, AppActivity1.access$2(AppActivity1.this).findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null));
            (new AsyncTask() {

                final AppActivity1._cls2 this$1;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient String doInBackground(Void avoid[])
                {
                    return String.valueOf(AppActivity1.access$4(this$0).size());
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((String)obj);
                }

                protected void onPostExecute(String s)
                {
                    super.onPostExecute(s);
                    AppActivity1.access$5(this$0).setVisibility(0);
                    AppActivity1.access$5(this$0).startAnimation(AppActivity1.access$6(this$0));
                    AppActivity1.access$7(this$0).setText(s);
                    AppActivity1.access$7(this$0).show();
                }

            
            {
                this$1 = AppActivity1._cls2.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }


    _cls1.this._cls1()
    {
        this$0 = AppActivity1.this;
        super();
    }
}
