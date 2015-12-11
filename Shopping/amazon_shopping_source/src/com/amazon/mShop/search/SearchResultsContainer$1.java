// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search;

import android.view.View;
import com.amazon.mShop.voice.MShopVoicePackageProxy;

// Referenced classes of package com.amazon.mShop.search:
//            SearchResultsContainer

class this._cls0
    implements android.view.ontainer._cls1
{

    final SearchResultsContainer this$0;

    public void onClick(View view)
    {
        if (SearchResultsContainer.access$000(SearchResultsContainer.this) != null)
        {
            MShopVoicePackageProxy.getInstance().openVoiceSearch(SearchResultsContainer.access$000(SearchResultsContainer.this), false);
        }
    }

    ()
    {
        this$0 = SearchResultsContainer.this;
        super();
    }
}
