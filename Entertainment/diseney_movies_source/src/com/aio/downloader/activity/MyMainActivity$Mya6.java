// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.MyAppInfo;
import com.aio.downloader.utils.Myutils;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity

class this._cls0 extends AsyncTask
{

    final MyMainActivity this$0;
    private String url1;

    private void ShowResult7(String s)
    {
        MyMainActivity.access$39(MyMainActivity.this).addAll(Myutils.parseupdata(s));
        if (Myutils.status == 1)
        {
            try
            {
                Log.e("llt", (new StringBuilder(String.valueOf(MyMainActivity.access$39(MyMainActivity.this).size()))).toString());
                MyMainActivity.access$40(MyMainActivity.this, (int)(Math.random() * (double)MyMainActivity.access$39(MyMainActivity.this).size()));
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            MyMainActivity.access$41(MyMainActivity.this).setVisibility(8);
            s = new MyAppInfo(getApplicationContext());
            try
            {
                MyMainActivity.access$43(MyMainActivity.this, s.getAppName(((DownloadMovieItem)MyMainActivity.access$39(MyMainActivity.this).get(MyMainActivity.access$42(MyMainActivity.this))).getId()));
                MyMainActivity.access$44(MyMainActivity.this, s.getAppVersion(((DownloadMovieItem)MyMainActivity.access$39(MyMainActivity.this).get(MyMainActivity.access$42(MyMainActivity.this))).getId()));
                MyMainActivity.access$45(MyMainActivity.this, s.getAppIcon(((DownloadMovieItem)MyMainActivity.access$39(MyMainActivity.this).get(MyMainActivity.access$42(MyMainActivity.this))).getId()));
                MyMainActivity.access$46(MyMainActivity.this).setBackgroundDrawable(MyMainActivity.access$47(MyMainActivity.this));
                MyMainActivity.access$48(MyMainActivity.this).setText(MyMainActivity.access$49(MyMainActivity.this));
                MyMainActivity.access$50(MyMainActivity.this).setText(MyMainActivity.access$51(MyMainActivity.this));
                MyMainActivity.access$52(MyMainActivity.this).setText(((DownloadMovieItem)MyMainActivity.access$39(MyMainActivity.this).get(MyMainActivity.access$42(MyMainActivity.this))).getVersion());
                MyMainActivity.access$53(MyMainActivity.this).setText(((DownloadMovieItem)MyMainActivity.access$39(MyMainActivity.this).get(MyMainActivity.access$42(MyMainActivity.this))).getSize());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            return;
        } else
        {
            MyMainActivity.access$41(MyMainActivity.this).setVisibility(8);
            return;
        }
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        Log.e("upJsonStr", (new StringBuilder(String.valueOf(MyMainActivity.access$38(MyMainActivity.this)))).append("===").toString());
        return MyMainActivity.access$38(MyMainActivity.this);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        if (s == null)
        {
            return;
        } else
        {
            Log.e("asd1", (new StringBuilder("result=")).append(s).toString());
            ShowResult7(s);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    ()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
