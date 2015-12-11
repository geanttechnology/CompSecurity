// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.AsyncTask;
import android.util.Log;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.fragments:
//            MusthaveFragment

class this._cls0 extends AsyncTask
{

    final MusthaveFragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        avoid = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_recommend.php?tab=must-have&page=")).append(MusthaveFragment.access$1(MusthaveFragment.this)).toString();
        Log.e("must", (new StringBuilder("url=")).append(avoid).toString());
        avoid = publicTools.getUrl(avoid);
        Log.e("must", (new StringBuilder("jsonData=")).append(avoid).toString());
        return avoid;
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
            MusthaveFragment.access$2(MusthaveFragment.this, s);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        MusthaveFragment.access$0(MusthaveFragment.this).setVisibility(0);
    }

    ()
    {
        this$0 = MusthaveFragment.this;
        super();
    }
}
