// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import com.aio.downloader.model.GameInfosVersionModel;
import com.aio.downloader.utils.Myutils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

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
        Object obj;
        Thread.sleep(1000L);
        obj = (HttpURLConnection)(new URL((new StringBuilder("http://app.loveitsomuch.com/gonglue_xilie/ping.php?id=")).append(Myutils.packagename2).append("&version=").append("3.3.9").toString())).openConnection();
        ((HttpURLConnection) (obj)).setConnectTimeout(5000);
        ((HttpURLConnection) (obj)).setRequestMethod("GET");
        Log.v("ggg", (new StringBuilder(String.valueOf(((HttpURLConnection) (obj)).getResponseCode()))).toString());
        if (((HttpURLConnection) (obj)).getResponseCode() != 200)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        avoid = new StringBuffer();
        obj = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj)).getInputStream()));
_L1:
        String s = ((BufferedReader) (obj)).readLine();
        if (s == null)
        {
            try
            {
                avoid = new JSONObject(avoid.toString());
                if (avoid.getInt("status") == 1)
                {
                    GameInfosVersionModel gameinfosversionmodel = new GameInfosVersionModel();
                    gameinfosversionmodel.setUpdatePath(avoid.getString("update_url"));
                    handler.sendMessage(handler.obtainMessage(564, gameinfosversionmodel));
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
            }
            break MISSING_BLOCK_LABEL_212;
        }
        avoid.append(s);
          goto _L1
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
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        mProgressDialog = ProgressDialog.show(MySettingsActivity.this, null, "Loading......");
    }

    ()
    {
        this$0 = MySettingsActivity.this;
        super();
    }
}
