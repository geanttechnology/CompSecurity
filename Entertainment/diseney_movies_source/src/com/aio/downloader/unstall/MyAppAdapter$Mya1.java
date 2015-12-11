// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.unstall;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.publicTools;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import org.json.JSONObject;

// Referenced classes of package com.aio.downloader.unstall:
//            MyAppAdapter

class this._cls0 extends AsyncTask
{

    final MyAppAdapter this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient ArrayList doInBackground(Void avoid[])
    {
        avoid = publicTools.getUrl(MyAppAdapter.access$0(MyAppAdapter.this));
        Log.e("gak", (new StringBuilder(String.valueOf(MyAppAdapter.access$0(MyAppAdapter.this)))).append("=====================jsonData=").append(avoid).toString());
        if (avoid != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        MyAppAdapter.access$1(MyAppAdapter.this, new ArrayList());
        avoid = new JSONObject(avoid);
        if (avoid.getInt("status") != 1) goto _L1; else goto _L3
_L3:
        MyAppAdapter.access$2(MyAppAdapter.this, new DownloadMovieItem());
        avoid = avoid.getJSONObject("pdt");
        MyAppAdapter.access$3(MyAppAdapter.this).setId(avoid.getString("id"));
        MyAppAdapter.access$3(MyAppAdapter.this).setSerial(avoid.getInt("serial"));
_L5:
        return MyAppAdapter.access$4(MyAppAdapter.this);
        avoid;
        avoid.printStackTrace();
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ArrayList)obj);
    }

    protected void onPostExecute(ArrayList arraylist)
    {
        super.onPostExecute(arraylist);
        MobclickAgent.onEvent(MyAppAdapter.access$5(MyAppAdapter.this), "share");
        if (arraylist != null)
        {
            arraylist = (new StringBuilder("Share: http://android.downloadatoz.com/apps/")).append(MyAppAdapter.access$3(MyAppAdapter.this).getId()).append(",").append(MyAppAdapter.access$3(MyAppAdapter.this).getSerial()).append(".html").toString();
            Log.e("location", arraylist);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", arraylist);
            MyAppAdapter.access$5(MyAppAdapter.this).startActivity(Intent.createChooser(intent, "AIO Downloaded").addFlags(0x10000000));
            return;
        } else
        {
            arraylist = (new StringBuilder("Share: http://android.downloadatoz.com/search.php?q=")).append(MyAppAdapter.access$6(MyAppAdapter.this)).toString();
            Log.e("location", arraylist);
            Intent intent1 = new Intent("android.intent.action.SEND");
            intent1.setType("text/plain");
            intent1.putExtra("android.intent.extra.TEXT", arraylist);
            MyAppAdapter.access$5(MyAppAdapter.this).startActivity(Intent.createChooser(intent1, "AIO Downloaded"));
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    em()
    {
        this$0 = MyAppAdapter.this;
        super();
    }
}
