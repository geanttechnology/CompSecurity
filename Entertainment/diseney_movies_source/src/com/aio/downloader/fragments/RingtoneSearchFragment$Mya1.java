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
//            RingtoneSearchFragment

class this._cls0 extends AsyncTask
{

    final RingtoneSearchFragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        avoid = (new StringBuilder("http://54.241.35.253/testamz2/?p=ringtones-7-0-")).append(RingtoneSearchFragment.access$7(RingtoneSearchFragment.this)).append("&search=");
        Myutils.getInstance();
        avoid = publicTools.getUrl(avoid.append(Myutils.searchkeywords).append("&sec=4").toString());
        HashMap hashmap = new HashMap();
        hashmap.put("content", avoid);
        return publicTools.doHttpPost("http://android.downloadatoz.com/_201409/market/ringtone_list_more_parser.php?", hashmap);
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
            RingtoneSearchFragment.access$8(RingtoneSearchFragment.this, s);
            ((RelativeLayout)RingtoneSearchFragment.access$6(RingtoneSearchFragment.this).findViewById(0x7f0701db)).setVisibility(0);
            RingtoneSearchFragment.access$6(RingtoneSearchFragment.this).setVisibility(0);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        RingtoneSearchFragment.access$0(RingtoneSearchFragment.this).setVisibility(0);
    }

    ()
    {
        this$0 = RingtoneSearchFragment.this;
        super();
    }
}
