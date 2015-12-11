// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fastBrowse;

import com.amazon.searchapp.retailsearch.model.SearchResult;

// Referenced classes of package com.amazon.retailsearch.android.fastBrowse:
//            FastBrowseBaseView, RefinementsLoader

class this._cls0
    implements Runnable
{

    final FastBrowseBaseView this$0;

    public void run()
    {
        (new RefinementsLoader(new RefinementsLoader.RefinementResultListener() {

            final FastBrowseBaseView._cls3 this$1;

            public void onError(Exception exception)
            {
            }

            public void onResult(SearchResult searchresult)
            {
                FastBrowseBaseView.access$302(this$0, searchresult);
                onRefresh();
            }

            
            {
                this$1 = FastBrowseBaseView._cls3.this;
                super();
            }
        }, null)).getRefinements();
    }

    _cls1.this._cls1()
    {
        this$0 = FastBrowseBaseView.this;
        super();
    }
}
