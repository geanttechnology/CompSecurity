// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.categoryBrowse;

import com.amazon.retailsearch.android.categoryBrowse.CategoryBrowseController;
import com.amazon.retailsearch.android.fastBrowse.RefinementsLoader;
import com.amazon.searchapp.retailsearch.model.RefinementLink;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import com.amazon.searchapp.retailsearch.model.TrackingInfo;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.mShop.categoryBrowse:
//            CategoryBrowseActivity, CategoryMetadata

class this._cls1
    implements com.amazon.retailsearch.android.fastBrowse.tResultListener
{

    final rchAlias this$1;

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
                CategoryBrowseActivity.access$000(_fld0).put(url, new CategoryMetadata(refinementlink.getText(), refinementlink.getUrl(), searchresult.getTrackingInfo().getSearchAlias()));
            }
        }
    }

    l.url()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/categoryBrowse/CategoryBrowseActivity$1

/* anonymous class */
    class CategoryBrowseActivity._cls1
        implements Runnable
    {

        final CategoryBrowseActivity this$0;
        final String val$url;

        public void run()
        {
            (new RefinementsLoader(new CategoryBrowseActivity._cls1._cls1(), url)).getRefinements();
        }

            
            {
                this$0 = final_categorybrowseactivity;
                url = String.this;
                super();
            }
    }

}
