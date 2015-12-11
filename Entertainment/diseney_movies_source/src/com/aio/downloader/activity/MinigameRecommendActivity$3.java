// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import com.aio.downloader.model.SearchkeywordModel;
import com.aio.downloader.views.DeletableEditText;
import java.util.List;

// Referenced classes of package com.aio.downloader.activity:
//            MinigameRecommendActivity, MinigamesSearchResultActivity

class this._cls0
    implements android.view.mendActivity._cls3
{

    final MinigameRecommendActivity this$0;

    public void onClick(View view)
    {
        if (!TextUtils.isEmpty(MinigameRecommendActivity.access$7(MinigameRecommendActivity.this).getText()))
        {
            MinigameRecommendActivity.access$8(MinigameRecommendActivity.this, MinigameRecommendActivity.access$7(MinigameRecommendActivity.this).getText().toString());
            view = new Intent(MinigameRecommendActivity.this, com/aio/downloader/activity/MinigamesSearchResultActivity);
            view.putExtra("searchkeywords", MinigameRecommendActivity.access$9(MinigameRecommendActivity.this));
            startActivity(view);
            return;
        } else
        {
            view = new Intent(MinigameRecommendActivity.this, com/aio/downloader/activity/MinigamesSearchResultActivity);
            view.putExtra("searchkeywords", ((SearchkeywordModel)MinigameRecommendActivity.access$2(MinigameRecommendActivity.this).get(0)).getKeyword());
            startActivity(view);
            return;
        }
    }

    y()
    {
        this$0 = MinigameRecommendActivity.this;
        super();
    }
}
