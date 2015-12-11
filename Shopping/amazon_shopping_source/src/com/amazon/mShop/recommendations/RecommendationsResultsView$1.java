// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.recommendations;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.amazon.mShop.control.recommendations.RecommendationsBrowser;

// Referenced classes of package com.amazon.mShop.recommendations:
//            RecommendationsResultsView

class this._cls0
    implements com.amazon.mShop.error.ActionListener
{

    final RecommendationsResultsView this$0;

    public void onActionButtonClick(int i)
    {
        RecommendationsResultsView.access$000(RecommendationsResultsView.this).setVisibility(0);
        RecommendationsResultsView.access$100(RecommendationsResultsView.this).setText(com.amazon.mShop.android.lib.w);
        RecommendationsResultsView.access$100(RecommendationsResultsView.this).setVisibility(0);
        mBrowser.replayPageRequest();
    }

    r()
    {
        this$0 = RecommendationsResultsView.this;
        super();
    }
}
