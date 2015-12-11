// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.AsyncTask;
import android.widget.RelativeLayout;
import com.aio.downloader.refresh.PullableListView;
import com.aio.downloader.utils.ASCIIutil;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import java.net.URLEncoder;

// Referenced classes of package com.aio.downloader.activity:
//            MinigamesSearchResultActivity

class this._cls0 extends AsyncTask
{

    final MinigamesSearchResultActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        MinigamesSearchResultActivity.access$2(MinigamesSearchResultActivity.this, URLEncoder.encode(MinigamesSearchResultActivity.access$1(MinigamesSearchResultActivity.this)));
        return ASCIIutil.toparse(publicTools.getUrl((new StringBuilder("http://app.loveitsomuch.com/game/h5/search.php?ucode=abc&version=1.0&keyword=")).append(MinigamesSearchResultActivity.access$1(MinigamesSearchResultActivity.this)).append("&page=").append(MinigamesSearchResultActivity.access$3(MinigamesSearchResultActivity.this)).toString()));
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
            MinigamesSearchResultActivity.access$4(MinigamesSearchResultActivity.this, s);
            ((RelativeLayout)MinigamesSearchResultActivity.access$5(MinigamesSearchResultActivity.this).findViewById(0x7f0701db)).setVisibility(0);
            MinigamesSearchResultActivity.access$5(MinigamesSearchResultActivity.this).setVisibility(0);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        MinigamesSearchResultActivity.access$0(MinigamesSearchResultActivity.this).setVisibility(0);
    }

    ()
    {
        this$0 = MinigamesSearchResultActivity.this;
        super();
    }
}
