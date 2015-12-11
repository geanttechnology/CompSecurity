// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.AsyncTask;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.fragments:
//            AppFeaturedFragment

class this._cls0 extends AsyncTask
{

    final AppFeaturedFragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        return publicTools.getUrl("http://welaf.com/fun/list.php?tab=random&page=1");
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
            AppFeaturedFragment.access$3(AppFeaturedFragment.this, s);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        AppFeaturedFragment.access$0(AppFeaturedFragment.this).setVisibility(0);
    }

    ()
    {
        this$0 = AppFeaturedFragment.this;
        super();
    }
}
