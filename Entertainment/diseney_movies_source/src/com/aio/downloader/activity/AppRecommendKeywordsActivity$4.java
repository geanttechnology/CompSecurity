// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.view.View;

// Referenced classes of package com.aio.downloader.activity:
//            AppRecommendKeywordsActivity

class this._cls0
    implements android.view.ordsActivity._cls4
{

    final AppRecommendKeywordsActivity this$0;

    public void onClick(View view)
    {
        if (AppRecommendKeywordsActivity.access$21(AppRecommendKeywordsActivity.this) == 5)
        {
            AppRecommendKeywordsActivity.access$22(AppRecommendKeywordsActivity.this, 0);
        }
        AppRecommendKeywordsActivity.search1 = AppRecommendKeywordsActivity.access$21(AppRecommendKeywordsActivity.this) * 10;
        (new adingSearchKeywords(AppRecommendKeywordsActivity.this)).execute(new Void[0]);
        view = AppRecommendKeywordsActivity.this;
        AppRecommendKeywordsActivity.access$22(view, AppRecommendKeywordsActivity.access$21(view) + 1);
    }

    adingSearchKeywords()
    {
        this$0 = AppRecommendKeywordsActivity.this;
        super();
    }
}
