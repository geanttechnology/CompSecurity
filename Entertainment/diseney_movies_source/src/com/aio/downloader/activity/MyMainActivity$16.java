// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.AsyncTask;
import android.util.Log;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.publicTools;
import org.json.JSONObject;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity

class this._cls0 extends AsyncTask
{

    private DownloadMovieItem model_aio;
    final MyMainActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        avoid = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_detail_more.php?url_id=")).append(MyMainActivity.access$78(MyMainActivity.this)).toString();
        Log.e("goo", (new StringBuilder("url=")).append(avoid).toString());
        avoid = publicTools.getUrl(avoid);
        if (avoid != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if ((avoid = new JSONObject(avoid)).getInt("status") != 1) goto _L1; else goto _L3
_L3:
        model_aio = new DownloadMovieItem();
        avoid = avoid.getJSONObject("pdt");
        model_aio.setTitle(avoid.getString("title"));
        model_aio.setAuthor_title(avoid.getString("author_title"));
        model_aio.setIcon(avoid.getString("icon"));
        model_aio.setVersion(avoid.getString("version"));
        model_aio.setSerial(avoid.getInt("serial"));
        return null;
        avoid;
        avoid.printStackTrace();
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        try
        {
            MydownloadApk6(MyMainActivity.access$78(MyMainActivity.this), model_aio.getTitle(), model_aio.getIcon(), model_aio.getSerial());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
    }

    m()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
