// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.fastBrowse;

import com.amazon.mShop.categoryBrowse.CategoryMetadata;
import com.amazon.retailsearch.android.categoryBrowse.CategoryBrowseController;
import com.amazon.retailsearch.android.fastBrowse.RefinementsLoader;
import com.amazon.searchapp.retailsearch.model.RefinementLink;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import com.amazon.searchapp.retailsearch.model.TrackingInfo;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.mShop.fastBrowse:
//            FastBrowseActivity

class this._cls1
    implements com.amazon.retailsearch.android.fastBrowse.ementResultListener
{

    final o.getSearchAlias this$1;

    public void onError(Exception exception)
    {
    }

    public void onResult(SearchResult searchresult)
    {
        if (searchresult != null && searchresult.getTrackingInfo() != null && searchresult.getRefinements() != null)
        {
            RefinementLink refinementlink = CategoryBrowseController.getCurrentRefinement(searchresult.getRefinements());
            if (refinementlink != null)
            {
                FastBrowseActivity.access$400(_fld0).put(url, new CategoryMetadata(refinementlink.getText(), refinementlink.getUrl(), searchresult.getTrackingInfo().getSearchAlias()));
            }
        }
    }

    l.url()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/fastBrowse/FastBrowseActivity$3

/* anonymous class */
    class FastBrowseActivity._cls3
        implements Runnable
    {

        final FastBrowseActivity this$0;
        final String val$url;

        public void run()
        {
            (new RefinementsLoader(new FastBrowseActivity._cls3._cls1(), url)).getRefinements();
        }

            
            {
                this$0 = final_fastbrowseactivity;
                url = String.this;
                super();
            }
    }

}
