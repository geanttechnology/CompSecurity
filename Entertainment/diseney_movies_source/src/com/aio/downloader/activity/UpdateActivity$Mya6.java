// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.aio.downloader.adapter.UndateAdapter;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.ProgressWheel;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.activity:
//            UpdateActivity

class this._cls0 extends AsyncTask
{

    final UpdateActivity this$0;
    private String url1;

    private void ShowResult7(String s)
    {
        UpdateActivity.access$0(UpdateActivity.this).setVisibility(8);
        list_update.addAll(Myutils.parseupdata(s));
        if (Myutils.status == 1)
        {
            Log.e("update", (new StringBuilder(String.valueOf(list_update.size()))).toString());
            s = new UndateAdapter(getApplicationContext(), list_update);
            UpdateActivity.access$2(UpdateActivity.this).setAdapter(s);
            return;
        } else
        {
            UpdateActivity.access$3(UpdateActivity.this).setVisibility(0);
            UpdateActivity.access$4(UpdateActivity.this).setImageResource(0x7f040006);
            UpdateActivity.access$5(UpdateActivity.this, (AnimationDrawable)UpdateActivity.access$4(UpdateActivity.this).getDrawable());
            UpdateActivity.access$6(UpdateActivity.this).start();
            return;
        }
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        Log.e("update", (new StringBuilder(String.valueOf(UpdateActivity.access$1(UpdateActivity.this)))).append("===").toString());
        return UpdateActivity.access$1(UpdateActivity.this);
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
            Log.e("update", (new StringBuilder("result=")).append(s).toString());
            ShowResult7(s);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        UpdateActivity.access$0(UpdateActivity.this).setVisibility(0);
    }

    ()
    {
        this$0 = UpdateActivity.this;
        super();
    }
}
