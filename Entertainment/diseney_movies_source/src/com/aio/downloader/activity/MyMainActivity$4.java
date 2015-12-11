// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.views.BadgeView;
import java.io.File;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity

class this._cls0 extends BroadcastReceiver
{

    final MyMainActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        try
        {
            MyMainActivity.access$7(MyMainActivity.this, new FinalDBChen(MyMainActivity.this, getDatabasePath("download2.db").getAbsolutePath()));
            MyMainActivity.access$9(MyMainActivity.this, MyMainActivity.access$8(MyMainActivity.this).findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null));
            (new AsyncTask() {

                final MyMainActivity._cls4 this$1;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient String doInBackground(Void avoid[])
                {
                    return String.valueOf(MyMainActivity.access$10(this$0).size());
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((String)obj);
                }

                protected void onPostExecute(String s)
                {
                    super.onPostExecute(s);
                    MyMainActivity.access$11(this$0).setText(s);
                    MyMainActivity.access$11(this$0).show();
                    MyMainActivity.access$12(this$0).setText(String.valueOf(s));
                    MyMainActivity.access$12(this$0).show();
                }

            
            {
                this$1 = MyMainActivity._cls4.this;
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
        this$0 = MyMainActivity.this;
        super();
    }
}
