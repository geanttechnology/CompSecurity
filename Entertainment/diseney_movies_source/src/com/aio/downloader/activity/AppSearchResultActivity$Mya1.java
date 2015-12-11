// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.AsyncTask;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import java.net.URLEncoder;

// Referenced classes of package com.aio.downloader.activity:
//            AppSearchResultActivity

class this._cls0 extends AsyncTask
{

    final AppSearchResultActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        try
        {
            AppSearchResultActivity.access$9(AppSearchResultActivity.this, URLEncoder.encode(AppSearchResultActivity.access$8(AppSearchResultActivity.this)));
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[]) { }
        return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more.php?keyword=")).append(AppSearchResultActivity.access$8(AppSearchResultActivity.this)).append("&page=").append(AppSearchResultActivity.access$10(AppSearchResultActivity.this)).toString());
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
            AppSearchResultActivity.access$11(AppSearchResultActivity.this, s);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        AppSearchResultActivity.access$0(AppSearchResultActivity.this).setVisibility(0);
    }

    ()
    {
        this$0 = AppSearchResultActivity.this;
        super();
    }
}
