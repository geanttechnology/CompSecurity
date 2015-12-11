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

class val.url
    implements Runnable
{

    final CategoryBrowseActivity this$0;
    final String val$url;

    public void run()
    {
        (new RefinementsLoader(new com.amazon.retailsearch.android.fastBrowse.RefinementsLoader.RefinementResultListener() {

            final CategoryBrowseActivity._cls1 this$1;

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
                        CategoryBrowseActivity.access$000(this$0).put(url, new CategoryMetadata(refinementlink.getText(), refinementlink.getUrl(), searchresult.getTrackingInfo().getSearchAlias()));
                    }
                }
            }

            
            {
                this$1 = CategoryBrowseActivity._cls1.this;
                super();
            }
        }, val$url)).getRefinements();
    }

    _cls1.this._cls1()
    {
        this$0 = final_categorybrowseactivity;
        val$url = String.this;
        super();
    }
}
