// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import com.aio.downloader.model.SearchkeywordModel;
import com.aio.downloader.refresh.PullableListView_load;
import com.aio.downloader.views.DeletableEditText;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.aio.downloader.activity:
//            AppRecommendKeywordsActivity

class this._cls0
    implements android.view.ordsActivity._cls9
{

    final AppRecommendKeywordsActivity this$0;

    public void onClick(View view)
    {
        try
        {
            AppRecommendKeywordsActivity.access$20(AppRecommendKeywordsActivity.this).clear();
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
        try
        {
            ((InputMethodManager)AppRecommendKeywordsActivity.access$1(AppRecommendKeywordsActivity.this).getContext().getSystemService("input_method")).hideSoftInputFromWindow(AppRecommendKeywordsActivity.access$1(AppRecommendKeywordsActivity.this).getWindowToken(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
        if (!TextUtils.isEmpty(AppRecommendKeywordsActivity.access$1(AppRecommendKeywordsActivity.this).getText()))
        {
            break MISSING_BLOCK_LABEL_125;
        }
        AppRecommendKeywordsActivity.access$15(AppRecommendKeywordsActivity.this, ((SearchkeywordModel)AppRecommendKeywordsActivity.access$7(AppRecommendKeywordsActivity.this).get(0)).getKeyword());
_L1:
        ((RelativeLayout)AppRecommendKeywordsActivity.access$18(AppRecommendKeywordsActivity.this).findViewById(0x7f0701db)).setVisibility(8);
        (new a1(AppRecommendKeywordsActivity.this)).execute(new Void[0]);
        return;
        try
        {
            AppRecommendKeywordsActivity.access$15(AppRecommendKeywordsActivity.this, AppRecommendKeywordsActivity.access$1(AppRecommendKeywordsActivity.this).getText().toString());
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
          goto _L1
    }

    a1()
    {
        this$0 = AppRecommendKeywordsActivity.this;
        super();
    }
}
