// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;
import com.aio.downloader.utils.Myutils;

// Referenced classes of package com.aio.downloader.activity:
//            MySettingsActivity

class this._cls0 extends AsyncTask
{

    private ProgressDialog mProgressDialog;
    final MySettingsActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        delFolder((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(Myutils.packagename).append("/").append("webcache").toString());
        Log.v("hjhj", (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(Myutils.packagename).append("/").append("webcache").toString());
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        if (mProgressDialog != null && mProgressDialog.isShowing())
        {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
        Toast.makeText(getApplicationContext(), "done", 1).show();
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        mProgressDialog = ProgressDialog.show(MySettingsActivity.this, null, getString(0x7f0b003e));
    }

    ()
    {
        this$0 = MySettingsActivity.this;
        super();
    }
}
