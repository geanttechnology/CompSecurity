// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import com.aio.downloader.model.SearchkeywordModel;
import com.aio.downloader.refresh.PullableListView_load;
import com.aio.downloader.views.DeletableEditText;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.aio.downloader.activity:
//            AppRecommendKeywordsActivity

class this._cls0
    implements android.widget.
{

    final AppRecommendKeywordsActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        try
        {
            AppRecommendKeywordsActivity.access$20(AppRecommendKeywordsActivity.this).clear();
        }
        // Misplaced declaration of an exception variable
        catch (AdapterView adapterview) { }
        try
        {
            ((InputMethodManager)AppRecommendKeywordsActivity.access$1(AppRecommendKeywordsActivity.this).getContext().getSystemService("input_method")).hideSoftInputFromWindow(AppRecommendKeywordsActivity.access$1(AppRecommendKeywordsActivity.this).getWindowToken(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (AdapterView adapterview) { }
        AppRecommendKeywordsActivity.access$15(AppRecommendKeywordsActivity.this, ((SearchkeywordModel)AppRecommendKeywordsActivity.access$7(AppRecommendKeywordsActivity.this).get(i)).getKeyword());
        AppRecommendKeywordsActivity.access$1(AppRecommendKeywordsActivity.this).setText(AppRecommendKeywordsActivity.access$14(AppRecommendKeywordsActivity.this).toString());
        Log.e("qwa", (new StringBuilder("appkeywords=")).append(AppRecommendKeywordsActivity.access$14(AppRecommendKeywordsActivity.this)).toString());
        ((RelativeLayout)AppRecommendKeywordsActivity.access$18(AppRecommendKeywordsActivity.this).findViewById(0x7f0701db)).setVisibility(8);
        (new a1(AppRecommendKeywordsActivity.this)).execute(new Void[0]);
    }

    a1()
    {
        this$0 = AppRecommendKeywordsActivity.this;
        super();
    }
}
