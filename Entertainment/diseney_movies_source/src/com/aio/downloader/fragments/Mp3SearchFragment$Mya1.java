// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.AsyncTask;
import android.widget.RelativeLayout;
import com.aio.downloader.refresh.PullableListView;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import java.util.HashMap;

// Referenced classes of package com.aio.downloader.fragments:
//            Mp3SearchFragment

class this._cls0 extends AsyncTask
{

    final Mp3SearchFragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        avoid = new StringBuilder("http://mp3box.to/search?q=");
        Myutils.getInstance();
        avoid = publicTools.getUrl(avoid.append(Myutils.searchkeywords).append("&page=").append(Mp3SearchFragment.access$7(Mp3SearchFragment.this)).toString());
        HashMap hashmap = new HashMap();
        hashmap.put("content", avoid);
        return publicTools.doHttpPost("http://android.downloadatoz.com/_201409/market/mp3_list_more_parser.php", hashmap);
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
            Mp3SearchFragment.access$8(Mp3SearchFragment.this, s);
            ((RelativeLayout)Mp3SearchFragment.access$6(Mp3SearchFragment.this).findViewById(0x7f0701db)).setVisibility(0);
            Mp3SearchFragment.access$6(Mp3SearchFragment.this).setVisibility(0);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        Mp3SearchFragment.access$0(Mp3SearchFragment.this).setVisibility(0);
    }

    _cls9()
    {
        this$0 = Mp3SearchFragment.this;
        super();
    }
}
