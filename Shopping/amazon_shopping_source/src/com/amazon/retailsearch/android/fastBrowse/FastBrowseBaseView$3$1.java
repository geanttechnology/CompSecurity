// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fastBrowse;

import com.amazon.searchapp.retailsearch.model.SearchResult;

// Referenced classes of package com.amazon.retailsearch.android.fastBrowse:
//            FastBrowseBaseView, RefinementsLoader

class this._cls1
    implements ementResultListener
{

    final fresh this$1;

    public void onError(Exception exception)
    {
    }

    public void onResult(SearchResult searchresult)
    {
        FastBrowseBaseView.access$302(_fld0, searchresult);
        onRefresh();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$3

/* anonymous class */
    class FastBrowseBaseView._cls3
        implements Runnable
    {

        final FastBrowseBaseView this$0;

        public void run()
        {
            (new RefinementsLoader(new FastBrowseBaseView._cls3._cls1(), null)).getRefinements();
        }

            
            {
                this$0 = FastBrowseBaseView.this;
                super();
            }
    }

}
