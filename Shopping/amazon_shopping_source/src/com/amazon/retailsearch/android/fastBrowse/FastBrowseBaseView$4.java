// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fastBrowse;

import android.content.res.TypedArray;
import com.amazon.searchapp.retailsearch.model.Department;
import com.amazon.searchapp.retailsearch.model.RefinementLink;
import com.amazon.searchapp.retailsearch.model.Refinements;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.fastBrowse:
//            FastBrowseBaseView, RefinementsLoader, FastBrowseItem, FastBrowseListAdapter

class this._cls0
    implements Runnable
{

    final FastBrowseBaseView this$0;

    public void run()
    {
        (new RefinementsLoader(new RefinementsLoader.RefinementResultListener() {

            final FastBrowseBaseView._cls4 this$1;

            public void onError(Exception exception)
            {
            }

            public void onResult(SearchResult searchresult)
            {
                FastBrowseBaseView.access$302(this$0, searchresult);
                searchresult = FastBrowseBaseView.access$300(this$0).getRefinements().getDepartments().getCategories();
                Object obj = FastBrowseBaseView.access$300(this$0).getRefinements().getDepartments().getAncestry();
                FastBrowseBaseView.access$400(this$0).clear();
                FastBrowseBaseView.access$400(this$0).add(new FastBrowseItem(FastBrowseBaseView.access$500(this$0), "/s/browse/categories", "/s/browse/categories", FastBrowseBaseView.access$600(this$0).getResourceId(0, -1)));
                if (obj != null)
                {
                    RefinementLink refinementlink1;
                    for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); FastBrowseBaseView.access$400(this$0).add(new FastBrowseItem(refinementlink1.getText(), refinementlink1.getUrl(), refinementlink1.getBrowseUrl(), FastBrowseBaseView.access$600(this$0).getResourceId(0, -1))))
                    {
                        refinementlink1 = (RefinementLink)((Iterator) (obj)).next();
                    }

                }
                FastBrowseBaseView.access$700(this$0).setCurrentLayer(FastBrowseBaseView.access$400(this$0).size() - 1);
                if (FastBrowseBaseView.access$700(this$0).getCurrentLayer() == 0)
                {
                    ((FastBrowseItem)FastBrowseBaseView.access$400(this$0).get(0)).setTitle(FastBrowseBaseView.access$800(this$0));
                }
                if (searchresult != null)
                {
                    RefinementLink refinementlink;
                    for (searchresult = searchresult.iterator(); searchresult.hasNext(); FastBrowseBaseView.access$400(this$0).add(new FastBrowseItem(refinementlink.getText(), refinementlink.getUrl(), refinementlink.getBrowseUrl(), FastBrowseBaseView.access$600(this$0).getResourceId(0, -1))))
                    {
                        refinementlink = (RefinementLink)searchresult.next();
                    }

                }
                FastBrowseBaseView.access$600(this$0).recycle();
                onRefreshAfterInit();
            }

            
            {
                this$1 = FastBrowseBaseView._cls4.this;
                super();
            }
        }, FastBrowseBaseView.access$900(FastBrowseBaseView.this))).getRefinements();
    }

    _cls1.this._cls1()
    {
        this$0 = FastBrowseBaseView.this;
        super();
    }
}
