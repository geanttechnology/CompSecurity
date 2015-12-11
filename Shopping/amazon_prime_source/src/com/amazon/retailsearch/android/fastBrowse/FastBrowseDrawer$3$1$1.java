// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fastBrowse;

import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.searchapp.retailsearch.model.Department;
import com.amazon.searchapp.retailsearch.model.RefinementLink;
import com.amazon.searchapp.retailsearch.model.Refinements;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.fastBrowse:
//            FastBrowseDrawer, FastBrowseItem, RefinementsLoader

class val.result
    implements Runnable
{

    final l this$2;
    final SearchResult val$result;

    public void run()
    {
        RefinementLink refinementlink;
        for (Iterator iterator = val$result.getRefinements().getDepartments().getCategories().iterator(); iterator.hasNext(); FastBrowseDrawer.access$000(_fld0).add(new FastBrowseItem(refinementlink.getText(), refinementlink.getUrl(), refinementlink.getBrowseUrl())))
        {
            refinementlink = (RefinementLink)iterator.next();
        }

    }

    ._cls0()
    {
        this$2 = final__pcls0;
        val$result = SearchResult.this;
        super();
    }

    // Unreferenced inner class com/amazon/retailsearch/android/fastBrowse/FastBrowseDrawer$3

/* anonymous class */
    class FastBrowseDrawer._cls3
        implements Runnable
    {

        final FastBrowseDrawer this$0;

        public void run()
        {
            (new RefinementsLoader(new FastBrowseDrawer._cls3._cls1(), null)).getRefinements();
        }

            
            {
                this$0 = FastBrowseDrawer.this;
                super();
            }
    }


    // Unreferenced inner class com/amazon/retailsearch/android/fastBrowse/FastBrowseDrawer$3$1

/* anonymous class */
    class FastBrowseDrawer._cls3._cls1
        implements RefinementsLoader.RefinementResultListener
    {

        final FastBrowseDrawer._cls3 this$1;

        public void onError(Exception exception)
        {
            FastBrowseDrawer.access$900().error("Failed to fetch refinements", exception);
        }

        public void onResult(SearchResult searchresult)
        {
            FastBrowseDrawer.access$1002(this$0, searchresult);
            platform.invokeLater(searchresult. new FastBrowseDrawer._cls3._cls1._cls1());
            FastBrowseDrawer.access$1100(this$0);
        }

            
            {
                this$1 = FastBrowseDrawer._cls3.this;
                super();
            }
    }

}
