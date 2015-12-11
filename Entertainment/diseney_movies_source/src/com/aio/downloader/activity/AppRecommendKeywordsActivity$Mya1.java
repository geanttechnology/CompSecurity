// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.AsyncTask;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.aio.downloader.refresh.PullToRefreshLayout;
import com.aio.downloader.refresh.PullableListView_load;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import java.net.URLEncoder;

// Referenced classes of package com.aio.downloader.activity:
//            AppRecommendKeywordsActivity

class this._cls0 extends AsyncTask
{

    private String jsonData;
    final AppRecommendKeywordsActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        try
        {
            AppRecommendKeywordsActivity.access$15(AppRecommendKeywordsActivity.this, URLEncoder.encode(AppRecommendKeywordsActivity.access$14(AppRecommendKeywordsActivity.this)));
            jsonData = publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more.php?keyword=")).append(AppRecommendKeywordsActivity.access$14(AppRecommendKeywordsActivity.this)).append("&page=").append(AppRecommendKeywordsActivity.access$16(AppRecommendKeywordsActivity.this)).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[]) { }
        return jsonData;
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
        }
        try
        {
            AppRecommendKeywordsActivity.access$17(AppRecommendKeywordsActivity.this, s);
            ((RelativeLayout)AppRecommendKeywordsActivity.access$18(AppRecommendKeywordsActivity.this).findViewById(0x7f0701db)).setVisibility(0);
            AppRecommendKeywordsActivity.access$18(AppRecommendKeywordsActivity.this).setVisibility(0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        AppRecommendKeywordsActivity.access$4(AppRecommendKeywordsActivity.this).setVisibility(8);
        AppRecommendKeywordsActivity.access$9(AppRecommendKeywordsActivity.this).setVisibility(8);
        AppRecommendKeywordsActivity.access$12(AppRecommendKeywordsActivity.this).setVisibility(8);
        AppRecommendKeywordsActivity.access$13(AppRecommendKeywordsActivity.this).setVisibility(0);
        AppRecommendKeywordsActivity.access$0(AppRecommendKeywordsActivity.this).setVisibility(0);
    }

    ()
    {
        this$0 = AppRecommendKeywordsActivity.this;
        super();
    }
}
