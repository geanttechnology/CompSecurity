// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.AsyncTask;
import android.text.Editable;
import android.widget.ListView;
import com.aio.downloader.adapter.AppsearchpromitAdapter;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.publicTools;
import com.aio.downloader.views.DeletableEditText;
import java.net.URLEncoder;
import java.util.List;

// Referenced classes of package com.aio.downloader.activity:
//            AppRecommendKeywordsActivity

class this._cls0 extends AsyncTask
{

    final AppRecommendKeywordsActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        if (publicTools.isNetworkAvailable(AppRecommendKeywordsActivity.this))
        {
            return publicTools.getUrl((new StringBuilder("https://market.android.com/suggest/SuggRequest?json=1&c=0&query=")).append(URLEncoder.encode(AppRecommendKeywordsActivity.access$1(AppRecommendKeywordsActivity.this).getText().toString())).append("&hl=en").toString());
        } else
        {
            return null;
        }
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
            AppRecommendKeywordsActivity.access$2(AppRecommendKeywordsActivity.this).clear();
            AppRecommendKeywordsActivity.access$2(AppRecommendKeywordsActivity.this).addAll(Myutils.parsearchpromitlist(s));
            AppRecommendKeywordsActivity.access$3(AppRecommendKeywordsActivity.this, new AppsearchpromitAdapter(getApplicationContext(), AppRecommendKeywordsActivity.access$2(AppRecommendKeywordsActivity.this)));
            AppRecommendKeywordsActivity.access$4(AppRecommendKeywordsActivity.this).setAdapter(AppRecommendKeywordsActivity.access$5(AppRecommendKeywordsActivity.this));
            AppRecommendKeywordsActivity.access$5(AppRecommendKeywordsActivity.this).notifyDataSetChanged();
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    ()
    {
        this$0 = AppRecommendKeywordsActivity.this;
        super();
    }
}
