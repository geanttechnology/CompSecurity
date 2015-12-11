// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.AsyncTask;
import android.widget.GridView;
import com.aio.downloader.adapter.ApprecommendkeywordAdapter;
import com.aio.downloader.model.SearchkeywordModel;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import com.aio.downloader.views.DeletableEditText;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.aio.downloader.activity:
//            MinigameRecommendActivity

class this._cls0 extends AsyncTask
{

    final MinigameRecommendActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        MinigameRecommendActivity.access$1(MinigameRecommendActivity.this, new ArrayList());
        return publicTools.getUrl("http://android.downloadatoz.com/_201409/market/minigame_search_recommend_list.php");
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
            MinigameRecommendActivity.access$2(MinigameRecommendActivity.this).addAll(Myutils.parseminikeywords(s));
            MinigameRecommendActivity.access$3(MinigameRecommendActivity.this, new ApprecommendkeywordAdapter(getApplicationContext(), MinigameRecommendActivity.access$2(MinigameRecommendActivity.this)));
            MinigameRecommendActivity.access$4(MinigameRecommendActivity.this).setAdapter(MinigameRecommendActivity.access$5(MinigameRecommendActivity.this));
            MinigameRecommendActivity.access$5(MinigameRecommendActivity.this).notifyDataSetChanged();
            MinigameRecommendActivity.access$6(MinigameRecommendActivity.this).setVisibility(8);
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        MinigameRecommendActivity.access$7(MinigameRecommendActivity.this).setHint(((SearchkeywordModel)MinigameRecommendActivity.access$2(MinigameRecommendActivity.this).get(0)).getKeyword());
        MinigameRecommendActivity.access$0(MinigameRecommendActivity.this).setVisibility(8);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        MinigameRecommendActivity.access$0(MinigameRecommendActivity.this).setVisibility(0);
    }

    ()
    {
        this$0 = MinigameRecommendActivity.this;
        super();
    }
}
