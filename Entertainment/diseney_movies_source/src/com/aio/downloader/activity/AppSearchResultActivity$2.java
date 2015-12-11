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
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.views.BadgeView;
import java.io.File;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.aio.downloader.activity:
//            AppSearchResultActivity

class this._cls0 extends BroadcastReceiver
{

    final AppSearchResultActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        AppSearchResultActivity.access$0(AppSearchResultActivity.this).setVisibility(8);
        try
        {
            AppSearchResultActivity.access$1(AppSearchResultActivity.this, new FinalDBChen(AppSearchResultActivity.this, getDatabasePath("download2.db").getAbsolutePath()));
            AppSearchResultActivity.access$3(AppSearchResultActivity.this, AppSearchResultActivity.access$2(AppSearchResultActivity.this).findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null));
            (new AsyncTask() {

                final AppSearchResultActivity._cls2 this$1;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient String doInBackground(Void avoid[])
                {
                    return String.valueOf(AppSearchResultActivity.access$4(this$0).size());
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((String)obj);
                }

                protected void onPostExecute(String s)
                {
                    super.onPostExecute(s);
                    AppSearchResultActivity.access$5(this$0).setVisibility(0);
                    AppSearchResultActivity.access$5(this$0).startAnimation(AppSearchResultActivity.access$6(this$0));
                    AppSearchResultActivity.access$7(this$0).setText(s);
                    AppSearchResultActivity.access$7(this$0).show();
                }

            
            {
                this$1 = AppSearchResultActivity._cls2.this;
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
        this$0 = AppSearchResultActivity.this;
        super();
    }
}
