// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.AsyncTask;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.aio.downloader.adapter.ApprecommendkeywordAdapter;
import com.aio.downloader.model.SearchkeywordModel;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import com.aio.downloader.views.DeletableEditText;
import java.util.ArrayList;
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
        AppRecommendKeywordsActivity.access$6(AppRecommendKeywordsActivity.this, new ArrayList());
        if (publicTools.isNetworkAvailable(AppRecommendKeywordsActivity.this))
        {
            return publicTools.getUrl("http://android.downloadatoz.com/_201409/market/top_keywords.php");
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
        if (s != null)
        {
            try
            {
                AppRecommendKeywordsActivity.access$7(AppRecommendKeywordsActivity.this).addAll(Myutils.parseSearchKeywords(s));
                AppRecommendKeywordsActivity.access$8(AppRecommendKeywordsActivity.this, new ApprecommendkeywordAdapter(getApplicationContext(), AppRecommendKeywordsActivity.access$7(AppRecommendKeywordsActivity.this)));
                AppRecommendKeywordsActivity.access$9(AppRecommendKeywordsActivity.this).setAdapter(AppRecommendKeywordsActivity.access$10(AppRecommendKeywordsActivity.this));
                AppRecommendKeywordsActivity.access$10(AppRecommendKeywordsActivity.this).notifyDataSetChanged();
                AppRecommendKeywordsActivity.access$0(AppRecommendKeywordsActivity.this).setVisibility(8);
                if (AppRecommendKeywordsActivity.access$11(AppRecommendKeywordsActivity.this) == 0)
                {
                    AppRecommendKeywordsActivity.access$1(AppRecommendKeywordsActivity.this).setHint(((SearchkeywordModel)AppRecommendKeywordsActivity.access$7(AppRecommendKeywordsActivity.this).get(0)).getKeyword());
                    AppRecommendKeywordsActivity.access$4(AppRecommendKeywordsActivity.this).setVisibility(8);
                    AppRecommendKeywordsActivity.access$9(AppRecommendKeywordsActivity.this).setVisibility(0);
                    AppRecommendKeywordsActivity.access$12(AppRecommendKeywordsActivity.this).setVisibility(0);
                    Myutils.getInstance();
                    Myutils.hint = ((SearchkeywordModel)AppRecommendKeywordsActivity.access$7(AppRecommendKeywordsActivity.this).get(0)).getKeyword();
                    Myutils.getInstance();
                    Myutils.hintid = ((SearchkeywordModel)AppRecommendKeywordsActivity.access$7(AppRecommendKeywordsActivity.this).get(0)).getId();
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return;
            }
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        AppRecommendKeywordsActivity.access$0(AppRecommendKeywordsActivity.this).setVisibility(0);
    }

    ()
    {
        this$0 = AppRecommendKeywordsActivity.this;
        super();
    }
}
